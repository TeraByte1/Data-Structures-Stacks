public interface StackInterface<T> {
		
	/**
	* Sees whether this stack is empty 
	* @return True if the stack is empty, 
	* or false if not 
	*/
	public boolean isEmpty();
		
	/**
	 * Adds new entry to the stack, if possible.
	 * @param newEntry The object to be added
	 * @return True if addition is successful,
	 * or false if not
	 */
	public void push(T newEntry);
		
	/**
	 * Removes unspecified entry from the stack,
	 * if possible
	 * @return the removed entry (if successful)
	 * or null
	 */
	public T pop();
	
	/**
	 * Removes all entries from this stack
	 */
	public void clear();
		
	/**
	 * Returns what is at the top of the stack
	 * @return
	 */
	public T peek();
}
