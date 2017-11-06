package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdSkpdController;

public class MainMdSkpdKota {
	
	Scanner in = new Scanner(System.in);
	MdSkpdController newMd = new MdSkpdController();
	
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
	
	public void testqueryMenampilkanData() {
		try {
			JSONArray data = newMd.getQueryMenampilkanData();
			showDataSelect(data,"kdcabang","kdssbp","kdskpd","nmskpd","updstamp","inputer","kelssbp");
			menu();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void testqueryMencariData() {
		String nama;
		try {
			System.out.print("Masukkan nama skpd : ");
			nama = in.nextLine();
			JSONArray data = newMd.getQueryMencariData(nama);
			showDataSelect(data,"kdcabang","kdssbp","kdskpd","nmskpd","updstamp","inputer","kelssbp");
			menu();
			} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testqueryMenambahData() {
		String cabang, ssbp, skpd, nama, upd, input, kel;
		try {
			System.out.print("Masukkan kode cabang : ");
			cabang = in.next();
			System.out.print("Masukkan kode sbp : ");
			ssbp = in.next();
			System.out.print("Masukkan kode skpd : ");
			skpd = in.next();
			System.out.print("Masukkan nama skpd : ");
			nama = in.next();
			System.out.print("Masukkan updstamp : ");
			upd = in.next();
			System.out.print("Masukkan inputer : ");
			input = in.next();
			System.out.print("Masukkan kelompok ssbp : ");
			kel = in.next();
			newMd.getQueryMenambahData(cabang, ssbp, skpd, nama, upd, input, kel);
			menu();
			} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testqueryMengubahData() {
		String nama, kode;
		try {
			System.out.print("Masukkan nama skpd : ");
			nama = in.nextLine();
			System.out.print("Masukkan kode skpd : ");
			kode = in.nextLine();
			newMd.getQueryMengubahData(nama,kode);
			menu();
			} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testqueryMenghapusData() {
		String kode;
		try {
			System.out.print("Masukkan kode skpd : ");
			kode = in.next();
			newMd.getQueryMenghapusData(kode);
			menu();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void showDataSelect(JSONArray arrayData, String f1, String f2, String f3, String f4, String f5, String f6, String f7) {
		System.out.println("+-----------------------------------------------------------------------------------------------------+");
		System.out.println("| CABANG | SSBP | KODE |                 NAMA SKPD                    | UPDSTAMP | INPUTER  | KELOMPOK |");
		System.out.println("+-----------------------------------------------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			System.out.print("|   "+obj.get(f1));
			
			System.out.print("  | "+obj.get(f2));
			
			System.out.print("  | "+obj.get(f3));
			
			space=(String) obj.get(f4);
			space = space.trim();
			System.out.print("  | "+space);
			for (int j = 0; j  <45-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("|    "+obj.get(f5));
			
			System.out.print("    | "+obj.get(f6));
			
			System.out.print(" |    "+obj.get(f7));
			
			System.out.println("    |");
			
			System.out.println("+-----------------------------------------------------------------------------------------------------+");
		}
	}
	
	public static void main(String[] args) {
		MainMdSkpdKota md = new MainMdSkpdKota();
		md.menu();
	}
}
