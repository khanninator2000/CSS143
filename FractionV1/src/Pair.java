// Krish Kalai
// CSS 143 B
// FractionsV1

/**
 * Class with a key-value pair
 *
 * @param <K> The type for the key.
 * @param <V> The type for the value.
 */
public class Pair<K, V> {
    private K first;
    private V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public boolean key_equals(K value) {
        return first.equals(value);
    }

    public K getFirst() {
        return first;
    }

    public void setFirst(K first) {
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }
}
