import java.util.Scanner;
/**
 * The MatrixChainParanthesize takes in the number of rows
 * and columns of each matrix and returns the most optimal 
 * way to find the product and displays matrices with parenthesis
 * showing matrices which should be multiplied first.
 *
 * @author Lohit Velagapudi
 *
 */
public class MatrixChainParenthesize{
   static int num;
   static int[] r;
   static int[] c;
   static int[][] matrix;
   static BackTracker[][] tracker;

   /**
    * The main method.
    * @param args String[] to be ignored
    */
   public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      num=sc.nextInt();
      int[] in=new int[num+1];
      for(int i=0; i<num+1; i++){
         in[i]=sc.nextInt();
      }

      r=new int[num];
      c=new int[num];

      for(int i=0; i<num; i++){
         r[i]=in[i];
         c[i]=in[i+1];
      }
      matrixMultiplication();
   }

   /**
    * This method uses a matrix to find the optimal
    * number of steps to find the product of matrices
    * and the steps to find the optimal number of steps 
    * are kept track using a class BackTracker.
    */
   static void matrixMultiplication(){
      matrix=new int[num][num];

      for(int i=0; i<num; i++){
         matrix[i][i]=0;
      }

      tracker=new BackTracker[num][num];
      for(int i=0; i<num; i++){
         for(int j=0; j<num-i; j++){
            int s=i+j;
            matrix[j][s]=0;
            tracker[j][s]=new BackTracker();
            int temp;
            for(int k=j; k<s; k++){
               temp=matrix[j][k]+matrix[k+1][s]+(r[j]*c[k]*c[s]);
               if(matrix[j][s]==0){
                  matrix[j][s]=temp;
                  tracker[j][s].setPoints(j, k, k+1, s);
               }
               else if(temp<matrix[j][s]){
                  matrix[j][s]=temp;
                  tracker[j][s].setPoints(j, k , k+1, s);
               }
            }
         }
      }
      String result=getProductParentheses(0, num-1);
      System.out.println(result);
   }

  /**
   * The method uses the steps stored using BackTracker
   * class to return the parentheses required to get the
   * optimal product
   *
   * @param int a position in matrix
   * @param int b position in matrix
   * @return String returns optimal paranthesis at each step  
   */
  static String getProductParentheses(int a, int b){
     if(a==b) return "A"+(a+1);
     int x1=tracker[a][b].getX1();
     int y1=tracker[a][b].getY1();
     int x2=tracker[a][b].getX2();
     int y2=tracker[a][b].getY2();
     return("( "+getProductParentheses(x1, y1)+" x "+getProductParentheses(x2, y2)+" )");
     
  }
}
