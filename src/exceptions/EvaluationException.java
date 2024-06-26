package exceptions;

/**
 * Class used for errors which can occur during the evaluation of a mathematical expression.
 * 
 * @author  Valentin Gabriel Mitrea
 */
@SuppressWarnings("serial")
public class EvaluationException extends Exception {

	/**
	 * String constant for the division by zero error message.
	 */
	public static final String ZERO_DIV_MESSAGE = "division by zero";

	/**
	 * String constant for the modulo by zero error message.
	 */
	public static final String ZERO_MOD_MESSAGE = "modulo by zero";

	/**
	 * String constant for the zero to negative power error message.
	 */
	public static final String ZERO_TO_NEGATIVE_POW_MESSAGE = "zero to negative power";

	/**
	 * String constant for the negative value square root error message.
	 */
	public static final String NEGATIVE_SQRT_MESSAGE = "negative value passed to square root";

	/**
	 * String constant for the zero or negative value logarithm error message.
	 */
	public static final String ZERO_OR_NEGATIVE_LOG_MESSAGE = "zero or negative value passed to logarithm";

	/**
	 * Constructor for an evaluation error of a mathematical expression.
	 * 
	 * @param  message  error message
	 */
	public EvaluationException(String message) {
		super("Evaluation error encountered in the mathematical expression: " + message + "!");
	}

}
