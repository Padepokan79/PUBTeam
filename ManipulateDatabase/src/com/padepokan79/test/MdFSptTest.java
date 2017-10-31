package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdFSptController;
import com.padepokan79.controller.MdJadualHutangController;
import com.padepokan79.model.MdFSpt;
import com.padepokan79.util.DatabaseConnection;

public class MdFSptTest extends DatabaseConnection implements MdFSpt {
	Scanner in=new Scanner(System.in);
	 MainActivity ma=new MainActivity();
	 public MdFSptTest() {
		 mainMenu();
	 }
	 
	 public void mainMenu() {
		 	System.out.println("+------------------------------------+");
			System.out.println("|           ~ Menu F_Spt ~           |");
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
					break;
				case "3":
					testMerubahData();
			//		testMenampilkanData();
					break;
				case "4":
					testMenghapusData();
			//		testMenampilkanData();
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
			MdFSptController mac=new MdFSptController();
			try {
				JSONArray data = mac.getMenampilkanTabelFSpt();
				showData(data,"nip","nama","nourt");
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}
	}
	 public  void testMenambahkanData(){
		 MdFSptController mac=new MdFSptController();
		 String nip, nama,  kdskpd="001",  KdSatker="D10200100100006"; int nourt; double th_pajak;
			try {
				System.out.print("Masukkan nip (196811052007011001) : ");
				nip=in.next();
				System.out.print("Masukkan Nama : ");
				nama=in.next();
				System.out.print("Masukkan nourt(Mulai 1001) : ");
				nourt=in.nextInt();
				System.out.print("Masukkan Tahun Pajak(Contoh : 2.017) : ");
				th_pajak=in.nextDouble();
	

				System.out.println("");
				mac.getMenambahkanTabelFSpt(nip, nama, kdskpd, KdSatker, nourt, th_pajak);

				JSONArray data = mac.getMencariTabelFSpt(nip);
				showData(data,"nip","nama","nourt");
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}
	}
	 public  void testMenghapusData(){
		 MdFSptController mac=new MdFSptController();
			String nip;
			try {
				System.out.print("Masukkan Nip(196811052007011001) : ");
				nip=in.next();
				mac.getMenghapusTabelFSpt(nip);
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}
	}
	 public  void testMerubahData(){
		 MdFSptController mac=new MdFSptController();
			String nip;int nourt;
			try {
				System.out.print("Masukkan nourt : ");
				nourt=in.nextInt();
				System.out.print("Masukkan Nip(196811052007011001) : ");
				nip=in.next();
				mac.getMerubahTabelFSpt(nourt, nip);
				JSONArray data = mac.getMencariTabelFSpt(nip);
				showData(data,"nip","nama","nourt");
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}
	}
	 public  void testMencariData(){
		 MdFSptController mac=new MdFSptController();
			String nip;
			try {
				System.out.print("Masukkan Nip(196811052007011001) : ");
				nip=in.next();
				
				JSONArray data = mac.getMencariTabelFSpt(nip);
				showData(data,"nip","nama","nourt");
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}
	}
	 
	 public  void showData(JSONArray arrayData,String nip,  String nama, String nourt) {
			//System.out.println(arrayData);
			System.out.println("+-------------------------------------------------------+");
			System.out.println("|         nip         |        Nama         |   Nourt   |");
			System.out.println("+-------------------------------------------------------+");
			String space,space1;
			for (int i = 0; i < arrayData.length(); i++) {
				JSONObject obj =  arrayData.getJSONObject(i);	
				space=obj.getString(nip);
				space=space.trim();
				System.out.print("| "+space);
				for (int x=0;x<20-space.length();x++) {
					System.out.print(" ");
				}
				space1=obj.getString(nama);
				space1=space1.trim();
				
				System.out.print("| "+space1);
				for (int x=0;x<20-space1.length();x++) {
					System.out.print(" ");
				}
				
				System.out.print("|    "+obj.get(nourt));
				for (int y=0;y<7-obj.get(nourt).toString().length();y++) {
					System.out.print(" ");
				}
				System.out.print("|\n");
				System.out.println("+-------------------------------------------------------+");
			}
		}
	 
	 public static void main (String[] args) {
		 MdFSptTest mat=new MdFSptTest();
	 }
}
