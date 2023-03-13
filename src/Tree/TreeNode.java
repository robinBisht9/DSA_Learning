package Tree;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode next;
    TreeNode prev;

    public TreeNode(){
         this.left = null;
         this.right = null;
    }
    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
   }
    
   
}
