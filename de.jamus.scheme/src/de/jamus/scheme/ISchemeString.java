/**
 * 
 */
package de.jamus.scheme;

/**
 * @author Angelos Drossos
 * 
 */
public interface ISchemeString extends ISchemeObject {

	/**
	 * Converts a SchemeString object to a Symbol object. If this object is no
	 * SchemeString object, this method should return an empty Symbol object!
	 * 
	 * @return a Symbol object with the value of this object, if the value is a
	 *         string.
	 */
	public ISchemeSymbol stringsymbol();

	// public SchemeBoolean stringle();

	// public SchemeString stringappend(SchemeString s);
}
