package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdTpController;

public class MainMdTp {
	Scanner in = new Scanner(System.in);
	MdTpController newMd = new MdTpController();
	
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
			testqueryMenambahData();
		}else if (pilih == 4) {
			testqueryMengubahData();
		}else if (pilih == 5) {
			testqueryMenghapusData();
		}else {
			System.out.println("Inputan Salah");
			menu();
		}
	}
	
	public  void testqueryMenampilkanData() {
		try {
			JSONArray data = newMd.getQueryMenampilkanData();
			showData(data,"kode_tp","ket","rp_1","rp_2");
			menu();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void testqueryMencariData() {
		String kode;
		try {
			System.out.print("Masukkan kode tp : ");
			kode = in.next();
			JSONArray data = newMd.getQueryMencariData(kode);
			showData(data,"kode_tp","ket","rp_1","rp_2");
			menu();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void testqueryMenambahData() {
		String kode,ket;
		int satu, dua;
		try {
			System.out.print("Masukkan kode tp : ");
			kode = in.next();
			System.out.print("Masukkan keterangan : ");
			ket = in.next();
			System.out.print("Masukkan harga satu : ");
			satu = in.nextInt();
			System.out.print("Masukkan harga dua : ");
			dua = in.nextInt();
			newMd.getQueryMenambahData(kode, ket, satu, dua);
			menu();
			} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void testqueryMengubahData() {
		String kode,ket;
		try {
			System.out.print("Masukkan kode tp : ");
			kode = in.next();
			System.out.print("Masukkan keterangan : ");
			ket = in.next();
			newMd.getQueryMengubahData(ket, kode);
			menu();
			} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void testqueryMenghapusData() {
		String kode;
		try {
			System.out.print("Masukkan kode tp : ");
			kode = in.next();
			newMd.getQueryMenghapusData(kode);
			menu();
			} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public  void showData(JSONArray arrayData, String f1, String f2, String f3, String f4) {
		System.out.println("+------------------------------------------------------------+");
		System.out.println("| KODE |     KETERANGAN      |    HARGA 1    |    HARGA 2    |");
		System.out.println("+------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			System.out.print("|  "+obj.get(f1));
			
			space=(String) obj.get(f2);
			space = space.trim();
			System.out.print("  | "+space);
			for (int j = 0; j  <20-(space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.print("| "+obj.get(f3));
			for (int j = 0; j  <12-(obj.get(f3).toString().length()); j++) {
				System.out.print(" ");
			}
			
			System.out.print("  | "+obj.get(f4));
			for (int j = 0; j  <12-(obj.get(f4).toString().length()); j++) {
				System.out.print(" ");
			}
			
			System.out.println("  |");
			System.out.println("+------------------------------------------------------------+");
		}
	}
		
	public static void main(String[] args) {
		MainMdTp md = new MainMdTp();
		md.menu();
	}
}
