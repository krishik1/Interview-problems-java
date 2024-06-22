package designpattern.factory;

public class MysqlFactory implements DatabaseFactory{

	@Override
	public void createQuery() {
		System.out.println("Create Query Of Mysql .");
	}

	@Override
	public void createTransaction() {
		System.out.println("Create Transaction Of Mysql .");
	}

	@Override
	public void createUpdateType() {
		System.out.println("Create Update Of Mysql .");
	}

}
