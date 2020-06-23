package task1;

import java.util.List;

import twitter4j.Status;

public abstract class Task {
	protected List<String> params;

	public abstract boolean configure(List<String> statuses);
    public abstract String run() throws Exception;
    
    
	public boolean paramConfig(List<String> statuses) {
		if (statuses == null ||statuses.size() < 1)
		{
			System.out.println("False config");
			return false;
		}
		return true;
	}
}
