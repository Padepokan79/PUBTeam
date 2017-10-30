package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.channels.ShutdownChannelGroupException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.Automut;


public class MainAutoMut {
	public  Scanner sc = new Scanner(System.in);
	BufferedReader dataIn = new BufferedReader(new InputStreamReader( System.in) );
	MainActivity ma=new MainActivity();

	public  void mainMenu () {

		System.out.println("+------------------------------------------------------------+");
		System.out.println("|           Submenu Main Urutan Main Auto Mutasi             |");   
		System.out.println("|------------------------------------------------------------|");
		System.out.println("| 1. PNS berdasarkan Tanggal Pensiun Dan Kode Status Pegawai |");
		System.out.println("|------------------------------------------------------------|");
		System.out.println("| 2. PNS Berdasarkan Kode Status Pegawai Dan Nama Pegawai    |");
		System.out.println("+------------------------------------------------------------+");
		try {
			System.out.print("Masukan Pilihan : ");
			String input=dataIn.readLine();
			switch (input) {
			case "1":
				getMencariTanggalPensiundanKodeStapeg();
				break;
			case "2":
				getKodeStapegdanNamaStapeg();
				break;

			case "0":
				ma.menuUtama();
				break;
			default:
				System.out.println("Masukan anda tidak valid !");
			}

			backto();
		} catch (Exception e) {
			System.out.println("Exception Print !");
			System.out.println(e.getMessage());
		}

	}

	public  void backto()  {
		String inp;
		System.out.print("1. Menu Utama 2. Submenu Urutan NIP  : ");
		try {
			inp=dataIn.readLine();
			switch (inp) {
			case "1":
				ma.menuUtama();;
				break;
			case "2":
				mainMenu();
				break;
			default:
				System.out.println("Masukan Salah !");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}



	public  static void main(String[]args) {
		MainAutoMut obj =  new MainAutoMut();
		obj.mainMenu();

	}
	
	// query 1
	public  void getMencariTanggalPensiundanKodeStapeg(){
		System.out.println("Mencari Tanggal Pensiun dan Kode Status Pegawai");
		System.out.print("Masukan tanggal pensiun : ");
		String tglPensiun=sc.next();
		System.out.print("Masukan kode status Pegawai : ");
		String  kdStaPeg_l=sc.next();
		Automut automut = new Automut();
		JSONArray data = automut.getQueryMencariTanggalPensiundanKodeStapeg(tglPensiun, kdStaPeg_l);
		//System.out.println(data);
	}		
	public  void showData_automut(JSONArray arrayData, String fieldKDNIP, String fieldNama, String fieldKdStatusPegawai, String fieldTglPensiun) {
		//System.out.println(arrayData);
		System.out.println("+----------------------------------------------------------+");
		System.out.println("| NIP     | Nama     | Kode Status Pegawai | Tanggal Pensiun");
		System.out.println("+----------------------------------------------------------+");
		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			tamp=(int) obj.get(fieldKDNIP);
			System.out.print("| "+tamp);

			space=(String) obj.get(fieldNama);
			System.out.print("              | "+ space);
			for (int j = 0; j  < 16 - (space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldKdStatusPegawai);
			System.out.print("              | "+ space);
			for (int j = 0; j  < 16 - (space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldTglPensiun);
			System.out.print("              | "+ space);
			for (int j = 0; j  < 16 - (space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+----------------------------------+");
		}
		backto();
	}	

	// query 3
	public  void getKodeStapegdanNamaStapeg(){
		Automut autoMut = new Automut();
		System.out.println("Masukan masa kerja : ");
		String tglPensiun = sc.next();
		JSONArray data = autoMut.getQueryKodeStapegdanNamaStapeg(tglPensiun);
		//System.out.println(data);
		showData7Parameter(data,"nip","nama","kdstapeg_l","stapeg_tbl","tglpensiun");
	} // ikan added test for NamaDanGajiBersih
	public  void showData7Parameter(JSONArray arrayData,String fieldNIP,String fieldNama,String fieldKodeStatusPegawai,String fieldStatusPegawai, String fieldtglpensiun) {
		//System.out.println(arrayData);

		System.out.println("+------------------------------------------------------------------------------+");
		System.out.println("| NIP     | Nama     | Kode Status Pegawai | Status Pegawai |Tanggal Pensiun   |");
		System.out.println("+------------------------------------------------------------------------------+");
		String space;
		int tmp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	


			space=(String) obj.get(fieldNIP);
			System.out.print("|"+space);
			for (int j = 0; j  <18-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldNama);
			System.out.print("|"+space);
			for (int j = 0; j  <30-(space.length()); j++) {
				System.out.print(" ");
			}

			space=(String) obj.get(fieldKodeStatusPegawai);
			System.out.print("|"+space);
			for (int j = 0; j  <30-(space.length()); j++) {
				System.out.print(" ");
			}

			space=(String) obj.get(fieldStatusPegawai);
			System.out.print("|"+space);
			for (int j = 0; j  <30-(space.length()); j++) {
				System.out.print(" ");
			}

			space=(String) obj.get(fieldtglpensiun);
			System.out.print("|"+space);
			for (int j = 0; j  <30-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+----------------------------------+");
		}
	}
}	

