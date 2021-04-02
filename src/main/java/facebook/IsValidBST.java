package facebook;

public class IsValidBST {


    public boolean isValidBSTC(TreeNode root,int mx,int min){
            if(root==null)
                return true ;
            else{
                boolean current = root.val<mx && root.val>min ;
                boolean childBST = isValidBSTC(root.left,root.val,min) && isValidBSTC(root.right,mx,root.val) ;
                return current&&childBST ;

            }
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBSTC(root,Integer.MAX_VALUE,Integer.MIN_VALUE) ;
    }
}





