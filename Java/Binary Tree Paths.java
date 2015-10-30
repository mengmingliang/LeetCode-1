/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]


Tags: Tree, Depth-first Search
Similar Problems: (M) Path Sum II


*/

/*
Just DFS .
remember to remove end item on the list when backtracking
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<String>();
        if (root == null) {
            return rst;
        }   
        ArrayList<String> list = new ArrayList<String>();
        DFS(root, list, rst);
        return rst;
    }
    public void DFS(TreeNode node, ArrayList<String> list, List<String> rst) {
        list.add(node.val+"");
        if(node.left == null && node.right == null) {
            String str = "";
            for (String s : list) {
                str += s + "->";
            }
            rst.add(str.substring(0, str.length() - 2));
            return;
        }
        if (node.left != null) {
            DFS(node.left, list, rst);
            list.remove(list.size() - 1);
        }
        if (node.right != null) {
            DFS(node.right, list, rst);
            list.remove(list.size() - 1);
        }
    }
}








