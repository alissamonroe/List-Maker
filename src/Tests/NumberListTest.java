package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ListProject.NumberList;

public class NumberListTest {
	
	/** Pointers to the class we are testing from */
	private NumberList numList;
	private NumberList numList2;
	private NumberList numList3;
	private NumberList numList4;
	
	/** To set things up in place of a constructor */
	@Before
	public void setUp() {
		numList = new NumberList();
		numList.addTo(1);
		numList.addTo(10);
		numList.addTo(2.5);
		numList.addTo(1000);
		
		numList2 = new NumberList();
		numList2.addTo(-0.5);
		numList2.addTo(-0.9);
		
		numList3 = new NumberList();
		numList3.addTo(6000.23);
		numList3.addTo(10);
		numList3.addTo(1000);
		
		numList4 = new NumberList();
		numList4.addTo(10);
		numList4.addTo(10);
		numList4.addTo(10);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testNull() {
		thrown.expect(NullPointerException.class);
		numList.addTo(null);
	}
	
	@Test
	public void testAddTo() {
		assertEquals("Adding to the list failed", numList.printList(), "1, 10, 2.5, 1000");
	}
	
	@Test
	public void testAddTo2() {
		assertEquals("Adding to the list failed", numList4.printList(), "10, 10, 10");
	}
	
	@Test
	public void testAddTo3() {
		assertEquals("Adding to the list failed", numList2.printList(), "-0.5, -0.9");
	}
	
	@Test
	public void testLargest() {
		assertEquals("Finding the largest number failed", numList.largestNum(), 1000);
	}
	
	@Test
	public void testLargest2() {
		assertEquals("Finding the largest number failed", numList2.largestNum(), -0.5);
	}
	
	@Test
	public void testLargest3() {
		assertEquals("Finding the largest number failed", numList3.largestNum(), 6000.23);
	}
	
	@Test
	public void testLargest4() {
		assertEquals("Finding the largest number failed", numList4.largestNum(), 10);
	}
	
}
