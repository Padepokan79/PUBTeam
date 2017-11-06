package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdGuruTblController;

public class MainMdGuru {
public BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
	
	public MainMdGuru(){
		//testqueryTampilDataJuruBayar();
	}
	
	public void menu() throws SQLException, IOException{
		System.out.println(" ---------------------------");
		System.out.println("|            MENU           |");
		System.out.println(" ---------------------------");
		System.out.println("| 1. Tampil Data Guru       |");
		System.out.println("| 2. Cari Data Guru         |");
		System.out.println("| 3. Tambah Data Guru       |");
		System.out.println("| 4. Ubah Data Guru         |");
		System.out.println("| 5. Hapus Data Guru        |");
		System.out.println(" ---------------------------");
		System.out.print("Pilih Menu : ");
		int pilih= Integer.parseInt(keyboard.readLine());
		switch (pilih) {
		case 1:
			testqueryTampilDataGuru();
			menu();
			break;
		case 2:
			testquerySearchDataGuru();
			menu();
			break;
		case 3:
			testqueryInsertDataGuru();
			menu();
			break;
		case 4:
			testqueryUpdateDataGuru();
			menu();
			break;
		case 5:
			testqueryDeleteDataGuru();
			menu();
			break;
		default:
			System.out.println("Masukan Salah !");
			menu();
		}
	}
	
	public  void testqueryTampilDataGuru() {
		MdGuruTblController md = new MdGuruTblController();
		
		try {
			JSONArray data = md.getQueryTampilDataGuru();
			showData(data,"tmtberlaku","kdguru","nmguru","tjguru");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testquerySearchDataGuru() {
		MdGuruTblController md = new MdGuruTblController();
		
		try {
			System.out.print("Masukan Kode Guru yang di cari : ");
			String inputKode=keyboard.readLine();
			JSONArray data = md.getQuerySearchGuru(inputKode);
			showData(data,"tmtberlaku","kdguru","nmguru","tjguru");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryInsertDataGuru() {
		MdGuruTblController md = new MdGuruTblController();
		
		try {
			System.out.print("Masukan TMT BERLAKU : ");
			String inputTmt=keyboard.readLine();
			System.out.print("Masukan Kode Guru : ");
			String inputKode=keyboard.readLine();
			System.out.print("Masukan Nama Guru : ");
			String inputNama=keyboard.readLine();
			System.out.print("Masukan Tunjangan Guru : ");
			int inputTj= Integer.parseInt(keyboard.readLine());
			JSONArray data = md.getQueryInsertGuru(inputTmt, inputKode, inputNama, inputTj);
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryUpdateDataGuru() {
		MdGuruTblController md = new MdGuruTblController();
		
		try {
			System.out.print("Masukan Kode Guru Yang akan di ubah : ");
			String inputKode=keyboard.readLine();
			System.out.print("Masukan Tunjangan Guru baru: ");
			int inputTj= Integer.parseInt(keyboard.readLine());
			JSONArray data = md.getQueryUpdateGuru(inputKode, inputTj);
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryDeleteDataGuru() {
		MdGuruTblController md = new MdGuruTblController();
		
		try {
			System.out.print("Masukan Kode Guru Yang akan di hapus : ");
			String inputKode=keyboard.readLine();
			JSONArray data = md.getQueryDeleteGuru(inputKode);
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void showData(JSONArray arrayData, String tmt, String kdGuru, String nmGuru, String tjGuru) {
		//System.out.println(arrayData);
		System.out.println("+--------------------------------------------------------------------------------+");
		System.out.println("| TMT Berlaku        | Kode Guru    | Nama Guru             | Tunjangan Guru     | ");
		System.out.println("+--------------------------------------------------------------------------------+");
		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			System.out.print("| "+ obj.get(tmt));

			space=(String) obj.get(kdGuru);
			System.out.print("         | "+ space);
			
			space=(String) obj.get(nmGuru);
			System.out.print("            | "+ space);
			
			tamp=(int) obj.get(tjGuru);
			System.out.print("       |  "+tamp+"   ");
			for (int k = 0; k  < 16 - (space.length()); k++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+-------------------------------------------------------------------------------+");
		}
	}
	
	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		MainMdGuru mg= new MainMdGuru();
		mg.menu();
	}

}
