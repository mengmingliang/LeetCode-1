/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

Tags:  Tree Breadth-first Search
Similar Problems: (M) Binary Tree Zigzag Level Order Traversal, (E) Binary Tree Level Order Traversal II, (E) Minimum Depth of Binary Tree

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
/*
Thoughts:
Looks like BFS. put root in a queue, then put left, right in the queue.
Process the queue until it runs out.

Note: 
Queue: offer()


*/
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (root == null) {
        	return rst;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
	    	int size = queue.size();//Becareful with fixed size
	    	List<Integer> list = new ArrayList<Integer>();
	    	for (int i = 0; i < size; i++) {
	    		TreeNode node = queue.poll();
		    	list.add(node.val);
		    	if (node.left != null) {
		    		queue.offer(node.left);
		    	}
		    	if (node.right != null) {
		    		queue.offer(node.right);
		    	}
	    	}
	    	rst.add(list);
        }
        return rst;
    }
}







