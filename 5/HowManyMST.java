import java.util.Scanner;
/**
 * This class displays the number of possible 
 * Minimum Spanning Trees for a given graph
 *
 * @author Lohit Velagapudi
 *
 */
public class HowManyMST{
     static Edge[] edge;

     /**
      * The main method
      * @param args String[] to be ignored
      */
     public static void main(String[] args){
          Scanner sc=new Scanner(System.in);
          int n=sc.nextInt();
          int m=sc.nextInt();
          edge=new Edge[m];
          int[] repeat=new int[m];
          for(int i=0; i<m; i++){
               int n1=sc.nextInt();
               int n2=sc.nextInt();
               int wt=sc.nextInt();
               edge[i]=new Edge(n1, n2, wt);
               repeat[i]=1;
          }

          edge=sortEdges(0, m-1);

          UnionFind uf=new UnionFind(n);
          for(int i=0; i<n; i++){
               uf.Init(i);
          }
          for(int i=0; i<m-1; i++){
               if(uf.Find(edge[i].getNode1())!=uf.Find(edge[i].getNode2())){
                    int t=i;
                    int count=0;
                    //System.out.println(i);
                    while(edge[i].getWeight()==edge[i+1].getWeight()){
                         boolean flag=false;
                         if(edge[i].getNode1()==edge[i+1].getNode1() && uf.Find(edge[i].getNode2())==uf.Find(edge[i+1].getNode2())){
                              count++;
                              flag=true;
                         }
                         else if(edge[i].getNode2()==edge[i+1].getNode2() && uf.Find(edge[i].getNode1())==uf.Find(edge[i+1].getNode1())){
                              count++;
                              flag=true;
                         }
                         else if(edge[i].getNode1()==edge[i+1].getNode2() && uf.Find(edge[i].getNode2())==uf.Find(edge[i+1].getNode1())){
                              count++;
                              flag=true;
                         }
                         else if(edge[i].getNode2()==edge[i+1].getNode1() && uf.Find(edge[i].getNode1())==uf.Find(edge[i+1].getNode2())){
                              count++;
                              flag=true;
                         }
                         if(flag && i<m-2) i++;
                         else{
                              i--;
                              break;
                         }
                         //System.out.println(i);
                    }
                    if(count>0) repeat[t]=repeat[t]+count;                    
                    uf.Union(edge[t].getNode1(), edge[t].getNode2());
               }
          }

          int result=1;
          for(int i=0; i<m; i++){
               result=result*repeat[i];
          }
          System.out.println(result);
     }

     /**
      * Sorts the edges by edge weight
      *
      * @param start int start of the array to be considered
      * @param end int end of the array to be considered
      *
      * @return  Edge[] returns a sorted array of edges
      */
     static Edge[] sortEdges(int start, int end){
          int mid=(int)(start+end)/2;
          Edge[] e1, e2;
          if(start!=end){
               e1=sortEdges(start, mid);
               e2=sortEdges(mid+1, end);
          }
          else{
               Edge[] t=new Edge[1];
               t[0]=edge[start];
               return t;
          }

          int i=0;
          int j=0;
          int k=0;

          Edge[] temp=new Edge[end-start+1];

          while(i<(mid-start+1) && j<(end-(mid+1)+1) && k<((end-start)+1)){
               if(e1[i].getWeight()<=e2[j].getWeight()){
                    temp[k]=e1[i];
                    i++;
                    k++;
               }
               else{
                    temp[k]=e2[j];
                    j++;
                    k++;
               }
          }
          while(i<(mid-start+1) && k<((end-start)+1)){
               temp[k]=e1[i];
               i++;
               k++;
          }
          while(j<(end-(mid+1)+1) && k<((end-start)+1)){
               temp[k]=e2[j];
               j++;
               k++;
          }
          return temp;
     }

}
