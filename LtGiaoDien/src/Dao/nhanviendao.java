package Dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Bean.nhanvienbean;

public class nhanviendao {
	public ArrayList<nhanvienbean> getnv() throws Exception{
		//tao mang luu nv
		ArrayList<nhanvienbean> ds= new ArrayList<nhanvienbean>();
		//doc file
		FileReader f= new FileReader("nhanvien.txt");
		BufferedReader b= new BufferedReader(f);
		//duyet file
		while(true) {
			String st=b.readLine();
			if(st==null || st=="") break;
			String[] t=st.split("[;]");
			String manv=t[0];
			String hoten=t[1];
			Boolean gioitinh;
			if(t[2] == "1") 
				gioitinh=true;
			else 
				gioitinh=false;
			
			SimpleDateFormat dd= new SimpleDateFormat("dd/MM/yyyy");
			Date ngaysinh=dd.parse(t[3]);
			Double hsl=Double.parseDouble(t[4]);
			String madv=t[5];
			
			ds.add(new nhanvienbean(manv, hoten, gioitinh, ngaysinh, hsl, madv));
		}
		b.close();
		return ds;
	}
	public int Them(String manv,String hoten,Boolean gioitinh,Date ngaysinh,double hsl,String madv) {
		try {
			//b1: Ket noi vao csdl
			ketnoi kn= new ketnoi();
			kn.ketnoi();
			//B2: Tao cau lenh sql
			String sql="insert into nhanvien(manv,hoten, gioitinh, ngaysinh, hsl, madv) values (?,?,?,?,?,?)";
			//B3: tao cau lenh
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, manv);
			cmd.setBoolean(3, gioitinh);
			cmd.setString(2, hoten);
			cmd.setDate(4, new java.sql.Date(ngaysinh.getTime()));
			cmd.setDouble(5, hsl);
			cmd.setString(6, madv);
			//b4: Thuc hien cau lenh
			int kq= cmd.executeUpdate();
			kn.cn.close();
			
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int Xoa(String manv) {
		try {
		//b1: Ket noi vao csdl
			ketnoi kn= new ketnoi();
			kn.ketnoi();
		//B2: Tao cau lenh sql
			String sql="delete from nhanvien where manv=?";
		//B3: tao cau lenh
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, manv);
		//b4: Thuc hien cau lenh
			int kq= cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int Sua(String manv, String hoten,Boolean gioitinh, Date ngaysinh, Double hsl, String madv) {
		try {
		//b1: Ket noi vao csdl
			ketnoi kn= new ketnoi();
			kn.ketnoi();
		//B2: Tao cau lenh sql
			String sql="update nhanvien set hoten=?,gioitinh=?,ngaysinh=?,hsl=?, madv=? where manv=?";
		//B3: tao cau lenh
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(6, manv);
			cmd.setString(1, hoten);
			cmd.setBoolean(2, gioitinh);
			cmd.setDate(3, new java.sql.Date(ngaysinh.getTime()));
			cmd.setDouble(4, hsl);
			cmd.setString(5, madv);
		//b4: Thuc hien cau lenh
			int kq= cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
