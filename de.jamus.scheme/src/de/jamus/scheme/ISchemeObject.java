package de.jamus.scheme;

import java.io.BufferedWriter;

/**
 * ISchemeObject is an general interface of all scheme object types. It has all
 * neccessary functions so that JamusScheme can operate. All scheme objects have
 * there own implementations of these functions. Additionally, every scheme
 * object can have more functions.
 */
public interface ISchemeObject {

	/**
	 * Expands a scheme expression once. Which object is returned, depends on
	 * the scheme expression.
	 * 
	 * @note This is an important function for the scheme interpreter and must
	 *       be implemented by all scheme objects.
	 * @return a scheme object. Which type of scheme object can be found out
	 *         with castings.
	 * @see e.g. symbolp(), numberp(), integerp(), realp(), pairp(), listp(),
	 *      nullp()
	 */
	public ISchemeObject expand();

	/**
	 * Expands a scheme expression until it cannot be expanded anymore. Which
	 * object is returned, depends on the scheme expression.
	 * 
	 * @note This is an important function for the scheme interpreter and must
	 *       be implemented by all scheme objects.
	 * @return a scheme object. Which type of scheme object can be found out
	 *         with castings.
	 * @see e.g. symbolp(), numberp(), integerp(), realp(), pairp(), listp(),
	 *      nullp()
	 */
	public ISchemeObject expandall();

	/**
	 * Evaluates a scheme expression and returns a new scheme object. Which
	 * object is returned, depends on the scheme expression.
	 * 
	 * @note This is an important function for the scheme interpreter and must
	 *       be implemented by all scheme objects.
	 * @return a scheme object. Which type of scheme object can be found out
	 *         with castings.
	 */
	public ISchemeObject eval();

	/**
	 * Checks if the scheme object is an empty object.
	 * 
	 * @return true, if the scheme object is an empty object, else false.
	 * @see class Pair.
	 */
	public boolean nullp();

	/**
	 * Concatinates a scheme object with another scheme object to create a pair
	 * of objects. The expression tail.cons(head) can be interpreted as
	 * (head::tail). Rechtsb�ndig verschachtelte pairs are a list of objects:
	 * (1::(2::(3::'()))). '() is an empty pair, in many cases this is an empty
	 * pair object. '1' can be a symbol object.
	 * 
	 * @param head
	 *            the head or left scheme object
	 * @return a pair of two scheme objects.
	 */
	public ISchemePair cons(ISchemeObject head);

	/**
	 * Checks if this scheme object is (structural) equal to the given scheme
	 * object #compared_object.
	 * 
	 * @note This is an important function for the scheme interpreter and must
	 *       be implemented by all scheme objects.
	 * @return a SchemeBoolean object with value 'true' if they are structural
	 *         equal, else false.
	 */
	public ISchemeBoolean eqp(ISchemeObject compared_object);

	/**
	 * Checks if this scheme object is equal (by value) to the given scheme
	 * object #compared_object.
	 * 
	 * @note This is an important function for the scheme interpreter and must
	 *       be implemented by all scheme objects.
	 * @return a SchemeBoolean object with value 'true' if they are equal (have
	 *         the same value), else false.
	 */
	public ISchemeBoolean equalp(ISchemeObject compared_object);

	/**
	 * Returns the scheme object as String.
	 * 
	 * @note This is an important function for the scheme interpreter and must
	 *       be implemented by all scheme objects.
	 */
	public String sprint();

	/**
	 * Prints the scheme object to the BufferedWriter.
	 * 
	 * @note This is an important function for the scheme interpreter and must
	 *       be implemented by all scheme objects.
	 */
	public ISchemeObject printp(BufferedWriter open_buffer_writer);

	/**
	 * Prints the scheme object to 'stdout' (mostly a console).
	 * 
	 * @note This is an important function for the scheme interpreter and must
	 *       be implemented by all scheme objects.
	 */
	public void print();

	// public SchemeObject write();
}
