package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdAkunKonvController;

public class MainMdAkunKonv {
	public static Scanner keyboard = new Scanner(System.in);
	public static MdAkunKonvController mak= new MdAkunKonvController();
	
	public static void testReadData() {
		MdAkunKonvController mak= new MdAkunKonvController();
		try {
			JSONArray data = mak.getReadData();
			showData_AkunKonv(data,"kdtrans","urt");
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	public static void testSearchData() {	
		try {
			String input;
			System.out.println("Masukkan kdtrans:");
			input=keyboard.next();
			JSONArray data = mak.getSearchData(input);
			showData_AkunKonv(data,"kdtrans","urt");
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		backto();
		
	}
	public static void testUpdateData() {
		try {
			System.out.print("Masukan Kode Trans yang akan di edit : ");
			String inputKode=keyboard.next();
			System.out.print("Masukan Urt baru: ");
			int urt=keyboard.nextInt();
			JSONArray data = mak.getUpdateData(urt,inputKode);
		} catch (Exception e){
			System.out.println("Inputan Salah, masukan String untuk Kode Trans");
			System.out.println(e.getMessage());
		}
		backto();
		
	}
	public static void testCreateData() {	
		try {
			System.out.print("Masukan Kode Trans : ");
			String inputKode=keyboard.next();
			System.out.print("Masukan Urt : ");
			int urt=keyboard.nextInt();
			JSONArray data = mak.getCreateData(inputKode, urt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		backto();
	}
	public static void testDeleteData() {	
		try {
			System.out.print("Masukan Kode Trans yang akan di hapus : ");
			String kdtrans=keyboard.next();
			JSONArray data = mak.getDeleteData(kdtrans);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
		backto();
	}
	public static  void backto()  {
		int inp;
		System.out.println("1. Menampilkan Tabel Akun Konvensional");
		System.out.println("2. Mencari Urt Berdasarkan Kode Trans");
		System.out.println("3. Mengedit Data Akun Konv");
		System.out.println("4. Menambahkan Data Akun Konv");
		System.out.println("5. Menghapus Data Akun Konv");
		System.out.println("=======================================");
		System.out.print("Masukan Pilihan : ");
			inp=keyboard.nextInt();
			if(inp==1) {
				testReadData();
			}else if(inp==2) {
				testSearchData();
			}else if(inp==3) {
				testUpdateData();
			}else if(inp==4) {
				testCreateData();
			}else if(inp==5) {
				testDeleteData();
			}else {
				System.out.println("Masukan Salah !");
			}
		
	}
	
	public static  void showData_AkunKonv(JSONArray arrayData, String kdtrans,String urt) {
		System.out.println("+----------------------------------+");
		System.out.println("| Kdtrans   | Urt			       |");
		System.out.println("+----------------------------------+");
	
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);
			System.out.print("| "+ obj.get(kdtrans));

			System.out.print("              | "+  obj.get(urt));
			System.out.println("|");
			System.out.println("+----------------------------------+");
			}
		backto();
		
	}
	
	public static void main(String args[]) {
		MainMdAkunKonv mainmdakunkonv = new MainMdAkunKonv();
		mainmdakunkonv.backto();
	}
	
}
	
	