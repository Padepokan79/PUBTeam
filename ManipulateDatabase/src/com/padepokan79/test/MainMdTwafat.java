package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdTwafatController;


public class MainMdTwafat {
	Scanner in = new Scanner(System.in);
	MdTwafatController newMd = new MdTwafatController();
	
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
		}else if (pilih ==5) {
			testqueryMenghapusData();
		}else {
			System.out.println("Inputan Salah");
			menu();
		}
	}
	
	public  void testqueryMenampilkanData() {
		JSONArray data = newMd.getQueryMenampilkanData();
		showDataSelect(data,"nip","tglwafat","nosurat","penerbit");
		menu();
	}
	
	public  void testqueryMencariData() {
		String nosurat;
		try {
			System.out.print("Masukkan nosurat : ");
			nosurat = in.next();
			JSONArray data = newMd.getQueryMencariData(nosurat);
			showDataSelect(data,"nip","tglwafat","nosurat","penerbit");
			menu();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void testqueryMenambahData() {
		String nip, hubkel, wafat, nosurat, surat,penerbit,stop,penerima;
		int terusan;
		try {
			System.out.print("Masukkan Nip : ");
			nip = in.next();
			System.out.print("Masukkan kode hubungan keluarga : ");
			hubkel = in.next();
			System.out.print("Masukkan tanggal wafat : ");
			wafat = in.next();
			System.out.print("Masukkan nosurat : ");
			nosurat = in.next();
			System.out.print("Masukkan tanggal surat : ");
			surat = in.next();
			System.out.print("Masukkan penerbit : ");
			penerbit = in.next();
			System.out.print("Masukkan banyak terusan : ");
			terusan = in.nextInt();
			System.out.print("Masukkan tanggal stop : ");
			stop = in.next();
			System.out.print("Masukkan keluarga penerima : ");
			penerima = in.next();
			newMd.getQueryMenambahData(nip, hubkel, wafat, nosurat, surat,penerbit, terusan,stop,penerima );
			menu();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void testqueryMengubahData() {
		String penerbit, nosurat;
		try {
			System.out.print("Masukkan nosurat : ");
			nosurat = in.next();
			System.out.print("Masukkan penerbit terbaru : ");
			penerbit = in.next();
			newMd.getQueryMengubahData(penerbit,nosurat);
			menu();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void testqueryMenghapusData() {
		String nosurat;
		try {
			System.out.print("Masukkan nosurat : ");
			nosurat = in.next();
			newMd.getQueryMenghapusData(nosurat);
			menu();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void showDataSelect(JSONArray arrayData, String f1, String f2, String f3, String f4) {
		System.out.println("+------------------------------------------------------------------------------------------------+");
		System.out.println("|         NIP        |    WAFAT   |         NOSURAT         |              PENERBIT              |");
		System.out.println("+------------------------------------------------------------------------------------------------+");
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
			
			space = obj.get(f3).toString();
			space = space.trim();
			System.out.print(" | "+space);
			for (int j = 0; j  <23-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space = obj.get(f4).toString();
			space = space.trim();
			System.out.print(" | "+space);
			for (int j = 0; j  <35-(space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.println("|");
			
			System.out.println("+------------------------------------------------------------------------------------------------+");
		}
	}
	
	public static void main(String[] args) {
		MainMdTwafat md = new MainMdTwafat();
		md.menu();
	}
}
