package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.DataRapel;

public class MainDataRapel {
	 MainActivity ma=new MainActivity();
	public  Scanner bf=new Scanner( System.in );
	
	public MainDataRapel() {
		mainMenu();
	}
	
	public  void mainMenu () {//Modify by Manto
		
		System.out.println("+-------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                             Submenu Data Rapel                                                    |");
		System.out.println("|-------------------------------------------------------------------------------------------------------------------|");
		System.out.println("| 1. Jumlah PNS Sesuai Gaji Pokok           | 2. Jumlah PNS Sesuai Satuan Kerja   | 3. Pembayaran Rapel Sesuai Date |");
		System.out.println("|-------------------------------------------------------------------------------------------------------------------|");
		System.out.println("| 4. Mencari PNS Huruf depan & Kode Pangkat | 5. Data PNS Tidak Ada Jenis Kelamin | 0. Menu Utama                   |");
		System.out.println("+-------------------------------------------------------------------------------------------------------------------+");
		
		try {
			System.out.print("Masukan PIlihan : ");
			String input=bf.next();
			switch (input) {
			case "1":
				testQueryGroupByGapokPNS();	
				break;
			case "2":
				testQueryGroupKodeSatuanKerjaNamaSatuanKerjaDanJumlahPNSNya();
			case "3":
				testQueryMenampilkanDataYangDibayarkanSatuBulanSetelahDataAwal();
				break;
			case "4":
				TestQueryMenampilkanDataNamaYangHurufAwalADanPangkat3D();
				break;
			case "5":
				testQueryMenampilkanPNSyangJenisKElaminNULLdanBukanPriadaWanita();
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
			inp=bf.next();
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
	
	public  void testQueryGroupByGapokPNS(){
		DataRapel objDataRapel=new DataRapel();
		try {
			System.out.print("Masukan Gaji Pokok Lebih Dari : ");
			int gapok=bf.nextInt();
			JSONArray data = objDataRapel.getQueryGroupByGapokPNS(gapok); 
			showData(data,"gapok","jumlah_pns");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	
	public  void testQueryGroupKodeSatuanKerjaNamaSatuanKerjaDanJumlahPNSNya(){
		DataRapel objDataRapel=new DataRapel();
		try {
			JSONArray data = objDataRapel.getQueryGroupKodeSatuanKerjaNamaSatuanKerjaDanJumlahPNSNya(); 
			showData(data,"kode_satuan_kerja","nama_satuan_kerja","jumlah_pns");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	
	public  void testQueryMenampilkanDataYangDibayarkanSatuBulanSetelahDataAwal(){
		DataRapel objDataRapel=new DataRapel();
		try {
			System.out.print("Masukan Tanggal Awal (format YYYY-MM-DD) : ");
			String tglAwal=bf.next();
			System.out.print("Masukan Tanggal Akhir (format YYYY-MM-DD) : ");
			String tglAkhir=bf.next();
			JSONArray data = objDataRapel.getQueryMenampilkanDataYangDibayarkanSatuBulanSetelahDataAwal(tglAwal, tglAkhir, 0); 
			showData(data,"nip","nama","awal","akhir");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	
	public  void TestQueryMenampilkanDataNamaYangHurufAwalADanPangkat3D(){
		DataRapel objDataRapel=new DataRapel();
		try {
			System.out.print("Masukan Huruf Nama PNS : ");
			String hurufAwal=bf.next()+"%";
			System.out.print("Masukan Kode Pangkat (2D, 3D, Etc.) : ");
			String kodePangkat=bf.next();
			JSONArray data = objDataRapel.getQueryMenampilkanDataNamaYangHurufAwalADanPangkat3D(hurufAwal, kodePangkat, 0); 
			showData2(data,"nip","nama","kdpangkat");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	
	public  void testQueryMenampilkanPNSyangJenisKElaminNULLdanBukanPriadaWanita(){
		DataRapel objDataRapel=new DataRapel();
		try {
			JSONArray data = objDataRapel.getQueryMenampilkanPNSyangJenisKElaminNULLdanBukanPriadaWanita(); 
			showData2(data,"kode_satuan_kerja","nip","nama","tanggal_lahir");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	
	public  void showData(JSONArray arrayData,String fielda, String fieldb) {
		System.out.println("+-------------------------------+");
		System.out.println("|  GAJI POKOK   | JUMLAH PNS    |");
		System.out.println("+-------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			
			System.out.print("|  "+obj.get(fielda));
			space=String.valueOf(obj.get(fieldb));
			
			space = space.trim();
			System.out.print("\t| "+space);	
			System.out.println("\t\t|");
			System.out.println("+-------------------------------+");
		}
		backto();
	}
	
	public  void showData(JSONArray arrayData,String fielda, String fieldb, String fieldc) {
		System.out.println("+----------------------------------------------------------------------------------------+");
		System.out.println("|  KODE SATUAN KERJA    |     NAMA SATUAN KERJA                             | JUMLAH PNS |");
		System.out.println("+----------------------------------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			//System.out.print("| ");
			space=(String) obj.get(fielda);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <15-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldb);
			space = space.trim();
			System.out.print("\t| "+space);
			for (int j = 0; j  <50-(space.length()); j++) {
				System.out.print(" ");
			}

			System.out.print("| "+obj.get(fieldc));
			space=String.valueOf(obj.get(fieldc)) ;
			space = space.trim();
			for (int j = 0; j  <10-(space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.println(" |");
			System.out.println("+----------------------------------------------------------------------------------------+");
		}
		backto();
	}
	
	public  void showData(JSONArray arrayData,String fielda, String fieldb, String fieldc, String fieldd) {
		System.out.println("+----------------------------------------------------------------------+");
		System.out.println("| NIP       |           NAMA PNS             | DATE AWAL  | DATE AKHIR |");
		System.out.println("+----------------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			space=(String) obj.get(fielda);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <10-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldb);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <30-(space.length()); j++) {
				System.out.print(" ");
			}

			System.out.print(" | "+obj.get(fieldc));
			space=String.valueOf(obj.get(fieldc)) ;
			space = space.trim();
			for (int j = 0; j  <10-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print(" | "+obj.get(fieldd));
			
			System.out.println(" |");
		System.out.println("+----------------------------------------------------------------------+");
		}
		backto();
	}
	
	public  void showData2(JSONArray arrayData,String fielda, String fieldb, String fieldc) {
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println("|          NIP          |         NAMA PNS         | KODE PANGKAT |");
		System.out.println("+-----------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
//			System.out.print("| ");
			space=(String) obj.get(fielda);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <15-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldb);
			space = space.trim();
			System.out.print("\t| "+space);
			for (int j = 0; j  <25-(space.length()); j++) {
				System.out.print(" ");
			}

			System.out.print("| "+obj.get(fieldc));
			space=String.valueOf(obj.get(fieldc)) ;
			space = space.trim();
			for (int j = 0; j  <12-(space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.println(" |");
			System.out.println("+-----------------------------------------------------------------+");
		}
		backto();
	}
	
	public  void showData2(JSONArray arrayData,String fielda, String fieldb, String fieldc, String fieldd) {
		System.out.println("+------------------------------------------------------------------------------------+");
		System.out.println("| KODE SATUAN KERJA |         NIP          |        NAMA PNS         | TANGGAL LAHIR |");
		System.out.println("+------------------------------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			space=(String) obj.get(fielda);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <18-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldb);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <20-(space.length()); j++) {
				System.out.print(" ");
			}

			System.out.print(" | "+obj.get(fieldc));
			space=String.valueOf(obj.get(fieldc)) ;
			space = space.trim();
			for (int j = 0; j  <23-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print(" | "+obj.get(fieldd));
			
			System.out.println("    |");
		System.out.println("+------------------------------------------------------------------------------------+");
		}
		backto();
	}
	
	public static void main(String args[]) {
		MainDataRapel mk=new MainDataRapel();
		mk.mainMenu();
	}

}
