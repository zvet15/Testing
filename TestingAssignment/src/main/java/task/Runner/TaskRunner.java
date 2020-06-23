package task.Runner;

import java.util.Arrays;
import java.util.List;
import task1.Task;
import task1.TwitterApi;
import task1.TwitterData;
import task1.TwitterTask;
import task2.ReadingFile;

public class TaskRunner {

	public static String output;
	public static boolean conf;
	

	public static void main(String[] args) throws Exception {
		String[]intArray= new String [3];
		Task ta=null; 
		if(args.length>0)
		{
			if(args[0].equals("file"))
			{  
				System.out.println("File");
				ta = new ReadingFile();  
			}
			else if(args[0].equals("API"))
			{		 
				//System.out.println("API"); 		 
				TwitterApi twittera= new TwitterData();
				ta = new TwitterTask(twittera);		
			}		

			if(args.length<2)
			{			
				intArray[0]=null;	
				List<String> params = Arrays.asList(intArray[0]);	
				conf=ta.configure(params);  
			}
			else
			{	 
				if(args[1].equals(""))
				{
					System.out.println(args[1]);
					System.out.println("Config"+args[1]);	
					List<String> params = Arrays.asList(args[1]);	
					conf=ta.configure(params);  	
				}
				else
				{
					List<String> params = Arrays.asList(args[1]);	
					System.out.println("__"+args[1]);
					conf=ta.configure(params);		
					output=ta.run();  
				}
			} 	   
		}
		else
		{
			System.out.println("Input Arguments please");
		}
		     
	}
}
