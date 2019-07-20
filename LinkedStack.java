import java.util.EmptyStackException;
import javax.xml.crypto.Data;

public class LinkedStack<T> 
{

	private Node<T> topNode;

	private static class Node<T> 
	{
		T data; // The data contained inside the Node.
		Node<T> next; // The next node in the LinkedStack.

		public Node(T data, Node<T> next) 
		{
			this.data = data;
			this.next = next;
		} // End of Node constructor. 
	} // End of Node subclass.
   
   //*****************************************************************************************
      
   /**
    * Push - adds a new Node to the top of the Stack.
    *
    * @param data - The data to be stored inside the Stack.
    */
	public void push(T data) 
	{
		Node<T> newNode = new Node<>(data, null);
		newNode.next = topNode;
		topNode = newNode;
	} // End of push.
   
   //*****************************************************************************************
   
   /**
    * Pop - Removes the top Node from the Stack.
    *
    * @return data - The removed piece of data.
    */
	public T pop() 
	{
		if (isEmpty()) 
		{
			throw new EmptyStackException();
		}
		T data = topNode.data;
		topNode = topNode.next;
		return data;
	} // End of pop.
   
   //*****************************************************************************************
   
   /**
    * isEmpty - Checks to see if the Stack is currently empty.
    *
    * @return - A boolean response to whether or not the Stack is empty.
    */
	public boolean isEmpty() {
		return topNode == null;
	} // End of isEmpty.

   //*****************************************************************************************
   
   /**
    * Clear - sets the top Node to null, effectively clearing the Stack.
    */
	public void clear()
	{
		topNode = null;
	} // End of clear.
   
   //*****************************************************************************************
      
   /**
    * Peek - Shows the user the top Node in the Stack.
    *
    * @return - The data from inside of the top Node.
    */  
	public T peek() {
		if (isEmpty()) 
		{
			throw new EmptyStackException();
		}
		return topNode.data;
	} // End of peek.
} // end of LinkedStack.