/**
 * This class implements StackInterface using a vector. 
 */
import java.util.*; //includes vector class 
public final class VectorStack<T> implements StackInterface<T> {
	private Vector<T> stack;
	private boolean integrityOK;
	private static final int DEFAULT_CAPACITY=50;
	private static final int MAX_CAPACITY=10000;
	
	//default constructor
	public VectorStack()
	{
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Creates new vector stack with initial capacity
	 * as the parameter. 
	 * @param initialCapacity
	 */
	public VectorStack(int initialCapacity)
	{
		integrityOK=false;
		checkCapacity(initialCapacity);
		stack = new Vector<>(initialCapacity);
		integrityOK=true;
	}
	
	/**
	 * This method checks the integrity of the vector stack.
	 */
	public void checkIntegrity()
	{
		if(!integrityOK)
			throw new SecurityException("VectorStack is corrupt.");
	}
	
	/**
	 * This method makes sure the capacity of the vector
	 * stack does not exceed max capacity.
	 * @param capacity
	 */
	private void checkCapacity(int capacity)
	{
		if(capacity>MAX_CAPACITY)
			throw new IllegalStateException("Attempt to create a stack"
					+ " whose capacity exceeds allowed maximum "
					+ "of " + MAX_CAPACITY);	
	}

	/**
	 * This method takes in a new entry (book title) and 
	 * adds it to the vector stack. 
	 * @param newEntry
	 */
	public void push(T newEntry)
	{
		checkIntegrity();
		stack.add(newEntry);
	}
	
	/**
	 * This method removes the top entry (top book)
	 * in the vector stack. 
	 * @return the entry (book) that was removed
	 */
	public T pop()
	{
		checkIntegrity();
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		else 
			return stack.remove(stack.size()-1);
	}
	
	/**
	 * This method peeks the top of the stack & returns 
	 * the top entry (book)
	 * @return the entry (book) that is at the top
	 */
	public T peek()
	{
		checkIntegrity();
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else
			return stack.lastElement();
	}
	
	/**
	 * This method returns true if the stack is 
	 * empty, or false if not. 
	 * @return true if stack is empty
	 */
	public boolean isEmpty()
	{
		checkIntegrity();
		return stack.isEmpty();
	}
	
	/**
	 * This method clears all entries (books). 
	 */
	public void clear()
	{
		checkIntegrity();
		stack.clear();
	}
}
