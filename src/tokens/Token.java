package tokens;

import visitors.Visitor;

/**
 * Abstract class that defines the concept of a token in the mathematical expression.
 * 
 * @author  Valentin Gabriel Mitrea
 */
public abstract class Token {

	/**
	 * Returns the priority of the token. It is used to determine the order of evaluation.
	 * 
	 * @return  the priority of the token
	 */
	public abstract int priority();

	/**
	 * Returns whether or not the token is a binary operator.
	 * 
	 * @return  true if token is a binary operator, false otherwise
	 */
	public abstract boolean isBinaryOperator();

	/**
	 * Returns whether or not the token is a mathematical function.
	 * 
	 * @return  true if token is a mathematical function, false otherwise
	 */
	public abstract boolean isMathematicalFunction();

	/**
	 * Utility method necessary as part of the Visitor design pattern.
	 * 
	 * @param  <T>      the data type returned by the accepted visitor
	 * @param  visitor  the visitor that needs to be accepted
	 * 
	 * @return          the result of the visit
	 */
	public abstract <T> T accept(Visitor<T> visitor);

}
