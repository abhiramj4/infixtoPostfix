package stack;

public class Node<T> extends Object {

	private T data;
	private Node previous;
	
	public Node(T data, Node previous) {
		this.data = data;
		this.previous = previous;
	}
	
	public T getData() {
		return data;
	}
	
	public Node getPrevious() {
		return previous;
	}
}
