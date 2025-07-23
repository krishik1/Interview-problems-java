package gap.interview.prep.singleton;

public class Singleton {
	private static volatile DataBaseDemo dataBaseDemo = null;

	private Singleton() {
	}

	public static DataBaseDemo getInstance() {
		if(dataBaseDemo==null) {
			synchronized (Singleton.class) {
				if (dataBaseDemo == null) {
					dataBaseDemo = new DataBaseDemo("3306", "jdbc:mysql://localhost:3306/mydatabase", "root", "root");
				}
			}
		}
		return dataBaseDemo;
	}
	
	

}
