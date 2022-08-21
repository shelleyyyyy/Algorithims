package HomeWork1;

// HELP RECIEVED
// Class materials, textbook, notes, in class code
// I googled how to take the absolute value in java
// Discussed elements of assignment with cole corson

import java.lang.Math;

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

    // O(n)
    public static <AnyType> int size(BinaryNode<AnyType> treeNode){
        if(treeNode == null){
            return 0;
        }

        return 1 + size(treeNode.getLeft()) + size(treeNode.getRight());
    }

    public static <AnyType> int leafs(BinaryNode<AnyType> treeNode){

        if(treeNode == null){
            return 0;
        }

        if(treeNode.getLeft() == null && treeNode.getLeft() == null){
            return 1;
        }

        return leafs(treeNode.getLeft()) + leafs(treeNode.getRight());
    }

    public static <AnyType> int fullNodes(BinaryNode<AnyType> treeNode){
        return leafs(treeNode) - 1;
    }

    // O(n)
    public static <AnyType> int height(BinaryNode<AnyType> treeNode){
        if(treeNode == null){
            return -1;
        }

        return 1 + Math.max(height(treeNode.getLeft()), height(treeNode.getRight()));
    }

    public static <AnyType> boolean similar(BinaryNode<AnyType> t1Root, BinaryNode<AnyType> t2Root){

        int t1LH = height(t1Root.getLeft());
        int t1RH = height(t1Root.getLeft());
        int t2LH = height(t2Root.getLeft());
        int t2RH = height(t2Root.getLeft());

        int heightLDiff = Math.abs(t1LH - t2LH);
        int heightRDiff = Math.abs(t1RH - t2RH);

        int t1LS = size(t1Root.getLeft());
        int t1RS = size(t1Root.getLeft());
        int t2LS = size(t2Root.getLeft());
        int t2RS = size(t2Root.getLeft());

        int sizeLDiff = Math.abs(t1LS - t2LS);
        int sizeRDiff = Math.abs(t1RS - t2RS);

        if(height(t1Root) == -1 && height(t2Root) == -1){
            return true;
        }

        if(height(t1Root) != -1 && height(t2Root) == -1){
            return false;
        }

        if(height(t1Root) == -1 && height(t2Root) != -1){
            return false;
        }

        if(heightLDiff > 3){
            return false;
        }

        if(heightRDiff > 3){
            return false;
        }

        if(sizeLDiff > 3){
            return false;
        }

        if(sizeRDiff > 3){
            return false;
        }

        return true;

    }

    // Question 5

    public static int sumTree(BinaryNode<Integer> treeNode){

        if(treeNode == null){
            return 0;
        }

        return treeNode.getElement() + sumTree(treeNode.getLeft()) + sumTree(treeNode.getRight());
    }

    public static int countEvens(BinaryNode<Integer> treeNode){

        if(treeNode == null){
            return 0;
        }

        if(treeNode.getElement() % 2 == 0){
            return 1 + countEvens(treeNode.getLeft()) + countEvens(treeNode.getRight());
        }else{
            return countEvens(treeNode.getLeft()) + countEvens(treeNode.getRight());
        }
    }

    public static <AnyType> int sameChildren(BinaryNode<AnyType> treeNode){

        if(treeNode.getLeft() == null || treeNode.getRight() == null){
            return 0;
        }

        if(treeNode.getLeft().getElement() == treeNode.getRight().getElement()){
            return 1 + sameChildren(treeNode.getLeft()) + sameChildren(treeNode.getRight());
        }else{
            return sameChildren(treeNode.getLeft()) + sameChildren(treeNode.getRight());
        }
    }

    public static int longestIncreasingPath(BinaryNode<Integer> treeNode){

        if(treeNode.getLeft() == null || treeNode.getRight() == null){
            return 0;
        }

        if(treeNode.getLeft().getElement() > treeNode.getElement() && treeNode.getRight().getElement() > treeNode.getElement()){
            return 1 + Math.max(longestIncreasingPath(treeNode.getLeft()), longestIncreasingPath(treeNode.getRight()));
        }

        if(treeNode.getLeft().getElement() > treeNode.getElement()){
            return 1 + longestIncreasingPath(treeNode.getLeft());
        }
        else if(treeNode.getRight().getElement() > treeNode.getElement()){
            return 1 + longestIncreasingPath(treeNode.getRight());
        }
        else{
            return 0;
        }        
    }

    public static void main(String[] args) {

        BinaryTree<Character> t1 = new BinaryTree<>('a');
        BinaryTree<Character> t2 = new BinaryTree<>('a');
        BinaryTree<Integer> intTree = new BinaryTree<>(1);

        BinaryNode<Character> root = t1.getRoot();
        BinaryNode<Character> root2 = t2.getRoot();
        BinaryNode<Integer> root3 = intTree.getRoot();

        BinaryNode<Integer> intNode1 = new BinaryNode<>(2);
        BinaryNode<Integer> intNode2 = new BinaryNode<>(2);
        BinaryNode<Integer> intNode3 = new BinaryNode<>(3);
        BinaryNode<Integer> intNode4 = new BinaryNode<>(1);
        BinaryNode<Integer> intNode5 = new BinaryNode<>(1);
        BinaryNode<Integer> intNode6 = new BinaryNode<>(1);


        BinaryNode<Character> bNode = new BinaryNode<>('b');
        BinaryNode<Character> cNode = new BinaryNode<>('b');
        BinaryNode<Character> dNode = new BinaryNode<>('e');
        BinaryNode<Character> eNode = new BinaryNode<>('e');
        BinaryNode<Character> fNode = new BinaryNode<>('f');
        BinaryNode<Character> gNode = new BinaryNode<>('g');

        eNode.setRight(gNode);
        bNode.setLeft(dNode);
        bNode.setRight(eNode);
        cNode.setRight(fNode);
        root.setLeft(bNode);
        root.setRight(cNode);

        intNode1.setLeft(intNode3);
        intNode1.setRight(intNode4);
        intNode2.setLeft(intNode5);
        intNode2.setRight(intNode6);
        root3.setLeft(intNode1);
        root3.setRight(intNode2);

        System.out.println("****************************************");
        System.out.println("****************************************");
        System.out.println("TREE");
        System.out.println(t1.getRoot().toString());

        System.out.println("Question 4.31 a) Get Size of Tree");
        // Running time of the size() method is O(n) because you have to visit every node
        // to calculate how many nodes are in a binary tree
        System.out.println(size(root));
        System.out.println("Question 4.31 b) Get Leafs in Tree");
        // Running time of the leafs() method is O(n) because you have to visit every node
        // and then check to see if both of its children are null to determine if it is a leaf
        System.out.println(leafs(root));
        System.out.println("Question 4.31 c) Get Full Nodes in Tree");
        // Running time of the fullNodes() method is O(n) because you have to visit every node
        // and then check to see if both of its children are not null to determine if it is a full node
        System.out.println(fullNodes(root));

        System.out.println("****************************************");
        System.out.println("****************************************");

        System.out.println("TREE 1");
        System.out.println(t1.getRoot().toString());

        System.out.println("TREE 2");
        System.out.println(t2.getRoot().toString());

        System.out.println("4.46 similar test");
        // The running tiem of the similar() method is O(n) because I run size() and height() in the similar
        // method so I can do some checks, and in both the size() and the height() method you have to visit every node
        System.out.println(similar(t1.getRoot(), t2.getRoot()));
        
        System.out.println("****************************************");
        System.out.println("****************************************");

        System.out.println("Question 5");
        System.out.println("TREE");
        System.out.println(intTree.getRoot().toString());
        System.out.println("question 5 a) even data items");
        // Running time of the countEvens() method is O(n) because you have to visit every node
        // and then check to see if it is even for this method to return the number of evens in the tree
        System.out.println(countEvens(intTree.getRoot()));
        System.out.println("question 5 b) sum of all items");
        // Running time of the sumTree() method is O(n) because you have to visit every node
        // to add the value of the node to the sum of the tree
        System.out.println(sumTree(intTree.getRoot()));
        System.out.println("question 5 c) nodes with the same children");
        // Running time of the sameChildren() method is O(n) because you have to visit every node
        // to check and see what its children are
        System.out.println(sameChildren(intTree.getRoot()));
        System.out.println("question 5 d) longest path");
        // Running time of the longestIncreasingPath() method is O(n) because you have to visit every node
        // to check weather the value is greater than its parent and then add one to the return value if it is
        System.out.println(longestIncreasingPath(intTree.getRoot()));

        System.out.println("****************************************");
        System.out.println("****************************************");

    }
}
