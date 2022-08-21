package HomeWork2;

// HELP RECIEVED
// Class materials, notes, textbook, in class code
// Discussed elements of assignment with cole corson

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

    public static <AnyType> BinaryNode<AnyType> removeLeafe(BinaryNode<AnyType> treeNode){
        if(treeNode == null){
            return treeNode;
        }

        BinaryNode<AnyType> dupNode = new BinaryNode<>(treeNode.getElement());

        if(treeNode.getLeft() != null){
            if(treeNode.getLeft().getLeft() == null && treeNode.getLeft().getRight() == null){

            }else{
                dupNode.setLeft(removeLeafe(treeNode.getLeft()));;
            }
        }

        if(treeNode.getRight() != null){
            if(treeNode.getRight().getLeft() == null && treeNode.getRight().getRight() == null){

            }else{
                dupNode.setRight(removeLeafe(treeNode.getRight()));;
            }
        }
        return dupNode;
    }

    public static void main(String[] args) {

        BinaryTree<Character> t1 = new BinaryTree<>('a');

        BinaryNode<Character> root = t1.getRoot();

        BinaryNode<Character> bNode = new BinaryNode<>('b');
        BinaryNode<Character> cNode = new BinaryNode<>('c');
        BinaryNode<Character> dNode = new BinaryNode<>('d');
        BinaryNode<Character> eNode = new BinaryNode<>('e');
        BinaryNode<Character> fNode = new BinaryNode<>('f');
        BinaryNode<Character> gNode = new BinaryNode<>('g');

        eNode.setRight(gNode);
        bNode.setLeft(dNode);
        bNode.setRight(eNode);
        cNode.setRight(fNode);
        root.setLeft(bNode);
        root.setRight(cNode);
        
        System.out.println("TREE");
        System.out.println(t1.getRoot().toString());

        System.out.println("Question 4.33) Remove Leaf");

        System.out.println(removeLeafe(t1.getRoot()).toString());

    }
}
