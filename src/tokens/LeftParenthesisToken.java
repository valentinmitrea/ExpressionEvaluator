package tokens;

import visitors.Visitor;

/**
 * Class that defines a left parenthesis token in the mathematical expression.
 * 
 * @author  Valentin Gabriel Mitrea
 */
public class LeftParenthesisToken extends Token {

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

	@Override
	public String toString() {
		return "(";
	}

}
