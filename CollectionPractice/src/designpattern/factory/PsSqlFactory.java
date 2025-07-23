package designpattern.factory;

public class PsSqlFactory implements DatabaseFactory {

	@Override
	public void createQuery() {
		System.out.println("Create Query Of PLSQL .");
	}

	@Override
	public void createTransaction() {
		System.out.println("Create Transaction Of PLSQL .");
	}

	@Override
	public void createUpdateType() {
		System.out.println("Create Update Of PLSQL .");
	}

}
