package Bean;

public class sinhvien extends nguoi {
	private String masv;
	private Double dtb;
	
	public sinhvien(String masv, String hoten, int tuoi, Double dtb) {
		super(hoten, tuoi);//truyen ho ten, tuoi len lop cha: nguoi
		this.masv=masv;
		this.dtb=dtb;
	}

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public Double getDtb() {
		return dtb;
	}

	public void setDtb(Double dtb) {
		this.dtb = dtb;
	}
	
	public void hienthi(){
		System.out.println("Ten sinh vien: "+ hoten +" hskd" + masv);
	}
}
