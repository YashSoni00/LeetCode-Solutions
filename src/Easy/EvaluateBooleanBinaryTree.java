package Easy;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class EvaluateBooleanBinaryTree {
    public static void main(String[] args) {
        // [2,1,3,null,null,0,1]
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(evaluateTree(root)); // true
    }

    public static boolean evaluateTree(TreeNode root) {
        if (root.val == 3) {
            return evaluateTree(root.left) && evaluateTree(root.right);
        } else if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return root.val == 1;
        }
    }
}
