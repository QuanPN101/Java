package Bo;

import java.util.ArrayList;
import java.util.Date;
import Bean.nhanvienbean;
import Dao.nhanviendao;

public class nhanvienbo {
	nhanviendao nvdao= new nhanviendao();
	ArrayList<nhanvienbean> ds;
	public ArrayList<nhanvienbean> getnv() throws Exception{
		ds=nvdao.getnv();
		return ds;
	}
	
	public int Them(String manv,String hoten,boolean gioitinh,Date ngaysinh,double hsl,String madv) throws Exception{
		for(nhanvienbean nv: ds)
			if(nv.getManv().equals(manv))
				  return 0;
			ds.add(new nhanvienbean(manv, hoten,gioitinh,ngaysinh,hsl,madv));
			//them vao csdl		
			return nvdao.Them(manv, hoten, gioitinh, ngaysinh, hsl, madv);
	}
	
	public ArrayList<nhanvienbean> Xoa(String manv) throws Exception{
		for(nhanvienbean dv: ds)
			if(dv.getManv().equals(manv)) {
				ds.remove(dv);//xoa trong bo nho
				nvdao.Xoa(manv);//xoa trong csdl
				break;
			}
		return ds;
	}
	
	public ArrayList<nhanvienbean> Sua(String manv, String hoten,Boolean gioitinh, Date ngaysinh, Double hsl, String madv) throws Exception{
		int n=ds.size();
		for(int i=0;i<n;i++) {
			if(ds.get(i).getMadv().equals(madv)) {
				nhanvienbean dv=ds.get(i);
				dv.setHoten(hoten);
				dv.setGioitinh(gioitinh);
				dv.setHsl(hsl);
				dv.setMadv(madv);
				dv.setManv(manv);
				dv.setNgaysinh(ngaysinh);
				ds.set(i,dv);//sua trong bo nho
				nvdao.Sua(manv, hoten, gioitinh, ngaysinh, hsl, madv);//sua trong csdl
				break;
			}
		}
		return ds;
	}
}
