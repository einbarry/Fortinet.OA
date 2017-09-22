package OA;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class Q3Test {
	static List<Integer> list = new ArrayList<>();

	@BeforeClass
	public static void setUp(){
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(5);
		// make a original list {2,2,3,4,5,5},sum = 21, can be divided by 3.{3,4} {2,5} {2,5}
	}
	@Test
	// test null and empty list
	public void testSeparate() {
		List<Integer> cur = null;
		List<Integer> cur2 = new ArrayList<>();
		boolean res = Q3.separate(cur, 3);
		boolean res2 = Q3.separate(cur2, 3);
		assertFalse(res);
		assertFalse(res2);
	}
	
	@Test
	public void testSeparate1() {
		boolean res = Q3.separate(list, 3);
		assertTrue(res);
	}
	
	@Test
	public void testSeparate2() {
		// add 1, make the list to {1,2,2,3,4,5,5}, can be divided by 2
		list.add(1);
		boolean res = Q3.separate(list, 2);
		list.remove(list.size() - 1);
		assertTrue(res);
	}
	
	@Test
	// test one element,split by 1
	public void testSeparate3() {
		List<Integer> cur = new ArrayList<>();
		cur.add(1);
		boolean res = Q3.separate(list, 1);
		assertTrue(res);
	}
	
	@Test
	// test one element,split by 2
	public void testSeparate4() {
		List<Integer> cur = new ArrayList<>();
		cur.add(1);
		boolean res = Q3.separate(cur, 2);
		assertFalse(res);
	}
	
	@Test
	// test ten elements which are all one ,split by 10
	public void testSeparate5() {
		List<Integer> cur = new ArrayList<>();
		for(int i = 1; i <=10; i++) {
			cur.add(1);
		}
		
		boolean res = Q3.separate(cur, 10);
		assertTrue(res);
	}

}
