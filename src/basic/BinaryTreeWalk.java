package basic;

public class BinaryTreeWalk {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    void printByPreorder(TreeNode root){
        System.out.println(root.val);
        if(root.left != null)
            printByPreorder(root.left);
        if(root.right != null)
            printByPreorder(root.right);
    }

    public static void main(String[] argv){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BinaryTreeWalk binaryTreeWalk = new BinaryTreeWalk();
        binaryTreeWalk.printByPreorder(root);
    }
}
