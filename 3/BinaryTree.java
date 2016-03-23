/**
 * The BinaryTree class is used by the HuffmanDecoder class
 * for decoding 
 *
 * @author Lohit Velagapudi
 *
 */
public class BinaryTree{
   
   Node root;
   Node current;

   /**
    * The Node class represents each node in a binary tree
    */
   private class Node{
      Object center;
      Node left=null;
      Node right=null;
 
      /**
       * Node constructor
       */
      Node(){
         center=null;
      }
 
   }
 
   /**
    * BinaryTree constructor
    */
   BinaryTree(){
      root=new Node();
      current=root;
   }

   /**
    * The addRight method adds a new node to the right of the
    * current node and moves the current node right
    *
    * @param x Object the object to be added
    */
   void addRight(Object x){
      if(current.right==null) current.right=new Node();
      current.right.center=x;
      current=current.right;      
   }

   /**
    * The addLeft method adds a new node to the left of the  
    * current node and moves the current node left
    * 
    * @param x Object the object to be added
    */
   void addLeft(Object x){
      if (current.left==null) current.left=new Node();
      current.left.center=x;
      current=current.left;
   }

   /**
    * The reset method resets the current node to the root node
    */
   void reset(){
      current=root;
   }

   /**
    * The getRight method returns the node to the right of the 
    * current node and moves the current node right
    *
    * @return Object returns the object
    */
   Object getRight(){
      current=current.right;
      return current.center;
   }
   /**
    * The getLeft method returns the node to the left of the 
    * current node and moves the current node to the left.
    */

   Object getLeft(){
      current=current.left;
      return current.center;
   }
}
