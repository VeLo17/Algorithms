/**
 * The Perpendiculars class stores the slope and y-intercept of the 
 * perpendiculars
 *
 * @author Lohit Velagapudi
 *
 */

public class Perpendiculars{
   double slope;
   double c;
  
   /**
    * Perpendiculars parameterized constructor
    *
    * @param s double slope of the perpendicular
    * @param val double y-intercept of the perpendicular 
    */
     
   Perpendiculars(double s, double val){
      slope=s;
      c=val;
   }

   /**
    * The getSlope() returns the slope of the perpendicular
    * 
    * @return double returns slope value
    */
   double getSlope(){
      return slope;
   }

   /**
    * The getC() method returns the y-intercept of the perpendicular
    *
    * @return double returns the y-intercept
    */
   double getC(){
      return c;
   }
}
