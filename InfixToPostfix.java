package stack;
import java.util.HashMap;
import java.util.Stack;
/*
 * Jamie Gashler
 * 11/03/22 - 11/14/22
 * This is a program that converts the user input infix 
 * to a postfix expression. It reads all the symbols and places 
 * them in order so that the parentheses, curly braces and 
 * operations with higher precedence are all correctly placed  
 */


public class InfixToPostfix 
{
	public static String postfix = "";
	public static String finalpost = "";

	public static HashMap<Character, Integer> precedence = new HashMap<>();
	public static String infix2postfix(String infix) 
	{
		Stack<Character> myStack = new Stack<>();

		LoadPrecedence();

		// Read all the symbols one by one from left to right in the given Infix expression.

		for (int i = 0; i < infix.length(); i++) 
		{

			char c = infix.charAt(i);

			//If the token is an operand (numbers or variables), then directly add it to the result (postfix).
			if (c >= '0' && c <= '9') 
			{
				postfix += c;
			}

			//If the token is a '(' or '{', then push it.
			if (c == '(' || c == '{') 
			{
				myStack.push(c);
			}

			// If the reading symbol is a ')' or '}',
			// Pop all the contents of stack until respective ( or { is popped and add each popped symbol to the result (postfix).
			// ( and { are not added to the postfix (throw it away).
			if (c == ')') 
			{
				while (myStack.peek() != '(') 
				{
					postfix += myStack.pop();
				}
				myStack.pop(); // this is '(', throw it away
			}

			if (c == '}') 
			{
				while (myStack.peek() != '{') 
				{
					postfix += myStack.pop();

				}
				myStack.pop(); // This is '{', throw it away
			}

			
			// If the token is an operator (+ , - , * , /)
			// If top of the stack is ( or {, OR stack is empty, push it.
			// else, pop the operators which are already on the stack that have higher or equal
			// precedence than the token, and add them to the postfix.
			// After that, push the token.
			if (c == '+' || c == '-' || c == '*' || c == '/') 
			{

				if (myStack.isEmpty() || myStack.peek() == '(' || myStack.peek() == '{') 
				{
					myStack.push(c);
				}

				else 
				{
					while (!myStack.isEmpty() && precedence.get(myStack.peek()) >= precedence.get(c)) 
					{
						postfix += myStack.pop();
					}
					myStack.push(c);

				}

			} // end if

		} // end for

		while (!myStack.isEmpty()) 
		{
			postfix += myStack.pop();
		}
		
		finalpost = postfix; // this creates a temporary variable, the final postfix, is so that postfix is cleared out for the next expression the user gives
		postfix = ""; // resets postfix for the next expression
		
		return finalpost;
	}
	
	//loads the order of the operands in the expression
	public static void LoadPrecedence() 
	{
		precedence.put('+', 1);
		precedence.put('-', 1);
		precedence.put('*', 2);
		precedence.put('/', 2);
	}

}
