public class Stack {

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