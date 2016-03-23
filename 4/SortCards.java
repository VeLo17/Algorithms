import java.util.Scanner;
/**
 * The SortCards class displays number of cards
 * that needs to be moved to sort the cards
 * 
 * @author Lohit Velagapudi
 *
 */
public class SortCards{
   /**
    * The main method
    *
    * @param args String to be ignored.
    */
   public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      int num=sc.nextInt();
      int[] arr=new int[num];
      
      for(int i=0; i<num; i++){
         arr[i]=sc.nextInt();
      }

      int length=longestSubseq(num, arr);
      System.out.println((num-length));
   }
   
   /**
    * This method returns the longest increasing subsequence
    *
    * @param num int size of the array
    * @param arr int array to be sorted 
    * 
    * @return int returns longest increasing subsequence
    */
   static int longestSubseq(int num, int[] arr){
       int[] tracker=new int[num];
      
       for(int i=0; i<num; i++){
          tracker[i]=1;
       }

       for(int i=1; i<num; i++){
         for(int j=0; j<num; j++){
           if(j<i && arr[j]<arr[i]){
              if(tracker[i]<(tracker[j]+1))
              	 tracker[i]=tracker[j]+1;             
            }
         }
       }
      int max=0;
      for(int i=0; i<num; i++){
         if(max<tracker[i]) max=tracker[i];
      }
      return max;
   }
}
