package facebook;

public class InOrderSuccessor {

    public TreeNode getMin(TreeNode root){
        if(root == null)
            return null ;
        if(root.left==null)
            return root ;
        return getMin(root.left) ;
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p,boolean isleft,TreeNode parent){
        if(root.val==p.val){
            if(parent==null)
                return null ;
            else{
                if(isleft){
                    TreeNode rightS = getMin(p.right) ;
                    if(rightS!=null)
                        return rightS ;
                    else
                        return parent ;

                }else{
                    return getMin(p.right) ;
                }

            }
        }else{
            if(root.val>p.val)
                return inorderSuccessor(root.left,p,true,root) ;
            else{
                return inorderSuccessor(root.right,p,false,root) ;
            }
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return inorderSuccessor(root,p,false,null) ;

    }
}
