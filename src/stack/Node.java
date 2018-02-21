package stack;

public class Node<T> extends Object {

	private T data; //node data
	private Node previous; //previous node
	
	/**
	 * constructor for type node
	 * @param data the value held by the node
	 * @param previous data value of previous node
	 */
	public Node(T data, Node previous) {
		this.data = data;
		this.previous = previous;
	}
	
	/**
	 * get the node data
	 * @return the data of this node
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * get the previous node
	 * @return the previous node
	 */
	public Node getPrevious() {
		return previous;
	}
}
