package com.padepokan79.test;

import java.sql.Date;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdZakatTdkController;

public class MainZakatTdk {

Scanner keyboard = new Scanner( System.in );
	
	public void menuUtama1(){
		System.out.println("+------------------+");
		System.out.println("| MENU TABEL ZAKAT |");
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
				testqueryMenambahkanTabelZakat();
			}else if(input==2) {
				testQueryMenampilkanTabelZakat();
			}else if(input==3) {
				testQueryMencariZakat();
			}else if(input==4) {
				testQueryMengeditZakat();
			}else if(input==5) {
				testQueryMenghapusZakat();
			}else{
				System.out.println("Maaf, inputan anda salah");
				menuUtama1();
			}
		}catch (Exception e) {
				System.out.println("Exception Print !");
				System.out.println(e.getMessage());
		}
	
	}
	
/////////////////////////////////////////////////MENAMBAHKAN//////////////////////////////////////////////
	
	
	public  void testqueryMenambahkanTabelZakat() {
		MdZakatTdkController zt = new MdZakatTdkController();

		try {
			System.out.print("Masukan NIP : ");
			String inputKode=keyboard.next();
			System.out.print("Masukan Tanggal Mulai : ");
			String inputMulai=keyboard.next();
			JSONArray data = zt.getMenambahZakat(inputKode, inputMulai);
			menuUtama1();
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	
/////////////////////////////////////////////////MENAMPILKAN//////////////////////////////////////////////

	public  void testQueryMenampilkanTabelZakat() {
		 MdZakatTdkController zt = new MdZakatTdkController();
	
		try {
			JSONArray data = zt.getMenampilkanTabelZakat();
			showData_bulan(data,"nip","mulai");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		 
		}
	}	
	

	/////////////////////////////////////////////////MENCARI//////////////////////////////////////////////
	
	public  void testQueryMencariZakat() {
		MdZakatTdkController zt = new MdZakatTdkController();
	
		 try {
				System.out.print("Masukan NIP : ");
				String inputKode=keyboard.next();
				JSONArray data = zt.getMencariZakat(inputKode);
				showData_bulan(data,"nip","mulai");
			} catch (Exception e) {
				System.out.println("Inputan Salah..");
				System.out.println(e.getMessage());
				 
			}
	}
	
	
	/////////////////////////////////////////////////MENGUBAH//////////////////////////////////////////////
	
	public  void testQueryMengeditZakat() {
		MdZakatTdkController zt = new MdZakatTdkController();
		
		try {
			System.out.print("Masukan NIP yang akan di update: ");
			String inputKode=keyboard.next();
			System.out.print("Masukan Tanggal Mulai Baru: ");
			String inputMulai=keyboard.next();
			JSONArray data = zt.getMengeditZakat(inputKode, inputMulai);
			menuUtama1();
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
/////////////////////////////////////////////////MENGHAPUS//////////////////////////////////////////////
	
	public  void testQueryMenghapusZakat() {
		MdZakatTdkController zt = new MdZakatTdkController();
		
		try {
			System.out.print("Masukan NIP yang akan di hapus: ");
			String inputKode=keyboard.next();
			JSONArray data = zt.getMenghapusZakat(inputKode);
			menuUtama1();
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	/////////////////////////////////////////////////SHOW DATA//////////////////////////////////////////////
	
	public  void showData_bulan(JSONArray arrayData, String nip, String mulai) {
		
		System.out.println("+---------------------------------------------+");
		System.out.println("| NIP                            | MULAI      |");
		System.out.println("+---------------------------------------------+");
		Date sp;
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(nip);
			System.out.print("| "+space);
			for(int j = 0; j  < 18 - (space.length()); j++) {
				System.out.print(" ");
			}
			sp=(Date) obj.get(mulai);
			System.out.print("             | "+ sp);
			System.out.print(" ");
			
		System.out.println("|");
		System.out.println("+---------------------------------------------+");
		}
		menuUtama1();
	}
	
	
	
	public static void main(String[] args) {
		MainZakatTdk zt = new MainZakatTdk();
		zt.menuUtama1();
	}

}
