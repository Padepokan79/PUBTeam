package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdJuruBayarController;


public class MainMdJuruBayar {
	public  Scanner keyboard = new Scanner( System.in );
	
	public MainMdJuruBayar(){
		//testqueryTampilDataJuruBayar();
	}
	
	public void menu(){
		System.out.println(" ---------------------------");
		System.out.println("|            MENU           |");
		System.out.println(" ---------------------------");
		System.out.println("| 1. Tampil Data Juru Bayar |");
		System.out.println("| 2. Cari Juru Bayar        |");
		System.out.println("| 3. Tambah Data Juru Bayar |");
		System.out.println("| 4. Ubah Data Juru Bayar   |");
		System.out.println("| 5. Hapus Data Juru Bayar  |");
		System.out.println(" ---------------------------");
		System.out.print("Pilih Menu : ");
		int pilih=keyboard.nextInt();
		switch (pilih) {
		case 1:
			testqueryTampilDataJuruBayar();
			menu();
			break;
		case 2:
			testqueryMencariNamaJuruBayar();
			menu();
			break;
		case 3:
			testqueryInsertJuruBayar();
			menu();
			break;
		case 4:
			testqueryUpdateJuruBayar();
			menu();
			break;
		case 5:
			testqueryDeleteJuruBayar();
			menu();
			break;
		default:
			System.out.println("Masukan Salah !");
			menu();
		}
	}
	public  void testqueryTampilDataJuruBayar() {
		MdJuruBayarController jb = new MdJuruBayarController();
		
		try {
			JSONArray data = jb.getQueryTampilDataJuruBayar();
			showData_juruBayar(data,"kodebyr","nmbayar");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryMencariNamaJuruBayar() {
		MdJuruBayarController jb = new MdJuruBayarController();
		
		try {
			System.out.print("Masukan Kode Bayar : ");
			String inputKode=keyboard.next();
			JSONArray data = jb.getQueryMencariNamaBayar(inputKode);
			showData_juruBayar(data,"kodebyr","nmbayar");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryInsertJuruBayar() {
		MdJuruBayarController jb = new MdJuruBayarController();
		
		try {
			System.out.print("Masukan Kode Bayar : ");
			String inputKode=keyboard.next();
			System.out.print("Masukan Nama Bayar : ");
			String inputNama=keyboard.next();
			JSONArray data = jb.getQueryInsertJuruBaya(inputKode, inputNama);
			//showData_juruBayar(data,"kodebyr","nmbayar");
			//testqueryTampilDataJuruBayar();
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryUpdateJuruBayar() {
		MdJuruBayarController jb = new MdJuruBayarController();
		
		try {
			System.out.print("Masukan Kode Bayar yang akan di update: ");
			String inputKode=keyboard.next();
			System.out.print("Masukan Nama Bayar Baru: ");
			String inputNama=keyboard.next();
			JSONArray data = jb.getQueryUpdateJuruBaya(inputKode, inputNama);
			//showData_juruBayar(data,"kodebyr","nmbayar");
			//testqueryTampilDataJuruBayar();
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryDeleteJuruBayar() {
		MdJuruBayarController jb = new MdJuruBayarController();
		
		try {
			System.out.print("Masukan Kode Bayar yang akan di hapus: ");
			String inputKode=keyboard.next();
			JSONArray data = jb.getQueryDeleteJuruBayar(inputKode);
			//showData_juruBayar(data,"kodebyr","nmbayar");
			//testqueryTampilDataJuruBayar();
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void backto()  {
		String inp;
		MainActivity ma = new MainActivity();
		System.out.print("1. Menu Utama 2. Submenu Menampilkan Data Juru Bayar 3. Submenu Mencari Nama Juru Bayar berdasarkan kode bayar  : ");
		try {
			inp=keyboard.next();
			switch (inp) {
			case "1":
				ma.menuUtama();;
				break;
			case "2":
				testqueryTampilDataJuruBayar();
				break;
			case "3":
				testqueryMencariNamaJuruBayar();
				break;
			default:
				System.out.println("Masukan Salah !");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public  void showData_juruBayar(JSONArray arrayData, String kdbayar, String nmbayar) {
		//System.out.println(arrayData);
		System.out.println("+----------------------------------+");
		System.out.println("| Kode Bayar     | Nama Bayar      |");
		System.out.println("+----------------------------------+");
		String space;
		String tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			tamp=(String) obj.get(kdbayar);
			System.out.print("| "+tamp);

			space=(String) obj.get(nmbayar);
			System.out.print("            | "+ space);
			for (int j = 0; j  < 16 - (space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+----------------------------------+");
		}
		//backto();
	//add by Hendra YN
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainMdJuruBayar mainJB = new MainMdJuruBayar();
		//mainJB.testqueryTampilDataJuruBayar();
		//mainJB.testqueryMencariNamaJuruBayar();
		//mainJB.testqueryInsertJuruBayar();
		//mainJB.testqueryTampilDataJuruBayar();
//		mainJB.testqueryUpdateJuruBayar();
//		mainJB.testqueryTampilDataJuruBayar();
//		mainJB.testqueryUpdateJuruBayar();
//		mainJB.testqueryTampilDataJuruBayar();
//		mainJB.testqueryDeleteJuruBayar();
//		mainJB.testqueryTampilDataJuruBayar();
		mainJB.menu();
	}

}
