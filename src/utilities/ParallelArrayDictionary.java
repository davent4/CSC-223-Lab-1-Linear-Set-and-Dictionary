package utilities;
/**
 * A mapping system that correlates a unique key to a possibly non-unique value
 *  
 * @author Sage DeVore and Della Avent
 * @date 01/19/2024
 */

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ParallelArrayDictionary<Key, Value> implements Map<Key, Value>
{
	protected ArraySet<Key>    _keys;
	protected ArrayList<Value> _values;

	/**
	 * default constructor
	 */
	public ParallelArrayDictionary()
	{
		_keys = new ArraySet<Key>();
		_values = new ArrayList<Value>();
	}

	/**
	 * returns size of the set
	 * @return int
	 */
	@Override
	public int size() 
	{
		return _keys.size();
	}

	/**
	 * checks whether there is anything in set
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() 
	{
		return _keys.isEmpty();
	}

	/**
	 * checks if a given key is in the set
	 * @param object key
	 * @return boolean
	 */
	@Override
	public boolean containsKey(Object key) 
	{
		return _keys.contains(key);
	}

	/**
	 * checks if a given value is in the list
	 * @param object value
	 * @return boolean
	 */
	@Override
	public boolean containsValue(Object value) 
	{
		return _values.contains(value);
	}

	/**
	 * returns the value of a specified key, or null if its not there
	 * @param object key
	 * @return Value
	 */
	@Override
	public Value get(Object key) 
	{
		int index = _keys.indexOf(key);
		if (index != -1) {
			return _values.get(index);
		}
		return null;
	}
	
	/**
	 * adds the given key at a specified value if key isn't already present
	 * @param Key key
	 * @param Value value
	 * @return Value
	 */
	@Override
	public Value put(Key key, Value value) 
	{
		int index = _keys.indexOf(key);
		if (index != -1) {
			return _values.set(index, value);
		} else {
			_keys.add(key);
			_values.add(value);
			return null;
		}
	}

	/**
	 * removes the specified key 
	 * @param Object key
	 * @return Value
	 */
	@Override
	public Value remove(Object key) 
	{
		int index = _keys.indexOf(key);
		if (index != -1) {
			_keys.remove(index);
			return _values.remove(index);
		}
		return null;
	}

	/**
	 * adds given map to this map
	 * @param map m
	 */
	@Override
	public void putAll(Map<? extends Key, ? extends Value> m) 
	{
		for (Map.Entry<? extends Key, ? extends Value> entry : m.entrySet()) {
			put (entry.getKey(), entry.getValue());
		}
	}

	/**
	 * empties the set
	 */
	@Override
	public void clear() 
	{
		_keys.clear();
		_values.clear();
	}

	/**
	 * returns the set of key values
	 * @return Set<Key>
	 */
	@Override
	public Set<Key> keySet() 
	{
		return _keys;
	}

	/**
	 * returns the list of values
	 * @return Collection<Value>
	 */
	@Override
	public Collection<Value> values() 
	{
		return _values;
	}

	/**
	 * returns the entire map with both key and values
	 * @return Set<Entry<Key, Value>>
	 */
	@Override
	public Set<Entry<Key, Value>> entrySet() 
	{
		Set<Entry<Key, Value>> set = new ArraySet<>();
		for (int i = 0; i < _keys.size(); i++) {
			set.add(new AbstractMap.SimpleEntry<Key,Value>(_keys.get(i), _values.get(i)));
		}
		return set;
	}
}

