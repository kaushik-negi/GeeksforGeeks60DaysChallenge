package geeksforgeeks;
import java.util.*;
class node{
    int data;
    int idx;
    node left;
    node right;
    node(int data,int idx){
        this.data = data;
        this.idx = idx;
        this.left = null;
        this.right = null;
    }
}
public class HuffmanEncoding {
    public static void main(String[] args) {

    }
    static ArrayList<String> huffmanCodes(String s, int f[]) {
        PriorityQueue<node> p = new PriorityQueue<>((x,y)->x.data - y.data);
        for (int i = 0; i < f.length; i++) {
            p.offer(new node(f[i],i));
        }

        while (p.size() > 1){
            node left = p.poll();
            node right = p.poll();

            node n = new node(left.data+right.data,Math.min(left.idx, right.idx));

            n.left = left;
            n.right = right;

            p.offer(n);
        }

        node root = p.poll();

        ArrayList<String> ans = new ArrayList<>(Collections.nCopies(f.length,""));

        StringBuilder str = new StringBuilder();

        solve(root,ans,str);

        return ans;
    }

    static void solve(node root,ArrayList<String> ans,StringBuilder str){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(str.length() == 0){
                ans.add( "0");
            }else{
                ans.add( str.toString());
            }
            return;
        }
        solve(root.left, ans, str.append('0'));
        str.deleteCharAt(str.length()-1);
        solve(root.right, ans, str.append('1'));
        str.deleteCharAt(str.length()-1);
    }
}
