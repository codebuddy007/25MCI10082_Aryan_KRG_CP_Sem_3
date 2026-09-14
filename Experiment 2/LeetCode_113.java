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
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        sum(root,targetSum,ans,new ArrayList<>(),0);
        return ans;
        
    }
    void sum(TreeNode root, int targetSum, List<List<Integer>> ans , List<Integer> curr, int totalSum){
        if(root == null) return ;
        totalSum += root.val;
        curr.add(root.val);

        if( root.left == null && root.right == null && totalSum == targetSum){
            ans.add(new ArrayList<>(curr));
        }

        sum(root.left,targetSum,ans,curr,totalSum);
        sum(root.right,targetSum,ans,curr,totalSum);

        curr.remove(curr.size()-1);
    }
}
