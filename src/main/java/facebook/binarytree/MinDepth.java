package facebook.binarytree;

public class MinDepth {

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

    public int minDepth(TreeNode root) {

        if(root.left==null && root.right==null)
            return 0 ;
        int ldepth = Integer.MAX_VALUE-10 ;
        int rdepth = Integer.MAX_VALUE-10 ;

        if(root.left==null)
            rdepth = minDepth(root.right) ;
        else if(root.right==null)
            ldepth = minDepth(root.left) ;
        else{
            ldepth = minDepth(root.left ) ;
            rdepth = minDepth(root.right) ;
        }

        int ans = 1+Math.min(ldepth,rdepth);
        return ans ;


    }
}
