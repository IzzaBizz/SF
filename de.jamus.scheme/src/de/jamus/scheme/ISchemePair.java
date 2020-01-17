/**
 * 
 */
package de.jamus.scheme;

/**
 * @author Angelos Drossos
 * 
 */
public interface ISchemePair extends ISchemeObject {
	/**
	 * the car object (left child of pair)
	 */
	ISchemeObject car = null;

	/**
	 * the cdr object (right child of pair)
	 */
	ISchemeObject cdr = null;

	/**
	 * Returns the current set car object.
	 * 
	 * @return the car object (left child of pair)
	 */
	public ISchemeObject car();

	/**
	 * Returns the current set cdr object.
	 * 
	 * @return the cdr object (right child of pair)
	 */
	public ISchemeObject cdr();

	/**
	 * Checks if this scheme object is a Pair object and returns a
	 * SchemeBoolean. Only the Pair class should return true, all other classes
	 * should return false!
	 * 
	 * @return a SchemeBoolean with value 'true', if this scheme object is from
	 *         type Pair, else 'false'.
	 */
	public SchemeBoolean pairp();

	/**
	 * Checks if this scheme object is a list of pairs and returns a
	 * SchemeBoolean. All classes exept the Pair class should return always
	 * false! The pair class should check if all tail elements are Pair objects.
	 * If it is so, the method should return true.
	 * 
	 * @return a SchemeBoolean with value 'true', if this scheme object is a
	 *         list of pairs, else 'false'.
	 */
	public SchemeBoolean listp();

	/**
	 * ??????????????? Checks if this scheme object is a number object and
	 * returns a SchemeBoolean. Only the SchemeNumber class should return true,
	 * all other classes should return false!
	 * 
	 * @return a SchemeBoolean with value 'true', if this scheme object is from
	 *         type SchemeNumber, else 'false'.
	 */
	public SchemeBoolean nullpp();

}
