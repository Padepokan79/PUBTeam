package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;


import com.padepokan79.controller.MdPajakAccController;

public class MainMdPajakAcc {
	public  Scanner keyboard = new Scanner( System.in );
	BufferedReader dataIn= new BufferedReader(new InputStreamReader(System.in));
	public void mainMenu () {

		System.out.println("+-------------------------------------------------------------------+");
		System.out.println("|                       Historis Eselon                             |");
		System.out.println("|-------------------------------------------------------------------|");
		System.out.println("| 1. Read Data          | 2. Insert Data     | 3. Update Data       |");
		System.out.println("|-------------------------------------------------------------------|");
		System.out.println("| 4. Search Data        | 5. Delete Data     | 0. Menu Utama        |");
		System.out.println("+-------------------------------------------------------------------+");

		try {
			System.out.print("Masukan PIlihan : ");
			String input=dataIn.readLine();
			switch (input) {
			case "1":
				testMenampilkanPajakAcc();
				break;
			case "2":
				testqueryMenambahPajakAcc();
				break;
			case "3":
				MengubahPajakAcc();
				break;
			case "4":
				testqueryMencariPajakAcc();
				break;
			case "5":
				hapusPajakAcc();
				break;
			case "0":
			default:
				System.out.println("Masukan anda tidak valid !");
			}

		} catch (Exception e) {
			System.out.println("Exception Print !");
			System.out.println(e.getMessage());
		}

	}
		
		public  void testqueryMencariPajakAcc() {
			MdPajakAccController pa = new MdPajakAccController();
			
			try {
				System.out.print("Masukan tgl_srt : ");
				String inputKode=keyboard.nextLine();
				JSONArray data = pa.getMencariPajakAcc(inputKode);
				showData_PajakAcc(data,"kdcabang","kdssbp");
			} catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
				 
			}
		}
		public MainMdPajakAcc(){
			testqueryMencariPajakAcc();
		}
		
		public  void testqueryMenambahPajakAcc(){
			MdPajakAccController pa =new MdPajakAccController();
			String kdcabang,kdssbp,tgl_srt,no_srt;
			
			try{
				System.out.print("Masukan kdcabang : ");
				kdcabang=dataIn.readLine();
				System.out.print("Masukan kdssbp : ");
				kdssbp=dataIn.readLine();
				System.out.print("Masukan tgl_srt : ");
				tgl_srt=dataIn.readLine();
				System.out.print("Masukan no_srt : ");
				no_srt=dataIn.readLine();
				pa.getMenambahPajakAcc(kdcabang, kdssbp, tgl_srt, no_srt);
				mainMenu();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		public  void MengubahPajakAcc(){
			MdPajakAccController pa =new MdPajakAccController();
			String tgl_srt,no_srt;
			
			try{
				
				System.out.print("Masukan tgl-srt yang akan di ubah: ");
				tgl_srt=dataIn.readLine();
				System.out.print("Masukan no_srt : ");
				no_srt=dataIn.readLine();
				pa.getMengeditPajakAcc(tgl_srt, no_srt);
				mainMenu();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		public  void testMenampilkanPajakAcc(){
			MdPajakAccController pa =new MdPajakAccController();
			JSONArray data = pa.getMenampilkanTabelPajakAcc(); 
			showData_PajakAcc(data, "kdcabang", "kdssbp");
		}
		
		public  void hapusPajakAcc() throws IOException{
			MdPajakAccController pa =new MdPajakAccController();
			String kdcabang,kdssbp;

			System.out.print("Masukan kdcabang data yang ingin di hapus : ");
			kdcabang=dataIn.readLine();
			System.out.print("Masukan kdssbp data yang ingin di hapus : ");
			kdssbp=dataIn.readLine();
			pa.getMenghapusPajakAcc(kdcabang, kdssbp);
			
			mainMenu();
		}
		
//		public  void backto()  {
//			String inp;
//			MainActivity ma = new MainActivity();
//			System.out.print("1. Menu Utama 2. Submenu Mencari Agama Berdasarkan Kode  : ");
//			try {
//				inp=keyboard.next();
//				switch (inp) {
//				case "1":
//					ma.menuUtama();;
//					break;
//				case "2":
//					testqueryMencariNamaAgama();
//					break;
//				default:
//					System.out.println("Masukan Salah !");
//				}
//			}catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}
		public  void showData_PajakAcc(JSONArray arrayData, String kdcabang, String kdssbp) {
			//System.out.println(arrayData);
			System.out.println("+----------------------------------+");
			System.out.println("| KDCABANG    | KDSSBP      |");
			System.out.println("+----------------------------------+");
			String space;
			String tamp;

			for (int i = 0; i < arrayData.length(); i++) {
				JSONObject obj =  arrayData.getJSONObject(i);	

				tamp=(String) obj.get(kdcabang);
				System.out.print("| "+tamp);

				space=(String) obj.get(kdssbp);
				System.out.print("              | "+ space);
				for (int j = 0; j  < 20 - (space.length()); j++) {
					System.out.print(" ");
				}
				System.out.println("|");
				System.out.println("+----------------------------------+");
			}
			//backto();
			//add by Hendra YN
		}
		public static void main(String args[]) {
			MainMdPajakAcc mainMdPajakAcc = new MainMdPajakAcc();
			mainMdPajakAcc.mainMenu();
		}

}
