/**
 * 
 */
package de.jamus.scheme;

/**
 * ISchemeProlog provides all neccessary functions, so that a prolog interpreter
 * can be implemented in JamusScheme.
 * 
 * 
 * 
 * @author Angelos Drossos
 * 
 */
public interface ISchemeProlog {

	public void add_fact(ISchemeObject head);

	public void add_rule(ISchemeObject head, ISchemeObject body);

	public void question(ISchemeObject body);
}
