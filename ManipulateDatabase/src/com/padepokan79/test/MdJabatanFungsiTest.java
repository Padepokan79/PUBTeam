package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdJabatanFungsiController;
import com.padepokan79.model.MdJabatanFungsi;
import com.padepokan79.util.DatabaseConnection;

public class MdJabatanFungsiTest extends DatabaseConnection implements MdJabatanFungsi {
	Scanner in=new Scanner(System.in);
	 MainActivity ma=new MainActivity();
	 public MdJabatanFungsiTest() {
		 mainMenu();
	 }
	 
	 public void mainMenu() {
		 	System.out.println("+------------------------------------+");
			System.out.println("|       ~ Menu Jabatan_Fungsi ~      |");
			System.out.println("+------------------------------------+");
			System.out.println("| 1. Menampilkan  |   2. Menambahkan |");
			System.out.println("+------------------------------------+");
			System.out.println("| 3. Merubah      |   4. Menghapus   |");
			System.out.println("+------------------------------------+");
			System.out.println("|           5. Mencari               |");
			System.out.println("+------------------------------------+");
			
			try {
				System.out.print("Masukan PIlihan : ");
				String input=in.next();
				switch (input) {
				case "1":
					testMenampilkanData();
					break;
				case "2":
					testMenambahkanData();
					testMenampilkanData();
					break;
				case "3":
					testMerubahData();
					testMenampilkanData();
					break;
				case "4":
					testMenghapusData();
					testMenampilkanData();
					break;
				case "5":
					testMencariData();
					break;
				case "0":
					mainMenu();
					break;
				default:
					System.out.println("Masukan anda tidak valid !");
				}
			} catch (Exception e) {
				System.out.println("Exception Print !");
				System.out.println(e.getMessage());
			}		
	 }
	 public  void testMenampilkanData(){
			MdJabatanFungsiController mac=new MdJabatanFungsiController();
			try {
				JSONArray data = mac.getMenampilkanTabelJabatanFungsi();
				showData(data,"kdfungsi","nmfungsi");
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}
	}
	 public  void testMenambahkanData(){
		 MdJabatanFungsiController mac=new MdJabatanFungsiController();
			int kdfungsi;
			String nmfungsi;
			try {
				System.out.print("Masukkan Kode Fungsi : ");
				kdfungsi=in.nextInt();
				System.out.print("Masukkan Nama Fungsi : ");
				nmfungsi=in.next();
				System.out.println("");
				mac.getMenambahkanTabelJabatanFungsi(kdfungsi, nmfungsi);
//				MdJabatanFungsiTest mat=new MdJabatanFungsiTest();	
//				mat.testMenampilkanData();
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}
	}
	 public  void testMenghapusData(){
		 MdJabatanFungsiController mac=new MdJabatanFungsiController();
			int KDFUNGSI;
			try {
				System.out.print("Masukkan Kode Fungsi : ");
				KDFUNGSI=in.nextInt();
				mac.getMenghapusTabelJabatanFungsi(KDFUNGSI);
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}
	}
	 public  void testMerubahData(){
		 MdJabatanFungsiController mac=new MdJabatanFungsiController();
			int KDFUNGSI;String NMFUNGSI;
			try {
				System.out.print("Masukkan Nama Fungsi : ");
				NMFUNGSI=in.next();
				System.out.print("Masukkan Kode Fungsi : ");
				KDFUNGSI=in.nextInt();
				mac.getMerubahTabelJabatanFungsi(NMFUNGSI, KDFUNGSI);
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}
	}
	 public  void testMencariData(){
		 MdJabatanFungsiController mac=new MdJabatanFungsiController();
			int KDFUNGSI;
			try {
				System.out.print("Masukkan Kode Fungsi : ");
				KDFUNGSI=in.nextInt();
				
				JSONArray data = mac.getMencariKodeTransTabelJabatanFungsi(KDFUNGSI);
				showData(data,"kdfungsi","nmfungsi");
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}
	}
	 
	 public  void showData(JSONArray arrayData,String kdfungsi, String nmfungsi) {
			//System.out.println(arrayData);
			System.out.println("+----------------------------------------------------------+");
			System.out.println("| Kode Fungsi   |               Nama Fungsi                |");
			System.out.println("+----------------------------------------------------------+");
			String space;
			for (int i = 0; i < arrayData.length(); i++) {
				JSONObject obj =  arrayData.getJSONObject(i);	
			//	System.out.print("|       "+obj.get(kdfungsi)+"     ");
				System.out.print("|     "+obj.get(kdfungsi));
				for (int y=0;y<10-obj.get(kdfungsi).toString().length();y++) {
					System.out.print(" ");
				}
				space=obj.getString(nmfungsi);
				space=space.trim();
				System.out.print("| "+space);
				for (int x=0;x<41-space.length();x++) {
					System.out.print(" ");
				}
				System.out.print("|\n");
				System.out.println("+----------------------------------------------------------+");
			}
		}
	 
	 public static void main (String[] args) {
		 MdJabatanFungsiTest mat=new MdJabatanFungsiTest();
	 }
}
