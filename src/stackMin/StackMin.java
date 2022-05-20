package stackMin;

import java.util.Collection;
import java.util.Stack;


/**
 * This class holds a generic, comparable wrapper class in the same way a stack does.
 * However, it has the additional functionality of tracking the last minimum value.
 * 
 * Each pushed value is compared to the last known minimum, and if it is lower, its
 * index is added to a private stack lastMin. When a call to minimum is made, a call to
 * lastMin.peek() is made, and that index is used to get the last known minimum. 
 * 
 * No iterations are required, and thus push, pop, and minimum all have a time complexity
 * of O(1). It must be noted that these methods are not designed to work with inherited
 * methods such as addAll, removeRange, etc, as this changes a large number of elements
 * without updating the lastMinAt stack. However, they could be overridden to iterate 
 * across elements from a collection, but that would be beyond the scope of this challenge.
 * @author Richard Navarro
 *
 * @param <E>
 */
@SuppressWarnings("serial") // I don't believe serial number is necessary to compile.
public class StackMin<E extends Comparable<E>> extends Stack<E> {
	
	/**
	 * Creates an empty MinStack
	 */
	public StackMin() {
	}
	
	/**
	 * Creates a MinStack given a collection.
	 * 
	 * Personally I'm unfamiliar with the syntax of the analogous constructor in
	 * the Vector class, so I'm bodging this constructor together in the case
	 * that the test will insert a collection. After all, what good would the test
	 * be if it wasn't loading a sizable data structure onto this stack? This way,
	 * it will at least generate its own lastMinAt stack. Unfortunately, this is O(n).
	 */
	public StackMin(Collection<? extends E> c) {
		
		for(E e: c) {
			this.push(e);
		}
	}
	
	/**
	 * A privately accessible stack that keeps track of the index of the last 
	 * minimum applied.
	 */
	private Stack<Integer> lastMinAt = new Stack<>();
	
	/**
	 * Evaluates the validity of lastMin. If it has values, it uses the integer
	 * on the top of the stack to index the current minimum.
	 * @return null if lastMin (and by extension, the MinStack) is empty,
	 * returns E if it is not.
	 */
	public E minimum() {
		
		if (lastMinAt.isEmpty()) {
			return null;
		} else { 
			int minIndex = lastMinAt.peek();	
			return this.get(minIndex);
		}
	}
	
	public E push(E e) {
		if (lastMinAt.isEmpty()) {
			lastMinAt.push(0);
		} else {
			if(e.compareTo(this.minimum())<0) {
				/*
				 * This should point to an index that doesn't yet exist in the MinStack.
				 * However, once e is pushed, it will fill out MinStack to that index.
				 */
				int newMinIndex = this.size();
				lastMinAt.push(newMinIndex);
			}
		}
		
		return super.push(e);
	}
	
	public E pop() {
		int lastMinIndex = lastMinAt.peek();
		
		/*
		 * Compares the index of the last known minimum to the index of the item
		 * to be popped. If they are equal, we make sure that the lastMinAt stack
		 * is no longer tracking this index.
		 */
		if (this.size()-1 == lastMinIndex) {
			lastMinAt.pop();
		}
		
		return super.pop();
	}

}
