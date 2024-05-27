package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class testnhap {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//b1 ket noi csdl
			ketnoi kn= new ketnoi();
			kn.ketnoi();
			//b2 tao cau lenh sql
			String sql="insert into nhanvien(manv, hoten, gioitinh, ngaysinh, hsl, madv) values (?,?,?,?,?,?)";
			//b3 tao cau lenh
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			
			cmd.setString(1, "9");
			cmd.setString(2, "Ly Luan");
			cmd.setBoolean(3, true);
			String ns="2000-02-23";
			//doi
			SimpleDateFormat d= new SimpleDateFormat("yyyy-MM-dd");
			Date ngay=d.parse(ns);
			//
			cmd.setDate(4, new java.sql.Date(ngay.getTime()));
			cmd.setDouble(5, 7.0);
			cmd.setString(6, "dv1");
			
			//b4 thuc hien cau lenh
			cmd.executeUpdate();
			
			System.out.println("xong");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

