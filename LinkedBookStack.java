/**
 * This class implements StackInterface using a linked chain 
 * of nodes.  
 */
import java.util.*;
public class LinkedBookStack<T> implements StackInterface<T> {
	private Node topNode;
	
	//default constructor
	public LinkedBookStack ()
	{
		topNode=null;
	}

	/**
	 * Inner class for Node
	 */
	private class Node
	{
	private T data;
	private Node next;
		
	private Node(T dataPortion)
	{
		this(dataPortion,null);
	}
		
	private Node(T dataPortion, Node nextNode)
	{
		data=dataPortion;
		next=nextNode;
	}
	
	private T getData()
	{
		return data;
	}
		
	private Node getNextNode()
	{
		return next;
	}
	}
	
	/**
	 * This method adds a new book to the top of the pile
	 * The new node created becomes the top node (book). 
	 * @param newEntry
	 */
	public void push(T newEntry)
	{
		//make new node & insert new entry 
		Node newNode = new Node(newEntry, topNode);
		//new node will be the top node
		topNode=newNode;
	}
	
	/**
	 * This method returns the entry at the top
	 * if the stack is not empty 
	 * @return top node data
	 */
	public T peek()
	{
		if(isEmpty())
			throw new EmptyStackException();
		else
			return topNode.getData();
	}
	
	/**
	 * This method sets the top node as the next
	 * and returns the old top (the removed book). 
	 * @return the book that was removed
	 */
	public T pop() {
	if(isEmpty())
		throw new EmptyStackException();
	else
		{
		T top = peek(); 
		topNode=topNode.getNextNode();
		return top; 
		}
	}
	
	/**
	 * This methods returns true if there are
	 * no books in the pile.
	 * @return true if empty
	 */
	public boolean isEmpty()
	{
		return topNode==null;
	}
	
	/**
	 * This method clears all books. 
	 */
	public void clear()
	{
		topNode=null;
	}
}
