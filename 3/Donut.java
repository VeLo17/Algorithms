import java.util.Scanner;
import java.lang.Math;

/**
 * The Donut class returns the total distance between the ideal postion
 * for donut store by finding it and each police clar
 *
 * @author Lohit Velagapudi
 *
 */ 
public class Donut{
   static int num;
   static int[] x;
   static int[] y;
   static int mid_x;
   static int mid_y;
   static int dist;

   /**
    * The main method
    * 
    * @param args String[] to be ignored
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

      calcMidPoint();
      calcDistance();
      System.out.println(dist);      
   }

   /**
    * The calcMidPoint() finds the ideal position for the Donut store
    */
   static void calcMidPoint(){
      int sum_x=0;
      int sum_y=0;
      for(int i=0; i<num; i++){
         sum_x=sum_x+x[i];
         sum_y=sum_y+y[i];
      }
      mid_x=(int)sum_x/num;
      mid_y=(int)sum_y/num;
   }

   /**
    * The calcDistance() calcualtes the sum of distances between 
    * each police car and store.
    */
   static void calcDistance(){
      dist=0;
      for(int i=0; i<num; i++){
         dist=dist+Math.abs(mid_x-x[i])+Math.abs(mid_y-y[i]);
      }      
   }
}
