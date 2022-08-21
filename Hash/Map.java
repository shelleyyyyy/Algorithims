package Hash;

public class Map <KeyType, ValueType>{

    private QuadraticProbingHashTable<Entry<KeyType, ValueType>> items;

    public Map(){
        items = new QuadraticProbingHashTable<>();
    }

    public void put(KeyType key, ValueType val){
        Entry<KeyType, ValueType> e = new Entry<>(key, val);
        items.insert(e);
    }

    public ValueType get(KeyType key){

        ValueType val = (ValueType) new Object();
        Entry<KeyType, ValueType> e = new Entry<>(key, val);

        e = items.find(e);
        return e.val;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public void makeEmpty(){
        items.makeEmpty();
    }

    private static class Entry<KeyType, ValueType>{
        private KeyType key;
        private ValueType val;

        Entry(KeyType k, ValueType v){
            key = k;
            val = v;
        }

        public int hashCode() {
            return key.hashCode();
        }

        public boolean equals(Object rhs) {
            Entry<KeyType, ValueType> rhs1 = (Entry<KeyType, ValueType>) rhs;

            return rhs1 instanceof Entry && key.equals(rhs1.key);
        }
    }
}
