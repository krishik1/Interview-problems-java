package designpattern.factory;

public abstract class DataBase{
	
	public abstract void connectDB();
	public abstract void setPort();
	public abstract void setusername();
	public abstract void setpassword();
	
	public abstract DatabaseFactory createFactory();
	
}
