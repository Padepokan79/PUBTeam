package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdTbulanController;

public class MainTbulan {
	Scanner keyboard = new Scanner( System.in );
	
	public void menuUtama(){
		System.out.println("+------------------+");
		System.out.println("| MENU TABEL BULAN |");
		System.out.println("+------------------+");
		System.out.println("| 1. Insert Data   |");
		System.out.println("| 2. Select Data   |");
		System.out.println("| 3. Search Data   |");
		System.out.println("| 4. Update Data   |");
		System.out.println("| 5. Delete Data   |");
		System.out.println("+------------------+");
		try {
			System.out.print("Masukan Pilihan : ");
			int input=keyboard.nextInt();
			if(input==1) {
				testqueryMenambahkanTabelBulan();
			}else if(input==2) {
				testQueryMenampilkanTabelBulan();
			}else if(input==3) {
				testQueryMencariNamaBulan();
			}else if(input==4) {
				testQueryMengeditBulan();
			}else if(input==5) {
				testQueryMenghapusBulan();
			}else{
				System.out.println("Maaf, inputan anda salah");
				menuUtama();
			}
		}catch (Exception e) {
				System.out.println("Exception Print !");
				System.out.println(e.getMessage());
		}
	
	}
	
/////////////////////////////////////////////////MENAMBAHKAN//////////////////////////////////////////////
	
	
	public  void testqueryMenambahkanTabelBulan() {
		MdTbulanController tbc = new MdTbulanController();

		try {
			System.out.print("Masukan Kode Bulan : ");
			int inputKode=keyboard.nextInt();
			System.out.print("Masukan Nama Bulan : ");
			String inputNama=keyboard.next();
			JSONArray data = tbc.getMenambahBulan(inputKode, inputNama);
			menuUtama();
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	
/////////////////////////////////////////////////MENAMPILKAN//////////////////////////////////////////////

	public  void testQueryMenampilkanTabelBulan() {
		 MdTbulanController tbc = new MdTbulanController();
	
		try {
			JSONArray data = tbc.getMenampilkanTabelBulan();
			showData_bulan(data,"kdbulan","nmbulan");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		 
		}
	}	
	

	/////////////////////////////////////////////////MENCARI//////////////////////////////////////////////
	
	public  void testQueryMencariNamaBulan() {
		 MdTbulanController tbc = new MdTbulanController();
	
		 try {
				System.out.print("Masukan Kode Bulan : ");
				int inputKode=keyboard.nextInt();
				JSONArray data = tbc.getMencariBulan(inputKode);
				showData_bulan(data,"kdbulan","nmbulan");
			} catch (Exception e) {
				System.out.println("Inputan Salah..");
				System.out.println(e.getMessage());
				 
			}
	}
	
	
	/////////////////////////////////////////////////MENGUBAH//////////////////////////////////////////////
	
	public  void testQueryMengeditBulan() {
		MdTbulanController tbc = new MdTbulanController();
		
		try {
			System.out.print("Masukan Kode Bulan yang akan di update: ");
			int inputKode=keyboard.nextInt();
			System.out.print("Masukan Nama Bulan Baru: ");
			String inputNama=keyboard.next();
			JSONArray data = tbc.getMengeditBulan(inputKode, inputNama);
			menuUtama();
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
/////////////////////////////////////////////////MENGHAPUS//////////////////////////////////////////////
	
	public  void testQueryMenghapusBulan() {
		MdTbulanController tbc = new MdTbulanController();
		
		try {
			System.out.print("Masukan Kode Bulan yang akan di hapus: ");
			int inputKode=keyboard.nextInt();
			JSONArray data = tbc.getMenghapusBulan(inputKode);
			menuUtama();
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	/////////////////////////////////////////////////SHOW DATA//////////////////////////////////////////////
	
	public  void showData_bulan(JSONArray arrayData, String kdbulan, String nmbulan) {
		
		System.out.println("+----------------------------------+");
		System.out.println("| Kode Bulan     | Nama Bulan      |");
		System.out.println("+----------------------------------+");
		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			tamp=(int) obj.get(kdbulan);
			System.out.print("| "+tamp);

			space=(String) obj.get(nmbulan);
			System.out.print("             | "+ space);
			for(int j = 0; j  < 16 - (space.length()); j++) {
			System.out.print(" ");
			}
		System.out.println("|");
		System.out.println("+----------------------------------+");
		}
		menuUtama();
	}
	
	public static void main(String[] args) {
		MainTbulan tb = new MainTbulan();	
		tb.menuUtama();
	}
}