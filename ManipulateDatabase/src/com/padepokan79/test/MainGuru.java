package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.Guru;

public class MainGuru {
	 MainActivity ma=new MainActivity();
	 int input;
	public  Scanner sc=new Scanner( System.in );
	//KodeGuru, NamaGuru,
	public  void tesMencariKodeGuruDitabelGuru(){
		Guru guru = new Guru();
		try {
			System.out.print("Masukan Kode Guru 1 s.d 17 : ");
			 input= sc.nextInt();
			JSONArray data = guru.getQueryMencariKodeGurudiTabelGuruTBL(input);
			showData_skpp(data,"kodeguru","namaguru");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	public MainGuru(){
		tesMencariKodeGuruDitabelGuru();
	}
	public  void backto()  {
		String inp;
		System.out.print("1. Menu Utama 2. Submenu Mencari Guru Berdasarkan Kode  : ");
		try {
			inp=sc.next();
			switch (inp) {
			case "1":
				ma.menuUtama();;
				break;
			case "2":
				tesMencariKodeGuruDitabelGuru();
				break;
			default:
				System.out.println("Masukan Salah !");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public  void showData_skpp(JSONArray arrayData, String pa, String pb) {
		//System.out.println(arrayData);
		System.out.println("+--------------------------------------+");
		System.out.println("| KodeGuru |          NamaGuru         |");
		System.out.println("+--------------------------------------+");
		String space;
//		int tamp=0;
//		for (int i = 0; i < arrayData.length(); i++) {
//			JSONObject obj =  arrayData.getJSONObject(i);
//			space = (String) obj.get(pb);
//			space=space.trim();
//			if(tamp<space.length())
//				tamp=space.length();
//		}
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			System.out.print("|   "+obj.get(pa)+"    |");

			space = (String) obj.get(pb);
			space=space.trim();
			System.out.print(" "+space);
			for (int j = 0; j  <25-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println(" |");
			System.out.println("+--------------------------------------+");
		}
		backto();

	}//Hendra Add ShowData Hehe... 


	public static void main(String args[]) {
		MainGuru tesGuru = new MainGuru();
		tesGuru.tesMencariKodeGuruDitabelGuru();
	}
}
