package codes.showme.autocomple;

import codes.showme.autocomplete.InitWorker;
import codes.showme.autocomplete.common.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jack on 12/30/16.
 */
public class MainTest {

    @Test
    public void testName() throws Exception {
        InitWorker initWorker = new InitWorker();
        List<Pair<String, String>> pairList = initWorker.convertLineToRedisRecord(Arrays.asList(
                "阿坝 a ba",
                "东城 dong cheng",
                "辽宁省大连市经济技术开发区辽河西路号 liao ning sheng da lian shi jing ji ji shu kai fa qu liao he xi lu hao"
        ));

        Assert.assertEquals("ab", pairList.get(0).getLeft());
        Assert.assertEquals("阿坝", pairList.get(0).getRight());
        Assert.assertEquals("a", pairList.get(1).getLeft());
        Assert.assertEquals("阿坝", pairList.get(1).getRight());
        Assert.assertEquals("ab", pairList.get(2).getLeft());
        Assert.assertEquals("阿坝", pairList.get(2).getRight());
        Assert.assertEquals("aba", pairList.get(3).getLeft());
        Assert.assertEquals("阿坝", pairList.get(3).getRight());
        Assert.assertEquals("阿", pairList.get(4).getLeft());
        Assert.assertEquals("阿坝", pairList.get(4).getRight());
        Assert.assertEquals("阿坝", pairList.get(5).getLeft());
        Assert.assertEquals("阿坝", pairList.get(5).getRight());
        Assert.assertEquals("dc", pairList.get(6).getLeft());
        Assert.assertEquals("东城", pairList.get(6).getRight());
        Assert.assertEquals("d", pairList.get(7).getLeft());
        Assert.assertEquals("东城", pairList.get(7).getRight());
        Assert.assertEquals("do", pairList.get(8).getLeft());
        Assert.assertEquals("东城", pairList.get(8).getRight());
        Assert.assertEquals("don", pairList.get(9).getLeft());
        Assert.assertEquals("东城", pairList.get(9).getRight());
        Assert.assertEquals("dong", pairList.get(10).getLeft());
        Assert.assertEquals("东城", pairList.get(10).getRight());
        Assert.assertEquals("dongc", pairList.get(11).getLeft());
        Assert.assertEquals("东城", pairList.get(11).getRight());
        Assert.assertEquals("dongch", pairList.get(12).getLeft());
        Assert.assertEquals("东城", pairList.get(12).getRight());
        Assert.assertEquals("dongche", pairList.get(13).getLeft());
        Assert.assertEquals("东城", pairList.get(13).getRight());
        Assert.assertEquals("dongchen", pairList.get(14).getLeft());
        Assert.assertEquals("东城", pairList.get(14).getRight());
        Assert.assertEquals("dongcheng", pairList.get(15).getLeft());
        Assert.assertEquals("东城", pairList.get(15).getRight());
        Assert.assertEquals("东", pairList.get(16).getLeft());
        Assert.assertEquals("东城", pairList.get(16).getRight());
        Assert.assertEquals("东城", pairList.get(17).getLeft());
        Assert.assertEquals("东城", pairList.get(17).getRight());
        Assert.assertEquals("lnsdlsjjjskfqlhxlh", pairList.get(18).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(18).getRight());
        Assert.assertEquals("l", pairList.get(19).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(19).getRight());
        Assert.assertEquals("li", pairList.get(20).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(20).getRight());
        Assert.assertEquals("lia", pairList.get(21).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(21).getRight());
        Assert.assertEquals("liao", pairList.get(22).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(22).getRight());
        Assert.assertEquals("liaon", pairList.get(23).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(23).getRight());
        Assert.assertEquals("liaoni", pairList.get(24).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(24).getRight());
        Assert.assertEquals("liaonin", pairList.get(25).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(25).getRight());
        Assert.assertEquals("liaoning", pairList.get(26).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(26).getRight());
        Assert.assertEquals("liaonings", pairList.get(27).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(27).getRight());
        Assert.assertEquals("liaoningsh", pairList.get(28).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(28).getRight());
        Assert.assertEquals("liaoningshe", pairList.get(29).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(29).getRight());
        Assert.assertEquals("liaoningshen", pairList.get(30).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(30).getRight());
        Assert.assertEquals("liaoningsheng", pairList.get(31).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(31).getRight());
        Assert.assertEquals("liaoningshengd", pairList.get(32).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(32).getRight());
        Assert.assertEquals("liaoningshengda", pairList.get(33).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(33).getRight());
        Assert.assertEquals("liaoningshengdal", pairList.get(34).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(34).getRight());
        Assert.assertEquals("liaoningshengdali", pairList.get(35).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(35).getRight());
        Assert.assertEquals("liaoningshengdalia", pairList.get(36).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(36).getRight());
        Assert.assertEquals("liaoningshengdalian", pairList.get(37).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(37).getRight());
        Assert.assertEquals("liaoningshengdalians", pairList.get(38).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(38).getRight());
        Assert.assertEquals("liaoningshengdaliansh", pairList.get(39).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(39).getRight());
        Assert.assertEquals("liaoningshengdalianshi", pairList.get(40).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(40).getRight());
        Assert.assertEquals("liaoningshengdalianshij", pairList.get(41).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(41).getRight());
        Assert.assertEquals("liaoningshengdalianshiji", pairList.get(42).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(42).getRight());
        Assert.assertEquals("liaoningshengdalianshijin", pairList.get(43).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(43).getRight());
        Assert.assertEquals("liaoningshengdalianshijing", pairList.get(44).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(44).getRight());
        Assert.assertEquals("liaoningshengdalianshijingj", pairList.get(45).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(45).getRight());
        Assert.assertEquals("liaoningshengdalianshijingji", pairList.get(46).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(46).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjij", pairList.get(47).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(47).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjiji", pairList.get(48).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(48).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijis", pairList.get(49).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(49).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijish", pairList.get(50).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(50).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishu", pairList.get(51).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(51).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishuk", pairList.get(52).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(52).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishuka", pairList.get(53).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(53).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishukai", pairList.get(54).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(54).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishukaif", pairList.get(55).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(55).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishukaifa", pairList.get(56).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(56).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishukaifaq", pairList.get(57).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(57).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishukaifaqu", pairList.get(58).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(58).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishukaifaqul", pairList.get(59).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(59).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishukaifaquli", pairList.get(60).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(60).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishukaifaqulia", pairList.get(61).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(61).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishukaifaquliao", pairList.get(62).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(62).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishukaifaquliaoh", pairList.get(63).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(63).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishukaifaquliaohe", pairList.get(64).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(64).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishukaifaquliaohex", pairList.get(65).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(65).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishukaifaquliaohexi", pairList.get(66).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(66).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishukaifaquliaohexil", pairList.get(67).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(67).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishukaifaquliaohexilu", pairList.get(68).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(68).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishukaifaquliaohexiluh", pairList.get(69).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(69).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishukaifaquliaohexiluha", pairList.get(70).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(70).getRight());
        Assert.assertEquals("liaoningshengdalianshijingjijishukaifaquliaohexiluhao", pairList.get(71).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(71).getRight());
        Assert.assertEquals("辽", pairList.get(72).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(72).getRight());
        Assert.assertEquals("辽宁", pairList.get(73).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(73).getRight());
        Assert.assertEquals("辽宁省", pairList.get(74).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(74).getRight());
        Assert.assertEquals("辽宁省大", pairList.get(75).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(75).getRight());
        Assert.assertEquals("辽宁省大连", pairList.get(76).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(76).getRight());
        Assert.assertEquals("辽宁省大连市", pairList.get(77).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(77).getRight());
        Assert.assertEquals("辽宁省大连市经", pairList.get(78).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(78).getRight());
        Assert.assertEquals("辽宁省大连市经济", pairList.get(79).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(79).getRight());
        Assert.assertEquals("辽宁省大连市经济技", pairList.get(80).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(80).getRight());
        Assert.assertEquals("辽宁省大连市经济技术", pairList.get(81).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(81).getRight());
        Assert.assertEquals("辽宁省大连市经济技术开", pairList.get(82).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(82).getRight());
        Assert.assertEquals("辽宁省大连市经济技术开发", pairList.get(83).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(83).getRight());
        Assert.assertEquals("辽宁省大连市经济技术开发区", pairList.get(84).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(84).getRight());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽", pairList.get(85).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(85).getRight());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河", pairList.get(86).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(86).getRight());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西", pairList.get(87).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(87).getRight());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路", pairList.get(88).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(88).getRight());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(89).getLeft());
        Assert.assertEquals("辽宁省大连市经济技术开发区辽河西路号", pairList.get(89).getRight());

        // 用于生成测试语句
        for (int i = 0; i < pairList.size(); i++) {

            System.out.println("Assert.assertEquals(\""+ pairList.get(i).getLeft() +"\", pairList.get("+ i +").getLeft());");
            System.out.println("Assert.assertEquals(\""+ pairList.get(i).getRight() +"\", pairList.get("+ i +").getRight());");
        }

//
//        for (Pair<String, String> stringStringPair : pairList) {
//            System.out.println(stringStringPair.getLeft() + " " + stringStringPair.getRight());
//        }
    }


}
