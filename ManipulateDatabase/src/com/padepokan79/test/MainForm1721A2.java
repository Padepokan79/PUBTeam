package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.Fgaji;
import com.padepokan79.controller.Form1721A2;

public class MainForm1721A2 {
	public static void main(String args[]) {
		MainForm1721A2 fg=new MainForm1721A2();
		fg.mainMenu();
	}
	public  Scanner bf=new Scanner( System.in );
	 MainActivity ma=new MainActivity();
	public void mainMenu () {//Modify by Ipin

		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                      Submenu Form1721A2                                                                              |");
		System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("| 1. Mencari Tahun Pajak dan Tahun Jabatan | 2.Cek PNS yang sudah atau belum bayar Pajak   | 3. Mengecek laki laki yang membayar pajak |");
		System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("| 4. menampilkan yang sudah ada NPWP       | 5. Menampilkan status berdasarkan  keluarga   | 6. Main Menu                              |");
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------+");

		try {
			System.out.print("Masukan PIlihan : ");
			String input=bf.next();
			switch (input) {
			case "1":
				testNamaDanGajiBersih();
				break;
			case "2":
				testNamaDanStatusKawin();
				break;
			case "3":
				testNamaDanLakiJomblo();
				break;
			case "4":
				NipNamaGajiBersihDiAtas10Jt();
				break;
			case "5":
				usiaAntara25Dan35();
				break;
			case "6":
				getNamaJandaKembang();
				break;
			case "7":
				namaSuperDad();
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
		System.out.print("1. Menu Utama 2. Submenu Gajih  : ");
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

	public  void testNamaDanLakiJomblo(){
		Fgaji fgaji = new Fgaji();
		JSONArray data = fgaji.getNamaDanLakiJomblo();
		showData(data,"nama","bersih");
	}

	public  void testNamaDanGajiBersih(){
		Fgaji fgaji = new Fgaji();
		JSONArray data = fgaji.getNamaDanGajiBersih();
		showData(data,"nama","bersih");
	} // ikan added test for NamaDanGajiBersih

	public  void testNamaDanStatusKawin(){
		Fgaji fgaji = new Fgaji();
		JSONArray data = fgaji.getNamaDanStatusKawin();
		showData(data,"nama","bersih");
	} // ikan added test for testNamaDanStatusKawin


	public  void usiaAntara25Dan35(){
		Fgaji fgaji = new Fgaji();
		JSONArray data = fgaji.queryUsiaAntara25Sampai35();
		showData(data,"nip","nama","bersih","kdpangkat","usia");
	}

	public  void NipNamaGajiBersihDiAtas10Jt(){
		Fgaji fgaji = new Fgaji();
		JSONArray data = fgaji.getNipNamaGajiBersihDiAtas10Jt();
		showData(data,"nip", "nama", "bersih", "kdpangkat");
	} // ikan added test for NamaDanGajiBersih

	// update janda kembang indra
	public  void getNamaJandaKembang(){
		Fgaji fgaji = new Fgaji();
		JSONArray data = fgaji.getNamaJandaKembang();
		showData4Parameter(data,"nip", "nama", "kdstawin", "janak");
	} // ikan added test for NamaDanGajiBersih

	public  void namaSuperDad(){
		Fgaji fgaji = new Fgaji();
		JSONArray data = fgaji.getNamaSuperDad();
		showData(data,"nip", "nama", "kdjenkel", "tgllhr","kdpangkat","masker","janak");
	} 

	public  void showData(JSONArray arrayData,String fieldsa, String fieldsb) {
		System.out.println("+-------------------------------------------------+");
		System.out.println("|   Nama                            |  Status     |");
		System.out.println("+-------------------------------------------------+");
		String space;
		for (int i = 0; i < arrayData.length(); i++) {//modify by Ipin
			JSONObject obj =  arrayData.getJSONObject(i);
			String status = "";
			if ((int)obj.get(fieldsb) == 1){
				status = "Kawin";
			}else{
				status = "Tidak kawin";
			}
			space=(String) obj.get(fieldsa);
			space=space.trim();
			System.out.print("|"+space);
			for (int j = 0; j <35-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("| "+status+" |");
			System.out.println("---------------------------------------------------");
		}
		backto();
	}

	// nip, nama, bersih, kdpangkat, TGLLHR as usia
	public  void showData(JSONArray arrayData,String fieldsa, String fieldsb,String fieldsc,String fieldsd,String fieldse) {

		System.out.println("+------------------------------------------------------------------------------------------+");
		System.out.println("| Nip              | Nama                       | Gaji      | Kode Pangkat | Tanggal lahir |");
		System.out.println("+------------------------------------------------------------------------------------------+");
		String space;
		for (int i = 0; i < arrayData.length(); i++) {//modify by Ipin
			JSONObject obj =  arrayData.getJSONObject(i);

			space=(String) obj.get(fieldsb);
			space=space.trim();
			System.out.print("|"+obj.get(fieldsa));
			System.out.print("|"+space);
			for (int j = 0; j <28-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("| Rp."+obj.get(fieldsc));
			System.out.print("|     "+obj.get(fieldsd));
			System.out.println("       |   "+obj.get(fieldse)+"  |");
			System.out.println("+------------------------------------------------------------------------------------------+");

		}
		backto();
	}


	public  void showData(JSONArray arrayData,String fieldsa, String fieldsb, String fieldsc, String fieldsd) {
		//System.out.println(arrayData);
		System.out.println("+---------------------------------------------------------------------------+");
		System.out.println("|   NIP            |        Nama              | Gaji         |     Golongan |");
		System.out.println("+---------------------------------------------------------------------------+");
		String space;
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);
			space=(String) obj.get(fieldsb);
			System.out.print("|"+obj.get(fieldsa));
			System.out.print("|  "+obj.get(fieldsb));
			for (int j = 0; j  <24-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("| Rp."+obj.get(fieldsc));
			System.out.println("  |       "+obj.get(fieldsd)+"     |");
			System.out.println("+---------------------------------------------------------------------------+");
		}

		backto();
	}

	public  void showData4Parameter(JSONArray arrayData,String fieldsa, String fieldsb, String fieldsc, String fieldsd) {
		//System.out.println(arrayData);
		System.out.println("+---------------------------------------------------------------------------------+");
		System.out.println("|   NIP            |        Nama              | Status Perkawinan  |  Jumlah Anak |");
		System.out.println("+---------------------------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);
			space=(String) obj.get(fieldsb);
			System.out.print("|"+obj.get(fieldsa));		
			space=space.trim();
			System.out.print("|"+space);

			for (int j = 0; j  <26-(space.length()); j++) {
				System.out.print(" ");}
			System.out.print("|           "+obj.get(fieldsc));
			System.out.println("        |       "+obj.get(fieldsd)+"      |");
			System.out.println("+---------------------------------------------------------------------------------+");
		}

		backto();
	}

	public  void showData(JSONArray arrayData, String fSatu, String fDua, String fTiga, String fEmpat, String fLima, String fEnam, String fTujuh) {
		//System.out.println(arrayData);
		System.out.println("+---------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|        Nip         |           Nama           |  Jenis Kelamin  | Tanggal Lahir | Kode Pangkat | Masa Kerja | Jumlah Anak |");
		System.out.println("+---------------------------------------------------------------------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(fSatu);
			System.out.print("| "+space);

			space=(String) obj.get(fDua);
			space = space.trim();
			System.out.print(" | "+space);
			for (int j = 0; j  <24-(space.length()); j++) {
				System.out.print(" ");
			}

			if (obj.get(fTiga).equals(1)) {
				space = "Laki Laki";
			}else {
				space = "Perempuan";
			}
			System.out.print(" |    "+space);

			System.out.print("    |   "+obj.get(fEmpat));

			System.out.print("  |      "+obj.get(fLima));

			System.out.print("      |     "+obj.get(fEnam));

			System.out.println("     |      "+obj.get(fTujuh)+"      |");

			System.out.println("+---------------------------------------------------------------------------------------------------------------------------+");
		}
		backto();
	}

	
}
