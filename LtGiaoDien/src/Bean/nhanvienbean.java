package Bean;

import java.util.Date;

public class nhanvienbean {
	private String manv;
	private String hoten;
	private Boolean gioitinh;
	private Date ngaysinh;
	private Double hsl;
	private String madv; //microsoft sql sever 2014 SP3
	
	//ham tao
	public nhanvienbean(String manv, String hoten,Boolean gioitinh, Date ngaysinh, Double hsl, String madv) {
		super();
		this.manv = manv;
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.hsl = hsl;
		this.madv = madv;
	}

	public nhanvienbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	//ham get set
	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public Boolean getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(Boolean gioitinh) {
		this.gioitinh = gioitinh;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public Double getHsl() {
		return hsl;
	}

	public void setHsl(Double hsl) {
		this.hsl = hsl;
	}

	public String getMadv() {
		return madv;
	}

	public void setMadv(String madv) {
		this.madv = madv;
	}
	//ham toString

	@Override
	public String toString() {
		return "nhanvienbean [manv=" + manv + ", hoten=" + hoten + ", gioitinh=" + gioitinh + ", ngaysinh=" + ngaysinh
				+ ", hsl=" + hsl + ", madv=" + madv + "]";
	}
	
}
