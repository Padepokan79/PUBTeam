package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdStatusController;

public class MainMdStatus {
	MdStatusController newMd = new MdStatusController();
	Scanner in = new Scanner(System.in);
	
	public void menu() {
		int pilih;
		System.out.println("+------------------------------------------------------------------+");
		System.out.println("|                         Menu Tabel Status                        |");
		System.out.println("+------------------------------------------------------------------+");
		System.out.println("|    1. Lihat Data    |    2. Cari Data     |   3. Tambah Data     |");
		System.out.println("+------------------------------------------------------------------+");
		System.out.println("|    4. Ubah Data     |    5. Hapus Data    |   0. Kembali         |");
		System.out.println("+------------------------------------------------------------------+");
		System.out.print("Masukkan Pilihan : ");
		pilih = in.nextInt();
		if (pilih ==1) {
			testqueryMenampilkanData();
		}else if (pilih == 2) {
			testqueryMencariData();
		}else if (pilih == 3) {
			testQueryMenambahData();
		}else if (pilih == 4) {
			testQueryMengubahData();
		}else if (pilih ==5) {
			testQueryMenghapusData();
		}else {
			System.out.println("Inputan Salah");
			menu();
		}
	}
	
	public void testqueryMenampilkanData() {
		try {
			JSONArray data = newMd.getQueryMenampilkanData();
			showDataSelect(data,"kd_status","nm_status");
			menu();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testqueryMencariData() {
		try {
			System.out.print("Masukkan kode status : ");
			String input=in.next();
			JSONArray data = newMd.getQueryMencariDdata(input); 
			showDataSelect(data, "kd_status", "nm_status");
			menu();
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	
	public void testQueryMenambahData() {
		String kode, nama;
		try {
			System.out.print("Masukkan kode status : ");
			kode = in.next();
			System.out.print("Masukkan nama status : ");
			nama = in.next();
			newMd.getQueryMenambahData(kode, nama);
			menu();
			} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testQueryMengubahData() {
		String kode, nama;
		try {
			System.out.print("Masukkan kode status : ");
			kode = in.next();
			System.out.print("Masukkan nama status : ");
			nama = in.next();
			newMd.getQueryMengubahData(nama, kode);
			menu();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testQueryMenghapusData() {
		String kode;
		try {
			System.out.print("Masukkan kode status : ");
			kode = in.next();
			newMd.getQueryMenghapusData(kode);
			menu();
			} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public  void showDataSelect(JSONArray arrayData, String f1, String f2) {
		System.out.println("+---------------------+");
		System.out.println("| KODE |    STATUS    |");
		System.out.println("+---------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			System.out.print("|  "+obj.get(f1));
			
			space=(String) obj.get(f2);
			space = space.trim();
			System.out.print("  | "+space);
			for (int j = 0; j  <13-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+---------------------+");
		}
	}
	
	public static void main(String[] args) {
		MainMdStatus md = new MainMdStatus();
		md.menu();
	}

}
