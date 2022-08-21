package Heap;

public class BinaryHeap<AnyType extends Comparable<AnyType>>{
    
    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private AnyType [] array;

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = (AnyType []) new Comparable[capacity + 1];
    }

    public BinaryHeap(AnyType[] items) {

        currentSize = items.length;
        array = (AnyType []) new Comparable[currentSize + 1];

        int i = 1;

        for(AnyType item : items) {
            array[i++] = item;
        }

        buildHeap();

    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        currentSize = 0;
    }

    public void insert(AnyType x) {

        // check if its full
        if(currentSize == array.length - 1) {
            enlargeArray(array.length * 2 + 1);
        }

        // peroclate up
        int hole = ++currentSize;

        for(array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }

        array[hole] = x;
    }

    private void enlargeArray(int newSize) {
        AnyType [] old = array;
        array = (AnyType []) new Comparable[newSize];
        for(int i = 0; i < old.length; i++) {
            array[i] = old[i];
        }
    }

    public AnyType findMin() {
        if(isEmpty()) {
            return null;
        }

        return array[1];
    }

    public AnyType deleteMin() {

        AnyType minItem = findMin();

        if(minItem == null){
            return null;
        }

        array[1] = array[currentSize--];
        percolateDown(1);

        return minItem;
    }

    public void percolateDown(int hole) {
        int child = 0;
        AnyType tmp = array[hole];

        for(; hole * 2 <= currentSize; hole = child){
            child = hole * 2;

            // if child + 1 is smaller than child then update child to child + 1
            if(child != currentSize && array[child + 1].compareTo(array[child]) < 0){
                child++;
            }if(array[child].compareTo(tmp) < 0){
                array[hole] = array[child];
            }else{
                break;
            }            
        }
        array[hole] = tmp;
    }

    public void buildHeap() {
        for(int i = (currentSize / 2); i > 0; i--){
            percolateDown(i);
        }
    }

    public void showHeap() {
        for(int i = 1; i <= currentSize; i++){
            System.out.print(array[i] + ", ");
        }
    }

    public static void main(String[] args) {

        int n = 15;
        // sorted arry
        Integer [] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // random array 
        Integer [] random = {8, 4, 2, 8, 9, 1, 3, 4, 9, 3};
        // reversed array
        Integer [] reversed = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};


        BinaryHeap<Integer> sortedHeapForInsert = new BinaryHeap<Integer>();
        BinaryHeap<Integer> sortedHeapForBuild = new BinaryHeap<Integer>(sorted);

        for(int i = 0; i < n; i++) {
            sortedHeapForInsert.insert(i);
        }

        BinaryHeap<Integer> rendomHeapForInsert = new BinaryHeap<Integer>();
        BinaryHeap<Integer> randomHeapForBuild = new BinaryHeap<Integer>(random);

        for(int i = 0; i < n; i++) {
            int rand = (int)(Math.random() * 10) + 1;
            rendomHeapForInsert.insert(rand);
        }

        BinaryHeap<Integer> reversedHeapForInsert = new BinaryHeap<Integer>();
        BinaryHeap<Integer> reversedHeapForBuild = new BinaryHeap<Integer>(reversed);

        for(int i = n; i > 0; i--) {
            reversedHeapForInsert.insert(i);
        }


        // show all heap outputs

        System.out.println("Heaps For the sorted inputs");
        System.out.print("Inserting n items: ");
        sortedHeapForInsert.showHeap();
        System.out.println("");
        System.out.print("Build n items: ");
        sortedHeapForBuild.showHeap();

        System.out.println("");
        System.out.println("********************");
        System.out.println("********************");

        System.out.println("Heaps For the random inputs");
        System.out.print("Inserting n items: ");
        rendomHeapForInsert.showHeap();
        System.out.println("");
        System.out.print("Build n items: ");
        randomHeapForBuild.showHeap();


        System.out.println("");
        System.out.println("********************");
        System.out.println("********************");
        
        System.out.println("Heaps For the reversed inputs");
        System.out.print("Inserting n items: ");
        reversedHeapForInsert.showHeap();
        System.out.println("");
        System.out.print("Build n items: ");
        reversedHeapForBuild.showHeap();


        // for the inserting methods the sorted list will run in O(n) time, this is becasue no percolate 
        // operations will be performed because the list is already sorted
        // for the random and reversed inputs it will run in O(nlogn) time because you have to perform a percolation
        // operation that takes O(logn) time. The random could potentially run faster based on how sorted the list is sorted

        // for the build heap operation it will run in O(n) for the sorted, reversed, and random. We know that the random list will
        // take O(n) time and sense you are always going to have to visit n nodes it cannot run in less time even if the list is sorted

    }
}
