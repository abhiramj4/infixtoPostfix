package stack;

public class Stack<T> {
	
	private int items;
	private Node top;
	
	/**
	 * create a new stack of some type
	 */
	Stack(){
		top = null;
	}
	
	/**
	 * create a new stack, set the top to null
	 */
	public void createStack(){
		top = null;
	}
	
	/**
	 * Push a new value to the stack
	 * 
	 * @param data value to create a new stack node
	 */
	public void push(T data) {
		this.top = new Node(data,this.top);
		items++;
	}
	
	/**
	 * look at the first element of the stack, if the stack is
	 * empty then print a empty stack message
	 * 
	 * @return the first element of the stack
	 */
	public T peek() {
		if(this.top == null) {
			System.out.println("Stack is empty");
			return null;
		} else {
			return (T) this.top.getData();
		}
	}
	
	/**
	 * remove the first element of the stack, if the stack is
	 * empty then print a empty stack message
	 * 
	 * @return the first element of the stack that was removed
	 */
	public T pop() {
		
		if(this.top == null) {
			System.out.println("Stack is empty");
			return null;
		} else {
			T topValue = (T) this.top.getData();
			this.top =  this.top.getPrevious();
			items--;
			return topValue;
		}
	}
	
	/**
	 * remove all elements of the stack
	 * 
	 */
	public void popAll() {
		
		while(!isEmpty()) {
			this.pop();
		}
	}
	
	/**
	 * Check if the stack is empty
	 * @return true if the stack is empty
	 */
	public boolean isEmpty() {
		
		if (this.top == null) return true;
		return false;
	}
}

