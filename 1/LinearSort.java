import java.util.Scanner;
import java.lang.Math;

/**
 * The LinearSort class sorts an array in O(n) time
 * 
 * @author Lohit Velagapudi
 *
 */
public class LinearSort{

   static int num;
   static long[] arr;

   public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      num=sc.nextInt();
      arr=new long[num];
      for(int i=0; i<num; i++){
         arr[i]=sc.nextLong();
      } 
      changeBasetoN();     
      long high_no=findHighest();
      radixSort(high_no);
      changeBasetoDec();
      for(int i=0; i<num; i++){
         System.out.print(arr[i]+" ");
      }
      System.out.println();
   }

   /**
    * The radixSort() method sorts an array in linear time
    *
    * @param highest the highest number in the array to be sorted(type long)
    *
    */
   static void radixSort(long highest){
      long [][] order_by_digit=new long[num][num];
      int[] spot=new int[num];
      int msd=(int)Math.log10(highest);
      int digit;

      for(int i=0; i<=msd; i++){       
         for(int j=0; j<num; j++){
            spot[j]=0;
         }
         System.out.println("2");
         for(int j=0; j<num; j++){
            digit=((int)(arr[j]/Math.pow(10,i)))%10;
            order_by_digit[digit][spot[digit]]=arr[j];
            spot[digit]++;
         }
         System.out.println("3");
         int c=0;
         for(int j=0; j<num; j++){
            for(int k=0; k<spot[j]; k++){
               arr[c]=order_by_digit[j][k];
               c++;
            }
         }
      }   
   }

   /**
    * The findHighest() method returns the highest number in an array
    *
    * @param none
    *
    * @return     returns the highest number of type long
    */ 
   static long findHighest(){
      long high=0;
      for(int i=0; i<num; i++){
         if(arr[i]>high){
            high=arr[i];
         }
      }
      return high;
   }

  /**
   * The changeBasetoN() method changes the base of all the numbers 
   * in the array to a base that is equal to size of the array
   *
   * @param none
   */

  static void changeBasetoN(){
     long val;
     int count;
     for(int i=0; i<num; i++){
        count=0;
        val=0;
        long mod;
        while(arr[i]!=0){
          mod= arr[i]%num;
          arr[i]=(long)arr[i]/num;
          val=val+(long)(mod*Math.pow(10, count));
          count++;
        }
        arr[i]=val;
     }
  }

  /**
   * The changeBasetoDec() method changes the base of the numbers
   * in the array to 10
   *
   * @param none
   *
   */

  static void changeBasetoDec(){
     long val;
     int count;
     for(int i=0; i<num; i++){
        count=0;
        val=0;
        long mod;
        while(arr[i]!=0){
          mod= arr[i]%10;
          arr[i]=(long)arr[i]/10;
          val=val+(long)(mod*Math.pow(num, count));
          count++;
        }
        arr[i]=val;
     }
  }

 
}
