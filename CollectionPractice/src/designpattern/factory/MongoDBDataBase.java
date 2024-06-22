package designpattern.factory;

public class MongoDBDataBase extends DataBase {

	@Override
	public void connectDB() {
		System.out.println("MONGODB");
	}

	@Override
	public void setPort() {
		System.out.println("3364");

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
		return new MongoDBFactory();
	}

}
