/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:
	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

Tags: Tree Depth-first Search
Similar Problems: (M) Binary Tree Inorder Traversal

*/

/*Current solution: Do the same as before, however, make sure to add MIN and MAX in the recursive funtion

Note: becareful with Integer MAX and MIN. Use Long MAX and MIN
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
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean check(TreeNode node, long MIN, long MAX) {
    	if (node == null) {
    		return true;
    	}
    	if (node.val > MIN && node.val < MAX &&
    		check(node.left, MIN, node.val) &&
    		check(node.right, node.val, MAX)) {
    		return true;
    	} else {
    		return false;
    	}
    }
}



/*Older Solution: does not work anymore for case: {10,5,15,#,#,6,20}. The original judge of lintcode was incorrect*/
/*
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        
        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);
        
        return left && right;
    }
}
*/