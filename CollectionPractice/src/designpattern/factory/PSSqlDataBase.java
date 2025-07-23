package designpattern.factory;

public class PSSqlDataBase extends DataBase {

	@Override
	public void connectDB() {
		System.out.println("PLSQL");
	}

	@Override
	public void setPort() {
		System.out.println("3362");

	}

	@Override
	public void setusername() {
		System.out.println("Krisik");
	}

	@Override
	public void setpassword() {
		System.out.println("******");

	}

	@Override
	public DatabaseFactory createFactory() {
		return new PsSqlFactory();
	}

	
	
}
