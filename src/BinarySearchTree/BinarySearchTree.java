package BinarySearchTree;
import Tree.*;

public class BinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right = new TreeNode(28);
        root.right.right = new TreeNode(30);
        root.right.left = new TreeNode(25);

        root = insertInBST(root, 14);
        root = deleteKeyInBST(root, 10);

        solution();
    }

    public static boolean searchInBST(TreeNode root,int data){
        if( root == null ) return false;
        if( root.data == data ) return true;
        else if( data < root.data ){
            return searchInBST(root.left, data);
        }
        else{
            return searchInBST(root.right, data);
        }
    }
    public static TreeNode insertInBST(TreeNode root,int data){
        TreeNode temp = root;
        TreeNode prev = root;
        while( temp != null ){
            prev = temp;
            if( data < temp.data ){
                temp = temp.left;
            }
            else if ( data > temp.data ){
                temp = temp.right;
            }
            else{
                return root;
            }
        }
        if( prev == null ){
            root = new TreeNode(data);
        }
        else if( data < prev.data ){
            prev.left = new TreeNode(data);
        }
        else{
            prev.right = new TreeNode(data);
        }
        return root;
    }
    public static TreeNode deleteKeyInBST( TreeNode root,int data){
        if( root == null ) return root;
        if( data < root.data ){
            root.left = deleteKeyInBST(root.left, data);
        }
        else if( data > root.data ){
            root.right = deleteKeyInBST(root.right, data);
        }
        else{
            if( root.left == null ) return root.right;
            else if( root.right == null ) return root.left;
            else{
                TreeNode succ = getSuccessor(root);
                root.data = succ.data;
                root.right = deleteKeyInBST(root.right, succ.data);
            }
        }
        return root;

    }
    public static TreeNode getSuccessor( TreeNode root){
        TreeNode curr = root.right;
        while( curr!=null && curr.left !=null ){
            curr = curr.left;
        }
        return curr;
    }
    public static void sortedArrayToBST(int[] nums){
        TreeNode root = toBST(nums, 0, nums.length-1);
        BasicTree.levelOrderTraversal(root);
    }
    public static TreeNode toBST(int[] nums, int l, int r){
        if( l > r ){
            return null;
        }
        if( l == r ){
            return new TreeNode(nums[l]);
        }
        int mid = (l+r)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums,l,mid-1);
        root.right = toBST(nums,mid+1,r);
        return root;
    }
}
