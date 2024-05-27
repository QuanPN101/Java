package Dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ketnoi {
	
	public static Connection cn;
	public void ketnoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh HQTCSDL");
		String url="jdbc:sqlserver://LAPTOP-CMRGCIMS\\QUAN:1433;databaseName=javaSQL; user=sa; password=pq101";
		cn=DriverManager.getConnection(url);
		System.out.println("Da ket noi");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//b1 ket noi csdl
			ketnoi kn= new ketnoi();
			kn.ketnoi();
			//b2 tao cau lenh sql
			String sql="select * from nhanvien";
			//b3 tao cau lenh
			PreparedStatement cmd=cn.prepareStatement(sql);
			//b4 thuc hien cau lenh
			ResultSet rs=cmd.executeQuery();
			//b5 duyet qua rs
			while(rs.next()) {
				String manv=rs.getString("manv");
				String ht=rs.getString("hoten");
				Double hsl=rs.getDouble("hsl");
				Date ns=rs.getDate("ngaysinh");
				SimpleDateFormat d= new SimpleDateFormat("dd/MM/yyyy");
				String ngaysinh=d.format(ns);
				System.out.println(manv+";"+ht+";"+hsl+";"+ngaysinh );
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}






















