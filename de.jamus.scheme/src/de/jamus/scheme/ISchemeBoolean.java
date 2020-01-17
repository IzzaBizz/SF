/**
 * 
 */
package de.jamus.scheme;

/**
 * The interface for scheme boolean type.
 * 
 */
public interface ISchemeBoolean extends ISchemeObject {
	/**
	 * Returns a negated object of type SchemeBoolean. E.g., all objects which
	 * implements the SchemeBoolean class should also implement this method.
	 * 
	 * @return a negated SchemeBoolean object.
	 */
	public SchemeBoolean not();
}
