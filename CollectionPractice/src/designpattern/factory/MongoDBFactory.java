package designpattern.factory;

public class MongoDBFactory  implements DatabaseFactory {

	@Override
	public void createQuery() {
		System.out.println("Create Query Of MongoDB .");
	}

	@Override
	public void createTransaction() {
		System.out.println("Create Transaction Of MongoDB .");
	}

	@Override
	public void createUpdateType() {
		System.out.println("Create Update Of MongoDB .");
	}

}
