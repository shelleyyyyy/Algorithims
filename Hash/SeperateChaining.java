
package Hash;

import java.util.LinkedList;
import java.util.List;

public class SeperateChaining<AnyType>{
    private static final int DEFAULT_TABLE_SIZE = 11;
    private List<AnyType> [] theLists;
    private int currentSize;

    public SeperateChaining(){
        this(DEFAULT_TABLE_SIZE);
    }

    public SeperateChaining(int size){
        theLists = new LinkedList[nextPrime(size)];

        for(int i = 0; i < theLists.length; i++){
            theLists[i] = new LinkedList<>();
        }
    }

    public int myHash(AnyType x){
        int hashVal = x.hashCode();

        hashVal %= theLists.length;

        if(hashVal < 0){
            hashVal += theLists.length;
        }

        return hashVal;
    }

    public void makeEmpty(){
        for(int i = 0; i < theLists.length; i++){
            theLists[i].clear();
        }

        currentSize = 0;
    }

    public void insert(AnyType x){
        List<AnyType> whichList = theLists[myHash(x)];

        if(!whichList.contains(x)){
            whichList.add(x);
            currentSize++;
        }
    }


    public void reHash(){
        List<AnyType> [] whichList = theLists;

        theLists = new List[nextPrime(2 * theLists.length)];

        for(int i = 0; i < whichList.length; i++){
            theLists[i] = new LinkedList<>();
        }

        for(int i = 0; i < whichList.length; i++){
            for(AnyType item : whichList[i]){
                insert(item);
            }
        }
    }

    public boolean containes(AnyType x){
        List<AnyType> whichList = theLists[myHash(x)];

        return whichList.contains(x);
    }

    public void remove(AnyType x){
        List<AnyType> whichList = theLists[myHash(x)];

        if(whichList.contains(x)){
            whichList.remove(x);
            currentSize--;
        }
    }

    public void print(){
        int i = 0; 

        for(List<AnyType> list : theLists){
            System.out.print("Cell" + i +  " : ");
            for(AnyType item : list){
                System.out.print(item + " -> ");
            }
            System.out.println();
            i++;
        }
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
        SeperateChaining<Integer> sp = new SeperateChaining<>();

        // Integer [] keys = {2, 14, 26, 31, 86, 97};
        for(int i = 0; i < 200; i++){
            int rand = (int)(Math.random() * 100);
            sp.insert(rand);
        }

        sp.print();
    }
}