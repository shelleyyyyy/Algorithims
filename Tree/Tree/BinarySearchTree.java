package Tree;

public class BinarySearchTree <AnyType extends Comparable<AnyType>> {
    public class BinaryNode <AnyType> {

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

    public void makeEmpty(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
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


    public AnyType findMin(BinaryNode <AnyType> treeNode){

        if(treeNode == null){
            return null;
        }

        if(treeNode.left == null){
            return treeNode.element;
        }

        return findMin(treeNode.left);
    }

    public AnyType findMax(BinaryNode <AnyType> treeNode){

        if(treeNode == null){
            return null;
        }

        if(treeNode.right == null){
            return treeNode.element;
        }

        return findMax(treeNode.right);
    }

    public AnyType badFindMax(BinaryNode <AnyType> treeNode){
        if(treeNode == null){
            return null;
        }

        while(treeNode.right != null){
            treeNode = treeNode.right;
        }

        return treeNode.element;
    }


    public void remove(AnyType x){
        root = remove(x, root);
    }

    public BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t){
        if(t == null){
            return t;
        }

        int compareResult = x.compareTo(t.element);

        if(compareResult < 0){
            t.left =  remove(x, t.left);
        }else if(compareResult > 0){
            t.right = remove(x, t.right);
        }else if(t.right != null && t.left !=null){
            t.element = findMin(t.right);
            t.right = remove(t.element, t.right);
        }else{
            t = (t.left != null) ? t.left : t.right;
        }
        return t;   
        
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        for(int i = 0; i < 15; i ++){
            int rand = 1 + (int)(Math.random() * 10);

            bst.insert(i);
        }

        System.out.println(bst.root.toString());

        System.out.println(bst.findMin(bst.root));
        System.out.println(bst.badFindMax(bst.root));
        System.out.println(bst.findMax(bst.root));

        System.out.println(bst.contains(9));
        bst.remove(9);
        System.out.println(bst.contains(9));
        System.out.println(bst.root.toString());

        


        // System.out.println(findMin(17, bst.root));
    }
}
