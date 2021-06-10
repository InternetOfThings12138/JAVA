import java.util.HashMap;
import java.util.Map;

public class Solution106 {
    public class TreeNode {
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
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
    public TreeNode myBuildTree(int left,int right){
        if(left>right){
            return null;
        }
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);
        int index = indexMap.get(root_val);
        post_idx--;
        root.right = myBuildTree(index+1,right);
        root.left = myBuildTree(left,index-1);
        return root;

    }
    public TreeNode buildTree(int[] inorder, int[] postorder){
        this.postorder = postorder;
        this.inorder = inorder;
        post_idx = postorder.length - 1;
        int idx = 0;
        for(Integer val:inorder){
            indexMap.put(val,idx++);
        }
        return myBuildTree(0,post_idx);
    }
}
