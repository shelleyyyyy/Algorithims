package Hash;

public class Hashing {
    public static int hash(String key, int tableSize){
        int hashVal = 0;

        for(int i = 0; i < key.length(); i++){
            hashVal += key.charAt(i);

        }

        return hashVal % tableSize;
    }

    public static int hash1(String key, int tableSize){
        int hashVal = 0;

        for(int i = 0; i < key.length(); i++){
            hashVal = 37 * hashVal * key.charAt(i);
        }

        hashVal %= tableSize;

        if(hashVal < 0){
            hashVal += tableSize;
        }

        return hashVal;
    }

    public static int myHash(String key, int tableSize){
        int hashVal = key.hashCode();

        hashVal %= tableSize;

        if(hashVal < 0){
            hashVal += tableSize;
        }

        return hashVal;
    }

    public static void print(String [] arr){
        System.out.print("{");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        
        String [] hashTable = new String[11];

        String [] keys = {"Riley", "Ian", "Connor", "Tanner", "Cole", "Nick", "aIn"};

        for(int i = 0; i < keys.length; i++){
            hashTable[hash(keys[i], hashTable.length)] = keys[i];
            

        }

        System.out.println("*********************************");

        System.out.println("Original Keys");
        print(keys);

        System.out.println();

        System.out.println("Hash Table");
        print(hashTable);

        System.out.println(hashTable.hashCode());
    }
}
