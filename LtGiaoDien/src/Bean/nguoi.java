package Bean;

public class nguoi {
	protected String hoten;
	protected int tuoi;
	
	public nguoi(String hoten, int tuoi) {
		super();
		this.hoten = hoten;
		this.tuoi = tuoi;
	}
	public nguoi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	
	public void hienthi() {
		System.out.println("Ten nguoi: "+ hoten);
	}
}
