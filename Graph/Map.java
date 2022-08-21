// package Graph;

// public class Map <KeyType, ValueType> {
                
//     QuadraticProbingHashTable<Entry<KeyType, ValueType>> items;
    
//     public Map() {
//         items = new QuadraticProbingHashTable<>();
//     }
    
//     public void put(KeyType key, ValueType val) {
//         Entry<KeyType, ValueType> e = new Entry<>(key, val);
//         items.insert(e);
//     }
    
//     public ValueType get(KeyType key) {
//         ValueType val = (ValueType)new Object();
//         Entry<KeyType, ValueType> e = new Entry<>(key, val);
//         e = items.find(e);
//         return e.val;
//     }
    
//     public boolean isEmpty() {
//         return items.isEmpty();
//     }
    
//     public void makeEmpty() {
//         items.makeEmpty();
//     }

//     private static class Entry<KeyType, ValueType> {
//         private KeyType key;
//         private ValueType val;
        
//         Entry(KeyType k, ValueType v) {
//             key = k;
//             val = v;
//         }
        
        
//         public boolean equals(Object rhs) {
                        
//             Entry<KeyType, ValueType>  rhs1 = (Entry<KeyType, ValueType>) rhs;
//             return rhs1 instanceof Entry && key.equals(rhs1.key);
//         }
//         public int hashCode() {
//             return key.hashCode();
//         }
//     }
    
//     public static void main(String args[]) {
//         Map x = new Map<>();
//         System.out.println("Is the new map empty? " + x.isEmpty());
        
        
//         for (int i = 0; i < 10; i++) {
//             x.put(i, i+1);
//         }
//         System.out.println("Filled map");
//         for (int i = 0; i < 10; i++) {
//             System.out.print(x.get(i) + " ");
//         }
//         System.out.println();
//         System.out.println("Is the new map STILL empty? " + x.isEmpty());
        
//         System.out.println("Making map empty...");
//         x.makeEmpty();
//         System.out.println("The map has now been nulled out");
//         System.out.println("Is the map now empty? " + x.isEmpty());
//     }

// }