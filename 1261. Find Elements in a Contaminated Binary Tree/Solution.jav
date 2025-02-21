/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {


    Set<Integer> set;
    
        public FindElements(TreeNode root) {
            set= new HashSet<>();
            boolean isparentnull=false;
            construct_tree(0,root,set);
        }
        public void construct_tree(int val, TreeNode root,Set<Integer> set)
        {
            if(root==null)
            {
                return;
            }
           
           
            root.val= val;
            set.add(val);
        
            if(root.left!=null)
            {
                construct_tree(val*2+1, root.left,set);
            }
              if(root.right!=null)
            {
                construct_tree(val*2+2, root.right,set);
            }
        }
        
        public boolean find(int target) {
            return set.contains(target);
        }
    }
    
    /**
     * Your FindElements object will be instantiated and called as such:
     * FindElements obj = new FindElements(root);
     * boolean param_1 = obj.find(target);
     */