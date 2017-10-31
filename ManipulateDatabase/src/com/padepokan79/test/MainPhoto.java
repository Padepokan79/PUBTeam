package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdPhotoController;
import com.padepokan79.controller.MdStawinTblController;

public class MainPhoto {
	BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		MainPhoto p=new MainPhoto();
		p.menu();
	}
	
	public void menu() throws NumberFormatException, IOException {
		System.out.println("");
		System.out.println("+------------------------------------+");
		System.out.println("|        MENU PHOTO                  |");
		System.out.println("+------------------------------------+");
		System.out.println("|   1. Menampilkan Data              |");
		System.out.println("|   2. Insert Data                   |");
		System.out.println("|   3. Update Data                   |");
		System.out.println("|   4. Delete Data                   |");
		System.out.println("|   5. Search Data                   |");
		System.out.println("+------------------------------------+");
		System.out.println("Pilihan: ");
		int tamp=Integer.parseInt(input.readLine());
		if(tamp==1) {
			testSelectPhoto();
			menu();
		}else if(tamp==2) {
			testInsertPhoto();
			menu();
		}else if(tamp==3) {
			testUpdatePhoto();
			menu();
		}else if(tamp==4) {
			testDeletePhoto();
			menu();
		}else if(tamp==5) {
			testMencariPhoto();
			menu();
		}else {
			System.out.println("Pilihan tidak terdaftar");
			menu();
		}
	}
	
	public void testSelectPhoto() {
		MdPhotoController ph=new MdPhotoController();
		try {
			JSONArray data=ph.getQuerySelectAllPhoto();
			showData_photo(data,"nip","gambar");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testMencariPhoto(){
		MdPhotoController ph=new MdPhotoController();
		try {
			System.out.println("Masukan nip: ");
			String in=input.readLine();
			JSONArray data=ph.getQueryMencariPhoto(in);
			showData_photo(data,"nip","gambar");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testUpdatePhoto() {
		MdPhotoController ph=new MdPhotoController();
		try {
			System.out.println("Masukan gambar baru: ");
			String n=input.readLine();
			System.out.println("Masukan nip yang gambarnya akan diubah: ");
			String k=input.readLine();
			JSONArray data=ph.getQueryUpdatePhoto(n, k);
			//showData_photo(data,"nip","gambar");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testDeletePhoto() {
		MdPhotoController ph=new MdPhotoController();
		try {
			System.out.println("Masukan nip yang gambarnya akan dihapus: ");
			String k=input.readLine();
			JSONArray data=ph.getQueryDeletePhoto(k);
			//showData_photo(data,"nip","gambar");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testInsertPhoto() {
		MdPhotoController ph=new MdPhotoController();
		try {
			System.out.println("Masukan nip baru: ");
			String k=input.readLine();
			System.out.println("Masukan gambar baru: ");
			String n=input.readLine();
			JSONArray data=ph.getQueryInsertPhoto(k, n);
			//showData_photo(data,"nip","gambar");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public  void showData_photo(JSONArray arrayData, String nip, String gambar) {
		System.out.println(arrayData);
		System.out.println("+-------------------------------------------------+");
		System.out.println("|    nip                        |    gambar       |");
		System.out.println("+-------------------------------------------------+");
		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(nip);
			System.out.print("| "+space);
			for (int j = 0; j  < 30 - (space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(gambar);
			System.out.print("| "+ space);
			for (int j = 0; j  < 16 - (space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+-------------------------------------------------+");
		}
		
	}
}
