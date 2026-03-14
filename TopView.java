package geeksforgeeks;
import java.util.*;
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
class pair{
    Node node;
    int level;
    pair(Node node,int level){
        this.node = node;
        this.level = level;
    }
}
public class TopView {
    public static void main(String[] args) {

    }
    static ArrayList<Integer> topView(Node root) {
        if(root == null) return new ArrayList<>();
        Map<Integer,Integer> mp = new TreeMap<>();
        Queue<pair> q = new LinkedList<>();

        q.offer(new pair(root,0));
        ArrayList<Integer> arr = new ArrayList<>();
        while (!q.isEmpty()){
            pair p = q.poll();

            if(!mp.containsKey(p.level)){
                mp.put(p.level,p.node.data);
            }
            if(p.node.left != null) {
                q.offer(new pair(root.left,p.level-1));
            }
            if(p.node.right != null){
                q.offer(new pair(root.right,p.level+1));
            }
        }
        for (Map.Entry<Integer,Integer> m : mp.entrySet()) {
            arr.add(m.getValue());
        }

        return arr;
    }
}
