package Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BasicTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(4);
        root.right = new TreeNode(18);
        root.right.right = new TreeNode(71);
        root.right.left = new TreeNode(98);
        root.left.left = new TreeNode(28);
        
    }
    public static TreeNode findLeftMost(TreeNode root){
        if( root == null ) return null;
        if( root.left == null ) return root;
        
        return findLeftMost(root.left);
    }

    public static void PreorderTraversal(TreeNode root){
        if( root == null ) return;
        PreorderTraversal(root.left);
        System.out.print(root.data+" ");
        PreorderTraversal(root.right);
    }
    public static void InorderTraversal(TreeNode root){
        if( root == null ) return;
        System.out.print(root.data+" ");
        InorderTraversal(root.left);
        InorderTraversal(root.right);
    }
    public static void PostorderTraversal(TreeNode root){
        if( root == null ) return;
        PostorderTraversal(root.left);
        PostorderTraversal(root.right);
        System.out.print(root.data+" ");
    }
    public static int heightOfTree(TreeNode root){
        if( root == null ) return 0;

        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);

        return Math.max(left, right)+1;
    }
    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> qu = new LinkedList<>();

        qu.add(root);
        qu.add(null);
        while( qu.isEmpty() == false ){
            TreeNode curr = qu.poll();
            if( curr == null ){
                if( !qu.isEmpty() ){
                    qu.add(null);
                }
                System.out.println();
                continue;
            }
            System.out.print(curr.data+" ");
            if( curr.left != null ){
                qu.add(curr.left);
            }
            if( curr.right != null ){
                qu.add(curr.right);
            }

        }

    }
    public static int sizeOfBinaryTree(TreeNode root){
        if( root == null ) return 0;

        int leftSize = sizeOfBinaryTree(root.left);
        int rightSize = sizeOfBinaryTree(root.right);

        return leftSize+rightSize+1;
    }
    public static int maxInBinaryTree(TreeNode root){
        if( root == null ) return Integer.MIN_VALUE;

        int maxData = root.data;
        int left = maxInBinaryTree(root.left);
        if( left > maxData ){
            maxData = left;
        }
        int right = maxInBinaryTree(root.right);
        if( right > maxData ){
            maxData = right;
        }

        return maxData;

    }
    public static int isBalanced(TreeNode root){
        if( root == null ) return 0;
        int left = isBalanced(root.left);
        int right = isBalanced(root.right);
        if( left == -1 || right == -1 ) return -1;

        int absDifference = Math.abs(right-left);

        return absDifference > 1 ? -1 : Math.max(left,right)+1;
    }
}
