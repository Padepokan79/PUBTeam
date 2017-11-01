package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdJenisPegController;

public class MainMdJenisPeg {
	int inputInt;
	String inputStr;
	BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
	
//	Searching data Jenis Pegawai by Jejen
	public  void MencariKodeJenisPegawaidiJenisPeg(){
		MdJenisPegController jenisPeg = new MdJenisPegController();
		try {
			System.out.print("Masukan Kode Jenis Pegawai: ");
			 inputInt= Integer.parseInt(dataIn.readLine());
			JSONArray data = jenisPeg.getQueryMencariKodeJenisPegawaidiJenisPeg(inputInt);
			showData_jenisPeg(data,"kd_jns","nm_jns");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	
//	Menampilkan data Jenis Pegawai by Jejen	
	public  void MenampilkanSemuaJenisPegawai(){
		MdJenisPegController jenisPeg = new MdJenisPegController();
			JSONArray data = jenisPeg.getQueryMenampilkanKodeJenisPegawaidiJenisPeg();
			showData_jenisPeg(data,"kd_jns","nm_jns");
	}

//	Mengubah data Jenis Pegawai by Jejen
	public  void MengubahNamaJenisPegawaidiJenisPeg(){
		MdJenisPegController jenisPeg = new MdJenisPegController();
			System.out.print("Masukan Kode Jenis Pegawai yang akan di ubah : ");
			try {
				inputInt = Integer.parseInt(dataIn.readLine());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			System.out.print("Masukan Nama Jenis Pegawai : ");
			try {
				inputStr = dataIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			jenisPeg.getQueryMengubahNamaJenisPegawaidiJenisPeg(inputInt, inputStr);
			System.out.println("UPDATE SUCCESS !!");
	}	

//	Menghapus data Jenis Pegawai by Jejen
	public  void MenghapusJenisPegawaidiJenisPeg(){
		MdJenisPegController jenisPeg = new MdJenisPegController();
			System.out.print("Masukan Kode Jenis Pegawai yang akan di hapus : ");
			try {
				inputInt = Integer.parseInt(dataIn.readLine());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			jenisPeg.getQueryMenghapusJenisPegawaidiJenisPeg(inputInt);
			System.out.println("DELETE SUCCESS !!");
	}
	
//	Menambah data Jenis Pegawai by Jejen
	public  void MenambahJenisPegawaidiJenisPeg(){
		MdJenisPegController jenisPeg = new MdJenisPegController();
			System.out.print("Masukan Kode Jenis Pegawai baru : ");
			try {
				inputInt = Integer.parseInt(dataIn.readLine());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			System.out.print("Masukan Nama Jenis Pegawai baru : ");
			try {
				inputStr = dataIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			jenisPeg.getQueryMenambahJenisPegawaidiJenisPeg(inputInt, inputStr);
			System.out.println("DATA BARU SUCCESS DI TAMBAHKAN !!");
	}	
	
	public  void backto()  {
		String inp;
		System.out.println("\n====================================================");
		System.out.println("==              CRUD TABEL jenis_peg              ==");
		System.out.println("====================================================");
		System.out.println("1. Menampilkan data Jenis Pegawai ");
		System.out.println("2. Mencari data Jenis Pegawai ");
		System.out.println("3. Menambahkan data Jenis Pegawai ");
		System.out.println("4. Mengubah data Jenis Pegawai ");
		System.out.println("5. Menghapus data Jenis Pegawai ");
		try {
			System.out.print("Input Pilihan : ");
			inp=dataIn.readLine();
			System.out.println("====================================================\n");
			switch (inp) {
			case "1":
				MenampilkanSemuaJenisPegawai();
				break;
			case "2":
				MencariKodeJenisPegawaidiJenisPeg();
				break;
			case "3":
				MenambahJenisPegawaidiJenisPeg();
				break;
			case "4":
				MengubahNamaJenisPegawaidiJenisPeg();
				break;
			case "5":
				MenghapusJenisPegawaidiJenisPeg();
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
		System.out.println("| Kode Jenis     |  Nama Jenis Pegawai      |");
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
		MainMdJenisPeg newMenu = new MainMdJenisPeg();
		newMenu.backto();
	}
}
