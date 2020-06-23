package ApiStub;
 
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import task1.TwitterApi;
import task1.TwitterData;
import task1.TwitterTask;

public class DriverTesting {

	/* Working internet */

	@Test
	public void DrivertestLogic() throws Exception {
		TwitterApi twittera= new TwitterData();
		TwitterTask ta = new TwitterTask(twittera);
		List<String> params = Arrays.asList("@keanemizzi");
		ta.configure(params);
		Assert.assertEquals("High number of tweets(15)", ta.run());
	}
	

	@Test
	public void configureFalseReturn() throws Exception {
		TwitterApi twittera= new TwitterData();
		TwitterTask ta = new TwitterTask(twittera);
		List<String> file = new ArrayList<String>();
		ta.configure(file);
		Assert.assertEquals("Low number of tweets(0)", ta.run());
	}

	@Test
	public void configureFileEmpty() throws IOException {
		TwitterApi twittera= new TwitterData();
		TwitterTask ta = new TwitterTask(twittera);
		List<String> file = new ArrayList<String>();
		file.add("");
		Assert.assertEquals(false, ta.configure(file));
	}

	@Test
	public void configureFileNull() throws IOException {
		TwitterApi twittera= new TwitterData();
		TwitterTask ta = new TwitterTask(twittera);
		List<String> file = new ArrayList<String>();
		file.add(null);
		Assert.assertEquals(false, ta.configure(file));
	}
 
	@Test
	public void configureParamsNull() throws IOException {
		TwitterApi twittera= new TwitterData();
		TwitterTask ta = new TwitterTask(twittera);
		Assert.assertEquals(false, ta.configure(null));
	}
	
	/* Stub */
	@Test
	public void workingStub() throws Exception {
		List<String> params = Arrays.asList("@keanemizzi");
		TwitterApi ws = new WorkingStub();
		TwitterTask tt = new TwitterTask(ws);
		if(tt.configure(params) == true) {
			String ans = tt.run();
			assertEquals("High number of tweets(20)",ans);
		}
	}
	
	@Test
	public void workinglessTweets() throws Exception {
		List<String> params = Arrays.asList("@keanemizzi");
		TwitterApi ws = new workingLowTweets();
		TwitterTask tt = new TwitterTask(ws);
		if(tt.configure(params) == true) {
			String ans = tt.run();
			assertEquals("Low number of tweets(1)",ans);
		}
	}

	@Test (expected=NullPointerException.class)
	public void emptyStub() throws Exception {		
		List<String> params = Arrays.asList("@BarackObama");
		TwitterApi es = new emptyStub();
		TwitterTask tt = new TwitterTask(es);
		if(tt.configure(params) == true) {
			String ans = tt.run();
		}
	
	}

	@Test(expected = RuntimeException.class)
	public void crashStub() throws Exception {
		List<String> params = Arrays.asList("@BarackObama");
		TwitterApi es =new crashStub();
		TwitterTask tt = new TwitterTask(es);
		if(tt.configure(params) == true) {
			String ans = tt.run();
		}
 
 
	}

}
