/**
 * The BackTracker class is used to store the positions
 * in the matrix that led to the current position in the matrix
 */
class BackTracker{
   int x1;
   int y1;
   int x2;
   int y2;

   /**
    * A setter for BackTracker class
    * @param a int dimension 1 for 1st value in matrix
    * @param b int dimension 2 for 2nd value in matrix
    */
   void setPoints(int a, int b, int c, int d){
      x1=a;
      y1=b;
      x2=c;
      y2=d;
   }

   /**
    * A getter for x1.
    * @return int
    */
   int getX1(){
      return x1;
   }

   /**
    * A getter for y1
    * @return int
    */
   int getY1(){
      return y1;
   }

   /**
    * A getter for x2
    * @return int
    */
   int getX2(){
      return x2;
   }

   /**
    * A getter for y2
    * @return int
    */
   int getY2(){
      return y2;
   }
}

