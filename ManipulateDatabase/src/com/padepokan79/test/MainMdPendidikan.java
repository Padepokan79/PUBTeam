package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdJuruBayarController;
import com.padepokan79.controller.MdPendidikanTblController;

public class MainMdPendidikan {
	public  Scanner keyboard = new Scanner( System.in );
	
	public MainMdPendidikan(){
		//testqueryTampilDataJuruBayar();
	}
	
	public void menu(){
		System.out.println(" ---------------------------");
		System.out.println("|            MENU           |");
		System.out.println(" ---------------------------");
		System.out.println("| 1. Tampil Data Pendidikan |");
		System.out.println("| 2. Cari Data Pendidikan   |");
		System.out.println("| 3. Tambah Data Pendidikan |");
		System.out.println("| 4. Ubah Data Pendidikan   |");
		System.out.println("| 5. Hapus Data Pendidikan  |");
		System.out.println(" ---------------------------");
		System.out.print("Pilih Menu : ");
		int pilih=keyboard.nextInt();
		switch (pilih) {
		case 1:
			testqueryTampilDataPendidikan();
			menu();
			break;
		case 2:
			testquerySearchDataPendidikan();
			menu();
			break;
		case 3:
			testqueryInsertDataPendidikan();
			menu();
			break;
		case 4:
			testqueryUpdateDataPendidikan();
			menu();
			break;
		case 5:
			testqueryDeleteDataPendidikan();
			menu();
			break;
		default:
			System.out.println("Masukan Salah !");
			menu();
		}
	}
	
	public  void testqueryTampilDataPendidikan() {
		MdPendidikanTblController pen = new MdPendidikanTblController();
		
		try {
			JSONArray data = pen.getQueryTampilDataPendidikan();
			showData_Pendidikan(data,"jnsdidik","kddidik","pendidikan");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testquerySearchDataPendidikan() {
		MdPendidikanTblController pen = new MdPendidikanTblController();
		
		try {
			System.out.print("Masukan Jenis Didik yang di cari : ");
			int inputKodejns=keyboard.nextInt();
			System.out.print("Masukan kode Didik yang di cari : ");
			int inputkd=keyboard.nextInt();
			JSONArray data = pen.getQuerySearchPendidikan(inputKodejns, inputkd);
			showData_Pendidikan(data,"jnsdidik","kddidik","pendidikan");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryInsertDataPendidikan() {
		MdPendidikanTblController pen = new MdPendidikanTblController();
		
		try {
			System.out.print("Masukan Jenis Didik : ");
			int inputKodejns=keyboard.nextInt();
			System.out.print("Masukan kode Didik : ");
			int inputkd=keyboard.nextInt();
			System.out.print("Masukan Pendidikan : ");
			String inputNama=keyboard.next();
			JSONArray data = pen.getQueryInsertPendidikan(inputKodejns, inputkd, inputNama);
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryUpdateDataPendidikan() {
		MdPendidikanTblController pen = new MdPendidikanTblController();
		
		try {
			System.out.print("Masukan Jenis Didik yang akan di ubah : ");
			int inputKodejns=keyboard.nextInt();
			System.out.print("Masukan kode Didik yang akan di ubah: ");
			int inputkd=keyboard.nextInt();
			System.out.print("Masukan Pendidikan baru: ");
			String inputNama=keyboard.next();
			JSONArray data = pen.getQueryUpdatePendidikan(inputKodejns, inputkd, inputNama);
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryDeleteDataPendidikan() {
		MdPendidikanTblController pen = new MdPendidikanTblController();
		
		try {
			System.out.print("Masukan Jenis Didik yang akan di hapus : ");
			int inputKodejns=keyboard.nextInt();
			System.out.print("Masukan Pendidikan yang akan di hapus : ");
			String inputNama=keyboard.next();
			JSONArray data = pen.getQueryDeletePendidikan(inputKodejns, inputNama);
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void showData_Pendidikan(JSONArray arrayData, String jnsdidik, String kddidik, String pen) {
		//System.out.println(arrayData);
		System.out.println("+-----------------------------------------------+");
		System.out.println("| Jenis Didik  | Kode Didik   | Pendidikan      |");
		System.out.println("+-----------------------------------------------+");
		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			tamp=(int) obj.get(jnsdidik);
			System.out.print("| "+tamp);

			tamp=(int) obj.get(kddidik);
			System.out.print("            | "+ tamp);
			
			space=(String) obj.get(pen);
			System.out.print("            | "+ space);
			for (int k = 0; k  < 16 - (space.length()); k++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+-----------------------------------------------+");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainMdPendidikan mp= new MainMdPendidikan();
		//mp.testqueryTampilDataPendidikan();
		//mp.testquerySearchDataPendidikan();
		//mp.testqueryInsertDataPendidikan();
		//mp.testqueryUpdateDataPendidikan();
		//mp.testquerySearchDataPendidikan();
		//mp.testqueryDeleteDataPendidikan();
		mp.menu();
	}

}
