package gap.interview.prep.singleton;

public class Client {
	public static void main(String[] args) {
		DataBaseDemo db = Singleton.getInstance();
		System.out.println(db.getPort());
	}

}
