/**
 * 
 */
package de.jamus.scheme;

/**
 * @author Angelos Drossos
 * 
 */
public interface ISchemeSymbol extends ISchemeObject {

	/**
	 * Checks if this scheme object is a Symbol object and returns a
	 * SchemeBoolean. Only the Symbol class should return true, all other
	 * classes should return false!
	 * 
	 * @return a SchemeBoolean with value 'true', if this scheme object is from
	 *         type Symbol, else 'false'.
	 */
	public ISchemeBoolean symbolp();

	/**
	 * Converts a Symbol object to an SchemeString object. If this object is no
	 * Symbol object, this method should return an empty String object!
	 * 
	 * @return a SchemeString object with the value of this object, if the value
	 *         is a symbol.
	 */
	public ISchemeString symbolstring();
}
