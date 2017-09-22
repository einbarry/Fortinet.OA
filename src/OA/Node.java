package OA;

public class Node {
	Node next;
	int value;
	public Node(int val) {
		value = val;
	}
	
	public  static Node reverse(Node head) {
		// sanity check
		if(head == null ) {
			return head;
		}
		Node pre = null;
		Node cur = head;
		Node next;
		while(cur != null) { // termiantion condition : while cur node is null that mean we reach the end of list
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	//Time Complexity: O(n) n equals to numbers of node in the list
	//Space Complexity: O(1) only use constant space
	
	//Recursive way
	public static Node reverseRe(Node head) {
		// base case: head == null or only have one node we don't need to reverse
		if(head == null || head.next == null) {
			return head;
		}
		// we use same logic to slove the smaller question
		Node newHead = reverse(head.next);
		// what we do on current level is to point the next node of cur  to cur
		head.next.next = head;
		head.next = null;
		return newHead;
	}

	//Time Complexity: O(n) n equals to numbers of node in the list
	//Space Complextity: O(h) the max number of call stack is the height of the tree h
}
