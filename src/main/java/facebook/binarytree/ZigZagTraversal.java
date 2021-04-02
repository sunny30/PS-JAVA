package facebook.binarytree;

import java.util.*;

public class ZigZagTraversal {

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




        public void levelOrderBottom(TreeNode root, int level, TreeMap<Integer,List<Integer>> map){
            if(root==null)
                return ;
            if(!map.containsKey(level)){
                List<Integer> list = new ArrayList<Integer>() ;
                list.add(root.val);
                map.put(level,list) ;
            }else{
                map.get(level).add(root.val);
            }

            levelOrderBottom(root.left,level+1,map) ;
            levelOrderBottom(root.right,level+1,map) ;

        }


        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            TreeMap<Integer,List<Integer>> map = new TreeMap<Integer, List<Integer>>() ;
            levelOrderBottom(root,0,map);
            List<List<Integer>> ans = new ArrayList<List<Integer>>() ;
            for(int key:map.keySet()){
                if(key%2==1) {
                    Collections.reverse(map.get(key)) ;
                   // ans.add();
                }
                ans.add(map.get(key));
            }
            return ans ;

        }
}
