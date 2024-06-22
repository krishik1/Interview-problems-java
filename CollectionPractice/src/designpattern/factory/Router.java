package designpattern.factory;

public class Router {
	public static void route(String input,DataBase db) {
		
		if(input.equalsIgnoreCase("mysql")) {
			db = new MySqlDataBase();
		} else if(input.equalsIgnoreCase("mongo")) {
			db = new MongoDBDataBase();
		} else if(input.equalsIgnoreCase("plsql")) {
			db = new PSSqlDataBase();
		}
				
		db.connectDB();
		db.setPort();
		db.setusername();
		db.setpassword();
		db.createFactory().createQuery();
		db.createFactory().createTransaction();
		db.createFactory().createUpdateType();
	}
}
