package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdFileBlnController;
import com.padepokan79.controller.MdGapokTblController;

public class MdGapokTblMain {
	public  Scanner keyboard = new Scanner( System.in );
	public  void testqueryMenghapusTabelGapok() {
		MdGapokTblController gp = new MdGapokTblController();
		
		try {
			System.out.print("Masukan Kode Pangkat Data yang akan di hapus : ");
			String inputKode=keyboard.next();
			JSONArray data = gp.getMenghapusGapok(inputKode);
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
		mainMenu();
	}
	
	public  void testqueryMenampilkanTabelGapok() {
		MdGapokTblController gp = new MdGapokTblController();
		
		try {
			//System.out.print("Masukan Kode Bulan : ");
    		//int inputKode=keyboard.nextInt();
			JSONArray data = gp.getMenampilkanTabelGapok();
			showData_Gapok(data, "kdpangkat", "nilai_bawah");
		} catch (Exception e) {
			//System.out.println("Inputan Salah, masukan angka 1 sampai 12");
			System.out.println(e.getMessage());
			 
		}
	}
	public  void testqueryMenambahGapok() {
		MdGapokTblController gp = new MdGapokTblController();
		try {
			System.out.print("Masukan Kode Pangkat : ");
			String namaGapok=keyboard.next();
			System.out.print("Masukan Nilai Bawah Gapok : ");
			int inputKode=keyboard.nextInt();
			JSONArray data = gp.getMenambahGapok(0, "0000-00-00", namaGapok, 0, inputKode, 0);
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		mainMenu();
	}
		public  void queryMengeditGapok() {
			MdGapokTblController gp = new MdGapokTblController();
			
			try {
				System.out.print("Masukan Kode Pangkat Data yang akan di edit : ");
				String kode=keyboard.next();
				System.out.print("Masukan Nilai Bawah Gapok yang akan dirubah : ");
				int nilai=keyboard.nextInt();
				JSONArray data = gp.getMengeditGapok(kode, nilai);
			} catch (Exception e) {
				//System.out.println("Inputan Salah, masukan angka untuk Kode bulan");
				System.out.println(e.getMessage());
			}
			mainMenu();
	}
	public  void testMencariGapok() {
		MdGapokTblController gp = new MdGapokTblController();
		try {
			System.out.print("Masukan Kode Pangkat : ");
			String kode=keyboard.next();
			JSONArray data = gp.getmencariGapok(kode);
			showData_Gapok(data,"kdpangkat", "nilai_bawah");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
		mainMenu();
	}
	public MdGapokTblMain() {
		mainMenu();
	}
	public  void backto()  {
		String inp;
		MainActivity ma = new MainActivity();
		System.out.print("1. Menu Utama 2. Submenu Mencari Gapok Berdasarkan Kode Pangkat  : ");
		try {
			inp=keyboard.next();
			switch (inp) {
			case "1":
				mainMenu();
				break;
			case "2":
				testMencariGapok();
				break;
			default:
				System.out.println("Masukan Salah !");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public  void mainMenu()  {
		String inp;
		
		System.out.println("1. Menampilkan Tabel Gapok");
		System.out.println("2. Mencari Gapok Berdasarkan Kode Pangkat");
		System.out.println("3. Menambahkan Gapok Baru");
		System.out.println("4. Mengedit Gapok");
		System.out.println("5. Menghapus Data Gapok");
		System.out.println("=======================================");
		System.out.print("Masukan Menu : ");
		try {
			inp=keyboard.next();
			switch (inp) {
			case "1":
				testqueryMenampilkanTabelGapok();
				break;
			case "2":
				testMencariGapok();
				break;
			case "3":
				testqueryMenambahGapok();
				break;
			case "4":
				queryMengeditGapok();
			case "5":
				testqueryMenghapusTabelGapok();
			default:
				System.out.println("Masukan Salah !");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public  void showData_Gapok(JSONArray arrayData, String kode, String nilai) {
		//System.out.println(arrayData);
		System.out.println("+--------------------------------------+");
		System.out.println("| Kode Pangkat     |   Nilai Bawah     |");
		System.out.println("+--------------------------------------+");
		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			
			space=(String) obj.get(kode);
			System.out.print( "| "+ space);
			tamp=(int) obj.get(nilai);
			System.out.print("                |"+tamp);

			
			
			
			for (int j = 0; j  < 16 - (space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+----------------------------------+");
		}
		//backto();
		//add by Cucu Yuni
	}
	public static void main(String args[]) {
		MdGapokTblMain mainBln = new MdGapokTblMain();
		mainBln.mainMenu();
	}


}
