package com.padepokan79.test;

import java.io.InputStreamReader;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import com.padepokan79.controller.MdAkunTblController;

public class MdAkunTblTest {
	Scanner in=new Scanner(System.in);
	 MainActivity ma=new MainActivity();
	 public MdAkunTblTest() {
		 mainMenu();
	 }
	 
	 public void mainMenu() {
		 	System.out.println("+------------------------------------+");
			System.out.println("|          ~ Menu Akun_Tbl ~         |");
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
					break;
				case "4":
					testMenghapusData();
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
			MdAkunTblController mac=new MdAkunTblController();
			try {
				JSONArray data = mac.getMenampilkanTabelAkun();
				showData(data,"kdtrans","kdakun","nmakun");
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}

	}
	 public  void testMenambahkanData(){
			MdAkunTblController mac=new MdAkunTblController();
			int kdtrans;
			String kdakun,nmakun,idakun="";
			try {
				System.out.print("Masukkan Kode Trans : ");
				kdtrans=in.nextInt();
				System.out.print("Masukkan Kode Akun (120.18.00.00.5.1.1.01.XX) : ");
				kdakun=in.next();
				System.out.print("Masukkan Nama Akun : ");
				nmakun=in.next();
				System.out.println("");
				mac.getMenambahkanTabelAkun(kdtrans, kdakun, nmakun, idakun);
				
				JSONArray data = mac.getMencariTabelAkun(kdtrans);
				showData(data,"kdtrans","kdakun","nmakun");
				
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}

	}
	 public  void testMenghapusData(){
			MdAkunTblController mac=new MdAkunTblController();
			int kdtrans;
			try {
				System.out.print("Masukkan Kode Trans : ");
				kdtrans=in.nextInt();
				mac.getMenghapusTabelAkun(kdtrans);
				
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}

	}
	 public  void testMerubahData(){
			MdAkunTblController mac=new MdAkunTblController();
			int KDTRANS;String NMAKUN;
			try {
				System.out.print("Masukkan Nama Akun : ");
				NMAKUN=in.next();
				System.out.print("Masukkan Kode Trans : ");
				KDTRANS=in.nextInt();
				
				mac.getMerubahTabelAkun(NMAKUN, KDTRANS);
				
				JSONArray data = mac.getMencariTabelAkun(KDTRANS);
				showData(data,"kdtrans","kdakun","nmakun");
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}

	}
	 public  void testMencariData(){
			MdAkunTblController mac=new MdAkunTblController();
			int kdtrans;
			try {
				System.out.print("Masukkan Kode Trans : ");
				kdtrans=in.nextInt();
				
				JSONArray data = mac.getMencariTabelAkun(kdtrans);
				showData(data,"kdtrans","kdakun","nmakun");
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}

	}
	 
	 public  void showData(JSONArray arrayData,String kdtrans, String kdakun, String nmakun) {
			//System.out.println(arrayData);
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("| Kode Trans |       Kode Akun         |         Nama Akun         |");
			System.out.println("+------------------------------------------------------------------+");
			String space;
			for (int i = 0; i < arrayData.length(); i++) {
				JSONObject obj =  arrayData.getJSONObject(i);	
				
				System.out.print("|     "+obj.get(kdtrans)+"    ");
				System.out.print("| "+obj.get(kdakun));
				space=obj.getString(nmakun);
				space=space.trim();
				System.out.print("| "+space);
				for (int x=0;x<26-space.length();x++) {
					System.out.print(" ");
				}
				System.out.print("|\n");
				System.out.println("+------------------------------------------------------------------+");
				
				
			}
		}
	 
	 public static void main (String[] args) {
		 MdAkunTblTest mat=new MdAkunTblTest();
	 }
	 
}
