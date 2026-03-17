package geeksforgeeks;

import java.util.*;

public class BurningOfTree {
    public static void main(String[] args) {

    }
    static int minTime(Node root, int target) {
        if(root.left == null && root.right == null) return 0;
        HashMap<Node,Node> mp = new HashMap<>();
        Node tar = markParents(root, mp,null,target);
        HashMap<Node,Integer> vis = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(tar);
        vis.put(tar,1);
        int cnt = 0;
        while(!q.isEmpty()){
            int s = q.size();
            int fl = 0;
            for (int i = 0; i < s; i++) {
                Node node = q.poll();
                if(node.left != null && vis.get(node.left) == null) {
                    q.offer(node.left);
                    vis.put(node.left,1);
                    fl = 1;
                }
                if(node.right != null && vis.get(node.right) == null){
                    q.offer(node.right);
                    vis.put(node.right,1);
                    fl = 1;
                }
                if(mp.get(node) != null&&vis.get(mp.get(node)) == null){
                    q.offer(mp.get(node));
                    vis.put(mp.get(node),1);
                    fl = 1;
                }
            }
            if(fl == 1) cnt += 1;
        }
        return cnt;
    }
    static Node markParents(Node root,HashMap<Node,Node> mp ,Node parent,int tar){
        if(root == null) return null;

        mp.put(root,parent);
        Node res = null;
        if(root.data == tar){
            res = root;
        }
        Node lefttarget = markParents(root.left,mp,root,tar);
        Node righttarget = markParents(root.right,mp,root,tar);

        if(lefttarget != null) return lefttarget;
        if(righttarget != null) return righttarget;

        return res;
    }
}
