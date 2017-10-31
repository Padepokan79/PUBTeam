package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;


import com.padepokan79.controller.MdHutangController;

public class MainMdHutang {
	
	Scanner in = new Scanner(System.in);
	MdHutangController newMd = new MdHutangController();
	
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
		JSONArray data = newMd.getQueryMenampilkanData();
		showData(data,"nip","jmlhutang","jmlcicilan","jmlbulan");
		menu();
	}
	
	public  void testqueryMencariData() {
		int hutang;
		try {
			System.out.print("Masukkan besaran gaji : ");
			hutang = in.nextInt();
			JSONArray data = newMd.getQueryMencariData(hutang);
			showData(data,"nip","jmlhutang","jmlcicilan","jmlbulan");
			menu();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void testqueryMenambahData() {
		int kode,norut,jmlhutang,jmlcicilan,akhir,waktu,jmlunas;
		String nip, ket, tmt,tat,lunas,gaji;
		try {
			System.out.print("Masukkan NIP : ");
			nip = in.next();
			System.out.print("Masukkan Kode Hutang : ");
			kode = in.nextInt();
			System.out.print("Masukkan Nomor urut : ");
			norut = in.nextInt();
			System.out.print("Masukkan Jumlah Hutang : ");
			jmlhutang = in.nextInt();
			System.out.print("Masukkan jumlah cicilan : ");
			jmlcicilan = in.nextInt();
			System.out.print("Masukkan cicilan akhir : ");
			akhir = in.nextInt();
			System.out.print("Masukkan waktu cicilan : ");
			waktu = in.nextInt();
			System.out.print("Keterangan : ");
			ket = in.next();
			System.out.print("Masukkan TMT hutang : ");
			tmt = in.next();
			System.out.print("Masukkan TAT hutang : ");
			tat = in.next();
			System.out.print("Masukkan Tanggal lunas : ");
			lunas = in.next();
			System.out.print("Masukkan pelunasan : ");
			jmlunas = in.nextInt();
			System.out.println("Masukkan tanggal gaji : ");
			gaji = in.next();
			newMd.getQueryMenambahData(nip,kode,norut,jmlhutang,jmlcicilan,akhir,waktu,tmt,tat,ket,lunas,jmlunas,gaji);
			menu();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void testqueryMengubahData() {
		String nip, ket;
		try {
			System.out.print("Masukkan Nip : ");
			nip = in.next();
			System.out.print("Masukkan keterangan terkini : ");
			ket = in.next();
			newMd.getQueryMengubahData(ket, nip);
			menu();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void testqueryMenghapusData() {
		String nip;
		try {
			System.out.print("Masukkan Nip : ");
			nip = in.next();
			newMd.getQueryMenghapusData(nip);
			menu();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void showData(JSONArray arrayData, String f1, String f2, String f3, String f4) {
		System.out.println("+--------------------------------------------------------+");
		System.out.println("|         NIP        |   HUTANG  |  CICILAN  |   WAKTU   |");
		System.out.println("+--------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			space=(String) obj.get(f1);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <19-(space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.print("| "+obj.get(f2));
			for (int j = 0; j  <10-(obj.get(f2).toString().length()); j++) {
				System.out.print(" ");
			}
			
			System.out.print("| "+obj.get(f3));
			for (int j = 0; j  <8-(obj.get(f3).toString().length()); j++) {
				System.out.print(" ");
			}
			
			System.out.print("  | "+obj.get(f4)+" bulan");
			for (int j = 0; j  <4-(obj.get(f4).toString().length()); j++) {
				System.out.print(" ");
			}
			
			System.out.println("|");
			
			System.out.println("+--------------------------------------------------------+");
		}
	}
	
	public static void main(String[] args) {
		MainMdHutang md = new MainMdHutang();
		md.menu();
	}
}
