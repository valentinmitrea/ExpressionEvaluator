package visitors;

import datastructures.BinaryTreeNode;

import exceptions.EvaluationException;

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

/**
 * Class for a concrete visitor that evaluates a mathematical expression.
 * 
 * @author  Valentin Gabriel Mitrea
 */
public class EvaluatorVisitor implements Visitor<Double> {

	/**
	 * A binary tree representation of the mathematical expression being visited.
	 */
	private BinaryTreeNode<Token> expressionTree;

	/**
	 * Constructor for an EvaluatorVisitor.
	 * 
	 * @param  expressionTree  the root node of the mathematical expression that has to be visited
	 */
	public EvaluatorVisitor(BinaryTreeNode<Token> expressionTree) {
		this.expressionTree = expressionTree;
	}

	@Override
	public Double visit(AbsoluteValueToken absoluteValue) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(absoluteValue);
		return Math.abs(expressionNode.getLeftChild().getData().accept(this));
	}

	@Override
	public Double visit(ArccosineToken arccosine) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(arccosine);
		return Math.acos(expressionNode.getLeftChild().getData().accept(this));
	}

	@Override
	public Double visit(ArcsineToken arcsine) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(arcsine);
		return Math.asin(expressionNode.getLeftChild().getData().accept(this));
	}

	@Override
	public Double visit(ArctangentToken arctangent) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(arctangent);
		return Math.atan(expressionNode.getLeftChild().getData().accept(this));
	}

	@Override
	public Double visit(CeilingToken ceiling) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(ceiling);
		return Math.ceil(expressionNode.getLeftChild().getData().accept(this));
	}

	@Override
	public Double visit(ConstantToken constant) {
		return constant.getValue();
	}

	@Override
	public Double visit(CosineToken cosine) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(cosine);
		return Math.cos(expressionNode.getLeftChild().getData().accept(this));
	}

	@Override
	public Double visit(DivideToken divide) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(divide);
		Double result = expressionNode.getRightChild().getData().accept(this);

		if (result.equals(0.0))
			throw new RuntimeException(EvaluationException.ZERO_DIV_MESSAGE);

		return expressionNode.getLeftChild().getData().accept(this) / result;
	}

	@Override
	public Double visit(FloorToken floor) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(floor);
		return Math.floor(expressionNode.getLeftChild().getData().accept(this));
	}

	@Override
	public Double visit(LeftParenthesisToken leftParenthesis) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(leftParenthesis);
		return expressionNode.getRightChild().getData().accept(this);
	}

	@Override
	public Double visit(LogarithmBaseTenToken logarithmBaseTen) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(logarithmBaseTen);
		Double result = expressionNode.getLeftChild().getData().accept(this);

		if (result.equals(0.0) || result < 0.0)
			throw new RuntimeException(EvaluationException.ZERO_OR_NEGATIVE_LOG_MESSAGE);

		return Math.log(result) / Math.log(10);
	}

	@Override
	public Double visit(LogarithmBaseTwoToken logarithmBaseTwo) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(logarithmBaseTwo);
		Double result = expressionNode.getLeftChild().getData().accept(this);

		if (result.equals(0.0) || result < 0.0)
			throw new RuntimeException(EvaluationException.ZERO_OR_NEGATIVE_LOG_MESSAGE);

		return Math.log(result) / Math.log(2);
	}

	@Override
	public Double visit(LogarithmToken logarithm) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(logarithm);
		Double result = expressionNode.getLeftChild().getData().accept(this);

		if (result.equals(0.0) || result < 0.0)
			throw new RuntimeException(EvaluationException.ZERO_OR_NEGATIVE_LOG_MESSAGE);

		return Math.log(result);
	}

	@Override
	public Double visit(MinusToken minus) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(minus);
		return expressionNode.getLeftChild().getData().accept(this) -
			   expressionNode.getRightChild().getData().accept(this);
	}

	@Override
	public Double visit(ModuloToken modulo) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(modulo);
		Double result = expressionNode.getRightChild().getData().accept(this);

		if (result.equals(0.0))
			throw new RuntimeException(EvaluationException.ZERO_MOD_MESSAGE);

		return expressionNode.getLeftChild().getData().accept(this) % result;
	}

	@Override
	public Double visit(MultiplyToken multiply) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(multiply);
		return expressionNode.getLeftChild().getData().accept(this) *
			   expressionNode.getRightChild().getData().accept(this);
	}

	@Override
	public Double visit(NumberToken number) {
		return number.getValue();
	}

	@Override
	public Double visit(PlusToken plus) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(plus);
		return expressionNode.getLeftChild().getData().accept(this) +
			   expressionNode.getRightChild().getData().accept(this);
	}

	@Override
	public Double visit(PowerToken power) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(power);
		Double resultLeft = expressionNode.getLeftChild().getData().accept(this);
		Double resultRight = expressionNode.getRightChild().getData().accept(this);

		if (resultLeft.equals(0.0) && resultRight < 0.0)
			throw new RuntimeException(EvaluationException.ZERO_TO_NEGATIVE_POW_MESSAGE);

		return Math.pow(resultLeft, resultRight);
	}

	@Override
	public Double visit(RightParenthesisToken rightParenthesis) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(rightParenthesis);
		return expressionNode.getLeftChild().getData().accept(this);
	}

	@Override
	public Double visit(RoundToken round) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(round);
		return Long.valueOf(Math.round(expressionNode.getLeftChild().getData().accept(this))).doubleValue();
	}

	@Override
	public Double visit(SineToken sine) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(sine);
		return Math.sin(expressionNode.getLeftChild().getData().accept(this));
	}

	@Override
	public Double visit(SquareRootToken squareRoot) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(squareRoot);
		Double result = expressionNode.getLeftChild().getData().accept(this);

		if (result < 0.0)
			throw new RuntimeException(EvaluationException.NEGATIVE_SQRT_MESSAGE);

		return Math.sqrt(result);
	}

	@Override
	public Double visit(TangentToken tangent) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(tangent);
		return Math.tan(expressionNode.getLeftChild().getData().accept(this));
	}

}
