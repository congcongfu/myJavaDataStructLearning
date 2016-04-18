package model;

import javax.swing.event.AncestorEvent;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/*
 * ExpressionTreeOp represents an element in an expression tree
 * */
public class ExpressionTreeOp {
	
	private int termType;
	private char operator;
	private int value;
	
	
	/*
	 *Creates a new expression tree object with the specified data
	 *
	 * @param type the integer type the expression
	 * @param pop the operand for the expression
	 * @param val the value for the expression
	 * */
	
	public ExpressionTreeOp(int type, char op, int val){
		this.termType = type;
		this.operator = op;
		this.value = val;
	}
	
	/**
	 * Returns true if this object is an operator  and false otherwise.
	 * @return true if this object is an  operator  false otherwise.
	 * 
	 * */
	public boolean isOperator(){
		return (termType ==1);
	}
	
	/*
	 * Returns the operator of this expression tree object.
	 * @return the character representation of the operator
	 * */
	public char getOperator(){
		return operator;
	}
	
	/*
	 * Returns the value of this expression tree object
	 * @return the value of this expression tree object
	 * */
	public int getValue(){
		return value;
	}
	
	/*
	 * Returns a string to represents the binary tree
	 * */
	public String toString(){
		if(termType == 1){
			return operator + " ";
		}else {
			return value + " ";
		}
	}
	
}























