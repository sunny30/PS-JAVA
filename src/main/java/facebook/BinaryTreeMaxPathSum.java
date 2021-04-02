package facebook;

class TreeNode {
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


public class BinaryTreeMaxPathSum {

    int max = -100001;

    public int longestPathSum(TreeNode root) {
        if (root == null)
            return 0;
        int lsum = longestPathSum(root.left);
        int rsum = longestPathSum(root.right);

        int ans1 = root.val;
        int ans = Math.max(root.val + lsum, root.val + rsum);
        ans = Math.max(ans, ans1);
        int max1 = Math.max(root.val + lsum + rsum, ans);
        max = Math.max(max1, max);
        return ans;
    }

    public int maxPathSum(TreeNode root) {
        longestPathSum(root);
        return max;
    }
}
