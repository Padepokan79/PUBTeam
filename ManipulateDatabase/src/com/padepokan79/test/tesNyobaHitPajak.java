package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;


import com.padepokan79.model.NyobaHitPajak;

public class tesNyobaHitPajak {
	static MainActivity ma=new MainActivity();
	public static Scanner sc=new Scanner( System.in );
	
	//KodeGuru, NamaGuru,
	public static void tesMencariHitPajak(){
		
		NyobaHitPajak hit = new NyobaHitPajak();
		try {
//			InputVariable in = new InputVariable();
			System.out.print("Masukan jumlah anak 1 s.d 17 : ");
			int masukan = sc.nextInt();
			System.out.print("Masukan jumlah anak 1 s.d 17 : ");
			int masukan2 = sc.nextInt();
			JSONArray data = hit.getHitPajak(masukan, masukan2);
//			showData_skpp(data,"kodeguru","namaguru");
			showDataTop10AllFields(data);
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	public static void backto()  {
		String inp;
		System.out.print("1. Menu Utama 2. Submenu Mencari Guru Berdasarkan Kode  : ");
		try {
			inp=sc.next();
			switch (inp) {
			case "1":
				ma.menuUtama();;
				break;
			case "2":
				tesMencariHitPajak();
				break;
			default:
				System.out.println("Masukan Salah !");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void showData_skpp(JSONArray arrayData, String pa, String pb) {
		//System.out.println(arrayData);
		System.out.println("+--------------------------------------+");
		System.out.println("| KodeGuru |          NamaGuru         |");
		System.out.println("+--------------------------------------+");
		String space;
		int tamp=0;
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
	public static void showDataTop10AllFields(JSONArray arrayData) {
		System.out.println(arrayData.length());
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);
			System.out.println(obj);
			
		}
		backto();
	}

	public static void main(String args[]) {
		tesNyobaHitPajak md=new tesNyobaHitPajak();
		md.tesMencariHitPajak();
	}


}
