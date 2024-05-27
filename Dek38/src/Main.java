import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		function a= new function();
		ArrayList<Integer> a1= new ArrayList<Integer>();
		a1=a.LayDSA();
//		System.out.println(a1);
//		System.out.println(a.KTIP1(a1));
//		System.out.println(a1);
		ArrayList<String> a2= new ArrayList<String>();
		ArrayList<Integer> a3= new ArrayList<Integer>();
		a2=a.LayDSB();
		a1.sort(null);
		for(int i=0;i<a2.size();i++) {
			if(a.KTIP2(a2.get(i)) == true) {
				System.out.println(a.SoSanh(a.LaySoKH(a2.get(i)), a1));
			}
		}
		try {
			a.ketnoi();
			String sql="insert into kh(Hoten, Diachi,Sdt,SLve, s1,s2,s3,s4,s5,s6)"
					+ " values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement cmd=a.cn.prepareStatement(sql);
			cmd.setString(1, "Quan");
			cmd.setString(2, "Hue");
			cmd.setString(3, "012345");
			cmd.setInt(4, 10);
			cmd.setInt(5, 20);
			cmd.setInt(6, 40);
			cmd.setInt(7, 41);
			cmd.setInt(8, 42);
			cmd.setInt(9, 43);
			cmd.setInt(10, 44);
			int kq=cmd.executeUpdate();
			a.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}























