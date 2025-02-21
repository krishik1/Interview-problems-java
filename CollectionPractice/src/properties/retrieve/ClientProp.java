package properties.retrieve;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ClientProp {

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		prop.setProperty("db.mysql.port", "3306");
		prop.setProperty("dn.mysql.url", "jdbc:mysql://localhost");
		prop.setProperty("db.mysql.username", "Raj");
		prop.setProperty("db.mysql.password", "Pwd@123");

//		FileReader fr = new FileReader("C:\\Users\\User\\git\\Interview-problems-java1\\CollectionPractice\\src\\properties\\retrieve\\oracledb.properties");
//		prop.load(fr);
//		System.out.println(prop.getProperty("spring.datasource.url"));
//		System.out.println(prop.getProperty("spring.datasource.username"));
//		System.out.println(prop.getProperty("spring.datasource.password"));
//		System.out.println(prop.getProperty("spring.datasource.driver.class-name"));

		//prop.store(new FileWriter("mysqldb.properties"), "About Mysql DB.");
		try (FileWriter fw = new FileWriter(
		        "C:\\Users\\User\\git\\Interview-problems-java1\\CollectionPractice\\src\\properties\\retrieve\\mysqldb.properties")) {
		    prop.store(fw, "About Mysql DB.");
		    System.out.println("Properties file created successfully.");
		} catch (IOException e) {
		    e.printStackTrace();
		}


	}
}
