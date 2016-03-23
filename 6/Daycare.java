import java.util.Scanner;
/**
 * The Daycare class returns if children at Daycare
 * could get to wear clothes as per their prefrence.
 * If yes, then returns the clothes they should be 
 * wearing, so that everyone gets their preferred 
 * clothing. The time complexity of the algorithm is
 * O(n^2*max(a,b,c))
 *
 * @author Lohit Velagapudi
 *
 */
public class Daycare{
     private static int n;
     private static int[] assignedChild;
     private static boolean[] seen;

     /**
      * The main method
      *
      * @param String args to be ignored
      */          
     public static void main(String[] args){
          Scanner sc=new Scanner(System.in);
          n=sc.nextInt();
          int a=sc.nextInt();
          int b=sc.nextInt();
          int c=sc.nextInt();
          
          int[][] hatPref=new int[n][a];
          int[][] mittenPref=new int[n][b];
          int[][] jacketPref=new int[n][c];

          for(int i=0; i<n; i++){
               int val=1;
               while(val!=0){
                    val=sc.nextInt();
                    if(val!=0) hatPref[i][val-1]=1;
               }
               val=1;
               while(val!=0){
                    val=sc.nextInt();
                    if(val!=0) mittenPref[i][val-1]=1;
               }
               val=1;
               while(val!=0){
                    val=sc.nextInt();
                    if(val!=0) jacketPref[i][val-1]=1;
               }
          }
          if(a<n || b<n || c<n){
               System.out.println("NO");
               return;
          }
          int[][] output=new int[n][3];
          assignedChild=new int[a];
          if(!isReqdChildPrefPossible(hatPref, a)){
               System.out.println("NO");
               return;
          }
          else{
               for(int i=0; i<a; i++){
                    if(assignedChild[i]>0) output[assignedChild[i]-1][0]=i+1;
               }
          }
          assignedChild=new int[b];
          if(!isReqdChildPrefPossible(mittenPref, b)){
               System.out.println("NO");
               return;
          }
          else{
               for(int i=0; i<b; i++){
                  if(assignedChild[i]>0)  output[assignedChild[i]-1][1]=i+1;
               }
          }
          assignedChild=new int[c];
          if(!isReqdChildPrefPossible(jacketPref, c)){
               System.out.println("NO");
               return;
          }
          else{
               for(int i=0; i<c; i++){
                  if(assignedChild[i]>0)  output[assignedChild[i]-1][2]=i+1;
               }
          }
          System.out.println("YES");
          for(int i=0; i<n; i++){
               for(int j=0; j<3; j++){
                    System.out.print(output[i][j]+" ");
               }
               System.out.println();
          }
     }

     /**
      * This method returns if every child could recieve their preferred 
      * hat, pair of mittens and jackets. This algortihm checks the max flow 
      * of the graph and returns false if the max flow is less than the number 
      * of children.
      *
      * @param matrix int[] childrens preferences of a particular clothing
      * @parma no_of_clothes int number of clothing of a particular type available
      *
      * @return boolean true if all children get their preffered clothing or else false
      */
     static boolean isReqdChildPrefPossible(int[][] matrix, int no_of_clothes){
              int no_of_assigned_child=0;

              for(int i=0; i<n; i++){
                    seen=new boolean[no_of_clothes];
                    if(assignClothToChild(i, matrix, no_of_clothes)) no_of_assigned_child++;                              
              }            
              return (no_of_assigned_child==n);
     }

     /**
      * This method assigns a child to each piece of clothing and changes a childs
      * clothing if that child has other alternatives and the current child has no
      * alternative but that clothing
      * 
      * @param child int current child number
      * @param matrix int[][] childrens preference for clothing
      * @param no_of_clothes int number of clothes of a particular type
      *
      * @return boolean true if the child gets a clothing
      */
     static boolean assignClothToChild(int child, int[][] matrix, int no_of_clothes){
          for(int i=0; i<no_of_clothes; i++){
               if(matrix[child][i]==1 && !seen[i]){
                    seen[i]=true;
                    boolean flag=false;
                    if(assignedChild[i]!=0) flag=assignClothToChild(assignedChild[i]-1, matrix, no_of_clothes);
                    if(assignedChild[i]==0 || flag){
                         assignedChild[i]=child+1;
                         return true;
                    }
               }
          }
          return false;
     }     
}
