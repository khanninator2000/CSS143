public class Pair<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<Pair<K,V>>, Cloneable {
    private K key;
    private V value;
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    @Override
    public int compareTo(Pair<K, V> o) {
        return this.key.compareTo(o.key) + this.value.compareTo(o.value);
    }
    
    @Override
    public Pair<K, V> clone() {
        try {
            return (Pair<K, V>) super.clone();
        } catch (CloneNotSupportedException x) {
            throw new InternalError();
        }
    }
}
