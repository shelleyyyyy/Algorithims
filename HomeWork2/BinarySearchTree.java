package HomeWork2;

// HELP RECIEVED
// Class materials, notes, textbook, in class code
// Discussed elements of assignment with cole corson

public class BinarySearchTree <AnyType extends Comparable<AnyType>> {
    public static class BinaryNode <AnyType> {

        AnyType element;
        BinaryNode <AnyType> left; 
        BinaryNode <AnyType> right;
    
        BinaryNode(){
            this(null, null, null);
        }

        BinaryNode(AnyType element){
            this(element, null, null);
        }
        
        BinaryNode(AnyType element, BinaryNode <AnyType> left, BinaryNode <AnyType> right){
            this.element = element;
            this.left = left;
            this.right = right;
        }

            // online resource
        public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        
            if(right != null) 
                right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
            
            sb.append(prefix).append(isTail ? "└── " : "┌── ").append(element.toString()).append("\n");
            
            if(left != null) 
                left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
            
            return sb;
        }

        // online resource
        @Override
        public String toString() {
            
            return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
        }
    }

    private BinaryNode <AnyType> root;

    BinarySearchTree(){
        root = null;
    }

    public void insert(AnyType x){
        root = insert(x, root);
    }

    private BinaryNode <AnyType> insert(AnyType x, BinaryNode <AnyType> t){
        if(t == null){
            return new BinaryNode<>(x);
        }

        int compareResult = x.compareTo(t.element);

        if(compareResult < 0){
            t.left = insert(x, t.left);
        }
        else if(compareResult > 0){
            t.right = insert(x, t.right);
        }
        else{
            ;
        }

        return t;


    }

    public boolean contains(AnyType x){
        return contains(x, root);
    }

    private boolean contains(AnyType x, BinaryNode <AnyType> t){
        if(t == null){
            return false;
        }

        int compareResult = x.compareTo(t.element);

        if(compareResult < 0){
            return contains(x, t.left);
        }
        else if(compareResult > 0){
            return contains(x, t.right);
        }
        else
            return true;
    }


    public boolean satisfy(BinaryNode <AnyType> t){

        if(t == null){
            return true;
        }
        
        if(t.left != null){
            int cLeft = t.left.element.compareTo(t.element);
            if(cLeft > 0){
                return false;
            }
            return satisfy(t.left);
        }

        if(t.right != null){
            int cRight = t.right.element.compareTo(t.element);
            if(cRight < 0){
                return false;
            }
            return satisfy(t.right);
        }

        return true;
    }

    public static void createTree(int n){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        for(int i = 0; i < n; i ++){
            int rand = 1 + (int)(Math.random() * 10);
            bst.insert(rand);
        }

        System.out.println(bst.root.toString());
    }


    public static void printKeys(BinarySearchTree<Integer> bst, int k1, int k2){
        
        System.out.println("printing elements between " + k1 + " and " + k2);

        for(int i = k1 + 1; i < k2; i++){
            if(bst.contains(i)){
                System.out.println(i);
            }
        }
    }
    
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        for(int i = 0; i < 15; i ++){
            int rand = 1 + (int)(Math.random() * 10);

            bst.insert(rand);
        }

        System.out.println("TREE");
        System.out.println("***********************************");
        System.out.println(bst.root.toString());
        System.out.println("***********************************");
        System.out.println("Question 4.32) satisfy");

        System.out.println(bst.satisfy(bst.root));
        
        System.out.println("***********************************");

        System.out.println("***********************************");
        System.out.println("Question 4.34) create tree");

        // The running time of my create tree method is in O(nlogn) average and O(n^2) worst case this is because
        // the operation starts by initializing a for loop of length n, and the operation that is being
        // performed every iteration of the loop is O(logn) in on average and O(n) in the worst case
        // this is because the insert method that is being called works by cutting the tree in half each time if the
        // tree is balanced, if the tree is not balanced then the insert method will run in O(n)

        createTree(5);
        
        System.out.println("***********************************");
        System.out.println("***********************************");
        System.out.println("Question 4.37) print keys");

        // the running time of the printKeys method is O(klogn) in average because
        // for every key that it needs to check it runs the contains method which will run 
        // in O(logn) in average

        printKeys(bst, 5, 7);
        
        System.out.println("***********************************");
        
    }
}
