import java.util.Scanner;
/**
 * This class displays the minimal cost to convert the 
 * first string to the second string.
 *
 * @author Lohit Velagapudi
 *
 */
public class StringConvert{
  
   /**
    * The main method
    * @param args String to be ignored
    */
   public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      String str1=sc.next();
      String str2=sc.next();

      int result=getOptimalCost(str1, str2);
      System.out.println(result);
   }
  
   /**
    * This method calculates the minimum cost to convert
    * string 1 to string 2.
    *
    * @param str1 String string 1
    * @param str2 String string 2
    * @return int minimal cost to convert the strings
    */
   static int getOptimalCost(String str1, String str2){
      int len1=str1.length();
      int len2=str2.length();

      int[][] matrix=new int[len1+1][len2+1];

      for(int i=0; i<len1+1; i++){
         matrix[i][0]=3*i;
      }
      for(int j=0; j<len2+1; j++){
         matrix[0][j]=4*j;
      }

      boolean flag=false;

      for(int j=1; j<len2+1; j++){
         for(int i=1; i<len1+1; i++){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
               matrix[i][j]=matrix[i-1][j-1];
            }
            else if(!flag){
               if((matrix[i-1][j]+3)<(matrix[i][j-1]+4)){
                  matrix[i][j]=matrix[i-1][j]+3;
               }
               else if((matrix[i-1][j]+3)>(matrix[i][j-1]+4)){
                  matrix[i][j]=matrix[i][j-1]+4;
               }
               else{
                  matrix[i][j]=matrix[i][j-1]+4;
                  flag=true;
               }
            }
            else if(flag){
               flag=false;
               matrix[i][j]=matrix[i-1][j]-2;
            }
         }
      }
      return matrix[len1][len2];
   }
}
