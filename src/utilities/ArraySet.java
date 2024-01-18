package utilities;
/**
 * A data structure that guarantees uniqueness and is indexable
 *  
 * @author Sage DeVore and Della Avent
 * @date 01/19/2024
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Spliterator;

public class ArraySet<E> implements List<E>, Set<E>
{
	protected ArrayList<E> _list;

	/**
	 * default constructor
	 */
	public ArraySet()
	{
		_list = new ArrayList<E>();
	}
	
	/**
	 * overloaded constructor
	 * creates set with collection already included
	 * @param Collection c
	 */
	public ArraySet(Collection<? extends E> c)
	{
		_list = new ArrayList<E>();
		addAll(c);
	}

	/**
	 * adds given element to end of the set
	 * @param element e
	 * @return boolean
	 */
	@Override
	public boolean add(E element) 
	{
		if(contains(element)) return false;
		_list.add(element);
		return true;
	}

	/**
	 * adds given element at given index
	 * @param element e
	 * @param int index
	 */
	@Override
	public void add(int index, E element) 
	{
		if(!contains(element)) _list.add(index, element);
	}

	/**
	 * adds given collection to end of the set
	 * @param collection c
	 * @return boolean
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) 
	{
		if(c == null) return false;
	    boolean isChanged = false;
	    for (E e : c) {
	        if (add(e)) {
	            isChanged = true;
	        }
	    }
	    return isChanged;
	}

	/**
	 * adds given collection at given index
	 * @param int index
	 * @param collection c
	 * @return boolean
	 */
	@Override
	public boolean addAll(int index, Collection<? extends E> c) 
	{
		if(c == null) return false;
	    boolean isChanged = false;
	    for (E element : c) {
	        if (!contains(element)) {
	            _list.add(index++, element);	//increment index after adding element
	            isChanged = true;
	        }
	    }
	    return isChanged;
	}

	/**
	 * returns size of the set
	 * @return int
	 */
	@Override
	public int size() 
	{
		return _list.size();
	}

	/**
	 * checks whether there is anything in set
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() 
	{
		return _list.isEmpty();
	}

	/**
	 * checks if set contains a given target
	 * @param object o
	 * @return boolean
	 */
	@Override
	public boolean contains(Object o) 
	{
		return _list.contains(o);
	}

	/**
	 * checks if set contains the given targets
	 * @param collection c
	 * @return boolean
	 */
	@Override
	public boolean containsAll(Collection<?> c) 
	{
		return _list.containsAll(c);
	}

	/**
	 * allows set to be iterated through by user
	 * @return Iterator<E>
	 */
	@Override
	public Iterator<E> iterator() 
	{
		return _list.iterator();
	}

	/**
	 * returns set as an array
	 * @return Object[]
	 */
	@Override
	public Object[] toArray() 
	{
		return _list.toArray();
	}

	/**
	 * returns set as an array given a previous array
	 * @return T[]
	 * @param T[] a
	 */
	@Override
	public <T> T[] toArray(T[] a) 
	{
		return _list.toArray(a);
	}

	/**
	 * removes a specified object from set
	 * @param object o
	 * @return boolean
	 */
	@Override
	public boolean remove(Object o) 
	{
		return _list.remove(o);
	}

	/**
	 * removes an object from set at the specified index
	 * @param int index
	 * @return E 
	 */
	@Override
	public E remove(int index) 
	{
		return _list.remove(index);
	}

	/**
	 * removes specified objects from set
	 * @param collection c
	 * @return boolean
	 */
	@Override
	public boolean removeAll(Collection<?> c) 
	{
		return _list.removeAll(c);
	}

	/**
	 * removes everything but specified objects from set
	 * @param collection c
	 * @return boolean
	 */
	@Override
	public boolean retainAll(Collection<?> c) 
	{
		return _list.retainAll(c);
	}

	/**
	 * empties the set
	 */
	@Override
	public void clear() 
	{
		_list.clear();
	}

	/**
	 * returns object at specified index
	 * @param int index
	 * @return E
	 */
	@Override
	public E get(int index) 
	{
		return _list.get(index);
	}

	/**
	 * changes the object at a specified index to the given element
	 * @param E element
	 * @param int index
	 * @return E
	 */
	@Override
	public E set(int index, E element) 
	{
		return _list.set(index, element);
	}

	/**
	 * returns the index of a specified object
	 * @param object o
	 * @return int 
	 */
	@Override
	public int indexOf(Object o) 
	{
		return _list.indexOf(o);
	}

	/**
	 * returns the last index of a specified object
	 * @param object o
	 * @return int 
	 */
	@Override
	public int lastIndexOf(Object o) 
	{
		return _list.lastIndexOf(o);
	}

	/**
	 * (From Oracle.com)
	 * Returns a list iterator over the elements in this list (in proper sequence).
	 * @return ListIterator<E>
	 */
	@Override
	public ListIterator<E> listIterator() 
	{
		return _list.listIterator();
	}

	/**
	 * (From Oracle.com)
	 * Returns a list iterator over the elements in this list starting at specified index
	 * @param int index
	 * @return ListIterator<E>
	 */
	@Override
	public ListIterator<E> listIterator(int index) 
	{
		return _list.listIterator(index);
	}

	/**
	 * returns a shorter list beginning and ending at specified index
	 * @param int fromIndex
	 * @param int toIndex
	 * @return List<E>
	 */
	@Override
	public List<E> subList(int fromIndex, int toIndex) 
	{
		return _list.subList(fromIndex, toIndex);
	}
		
	/**
	 * creates a spliterator
	 */
	@Override
	public Spliterator<E> spliterator() 
	{
		return List.super.spliterator();
	}
	
	/**
	 * returns the set as a string
	 * @return String
	 */
	@Override
	public String toString() 
	{
		if(isEmpty()) return "";
		
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < size(); i++) {
			str.append(get(i).toString());
		}

		return str.toString();
	}


}
