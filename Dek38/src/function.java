import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;

public class function {
	
	public static Connection cn;
	public void ketnoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url="jdbc:sqlserver://LAPTOP-CMRGCIMS\\SQLQUAN:1433;databaseName=Veso; user=sa; password=pq101";
		cn=DriverManager.getConnection(url);
		System.out.println("Da ket noi csdl!");
	}
	
	public ArrayList<Integer> LayDSA() {
		ArrayList<Integer> A= new ArrayList<Integer>();
		try {
			FileInputStream f= new FileInputStream("input1.txt");
			InputStreamReader ir= new InputStreamReader(f);
			BufferedReader r= new BufferedReader(ir);
			while(true) {
				String st=r.readLine();
				if(st==null || st=="") break;
				int k = Integer.valueOf(st);
				A.add(k);
			}
			r.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Loi!");
		}
		return A;
	}
	public ArrayList<String> LayDSB() {
		ArrayList<String> B= new ArrayList<String>();
		try {
			FileInputStream f= new FileInputStream("input2.txt");
			InputStreamReader ir= new InputStreamReader(f);
			BufferedReader r= new BufferedReader(ir);
			while(true) {
				String st=r.readLine();
				if(st==null || st=="") break;
				B.add(st);
			}
			r.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Loi!");
		}
		return B;
	}
	public boolean KTIP1(ArrayList<Integer> C) {
		C.sort(null);
		int n=C.size();
		for(int i=0;i<n;i++) {
			if(C.get(i) < 1 || C.get(i) > 45) return false;
			if(i == (n-1)) break;
			if(C.get(i) == C.get(i+1)) return false;
		}
		return true;
	}
	public boolean KTIP2(String C) {
		ArrayList<Integer> a= new ArrayList<Integer>();
		String[] ds=C.split("[,]");
		int n=ds.length;
		for(int j=4;j<n;j++) {
			a.add(Integer.valueOf(ds[j]));
		}
		for(int k=0;k<a.size();k++) {
			if(a.get(k) < 1 || a.get(k) > 45) return false;
			if(k == (a.size()-1)) break;
			if(a.get(k) >= a.get(k+1)) return false;
		}
		return true;
	}
	public ArrayList<Integer> LaySoKH(String A){
		ArrayList<Integer> a= new ArrayList<Integer>();
		String[] ds=A.split("[,]");
		int n=ds.length;
		for(int j=4;j<n;j++) {
			a.add(Integer.valueOf(ds[j]));
		}
		return a;
	}
	public int SoSanh(ArrayList<Integer> A, ArrayList<Integer> B) {
		int count=0;
		for(int i=0;i<A.size();i++) {
			for(int j=0;j<B.size();j++) {
				if(A.get(i) == B.get(j)) count++;
			}
		}
		return count;
	}
}






















