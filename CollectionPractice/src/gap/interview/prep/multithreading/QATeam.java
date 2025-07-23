package gap.interview.prep.multithreading;

public class QATeam implements Runnable {
	String name;
	

	public QATeam(String name) {
		super();
		this.name = name;
	}


	@Override
	public void run() {
		System.out.println("Task Assigned to Devlopment Team "+name);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Task Finished to Devlopment Team "+name);

		
	}

}
