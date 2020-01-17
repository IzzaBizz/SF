package de.jamus.scheme;

/**
 * The interface for scheme number types. A number can be e.g. an integer or a
 * real value.
 * 
 * @author Angelos Drossos
 * @see ISchemeInteger, ISchemeReal, ISchemeDouble
 */
public interface ISchemeNumber extends ISchemeObject {
	/**
	 * Checks if this scheme object is a number object and returns a
	 * SchemeBoolean. Only the SchemeNumber class should return true, all other
	 * classes should return false!
	 * 
	 * @return a SchemeBoolean with value 'true', if this scheme object is from
	 *         type SchemeNumber, else 'false'.
	 */
	public ISchemeBoolean numberp();

	/**
	 * Converts a SchemeNumber object to an SchemeString object. If this object
	 * is no SchemeNumber object, this method should return an empty String
	 * object!
	 * 
	 * @return a SchemeString object with the value of this object, if the value
	 *         is a number.
	 */
	public ISchemeString numberstring();

	public ISchemeBoolean positivep();

	public ISchemeBoolean zerop();

	public ISchemeBoolean negativep();

}
