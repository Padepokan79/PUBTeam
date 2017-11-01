package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdPangkatTblController;

public class MainMdPangakat {
	public BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
	
	public MainMdPangakat(){
		//testqueryTampilDataJuruBayar();
	}
	
	public void menu() throws SQLException, IOException{
		System.out.println(" ---------------------------");
		System.out.println("|            MENU           |");
		System.out.println(" ---------------------------");
		System.out.println("| 1. Tampil Data Pangakat   |");
		System.out.println("| 2. Cari Data Pangakat     |");
		System.out.println("| 3. Tambah Data Pangakat   |");
		System.out.println("| 4. Ubah Data Pangakat     |");
		System.out.println("| 5. Hapus Data Pangakat    |");
		System.out.println(" ---------------------------");
		System.out.print("Pilih Menu : ");
		int pilih= Integer.parseInt(keyboard.readLine());
		switch (pilih) {
		case 1:
			testqueryTampilDataPangakat();
			menu();
			break;
		case 2:
			testquerySearchDataPangkat();
			menu();
			break;
		case 3:
			testqueryInsertDataPangkat();
			menu();
			break;
		case 4:
			testqueryUpdateDataPangkat();
			menu();
			break;
		case 5:
			testqueryDeleteDataPangkat();
			menu();
			break;
		default:
			System.out.println("Masukan Salah !");
			menu();
		}
	}
	
	public  void testqueryTampilDataPangakat() {
		MdPangkatTblController md = new MdPangkatTblController();
		
		try {
			JSONArray data = md.getQueryTampilDataPangkat();
			showData(data,"kdpangkat","gol","nmgol","nmpangkat");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testquerySearchDataPangkat() {
		MdPangkatTblController md = new MdPangkatTblController();
		
		try {
			System.out.print("Masukan Kode Pangkat yang di cari : ");
			String inputKode=keyboard.readLine();
			System.out.print("Masukan Nama Golongan yang di cari : ");
			String inputNmGol=keyboard.readLine();
			JSONArray data = md.getQuerySearchPangkat(inputKode, inputNmGol);
			showData(data,"kdpangkat","gol","nmgol","nmpangkat");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryInsertDataPangkat() {
		MdPangkatTblController md = new MdPangkatTblController();
		
		try {
			System.out.print("Masukan Kode Pangkat : ");
			String inputKode=keyboard.readLine();
			System.out.print("Masukan Golongan : ");
			String inputGol=keyboard.readLine();
			System.out.print("Masukan Nama Golongan : ");
			String inputNmGol=keyboard.readLine();
			System.out.print("Masukan Nama Pangkat : ");
			String inputNmPangkat=keyboard.readLine();
			JSONArray data = md.getQueryInsertPangkat(inputKode, inputGol, inputNmGol, inputNmPangkat);
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryUpdateDataPangkat() {
		MdPangkatTblController md = new MdPangkatTblController();
		
		try {
			System.out.print("Masukan Kode Pangkat yang akan di ubah : ");
			String inputKode=keyboard.readLine();
			System.out.print("Masukan Nama Golongan baru: ");
			String inputNmGol=keyboard.readLine();
			JSONArray data = md.getQueryUpdatePangkat(inputKode, inputNmGol);
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryDeleteDataPangkat() {
		MdPangkatTblController md = new MdPangkatTblController();
		
		try {
			System.out.print("Masukan kode Pangkat yang akan di hapus : ");
			String inputKode=keyboard.readLine();
			System.out.print("Masukan nama Pangkat yang akan di hapus : ");
			String inputNmPangkat=keyboard.readLine();
			JSONArray data = md.getQueryDeletePangkat(inputKode, inputNmPangkat);
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void showData(JSONArray arrayData, String kdpangkat, String gol, String nmGol, String nmPangkat) {
		//System.out.println(arrayData);
		System.out.println("+------------------------------------------------------------------+");
		System.out.println("| Kode Pangkat| Gol           | Nama Gol       | Nama Pangkat      | ");
		System.out.println("+------------------------------------------------------------------+");
		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(kdpangkat);
			System.out.print("| "+ space);

			space=(String) obj.get(gol);
			System.out.print("          | "+ space);
			
			space=(String) obj.get(nmGol);
			System.out.print("            | "+ space);
			
			space=(String) obj.get(nmPangkat);
			System.out.print("              | "+ space);
			for (int k = 0; k  < 16 - (space.length()); k++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+------------------------------------------------------------------+");
		}
	}

	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
		MainMdPangakat mp= new MainMdPangakat();
		mp.menu();
	}

}
