import java.util.Scanner;
/**
 * The Jobs takes in a list of start time, end time and employer number 
 * and displays the number of jobs that could be scheduled alternately 
 * for the employer
 *
 * @author Lohit Velagapudi
 *
 */
public class Jobs{
   int start_time;
   int end_time;
   int employer;
   static Jobs[] jobs;
   static int num;

   /**
    * Jobs constructor assigns value assigns the start time, end time 
    * and emplyer number for each Job
    *
    * @param x int start time of the job
    * @param y int end time of the job
    * @param z int employer number for the job
    */
   Jobs(int x, int y, int z){
      start_time=x;
      end_time=y;
      employer=z;
   }

   int getStartTime(){
      return start_time;
   }

   int getEndTime(){
      return end_time;
   }

   int getEmployer(){
      return employer;
   }

   /**
    * The main method
    * 
    * @param args String[] to be ignored
    */
   public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      num=sc.nextInt();

      jobs=new Jobs[num];

      for(int i=0; i<num; i++){
         int x=sc.nextInt();
         int y=sc.nextInt();
         int z=sc.nextInt();
 
         jobs[i]=new Jobs(x, y, z);
      }

      Jobs[] sorted_jobs=sortJobs(0, num-1);

      int result=maxScheduledJobs(sorted_jobs);
      System.out.println(result);
   }
   
   /**
    * The sortJobs method sorts the jobs by end time of the job
    *
    * @param start int start of the array to be processed
    * @param end int end of the array to be processed
    *
    * @return Jobs[] returns an array of sorted jobs
    */
   static Jobs[] sortJobs(int start, int end){
   
      int mid=(int)(start+end)/2;
      Jobs[] j1, j2;
      if(start!=end){
         j1=sortJobs(start, mid);
         j2=sortJobs(mid+1, end);
      }
      else{
         Jobs[] t=new Jobs[1];
         t[0]=jobs[start];
         return t;
      }

      int i=0;
      int j=0;
      int k=0;

      Jobs[] temp=new Jobs[end-start+1];

      while(i<(mid-start+1) && j<(end-(mid+1)+1) && k<((end-start)+1)){
        if(j1[i].getEndTime()<=j2[j].getEndTime()){
          temp[k]=j1[i];
            i++;
            k++;
         }
         else if(j1[i].getEndTime()>j2[j].getEndTime()){
          temp[k]=j2[j];
            j++;
            k++;
         }
      }
      while(i<(mid-start+1) && k<((end-start)+1)){
         temp[k]=j1[i];
         i++;
         k++;
      }
      while(j<(end-(mid+1)+1) && k<((end-start)+1)){
        temp[k]=j2[j];
         j++;
         k++;
      }
      return temp;
   }
   
   /** The maxScheduledJobs method takes in a list of jobs sorted by end time
    * and returns the jobs that could be scheduled.
    * 
    * @param jobs Jobs[] list of jobs sorted by end time
    *
    * @return int max number of jobs that could be scheduled
    */
   static int maxScheduledJobs(Jobs[] jobs){
      MyLinkedList JobList =new MyLinkedList(); 
      int prev_start_time=0;
      int prev_end_time=0;
      int prev_employer=0;

      for(int i=0; i<num; i++){
         if(JobList.getLength() == 0){
            JobList.add(jobs[i]);
            prev_start_time=jobs[i].getStartTime();
            prev_end_time=jobs[i].getEndTime();
            prev_employer=jobs[i].getEmployer();            
         }
         else{
            if(prev_employer!=jobs[i].getEmployer() && prev_end_time<=jobs[i].getStartTime()){
               JobList.add(jobs[i]);
               prev_start_time=jobs[i].getStartTime();
               prev_end_time=jobs[i].getEndTime();
               prev_employer=jobs[i].getEmployer();
            }
         }
      }
      return JobList.getLength();
   }
}
