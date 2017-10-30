package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.HistorisEselon;

public class MainHistorisEselon {
	Scanner dataIn = new Scanner(System.in);
	MainActivity ma=new MainActivity();

	public MainHistorisEselon() {
		mainMenu();
	}
	
	public void mainMenu () {//Modify by rzkypprtm

		System.out.println("+------------------------------------------------------------------------------------+");
		System.out.println("|                                  Submenu Keluarga                                  |");
		System.out.println("|------------------------------------------------------------------------------------|");
		System.out.println("| 1. Rata Rata Tunjangan Eselon   | 2. Daftar No Surat   | 3. Eselon yang bukan Null |");
		System.out.println("|------------------------------------------------------------------------------------|");
		System.out.println("| 4. Mencari Jumlah Eselon        | 5. Historis SKep     | 0. Menu Utama             |");
		System.out.println("+------------------------------------------------------------------------------------+");

		try {
			System.out.print("Masukan PIlihan : ");
			String input=dataIn.next();
			switch (input) {
			case "1":
				getQueryMenampilkanRatarataTunjanganEselon();
				break;
			case "2":
				getqueryMenampilkanDaftarPNSYangMempunyaiKodeEselonBersuratKeputusan();
				break;
			case "3":
				getQueryTJEselonYangNolBukanNull();
				break;
			case "4":
				getQueryMenampilkanJumlahPNSyangMempunyaiTunjanganEselonberdasrakanInputanBatasKecildanBatasBesar();
				break;
			case "5":
				getQueryMenampilkanHistorisSkep();
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
			inp=dataIn.next();
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

	/*Rata rata Tunjangan Eselon*/

	public  void getQueryMenampilkanRatarataTunjanganEselon(){
		HistorisEselon he = new HistorisEselon();
		JSONArray data = he.getQueryMenampilkanRatarataTunjanganEselon(); 
		showData(data,"tunjangan_eselon");
	}
	public  void showData(JSONArray arrayData,String fielda) {
		//System.out.println(arrayData);
		System.out.println("+-----------------------------------------------+");
		System.out.println("|        Rata - Rata Tunjangan Eselon           |");
		System.out.println("+-----------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			System.out.print("|    "+obj.get(fielda));
			System.out.println("  |");
			System.out.println("+--------------------------------------------------------------+");
		}
		backto();
	}		

	public void getqueryMenampilkanDaftarPNSYangMempunyaiKodeEselonBersuratKeputusan(){
		int nextPage = 0;
		HistorisEselon he =new HistorisEselon();
		JSONArray data = he.getQueryMenampilkanDaftarPNSYangMempunyaiKodeEselonBersuratKeputusan(nextPage); 
		showData(data,"nip","nama","kdeselon","tjeselon","nomorskep","penerbitskep");
	}
	public void showData(JSONArray arrayData,String fielda ,String fieldb, String fieldc, String fieldd, String fielde, String fieldf) {
		//System.out.println(arrayData);
		System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|            NIP            |          NAMA            |  KODE ESELON   |     TUNJANGAN ESELON     |   No. Surat Keputusan     |   Penerbit Surat Keputusan |");
		System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			System.out.print("|  	  "+obj.get(fielda));
			space=(String) obj.get(fieldb);
			space = space.trim();

			System.out.print("| "+space);
			for (int j = 0; j  <25-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldc);
			space = space.trim();

			System.out.print("| "+space);
			for (int j = 0; j  <15-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("| ");
			System.out.print(obj.get(fieldd));

			for (int j = 0; j  <20-(space.length()); j++) {
				System.out.print(" ");	
			}
			space=(String) obj.get(fielde);
			space = space.trim();
			System.out.print("|"+space);
			for (int j = 0; j  <16-(space.length()); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j  <15-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("|");
			space = (String) obj.get(fieldf);
			System.out.print(space.trim());
			System.out.println("                    |");

			System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------+");
		}
		System.out.println("N lanjut M Menu : ");
		String quiz= dataIn.next();
		if(quiz.equalsIgnoreCase("N")) {
			int nextPage = 0;
			nextPage+=10;
			HistorisEselon he =new HistorisEselon();
			JSONArray data = he.getQueryMenampilkanDaftarPNSYangMempunyaiKodeEselonBersuratKeputusan(nextPage); 
			showData(data,"nip","nama","kdeselon","tjeselon","nomorskep","penerbitskep");
		}else {
			backto();
		}
	}

	public  void getQueryTJEselonYangNolBukanNull(){
		int nextPage = 0;
		HistorisEselon he = new HistorisEselon();
		JSONArray data = he.getQueryTJEselonYangNolBukanNull(nextPage); 
		showData(data,"nip","tjeselon");
	}

	public  void showData(JSONArray arrayData,String fielda, String fieldb) {
		System.out.println("+--------------------------------------------------+");
		System.out.println("|          NIP           |    Tunjangan Eselon     |");
		System.out.println("+--------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			space=(String) obj.get(fielda);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <23-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("|    "+obj.get(fieldb));

			System.out.println("                    |");
			System.out.println("+--------------------------------------------------+");
		}
		backto();
	}

	public void getQueryMenampilkanJumlahPNSyangMempunyaiTunjanganEselonberdasrakanInputanBatasKecildanBatasBesar(){
		HistorisEselon he = new HistorisEselon();

		try {
			System.out.print("Masukan Batas Tunjangan Awal : ");
			int awal = dataIn.nextInt();
			System.out.print("Masukan Batas Tunjangan Akhir : ");
			int akhir = dataIn.nextInt();

			JSONArray data = he.getQueryMenampilkanJumlahPNSyangMempunyaiTunjanganEselonberdasrakanInputanBatasKecildanBatasBesar(awal, awal, 0);
			showData1(data, "tjeselon","jumlah");
		}
		catch (Exception e) {
//			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}

	public  void showData1(JSONArray arrayData,String fielda, String fieldb) {
		System.out.println("+-------------------------------+");
		System.out.println("| Tunjangan Eselon |   Jumlah   |");
		System.out.println("+-------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			System.out.print("|         "+obj.get(fielda)+"        ");

			System.out.print("|   "+obj.get(fieldb));

			System.out.println("    |");
			System.out.println("+-------------------------------+");
		}
		backto();
	}

	public  void getQueryMenampilkanHistorisSkep(){
		HistorisEselon he =new HistorisEselon();
		JSONArray data = he.getQueryMenampilkanHistorisSkep(0); 
		showData2(data,"nip","nama","nomorskep","penerbitskep","keterangan","tglupdate");
	} 
	public  void showData2(JSONArray arrayData,String fielda ,String fieldb, String fieldc, String fieldd, String fielde, String fieldf) {
		//System.out.println(arrayData);
		System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|            NIP            |          NAMA            |  NO. Surat Keputusan   |     Penerbit Keputusan     |         KETERANGAN     |    TANGGAL UPDATE   |");
		System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			System.out.print("|   "+obj.get(fielda));
			space=(String) obj.get(fieldb);
			space = space.trim();

			System.out.print("      | "+space);
			for (int j = 0; j  <25-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldc);
			space = space.trim();

			System.out.print("| "+space);
			for (int j = 0; j  <15-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("        | ");
			System.out.print(obj.get(fieldd));

			for (int j = 0; j  <20-(space.length()); j++) {
				System.out.print(" ");	
			}
			space=(String) obj.get(fielde);
			space = space.trim();
			System.out.print("|"+space);
			for (int j = 0; j  <16-(space.length()); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j  <15-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("|");
			space = (String) obj.get(fieldf);
			System.out.print(space.trim());
			System.out.println("                    |");
			System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------+");
		}
		backto();
	}


	public  void main(String args[]) {
		MainHistorisEselon mk=new MainHistorisEselon();
		mk.mainMenu();
	}
}
