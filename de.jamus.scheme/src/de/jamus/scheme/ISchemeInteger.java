/**
 * 
 */
package de.jamus.scheme;

/**
 * @author Angelos Drossos
 * 
 */
public interface ISchemeInteger extends ISchemeNumber {
	/**
	 * Checks if this scheme object is an integer object (a subtype of number
	 * object) and returns a SchemeBoolean. Only the SchemeInteger class should
	 * return true, all other classes should return false!
	 * 
	 * @return a SchemeBoolean with value 'true', if this scheme object is from
	 *         type SchemeInteger, else 'false'.
	 * @see class SchemeInteger and class SchemeNumber.
	 */
	public SchemeBoolean integerp();

}
