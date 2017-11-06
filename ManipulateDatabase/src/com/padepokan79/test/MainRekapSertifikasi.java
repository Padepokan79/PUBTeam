package com.padepokan79.test;

import java.sql.Date;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import com.padepokan79.controller.MdRekapSertifikasiController;

public class MainRekapSertifikasi {
	
	Scanner bf=new Scanner(System.in);
	
	public void menuUtama(){
		System.out.println("+-----------------+");
		System.out.println("| 1. Insert Data  |");
		System.out.println("| 2. Select Data  |");
		System.out.println("| 3. Search Data  |");
		System.out.println("| 4. Update Data  |");
		System.out.println("| 5. Delete Data  |");
		System.out.println("+-----------------+");
		try {
			System.out.print("Masukan Pilihan : ");
			int input=bf.nextInt();
			if(input==2) {
				tesQueryMenampilkanSemuaData();
			}else if(input==3) {
				tesQueryMencariTglgajiTglBayarKdsatkerdanPeg();
			}else {
				System.out.println("Maaf, inputan anda salah");
				menuUtama();
			}
		}catch (Exception e) {
				System.out.println("Exception Print !");
				System.out.println(e.getMessage());
		}
	}
	
	public  void tesQueryMencariTglgajiTglBayarKdsatkerdanPeg(){
		MdRekapSertifikasiController mrs = new MdRekapSertifikasiController();
		
		try {
			System.out.print("Masukan Kode Satuan Kerja : ");
			String inputKode=bf.next();
			JSONArray data = mrs.getQueryMencariqueryMencariTglgajiTglBayarKdsatkerdanPeg(inputKode);
			searchData(data,"tglgaji","tgl_byr","kdsatker","peg");
		} catch (Exception e) {
			System.out.println("Inputan Salah..");
			System.out.println(e.getMessage());
		}
	}
	
	public  void searchData(JSONArray arrayData, String tglgaji, String tgl_byr, String kdsatker, String peg) {
		//System.out.println(arrayData);
		System.out.println("+---------------------------------------------------------------------------+");
		System.out.println("| Tanggal Gaji     | Tanggal Bayar      |  Kode Satuan Kerja   | Peg        |");
		System.out.println("+---------------------------------------------------------------------------+");
		Date space;
		String sp;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			/*System.out.print("| "+obj.get(tglgaji)+"       |");
			
			System.out.print("        "+obj.get(tgl_byr)+"  |");
			
			System.out.print("      "+obj.get(kdsatker)+"            |");
			
			System.out.print("    "+obj.get(peg)+"  |");*/

			System.out.println("+----------------------------------------------------------------------+");

		}
		menuUtama();
	}
	
	public  void tesQueryMenampilkanSemuaData(){
		MdRekapSertifikasiController mrs = new MdRekapSertifikasiController();
		
		try {
			JSONArray data = mrs.getQueryMenampilkanSemuaData();
			viewData(data,"tglgaji","tgl_byr","kdsatker","peg", "gapok", "pajak", "tgl_cutoff");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public  void viewData(JSONArray arrayData, String tglgaji, String tgl_byr, String kdsatker, String peg, String gapok, String pajak, String tgl_cutoff) {
		//System.out.println(arrayData);
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("| Tanggal Gaji     | Tanggal Bayar      |  Kode Satuan Kerja   | Peg        |  Gapok     |  Pajak       |  Tgl_cutoff      |");
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			System.out.print("| "+obj.get(tglgaji)+"       |");
			
			System.out.print("        "+obj.get(tgl_byr)+"  |");
			
			System.out.print("      "+obj.get(kdsatker)+"            |");
			
			System.out.print("    "+obj.get(peg)+"  |");
			
			System.out.print("        "+obj.get(gapok)+"  |");
			
			System.out.print("         "+obj.get(pajak)+"  |");
			
			System.out.print("         "+obj.get(tgl_cutoff)+"  |");
			
			System.out.println(" |");
		System.out.println("+----------------------------------------------------------------------+");

		}
		menuUtama();
	}
	public static void main(String[] args) {
		MainRekapSertifikasi ma = new MainRekapSertifikasi();	
		ma.menuUtama();
	}
}
