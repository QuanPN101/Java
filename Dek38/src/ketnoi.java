import java.sql.Connection;
import java.sql.DriverManager;

public class ketnoi {
	public static Connection cn;
	public void ketnoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url="jdbc:sqlserver://LAPTOP-CMRGCIMS\\SQLQUAN:1433;databaseName=Veso; user=sa; password=pq101";
		cn=DriverManager.getConnection(url);
	}
}
