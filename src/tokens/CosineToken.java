package tokens;

import visitors.Visitor;

/**
 * Class that defines a cosine token in the mathematical expression.
 * 
 * @author  Valentin Gabriel Mitrea
 */
public class CosineToken extends Token {

	@Override
	public int priority() {
		return 1;
	}

	@Override
	public boolean isBinaryOperator() {
		return false;
	}

	@Override
	public boolean isMathematicalFunction() {
		return true;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "cos";
	}

}
