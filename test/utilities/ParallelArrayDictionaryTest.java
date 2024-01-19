package utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest {
	@Test
	void testParallelArrayDictionary() {
		ParallelArrayDictionary<String, Integer> dictionary = new ParallelArrayDictionary<>();
		assertNotNull(dictionary);
		assertTrue(dictionary.isEmpty());
		assertEquals(0, dictionary.size());
	}

	@Test
	void testGet() {
		ParallelArrayDictionary<String, Integer> dictionary = new ParallelArrayDictionary<>();
		dictionary.put("one", 1);
		assertEquals(1, dictionary.get("one").intValue());
		assertNull(dictionary.get("nonexistant"));
	}

	/**
	 * 
	 */
	@Test
	void testPut() 
	{
		ParallelArrayDictionary<String, Integer> dictionary = new ParallelArrayDictionary<>();
		assertNull(dictionary.put("two", 2));
		assertEquals(2, dictionary.put("two", 2).intValue());
		assertEquals(2, dictionary.get("two").intValue());
	}

	@Test
	void testRemove() 
	{
		ParallelArrayDictionary<String, Integer> dictionary = new ParallelArrayDictionary<>();
		dictionary.put("three", 3);
		assertEquals(3, dictionary.remove("three").intValue());
		assertNull(dictionary.remove("nonexistant"));
	}

	// @Test
	// void testPutAll() 
	// {
	// 	ParallelArrayDictionary<String, Integer> dictionary = new ParallelArrayDictionary<>();
	// 	dictionary.put("four", 4);

	// 	ParallelArrayDictionary<String, Integer> oldDictionary = new ParallelArrayDictionary<>();

	// }

	@Test
	void testClear() {
		ParallelArrayDictionary<String, Integer> dictionary = new ParallelArrayDictionary<>();
		dictionary.put("seven", 7);
		dictionary.clear();
	}
}
