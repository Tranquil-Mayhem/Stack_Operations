package stack;

import java.util.HashMap;
import java.util.Stack;

/*
 * Jamie Gashler
 * 11/03/22 - 11/14/22
 * This is a program that evaluates whether or not the expression
 * the user input is valid. If valid, returns true and the user input 
 * can be evaluated in the Expression Test program. If not valid, this program identifies 
 * the location of the user's error by printing a message with feedback and a 
 * location of where the user went wrong.Then this program returns false so 
 * that the Expression Test program knows to move on with the program without evaluating
 */

public class ExpressionEvaluation 
{
	static HashMap<Integer, String> errorMessage = new HashMap<>();
	static HashMap<Character, Character> pair = new HashMap<>(); // (->) {->}

	public static boolean expressionEvaluation(String statement) 
	{
		Stack<Character> myStack = new Stack<>();

		LoadErrorMessage(); //calls the method to get the error messages 
		LoadPair(); //calls the method to get the pairs of parentheses or curly braces

		boolean valid = true;

		for (int i = 0; i < statement.length(); i++) 
		{

			char c = statement.charAt(i);

			if ((c == '{' || (c == '('))) 
			{
				myStack.push(c);
			}
			
			//if c is '}' look for the matching pair on the stack and print the corresponding 
			//error message whether something else is in its place or nothing exists
			if (c == '}') 
			{
				if (myStack.isEmpty()) 
				{
					printError(statement, i, 3);
					valid = false;
					break;
				}

				char p = myStack.pop();

				if (!(p == pair.get(c))) 
				{
					printError(statement, i, 1);
					valid = false;
					break;
				} 
				else if (p == pair.get(c)) 
				{
					valid = true;
				}

			}
			//if c is ')' look for the matching pair on the stack and print the corresponding 
			//error message whether something else is in its place or nothing exists
			if (c == ')') {
				if (myStack.isEmpty()) 
				{

					printError(statement, i, 3);
					valid = false;
					break;
				}
				char p = myStack.pop();

				if (!(p == pair.get(c))) 
				{
					printError(statement, i, 2);
					valid = false;
					break;
				} 
				else if (p == pair.get(c)) 
				{
					valid = true;
				}
			}

		} // end for

		if (valid && !myStack.isEmpty()) 
		{
			printError(statement, statement.length() - 1, 3);
			valid = false;
		}
		return valid; // returns true or false
	} // end boolean expressionEvaluation(String statement)

	public static void LoadPair() 
	{
		//the valid pairs possible in the user's expression
		pair.put('}', '{');
		pair.put(')', '(');
	}

	public static void printError(String statement, int location, int errorNo) 
	{

		for (int i = 0; i < location; i++) 
		{
			System.out.print(" ");
		}
		System.out.print("^ ");
		System.out.println(errorMessage.get(errorNo)); // print the error message using the error number
	}

	public static void LoadErrorMessage() 
	{
		//the error messages and their index in the HashMap
		errorMessage.put(1, ") expected");
		errorMessage.put(2, "} expected");
		errorMessage.put(3, "Incomplete Expression");

	}

}
