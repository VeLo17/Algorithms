//Author: Lohit Velagapudi

import java.util.Scanner;

public class Robot{

   static int[] arr;
   static int num;

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
      
      boolean pos_result=possibility();
      if(!pos_result){
         System.out.println("IMPOSSIBLE");
      }
      else{
         System.out.println("POSSIBLE");
         sortDVD();
      }
   }

   /* The method sortDVD() sorts the DVDs as per the stack number.
    * If a stack has more than the reqd number of DVDs then it is 
    * shifted to the right. If a particular stack has less than the
    * reqd number of DVDs then the value is stored in a variable(reqd_left).
    * if reqd_left is greater than 0 then the shifting to the right stack
    * doesn't happen when a stack has more than the reqd no of DVDs and the 
    * extra number of DVDs are stored in a variable(excess_right). When the 
    * excess_right is greater than or equal to reqd_left then the DVDs start
    * shifting to the left and the reqd_left and excess_right values are 
    * subtracted as the stacks get the desired number of DVDs. The shifting 
    * to the left happens till the reqd_left is greater than 0. If excess_right
    * is greater than 0 then that value is moved to its right and excess_right 
    * is set to 0.
    */

   static void sortDVD(){
      int reqd_left=0;            //if a stack has less number of DVDs
      int excess_right=0;         //if a stack has more number of DVDs
      int current_stack_no=0;
      int set_stack_no=0;         //stacks that have required number of DVDs
      int no_of_moves=0;
      int[] move=new int[num];
      int[] source=new int[num];
      int[] dest=new int[num];

      while(set_stack_no<num){
         if(arr[current_stack_no]>(current_stack_no+1)){

            if(reqd_left==0){
               int extra_dvd=arr[current_stack_no]-(current_stack_no+1); 
               arr[current_stack_no]=current_stack_no+1;
               set_stack_no++;
               arr[current_stack_no+1]=arr[current_stack_no+1]+extra_dvd;
               move[no_of_moves]=extra_dvd;
               source[no_of_moves]=current_stack_no+1;
               dest[no_of_moves]=current_stack_no+2;
               no_of_moves++;
            }
             
            else if(reqd_left>0){
              excess_right=excess_right+(arr[current_stack_no]-(current_stack_no+1));
            }
         }

        else if(arr[current_stack_no]<(current_stack_no+1)){
           reqd_left=reqd_left+((current_stack_no+1)-arr[current_stack_no]); 
        }

        else if(arr[current_stack_no]==(current_stack_no+1) && reqd_left==0){
          set_stack_no++;
        }
        
        if(reqd_left<=excess_right && reqd_left!=0){
           int temp_current_stack_no=current_stack_no;
           int extra_dvd=arr[current_stack_no]-(current_stack_no+1)-(excess_right-reqd_left);
           arr[current_stack_no]=arr[current_stack_no]-extra_dvd;
           if(arr[current_stack_no]==(current_stack_no+1)){
              set_stack_no++;   
           }
           if(arr[current_stack_no-1]<current_stack_no){
              reqd_left=reqd_left-(current_stack_no-arr[current_stack_no-1]);
              excess_right=excess_right-(current_stack_no-arr[current_stack_no-1]);
           }
           arr[current_stack_no-1]=arr[current_stack_no-1]+extra_dvd;
           move[no_of_moves]=extra_dvd;
           source[no_of_moves]=current_stack_no+1;
           dest[no_of_moves]=current_stack_no;
           no_of_moves++;

           while(reqd_left>0){
              current_stack_no--;
              extra_dvd=arr[current_stack_no]-(current_stack_no+1);
              arr[current_stack_no]=current_stack_no+1;
              set_stack_no++;

              if(arr[current_stack_no-1]<current_stack_no){
                 reqd_left=reqd_left-(current_stack_no-arr[current_stack_no-1]);
                 excess_right=excess_right-(current_stack_no-arr[current_stack_no-1]);
              }
              arr[current_stack_no-1]=arr[current_stack_no-1]+extra_dvd;
              move[no_of_moves]=extra_dvd;
              source[no_of_moves]=current_stack_no+1;
              dest[no_of_moves]=current_stack_no;
              no_of_moves++;
           }
          
           if(reqd_left==0){
               set_stack_no++;
           }      
           current_stack_no=temp_current_stack_no;
           if(excess_right>0){
              extra_dvd=arr[current_stack_no]-(current_stack_no+1);
              arr[current_stack_no]=current_stack_no+1;
              set_stack_no++;
              arr[current_stack_no+1]=arr[current_stack_no+1]+extra_dvd;
              move[no_of_moves]=extra_dvd;
              source[no_of_moves]=current_stack_no+1;
              dest[no_of_moves]=current_stack_no+2;
              no_of_moves++;
              excess_right=0;    
           }    
        } 
        current_stack_no++;
      }
      System.out.println(no_of_moves);
      for(int i=0; i<no_of_moves; i++){
         System.out.println(source[i]+" "+dest[i]+" "+move[i]);
      }      
   }

   /* The method possibility() returns true if arranging the DVDs 
    * with respect to the stack nos is possible. To check this, the 
    * stack numbers and the number of DVDs are added and if they 
    * are equal then it is a possibility.
   */
   static boolean possibility(){
      int expected_sum=0;
      for(int i=1; i<=num; i++){
         expected_sum=expected_sum+i;      //the sum of the stack numbers are calculated
      }
      int sum_of_int=0;
      for(int i=0; i<num; i++){
         sum_of_int=sum_of_int+arr[i];    //the sum of the number of DVDs are calculated
      }
      if(expected_sum==sum_of_int){
         return true;
      }
      else{
         return false;
      }
   }
}
