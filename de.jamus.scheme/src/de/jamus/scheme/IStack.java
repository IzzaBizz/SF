package de.jamus.scheme;

/**
 * The IStack interface provides all neccessary functions, so that a stack
 * implementation for scheme can be implemented.
 * 
 * @author Angelos Drossos
 * 
 */
public interface IStack {
	// int nb_of_elem = 0;
	// int maxelem = 1000;
	// List stacklist = new List();

	/**
	 * Pushs a new element to the top of the stack.
	 * 
	 * @param elem
	 *            the new element
	 */
	public void push(Object elem);

	/**
	 * Removes the element on top of the stack.
	 */
	public void pop();

	/**
	 * Get the element on top of the stack.
	 * 
	 * @return the top element
	 */
	public Object top();

	/**
	 * Check if the stack is empty (there is no element on stack).
	 * 
	 * @return true, if the stack is empty, else false.
	 */
	public boolean empty();
}
