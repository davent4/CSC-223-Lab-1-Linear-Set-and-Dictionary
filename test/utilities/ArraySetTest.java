package utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ArraySetTest
{

	
	@Test
	void testArraySetCollectionOfE()
	{
		ArraySet<String> stringSet = new ArraySet<String>(Arrays.asList("a", "b", "c"));
		assertEquals(stringSet.size(), 3);
		assertFalse(stringSet.add("a"));
		assertFalse(stringSet.add("c"));
		assertTrue(stringSet.add("d"));
		
		ArraySet<Integer> intSet = new ArraySet<Integer>(Arrays.asList(null, null, 3));
		assertEquals(intSet.size(), 2);
		
	}

	@Test
	void testAddE()
	{
		ArraySet<Integer> intSet = new ArraySet<Integer>();
		
		assertTrue(intSet.add(1));
		assertFalse(intSet.add(1));
		assertTrue(intSet.add(null));
		
		ArraySet<String> stringSet = new ArraySet<String>();
		
		assertTrue(stringSet.add(null));
		assertTrue(stringSet.add(""));
		assertTrue(stringSet.add("hello"));
		assertFalse(stringSet.add("hel" + "lo"));
	}
	
	@Test
	void testAddEIndex()
	{
		ArraySet<Integer> set = new ArraySet<Integer>(Arrays.asList(2, 3));
		
		set.add(0, 1);
		assertEquals(set.toString(), "[1, 2, 3, ]");
		
		set.add(0, 1);
		assertEquals(set.toString(), "[1, 2, 3, ]");
		
		set.add(3, 4);
		assertEquals(set.toString(), "[1, 2, 3, 4, ]");
		
		set.add(2, 8);
		assertEquals(set.toString(), "[1, 2, 8, 3, 4, ]");
		
		set.add(10, 8);
		set.add(-1, 8);
		assertEquals(set.toString(), "[1, 2, 8, 3, 4, ]");
		
		set.add(0, null);
		assertEquals(set.size(), 6);
	}

	@Test
	void testAddAllCollectionOfQextendsE()
	{
		ArraySet<String> set = new ArraySet<String>();
		
		assertTrue(set.addAll(new ArrayList<String>(Arrays.asList("a", "b", "c"))));
		assertFalse(set.addAll(new ArrayList<String>(Arrays.asList("a", "b", "c"))));
		assertTrue(set.addAll(new ArrayList<String>(Arrays.asList("", "", ""))));
		assertTrue(set.addAll(new ArrayList<String>(Arrays.asList(null, null, null))));
		assertFalse(set.addAll(new ArrayList<String>()));
		assertFalse(set.addAll(null));
		assertFalse(set.addAll(new ArrayList<String>(Arrays.asList("a", "a", "a"))));
		assertTrue(set.addAll(new ArrayList<String>(Arrays.asList("d", "d", "d"))));
		
		//checks that everything is added only once
		assertEquals(set.size(), 6);
		
		assertTrue(set.addAll(new ArrayList<String>(Arrays.asList("e"))));
		assertFalse(set.addAll(set));
	}
	
	@Test
	void testAddAllIntCollectionOfQextendsE()
	{	
		ArraySet<String> set = new ArraySet<String>(Arrays.asList("d", "e", "g"));
		
		assertTrue(set.addAll(0, new ArrayList<String>(Arrays.asList("a", "b", "c"))));
		assertFalse(set.addAll(0, new ArrayList<String>(Arrays.asList("a", "b", "c"))));
		assertTrue(set.addAll(6, new ArrayList<String>(Arrays.asList("h", "i", "j"))));
		assertTrue(set.addAll(5, new ArrayList<String>(Arrays.asList("f"))));
		
		assertEquals(set.toString(), "[a, b, c, d, e, f, g, h, i, j, ]");
		
		assertTrue(set.addAll(0, new ArrayList<String>(Arrays.asList("", "", ""))));
		assertEquals(set.get(0), "");
		assertTrue(set.addAll(11, new ArrayList<String>(Arrays.asList(null, null, null))));
		assertEquals(set.get(11), null);
		
		assertFalse(set.addAll(0, new ArrayList<String>()));
		assertFalse(set.addAll(15, null));
		assertFalse(set.addAll(0, new ArrayList<String>(Arrays.asList("a", "a", "a"))));
		
		//checks that everything is added only once
		assertEquals(set.size(), 12);
		
		assertTrue(set.addAll(11, new ArrayList<String>(Arrays.asList("k"))));
		assertFalse(set.addAll(0, set));
		assertFalse(set.addAll(13, set));
		
		assertThrows(IndexOutOfBoundsException.class,
				() -> { set.addAll(15, new ArrayList<String>(Arrays.asList("l", "m", "n"))); }
				);
		assertThrows(IndexOutOfBoundsException.class,
				() -> { set.addAll(-1, new ArrayList<String>(Arrays.asList("l", "m", "n"))); }
				);
	}

	@Test
	void testRetainAll()
	{
		ArraySet<String> stringSet = new ArraySet<String>(Arrays.asList("a", "b", "c"));
		assertTrue(stringSet.retainAll(new ArrayList<String>(Arrays.asList("b"))));
		assertEquals(stringSet.size(), 1);
		
		ArraySet<Integer> intSet = new ArraySet<Integer>(Arrays.asList(1, 2, 3));
		assertTrue(intSet.retainAll(new ArrayList<Integer>(Arrays.asList(1, 3))));
		assertEquals(intSet.size(), 2);
		
		ArraySet<Integer> intSet2 = new ArraySet<Integer>(Arrays.asList(1, 2, 3));
		assertTrue(intSet2.retainAll(new ArrayList<Integer>(Arrays.asList(3, 3, 3))));
		assertEquals(intSet2.size(), 1);
		
		assertTrue(new ArraySet<Integer>(Arrays.asList(1, 2, 3)).retainAll(new ArrayList<Integer>()));
		assertTrue(new ArraySet<Integer>(Arrays.asList(1, 2, 3)).retainAll(new ArrayList<Integer>(Arrays.asList(4, 5, 6))));
		assertFalse(new ArraySet<Integer>(Arrays.asList(1, 2, 3)).retainAll(new ArrayList<Integer>(Arrays.asList(1, 2, 3))));
		
		assertFalse(new ArraySet<Integer>().retainAll(new ArrayList<Integer>(Arrays.asList(1, 2, 3))));
		assertFalse(new ArraySet<String>().retainAll(new ArrayList<String>(Arrays.asList(""))));
	}

	@Test
	void testRemoveAll()
	{
		//slightly altered retainAll(c) tests
		ArraySet<String> stringSet = new ArraySet<String>(Arrays.asList("a", "b", "c"));
		assertTrue(stringSet.removeAll(new ArrayList<String>(Arrays.asList("b"))));
		assertEquals(stringSet.size(), 2);
		
		ArraySet<Integer> intSet = new ArraySet<Integer>(Arrays.asList(1, 2, 3));
		assertTrue(intSet.removeAll(new ArrayList<Integer>(Arrays.asList(1, 3))));
		assertEquals(intSet.size(), 1);
		
		ArraySet<Integer> intSet2 = new ArraySet<Integer>(Arrays.asList(1, 2, 3));
		assertTrue(intSet2.removeAll(new ArrayList<Integer>(Arrays.asList(3, 3, 3))));
		assertEquals(intSet2.size(), 2);
		
		assertFalse(new ArraySet<Integer>(Arrays.asList(1, 2, 3)).removeAll(new ArrayList<Integer>()));
		assertFalse(new ArraySet<Integer>(Arrays.asList(1, 2, 3)).removeAll(new ArrayList<Integer>(Arrays.asList(4, 5, 6))));
		assertTrue(new ArraySet<Integer>(Arrays.asList(1, 2, 3)).removeAll(new ArrayList<Integer>(Arrays.asList(1, 2, 3))));
		
		assertFalse(new ArraySet<Integer>().removeAll(new ArrayList<Integer>(Arrays.asList(1, 2, 3))));
		assertFalse(new ArraySet<String>().removeAll(new ArrayList<String>(Arrays.asList(""))));
	}
}
