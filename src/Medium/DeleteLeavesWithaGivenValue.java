package Medium;

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

public class DeleteLeavesWithaGivenValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);

        printInorder(root);
        root = removeLeafNodes(root, 2);

        System.out.println();
        printInorder(root);
    }

    private static void printInorder(TreeNode result) {
        if (result == null)
            return;
        System.out.print(result.val + " ");
        printInorder(result.left);
        printInorder(result.right);
    }

    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        // Store the node as reference to return at end.
        TreeNode result = root;
        removeLeaves(root, target);
        return result;
    }

    public static void removeLeaves(TreeNode root, int target) {
        if (root.left != null) {
            removeLeaves(root.left, target);
            if (root.left.val == 0) {
                root.left = null;
            }
        }
        if (root.right != null) {
            removeLeaves(root.right, target);
            if (root.right.val == 0) {
                root.right = null;
            }
        }
        if (root.val == target && root.right == null && root.left == null) {
            root.val = 0;
        }
    }
}
