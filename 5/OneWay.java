import java.util.Scanner;

public class OneWay{

     static boolean[] seen;
     static int[] finish;
     static int time;
     static int[] top_order;
     static int n;
     static int[][] matrix;
     static int[][] transpose;
     static int[] seen2;
     static int no_of_components;
     static boolean component_flag;
     static MyLinkedList[] list;
     static int num;
     
     public static void main(String[] args){
          Scanner sc=new Scanner(System.in);
          n=sc.nextInt();
          matrix=new int[n+1][n+1];
          transpose=new int[n+1][n+1];

          int i=1;
          while(i<n+1){
               while(true){
                    int t=sc.nextInt();
                    if(t!=0) {
                         matrix[i][t]=1;
                         transpose[t][i]=1;
                    }
                    else break;
               }
               i++;
          }

          seen=new boolean[n+1];
          finish=new int[n+1];
          time=0;
          for(i=1; i<n+1; i++){
               if(!seen[i]) DFS(i);
          }
          top_order=new int[n+1];
          topologicalSort();

          seen=new boolean[n+1];
          no_of_components=0;
          for(i=0; i<n; i++){
               if(!seen[i]){
                     no_of_components++;
                     DFS2(top_order[i]);
               }
          }

          list=new MyLinkedList[no_of_components];

          num=0;
          seen=new boolean[n+1];
          no_of_components=0;
          for(i=0; i<n; i++){
               if(!seen[i]){
                     list[num]=new MyLinkedList();

                     DFS3(top_order[i]);
                     num++;
               }
          }          

          for(i=0; i<num-1; i++){
               for(int j=0; j<list[i].getLength(); i++){
                    System.out.print(list[i].get(j)+" ");
               }
               System.out.println();
          }                   
     }

     static void DFS(int i){
          seen[i]=true;
          for(int j=1; j<n+1; j++){
               if(matrix[i][j]==1 && !seen[j]) DFS(j);
          }
          time++;
          finish[i]=time;
     }
     
     static void DFS2(int i){
          seen[i]=true;
          for(int j=1; j<n+1; j++){
               if(transpose[i][j]==1 && !seen[j]) DFS2(j);
          }
     }

     static void DFS3(int i){
          seen[i]=true;
          //list[num].add(i);
          for(int j=1; j<n+1; j++){
               if(transpose[i][j]==1 && !seen[j]){ 
                    DFS2(j);
                    list[num].add(j);
               }
          }
     }

     static void topologicalSort(){
          for(int i=0; i<n+1; i++){
               top_order[i]=i;
          }
          for(int i=0; i<n+1; i++){
               for(int j=0; j<n; j++){
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
}
