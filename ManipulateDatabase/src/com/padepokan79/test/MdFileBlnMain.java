package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.Agama;
import com.padepokan79.controller.MdAgamaController;
import com.padepokan79.controller.MdFileBlnController;

public class MdFileBlnMain {
	public  Scanner keyboard = new Scanner( System.in );
	public  void testqueryMenghapusTabelBulan() {
		MdFileBlnController bl = new MdFileBlnController();
		
		try {
			System.out.print("Masukan Kode Bulan yang akan di hapus : ");
			int inputKode=keyboard.nextInt();
			JSONArray data = bl.getMenghapusBulan(inputKode);
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan angka");
			System.out.println(e.getMessage());
			 
		}
		mainMenu();
	}
	
	public  void testqueryMenampilkanTabelBulan() {
		MdFileBlnController bl = new MdFileBlnController();
		
		try {
			//System.out.print("Masukan Kode Bulan : ");
    		//int inputKode=keyboard.nextInt();
			JSONArray data = bl.getMenampilkanTabelBulan();
			showData_Bulan(data, "curr_mm", "name_mm");
		} catch (Exception e) {
			//System.out.println("Inputan Salah, masukan angka 1 sampai 12");
			System.out.println(e.getMessage());
			 
		}
	}
	public  void testqueryMenambahBulan() {
		MdFileBlnController bl =new MdFileBlnController();
		
		try {
			System.out.print("Masukan Kode Bulan : ");
			int inputKode=keyboard.nextInt();
			System.out.print("Masukan Nama Bulan : ");
			String namaBulan=keyboard.next();
			JSONArray data = bl.getMenambahBulan(inputKode,0, 0, 0,  namaBulan);
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan angka untuk Kode Bulan");
			System.out.println(e.getMessage());
		}
		mainMenu();
	}
		public  void queryMengeditBulan() {
			MdFileBlnController bl = new MdFileBlnController();
			
			try {
				System.out.print("Masukan Kode Bulan yang akan di edit : ");
				int inputKode=keyboard.nextInt();
				System.out.print("Masukan Nama Bulan yang akan dirubah : ");
				String namaBulan=keyboard.next();
				JSONArray data = bl.getMengeditBulan(namaBulan, inputKode);
			} catch (Exception e) {
				//System.out.println("Inputan Salah, masukan angka untuk Kode bulan");
				System.out.println(e.getMessage());
			}
			mainMenu();
	}
	public  void testMencariNamaBulan() {
		MdFileBlnController bl = new MdFileBlnController();
		
		try {
			System.out.print("Masukan No Bulan : ");
			int inputKode=keyboard.nextInt();
			JSONArray data = bl.getmencariBulan(inputKode);
			showData_Bulan(data,"curr_mm", "name_mm");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan angka 1 sampai 12");
			System.out.println(e.getMessage());
			 
		}
		mainMenu();
	}
	public MdFileBlnMain(){
		mainMenu();
	}
	public  void backto()  {
		String inp;
		MainActivity ma = new MainActivity();
		System.out.print("1. Menu Utama 2. Submenu Mencari Bulan Berdasarkan Urutan Bulan  : ");
		try {
			inp=keyboard.next();
			switch (inp) {
			case "1":
				mainMenu();
				break;
			case "2":
				testMencariNamaBulan();
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
		
		System.out.println("1. Menampilkan Tabel Bulan");
		System.out.println("2. Mencari Nama Bulan Berdasarkan Kode Bulan");
		System.out.println("3. Menambahkan Bulan Baru");
		System.out.println("4. Mengedit Bulan");
		System.out.println("5. Menghapus Data Bulan");
		System.out.println("=======================================");
		System.out.print("Masukan Menu : ");
		try {
			inp=keyboard.next();
			switch (inp) {
			case "1":
				testqueryMenampilkanTabelBulan();
				break;
			case "2":
				testMencariNamaBulan();
				break;
			case "3":
				testqueryMenambahBulan();
				break;
			case "4":
				queryMengeditBulan();
			case "5":
				testqueryMenghapusTabelBulan();
			default:
				System.out.println("Masukan Salah !");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public  void showData_Bulan(JSONArray arrayData, String no_bulan, String nama_bulan) {
		//System.out.println(arrayData);
		System.out.println("+----------------------------------+");
		System.out.println("| No Bulan       | Nama Bulan      |");
		System.out.println("+----------------------------------+");
		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			tamp=(int) obj.get(no_bulan);
			System.out.print("| "+tamp);

			space=(String) obj.get(nama_bulan);
			
			System.out.print("              | "+ space);
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
		MdFileBlnMain mainBln = new MdFileBlnMain();
		mainBln.mainMenu();
	}

}
