package task1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;

public class TwitterData extends TwitterApi{


	@Override
	public int GetCountData(String name) throws TwitterException {
		List<Status> statuses = new ArrayList<Status>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		Query query = new Query("from:" + name).until(dtf.format(localDate));
		QueryResult result = twitter.search(query);
		
		for(Status status:result.getTweets()) {
			
			statuses.add(status);
		} 
		//System.out.println(statuses.size());

		return statuses.size();
	}	
}
