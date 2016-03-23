import java.util.Scanner;

/**
 * The class IndexSearch displays true if the index 
 * of a an array matches its or else displays false
 * 
 * @author   Lohit Velagapudi
 *
*/
public class IndexSearch{
   static int num=0;
   static int[] arr;

   /**
    * The main program.
    *
    * @param args command line arguments(ignored)
    *
    */

   public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      num=sc.nextInt();
      arr=new int[num];
      for(int i=0; i<num; i++){
         arr[i]=sc.nextInt();
      }           
      String result=BinarySearch(0, num-1);
      System.out.println(result);
   }

   /**
    * The BinarySearch method compares the mid index value
    * with the value present at that position and decides the
    * range of index where the required answer would be present,
    * which in turn is used in calling the BinarySearch method.
    * 
    * @param start   the required start position in the array(type int)
    * @param end     the required end position in the array(type int)
    *
    * @return        returns true if search is a success or else false
    */

   static String BinarySearch(int start, int end){
      String result="FALSE";                    //default value to be returned
      int mid=(int)(end+start)/2;
      int size=(end-start+1);

      if(arr[mid]>mid && size>1){
         result=BinarySearch(start, mid);      //passing the new start & end points
      }  
      else if(arr[mid]<mid && size>1){
         result=BinarySearch(mid+1, end);     //passing the new start & end points
      }
      else if(arr[mid]==mid){
          result="TRUE";               //when search success result set to true
      }

      return result;
   }
}
