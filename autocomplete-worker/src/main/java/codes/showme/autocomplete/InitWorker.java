package codes.showme.autocomplete;

import codes.showme.autocomplete.common.Configuration;
import codes.showme.autocomplete.common.Pair;
import codes.showme.autocomplete.common.PropertiesConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by jack on 12/28/16.
 */
public class InitWorker {

    public final static Configuration configuration = new PropertiesConfig();

    public static void main(String[] args) throws IOException {

        if (args.length < 1) {
            throw new IllegalArgumentException("arg: p is required. arg p is the path of province.txt");
        }

        String pathname = args[0];
        File file = new File(pathname);
        if (!file.exists()) {
            throw new IllegalArgumentException(pathname + " is not found");
        }

        JedisPool jedisPool = createJedisPool();

        if (args.length > 1) {
            String flushallArg = args[1];
            if (flushallArg.equals("flushall")) {
                Jedis jedis = jedisPool.getResource();
                jedis.select(0);
                jedis.flushAll();
            }
        }
        InitWorker initWorker = new InitWorker();

        initWorker.iterateLines(file, 2, places -> {
            Jedis jedis = jedisPool.getResource();
            jedis.select(0);
            Transaction multi = jedis.multi();
            try {
                List<Pair<String, String>> pairList = initWorker.convertLineToRedisRecord(places);
                for (Pair<String, String> pair : pairList) {
                    multi.zincrby(pair.getLeft(), 0.0, pair.getRight());
                }
                multi.exec();

            } catch (Exception e) {
                System.err.println(e.getMessage());
            } finally {
                try {
                    multi.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
                jedis.close();
            }
        });
    }

    public void iterateLines(File file, int count, Consumer<List<String>> consumer) throws IOException {
        InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
        BufferedReader reader = new BufferedReader(inputReader);
        List<String> list = new ArrayList<String>();
        String line = reader.readLine();
        while (line != null) {
            list.add(line);
            if (list.size() >= count) {
                consumer.accept(list);
                list.clear();
            }
            line = reader.readLine();
        }
        if (!list.isEmpty()) {
            consumer.accept(list);
            list = null;
        }

        closeQuietly(reader);
        closeQuietly(inputReader);
    }


    public List<Pair<String, String>> convertLineToRedisRecord(List<String> lines) {
        List<Pair<String, String>> result = new ArrayList<>();

        lines.stream().filter(Objects::nonNull)
                .map(line -> Arrays.asList(line.split("\\s")))
                .filter(strings -> strings.size() > 1)
                .filter(strings -> !strings.get(0).trim().equals(""))
                .forEach((List<String> strList) -> {
                    String chinesePlaceName = strList.get(0);
                    List<String> pinyin = strList.subList(1, strList.size());
                    String pinyinTogether = getPinyinTogether(pinyin);

                    result.add(new Pair<>(getEachFirstAlpha(pinyin), chinesePlaceName));

                    List<Pair<String, String>> pairs = getSequences(pinyinTogether)
                            .stream()
                            .map(s -> new Pair<>(s, chinesePlaceName))
                            .collect(Collectors.toList());
                    result.addAll(pairs);

                    List<Pair<String, String>> chinesePairs = getChineseSequences(chinesePlaceName)
                            .stream()
                            .map(s -> new Pair<>(s, chinesePlaceName))
                            .collect(Collectors.toList());
                    result.addAll(chinesePairs);

                });
        return result;
    }

    /**
     * shi shen me -> ssm
     *
     * @param pinyins
     * @return
     */
    private String getEachFirstAlpha(List<String> pinyins) {
        return pinyins.stream().map(a -> a.charAt(0) + "").reduce("", (a, b) -> a + b);
    }

    /**
     * shishenme - {
     * s
     * sh
     * shi
     * shis
     * shish
     * shishe
     * ....
     * }
     *
     * @param pinyinTogether
     * @return
     */
    private List<String> getSequences(String pinyinTogether) {
        List<String> result = new ArrayList<>();
        char[] pinyinChars = pinyinTogether.toCharArray();
        for (int index = 0; index < pinyinChars.length; index++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int innerIndex = 0; innerIndex <= index; innerIndex++) {
                stringBuilder.append(pinyinChars[innerIndex]);
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }

    /**
     *辽宁省大连市 -> {
     *     辽
     *     辽宁
     *     辽宁省
     *     辽宁省大
     *     辽宁省大连
     *     辽宁省大连市
     *}
     * @param chinesePlaceName
     * @return
     */
    private List<String> getChineseSequences(String chinesePlaceName) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < chinesePlaceName.length(); i++) {
            result.add(chinesePlaceName.substring(0, i+1));
        }
        return result;
    }

    /**
     * shi shen me -> shishenme
     *
     * @param pinyins
     * @return
     */
    private String getPinyinTogether(List<String> pinyins) {
        return pinyins.stream().reduce("", (a, b) -> a + b);
    }

    private static JedisPool createJedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        String ip = configuration.getRedisIP();
        int port = configuration.getRedisPort();
        int timeout = 2000;
        jedisPoolConfig.setMaxTotal(1024);
        jedisPoolConfig.setMaxIdle(100);
        jedisPoolConfig.setMaxWaitMillis(100);
        jedisPoolConfig.setTestOnBorrow(false);
        jedisPoolConfig.setTestOnReturn(true);
        // 初始化JedisPool
        return new JedisPool(jedisPoolConfig, ip, port, timeout);
    }


    private void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }

}
