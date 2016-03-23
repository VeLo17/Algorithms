class UnionFind{
     int[] boss;
     int[] size;

     UnionFind(int length){
          boss=new int[length];
          size=new int[length];
     }

     void Init(int x){
          boss[x]=x;
          size[x]=1;
     }

     int Find(int x){
          return boss[x];
     }

     void Union(int u, int v){
          if(size[boss[u]]>size[boss[v]]){
               size[boss[u]]=size[boss[u]]+size[boss[v]];
               for(int i=0; i<boss.length; i++){
                    if(boss[i]==boss[v]){ boss[v]=boss[u]; System.out.println(boss[v]+" "+boss[u]);}
               }
          }
          else if(size[boss[u]]<size[boss[v]]){
               size[boss[v]]=size[boss[v]]+size[boss[u]];
               for(int i=0; i<boss.length; i++){
                    if(boss[i]==boss[u]) {boss[u]=boss[v]; System.out.println(boss[u]+" "+boss[v]);}
               }
          }
     }
}
