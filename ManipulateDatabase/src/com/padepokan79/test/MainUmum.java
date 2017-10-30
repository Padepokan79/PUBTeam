package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.Umum;

public  class MainUmum {
	public  Scanner sc = new Scanner(System.in);
	
	public  MainActivity Umum = new MainActivity();
	public  void backto()  {
		String inp;
		System.out.print("1. Menu Utama 2. Submenu Mencari Tunjangan Umum  : ");
		try {
			inp=sc.next();
			switch (inp) {
			case "1":
				Umum.menuUtama();;
				break;
			case "2":
				getMencariTJUmumBerdasarkanKodeGolongan();
				break;
			default:
				System.out.println("Masukan Salah !");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public  void getMencariTJUmumBerdasarkanKodeGolongan() {
		Umum umum = new Umum ();
		System.out.println("Masukan Kode Golongan : (1/2/3/4) ");

		int inputKode = sc.nextInt();
		JSONArray Data = umum.getQueryMencariTJUmumBerdasarkanKodeGolongan(inputKode, 0);

		showDataMencariTJUmumBerdasarkanKodeGolongan(Data,"tmtberlaku" , "kdgol" , "tjumum");
	}
	public  void showDataMencariTJUmumBerdasarkanKodeGolongan(JSONArray Data,String p1, String p2, String p3 )
	{
		System.out.println();
		System.out.println("+------------------------------------------------------------+");
		System.out.println("| 	TMTBERLAKU	 |    KDGOLONGAN   |      TJUMUM     |");
		System.out.println("+------------------------------------------------------------+");
		String space;
				//System.out.println(Data);
		for (int i = 0; i < Data.length(); i++) {
			JSONObject obj =  Data.getJSONObject(i);	
			
			//System.out.println("halo");
			System.out.print("|       "+obj.get(p1));
			
			space=String.valueOf(obj.get(p2)) ;
			System.out.print("       |      "+space);
			
			
			System.out.print("          |      "+obj.get(p3));
			
			
			System.out.println("     |");
					
			System.out.println("+------------------------------------------------------------+");
		} backto();
	}	
	public  void main(String[] args) {
		// TODO Auto-generated method stub
		MainUmum mu = new MainUmum();
		mu.getMencariTJUmumBerdasarkanKodeGolongan();

	}
	

}
