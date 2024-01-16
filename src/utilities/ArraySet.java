package utilities;
/**
 *  An ordered data structure that guarantees uniqueness 
 *  
 * <p>Bugs: no tests yet so no clue plus its not done
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

	public ArraySet()
	{
		_list = new ArrayList<E>();
	}

	@Override
	public boolean add(E e) 
	{
		if(contains(e)) return false;
		_list.add(e);
		return true;
	}

	@Override
	public void add(int index, E element) 
	{
		if(!contains(element)) _list.add(index, element);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) 
	{
		//TODO idk how to do for each loop like this, no clue if it's right
		for(E e : c) {
			if(contains(e)) return false;
		}
		_list.addAll(c);
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) 
	{
		//TODO see method above
		for(E e : c) {
			if(contains(e)) return false;
		}
		_list.addAll(index, c);
		return true;
	}

	/**
	 * calls a delegate method
	 */
	@Override
	public int size() {
		return _list.size();
	}

	/**
	 * calls a delegate method
	 */
	@Override
	public boolean isEmpty() {
		return _list.isEmpty();
	}

	/**
	 * calls a delegate method
	 */
	@Override
	public boolean contains(Object o) {
		return _list.contains(o);
		//TODO we could prob make more efficient if it's sorted but idk
	}

	/**
	 * calls a delegate method
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		return _list.containsAll(c);
	}

	/**
	 * calls a delegate method
	 */
	@Override
	public Iterator<E> iterator() {
		return _list.iterator();
	}

	/**
	 * calls a delegate method
	 */
	@Override
	public Object[] toArray() {
		return _list.toArray();
	}

	/**
	 * calls a delegate method
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		return _list.toArray(a);
	}

	/** (as of now)
	 * calls a delegate method
	 */
	@Override
	public boolean remove(Object o) {
		/*TODO do we need to make this one more efficient bc sorted? but removing
		 * a specific object will still leave it sorted
		 */
		return _list.remove(o);
	}

	/**
	 * calls a delegate method
	 */
	@Override
	public E remove(int index) {
		return _list.remove(index);
	}

	/** TODO (as of now)
	 * calls a delegate method
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		// same question as other remove
		return _list.removeAll(c);
	}

	/** TODO (as of now)
	 * calls a delegate method
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		//does it need to be sorted again after this?
		return _list.retainAll(c);
	}

	/**
	 * calls a delegate method
	 */
	@Override
	public void clear() {
		_list.clear();
	}

	/**
	 * calls a delegate method
	 */
	@Override
	public E get(int index) {
		//TODO we could prob make more efficient since it's sorted?? do we care??
		return _list.get(index);
	}

	/**
	 * calls a delegate method
	 */
	@Override
	public E set(int index, E element) {
		return _list.set(index, element);
	}

	/**
	 * calls a delegate method
	 */
	@Override
	public int indexOf(Object o) {
		return _list.indexOf(o);
	}

	/** (right now)
	 * calls a delegate method
	 */
	@Override
	public int lastIndexOf(Object o) {
		//TODO redundant bc its a set; should it throw exception?
		return _list.lastIndexOf(o);
	}

	/**
	 * calls a delegate method
	 */
	@Override
	public ListIterator<E> listIterator() {
		return _list.listIterator();
	}

	/**
	 * calls a delegate method
	 */
	@Override
	public ListIterator<E> listIterator(int index) {
		return _list.listIterator(index);
	}

	/**
	 * calls a delegate method
	 */
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return _list.subList(fromIndex, toIndex);
	}


}
