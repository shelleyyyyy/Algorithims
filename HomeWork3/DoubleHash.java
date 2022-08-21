package HomeWork3;

public class DoubleHash<AnyType> {

    private static final int DEFAULT_TABLE_SIZE = 11;
    private HashEntry<AnyType> [] array;
    private int currentSize;
    private int collisionCount;

    public DoubleHash(){
        this(DEFAULT_TABLE_SIZE);
    }

    public DoubleHash(int size){
        allocatedArray(size);
        makeEmpty();
    }

    public void makeEmpty(){
        for(int i = 0; i < array.length; i++){
            array[i] = null;
        }
    }

    private static class HashEntry<AnyType>{
        public int element;
        public boolean isActive;

        public HashEntry(int e){
            this(e, true);
        }

        public HashEntry(int e, boolean i){
            element = e;
            isActive = i;
        }
    }

    public boolean isActive(int currentPos){
        return array[currentPos] != null
        && array[currentPos].isActive;
    }

    private int findPos(int x){
        int currentPos = myHash(x);

        if(array[currentPos] != null){
            collisionCount++;
        }

        if(array[currentPos] != null){
            currentPos = myHash2(x);
        }

        currentPos = myHash2(x);

        int i = 1;
        while(array[currentPos] != null){
            currentPos = currentPos * i;

            i++;

            if(currentPos >= array.length){
                currentPos = currentPos % array.length;
            }
        }

        return currentPos;
    }

    public void insert(int x){
        int currentPos = findPos(x);

        if(isActive(currentPos)){
            return;
        }

        array[currentPos] = new HashEntry<>(x);

        if(++currentSize > array.length / 2){
            reHash();
        }
    }

    public void reHash(){

        currentSize = 0;
        HashEntry<AnyType> [] oldArray = array;

        allocatedArray(oldArray.length * 2);

        collisionCount = 0;
        for(int i = 0; i < oldArray.length; i++){
            if(oldArray[i] != null && oldArray[i].isActive){
                insert(oldArray[i].element);
            }
        }
    }
    
    private void allocatedArray(int arraySize){
        array = new HashEntry[nextPrime(arraySize)];
    }

    public int myHash(int x){
        int hashVal = x % array.length;

        if(hashVal < 0){
            hashVal += array.length;
        }

        return hashVal;
    }

    public int myHash2(int x){

        int hashVal = 7 - (x % 7);

        if(hashVal < 0){
            hashVal += array.length;
        }

        return hashVal;
    }
    
    private boolean isPrime(int n){
        if(n == 2 || n == 3){
            return true;
        }

        if(n == 1 || n % 2 == 0){
            return false;
        }

        for(int i = 3; i * i <= n; i += 2){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    private int nextPrime(int n){
        if(n % 2 == 0){
            n++;
        }

        for(; !isPrime(n); n += 2);

        return n;
    }

    public void print(){
        for(int i = 0; i < array.length; i++){
            if(array[i] == null){
                System.out.print("null, ");
                continue;
            }

            System.out.print(array[i].element + ", ");
        }
    }

    
    public static void main(String[] args) {
        
        DoubleHash<Integer> dh = new DoubleHash<Integer>();

        for(int i = 0; i < 50; i++){
            int rand = (int)(Math.random() * 100);
            dh.insert(rand);
        }

        System.out.println("Final");
        System.out.println("***************");
        dh.print();

        System.out.println("");
        System.out.println("****************");
        System.out.println("Collision Count");
        System.out.println(dh.collisionCount);

    }
}
