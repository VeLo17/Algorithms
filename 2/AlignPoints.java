import java.util.Scanner;

/**
 * The AlignPoints class displays the maximum  number 
 * of given points that are aligned when a fold is made
 * 
 * @author Lohit Velagapudi
 *
 */
public class AlignPoints{
   static int num;
   static int[] x;
   static int[] y;
   static Perpendiculars[] perp;

   /**
    * The main method
    *
    * @param args command line args(ignore)
    */
   public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      num=sc.nextInt();
      x=new int[num];
      y=new int[num];
      for(int i=0; i<num; i++){
         x[i]=sc.nextInt();
         y[i]=sc.nextInt();
      }
      setPerpendiculars(); 
      perp=sortPerpendiculars(0, ((num*(num-1))/2)-1);
      countLines();
   }

   /**
    * The setPerpendicular() method calculates the slope
    * and y-intercept of the perpendicular bisector of 
    * all pair of points
    */
   static void setPerpendiculars(){
      perp=new Perpendiculars[(num*(num-1))/2];
      int ctr=0;
      int te=0;
      for(int i=0; i<num; i++){
         for(int j=i+1; j<num; j++){
            double slope;
            double c;
            if((y[i]-y[j])!=0){
               slope=(double)-(x[i]-x[j])/(y[i]-y[j]);
               c=(double)(((double)(y[i]+y[j])/2)-slope*(double)(x[i]+x[j])/2);
            }
            else{ 
               slope=1000; 
               c=(double)(x[i]+x[j])/2.0;
            } 
            perp[ctr]=new Perpendiculars(slope, c);
            ctr++;   
         }
      }
   }
   
   /**
    * The sortPerpendicular() method sorts all the perpendiculars
    * by their slope and y-intercept
    *
    * @param start int start of the reqd porrtion of the  array
    * @param end   int end of the reqd portion of the array
    *
    * @return Perpendiculars[] returns a sorted array of Perpendiculars type
    * 
    */

   static Perpendiculars[] sortPerpendiculars(int start, int end){
      int mid=(int)(start+end)/2;
      Perpendiculars[] p1, p2;
      if(start!=end){
         p1=sortPerpendiculars(start, mid);
         p2=sortPerpendiculars(mid+1, end);
      }
      else{
         Perpendiculars[] t=new Perpendiculars[1];
         t[0]=new Perpendiculars(perp[start].getSlope(), perp[start].getC());
         
         return t;
      }
      int i=0;
      int j=0;
      int k=0;
      
      Perpendiculars[] temp=new Perpendiculars[end-start+1];
      while(i<(mid-start+1) && j<(end-(mid+1)+1) && k<(end-start+1)){
         if(p1[i].getSlope()<p2[j].getSlope()){
            temp[k]=p1[i];
            i++;
            k++;  
         }
         else if(p1[i].getSlope()>p2[j].getSlope()){
            temp[k]=p2[j];
            j++;
            k++;
        }
        else if(p1[i].getC()<p2[j].getC()){
           temp[k]=p1[i];
           i++;
           k++;
        }
        else{
           temp[k]=p2[j];
           j++; 
           k++;
        }
      }
      while(i<(mid-start+1) && k<(end-start+1)){
         temp[k]=p1[i];
         i++;
         k++;
      }
      while(j<((end-mid+1)+1) && k<(end-start+1)){
         temp[k]=p2[j];
         j++;
         k++;
      }
      return temp;
   }


  /**
   * The countLines() method counts the perependiculars having the same
   * slope and y-intercept
   *
   */
  static void countLines(){
     double slope=perp[0].getSlope();
     double c=perp[0].getC();
     int count=0;
     int max_count=0;

     for(int i=0; i<((num*(num-1))/2); i++){
        if(slope==perp[i].getSlope() && c==perp[i].getC()){
           count++;
        }
        else{
           slope=(double)perp[i].getSlope();
           c=(double)perp[i].getC();
           if(max_count<count)  max_count=count;
           count=1;
        }
     }
     if(max_count==0) System.out.println(count);
     else System.out.println(max_count);
  }
}
