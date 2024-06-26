package application;

import datastructures.BinaryTreeNode;

import exceptions.EvaluationException;

import tokens.Token;

import visitors.EvaluatorVisitor;

/**
 * Class used for evaluating a mathematical expression previously parsed into a binary tree representation.
 * 
 * @author  Valentin Gabriel Mitrea
 */
public class ExpressionEvaluator {

	/**
	 * Evaluates the mathematical expression given as a binary tree representation.
	 * 
	 * @param  expressionTree        a binary tree representation of the mathematical expression that has to be evaluated
	 * 
	 * @return                       the value resulted from the evaluation of the mathematical expression
	 * @throws  EvaluationException  when an error occurs during the evaluation process
	 */
	public static Double evaluate(BinaryTreeNode<Token> expressionTree) throws EvaluationException {
		try {
			EvaluatorVisitor visitor = new EvaluatorVisitor(expressionTree);
			return expressionTree.getData().accept(visitor);
		}
		catch (RuntimeException e) {
			throw new EvaluationException(e.getMessage());
		}
	}

}
