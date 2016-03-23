/**
 * The MyLinkedList class is used for storing list of objects.
 *
 * @author Lohit Velagapudi
 *
 */

public class MyLinkedList{
   
   /**
    * The Node class represents each node of a LinkedList.
    */
   
   private class Node{
      Node next=null;
      Object value;

      /**
       * The Node constructor for assigning the values
       *
       * @param data Object assign any type of object
       */
      Node(Object data){
         value=data;
      }

      /**
       * The Node constructor could assign the value and the next value
       *
       * @param data      Object assign any type of Object
       * @param next_data Node   reference to the next node
       */
      Node(Object data, Node next_data){
         next=next_data;
         value=data;
      }

      /**
       * The getValue() method returns the value
       *
       * @return Object returns the value
       */
      Object getValue(){
         return value;
      }

      /**
       * The setValue method sets the value.
       *
       * @param data Object value to be assigned
       */

      void setValue(Object data){
         value=data;
      }

      /**
       * The getNext() method returns the reference to next node
       *
       */
      Node getNext(){
         return next;
      }

      /**
       * The setNext() method assigns the next value
       * 
       * @param next_data Node Node next to the current node
       */
      void  setNext(Node next_data){
         next=next_data;
      }
   }
   
   Node head;
   int length;
   
   /**
    * The MyLinkedList() constructor creates a new LinkedList and creates the head
    * of the list.
    */
   MyLinkedList(){
      head=new Node(null);
      length=0;
   }
   
   /**
    * The add() method adds values to the linked list.
    *
    * @param data Object can add anyone type of object 
    */
   void add(Object data){
      Node new_node=new Node(data);
      Node current_node=head;

      while(current_node.getNext()!=null){
          current_node=current_node.getNext();
      }

      current_node.setNext(new_node);
      length++;
   }

   /**
    * The get() method returns the value at a postion
    *
    * @param pos int position of the value required
    * @return Object returns the object at that position
    */

   Object get(int pos){
      Node current_node=head;
      for(int i=-1; i<pos; i++){
         current_node=current_node.getNext();
      }
      return current_node.getValue();
   }

   /**
    * The getLength() method returns the number of values in the linked list
    *
    * @return int returns the linked list size
    */
   int getLength(){
     return length;
   }
}
