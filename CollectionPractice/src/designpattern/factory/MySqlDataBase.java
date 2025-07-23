package designpattern.factory;

public class MySqlDataBase extends DataBase{

	@Override
	public void connectDB() {
		System.out.println("MYSQL");
	}

	@Override
	public void setPort() {
		System.out.println("3360");
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
		return new MysqlFactory();
	}

	
	
}
