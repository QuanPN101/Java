package Bean;

public class canbo extends nguoi {
	private String macb;
	private String tendv;
	
	public canbo(String macb, String hoten, int tuoi, String tendv) {
		super(hoten, tuoi);
		this.macb=macb;
		this.tendv=tendv;
	}
	
	public String getMacb() {
		return macb;
	}
	public void setMacb(String macb) {
		this.macb = macb;
	}
	public String getTendv() {
		return tendv;
	}
	public void setTendv(String tendv) {
		this.tendv = tendv;
	}
	
	public void hienthi(){
		System.out.println("Ten can bo: "+ hoten + tuoi);
	}
	
}
