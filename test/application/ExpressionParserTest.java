package application;

import datastructures.BinaryTreeNode;

import exceptions.SyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tokens.Token;

/**
 * Tests for the ExpressionParser class.
 * 
 * @author  Valentin Gabriel Mitrea
 */
public class ExpressionParserTest {

	@BeforeClass
	public static void beforeClass() {
	}

	@AfterClass
	public static void afterClass() {
	}

	@Before
	public void before() {
	}

	@After
	public void after() {
	}

	/**
	 * Basic test for expression with number.
	 */
	@Test
	public void test1() {
		try {
			String expression = "10";
			BinaryTreeNode<Token> expressionTree = ExpressionParser.parse(expression);

			assertThat(ExpressionParser.toString(expressionTree), is("10.0"));
		}
		catch (SyntaxException e) {
			fail("SyntaxException should not be thrown!");
		}
	}

	/**
	 * Basic test for expression with symbol.
	 */
	@Test
	public void test2() {
		try {
			String expression = "PI";
			BinaryTreeNode<Token> expressionTree = ExpressionParser.parse(expression);

			assertThat(ExpressionParser.toString(expressionTree), is("PI"));
		}
		catch (SyntaxException e) {
			fail("SyntaxException should not be thrown!");
		}
	}

	/**
	 * Basic test for addition.
	 */
	@Test
	public void test3() {
		try {
			String expression = "10 + 20";
			BinaryTreeNode<Token> expressionTree = ExpressionParser.parse(expression);

			assertThat(ExpressionParser.toString(expressionTree), is("10.0 + 20.0"));
		}
		catch (SyntaxException e) {
			fail("SyntaxException should not be thrown!");
		}
	}

	/**
	 * Basic test for power.
	 */
	@Test
	public void test4() {
		try {
			String expression = "5 ^ 2";
			BinaryTreeNode<Token> expressionTree = ExpressionParser.parse(expression);

			assertThat(ExpressionParser.toString(expressionTree), is("5.0 ^ 2.0"));
		}
		catch (SyntaxException e) {
			fail("SyntaxException should not be thrown!");
		}
	}

	/**
	 * Basic test for natural logarithm.
	 */
	@Test
	public void test5() {
		try {
			String expression = "log ( e )";
			BinaryTreeNode<Token> expressionTree = ExpressionParser.parse(expression);

			assertThat(ExpressionParser.toString(expressionTree), is("log ( e )"));
		}
		catch (SyntaxException e) {
			fail("SyntaxException should not be thrown!");
		}
	}

	/**
	 * Intermediate test for operator precedence.
	 */
	@Test
	public void test6() {
		try {
			String expression = "10 + 20 * 30";
			BinaryTreeNode<Token> expressionTree = ExpressionParser.parse(expression);

			assertThat(ExpressionParser.toString(expressionTree), is("10.0 + 20.0 * 30.0"));
		}
		catch (SyntaxException e) {
			fail("SyntaxException should not be thrown!");
		}
	}

	/**
	 * Intermediate test for left and right associativity.
	 */
	@Test
	public void test7() {
		try {
			String expression = "10 + 20 - 2 ^ 2 ^ 3";
			BinaryTreeNode<Token> expressionTree = ExpressionParser.parse(expression);

			assertThat(ExpressionParser.toString(expressionTree), is("10.0 + 20.0 - 2.0 ^ 2.0 ^ 3.0"));
		}
		catch (SyntaxException e) {
			fail("SyntaxException should not be thrown!");
		}
	}

	/**
	 * Intermediate test for binary operator and mathematical function.
	 */
	@Test
	public void test8() {
		try {
			String expression = "10 + round ( 1.7 - 1 )";
			BinaryTreeNode<Token> expressionTree = ExpressionParser.parse(expression);

			assertThat(ExpressionParser.toString(expressionTree), is("10.0 + round ( 1.7 - 1.0 )"));
		}
		catch (SyntaxException e) {
			fail("SyntaxException should not be thrown!");
		}
	}

	/**
	 * Advanced test for expression with parentheses.
	 */
	@Test
	public void test9() {
		try {
			String expression = "10 * ( 10 + 20 - 5.5 ) - 50";
			BinaryTreeNode<Token> expressionTree = ExpressionParser.parse(expression);

			assertThat(ExpressionParser.toString(expressionTree), is("10.0 * ( 10.0 + 20.0 - 5.5 ) - 50.0"));
		}
		catch (SyntaxException e) {
			fail("SyntaxException should not be thrown!");
		}
	}

	/**
	 * Advanced test for expression with parentheses and mathematical functions.
	 */
	@Test
	public void test10() {
		try {
			String expression = "( 2 ^ ( 1 + 2 ) - ( 2 + 2 ) ^ ( 4 / 2 ) * abs ( -2.0 ) ) + 10 % 4 - sin ( PI / 2 ) * ( 4 / ( 1 + 1.5 ) )";
			BinaryTreeNode<Token> expressionTree = ExpressionParser.parse(expression);

			assertThat(ExpressionParser.toString(expressionTree), is("( 2.0 ^ ( 1.0 + 2.0 ) - ( 2.0 + 2.0 ) ^ ( 4.0 / 2.0 ) * abs ( -2.0 ) ) + 10.0 % 4.0 - sin ( PI / 2.0 ) * ( 4.0 / ( 1.0 + 1.5 ) )"));
		}
		catch (SyntaxException e) {
			fail("SyntaxException should not be thrown!");
		}
	}

	/**
	 * Syntax error test for incorrect number.
	 */
	@Test
	public void test11() {
		try {
			String expression = "2a - 3";
			ExpressionParser.parse(expression);

			fail("SyntaxException should be thrown!");
		}
		catch (SyntaxException e) {
			assertThat(e.getMessage(), is("Syntax error encountered in the mathematical expression!"));
		}
	}

	/**
	 * Syntax error test for missing operand.
	 */
	@Test
	public void test12() {
		try {
			String expression = "10 + * 20";
			ExpressionParser.parse(expression);

			fail("SyntaxException should be thrown!");
		}
		catch (SyntaxException e) {
			assertThat(e.getMessage(), is("Syntax error encountered in the mathematical expression!"));
		}
	}

	/**
	 * Syntax error test for missing parenthesis.
	 */
	@Test
	public void test13() {
		try {
			String expression = "( ( 10 + 20 ) * 30";
			ExpressionParser.parse(expression);

			fail("SyntaxException should be thrown!");
		}
		catch (SyntaxException e) {
			assertThat(e.getMessage(), is("Syntax error encountered in the mathematical expression!"));
		}
	}

	/**
	 * Syntax error test for mathematical function without parentheses.
	 */
	@Test
	public void test14() {
		try {
			String expression = "floor 2.3";
			ExpressionParser.parse(expression);

			fail("SyntaxException should be thrown!");
		}
		catch (SyntaxException e) {
			assertThat(e.getMessage(), is("Syntax error encountered in the mathematical expression!"));
		}
	}

	/**
	 * Syntax error test for incorrect mathematical function.
	 */
	@Test
	public void test15() {
		try {
			String expression = "2 + sine ( PI )";
			ExpressionParser.parse(expression);

			fail("SyntaxException should be thrown!");
		}
		catch (SyntaxException e) {
			assertThat(e.getMessage(), is("Syntax error encountered in the mathematical expression!"));
		}
	}

	/**
	 * Evaluation error test for division by zero.
	 * The expression should be correctly parsed without finding any syntax errors.
	 */
	@Test
	public void test16() {
		try {
			String expression = "5 / 0";
			BinaryTreeNode<Token> expressionTree = ExpressionParser.parse(expression);

			assertThat(ExpressionParser.toString(expressionTree), is("5.0 / 0.0"));
		}
		catch (SyntaxException e) {
			fail("SyntaxException should not be thrown!");
		}
	}

	/**
	 * Evaluation error test for modulo by zero.
	 * The expression should be correctly parsed without finding any syntax errors.
	 */
	@Test
	public void test17() {
		try {
			String expression = "10 + 20 % ( 30 - 30 )";
			BinaryTreeNode<Token> expressionTree = ExpressionParser.parse(expression);

			assertThat(ExpressionParser.toString(expressionTree), is("10.0 + 20.0 % ( 30.0 - 30.0 )"));
		}
		catch (SyntaxException e) {
			fail("SyntaxException should not be thrown!");
		}
	}

	/**
	 * Evaluation error test for zero to negative power.
	 * The expression should be correctly parsed without finding any syntax errors.
	 */
	@Test
	public void test18() {
		try {
			String expression = "4 * 0 ^ -1";
			BinaryTreeNode<Token> expressionTree = ExpressionParser.parse(expression);

			assertThat(ExpressionParser.toString(expressionTree), is("4.0 * 0.0 ^ -1.0"));
		}
		catch (SyntaxException e) {
			fail("SyntaxException should not be thrown!");
		}
	}

	/**
	 * Evaluation error test for negative square root.
	 * The expression should be correctly parsed without finding any syntax errors.
	 */
	@Test
	public void test19() {
		try {
			String expression = "sqrt ( -5 )";
			BinaryTreeNode<Token> expressionTree = ExpressionParser.parse(expression);

			assertThat(ExpressionParser.toString(expressionTree), is("sqrt ( -5.0 )"));
		}
		catch (SyntaxException e) {
			fail("SyntaxException should not be thrown!");
		}
	}

	/**
	 * Evaluation error test for zero or negative logarithm.
	 * The expression should be correctly parsed without finding any syntax errors.
	 */
	@Test
	public void test20() {
		try {
			String expression = "10.0 + 20 * log2 ( 30 - 40 )";
			BinaryTreeNode<Token> expressionTree = ExpressionParser.parse(expression);

			assertThat(ExpressionParser.toString(expressionTree), is("10.0 + 20.0 * log2 ( 30.0 - 40.0 )"));
		}
		catch (SyntaxException e) {
			fail("SyntaxException should not be thrown!");
		}
	}

}
