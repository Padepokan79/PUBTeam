package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdAgamaController;
import com.padepokan79.controller.MdDokumenController;

public class MainDokumen {
	BufferedReader In= new BufferedReader(new InputStreamReader(System.in));

		
	public  void Delete() {
		MdDokumenController md = new MdDokumenController();
		
		try {
			System.out.print("Masukan Kode Dokumen yang akan di hapus : ");
			String Kode=In.readLine();
			JSONArray data = md.getDeleteTable(Kode);
//			showDat(data,"kddokumen","nmdokumen");
		} catch (Exception e) {
			System.out.println("Failed");
			System.out.println(e.getMessage());
			 
		}
		mainMenu();
	}
	
	public  void view() {
		MdDokumenController md = new MdDokumenController();
		
		try {
//			System.out.print("Masukan Kode Agama : ");
//			int inputKode=keyboard.nextInt();
			JSONArray data = md.getViewTable();
			showData(data,"kddokumen","nmdokumen");
		} catch (Exception e) {
			System.out.println("Failed");
			System.out.println(e.getMessage());
			 
		}
	}
	public  void Add() {
		MdDokumenController md = new MdDokumenController();
		
		try {
			System.out.print("Masukan Kode Dokumen : ");
			String Kode=In.readLine();
			System.out.print("Masukan Nama Dokumen : ");
			String nama=In.readLine();
			 md.geInsertTable(Kode, nama);
//			showData(data,"kddokumen","nmdokumen");
		} catch (Exception e) {
			System.out.println("Failed");
			System.out.println(e.getMessage());
		}
		mainMenu();
	}
		public  void Edit() {
			MdDokumenController md = new MdDokumenController();
			
			try {
				System.out.print("Masukan Kode Dokumen yang akan di edit : ");
				String Kode=In.readLine();
				System.out.print("Masukan Nama Dokumen yang akan dirubah : ");
				String nama=In.readLine();
				JSONArray data = md.getEditTable(nama, Kode);
//				showData(data,"kddokumen","nmdokumen");
			} catch (Exception e) {
				System.out.println("Failed");
				System.out.println(e.getMessage());
			}
			mainMenu();
	}
	public  void Search() {
		MdDokumenController ag = new MdDokumenController();
		int tamp;
		try {
			System.out.print("Masukan Kode Dokumen : ");
			String Kode=In.readLine();
			//tamp = Integer.getInteger(Kode);
			JSONArray data = ag.getSelectTable(Kode);
			showData(data,"kddokumen","nmdokumen");
		} catch (Exception e) {
			System.out.println("Failed");
			System.out.println(e.getMessage());
		}
	}
	public MainDokumen(){
		mainMenu();
	}
	public  void mainMenu()  {
		String inp;
		
		System.out.println("1. View");
		System.out.println("2. Search");
		System.out.println("3. Add");
		System.out.println("4. Edit");
		System.out.println("5. Delete");
		System.out.println("=======================================");
		System.out.print("Masukan Menu : ");
		try {
			inp=In.readLine();
			switch (inp) {
			case "1":
				view();
				break;
			case "2":
				Search();
				break;
			case "3":
				Add();
				break;
			case "4":
				Edit();
			case "5":
				Delete();
			default:
				System.out.println("Masukan Salah !");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public  void showData(JSONArray arrayData, String kd, String nm) {
		System.out.println(arrayData);
		System.out.println("+---------------------------------------------+");
		System.out.println("| Kode Dokumen    | Nama Dokumen              |");
		System.out.println("+---------------------------------------------+");
		//String space;
		//String tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			
			JSONObject obj =  arrayData.getJSONObject(i);	
		
			//tamp=(String) obj.get(kd);
			System.out.print("| "+obj.get(kd));

			//space=(String) obj.get(nm);
			System.out.println("              | "+ obj.get(nm));
			//for (int j = 0; j  < 16 - (space.length()); j++) {
			//	System.out.print(" ");
			///}
			
			System.out.println("+---------------------------------------------+");
		}
		mainMenu();
		
	}
	public static void main(String []args) {
		MainDokumen md = new MainDokumen();
		md.mainMenu();
		//md.Search();
		
	}
}