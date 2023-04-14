package BinarySearchTree;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

import Tree.*;

public class BinarySearchTree {
    static TreeNode prev,first,second;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(25);
        root.left = new TreeNode(15);
        root.left.left = new TreeNode(35);
        root.left.left.left = new TreeNode(40);
        root.left.right = new TreeNode(20);
        root.left.right.right = new TreeNode(75);
        root.left.right.right.right = new TreeNode(80);

        verticalSum(root);
    }
    public static void verticalSum(TreeNode root){
        HashMap<Integer,Integer> map = new HashMap<>();
        int horiz = 0;
        verticalSumInternal(root,horiz,map);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for( int key : map.keySet() ){
            if( key < min ){
                min = key;
            }
            if( key > max ){
                max = key;
            }
        }
        for( int i = min;i<=max;i++ ){
            System.out.printf("%d ", map.get(i));
        }
    }
    public static void verticalSumInternal(TreeNode root,int horiz,HashMap<Integer,Integer> map){
        if( root == null ) return;

        verticalSumInternal(root.left,horiz-1,map);
        map.put(horiz, map.getOrDefault(horiz, 0) + root.data );
        verticalSumInternal(root.right,horiz+1,map);

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
    public static boolean isBST(TreeNode root, int min , int max){
        return isBSTInternal(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public static boolean isBSTInternal(TreeNode root, int min,int max){
        if( root == null ) return true;

        return ( root.data > min && root.data < max && isBSTInternal(root.left, min, root.data) && isBSTInternal(root.right, root.data, max) );
    }
    public static void fixBSTTwo(TreeNode root){

        fixBSTTwoIncorrect(root);
        int data = first.data;
        first.data = second.data;
        second.data = data;
    }
    public static void fixBSTTwoIncorrect(TreeNode root){
        if( root == null ) return;

        fixBSTTwoIncorrect(root.left);
        if( prev != null && root.data < prev.data ){
            if( first == null ) first = prev;
            second = root;
        }
        prev = root;
        fixBSTTwoIncorrect(root.right);
    }

}
