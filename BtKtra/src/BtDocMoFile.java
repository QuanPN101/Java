import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class BtDocMoFile {
	//Tao mang dong luu ho ten
	public ArrayList<String> DsCb= new ArrayList<String>();
	
	public void TaoDanhSach() {
		try {
			//mo file sv.txt luu o thu muc Phan1
			FileInputStream f= new FileInputStream("cb.txt");
			InputStreamReader ir= new InputStreamReader(f);
			BufferedReader r= new BufferedReader(ir);
			
			while(true) {//duyet file
				String st=r.readLine();
				if(st==null || st=="") break;
				
				DsCb.add(st);		
			}
			r.close();//dong file
		} catch (Exception tt) {
			// TODO: handle exception
			System.out.println("Loi o ham XuatDanhSach:"+tt.getMessage());
		}
	}
	public boolean KtSdt(String sdt) {//Kiem tra so diem thoai
		String mau="[0][\\d]{9,10}";
		return Pattern.matches(mau, sdt);
	}
	public boolean KtEmail(String email) {//kiem tra email
		String mau="[\\w]+@[\\w]+.[\\w]+.[\\w]{0,}";
		return Pattern.matches(mau, email);
	}
	public boolean KtNgay(String ngay) {//kiem tra ngay sinh
		try {
			SimpleDateFormat dd= new SimpleDateFormat("dd/MM/yyyy");
			dd.setLenient(false);
			dd.parse(ngay);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean KtMcbTdn(String t) {//kiem tra ten dang nhap, ma can bo
		if(t.codePointAt(0) >= 48 && t.codePointAt(0) <= 57) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean KtHsl(String hsl) {//kiem tra so thuc
		String mau="[\\d]+.[0]",mau1="[\\d]{0,}";
		if(Pattern.matches(mau, hsl) == true || Pattern.matches(mau1, hsl) == true){
			return false;
		}
		else {
			return true;
		}
	}
}



























