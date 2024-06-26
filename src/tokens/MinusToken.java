package tokens;

import visitors.Visitor;

/**
 * Class that defines a minus token in the mathematical expression.
 * 
 * @author  Valentin Gabriel Mitrea
 */
public class MinusToken extends Token {

	@Override
	public int priority() {
		return 2;
	}

	@Override
	public boolean isBinaryOperator() {
		return true;
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
		return "-";
	}

}
