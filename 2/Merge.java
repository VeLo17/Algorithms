import java.util.Scanner;
/**
 * The Merge class sorts given sorted arrays in O(n logk) time
 *
 * @author Lohit Velagapudi
 *
 */
public class Merge{
  
   static MyLinkedList[] arr; 
   static int k;
   public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      k=sc.nextInt();
      arr=new MyLinkedList[k];
      for(int i=0; i<k; i++){
         int num=sc.nextInt();
         arr[i]=new MyLinkedList();
	 for(int j=0; j<num; j++){
            int t=sc.nextInt();
            arr[i].add(t);
	 }
      }

      MyLinkedList result=divideList(0, k-1);

      for(int i=0; i<result.getLength(); i++){
         System.out.print(result.get(i)+" ");
      }
      System.out.println();		      
   }

   /**
    * The divideList() method divides given k sorted arrays 
    *
    * @param first int takes the start of the reqd part of the array
    * @param last  int takes the end of the reqd part of the array
    *
    * @return MyLinkedList returns a sorted list 
    */
    
   static MyLinkedList divideList(int first, int last){
      MyLinkedList list1=new MyLinkedList();
      MyLinkedList list2=new MyLinkedList();
      int mid=(int)((first+last)/2);
      if(first<last){
         list1=divideList(first, mid);
         list2=divideList(mid+1, last);
      }
      else{
         return arr[first];
      }
      
      return mergeList(list1, list2);
   }

   /**
    * The mergeList() method returns the merge of two sorted lists
    * 
    * @param list1 MyLinkedList sorted list
    * @param list2 MyLinkedList sorted list
    *
    * @return MyLinkedList returns a merged sorted list
    */
   static MyLinkedList mergeList(MyLinkedList list1, MyLinkedList list2){
      MyLinkedList mergedList=new MyLinkedList(); 
      int i=0;
      int j=0;
      
      while(i < list1.getLength() && j< list2.getLength()){
         if((int)list1.get(i)<(int)list2.get(j)){
            mergedList.add(list1.get(i));
            i++;
         }
         else{
            mergedList.add(list2.get(j));
            j++;
         }
      }

      while(i<list1.getLength()){
         mergedList.add(list1.get(i));
         i++;
      }

      while(j<list2.getLength()){
         mergedList.add(list2.get(j));
         j++;
      }
      
      return mergedList;
   } 
}
