/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Tags: Divide and Conquer, Linked List, Heap
Similar Problems: (E) Merge Two Sorted Lists, (M) Ugly Number II
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*First attempt: 
1. use a PriorityQueue to store initial node
2. Keep adding node.next into queue while processing the queue. Untill the queue is done.
Complexty: O(k) + O(k*n) = O(kn); k = k lists, n = max list length;
While, queue.offer() and queue.poll() both takes O(logN)
Overall explicitly: O(kn * logN) = O(knLogN)
*/
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
    	ListNode node = new ListNode(0);
    	ListNode dummy = node;
        if (lists == null || lists.length == 0) {
        	return dummy.next;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
        	public int compare(ListNode a, ListNode b){
        		return a.val - b.val;
        	}
        });
        //Populate queue with initial node with correct ordering
        for (int i = 0; i < lists.length; i++) {
        	if(lists[i] != null) {
        		queue.offer(lists[i]);
        	}
        }

        //add to rst
        while (!queue.isEmpty()) {
        	ListNode temp = queue.poll();
        	node.next = temp;
        	if (temp.next != null) {
        		queue.offer(temp.next);
        	}
        	node = node.next;
        }
        return dummy.next;
    }
}