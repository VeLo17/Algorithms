import java.util.Scanner;

/**
 * The FindKthSmallest class displays the kth smallest element using O(k) space in O(n) time
 *
 * @author Lohit Velagapudi
 *
 */
 
public class FindKthSmallest{

   static int num;
   static int[] arr;

   /**
    * The main program.
    *
    * @param args String command line args(ignore) 
    */
   public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      num=sc.nextInt();
      int c=0;
      arr=new int[num];
      while(c<num){
         arr[c]=sc.nextInt();
         c++;
      }
      
      sort();

      int x=0;
      do{
        x=sc.nextInt();
        int r;
        for(int i=0; i<num; i++){
           if(x<arr[i] && x!=-1){
             r=i;
             int asd=num-1;
             while(asd!=i){
                arr[asd]=arr[asd-1];
                asd--;
             }
             arr[r]=x;
             break;
           }
        }
      }while(x!=-1);
      System.out.println(arr[num-1]);
   }

   /**
    * The sort() sorts the k-sized array
    *
    */
    
   static void sort(){
      for(int i=0; i<num; i++){
         for(int j=0; j<num-1; j++){
            if(arr[j]>arr[j+1]){
              int temp=arr[j];
              arr[j]=arr[j+1];
              arr[j+1]=temp;
            }
         }
      }
   }
}
