package exceptions;

/**
 * Class used for syntax errors which can occur when parsing a mathematical expression.
 * 
 * @author  Valentin Gabriel Mitrea
 */
@SuppressWarnings("serial")
public class SyntaxException extends Exception {

	/**
	 * Constructor for a syntax error in a mathematical expression.
	 */
	public SyntaxException() {
		super("Syntax error encountered in the mathematical expression!");
	}

}
