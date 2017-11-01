package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdKorpriTblController;
import com.padepokan79.controller.MdSsbpController;

public class MainSsbp {
	static MainSsbp m= new MainSsbp(); 
	public  Scanner bf=new Scanner( System.in );
	public static void main(String [] args) {
		m.MenuUtamaMenuTbl();
	}
	public  void showData(JSONArray arrayData,String fielda, String fieldb) {
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			System.out.print("|   "+obj.get(fielda)+"    |");
			System.out.print("|   "+obj.get(fieldb)+"    |");

			System.out.println(" |");
			System.out.println("+--------------------------------------+");
		}

	}
	public void testQueryTampilSSBP(){
		MdSsbpController obj = new MdSsbpController();
		try {
			JSONArray data = obj.getQueryTampilSsbp(); 
			showData(data, "npwp", "namawp");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	
	public void testQueryMencariSsbp(){
		MdKorpriTblController obj=new MdKorpriTblController();
		try {
			System.out.print("Masukan Kode : ");
			Integer inputKode=bf.nextInt();
			JSONArray data = obj.getQueryMencariKorpriByKode(inputKode); 
			showData(data, "Npwp", "namawp");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	
	public void MenuUtamaMenuTbl() {
		System.out.println("Show SSbp Tbl");
		System.out.println("1. Mencari Data  By Kode");
		System.out.println("2. Menampilkan Semua Data");
		System.out.print("Masukkan nomor : ");
		String inp = bf.nextLine();
		switch(inp) {
			case "1":   m.testQueryMencariSsbp();
						m.MenuUtamaMenuTbl();
						break;
			case "2": 	m.testQueryTampilSSBP();
						m.MenuUtamaMenuTbl();
						break;
			
		}
		
		
	}
}
