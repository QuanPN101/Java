package view;

import java.util.ArrayList;

import Bean.donvibean;
import Bo.donvibo;

public class donviview {

	public static void main(String[] args) {
		try {
			donvibo dvbo= new donvibo();
			ArrayList<donvibean> ds;
			ds=dvbo.getdv();
			for(donvibean dv: ds) {
				System.out.println(dv.toString());
			}
			System.out.println("Them");
			dvbo.Them("bla bla", "bro bro");
			for(donvibean dv: ds) {
				System.out.println(dv.toString());
			}
			System.out.println("Xoa");
			dvbo.Xoa("dv1");
			for(donvibean dv: ds) {
				System.out.println(dv.toString());
			}
			System.out.println("Sua");
			dvbo.Sua("dv33","Boxxm");
			for(donvibean dv: ds) {
				System.out.println(dv.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
