package visitors;

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

/**
 * Interface necessary as part of the Visitor design pattern.
 * 
 * @param  <T>  the data type returned by the visitor
 * 
 * @author  Valentin Gabriel Mitrea
 */
public interface Visitor<T> {

	/**
	 * Defines what happens when visiting an AbsoluteValueToken.
	 * 
	 * @param  absoluteValue  the AbsoluteValueToken being visited
	 * 
	 * @return                the result of the visit
	 */
	T visit(AbsoluteValueToken absoluteValue);

	/**
	 * Defines what happens when visiting an ArccosineToken.
	 * 
	 * @param  arccosine  the ArccosineToken being visited
	 * 
	 * @return            the result of the visit
	 */
	T visit(ArccosineToken arccosine);

	/**
	 * Defines what happens when visiting an ArcsineToken.
	 * 
	 * @param  arcsine  the ArcsineToken being visited
	 * 
	 * @return          the result of the visit
	 */
	T visit(ArcsineToken arcsine);

	/**
	 * Defines what happens when visiting an ArctangentToken.
	 * 
	 * @param  arctangent  the ArctangentToken being visited
	 * 
	 * @return             the result of the visit
	 */
	T visit(ArctangentToken arctangent);

	/**
	 * Defines what happens when visiting a CeilingToken.
	 * 
	 * @param  ceiling  the CeilingToken being visited
	 * 
	 * @return          the result of the visit
	 */
	T visit(CeilingToken ceiling);

	/**
	 * Defines what happens when visiting a ConstantToken.
	 * 
	 * @param  constant  the ConstantToken being visited
	 * 
	 * @return           the result of the visit
	 */
	T visit(ConstantToken constant);

	/**
	 * Defines what happens when visiting a CosineToken.
	 * 
	 * @param  cosine  the CosineToken being visited
	 * 
	 * @return         the result of the visit
	 */
	T visit(CosineToken cosine);

	/**
	 * Defines what happens when visiting a DivideToken.
	 * 
	 * @param  divide  the DivideToken being visited
	 * 
	 * @return         the result of the visit
	 */
	T visit(DivideToken divide);

	/**
	 * Defines what happens when visiting a FloorToken.
	 * 
	 * @param  floor  the FloorToken being visited
	 * 
	 * @return        the result of the visit
	 */
	T visit(FloorToken floor);

	/**
	 * Defines what happens when visiting a LeftParenthesisToken.
	 * 
	 * @param  leftParenthesis  the LeftParenthesisToken being visited
	 * 
	 * @return                  the result of the visit
	 */
	T visit(LeftParenthesisToken leftParenthesis);

	/**
	 * Defines what happens when visiting a LogarithmBaseTenToken.
	 * 
	 * @param  logarithmBaseTen  the LogarithmBaseTenToken being visited
	 * 
	 * @return                   the result of the visit
	 */
	T visit(LogarithmBaseTenToken logarithmBaseTen);

	/**
	 * Defines what happens when visiting a LogarithmBaseTwoToken.
	 * 
	 * @param  logarithmBaseTwo  the LogarithmBaseTwoToken being visited
	 * 
	 * @return                   the result of the visit
	 */
	T visit(LogarithmBaseTwoToken logarithmBaseTwo);

	/**
	 * Defines what happens when visiting a LogarithmToken.
	 * 
	 * @param  logarithm  the LogarithmToken being visited
	 * 
	 * @return            the result of the visit
	 */
	T visit(LogarithmToken logarithm);

	/**
	 * Defines what happens when visiting a MinusToken.
	 * 
	 * @param  minus  the MinusToken being visited
	 * 
	 * @return        the result of the visit
	 */
	T visit(MinusToken minus);

	/**
	 * Defines what happens when visiting a ModuloToken.
	 * 
	 * @param  modulo  the ModuloToken being visited
	 * 
	 * @return         the result of the visit
	 */
	T visit(ModuloToken modulo);

	/**
	 * Defines what happens when visiting a MultiplyToken.
	 * 
	 * @param  multiply  the MultiplyToken being visited
	 * 
	 * @return           the result of the visit
	 */
	T visit(MultiplyToken multiply);

	/**
	 * Defines what happens when visiting a NumberToken.
	 * 
	 * @param  number  the NumberToken being visited
	 * 
	 * @return         the result of the visit
	 */
	T visit(NumberToken number);

	/**
	 * Defines what happens when visiting a PlusToken.
	 * 
	 * @param  plus  the PlusToken being visited
	 * 
	 * @return       the result of the visit
	 */
	T visit(PlusToken plus);

	/**
	 * Defines what happens when visiting a PowerToken.
	 * 
	 * @param  power  the PowerToken being visited
	 * 
	 * @return        the result of the visit
	 */
	T visit(PowerToken power);

	/**
	 * Defines what happens when visiting a RightParenthesisToken.
	 * 
	 * @param  rightParenthesis  the RightParenthesisToken being visited
	 * 
	 * @return                   the result of the visit
	 */
	T visit(RightParenthesisToken rightParenthesis);

	/**
	 * Defines what happens when visiting a RoundToken.
	 * 
	 * @param  round  the RoundToken being visited
	 * 
	 * @return        the result of the visit
	 */
	T visit(RoundToken round);

	/**
	 * Defines what happens when visiting a SineToken.
	 * 
	 * @param  sine  the SineToken being visited
	 * 
	 * @return       the result of the visit
	 */
	T visit(SineToken sine);

	/**
	 * Defines what happens when visiting a SquareRootToken.
	 * 
	 * @param  squareRoot  the SquareRootToken being visited
	 * 
	 * @return             the result of the visit
	 */
	T visit(SquareRootToken squareRoot);

	/**
	 * Defines what happens when visiting a TangentToken.
	 * 
	 * @param  tangent  the TangentToken being visited
	 * 
	 * @return          the result of the visit
	 */
	T visit(TangentToken tangent);

}
