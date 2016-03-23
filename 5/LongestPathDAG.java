import java.util.Scanner;
/**
 * This class displays the Longest Path in a DAG
 *
 * @author Lohit Velagapudi
 *
 */
public class LongestPathDAG{
     static int[][] input;
     static int num;
     static boolean[] seen;
     static int[] finish;
     static int time;
     static int[] top_order;

     /**
      * The main method
      *
      * @param args String[] to be ignored
      */    
     public static void main(String[] args){
          Scanner sc=new Scanner(System.in);
          num=sc.nextInt();
          input=new int[num+1][num+1];
          for(int i=0; i<(num+1); i++){
               for(int j=0; j<(num+1); j++){
                    input[i][j]=0;
               }
          }                   
          int i=1;
          int j=1;
          while(i<(num+1)){
               while(true){
                    int n=sc.nextInt();
                    if(n!=0) input[i][n]=1;
                    else break;
               }
               i++;
          }
          seen=new boolean[num+1];
          finish=new int[num+1];
          time=0;
          for(i=1; i<num+1; i++){
               if(!seen[i]) DFS(i);
          }
          topologicalSort();
          System.out.println(longestPath());
          
     }

     /**
      * This method returns the longest path in a DAG 
      * using the topological ordering of the vertices
      * 
      * @return int the longest path in the DAG
      */
     static int longestPath(){
          int[] out=new int[num];
          for(int i=0; i<num; i++){
               out[i]=0;
          }
          for(int i=0; i<num; i++){
               for(int j=i+1; j<num; j++){
                    if(input[top_order[i]][top_order[j]]==1 && out[j]<out[i]+1) out[j]=out[i]+1;
               }
          }
          int max=0;
          for(int i=0; i<num; i++){
               if(out[i]>max) max=out[i];
          }
          return max;
     }

     /**
      * This method topologically sorts the vertices
      * and uses finish time of the vertices while performing 
      * a DFS 
      */
     static void topologicalSort(){
          top_order=new int[num+1];
          for(int i=0; i<num+1; i++){
               top_order[i]=i;
          }
          for(int i=0; i<num+1; i++){
               for(int j=0; j<num; j++){
                    if(finish[j]<finish[j+1]){
                         int temp=finish[j];
                         finish[j]=finish[j+1];
                         finish[j+1]=temp;
                         temp=top_order[j];
                         top_order[j]=top_order[j+1];
                         top_order[j+1]=temp;
                    }
               }
          }
     }

     /**
      * This method performs a depth first traverasl of the vertices
      * and assigns finish time to the vertices
      * 
      * @param i int vertex on which DFS is performed
      */
     static void DFS(int i){
          seen[i]=true;
          for(int j=1; j<num+1; j++){
               if(input[i][j]==1 && !seen[j]) DFS(j);
          }
          time++;
          finish[i]=time;
     }
}
