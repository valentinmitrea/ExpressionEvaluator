package application;

import datastructures.BinaryTreeNode;
import datastructures.Queue;

import exceptions.SyntaxException;

import java.util.StringTokenizer;

import tokens.AbsoluteValueToken;
import tokens.ArccosineToken;
import tokens.ArcsineToken;
import tokens.ArctangentToken;
import tokens.CeilingToken;
import tokens.ConstantToken;
import tokens.CosineToken;
import tokens.DivideToken;
import tokens.FloorToken;
import tokens.LeftParenthesisToken;
import tokens.LogarithmBaseTenToken;
import tokens.LogarithmBaseTwoToken;
import tokens.LogarithmToken;
import tokens.MinusToken;
import tokens.ModuloToken;
import tokens.MultiplyToken;
import tokens.NumberToken;
import tokens.PlusToken;
import tokens.PowerToken;
import tokens.RightParenthesisToken;
import tokens.RoundToken;
import tokens.SineToken;
import tokens.SquareRootToken;
import tokens.TangentToken;
import tokens.Token;

import visitors.PrintVisitor;

/**
 * Class used for parsing a mathematical expression and converting it into a binary tree representation.
 * 
 * @author  Valentin Gabriel Mitrea
 */
public class ExpressionParser {

	/**
	 * Parses the token and converts it from String representation to a suitable token class.
	 * 
	 * @param  token  the String to analyze
	 * 
	 * @return        the suitable token class found when analyzing the String or null if unknown token
	 */
	private static Token parseToken(String token) {
		switch (token) {
			case "abs":
				return new AbsoluteValueToken();

			case "acos":
				return new ArccosineToken();

			case "asin":
				return new ArcsineToken();

			case "atan":
				return new ArctangentToken();

			case "ceil":
				return new CeilingToken();

			case "PI":
				return new ConstantToken(ConstantToken.PI);

			case "-PI":
				return new ConstantToken(-ConstantToken.PI);

			case "e":
				return new ConstantToken(ConstantToken.e);

			case "-e":
				return new ConstantToken(-ConstantToken.e);

			case "cos":
				return new CosineToken();

			case "/":
				return new DivideToken();

			case "floor":
				return new FloorToken();

			case "(":
				return new LeftParenthesisToken();

			case "log10":
				return new LogarithmBaseTenToken();

			case "log2":
				return new LogarithmBaseTwoToken();

			case "log":
				return new LogarithmToken();

			case "-":
				return new MinusToken();

			case "%":
				return new ModuloToken();

			case "*":
				return new MultiplyToken();

			case "+":
				return new PlusToken();

			case "^":
				return new PowerToken();

			case ")":
				return new RightParenthesisToken();

			case "round":
				return new RoundToken();

			case "sin":
				return new SineToken();

			case "sqrt":
				return new SquareRootToken();

			case "tan":
				return new TangentToken();

			default:
				try {
					return new NumberToken(Double.parseDouble(token));
				}
				catch (NumberFormatException e) {
					return null;
				}
		}
	}

	/**
	 * Utility function that tries to build a subexpression tree from the mathematical tokens found between the given
	 * left parenthesis token and its corresponding right parenthesis token.
	 * 
	 * @param  leftParenthesisToken  the LeftParenthesisToken that marks the start of the subexpression
	 * @param  tokens                a queue of tokens used to build the subexpression tree
	 * 
	 * @return                       the subexpression tree built from the given tokens
	 * @throws  SyntaxException      when a syntax error was discovered in the mathematical expression
	 */
	private static BinaryTreeNode<Token> buildSubExpressionTree(Token leftParenthesisToken, Queue<Token> tokens) throws SyntaxException {
		Queue<Token> subTokens = new Queue<Token>();
		int nrOfParentheses = 1;

		while (tokens.size() > 0) {
			Token token = tokens.pop();

			if (token.toString().equals("("))
				nrOfParentheses++;
			else if (token.toString().equals(")")) {
				// check to see if this is the corresponding right parenthesis we are looking for
				if (nrOfParentheses == 1) {
					BinaryTreeNode<Token> rhs = new BinaryTreeNode<Token>(token, buildExpressionTree(subTokens, 0), null);
					return new BinaryTreeNode<Token>(leftParenthesisToken, null, rhs);
				}
				else
					nrOfParentheses--;
			}

			subTokens.push(token);
		}

		return null;
	}

	/**
	 * Takes a queue of mathematical tokens and connects them together to form an expression tree.
	 * Token priority is taken into consideration when forming the expression tree using the Precedence Climbing algorithm.
	 * 
	 * @param  tokens            a queue of tokens used to build the expression tree
	 * @param  minPriority       current lowest acceptable token priority
	 * 
	 * @return                   the expression tree built from the given tokens
	 * @throws  SyntaxException  when a syntax error was discovered in the mathematical expression
	 */
	private static BinaryTreeNode<Token> buildExpressionTree(Queue<Token> tokens, int minPriority) throws SyntaxException {
		BinaryTreeNode<Token> lhs = null;
		Token token = tokens.peek() != null ? tokens.pop() : null;

		if (token == null || token.isBinaryOperator() || token.toString().equals(")"))
			throw new SyntaxException();
		else if (token.toString().equals("(")) {
			lhs = buildSubExpressionTree(token, tokens);
			if (lhs == null)
				throw new SyntaxException();
		}
		else if (token.isMathematicalFunction()) {
			Token functionToken = token;
			token = tokens.peek() != null ? tokens.pop() : null;
			if (token == null || !token.toString().equals("("))
				throw new SyntaxException();

			lhs = buildSubExpressionTree(token, tokens);
			if (lhs == null)
				throw new SyntaxException();
			else
				lhs = new BinaryTreeNode<Token>(functionToken, lhs, null);
		}
		else
			lhs = new BinaryTreeNode<Token>(token);

		while (tokens.size() > 0) {
			token = tokens.peek();
			if (!token.isBinaryOperator())
				throw new SyntaxException();
			else if (token.priority() < minPriority)
				break;

			tokens.pop();
			// exponentiation is right associative while the other binary operators are left associative
			int nextMinPriority = token.priority() == 4 ? token.priority() : token.priority() + 1;
			BinaryTreeNode<Token> rhs = buildExpressionTree(tokens, nextMinPriority);
			lhs = new BinaryTreeNode<Token>(token, lhs, rhs);
		}

		return lhs;
	}

	/**
	 * Parses the given mathematical expression and converts it from String format to a binary tree representation.
	 * 
	 * @param  expression        the mathematical expression to parse
	 * 
	 * @return                   a binary tree representation of the given mathematical expression
	 * @throws  SyntaxException  when a syntax error was discovered in the mathematical expression
	 */
	public static BinaryTreeNode<Token> parse(String expression) throws SyntaxException {
		StringTokenizer tokenizer = new StringTokenizer(expression);
		Queue<Token> tokens = new Queue<Token>();

		while (tokenizer.hasMoreTokens()) {
			Token token = parseToken(tokenizer.nextToken());
			if (token == null)
				throw new SyntaxException();

			tokens.push(token);
		}

		return buildExpressionTree(tokens, 0);
	}

	/**
	 * Takes the binary tree representation of a mathematical expression and converts it to String format.
	 * 
	 * @param  expressionTree  the binary tree representation of the mathematical expression that has to be converted
	 * 
	 * @return                 a String representation of the given mathematical expression
	 */
	public static String toString(BinaryTreeNode<Token> expressionTree) {
		PrintVisitor visitor = new PrintVisitor(expressionTree);
		return expressionTree.getData().accept(visitor);
	}

}
