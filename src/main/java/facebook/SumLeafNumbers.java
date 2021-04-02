package facebook;

public class SumLeafNumbers {
    public Integer totalSum = 0 ;
    public void sumNumbers(TreeNode root, String pathSum) {
        if(root==null)
            return ;
        pathSum = pathSum+String.valueOf(root.val) ;

        if(root.left==null && root.right==null)
        {
            totalSum = totalSum+Integer.parseInt(pathSum) ;
            return ;
        }
        sumNumbers(root.left,pathSum) ;
        sumNumbers(root.right,pathSum) ;
    }
    public int sumNumbers(TreeNode root) {

        sumNumbers(root, "") ;
        return totalSum ;
    }



}
