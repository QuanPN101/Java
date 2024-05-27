package Bean;

import java.util.ArrayList;

public class donvibean {
	private String madv;
	private String tendv;
	
	//Ham tao
	public donvibean(String madv, String tendv) {
		super();
		this.madv = madv;
		this.tendv = tendv;
	}
	public donvibean() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Ham get set
	public String getMadv() {
		return madv;
	}
	public void setMadv(String madv) {
		this.madv = madv;
	}
	public String getTendv() {
		return tendv;
	}
	public void setTendv(String tendv) {
		this.tendv = tendv;
	}
	//Ham to string
	@Override
	public String toString() {
		return "donvibean [madv=" + madv + ", tendv=" + tendv + "]";
	}
	
}
