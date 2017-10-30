package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;


import com.padepokan79.controller.Ttunjangan;


public class MainTunjangan {
	public  Scanner sf=new Scanner(System.in); 
	MainActivity ma=new MainActivity();
	
	String quiz;
	
	public MainTunjangan() {
		mainMenu();
	}
	
	public  void mainMenu () {//Modify by Ipin

		System.out.println("+---------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                 Submenu Tunjangan                                                               |");
		System.out.println("|---------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("| 1. PNS yang Pensiun | 2. PNS yang Pensiun berdasarkan jumlah uang pensiun | 3. PNS yang Pensiun dibawah 60 tahun| 0. Menu utama |");
		System.out.println("|---------------------------------------------------------------------------------------------------------------------------------|");
		

		try {
			System.out.print("Masukan PIlihan : ");
			String input=sf.next();
			switch (input) {
			case "1":
				testMenampilkanJumlahPNSYangPensiunBerdasarkanKodeJabatandanUsiaJabatan();
				break;
			case "2":
				testMenampilkanJumlahPNSYangPensiunBerdasarkanJumlahUangPensiun();
				break;
			case "3": 
				testMenampilkanPNSyangPensiunKurangdariUsia60();
				break;
			
			case "0":
				ma.menuUtama();
				break;
			default:
				System.out.println("Masukan anda tidak valid !");
			}

		} catch (Exception e) {
			System.out.println("Exception Print !");
			System.out.println(e.getMessage());
		}

	}

	public  void backto()  {
		String inp;
		System.out.print("1. Menu Utama 2. Submenu Satuan Kerja  : ");
		try {
			inp=sf.next();
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
	public  void testMenampilkanJumlahPNSYangPensiunBerdasarkanKodeJabatandanUsiaJabatan(){
		int nextPage=0;
		Ttunjangan objTj =new Ttunjangan();
		JSONArray data = objTj.getMenampilkanJumlahPNSYangPensiunBerdasarkanKodeJabatandanUsiaJabatan(nextPage); 
		showData_jml_pns(data,"kode_jabatan","usia_pensiun","jumlah",nextPage);
	} // Yusup  added test for NamaPnsYangPensiunTahunIni

	public  void showData_jml_pns(JSONArray arrayData, String Fkd, String usiap, String jml,int nextPage) {
		//System.out.println(arrayData);
		System.out.println("+-------------------------------------------+");
		System.out.println("| Kode Jabatan | Usia Pensiun | Jumlah PNS  |");
		System.out.println("+-------------------------------------------+");
		String space;
		long tam;
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(Fkd);
			System.out.print("|      "+space);
			for (int j = 0; j  <6-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("  |      "+obj.get(usiap));
			for (int j = 0; j  <6-(space.length()); j++) {
				System.out.print(" ");
			}
			tam = (long)  obj.get(jml);
			space =space.valueOf(tam);
			System.out.print("  |     "+ tam);
			for (int j = 0; j  <2-(space.length()); j++) {
				System.out.print(" ");
			}
	
			System.out.println("      |");
			System.out.println("+-------------------------------------------+");
		}
		System.out.println("N lanjut M Menu : ");
		quiz=sf.next();
		if(quiz.equalsIgnoreCase("N")) {
			nextPage+=10;
			Ttunjangan objTj =new Ttunjangan();
			JSONArray data = objTj.getMenampilkanJumlahPNSYangPensiunBerdasarkanKodeJabatandanUsiaJabatan(nextPage); 
			showData_jml_pns(data,"kode_jabatan","usia_pensiun","jumlah",nextPage);
		}else {
			backto();
		}
	}//Yusup Add ShowData Hehe...

	public  void testMenampilkanJumlahPNSYangPensiunBerdasarkanJumlahUangPensiun(){
		Ttunjangan ftj=new Ttunjangan();
		int nextPage=0;
		try {
			System.out.print("Masukan Jumlah Tunjangan dari : ");
			int inputJumlahAwal=sf.nextInt();
			System.out.print("Masukan Jumlah Tunjangan sampai : ");
			int inputJumlahAkhir=sf.nextInt();
			
			JSONArray data = ftj.getqueryMenampilkanJumlahPNSYangPensiunBerdasarkanJumlahUangPensiun(inputJumlahAwal, inputJumlahAkhir,nextPage);
			showData_jml(data,"jumlah","jumlah_pns",inputJumlahAwal, inputJumlahAkhir,nextPage);
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	} // Yusup  added test for TGLWafatDanUangBersihLebihDari1Jt

	public  void showData_jml(JSONArray arrayData, String jml_t, String jml_pns,int inputJumlahAwal,int inputJumlahAkhir,int nextPage) {
		//System.out.println(arrayData);
		System.out.println("+-------------------------------------+");
		System.out.println("| Jumlah Tunjangan Pensiun |Jumlah PNS|");
		System.out.println("+-------------------------------------+");
		String space = null;
		long tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);
			
			tamp = (long)  obj.get(jml_t);
			space =space.valueOf(tamp);
			System.out.print("|        "+ tamp);
			for (int j = 0; j  <8-(space.length()); j++) {
				System.out.print(" ");
			}
			
			tamp = (long)  obj.get(jml_pns);
			space =space.valueOf(tamp);
			System.out.print("          |     "+ tamp);
			for (int j = 0; j  <5-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("     |");
			System.out.println("+---------------------------------------+");
		}
		System.out.println("N lanjut M Menu : ");
		quiz=sf.next();
		if(quiz.equalsIgnoreCase("N")) {
			nextPage+=10;
			Ttunjangan objTj =new Ttunjangan();
			JSONArray data = objTj.getqueryMenampilkanJumlahPNSYangPensiunBerdasarkanJumlahUangPensiun(inputJumlahAwal, inputJumlahAkhir,nextPage);
			showData_jml(data,"jumlah","jumlah_pns",inputJumlahAwal, inputJumlahAkhir,nextPage);
		}else {
			backto();
		}
		
	}//Yusup Add ShowData Hehe...
	
	public  void testMenampilkanPNSyangPensiunKurangdariUsia60(){
		Ttunjangan objTj =new Ttunjangan();
		JSONArray data = objTj.getqueryMenampilkanPNSyangPensiunKurangdariUsia60(); 

		showData_tblTT(data,"kdkel","kdjab","nmjabatan","jml","pensiun");
	} // Yusup  added test for NamaPnsYangPensiunTahunIni

	public  void showData_tblTT(JSONArray arrayData, String Fkd,String kdjb,String nmjb, String jml, String pen) {
		//System.out.println(arrayData);
		System.out.println("+------------------------------------------------------------------------------------------------------------------+");
		System.out.println("| Kode Keluarga| Kode Jabatan |                       Nama Jabatan                       |    Jumlah   |  Pensiun  |");
		System.out.println("+------------------------------------------------------------------------------------------------------------------+");
		String space;
		long tam;
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(Fkd);
			System.out.print("|    "+space);
			for (int j = 0; j  <10-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(kdjb);
			System.out.print("|      "+space);
			for (int j = 0; j  <6-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(nmjb);
			System.out.print("  | "+ obj.get(nmjb));
			for (int j = 0; j  <56-(space.length()); j++) {
				System.out.print(" ");
			}
			
			tam = (long)  obj.get(jml);
			space =space.valueOf(tam);
			System.out.print(" |   "+ tam);
			for (int j = 0; j  <8-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("  |    "+ obj.get(pen));
			for (int j = 0; j  <5-(space.length()); j++) {
				System.out.print(" ");
			}
	
			System.out.println("     |");
			System.out.println("+------------------------------------------------------------------------------------------------------------------+");
		}
	}//Yusup Add ShowData Hehe...
}
