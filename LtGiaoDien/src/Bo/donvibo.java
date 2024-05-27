package Bo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import Bean.donvibean;
import Dao.donvidao;

public class donvibo {
	donvidao dvdao= new donvidao();
	ArrayList<donvibean> ds;
	
	public ArrayList<donvibean> getdv() throws Exception{
		ds=dvdao.getdv();
		return ds;
	}
	
	public ArrayList<donvibean> Them(String madv, String tendv) throws Exception{
		for(donvibean dv: ds)
			if(dv.getMadv().equals(madv))
				return null;
		ds.add(new donvibean(madv, tendv));
		//them vao csdl		
		dvdao.Them(madv, tendv);	
		return ds;
	}
	
	public ArrayList<donvibean> Xoa(String madv) throws Exception{
		for(donvibean dv: ds)
			if(dv.getMadv().equals(madv)) {
				ds.remove(dv);//xoa trong bo nho
				dvdao.Xoa(madv);//xoa trong csdl
				break;
			}
		return ds;
	}
	
	public ArrayList<donvibean> Sua(String madv, String tendvmoi) throws Exception{
		int n=ds.size();
		for(int i=0;i<n;i++) {
			if(ds.get(i).getMadv().equals(madv)) {
				donvibean dv=ds.get(i);
				dv.setTendv(tendvmoi);
				ds.set(i,dv);//sua trong bo nho
				dvdao.Sua(madv, tendvmoi);//sua trong csdl
				break;
			}
		}
		return ds;
	}
	public void Napfile() throws Exception{
		FileReader f= new FileReader("donvi.txt");
		BufferedReader b= new BufferedReader(f);
		while(true) {
			String st=b.readLine();
			if(st==null || st=="") break;
			String[] t=st.split("[;]");
			Them(t[0], t[1]);//them vao csdl
		}
		b.close();
		ds=dvdao.getdv();
	}
//	public void Napfile() throws Exception{
//		dvdao.Napfile();
//		ds=getdv();
//	}
}










