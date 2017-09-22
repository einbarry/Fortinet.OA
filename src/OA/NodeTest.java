package OA;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NodeTest {
	Node n1;
	Node n2;
	Node n3;
	Node n4;
	Node n5;
	
	@Before 
	public void setUp() {
		 n1 = new Node(1);
		 n2 = new Node(2);
		 n3 = new Node(3);
		 n4 = new Node(4);
		 n5 = new Node(5);
	}
	
	@Test
	public void testNull() {
		Node n1 = null;
		Node res = Node.reverse(n1);
		assertSame(null, res);
	}
	@Test
	public void testOneNode() {
		Node n1 = new Node(1);
		Node NewHead = Node.reverse(n1);
		assertSame(n1, NewHead);
		assertSame(null, NewHead.next);
	}
	@Test
	public void testNumberOfNodeEven() {
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		Node NewHead = Node.reverse(n1);
		Node cur = NewHead;
		assertSame(n4, cur);
		cur = cur.next;
		assertSame(n3, cur);
		cur = cur.next;
		assertSame(n2, cur);
		cur = cur.next;
		assertSame(n1, cur);
		cur = cur.next;
		assertSame(null, cur);
		
	}
	@Test
	public void testNumberOfNodeOdd() {
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		Node NewHead = Node.reverse(n1);
		Node cur = NewHead;
		assertSame(n5, cur);
		cur = cur.next;
		assertSame(n4, cur);
		cur = cur.next;
		assertSame(n3, cur);
		cur = cur.next;
		assertSame(n2, cur);
		cur = cur.next;
		assertSame(n1, cur);
		cur = cur.next;
		assertSame(null, cur);
		
	}
	
}
