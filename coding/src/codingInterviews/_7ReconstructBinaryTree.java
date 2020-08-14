package codingInterviews;


import basic.BinaryTreeWalk;

public class _7ReconstructBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null)
            return null;
        return reConstructBinaryTree(pre, in, 0, pre.length, 0, in.length);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int[] in,
                                       int preStart, int preEnd, int inStart, int inEnd){
        int root = pre[preStart];
        TreeNode node = new TreeNode(root);
        int leftChildLength = 0;

        // 中序数组里找root
        for(int i=inStart; i<inEnd; i++){
            if(in[i] == root){
                leftChildLength = i - inStart;
                break;
            }
        }
        int rightChildLength = preEnd - preStart - 1 - leftChildLength;

        if(leftChildLength != 0) {
            node.left = reConstructBinaryTree(pre, in, preStart + 1, preStart + 1 + leftChildLength,
                            inStart, inStart + leftChildLength);
        }
        if(rightChildLength != 0) {
            node.right = reConstructBinaryTree(pre, in, preStart + 1 + leftChildLength, preEnd,
                    inStart + leftChildLength + 1, inStart + leftChildLength + 1 + rightChildLength);
        }
        return node;

    }

    // 为了验证输出的前序遍历
    void printByPreorder(TreeNode root){
        System.out.println(root.val);
        if(root.left != null)
            printByPreorder(root.left);
        if(root.right != null)
            printByPreorder(root.right);
    }

    // 为了验证输出的中序遍历
    void printByInorder(TreeNode root){
        if(root.left != null)
            printByInorder(root.left);
        System.out.println(root.val);
        if(root.right != null)
            printByInorder(root.right);
    }

    public static void main(String[] argvs){
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};

        _7ReconstructBinaryTree s = new _7ReconstructBinaryTree();
        TreeNode result = s.reConstructBinaryTree(pre, in);
        s.printByPreorder(result);
        s.printByInorder(result);
    }
}
