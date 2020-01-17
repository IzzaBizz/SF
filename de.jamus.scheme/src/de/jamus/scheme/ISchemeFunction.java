/**
 * 
 */
package de.jamus.scheme;

/**
 * @author Angelos Drossos
 * 
 */
public interface ISchemeFunction extends ISchemeObject {
	/**
	 * The format of the expression given by a scheme function.
	 * 
	 * The previous implementation uses Strings to determine the expression
	 * type, but that is more error-prone. This implementation can be better
	 * documented.
	 * 
	 * @author Angelos Drossos
	 * 
	 */
	public enum exprType {
		/**
		 * This function has one argument in scheme syntax: (function x). The
		 * class of x calls the function, so every scheme type should implement
		 * this function to work correctly. Alternatively an exception is
		 * raised.
		 * 
		 * Examples: (car '(1 2)) calls Pair.car() and returns 1. But the scheme
		 * expression (car 3) tries to call SchemeNumber.car() but that function
		 * is not implemented and an exception is raised.
		 * 
		 * This type is useful for all global functions and for those who needs
		 * a special type to work.
		 * 
		 * @see EXPRp
		 */
		EXPR,

		/**
		 * This function has one argument in scheme syntax: (function x). This
		 * type is similar to EXPR, but with the difference that, if x has not
		 * the function implemented, #f is returned. Thus, the user does not see
		 * that the function is not implemented!
		 * 
		 * Examples: (integer? 3) calls SchemeInteger.integerp() and returns #t.
		 * The scheme expression (integer? (1 2)) calls Pair.integerp() which is
		 * not implemented, so #f is returned.
		 * 
		 * This type is useful for all type detection functions like number?,
		 * integer?, real?, pair?, symbol?.
		 * 
		 * @see EXPR
		 */
		EXPRp,

		/**
		 * TODO
		 */
		EXPR2,

		/**
		 * TODO
		 */
		EXPR2r,

		/**
		 * ?? (not used?)
		 */
		tEXPR,

		/**
		 * TODO
		 */
		CLOSURE,

		/**
		 * the default expression type.
		 */
		LIST,

		/**
		 * EXTERN indicates that the expression does not come from scheme
		 * implementation.
		 */
		EXTERN
	}
}
