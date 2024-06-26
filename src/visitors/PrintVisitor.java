package visitors;

import datastructures.BinaryTreeNode;

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
 * Class for a concrete visitor that prints a mathematical expression.
 * It is used for debugging purposes to check if the expression was correctly parsed.
 * 
 * @author  Valentin Gabriel Mitrea
 */
public class PrintVisitor implements Visitor<String> {

	/**
	 * A binary tree representation of the mathematical expression being visited.
	 */
	private BinaryTreeNode<Token> expressionTree;

	/**
	 * Constructor for a PrintVisitor.
	 * 
	 * @param  expressionTree  the root node of the mathematical expression that has to be visited
	 */
	public PrintVisitor(BinaryTreeNode<Token> expressionTree) {
		this.expressionTree = expressionTree;
	}

	@Override
	public String visit(AbsoluteValueToken absoluteValue) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(absoluteValue);
		return absoluteValue.toString() + " " + expressionNode.getLeftChild().getData().accept(this);
	}

	@Override
	public String visit(ArccosineToken arccosine) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(arccosine);
		return arccosine.toString() + " " + expressionNode.getLeftChild().getData().accept(this);
	}

	@Override
	public String visit(ArcsineToken arcsine) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(arcsine);
		return arcsine.toString() + " " + expressionNode.getLeftChild().getData().accept(this);
	}

	@Override
	public String visit(ArctangentToken arctangent) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(arctangent);
		return arctangent.toString() + " " + expressionNode.getLeftChild().getData().accept(this);
	}

	@Override
	public String visit(CeilingToken ceiling) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(ceiling);
		return ceiling.toString() + " " + expressionNode.getLeftChild().getData().accept(this);
	}

	@Override
	public String visit(ConstantToken constant) {
		return constant.toString();
	}

	@Override
	public String visit(CosineToken cosine) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(cosine);
		return cosine.toString() + " " + expressionNode.getLeftChild().getData().accept(this);
	}

	@Override
	public String visit(DivideToken divide) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(divide);
		return expressionNode.getLeftChild().getData().accept(this) + " " + divide.toString() + " " +
			   expressionNode.getRightChild().getData().accept(this);
	}

	@Override
	public String visit(FloorToken floor) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(floor);
		return floor.toString() + " " + expressionNode.getLeftChild().getData().accept(this);
	}

	@Override
	public String visit(LeftParenthesisToken leftParenthesis) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(leftParenthesis);
		return leftParenthesis.toString() + " " + expressionNode.getRightChild().getData().accept(this);
	}

	@Override
	public String visit(LogarithmBaseTenToken logarithmBaseTen) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(logarithmBaseTen);
		return logarithmBaseTen.toString() + " " + expressionNode.getLeftChild().getData().accept(this);
	}

	@Override
	public String visit(LogarithmBaseTwoToken logarithmBaseTwo) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(logarithmBaseTwo);
		return logarithmBaseTwo.toString() + " " + expressionNode.getLeftChild().getData().accept(this);
	}

	@Override
	public String visit(LogarithmToken logarithm) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(logarithm);
		return logarithm.toString() + " " + expressionNode.getLeftChild().getData().accept(this);
	}

	@Override
	public String visit(MinusToken minus) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(minus);
		return expressionNode.getLeftChild().getData().accept(this) + " " + minus.toString() + " " +
			   expressionNode.getRightChild().getData().accept(this);
	}

	@Override
	public String visit(ModuloToken modulo) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(modulo);
		return expressionNode.getLeftChild().getData().accept(this) + " " + modulo.toString() + " " +
			   expressionNode.getRightChild().getData().accept(this);
	}

	@Override
	public String visit(MultiplyToken multiply) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(multiply);
		return expressionNode.getLeftChild().getData().accept(this) + " " + multiply.toString() + " " +
			   expressionNode.getRightChild().getData().accept(this);
	}

	@Override
	public String visit(NumberToken number) {
		return number.toString();
	}

	@Override
	public String visit(PlusToken plus) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(plus);
		return expressionNode.getLeftChild().getData().accept(this) + " " + plus.toString() + " " +
			   expressionNode.getRightChild().getData().accept(this);
	}

	@Override
	public String visit(PowerToken power) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(power);
		return expressionNode.getLeftChild().getData().accept(this) + " " + power.toString() + " " +
			   expressionNode.getRightChild().getData().accept(this);
	}

	@Override
	public String visit(RightParenthesisToken rightParenthesis) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(rightParenthesis);
		return expressionNode.getLeftChild().getData().accept(this) + " " + rightParenthesis.toString();
	}

	@Override
	public String visit(RoundToken round) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(round);
		return round.toString() + " " + expressionNode.getLeftChild().getData().accept(this);
	}

	@Override
	public String visit(SineToken sine) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(sine);
		return sine.toString() + " " + expressionNode.getLeftChild().getData().accept(this);
	}

	@Override
	public String visit(SquareRootToken squareRoot) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(squareRoot);
		return squareRoot.toString() + " " + expressionNode.getLeftChild().getData().accept(this);
	}

	@Override
	public String visit(TangentToken tangent) {
		BinaryTreeNode<Token> expressionNode = expressionTree.findNode(tangent);
		return tangent.toString() + " " + expressionNode.getLeftChild().getData().accept(this);
	}

}
