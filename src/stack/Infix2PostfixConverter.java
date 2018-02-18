package stack;

public class Infix2PostfixConverter {

	private static boolean isOperand(char c) {
		
		if(c >= '0' && c <= '9') return true;
		return false;
	} 
	
	private static boolean isOperator(char c) {
		
		if (c == '*' || c == '-' || c == '/' || c == '+') return true;
		
		return false;
	}
	
	private static int getOperatorWeight(char op) {
		
		int weight = 0;
		
		if (op == '+' || op == '-') {
			weight = 1;
		}
		if (op == '*' || op == '/' ) {
			weight = 2;
		}
		return weight;
	}
	
	private static boolean hasHigherPrecedence(char op1, char op2) {
		
		//get operator weights, this is used for 
		//parsing
		int op1Weight = getOperatorWeight(op1);
		int op2Weight = getOperatorWeight(op2);
		
		if (op1Weight == op2Weight) {
			return true;
		}
		
		
		return op1Weight > op2Weight ? true: false;
		
	}
	
	
	public static char[]  infixtoPostfix(String expression) {
		
		//first convert expression to character array
		
		
		char[] infix = expression.toCharArray();
		
		Stack<Character> s = new Stack<Character>();
	
		return infix;
		
		
	}
	
	private static char[] convertMultidigit(char [] c) {
		
		//go through every character in the array
		//if we encounter a multi number expression, append the whole number into the index i
		//assuming that there are no spaces
		char [] newArray = new char[c.length];
		for(int i= 0; i < c.length - 1; i++) {
			char tempChar = ' ';
			
			if(isOperand(c[i + 1])) {
				
				tempChar += c[i];
				
				
			}
		}
		
		
		return c;
		
	}
	
	public static void main (String[] args ) {
		
		String h = "1 + 2       * 3";
		
		Stack<Character> s = new Stack<Character>();
		s.push('A');
		s.push('B');
		s.push('C');
		
		//while(!s.isEmpty()) {
			
			//System.out.print(s.peek());
			//s.pop();
		//}
		char[] c = infixtoPostfix(h);
		
		for(int i = 0; i < c.length; i++) {
			
			System.out.println(c[i]);
		}
		
		
		
		
	}
}
