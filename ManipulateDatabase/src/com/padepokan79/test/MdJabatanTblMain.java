package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdFileBlnController;
import com.padepokan79.controller.MdJabatanTblController;

public class MdJabatanTblMain {
	//public  Scanner keyboard = new Scanner( System.in );
	BufferedReader keyboard= new BufferedReader(new InputStreamReader(System.in));
	public  void testqueryMenghapusJabatan() {
		MdJabatanTblController jb = new MdJabatanTblController();
		
		try {
			System.out.print("Masukan Kode Jabatan yang akan di hapus : ");
			String inputKode=keyboard.readLine();
			JSONArray data = jb.getMenghapusJabatan(inputKode);
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
		mainMenu();
	}
	
	public  void testqueryMenampilkanTabelJabatan() {
		MdJabatanTblController jb = new MdJabatanTblController();
		
		try {
			//System.out.print("Masukan Kode Bulan : ");
    		//int inputKode=keyboard.nextInt();
			JSONArray data = jb.getMenampilkanTabelJabatan();
			showData_Jabatan(data, "kdjabatan", "nmjabatan");
		} catch (Exception e) {
			//System.out.println("Inputan Salah, masukan angka 1 sampai 12");
			System.out.println(e.getMessage());
			 
		}
	}
	public  void testqueryMenambahJabatan() {
		MdJabatanTblController jb = new MdJabatanTblController();
		
		try {
			System.out.print("Masukan Kode Jabatan : ");
			String inputKode=keyboard.readLine();
			System.out.print("Masukan Nama Jabatan : ");
			String namaJabatan=keyboard.readLine();
			JSONArray data = jb.getMenambahJabatan("0000-00-00", inputKode, namaJabatan, 0, 0, 0, "");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		mainMenu();
	}
		public  void queryMengeditBulan() {
			MdJabatanTblController jb = new MdJabatanTblController();			
			try {
				System.out.print("Masukan Kode Jabatan yang akan di edit : ");
				String inputKode=keyboard.readLine();
				System.out.print("Masukan Nama Jabatan yang akan dirubah : ");
				String namaJabatan=keyboard.readLine();
				JSONArray data = jb.getMengeditJabatan(inputKode, namaJabatan);
			} catch (Exception e) {
				//System.out.println("Inputan Salah, masukan angka untuk Kode bulan");
				System.out.println(e.getMessage());
			}
			mainMenu();
	}
	public  void testMencariNamaJabatan() {
		MdJabatanTblController jb = new MdJabatanTblController();
		
		try {
			System.out.print("Masukan Kode Jabatan : ");
			String inputKode=keyboard.readLine();
			JSONArray data = jb.getmencariJabatan(inputKode);
			showData_Jabatan(data,"kdjabatan", "nmjabatan");
		} catch (Exception e) {
			//System.out.println("Inputan Salah, masukan angka 1 sampai 12");
			System.out.println(e.getMessage());
			 
		}
		mainMenu();
	}
	public MdJabatanTblMain(){
		mainMenu();
	}
	public  void backto()  {
		String inp;
		MainActivity ma = new MainActivity();
		System.out.print("1. Menu Utama 2. Submenu Mencari Jabatan Berdasarkan Kode Jabatan  : ");
		try {
			inp=keyboard.readLine();
			switch (inp) {
			case "1":
				mainMenu();
				break;
			case "2":
				testMencariNamaJabatan();
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
		
		System.out.println("1. Menampilkan Tabel Jabatan");
		System.out.println("2. Mencari Nama Jabatan Berdasarkan Kode Jabatan");
		System.out.println("3. Menambahkan Jabatan");
		System.out.println("4. Mengedit Jabatan");
		System.out.println("5. Menghapus Data Jabatan");
		System.out.println("=======================================");
		System.out.print("Masukan Menu : ");
		try {
			inp=keyboard.readLine();
			switch (inp) {
			case "1":
				testqueryMenampilkanTabelJabatan();
				break;
			case "2":
				testMencariNamaJabatan();
				break;
			case "3":
				testqueryMenambahJabatan();
				break;
			case "4":
				queryMengeditBulan();
			case "5":
				testqueryMenghapusJabatan();
			default:
				System.out.println("Masukan Salah !");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public  void showData_Jabatan(JSONArray arrayData, String kdjbtn, String namajbtn) {
		//System.out.println(arrayData);
		System.out.println("+--------------------------------------------------------------------------------+");
		System.out.println("| Kode Jabatan       |                     Nama Jabatan                          |");
		System.out.println("+--------------------------------------------------------------------------------+");
		String space;
		String tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			tamp=(String) obj.get(kdjbtn);
			System.out.print("| "+tamp);

			space=(String) obj.get(namajbtn);
			
			System.out.print("              |"+ space);
			for (int j = 0; j  < 58 - (space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+--------------------------------------------------------------------------------+");
		}
		//backto();
		//add by Cucu Yuni
	}
	public static void main(String args[]) {
		MdJabatanTblMain mainJB = new MdJabatanTblMain();
		mainJB.mainMenu();
	}

}
