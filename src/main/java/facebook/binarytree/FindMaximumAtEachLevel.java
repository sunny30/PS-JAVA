package facebook.binarytree;

import java.util.*;

public class FindMaximumAtEachLevel {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void travers(TreeNode root,int level,Map<Integer,Integer> map){
        if(root==null)
            return ;
        if(!map.containsKey(level)){
            map.put(level,root.val) ;
        }else if(map.get(level)<root.val){
            map.put(level,root.val) ;
        }

        travers(root.left,level+1,map);
        travers(root.right,level+1,map);
    }

    public List<Integer> largestValues(TreeNode root) {
        Map<Integer,Integer> map = new TreeMap<Integer, Integer>() ;
        travers(root,0,map);
        List<Integer> list = new ArrayList<Integer>() ;
        for(int key:map.keySet()){
            list.add(map.get(key));
        }

        return list ;


    }
}
