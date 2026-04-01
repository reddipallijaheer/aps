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
        ArrayList<List<Integer>> li = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        dfs(root,targetSum,0,li,a);
        return li;
    }
    void dfs(TreeNode root, int targetSum,int sum,List<List<Integer>> li,List<Integer> a ){
        if(root==null){
            return;
        }
        sum +=root.val;
        a.add(root.val);
        if(root.left==null&&root.right==null && sum==targetSum){
            li.add(new ArrayList<>(a));
        }
        dfs(root.left,targetSum,sum,li,a);
        dfs(root.right,targetSum,sum,li,a);
        a.remove(a.size()-1);
    }
}