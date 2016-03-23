/**
 * This class holds the edge information
 *
 * @author Lohit Velagapudi
 *
 */ 
class Edge{
     private int node1;
     private int node2;
     private int weight;

     Edge(int n1, int n2, int wt){
          node1=n1;
          node2=n2;
          weight=wt;
     }

     /**
      * returns the node1
      */ 
     int getNode1(){
          return node1;
     }

     /**
      * returns the node2
      */
     int getNode2(){
          return node2;
     }

     /**
      * returns the weight of the edge
      */
     int getWeight(){
          return weight;
     }
}
