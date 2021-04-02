package dsalgo;


class TreeNode{
    int val ;
    TreeNode left ;
    TreeNode right ;

    TreeNode(int val){
        this.val = val ;
        this.left = null ;
        this.right = null ;

    }

    private void insert(TreeNode root,TreeNode parent,boolean isLeft,int val) {
        if(root==null  && parent==null){
            root = new TreeNode(val) ;
            return;
        } if(root ==null){
            root = new TreeNode(val) ;
            if(isLeft)
                parent.left = root ;
            else
                parent.right=root ;
            return ;
        }
        else{
            if(val<=root.val)
                insert(root.left,root,true,val);
            else
                insert(root.right,root,false,val);
        }
    }

    public void insert(int val) {
        insert(this,null,false,val);
    }


    public void inorderPrint(TreeNode root){
        if(root==null)
            return ;
        else{
            inorderPrint(root.left);
            System.out.println(root.val);
            inorderPrint(root.right);
        }
    }
}
public class BST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6) ;
        root.insert(4);
        root.insert(9);
        root.insert(5);
        root.insert(8);
        root.insert(10);
        root.inorderPrint(root);

    }




}
