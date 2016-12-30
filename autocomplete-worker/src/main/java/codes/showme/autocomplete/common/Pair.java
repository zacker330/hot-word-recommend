package codes.showme.autocomplete.common;

/**
 * Created by jack on 12/30/16.
 */
public class Pair<L,R> {
    private final L left;
    private final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() { return left; }
    public R getRight() { return right; }

    @Override
    public int hashCode() { return left.hashCode() ^ right.hashCode(); }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair anotherPair = (Pair) o;
        return this.left.equals(anotherPair.getLeft()) &&
                this.right.equals(anotherPair.getRight());
    }
}
