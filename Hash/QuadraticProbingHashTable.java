package Hash;

public class QuadraticProbingHashTable<AnyType> {

    private static final int DEFAULT_TABLE_SIZE = 11;
    private HashEntry<AnyType> [] array;
    private int currentSize;
     
    public QuadraticProbingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int size){
        allocatedArray(size);
        makeEmpty();
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public void makeEmpty(){
        for(int i = 0; i < array.length; i++){
            array[i] = null;
        }
    }

    private static class HashEntry<AnyType>{
        public AnyType element;
        public boolean isActive;

        public HashEntry(AnyType e){
            this(e, true);
        }


        public HashEntry(AnyType e, boolean i){
            element = e;
            isActive = i;
        }
    }

    public boolean isActive(int currentPos){
        return array[currentPos] != null
        && array[currentPos].isActive;
    }

    public AnyType find(AnyType x){
        int currentPos = findPos(x);

        return isActive(currentPos) ? array[currentPos].element : null;
    }

    private int findPos(AnyType x){
        int offset = 1;
        int currentPos = myHash(x);

        while(array[currentPos] != null && !array[currentPos].element.equals(x)){
            currentPos += offset;
            offset += 2;
        
            if(currentPos >= array.length){
                currentPos -= array.length;
            }
        }

        return currentPos;
    }

    public void insert(AnyType x){
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

        HashEntry<AnyType> [] oldArray = array;

        allocatedArray(oldArray.length * 2);

        for(int i = 0; i < oldArray.length; i++){
            if(oldArray[i] != null && oldArray[i].isActive){
                insert(oldArray[i].element);
            }
        }
    }

    private boolean contains(AnyType x){
        int currentPos = findPos(x);
        return isActive(currentPos);
    }

    private void remove(AnyType x){
        int currentPos = findPos(x);
        if(isActive(currentPos)){
            array[currentPos].isActive = false;
        }
    }
    
    private void allocatedArray(int arraySize){
        array = new HashEntry[nextPrime(arraySize)];
    }

    public int myHash(AnyType x){
        int hashVal = x.hashCode();

        hashVal %= array.length;

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

    
    public static void main(String[] args) {
        

        QuadraticProbingHashTable<Integer> qp = new QuadraticProbingHashTable<Integer>();


        for(int i = 0; i < 100; i++){
            int rand = (int)(Math.random() * 100);
            qp.insert(rand);
        }

        for(int i = 0; i < qp.array.length; i++){
            if(qp.array[i] == null){
                System.out.print("null ");
                continue;
            }

            System.out.print(qp.array[i].element + " ");
        }

    }
}
