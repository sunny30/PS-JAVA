package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RightViewofBinaryTree {

    Map<Integer,Integer> depthMap = new HashMap<Integer,Integer>();
    public int maxDepth(TreeNode root){
        if(root==null)
            return 0 ;
        int ldepth = maxDepth(root.left) ;
        int rdepth = maxDepth(root.right) ;
        return Math.max(ldepth,rdepth)+1 ;
    }
    public List<Integer> rightSideView(TreeNode root) {
        int height  = maxDepth(root) ;
        List<Integer> ans = new ArrayList<Integer>() ;
        rightSideView(root,1) ;
        for(int i=1;i<=height;i++){
            ans.add(depthMap.get(i)) ;
        }
        return ans ;

    }

    public void rightSideView(TreeNode root,int depth) {
        if(root==null)
            return ;
        if(!depthMap.containsKey(depth)){
            depthMap.put(depth,root.val) ;
        }
        rightSideView(root.right,depth+1) ;
        rightSideView(root.left,depth+1) ;

    }
}
