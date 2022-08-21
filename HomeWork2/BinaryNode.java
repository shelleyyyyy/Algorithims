package HomeWork2;

public class BinaryNode <AnyType> {

    private AnyType element;
    private BinaryNode <AnyType> left; 
    private BinaryNode <AnyType> right;

    public BinaryNode(AnyType element){
        this(element, null, null);
    }
    
    public BinaryNode(AnyType element, BinaryNode <AnyType> left, BinaryNode <AnyType> right){
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public AnyType getElement(){
        return element;
    }

    public BinaryNode <AnyType> getLeft(){
        return left;
    }
    
    public BinaryNode <AnyType> getRight(){
        return right;
    }

    public void setElement(AnyType newElement){
        element = newElement;
    }

    public void setLeft(BinaryNode <AnyType> newLeft){
        left = newLeft;
    }

    public void setRight(BinaryNode <AnyType> newRight){
        right = newRight;
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
