package ApiStub;

import task1.TwitterApi;

public class crashTweetStub  { 
	public String getTweets(String name) throws Exception {
		throw new RuntimeException("TweetStreamCrashStub always crashes");
	}
}
