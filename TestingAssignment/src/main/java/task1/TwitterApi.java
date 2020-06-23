package task1;

 
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public abstract class TwitterApi {
	public Twitter twitter;

	

	public TwitterApi() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("QILmVrzqq2HaTJ6nfI0emFbl6")
				.setOAuthConsumerSecret("AlOcLKT1u0rWnJaix9gtGaTYPNbRg2xcMXuLc14iYbk0zHk6md")
				.setOAuthAccessToken("967267726967361536-Xu5uwC4rU5VEmxro17TZ5shhpHXDvYG")
				.setOAuthAccessTokenSecret("KBg3jO2FOEhhc1DOyOw18v1IGLhhcr8EJBkgyM5PrsXkZ");
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();
	}

	
	public abstract int GetCountData(String name) throws TwitterException;

}
