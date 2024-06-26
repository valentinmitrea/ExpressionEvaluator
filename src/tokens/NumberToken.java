package tokens;

import visitors.Visitor;

/**
 * Class that defines a number token in the mathematical expression.
 * 
 * @author  Valentin Gabriel Mitrea
 */
public class NumberToken extends Token {

	private Double value;

	/**
	 * Constructor for a NumberToken that encapsulates a double value.
	 * 
	 * @param  value  the double value to encapsulate in this NumberToken
	 */
	public NumberToken(Double value) {
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
	 * Gets the value of the number encapsulated in this NumberToken.
	 * 
	 * @return  the value of the number encapsulated in this NumberToken
	 */
	public Double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

}
