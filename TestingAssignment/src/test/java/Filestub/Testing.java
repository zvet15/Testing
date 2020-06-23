package Filestub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;
import task2.ReadingFile;

public class Testing {

	@Test
	public void paramsNull() throws IOException {
		ReadingFile rft = new ReadingFile();
		Assert.assertEquals(false, rft.configure(null));
	}

	@Test
	public void paramsEmpty() throws IOException {
		ReadingFile rft = new ReadingFile();
		List<String> file = new ArrayList<String>();
		Assert.assertEquals(false, rft.configure(file));
	}

	@Test
	public void fileEmpty() throws IOException {
		ReadingFile rft = new ReadingFile();
		List<String> file = new ArrayList<String>();
		file.add("");
		Assert.assertEquals(false, rft.configure(file));
	}

	@Test
	public void fileNull() throws IOException {
		ReadingFile rft = new ReadingFile();
		List<String> file = new ArrayList<String>();
		file.add(null);
		Assert.assertEquals(false, rft.configure(file));
	}

	@Test
	public void fileParametersTrue() throws IOException {
		ReadingFile rft = new ReadingFile();
		List<String> file = new ArrayList<String>();
		file.add("something");
		Assert.assertEquals(true, rft.configure(file));
	}

	@Test
	public void checkWarningNull() throws Exception {
		ReadingFile rft = new ReadingFile();
		Assert.assertEquals("Invalid file", rft.run());
	}

	@Test
	public void testLogic() throws Exception {
		ReadingFile rft = new ReadingFile();
		String mystring = "ERROR: Opening file \"TestFile1.txt\" from server MYSERVER\r\n"
				+ "INFO: Opening file \"TestFile1.txt\" from server MYSERVER\r\n"
				+ "WARNING: Opening file \"TestFile1.txt\" from server MYSERVER\r\n";
		Assert.assertEquals("WARNING", rft.searchFile(new Scanner(mystring)));
	}
	
	@Test
	public void testDemoRun() throws Exception {
		ReadingFile rft = new ReadingFile();
		List<String> params = Arrays.asList("src/test/resources/file.log");
		rft.configure(params);
		Assert.assertEquals("WARNING", rft.run());

	}

	@Test
	public void testDemoRunInvalid() throws Exception {
		ReadingFile rft = new ReadingFile();
		List<String> params = Arrays.asList("src/test/resources/fe.log");
		rft.configure(params);
		Assert.assertEquals("Invalid file", rft.run());

	}
}
