package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdAgamaController;
import com.padepokan79.controller.MdTtab2Controller;

public class MainMdTtab2 {
public  Scanner keyboard = new Scanner( System.in );

////////////////////////MENAMPILKAN//////////////////////////////////////////////////////////////

	
	public  void testqueryMenampilkanTtab2() {
		MdTtab2Controller ag = new MdTtab2Controller();
		
		try {
//			System.out.print("Masukan Kode Agama : ");
//			int inputKode=keyboard.nextInt();
			JSONArray data = ag.getMenampilkanTtab2();
			showData_ttab2(data,"kode","jenjab","agama");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan angka 1 sampai 6");
			System.out.println(e.getMessage());
			 
		}
		mainMenu();
	}
	///////////////////////////////////////MENCARI///////////////////////////////////////////////
	public  void testqueryMencariDataBerdasarkanKODE() {
		MdTtab2Controller ag = new MdTtab2Controller();
		
		try {
			System.out.print("Masukan Kode : ");
			int inputKode=keyboard.nextInt();
			JSONArray data = ag.getMencariDataBerdasarkanKODE(inputKode);
			showData_ttab2(data,"kode","jenjab","agama");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan angka 1 sampai 6");
			System.out.println(e.getMessage());
			 
		}
		mainMenu();
	}
	
///////////////////////////////////////MENAMBAH/////////////////////////////////////////////////////////
	public  void testqueryMenambahkanTtab2() {
		MdTtab2Controller ag = new MdTtab2Controller();
		
		try {
			System.out.print("Masukan Kode : ");
			int inputKode=keyboard.nextInt();
			System.out.print("Masukan Nama Jenis Jabatan : ");
			String jenjab=keyboard.next();
			System.out.print("Masukan Nama Agama : ");
			String agama=keyboard.next();
			JSONArray data = ag.getMenambahkanTtab2(inputKode, jenjab,agama);
			//showData_ttab2(data,"inputKode", "jenjab","agama");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan angka untuk Kode");
			System.out.println(e.getMessage());
		}
		mainMenu();
	}
	///////////////////////////////////////MENGUBAH///////////////////////////////////////////////////
	public  void testqueryMengubahAgamaBerdasarkanKODE() {
		MdTtab2Controller ag = new MdTtab2Controller();
		
		try {
			System.out.print("Masukan Agama yang akan dirubah : ");
			String namaAgama=keyboard.next();
			System.out.print("Masukan Kode Agama yang akan di edit : ");
			int inputKode=keyboard.nextInt();
			
			JSONArray data = ag.getMengubahAgamaBerdasarkanKODE(namaAgama, inputKode);
			//showData_ttab2(data,"kode","agama");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan angka untuk KodeAgama");
			System.out.println(e.getMessage());
		}
		mainMenu();
}
	/////////////////////////////////////MENGHAPUS///////////////////////////////////////////////////
	public  void testqueryHapusTtab2BerdasarkanKODE() {
		MdTtab2Controller ag = new MdTtab2Controller();
		
		try {
			System.out.print("Masukan Kode data yang akan di hapus : ");
			int inputKode=keyboard.nextInt();
			JSONArray data = ag.getHapusTtab2BerdasarkanKODE(inputKode);
//			showData_agama(data,"kdagama","nmagama");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan angka");
			System.out.println(e.getMessage());
			 
		}
		mainMenu();
	}
	//////////////////////////////////////////MENU///////////////////////////////////////////////
	public  void mainMenu()  {
		String inp;
		
		System.out.println("1. Menampilkan Tabel T_Tab2");
		System.out.println("2. Mencari Data Berdasarkan KODE");
		System.out.println("3. Menambahkan T_Tab2 Baru");
		System.out.println("4. Mengubah Agama Berdasarkan KODE");
		System.out.println("5. Menghapus T_Tab2 Berdasarkan KODE");
		System.out.println("=======================================");
		System.out.print("Masukan Menu : ");
		try {
			inp=keyboard.next();
			switch (inp) {
			case "1":
				testqueryMenampilkanTtab2();
				break;
			case "2":
				testqueryMencariDataBerdasarkanKODE();
				break;
			case "3":
				testqueryMenambahkanTtab2();
				break;
			case "4":
				testqueryMengubahAgamaBerdasarkanKODE();
			case "5":
				testqueryHapusTtab2BerdasarkanKODE();
			default:
				System.out.println("Masukan Salah !");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//==================================================================
	public  void showData_ttab2(JSONArray arrayData, String kode, String jenjab,String agama) {
		//System.out.println(arrayData);
		System.out.println("+----------------------------------------------------+");
		System.out.println("| KODE      | JENJAB              | AGAMA            |");
		System.out.println("+----------------------------------------------------+");
		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			tamp=(int) obj.get(kode);
			System.out.print("| "+tamp);

			space=(String) obj.get(jenjab);
			System.out.print("         | "+ space);
			for (int j = 0; j  < 16 - (space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(agama);
			System.out.print("    | "+ space);
			for (int j = 0; j  < 16 - (space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.println(" |");
			System.out.println("+----------------------------------------------------+");
		}
		mainMenu();
		//add by Hendra YN
	}
	public static void main(String args[]) {
		MainMdTtab2 mMtab = new MainMdTtab2();
		mMtab.mainMenu();
	}

}
