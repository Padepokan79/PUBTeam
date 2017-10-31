package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdJenisPegController;
import com.padepokan79.controller.MdJenisSkppTblController;

public class MainMdJenisSkppTbl {
	int inputInt;
	String inputStr;
	BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
//	Searching data Jenis Skpp by Jejen
	public  void MencariKodeJenisPegawaidiJenisPeg(){
		MdJenisSkppTblController skpp = new MdJenisSkppTblController();
		try {
			System.out.print("Masukan Kode Jenis : ");
			 inputInt= Integer.parseInt(dataIn.readLine());
			JSONArray data = skpp.getQueryMencariJenisSkpp(inputInt);
			showData_jenisPeg(data,"jenis","nama_skpp");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
//	Menampilkan data Jenis Skpp by Jejen	
	public  void MenampilkanSemuaJenisSkpp(){
		MdJenisSkppTblController skpp = new MdJenisSkppTblController();
			JSONArray data = skpp.getQueryMenampilkanJenisSkpp();
			showData_jenisPeg(data,"jenis","nama_skpp");
	}
//	Mengubah data Jenis Skpp by Jejen
	public  void MengubahNamaJenisSkpp(){
		MdJenisSkppTblController jenisSkpp = new MdJenisSkppTblController();
			System.out.print("Masukan Kode Jenis yang akan di ubah : ");
			try {
				inputInt = Integer.parseInt(dataIn.readLine());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			System.out.print("Masukan Nama Skpp  : ");
			try {
				inputStr = dataIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			jenisSkpp.getQueryMengubahNamaJenisSkpp(inputInt, inputStr);
			System.out.println("UPDATE SUCCESS !!");
	}	

//	Menghapus data Jenis Skpp by Jejen
	public  void MenghapusJenisSkpp(){
		MdJenisSkppTblController jenisSkpp = new MdJenisSkppTblController();
			System.out.print("Masukan Kode Jenis yang akan di hapus : ");
			try {
				inputInt = Integer.parseInt(dataIn.readLine());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			jenisSkpp.getQueryMenghapusJenisSkpp(inputInt);
			System.out.println("DELETE SUCCESS !!");
	}
//	Menambah data Jenis Skpp by Jejen
	public  void MenambahJenisSkpp(){
		MdJenisSkppTblController jenisSkpp = new MdJenisSkppTblController();
			System.out.print("Masukan Kode Jenis  baru : ");
			try {
				inputInt = Integer.parseInt(dataIn.readLine());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			System.out.print("Masukan Nama SKPP baru : ");
			try {
				inputStr = dataIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			jenisSkpp.getQueryMenambahJenisSkpp(inputInt, inputStr);
			System.out.println("DATA BARU SUCCESS DI TAMBAHKAN !!");
	}	
	public  void backto()  {
		String inp;
		System.out.println("\n====================================================");
		System.out.println("==              CRUD TABEL jenisskpp_tbl          ==");
		System.out.println("====================================================");
		System.out.println("1. Menampilkan data Jenis Skpp ");
		System.out.println("2. Mencari data Jenis Skpp ");
		System.out.println("3. Menambahkan data Jenis Skpp ");
		System.out.println("4. Mengubah data Jenis Skpp ");
		System.out.println("5. Menghapus data Jenis Skpp ");
		try {
			System.out.print("Input Pilihan : ");
			inp=dataIn.readLine();
			System.out.println("====================================================\n");
			switch (inp) {
			case "1":
				MenampilkanSemuaJenisSkpp();
				break;
			case "2":
				MencariKodeJenisPegawaidiJenisPeg();
				break;
			case "3":
				MenambahJenisSkpp();
				break;
			case "4":
				MengubahNamaJenisSkpp();
				break;
			case "5":
				MenghapusJenisSkpp();
				break;
			default:
				System.out.println("Masukan Salah !");
			}
			backto();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public  void showData_jenisPeg(JSONArray arrayData, String kdjns, String nmjns) {
		//System.out.println(arrayData);
		System.out.println("+-------------------------------------------+");
		System.out.println("|      Jenis     |        Nama SKPP         |");
		System.out.println("+-------------------------------------------+");
		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			tamp=(int) obj.get(kdjns);
			System.out.print("| "+tamp);

			space=(String) obj.get(nmjns);
			System.out.print("              | "+ space);
			for (int j = 0; j  < 25 - (space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+-------------------------------------------+");
		}
		backto();
	}

	public static void main(String[] args) {
		MainMdJenisSkppTbl newMenu = new MainMdJenisSkppTbl();
		newMenu.backto();
	}
}
