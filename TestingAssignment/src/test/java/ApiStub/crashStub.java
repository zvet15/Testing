package ApiStub;

import task1.TwitterApi;
import twitter4j.TwitterException;

public class crashStub extends TwitterApi {
	
	@Override
	public int GetCountData(String name) throws RuntimeException {
		// TODO Auto-generated method stub 
		  throw new RuntimeException("always crash");
	}
}