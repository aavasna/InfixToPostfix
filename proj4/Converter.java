package proj4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The converter class models a converter object
 * The constructor takes in a text file.
 * It also has an instance method convert that converts the infix data
 * in the text file to postfix
 * It creates a token, identifies its type and calls the item's handle() method
 * to take care of it.
 * 
 * @author Aavasna Rupakheti
 * @version 02/26/2023
 */
public class Converter {
	
	private Scanner myReader;

	/**
	 * non-default constructor; Gradescope needs this to run tests
	 * @param infile path to the input file 
	 */
    public Converter(String infile)
    {
		try {
            myReader = new Scanner(new File(infile)); 
    	} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}

	/**
	 * Converts the expressions in the text file from infix to postfix
	 * Print format: infix --> postfix
	 * Example: A+B–C --> AB+C–
	 */
	public void convert() {
		Stack<Token> tokenStack = new Stack<>();
		String toPrint = "";
		while(myReader.hasNext()){
			String next = myReader.next();
			String thisLineInfix = "";
			String thisLinePostFix = "";
			boolean endOfLine = false;
			for (char c : next.toCharArray()) { // convert 1 line of infix to postfix at a time
				switch (c){
					case '(':
						LeftParen tokenLeftParen = new LeftParen();
						thisLinePostFix += tokenLeftParen.handle(tokenStack);
						break;
					case ')':
						RightParen tokenRightParen = new RightParen();
						thisLinePostFix += tokenRightParen.handle(tokenStack);
						break;
					case '^':
						Exponent tokenExponent = new Exponent();
						thisLinePostFix += tokenExponent.handle(tokenStack);
						break;
					case '*':
						Multiply tokenMultiply = new Multiply();
						thisLinePostFix += tokenMultiply.handle(tokenStack);
						break;
					case '/':
						Divide tokenDivide = new Divide();
						thisLinePostFix += tokenDivide.handle(tokenStack);
						break;
					case '+':
						Plus tokenPlus = new Plus();
						thisLinePostFix += tokenPlus.handle(tokenStack);
						break;
					case '-':
						Minus tokenMinus = new Minus();
						thisLinePostFix += tokenMinus.handle(tokenStack);
						break;
					case ';':
						Semicolon tokenSC = new Semicolon();
						thisLinePostFix += tokenSC.handle(tokenStack);
						endOfLine = true;
						break;
					default:
						//when the character is an operand
						thisLinePostFix += c;
				}
				if (!endOfLine){
					thisLineInfix += c;
				}
			}
			System.out.println(thisLineInfix + " --> "+ thisLinePostFix);
		}
	}
}
