package stack;

public class Stack<T> {
	
	private T[] items;
	private Node top;
	
	/**
	 * create a new stack of type object, 10 units long
	 * @param o
	 */
	Stack(){
		top = null;
	}
	
	public void push(T data) {
		this.top = new Node(data,this.top);
	}
	
	public T peek() {
		if(this.top == null) {
			System.out.println("Stack is empty");
			return null;
		} else {
			return (T) this.top.getData();
		}
	}
	
	public T pop() {
		
		if(this.top == null) {
			System.out.println("Stack is empty");
			return null;
		} else {
			T topValue = (T) this.top.getData();
			this.top =  this.top.getPrevious();
			return topValue;
		}
	}
	
	public boolean isEmpty() {
		
		if (this.top == null) return true;
		return false;
	}
}

