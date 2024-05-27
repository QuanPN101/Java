import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class MainKt {

	public static void main(String[] args) {
		BtDocMoFile z= new BtDocMoFile();
		z.TaoDanhSach();
		int n=z.DsCb.size();
		try {
			FileOutputStream fw= new FileOutputStream("loi.txt");
			OutputStreamWriter ow= new OutputStreamWriter(fw);
			PrintWriter pw= new PrintWriter(ow);
			for(int i=0;i<n;i++) {
				String[] a=z.DsCb.get(i).split("[;]");
				String kq="";
				if(z.KtMcbTdn(a[0]) == false) {
					kq+=";Sai ma cb";
				}
				if(z.KtEmail(a[2]) == false) {
					kq+=";Sai email";
				}
				if(z.KtNgay(a[3]) == false) {
					kq+=";Sai ngay sinh";
				}
				if(z.KtHsl(a[4]) == false) {
					kq+=";Sai he so luong";
				}
				if(z.KtSdt(a[5]) == false) {
					kq+=";Sai sdt";
				}
				if(z.KtMcbTdn(a[6]) == false) {
					kq+=";Sai ten dang nhap";
				}
				if(kq.compareTo("")>0) {
					pw.println((i+1)+kq);
				}
			}
			pw.close();
		} catch (Exception tt) {
			// TODO: handle exception
			System.out.println(tt);
		}
	}
}





























