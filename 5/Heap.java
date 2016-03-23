class Heap{
     int[] node;
     int[] cost;
     int currentSize;
     int maxSize;

     Heap(int x){
          maxSize=x;
          currentSize=0;
          node=new int[x];
          cost=new int[x];
     }

     void add(int x, int y){
          node[currentSize]=x;
          cost[currentSize]=y;
          int temp=currentSize;
          currentSize++;

          while(cost[temp]<cost[(int)(temp-1)/2] && temp!=0){
               int t=node[temp];
               node[temp]=node[(int)(temp-1)/2];
               node[(int)(temp-1)/2]=t;
               t=cost[temp];
               cost[temp]=cost[(int)(temp-1)/2];
               cost[(int)(temp-1)/2]=t;
               temp=(int)(temp-1)/2;
          }
     }

     int extractMin(){
          int minVal=node[0];
          node[0]=node[currentSize-1];
          cost[0]=cost[currentSize-1];
          currentSize--;

          int root=0;
          if(maxSize>2) changeWhenMaxSizeGreaterThan2(root);
          else if(maxSize==2 && maxSize==currentSize) changeWhenMaxSizeIs2(root);
          
          return minVal;
     }

     void changeKey(int changePoint){
          if(changePoint!=0){
               if(cost[changePoint]<cost[(int)(changePoint-1)/2]){
                    changeParent(changePoint);
               }
               else if(maxSize>2){
                    changeWhenMaxSizeGreaterThan2(changePoint);
               }
               else if(maxSize==2 && maxSize==currentSize){
                    changeWhenMaxSizeIs2(changePoint);
               }
          }
          else{
               if(maxSize>2){
                    changeWhenMaxSizeGreaterThan2(changePoint);
               }
               else if(maxSize==2 && maxSize==currentSize){
                    changeWhenMaxSizeIs2(changePoint);
               }
          }    
     }

     void changeWhenMaxSizeIs2(int changePoint){
          int t=cost[changePoint];
          cost[changePoint]=cost[2*changePoint+1];
          cost[2*changePoint+1]=t;
          t=node[changePoint];
          node[changePoint]=node[2*changePoint+1];
          node[2*changePoint+1]=t;
     }
     void changeWhenMaxSizeGreaterThan2(int changePoint){
          while((cost[changePoint]>cost[2*changePoint+1] || cost[changePoint]>cost[2*changePoint+2]) && (2*changePoint+1)<=(currentSize-1)){
                    if(cost[changePoint]>cost[2*changePoint+1] && cost[changePoint]>cost[2*changePoint+2] && (2*changePoint+2)<=(currentSize-1)){
                         if(cost[2*changePoint+1]<cost[2*changePoint+2]){
                              int t=cost[2*changePoint+1];
                              cost[2*changePoint+1]=cost[changePoint];
                              cost[changePoint]=t;
                              t=node[2*changePoint+1];
                              node[2*changePoint+1]=node[changePoint];
                              node[changePoint]=t;
                              changePoint=2*changePoint+1;
                              if(changePoint>(int)(currentSize-1)/2) break;
                         }
                         else{
                              int t=cost[2*changePoint+2];
                              cost[2*changePoint+2]=cost[changePoint];
                              cost[changePoint]=t;
                              t=node[2*changePoint+2];
                              node[2*changePoint+2]=node[changePoint];
                              node[changePoint]=t;
                              changePoint=2*changePoint+2;
                              if(changePoint>(int)(currentSize-1)/2) break;
                         }
                    }
                    else if(cost[changePoint]>cost[2*changePoint+1] && (2*changePoint+1)<=(currentSize-1)){
                         int t=cost[2*changePoint+1];
                         cost[2*changePoint+1]=cost[changePoint];
                         cost[changePoint]=t;
                         t=node[2*changePoint+1];
                         node[2*changePoint+1]=node[changePoint];
                         node[changePoint]=t;
                         changePoint=2*changePoint+1;
                         if(changePoint>(int)(currentSize-1)/2) break;
                    }
                    else if(cost[changePoint]>cost[2*changePoint+2] && (2*changePoint+2)<=(currentSize-1)){
                         int t=cost[2*changePoint+2];
                         cost[2*changePoint+2]=cost[changePoint];
                         cost[changePoint]=t;
                         t=node[2*changePoint+2];
                         node[2*changePoint+2]=node[changePoint];
                         node[changePoint]=t;
                         changePoint=2*changePoint+2;
                         if(changePoint>(int)(currentSize-1)/2) break;
                    }
               }
     }

     void changeParent(int changePoint){
          while(cost[changePoint]<cost[(int)(changePoint-1)/2]){
               int t=cost[changePoint];
               cost[changePoint]=cost[(int)(changePoint-1)/2];
               cost[(int)(changePoint-1)/2]=t;
               t=node[changePoint];
               node[changePoint]=node[(int)(changePoint-1)/2];
               node[(int)(changePoint-1)/2]=t;
               changePoint=(int)(changePoint-1)/2;
               if(changePoint==0) break;
          }
     }
     
     int size(){
          return currentSize;
     }

     int getNode(int x){
          return node[x];
     }

     int getCost(int x){
          return cost[x];
     }

     void setCost(int i, int x){
          cost[i]=x;
     }
     
     public static void main(String[] args){
          Heap heap=new Heap(5);
          heap.add(0, 1);
          System.out.println(heap.node[0]+" "+heap.cost[0]);
          heap.add(1, 4);
          System.out.println(heap.node[0]+" "+heap.cost[0]);
          heap.add(2, 5);
          System.out.println(heap.node[0]+" "+heap.cost[0]);
          heap.add(3, 2);
          System.out.println(heap.node[0]+" "+heap.cost[0]);
          heap.add(4, 1);
          System.out.println(heap.node[0]+" "+heap.cost[0]);
          System.out.println();
          for(int i=0; i<5; i++){
               System.out.println(heap.node[i]+" "+heap.cost[i]);
          }
          System.out.println();
          System.out.println(heap.extractMin());
          System.out.println(heap.extractMin());
          System.out.println(heap.extractMin());
          System.out.println(heap.extractMin());
          System.out.println(heap.extractMin());
     }     
}

