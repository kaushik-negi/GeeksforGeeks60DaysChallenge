package geeksforgeeks;

class NodeValue{
    int maxNode;
    int minNode;
    int maxSize;

    NodeValue(int maxNode,int minNode,int maxSize){
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.maxSize = maxSize;
    }
}
public class LargestBST {
    public static void main(String[] args) {

    }
    static int largestBst(Node root) {
        return largestBstHelper(root).maxSize;
    }
    static NodeValue largestBstHelper(Node root){
        if(root == null) return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);

        NodeValue left = largestBstHelper(root.left);
        NodeValue right = largestBstHelper(root.right);

        if(left.maxNode<root.data && root.data < right.minNode){
            return new NodeValue(Math.min(root.data, left.minNode),Math.max(root.data, right.maxNode),left.maxSize+right.maxSize+1);
        }

        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxSize, right.maxSize));
    }
}
