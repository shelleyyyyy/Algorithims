package HomeWork3;

public class QuadraticProbing<AnyType> {

    private static final int DEFAULT_TABLE_SIZE = 11;
    private HashEntry<AnyType> [] array;
    private int currentSize;
    private int collisionCount;
     
    public QuadraticProbing(){
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbing(int size){
        allocatedArray(size);
        makeEmpty();
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

    private int findPos(AnyType x){
        int offset = 1;
        int currentPos = myHash(x);

        if(array[currentPos] != null){
            collisionCount++;
        }

        while(array[currentPos] != null){
            currentPos += offset;
            offset +=2;
        
            if(currentPos >= array.length){
                currentPos -=array.length;
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

    public void print(){
        for(int i = 0; i < array.length; i++){
            if(array[i] == null){
                System.out.print("null ");
                continue;
            }

            System.out.print(array[i].element + " ");
        }
    }

    // 
    public static void main(String[] args) {
        
        QuadraticProbing<Integer> qp = new QuadraticProbing<Integer>();

        for(int i = 0; i < 50; i++){
            int rand = (int)(Math.random() * 100);
            qp.insert(rand);
        }

        System.out.println("Final");
        System.out.println("***************");
        qp.print();

        System.out.println("");
        System.out.println("****************");
        System.out.println("Collision Count");
        System.out.println(qp.collisionCount);

    }
}
