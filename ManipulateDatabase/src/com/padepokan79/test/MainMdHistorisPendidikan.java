package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdHistJiwaController;
import com.padepokan79.controller.MdHistorisPendidikanController;

public class MainMdHistorisPendidikan {
	int inputInt;
	String inputStr1,inputStr2;
	String nip,penerbit,catatan;
BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
	
//	Searching data historispendidikan by Jejen
	public  void MencariDataHistorisPendidikan(){
		MdHistorisPendidikanController hp = new MdHistorisPendidikanController(); 
		try { 
			System.out.print("Masukan NIP : ");
			 inputStr1= dataIn.readLine();
			JSONArray data = hp.getQueryMencariDataHistorisPendidikan(inputStr1);
			showData_hitorisPendidikan(data, "nip", "penerbit","catatan");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	
//	Menampilkan data historispendidikan by Jejen	
	public  void MenampilkanHistorisPendidikan(){
		MdHistorisPendidikanController hp = new MdHistorisPendidikanController(); 
			JSONArray data = hp.getQueryMenampilkanDataHistorisPendidikan();
			showData_hitorisPendidikan(data, "nip", "penerbit","catatan");
	}	
	
//	Mengubah data historispendidikan by Jejen
	public  void MengubahPenerbitdiHistJiwa(){
		MdHistorisPendidikanController hp = new MdHistorisPendidikanController();
			System.out.print("Masukan NIP yang akan di ubah : ");
			try {
				nip = dataIn.readLine();
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			
			System.out.print("Masukan Penerbit  : ");
			try {
				penerbit = dataIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.print("Masukan catatan  : ");
			try {
				catatan = dataIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			hp.getQueryMengubahPenerbitdiHistorisPendidikan(nip, penerbit, catatan);
			System.out.println("UPDATE SUCCESS !!");
	}	

//	Menghapus data Hhistorispendidikan by Jejen
	public  void MenghapusDataHistorisPendidikan(){
		MdHistorisPendidikanController hp = new MdHistorisPendidikanController();
			System.out.print("Masukan NIP yang akan di hapus : ");
			try {
				inputStr1 = dataIn.readLine();
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			hp.getQueryMenghapusDataHistorisPendidikan(inputStr1);
			System.out.println("DELETE SUCCESS !!");
	}
//	Menambah data Jenis Skpp by Jejen
	public  void MenambahDataHistorisPendidikan(){
		MdHistorisPendidikanController hp = new MdHistorisPendidikanController();
			System.out.print("Masukan Nip : ");
			try {
				nip = dataIn.readLine();
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			System.out.print("Masukan penerbit : ");
			try {
				penerbit = dataIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.print("Masukan catatan : ");
			try {
				catatan =dataIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			hp.getQueryMenambahDataHistorisPendidikan(nip, penerbit, catatan);
			System.out.println("DATA BARU SUCCESS DI TAMBAHKAN !!");
	}	
	public  void backto()  {
		String inp;
		System.out.println("\n====================================================");
		System.out.println("==         CRUD TABEL historis_pendidikan         ==");
		System.out.println("====================================================");
		System.out.println("1. Menampilkan data historis_pendidikan  ");
		System.out.println("2. Mencari data historis_pendidikan ");
		System.out.println("3. Menambahkan data historis_pendidikan ");
		System.out.println("4. Mengubah data historis_pendidikan ");
		System.out.println("5. Menghapus data historis_pendidikan ");
		try {
			System.out.print("Input Pilihan : ");
			inp=dataIn.readLine();
			System.out.println("====================================================\n");
			switch (inp) {
			case "1":
				MenampilkanHistorisPendidikan();;
				break;
			case "2":
				MencariDataHistorisPendidikan();
				break;
			case "3":
				MenambahDataHistorisPendidikan();
				break;
			case "4":
				MengubahPenerbitdiHistJiwa();
				break;
			case "5":
				MenghapusDataHistorisPendidikan();
				break;
			default:
				System.out.println("Masukan Salah !");
			}
			backto();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public  void showData_hitorisPendidikan(JSONArray Data,String p1, String p2, String p3 )
	{
		System.out.println();
		System.out.println("+------------------------------------------------------------------------------- +");
		System.out.println("|         NIP             |          PENERBIT          |      CATATAN            |");
		System.out.println("+--------------------------------------------------------------------------------+");
		String space;
		String tamp;
				//System.out.println(Data);
		for (int i = 0; i < Data.length(); i++) {
			JSONObject obj =  Data.getJSONObject(i);	
			
			//System.out.println("halo");
			space=String.valueOf(obj.get(p1)) ;
			System.out.print("| "+ space);
			for (int j = 0; j  < 24 - (space.length()); j++) {
				System.out.print(" ");
			}
			
			space=String.valueOf(obj.get(p2)) ;
			System.out.print("| "+ space);
			for (int j = 0; j  < 27 - (space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(p3);
			System.out.print("| "+ space);
			for (int j = 0; j  < 24 - (space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			


			System.out.println("+--------------------------------------------------------------------------------+");
		} backto();
	}	
	
	public static void main(String[] args) {
		MainMdHistorisPendidikan newMenu = new MainMdHistorisPendidikan();
		newMenu.backto();
	}
}
