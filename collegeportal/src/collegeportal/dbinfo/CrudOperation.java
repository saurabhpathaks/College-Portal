package collegeportal.dbinfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CrudOperation 
{
private static Connection connection;
private static ResourceBundle bundle;
public static Connection createConnection()
{
	try {
		
		bundle=ResourceBundle.getBundle("collegeportal/dbinfo/databaseinfo");
		String id=bundle.getString("db.id");
		String pass=bundle.getString("db.password");
		String url=bundle.getString("db.connectionstring");
		String slogan=bundle.getString("db.slogan");
		System.out.println(id+pass+url+slogan);
		Class.forName("com.mysql.cj.jdbc.Driver");
		//connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/collegedb","root","saurabh");
		connection=DriverManager.getConnection(url,id,pass);
		
	}
	catch(ClassNotFoundException|SQLException se)
	
	{
		se.printStackTrace();
		
		
	}
	return connection;
	

}
/*
 * public static void main(String[] args) {
 * System.out.println(createConnection()); }
 */
}
