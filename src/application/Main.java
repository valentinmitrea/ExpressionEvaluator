package application;

import datastructures.BinaryTreeNode;

import exceptions.EvaluationException;
import exceptions.SyntaxException;

import tokens.Token;

/**
 * Class that contains the main function of the application.
 * 
 * @author  Valentin Gabriel Mitrea
 */
public class Main {

	public static void main(String[] args) {
		try {
			String expression = "16 * atan ( 1 / 5 ) - 4 * atan ( 1 / 239 )";
			BinaryTreeNode<Token> expressionTree = ExpressionParser.parse(expression);

			System.out.print("Expression:  " + ExpressionParser.toString(expressionTree) + "\n");
			System.out.print("Result:      " + ExpressionEvaluator.evaluate(expressionTree) + "\n");
		}
		catch (SyntaxException | EvaluationException e) {
			System.out.println(e.getMessage());
		}
	}

}
