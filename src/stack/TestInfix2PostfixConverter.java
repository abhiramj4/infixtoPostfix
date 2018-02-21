package stack;

import java.util.Scanner;

public class TestInfix2PostfixConverter {

	/**
	 * check to see if current character is an operand
	 * @param c, character at expression
	 * @return true, if c is an operand
	 */
	private static boolean isOperand(char c) {
		
		if(c >= '0' && c <= '9') return true;
		return false;
	} 
	
	/**
	 * check to see if current character is an operator
	 * @param c, character at expression
	 * @return true, if c is an operator
	 */
	private static boolean isOperator(char c) {
		
		if (c == '*' || c == '-' || c == '/' || c == '+') return true;
		
		return false;
	}
	
	/**
	 * get the weight of an operator, * and / has higher weight than + or - 
	 * @param op, character operator
	 * @return, int weight
	 */
	private static int getOperatorWeight(char op) {
		
		int weight = 0;
		
		if (op == '+' || op == '-') {
			weight = 1; //classified as weight 1
		}
		if (op == '*' || op == '/' ) {
			weight = 2; //classified as weight 2
		}
		return weight;
	}
	
	/**
	 * Given two operators, check which has higher precedence
	 * @param op1, operator 1
	 * @param op2, operator 2
	 * @return true if operator 1 has the same weight as operator 2
	 */
	private static boolean hasHigherPrecedence(char op1, char op2) {
		
		//get operator weights, this is used for 
		//parsing
		int op1Weight = getOperatorWeight(op1);
		int op2Weight = getOperatorWeight(op2);
		
		if (op1Weight == op2Weight) {
			return true;
		}
		
		//if op1wiehgt is greater than the second opweight, return true
		//else return false
		return op1Weight > op2Weight ? true: false;
		
	}
	
	/**
	 * Convert infix expression to postfix
	 * @param expression infix expression
	 * @return String, representation of infix expression
	 */
	public static void  infixtoPostfix(String expression) {
		
		String postFix = ""; //final postfix expression init
		
		Stack<Character> operatorStack = new Stack<Character>(); //character stack for operators
	
		//loop through the infix expression
		for(int i = 0; i < expression.length(); i++) {
			
			//ignore spaces, just go to the second index
			while(expression.charAt(i) == ' ') {
				i++;
			}

			//is the character an operator?
			if (isOperator(expression.charAt(i))) {
				
				//checking to see if not empty and the top of the stack isn't a open bracket 
				//and the character at doesn't have higher precedence 
				//than the top of the stack (can't add to stack if top has 
				//lower precedence than current value)
				
				while(!operatorStack.isEmpty() && operatorStack.peek() != '(' && hasHigherPrecedence(operatorStack.peek(),expression.charAt(i))) {
					
					//append to postfix expression
					postFix += operatorStack.peek();
					//pop it
					operatorStack.pop();
				}
				
				//otherwise push
				operatorStack.push(expression.charAt(i));
				
				//if operand just add it
			} else if (isOperand(expression.charAt(i))) {
				
					//first add the first character
					postFix += expression.charAt(i);
					
					//accounts for multi digit numbers by adding a space if the next character is
					//not an operand
					//looks at the last number added (ex: 1[1] )
					//also make sure there isn't an index out of bounds
					
					if(i + 1 >= expression.length() || !isOperand(expression.charAt(i + 1))) {
					postFix += ' ';
				}
					
			//if open bracket, push
			//bracketed expressions should be treated as their own
			//expression
			} else if (expression.charAt(i) == '(') {
				
				operatorStack.push(expression.charAt(i));
				
			} else if (expression.charAt(i) == ')') {
				
				//pop until closing brace
				while(!operatorStack.isEmpty() && operatorStack.peek() != '(') {
					postFix += operatorStack.peek();
					operatorStack.pop();
				}
				operatorStack.pop();
			}
			
			
		}
		
		//after all this, just place whatever is in the stack into the postfix expression
		while(!operatorStack.isEmpty()) {
			postFix += operatorStack.peek();
			operatorStack.pop();
		}
		
		System.out.println("Infix: " + expression.toString());
		System.out.println("Postfix: " + postFix.toString());
		System.out.println("Result: " + evaluate(postFix));
		
		//return postFix;
		
		
	}
	
	public static Double evaluate(String postfix) {
		
		Stack<Double> operatorStack = new Stack<Double>();
		char[] characters = postfix.toCharArray();
		
		for(int i = 0; i < characters.length;i++) {
			char c = characters[i];
			
			if(isOperator(c)) {
				
                switch (c) {
                case '+': operatorStack.push(operatorStack.pop() + operatorStack.pop());     break;
                case '*': operatorStack.push(operatorStack.pop() * operatorStack.pop());     break;
                case '-': operatorStack.push(-operatorStack.pop() + operatorStack.pop());    break;
                case '/': operatorStack.push(1 / operatorStack.pop() * operatorStack.pop()); break;
            } 				
			} else if (isOperand(c)) {
            	
            	operatorStack.push(0.0);
            	
                while (Character.isDigit(characters[i]))
                	operatorStack.push(10.0 * operatorStack.pop() + (characters[i++] - '0'));
            }
			
		}
		
		if(!operatorStack.isEmpty()) {
			return operatorStack.pop();
		} else {
			return 0.0;
		}
	}
	
	private static char[] convertMultidigit(char [] c) {
		
		//go through every character in the array
		//if we encounter a multi number expression, append the whole number into the index i
		//assuming that there are no spaces
		char [] newArray = new char[c.length];
		for(int i= 0; i < c.length - 1; i++) {
			char tempChar = ' ';
			
			while(isOperand(c[i + 1]) && isOperand(c[i])) {
				
				tempChar += c[i];
				
				
			}
		}
		
		return c;
		
	}
	
	public static void main (String[] args ) {
		
		//String h = "(11 / 2) * 3";
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter an infix expression");
		String h = reader.nextLine();
		infixtoPostfix(h);
		
		
		
		
	}
}