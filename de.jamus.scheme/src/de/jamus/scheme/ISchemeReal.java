/**
 * 
 */
package de.jamus.scheme;

/**
 * @author Angelos Drossos
 * 
 */
public interface ISchemeReal extends ISchemeNumber {
	/**
	 * Checks if this scheme object is a real number object and returns a
	 * SchemeBoolean. Only the SchemeReal class should return true, all other
	 * classes should return false!
	 * 
	 * @return a SchemeBoolean with value 'true', if this scheme object is from
	 *         type SchemeReal, else 'false'.
	 */
	public SchemeBoolean realp();

}
