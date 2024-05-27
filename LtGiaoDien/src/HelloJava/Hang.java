package HelloJava;

public class Hang {
	private String tenhang;
	private long gia;
	
	public String getTenhang() {
		return tenhang;
	}
	public void setTenhang(String tenhang) {
		this.tenhang = tenhang;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	@Override
	public String toString() {
		return "Hang [tenhang=" + tenhang + ", gia=" + gia + "]";
	}
	
	public Hang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Hang(String tenhang, long gia) {
		super();
		this.tenhang = tenhang;
		this.gia = gia;
	}
}
