package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdMenuController;

public class MainMenuTbl {
	static MainMenuTbl m= new MainMenuTbl();
	public  Scanner bf=new Scanner( System.in );
	public BufferedReader dataIn= new BufferedReader(new InputStreamReader(System.in));

	public static void main(String [] args) {
		
		m.MenuUtamaMenuTbl();
	}
	
	public void testQueryMencariMenu(){
		MdMenuController obj=new MdMenuController();
		try {
			System.out.print("Masukan Kode : ");
			String inputKode=bf.nextLine();
			JSONArray data = obj.getQueryMencariMenuByKode(inputKode); 
			showData(data, "kd_menu", "nama_menu");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		//MenuUtamaMenuTbl();
	}
	
	public void testQueryTambahMenu(){
		MdMenuController obj=new MdMenuController();
		try {
			System.out.print("Masukan Kode : ");
			String kode=dataIn.readLine();
			System.out.print("Masukan Nama : ");
			String nama=dataIn.readLine();
			System.out.print("Masukan Form : ");
			String nf=dataIn.readLine();
			obj.getQueryTambahMenu(kode, nama, nf);
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		//MenuUtamaMenuTbl();
	}

	public void testQueryUbahMenu(){
		MdMenuController obj=new MdMenuController();
		try {
			System.out.print("Masukan Kode : ");
			String kode=dataIn.readLine();
			System.out.println("Di ubah menjadi ! ");
			System.out.print("Masukan Nama : ");
			String nama=dataIn.readLine();
			System.out.print("Masukan Form : ");
			String nf=dataIn.readLine();
			obj.getQueryUbahMenu(kode, nama, nf);
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		//MenuUtamaMenuTbl();
	}

	public void testQueryHapusMenu(){
		MdMenuController obj=new MdMenuController();
		try {
			System.out.print("Masukan Kode : ");
			String kode=dataIn.readLine();
			obj.getQueryHapusMenu(kode);
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		//MenuUtamaMenuTbl();
	}
	public void testQueryTampilMenu(){
		MdMenuController obj=new MdMenuController();
		try {JSONArray data = obj.getQueryTampilMenu(); 
			showData(data, "kd_menu", "nama_menu");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		//MenuUtamaMenuTbl();
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
	
	public void MenuUtamaMenuTbl() {
		System.out.println("Show Menu Tbl");
		System.out.println("1. Mencari Data Menu By Kode");
		System.out.println("2. Menampilkan Semua Data");
		System.out.println("3. Tambah Data");
		System.out.println("4. Hapus Data");
		System.out.println("5. Ubah Data");
		System.out.print("Masukkan nomor : ");
		String inp = bf.nextLine();
		switch(inp) {
			case "1":   m.testQueryMencariMenu();
						m.MenuUtamaMenuTbl();
						break;
			case "2": 	m.testQueryTampilMenu();
						m.MenuUtamaMenuTbl();
						break;
			case "3": 	m.testQueryTambahMenu();
						m.MenuUtamaMenuTbl();
						break;
			case "4": 	m.testQueryHapusMenu();
						m.MenuUtamaMenuTbl();
						break;
			case "5": 	m.testQueryUbahMenu();
						m.MenuUtamaMenuTbl();
						break;
			
			
		}
		
		
	}
}
