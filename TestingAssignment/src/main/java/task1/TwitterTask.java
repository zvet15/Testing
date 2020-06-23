package task1;

import java.util.List;

import twitter4j.TwitterException;

public class TwitterTask extends Task {
	private String name;
	private TwitterApi a;
	
	public TwitterTask(TwitterApi aa)
	{
		this.a = aa;
	}


	@Override
	public String run() throws Exception {
		
		int re = a.GetCountData(name);
		if(re>=3)
		{
			System.out.println("High number of tweets("+re+")");
			return  "High number of tweets("+re+")";
		}
		else
		{
			System.out.println("Low number of tweets("+re+")");
			return "Low number of tweets("+re+")";
		}

	}

//	@Override
//	public boolean configure(List<String> statuses) {
//		if (statuses == null || statuses.size() < 1)
//		{
//			System.out.println("false config");
//			return false;
//		}
//		
//
//		name = statuses.get(0);
//		if (name == null || name.isEmpty())
//		{
//			System.out.println("false Configure");
//			return false;
//		}
//			//return false;
//		System.out.println("True Configure");
//		this.params = statuses;
//		return true;
//	}
	
	@Override
	public boolean configure(List<String> statuses) {
	 	
	  if(paramConfig(statuses)==false)
	  {
		  return false;
	  }
	  
	  name = statuses.get(0);
		if (name==null||name.isEmpty())
		{
			System.out.println("False");
			return false;
		}

		this.params = statuses;
		System.out.println("True");
		return true;
 
	}
}
