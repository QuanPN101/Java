package Dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.donvibean;

public class donvidao {
	
	public ArrayList<donvibean> getdv() throws Exception{
		//tao 1 mang de luu all cac don vi trong file donvi.txt
		ArrayList<donvibean> ds= new ArrayList<donvibean>();
		//mo file
		FileReader f= new FileReader("donvi.txt");
		BufferedReader b= new BufferedReader(f);
		//duyet file
		while(true) {
			String st=b.readLine();
			if(st==null || st=="") break;
			String[] t=st.split("[;]");
			String madv=t[0]; String tendv=t[1];
			donvibean dv= new donvibean(madv, tendv);
			ds.add(dv);//luu don vi vao mang
		}
		b.close();
		return ds;
	}
	
	public int Them(String madv, String tendv) {
		try {
			//b1: Ket noi vao csdl
			ketnoi kn= new ketnoi();
			kn.ketnoi();
			//B2: Tao cau lenh sql
			String sql="insert into donvi(madv,tendv) values(?,?)";
			//B3: tao cau lenh
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, madv);
			cmd.setString(2, tendv);
			//b4: Thuc hien cau lenh
			int kq= cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int Xoa(String madv) {
		try {
			//b1: Ket noi vao csdl
			ketnoi kn= new ketnoi();
			kn.ketnoi();
			//B2: Tao cau lenh sql
			String sql="delete from donvi where madv=?";
			//B3: tao cau lenh
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, madv);
			//b4: Thuc hien cau lenh
			int kq= cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int Sua(String madv, String tendvmoi) {
		try {
			//b1: Ket noi vao csdl
			ketnoi kn= new ketnoi();
			kn.ketnoi();
			//B2: Tao cau lenh sql
			String sql="update donvi set tendv=? where madv=?";
			//B3: tao cau lenh
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, tendvmoi);
			cmd.setString(2, madv);
			//b4: Thuc hien cau lenh
			int kq= cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
//	public void Napfile() throws Exception{
//		FileReader f= new FileReader("donvi.txt");
//		BufferedReader b= new BufferedReader(f);
//		while(true) {
//			String st=b.readLine();
//			if(st==null || st=="") break;
//			String[] t=st.split("[;]");
//			Them(t[0], t[1]);//them vao csdl
//		}
//		b.close();
//	}
}




















