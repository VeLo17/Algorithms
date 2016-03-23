import java.util.Scanner;
/**
 * The HuffmanDecoder class decodes the encoded string using
 * a binary tree
 *
 * @author Lohit Velagapudi
 *
 */
public class HuffmanDecoder{
   
   static  BinaryTree tree;
   static int num;
   static String[] input;
   static String[] str;
   static String[] code;
   static int length;
   static String encoded;
   static String decoded;
   
   /**
    * The main method
    *
    * @param args String[] to be ignored
    */
   public static void main(String[] args){
      tree=new BinaryTree();
      Scanner sc=new Scanner(System.in);
      num=sc.nextInt();
      
      input=new String[num];
      str=new String[num];
      code=new String[num];
      int k=0;
     
      String l=sc.nextLine();
      while(sc.hasNextLine() && k<num){
         input[k]=sc.nextLine();
         k++;
      }
     
      for(int i=0; i<num; i++){
        String[] part=input[i].split(" ");
        str[i]=part[0];
        code[i]=part[1];
      }
    
      length=sc.nextInt();
      encoded=sc.next();
      addDataToTree();
      decode();
      System.out.println();
   }

   /**
    * The addDataToTree method creates a tree that represents 
    * each string and its code
    *
    */
   static void addDataToTree(){
      for(int i=0; i<num; i++){
         for(int j=0; j<code[i].length(); j++){
            if(code[i].charAt(j)=='0'){
               if(j==code[i].length()-1){ 
                  tree.addLeft(str[i]); 
                  tree.reset();
               }
               else tree.addLeft(null);
            }
            else if(code[i].charAt(j)=='1'){
               if(j==code[i].length()-1) {
                  tree.addRight(str[i]); 
                  tree.reset();
               }
               else tree.addRight(null);
            }  
         }
      }
   }
   /**
    * The decode method decodes the encded string using 
    * the binary tree
    */
   static void decode(){
      decoded="";
      for(int i=0; i<length; i++){
         if(encoded.charAt(i)=='0'){
            String req=(String)tree.getLeft();
            if(req!=null){
               System.out.print(req);
               tree.reset();
            }
         }
         else if(encoded.charAt(i)=='1'){
            String req=(String)tree.getRight();
            if(req!=null){
               System.out.print(req);
               tree.reset();
            }
         }
      }    
   }
}
