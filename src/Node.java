
public class Node 
{
	public Object data;		// generic data type, will be patients in this case
	public Node next;		// link to the next node in the list
	public Node previous;	// link to the previous node in the list
	
	// node constructor
	public Node(Object data, Node next, Node previous)
	{
		this.data = data;
		this.next = next;
		this.previous = previous;
	}
	
	// getters and setters for each of the variables
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
	public void remove()
	{
		
	}
	
	
}
