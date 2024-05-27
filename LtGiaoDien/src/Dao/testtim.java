package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class testtim {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//b1 ket noi csdl
			ketnoi kn= new ketnoi();
			kn.ketnoi();
			//b2 tao cau lenh sql
			System.out.println("Nhap manv: ");
			Scanner nhap= new Scanner(System.in);
			String manv=nhap.nextLine();
			
			System.out.println("Nhap hoten: ");
			
			String sql="insert into nhanvien(manv, hoten, gioitinh, ngaysinh, hsl, madv) values (?,?,?,?,?,?)";
			
			//b3 tao cau lenh
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, sql);
			//b4 thuc hien cau lenh
			ResultSet rs=cmd.executeQuery();
			//b5 duyet qua rs
			while(rs.next()) {
				//String manv=rs.getString("manv");
				String hoten=rs.getString("hoten");
				Double hsl=rs.getDouble("hsl");
				Date ns=rs.getDate("ngaysinh");
				SimpleDateFormat d= new SimpleDateFormat("dd/MM/yyyy");
				String ngaysinh=d.format(ns);
				System.out.println(manv+";"+hoten+";"+hsl+";"+ngaysinh );
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
