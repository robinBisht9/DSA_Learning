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

        BasicTree.levelOrderTraversal(root);

        System.out.println(searchInBST(root, 14));
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
}
