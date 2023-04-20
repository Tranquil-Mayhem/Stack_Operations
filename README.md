ExpressionEvaluation.java is a program that evaluates whether or not the expression
the user input is valid. If valid, returns true and the user input. It can be 
evaluated in MyExpressionTest.java. If not valid, this program identifies 
the location of the user's error by printing a message with feedback and a 
location of where the user went wrong.Then this program returns false so 
that the Expression Test program knows to move on with the program without 
evaluating

InfixToPostfix.java is a program that converts the user input infix to a postfix 
expression. It reads all the symbols and places them in order so that the parentheses, 
curly braces and operations with higher precedence are all correctly placed.

PostfixEvaluation.java is the postfix evaluation program for these Stack Operations.
it takes the postfix expression from the InfixToPostfix program and evaluates it 
like a calculator would, returning the result as a single integer

To see the working program, compile and run MyExpressionTest.java. This is the test 
program for these Stack Operations. This program asks for user input and checks to see 
if their expression is valid. If valid, returns their expression as an infix expression, 
postfix expression and the evaluated result
