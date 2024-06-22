package designpattern.factory;

public interface DatabaseFactory {
	public void createQuery();
	public void createTransaction();
	public void createUpdateType();
}
