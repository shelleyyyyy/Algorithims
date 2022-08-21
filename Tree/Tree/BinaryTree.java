package Tree;

// import java.security.SignatureException;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree <AnyType> {
    private BinaryNode<AnyType> root;

    public BinaryTree(){
        root = null;
    }

    public BinaryTree(AnyType item){
        root = new BinaryNode<>(item);
    }

    public BinaryTree(BinaryNode<AnyType> root){
        this.root = root;
    }

    public BinaryNode<AnyType> getRoot() {
        return root;
    }

    public void setRoot(BinaryNode<AnyType> root){
        this.root = root;
    }

    public void makeEmpty(){
        root = null;
    }

    public boolean checkEmpty(){
        return root == null;
    }

    // O(n)
    public static <AnyType> int size(BinaryNode<AnyType> treeNode){
        if(treeNode == null){
            return 0;
        }

        return 1 + size(treeNode.getLeft()) + size(treeNode.getRight());
    }

    // O(n)
    public static <AnyType> int height(BinaryNode<AnyType> treeNode){
        if(treeNode == null){
            return -1;
        }

        return 1 + Math.max(height(treeNode.getLeft()), height(treeNode.getRight()));
    }

    // O(n)
    public static <AnyType> BinaryNode<AnyType> duplicate(BinaryNode<AnyType> treeNode){
        if(treeNode == null){
            return treeNode;
        }

        BinaryNode<AnyType> dupNode = new BinaryNode<>(treeNode.getElement());

        if(treeNode.getLeft() != null){
            dupNode.setLeft(duplicate(treeNode.getLeft()));;
        }

        if(treeNode.getRight() != null){
            dupNode.setRight(duplicate(treeNode.getRight()));;
        }

        return dupNode;

    }

    // O(1)
    public static <AnyType> BinaryTree<AnyType> merge(AnyType item, BinaryTree<AnyType> t1, BinaryTree<AnyType> t2){
        
        BinaryNode<AnyType> mergeNode;

        if(t1 == null && t2 == null)
            return new BinaryTree<AnyType>(item);

        if(t1 != null && t2 != null){
            mergeNode = new BinaryNode<AnyType>(item, t1.getRoot(), t2.getRoot());
            t1.setRoot(null);
            t2.setRoot(null);
        }else if(t1 != null){
            mergeNode = new BinaryNode<AnyType>(item, t1.getRoot(), null);
        }else{
            mergeNode = new BinaryNode<AnyType>(item, null, t2.getRoot());
        }

        return new BinaryTree<>(mergeNode);        
    }

    // O(n)
    public static <AnyType> BinaryTree<AnyType> merge2(AnyType item, BinaryTree<AnyType> t1, BinaryTree<AnyType> t2){
        
        BinaryNode<AnyType> mergeNode = new BinaryNode<AnyType>(item, duplicate(t1.getRoot()), duplicate(t2.getRoot()));
        
        t1 = null;
        t2 = null;

        return new BinaryTree<>(mergeNode);

    }

    // O(n)
    public static <AnyType> void preOrder(BinaryNode<AnyType> treeNode){
        System.out.println(treeNode.getElement());

        if(treeNode.getLeft() != null){
            preOrder(treeNode.getLeft());
        }

        if(treeNode.getRight() != null){
            preOrder(treeNode.getRight());
        }
    }

    // O(n)
    public static <AnyType> void inOrder(BinaryNode<AnyType> treeNode){
    
        if(treeNode.getLeft() != null){
            preOrder(treeNode.getLeft());
        }

        System.out.println(treeNode.getElement());

        if(treeNode.getRight() != null){
            preOrder(treeNode.getRight());
        }
    }

    // O(n)
    public static <AnyType> void postOrder(BinaryNode<AnyType> treeNode){
    
        if(treeNode.getLeft() != null){
            preOrder(treeNode.getLeft());
        }

        if(treeNode.getRight() != null){
            preOrder(treeNode.getRight());
        }

        System.out.println(treeNode.getElement());
    }

    // O(n)
    public static <AnyType> void levelOrder(BinaryNode<AnyType> treeNode){

        Queue<BinaryNode<AnyType>> queue = new LinkedList<>();

        queue.add(treeNode);

        while(!queue.isEmpty()){
            BinaryNode<AnyType> node = queue.remove();

            System.out.print(node.getElement() + " ");

            if(node.getLeft() != null){
                queue.add(node.getLeft());
            }

            if(node.getRight() != null){
                queue.add(node.getRight());
            }
        }
    }

    
    public static void main(String[] args) {
        
        BinaryTree<Character> t3 = new BinaryTree<>('a');

        BinaryNode<Character> root = t3.getRoot();
        
        // create nodes
        BinaryNode<Character> bNode = new BinaryNode<>('b');
        BinaryNode<Character> cNode = new BinaryNode<>('c');
        BinaryNode<Character> dNode = new BinaryNode<>('d');
        BinaryNode<Character> eNode = new BinaryNode<>('e');
        BinaryNode<Character> fNode = new BinaryNode<>('f');
        BinaryNode<Character> gNode = new BinaryNode<>('g');
        BinaryNode<Character> hNode = new BinaryNode<>('h');
        BinaryNode<Character> iNode = new BinaryNode<>('i');

        // set the chold of node e 

        eNode.setRight(gNode);
        
        bNode.setLeft(dNode);
        bNode.setRight(eNode);

        cNode.setRight(fNode);
        
        // set root

        root.setLeft(bNode);
        root.setRight(cNode);

        System.out.println(root.toString());

        // System.out.println(size(root));
        // System.out.println(height(root));

        // preOrder(root);
        // System.out.println("\n");
        // inOrder(root);
        // System.out.println("\n");
        // postOrder(root);


        System.out.println("t1 Tree");

        BinaryNode<Character> dup = duplicate(root);

        System.out.println("t2 Tree");

        BinaryTree<Character> t2 = new BinaryTree<>(dup);

        // System.out.println(t2.toString());

        System.out.println("merged 2.0");

        BinaryTree<Character> x = merge2('x', t3, t2);

        System.out.println(x.getRoot().toString());


        levelOrder(root);

    }
}
