/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Tags: Design

*/
/*
It looks like we need to do some design, according to (http://www.cnblogs.com/yuzhangcmu/p/4113462.html). Though, the solution's concept is quite similar as attempt1.

1. The design uses HashMap, and 2-way LinkedList. Map<key, LinkNode>
2. Use two dummy node: head and tail. When add/remove nodes, we are add/remove nodes in between head and tail.
	So. head.next is our real 1st element
	andd tail.pre is our real last element

Note:
Be careful: when removing a node due to capacity issue, remember to remove both 1st node(head.next) and the corresponding entry in the map: map.remove(head.next.key)
*/
public class LRUCache {
	private class LinkNode {
		int key;
		int val;
		LinkNode pre = null;
		LinkNode next = null;
		LinkNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

    private int cap;
    private HashMap<Integer, LinkNode> map;
    private LinkNode head;
    private LinkNode tail;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<Integer, LinkNode>();
        this.head = new LinkNode(-1, -1);
        this.tail = new LinkNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
    	if (map.containsKey(key)) {
    		LinkNode temp = map.get(key);
    		moveUsedToTail(temp);
    		return temp.val;
    	} else {
    		return -1;
    	}
    }
    
    public void set(int key, int value) {
    	if (map.containsKey(key)) {
    		LinkNode temp = map.get(key);
    		temp.val = value;
    		moveUsedToTail(temp);	
    	} else {
			if (map.size() >= cap) {
        		map.remove(head.next.key);
        		removeHead();
        	}
        	LinkNode newNode = new LinkNode(key, value);
	        addTail(newNode);
	        map.put(key, newNode);
    	}
    }
    
    public void moveUsedToTail(LinkNode node) {
   		removeNode(node);
    	addTail(node);
   	}

   	public void removeHead(){//O(1)
   		removeNode(head.next);
   	}
   	public void addTail(LinkNode node){//O(1)
   		tail.pre.next = node;
   		node.pre = tail.pre;
   		node.next = tail;
   		tail.pre = node;
   	}
   	public void removeNode(LinkNode node) {//O(1)
   		node.pre.next = node.next;
   		node.next.pre = node.pre;
   	}
}


/*
First Attempt: time exceeds

Thoughts:
Easy to implement: cache the least-added item. However, we are looking for the cache of 'leaset-recently-used item'.

'used' means the get() method:
whenever get, remove that key from the queue, and move that key to top.

Time Cost: O(n) on get(), set()


*/

public class LRUCache {
    private int cap;
    private HashMap<Integer, Integer> map;
    private LinkedList<Integer> queue;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<Integer, Integer>();
        this.queue = new LinkedList<Integer>();
    }
    
    public int get(int key) {
    	if (map.containsKey(key)) {
    		moveUsedToTop(key);
    		return map.get(key);
    	} else {
    		return -1;
    	}
    }
    
    public void set(int key, int value) {
    	if (map.containsKey(key)) {
    		moveUsedToTop(key);
    		map.put(key, value);
    	} else {
			if (queue.size() >= cap) {
        		map.remove(queue.poll());
        	}
	        queue.offer(key);
	        map.put(key, value);
    	}
        
    }
    //O(n)
    public void moveUsedToTop(int key) {
    	for (int i = 0; i < queue.size(); i++) {
			if (queue.get(i) == key) {
				queue.remove(i);
				queue.offer(key);
				break;
			}
		}
    }
}