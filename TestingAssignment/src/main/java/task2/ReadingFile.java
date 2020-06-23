package task2;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import task1.Task;

public class ReadingFile extends Task {

	private String file;
	static String last;
	static String line;
	static int position;

	public String readFile(String fileName) throws Exception {
		File file = new File(fileName);
		return searchFile(new Scanner(file));
	}

	public String searchFile(Scanner sc) {

		while (sc.hasNextLine()) {
			last = sc.nextLine();
		}
		position = last.indexOf(":");
		String word = last.substring(0, position);
		last = String.valueOf(word);		
		sc.close();
		return last;
	}

	@Override
	public String run() {
		String fileName;
		try {
			fileName = readFile(file); 
			System.out.println(fileName);
			return fileName;
		} catch (Exception e) {
			System.out.println("Invalid file");
			return "Invalid file";
		}
	}

//	@Override
//	public boolean configure(List<String> params) {
//		if (params == null || params.size() < 1)
//		{
//			System.out.println("False");
//			return false;
//		}
//
//
//		file = params.get(0);
//		if (file==null||file.isEmpty())
//		{
//			System.out.println("False");
//			return false;
//		}
//
//		this.params = params;
//		System.out.println("True");
//		return true;
//	}
	
	@Override
	public boolean configure(List<String> statuses) {
	 	
	  if(paramConfig(statuses)==false)
	  {
		  return false;
	  }
	  
	  file = statuses.get(0);
		if (file==null||file.isEmpty())
		{
			System.out.println("False");
			return false;
		}

		this.params = statuses;
		System.out.println("True");
		return true;
 
	}
}