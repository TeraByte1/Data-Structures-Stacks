/**
 * This class implements StackInterface using a 
 * resizable array.
 */

import java.util.*;
public class BookArray<T> implements StackInterface<T> {
	private T[] stack; 
	private int topIndex;
	private boolean integrityOK=false;
	private static final int DEFAULT_CAPACITY=50;
	private static final int MAX_CAPACITY=10000;

	//default constructor
	public BookArray()
	{
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Constructor to create a new pile of books.
	 * @param desiredCapacity
	 */
	public BookArray(int initialCapacity)
	{
		integrityOK=false; //why?
		checkCapacity(initialCapacity);
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		stack=tempStack; //stack created here becomes this.stack
		topIndex=-1;
		integrityOK=true; //why?
		}
	
	/**
	 * This method adds a new book to the pile and 
	 * doubles the capacity if array is full. 
	 * Returns true if the addition was successful. 
	 * @param newEntry
	 */
	public void push(T newEntry)
	{
		checkIntegrity();
		ensureCapacity();
		//new entry will exist at new top index
		//because @first entry, the top index is -1
		stack[topIndex+1]=newEntry; 
		//since top index is still at -1 
		//only the new entry exists at index+1
		//so increment top index
		topIndex++;
	}
	
	/**
	 * This method checks the capacity of the pile.
	 * If the client requests a capacity that is too large,
	 * then it throws an exception. 
	 */
	private void ensureCapacity(){
		if(topIndex >= stack.length-1)
		{
			//multiply length by 2
			int newLength = 2*stack.length; 
			
			//make sure not above max
			checkCapacity(newLength); 
			
			//copy into new array
			stack=Arrays.copyOf(stack, newLength); 
		}
	}
	
	/**
	 * This method checks the integrity of the stack. 
	 */
	public void checkIntegrity()
	{
		if(!integrityOK)
			throw new SecurityException("BookArray object is corrupt.");
	}
	
	/**
	 * This method checks to make sure the capacity
	 * does not exceed the max capacity
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
	 * This method removes the book at the top of the pile.
	 * @return book removed
	 */
	public T pop(){
	checkIntegrity();
	if(isEmpty())
	{
		throw new EmptyStackException();
	}
	//top object to be removed at top index 
	//of the stack
	else {
	T top = stack[topIndex];
	stack[topIndex]=null;
	topIndex--;
	return top;
	}
	}

	/**
	 * This methods returns true if the stack is empty. 
	 */
	public boolean isEmpty()
	{
		//if top index is negative,
		//then the stack is empty
		return topIndex <0;
	}


	/**
	 * This method peeks the top book and returns 
	 * the book title at the top of the pile. 
	 * @return object at the top entry
	 */
	public T peek()
	{
		checkIntegrity();
		if (isEmpty())
		{
		System.out.println("No books to see here!");
		throw new EmptyStackException();
		}
		else
		{
		return stack[topIndex];
		}

	}

	/**
	 * This method clears all books in the pile. 
	 */
	public void clear()
	{
		checkIntegrity();
		//remove references to object
		//but don't deallocate the array
		while(topIndex>-1)
		{
			stack[topIndex]=null;
			topIndex--;
		}
	}
}
