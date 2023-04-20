package stack;
import java.util.Stack;

/*
 * Jamie Gashler
 * 11/03/22 - 11/14/22
 * This is the postfix evaluation program for these Stack Operations.
 * takes the postfix expression from the InfixToPostfix program and 
 * evaluates it like a calculator would, returning the result as 
 * a single integer
 */


public class PostfixEvaluation 
{

	public static int postEvaluation(String postfix) 
	{
		//initializes stack and variables
		int temp = 0;
		Stack<Integer> myStack = new Stack<>();
		int result = 0;
		myStack.clear();

		//for each item in the postfix expression, push it to the stack
		for (int k = 0; k < postfix.length(); k++) 
		{
			char c = postfix.charAt(k);
			if (c >= '0' && c <= '9') 
			{
				int intValue = c - '0';
				myStack.push(intValue);

			}

			if (c == '+' || c == '-' || c == '*' || c == '/') 
			{
				int operand1 = myStack.pop();
				int operand2 = myStack.pop();

				//Performs the actions of each corresponding operation

				if (c == '+') 
				{
					temp = operand2 + operand1; //adds the two operands
				}				
				else if (c == '-') 
				{
					temp = operand2 - operand1; //subtracts the two operands

				} 
				else if (c == '*') 
				{
					temp = operand2 * operand1; //multiplies the two operands

				} 
				else if (c == '/') 
				{
					temp = operand2 / operand1; //divides the two operands

				}
				myStack.push(temp);
			}

		} 
		result = myStack.push(temp); // end for
		return result;
	
	} // end postfixEvaluation

}
