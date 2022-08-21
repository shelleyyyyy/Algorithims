package Tree;

public class canvasMethods <AnyType> {

    private AnyType element;
    private canvasMethods <AnyType> left; 
    private canvasMethods <AnyType> right;

    public canvasMethods(){

    }
    
    public canvasMethods(AnyType element, canvasMethods <AnyType> left, canvasMethods <AnyType> right){
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public AnyType getElement(){
        return element;
    }

    public canvasMethods <AnyType> getLeft(){
        return left;
    }
    
    public canvasMethods <AnyType> getRight(){
        return right;
    }

    public void setElement(AnyType newElement){
        element = newElement;
    }

    public void setLeft(canvasMethods <AnyType> newLeft){
        left = newLeft;
    }

    public void setRight(canvasMethods <AnyType> newRight){
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

    public static void main(String[] args) {
        
        canvasMethods <Character> nodeD = new canvasMethods<>('D', null, null);
        canvasMethods <Character> nodeC = new canvasMethods<>('C', nodeD, nodeD);
        canvasMethods <Character> nodeB = new canvasMethods<>('B', nodeD, nodeD);

        canvasMethods <Character> nodeA = new canvasMethods<>('A', nodeB, nodeC);

        System.out.println(nodeA.toString());
    }

}
