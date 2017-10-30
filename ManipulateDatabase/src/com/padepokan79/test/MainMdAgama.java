package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdAgamaController;



public class MainMdAgama{
	
	public  Scanner keyboard = new Scanner( System.in );
	
	public  void testqueryMenghapusTabelAgama() {
		MdAgamaController ag = new MdAgamaController();
		
		try {
			System.out.print("Masukan Kode Agama yang akan di hapus : ");
			int inputKode=keyboard.nextInt();
			JSONArray data = ag.getMenghapusAgama(inputKode);
//			showData_agama(data,"kdagama","nmagama");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan angka");
			System.out.println(e.getMessage());
			 
		}
		mainMenu();
	}
	
	public  void testqueryMenampilkanTabelAgama() {
		MdAgamaController ag = new MdAgamaController();
		
		try {
//			System.out.print("Masukan Kode Agama : ");
//			int inputKode=keyboard.nextInt();
			JSONArray data = ag.getMenampilkanTabelAgama();
			showData_agama(data,"kdagama","nmagama");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan angka 1 sampai 6");
			System.out.println(e.getMessage());
			 
		}
	}
	public  void testqueryMenambahAgama() {
		MdAgamaController ag = new MdAgamaController();
		
		try {
			System.out.print("Masukan Kode Agama : ");
			int inputKode=keyboard.nextInt();
			System.out.print("Masukan Nama Agama : ");
			String namaAgama=keyboard.next();
			JSONArray data = ag.getMenambahAgama(inputKode, namaAgama);
//			showData_agama(data,"kdagama","nmagama");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan angka untuk KodeAgama");
			System.out.println(e.getMessage());
		}
		mainMenu();
	}
		public  void testqueryMengeditAgama() {
			MdAgamaController ag = new MdAgamaController();
			
			try {
				System.out.print("Masukan Kode Agama yang akan di edit : ");
				int inputKode=keyboard.nextInt();
				System.out.print("Masukan Nama Agama yang akan dirubah : ");
				String namaAgama=keyboard.next();
				JSONArray data = ag.getMengeditAgama(namaAgama, inputKode);
//				showData_agama(data,"kdagama","nmagama");
			} catch (Exception e) {
				System.out.println("Inputan Salah, masukan angka untuk KodeAgama");
				System.out.println(e.getMessage());
			}
			mainMenu();
	}
	public  void testqueryMencariNamaAgama() {
		MdAgamaController ag = new MdAgamaController();
		
		try {
			System.out.print("Masukan Kode Agama : ");
			int inputKode=keyboard.nextInt();
			JSONArray data = ag.getMencariAgama(inputKode);
			showData_agama(data,"kdagama","nmagama");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan angka 1 sampai 6");
			System.out.println(e.getMessage());
			 
		}
	}
	public MainMdAgama(){
		mainMenu();
	}
	public  void mainMenu()  {
		String inp;
		
		System.out.println("1. Menampilkan Tabel Agama");
		System.out.println("2. Mencari Agama Berdasarkan KodeAgama");
		System.out.println("3. Menambahkan Agama Baru");
		System.out.println("4. Mengedit Agama");
		System.out.println("5. Menghapus Data Agama");
		System.out.println("=======================================");
		System.out.print("Masukan Menu : ");
		try {
			inp=keyboard.next();
			switch (inp) {
			case "1":
				testqueryMenampilkanTabelAgama();
				break;
			case "2":
				testqueryMencariNamaAgama();
				break;
			case "3":
				testqueryMenambahAgama();
				break;
			case "4":
				testqueryMengeditAgama();
			case "5":
				testqueryMenghapusTabelAgama();
			default:
				System.out.println("Masukan Salah !");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public  void showData_agama(JSONArray arrayData, String kdagama, String nmagama) {
		//System.out.println(arrayData);
		System.out.println("+----------------------------------+");
		System.out.println("| Kode Agama     | Nama Agama      |");
		System.out.println("+----------------------------------+");
		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			tamp=(int) obj.get(kdagama);
			System.out.print("| "+tamp);

			space=(String) obj.get(nmagama);
			System.out.print("              | "+ space);
			for (int j = 0; j  < 16 - (space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+----------------------------------+");
		}
		mainMenu();
		//add by Hendra YN
	}
	public static void main(String args[]) {
		MainMdAgama mMdAg = new MainMdAgama();
		mMdAg.mainMenu();
	}
}
