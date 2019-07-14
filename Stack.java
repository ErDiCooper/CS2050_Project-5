import java.util.EmptyStackException;

public class Stack<T> {

   private Node<T> topNode;
   
   public Stack () {
      topNode = null;
   } // End of default constructor.
   
   
   //*****************************************************************************************
      
      /**
       * Push - adds a new Node to the top of the Stack.
       *
       * @param newEntry - The data to be stored inside the Stack.
       */
   public void push (T newEntry) {
      Node newNode = new Node(newEntry, topNode);
      topNode = newNode;
   } // End of push.
   
   //*****************************************************************************************
      
      /**
       * Peek - Shows the user the top Node in the Stack.
       *
       * @return - The data from inside of the top Node.
       */   
   public T peek() {
      if(isEmpty()) {
         throw new EmptyStackException();
      }
      else {
         return topNode.getData();
      }
   } // End of peek.
   
   //*****************************************************************************************
      
      /**
       * Pop - Removes the top Node from the Stack.
       *
       * @param top - The data from inside of the removed Node.
       */
   public T pop() {
      T top = peek();
      
      topNode = topNode.getNext();
      
      return top;
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
   public void clear() {
      topNode = null;
   } // End of clear.





//*****************************************************************************************
//*****************************************************************************************

   private class Node<T> {
      private T    data;
      private Node<T> next; // Reference to next node in the List.
   
      private Node(T dataPortion) {
         this(dataPortion, null);
      } // End of first Node constructor.
      
      private Node(T dataPortion, Node<T> nextNode) {
         data = dataPortion;
         next = nextNode;
      } // End of second Node constructor.   
      
//*****************************************************************************************
      
      /**
       * Gets data from the Node
       *
       * @return data
       */
      private T getData() {
         return data;
      } // End of getData.
      
//*****************************************************************************************

      /**
       * Sets new data for the node
       *
       * param newData - newData for the Node
       */
      private void setData(T newData) {
         data = newData;
      } // End of setData.
      
//*****************************************************************************************

      /**
       * Gets the next Node.
       *
       * @return next
       */
      private Node getNext() {
         return next;
      } // End of getNext.
      
//*****************************************************************************************

      /**
       * Sets a new next Node.
       *
       * @param nextNode - the new next Node.
       */
      private void setNext(Node<T> nextNode) {
         next = nextNode;
      } // End of setNext.
      
   } // End of Node class.

} // end of Stack class.