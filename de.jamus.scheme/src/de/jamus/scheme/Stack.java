package de.jamus.scheme;

/**
 * The Scheme run environment needs a stack to organize the expressions.
 * 
 */
public class Stack implements IStack {
	/** the number of elements on the stack */
	private int size = 0;

	/** maximal elements on the stack */
	private int maxelem = 10;

	/** The @stacklist: Stack is organized as list. */
	private List stacklist = new List();

	/**
	 * Construct a new stack with maximal @max_elements elements.
	 * 
	 * @param max_elements
	 *            the maximal elements on stack.
	 */
	public Stack(int max_elements) {
		maxelem = max_elements;
	}

	@Override
	public void push(Object elem) {
		if (size + 1 > maxelem) {
			System.out.println("Stackoverflow");
			return;
		}

		stacklist = stacklist.cons(elem);
		size++;
	}

	@Override
	public void pop() {
		if (empty()) {
			System.out.println("Stackunderflow");
			return;
		}

		stacklist = stacklist.cdr();
		size--;
	}

	@Override
	public Object top() {
		if (empty()) {
			System.out.println("Empty Stack");
			return null;
		}
		return stacklist.car();
	}

	@Override
	public boolean empty() {
		assert (size >= 0);
		return (size <= 0);
	}
}
