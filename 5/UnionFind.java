/**
 * The UnionFind data structure for Kruskal's algorithm
 *
 * @author Lohit Velagapudi
 *
 */
class UnionFind{
     int[] boss;
     int[] size;

     /**
      * The UnionFind constructor
      */
     UnionFind(int length){
          boss=new int[length];
          size=new int[length];
     }

     /**
      * The init method initializes the boss and size
      */
     void Init(int x){
          boss[x]=x;
          size[x]=1;
     }

     /**
      * returns boss of a certain node
      */
     int Find(int x){
          return boss[x];
     }

     /**
      * The union method unites the sets of 2 nodes
      */
     void Union(int u, int v){
          if(size[boss[u]]>=size[boss[v]]){
               size[boss[u]]=size[boss[u]]+size[boss[v]];
               int t=boss[v];
               for(int i=0; i<boss.length; i++){
                    if(boss[i]==t){ boss[i]=boss[u]; }
               }
          }
          else{
               size[boss[v]]=size[boss[v]]+size[boss[u]];
               for(int i=0; i<boss.length; i++){
                    if(boss[i]==boss[u]) {boss[i]=boss[v];}
               }
          }
     }
}
