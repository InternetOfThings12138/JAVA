import javax.swing.tree.TreeNode;

public class Solution101 {
    public boolean isSymmetric1(TreeNode root){
        return check(root,root);
    }
    public boolean check(TreeNode p,TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p ==null && q == null){
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right,q.left);
    }

    public boolean isSymmetric2(TreeNode root){
        if(root==null || (root.left==null && root.right==null)){
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root.left);
        queue.add(root.right);
        while(queue.size()>0){
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();
            if(left==null && right==null){
                continue;
            }
            if(left==null || right==null){
                return false;
            }
            if(left.val !=right.val){
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);

        }
        return true;
    }

}
