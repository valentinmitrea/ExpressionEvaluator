package tokens;

import visitors.Visitor;

/**
 * Class that defines a mathematical constant token in the mathematical expression.
 * 
 * @author  Valentin Gabriel Mitrea
 */
public class ConstantToken extends Token {

	private Double value;

	/**
	 * Number constant for the approximate value of PI.
	 */
	public static final Double PI = 3.141592;

	/**
	 * Number constant for the approximate value of e.
	 */
	public static final Double e = 2.718281;

	/**
	 * Constructor for a ConstantToken that encapsulates a mathematical constant.
	 * 
	 * @param  value  the double value of the mathematical constant to encapsulate in this ConstantToken
	 */
	public ConstantToken(Double value) {
		this.value = value;
	}

	@Override
	public int priority() {
		return 0;
	}

	@Override
	public boolean isBinaryOperator() {
		return false;
	}

	@Override
	public boolean isMathematicalFunction() {
		return false;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	/**
	 * Gets the value of the mathematical constant encapsulated in this ConstantToken.
	 * 
	 * @return  the value of the mathematical constant encapsulated in this ConstantToken
	 */
	public Double getValue() {
		return value;
	}

	@Override
	public String toString() {
		if (Double.compare(value, PI) == 0)
			return "PI";
		else if (Double.compare(value, -PI) == 0)
			return "-PI";
		else if (Double.compare(value, e) == 0)
			return "e";
		else if (Double.compare(value, -e) == 0)
			return "-e";
		else
			return String.valueOf(value);
	}

}
