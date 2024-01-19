package utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{
	@Test
	void testParallelArrayDictionary() {
		ParallelArrayDictionary<String, Integer> dictionary = new ParallelArrayDictionary<>();
		assertNotNull(dictionary);
		assertTrue(dictionary.isEmpty());
		assertEquals(0, dictionary.size());
	}
	
	@Test
	void testGet()
	{
	}

	@Test
	void testPut()
	{
	}

	@Test
	void testRemove()
	{
	}

	@Test
	void testPutAll()
	{
	}

	@Test
	void testClear()
	{
	}
}
