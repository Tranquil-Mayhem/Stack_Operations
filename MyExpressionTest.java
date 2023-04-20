package stack;
import java.util.Scanner;

/*
 * Jamie Gashler
 * 11/03/22 - 11/14/22
 * This is the test program for these Stack Operations.
 * This program asks for user input and checks to see 
 * if their expression is valid. If valid, returns their 
 * expression as an infix expression, postfix expression 
 * and returns the evaluated result
 */

public class MyExpressionTest 
{
	public static Scanner consol = new Scanner(System.in); 
	public static String userinfix;
	public static int result;
	public static String input;
	public static boolean valid = false;


	public static void main(String[] args) throws Exception 
	{
		while (true) 
		{
			
			// ask for a math expression
			System.out.println("CS 211 - Fall Quarter 2022");
			System.out.println("Enter a math expression: ");			
			input = consol.nextLine();
			
			//if the user hits enter instead of writing an expression, end the program
			if (input.length() == 0) 
			{
				System.out.println("Bye..");
				break;
			}
			checkIfValid();
		
			System.out.println();
		}
	}

	//checks if the user input is valid
	public static void checkIfValid() 
	{
		boolean valid = ExpressionEvaluation.expressionEvaluation(input);
		//only if valid will move on to converting to infix 
		//and postfix, otherwise go back to main
		if (valid == true) 
		{
			convertInfixtoPostfix();
			getPostfixEvaluation();			
		}
			
	}

	//converts the user's input to a postfix expression and prints it
	public static void convertInfixtoPostfix()
	{
		System.out.println("infix: " + input);
		String infixToPost = InfixToPostfix.infix2postfix(input);
		System.out.println("postfix: " + infixToPost);
		 userinfix = infixToPost; 

	}
	
	//evaluates the user's postfix expression and prints it
	public static void getPostfixEvaluation()
	{
		int postEvaluation = PostfixEvaluation.postEvaluation(userinfix);
		System.out.println("result: " + postEvaluation);

	}
	
}
