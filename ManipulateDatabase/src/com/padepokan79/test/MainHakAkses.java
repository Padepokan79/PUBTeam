package com.padepokan79.test;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;


import com.padepokan79.controller.HakAkses;


public class MainHakAkses {
	MainActivity ma=new MainActivity();
	public  Scanner bf=new Scanner( System.in );
	public  void mainMenu () {//Modify by Manto

		System.out.println("+-----------------------------------------------------------------------------------------------+");
		System.out.println("|                                      Submenu Main Hak Akses                                   |");
		System.out.println("|-----------------------------------------------------------------------------------------------|");
		System.out.println("| 1. Jumlah Hak Akses Sesuai Pemakai | 2. Mencari Yang Menggunakan Hak Akses | 0. Menu Utama    |");
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		try {
			System.out.print("Masukan PIlihan : ");
			String input=bf.next();
			switch (input) {
			case "1":
				testQueryMenghitungJumlahHakAksesBerdasarkanPemakai();	
				break;
			case "2":
				testQueryMencariYangMenggunakanKodeHakAkses();
			case "0":
				ma.menuUtama();
				break;
			default:
				System.out.println("Masukan anda tidak valid !");
			}
			
		} catch (Exception e) {
			System.out.println("Exception Print !");
			System.out.println(e.getMessage());
		}
		
	}
	public MainHakAkses(){
		mainMenu();
	}
	
	public  void backto()  {
		String inp;
		System.out.print("1. Menu Utama 2. Submenu Satuan Kerja  : ");
		try {
			inp=bf.next();
			switch (inp) {
			case "1":
				ma.menuUtama();;
				break;
			case "2":
				mainMenu();
				break;
			default:
				System.out.println("Masukan Salah !");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public  void testQueryMenghitungJumlahHakAksesBerdasarkanPemakai(){
		HakAkses objHakAkses=new HakAkses();

		try {
			JSONArray data = objHakAkses.getQueryMenghitungJumlahHakAksesBerdasarkanPemakai();
			showData(data,"pemakai","jumlah_hak_akses");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public  void testQueryMencariYangMenggunakanKodeHakAkses(){
		HakAkses objHakAkses=new HakAkses();
		try {
			System.out.print("Masukan Kode Akses : ");
			int inputKode=bf.nextInt();
			JSONArray data = objHakAkses.getQueryMencariYangMenggunakanKodeHakAkses(inputKode, 0); 
			showData2(data, "pemakai", "kodeakses");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}	
	
	public  void showData(JSONArray arrayData,String fielda, String fieldb) {
		System.out.println("+----------------------------------+");
		System.out.println("| PEMAKAI       | JUMLAH HAK AKSES |");
		System.out.println("+----------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			space=(String) obj.get(fielda);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <10-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=String.valueOf(obj.get(fieldb));
			//space=(String) obj.get(fieldb);
			space = space.trim();
			System.out.print("\t| "+space);
			for (int j = 0; j  <17-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+----------------------------------+");
		}
		backto();
	}
	
	public  void showData2(JSONArray arrayData,String fielda, String fieldb) {
		System.out.println("+---------------------------------------------------+");
		System.out.println("| KODE SATUAN KERJA     | NAMA SATUAN KERJA         |");
		System.out.println("+---------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			//System.out.print("| ");
			space=(String) obj.get(fielda);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <15-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldb);
			space = space.trim();
			System.out.print("\t| "+space);
			for (int j = 0; j  <25-(space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.println(" |");
		System.out.println("+---------------------------------------------------+");
		}
		backto();
	}
		
	public static void main(String args[]) {
		MainHakAkses mk=new MainHakAkses();
		mk.mainMenu();
	}

}
