package tokens;

import visitors.Visitor;

/**
 * Class that defines a logarithm base ten token in the mathematical expression.
 * 
 * @author  Valentin Gabriel Mitrea
 */
public class LogarithmBaseTenToken extends Token {

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
		return "log10";
	}

}
