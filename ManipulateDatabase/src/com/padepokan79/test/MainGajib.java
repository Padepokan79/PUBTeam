package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdGajibController;
import com.padepokan79.controller.MdIuranJkkjkmController;
//by ILFA SRI DESY
public class MainGajib {
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		MainGajib g=new MainGajib();
		g.menu();
	}
	
	public void menu() throws NumberFormatException, IOException {
		System.out.println("");
		System.out.println("+------------------------------------+");
		System.out.println("|        MENU GAJIB                  |");
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
			testSelectGajib();
			menu();
		}else if(tamp==2) {
			testInsertGajib();
			menu();
		}else if(tamp==3) {
			testUpdateGajib();
			menu();
		}else if(tamp==4) {
			testDeleteGajib();
			menu();
		}else if(tamp==5) {
			testMencariGajib();
			menu();
		}else {
			System.out.println("Pilihan tidak terdaftar");
			menu();
		}
	}
	
	public void testSelectGajib() {
		MdGajibController gb=new MdGajibController();
		try {
			JSONArray data=gb.getQuerySelectAllGajib();
			showData_gajib(data, "nip", "nama", "namasat", "gapok");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testMencariGajib(){
		MdGajibController gb=new MdGajibController();
		try {
			System.out.println("Masukan nip: ");
			String in=input.readLine();
			JSONArray data=gb.getQueryMencariGajib(in);
			showData_gajib(data, "nip", "nama", "namasat", "gapok");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testUpdateGajib() {
		MdGajibController gb=new MdGajibController();
		try {
			
			System.out.println("Masukan gapok baru: ");
			int gapok=Integer.parseInt(input.readLine());
			
			System.out.println("Masukan nip yang gapok nya akan diubah: ");
			String nip=input.readLine();
			
			JSONArray data=gb.getQueryUpdateGajib(gapok, nip);
			//showData_gajib(data, "nip", "nama", "namasat", "gapok");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testDeleteGajib() {
		MdGajibController gb=new MdGajibController();
		try {
			System.out.println("Masukan nip yang data nya akan dihapus: ");
			String nip=input.readLine();
			JSONArray data=gb.getQueryDeleteGajib(nip);
			//showData_gajib(data, "nip", "nama", "namasat", "gapok");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testInsertGajib() {
		MdGajibController gb=new MdGajibController();
		try {
			System.out.println("Masukan nip data baru: ");
			String nip=input.readLine();
			System.out.println("Masukan nama data baru: ");
			String nama=input.readLine();
			System.out.println("Masukan namasat data baru: ");
			String namasat=input.readLine();
			System.out.println("Masukan gapok data baru: ");
			int gapok=Integer.parseInt(input.readLine());
			
			JSONArray data=gb.getQueryInsertGajib(nip, nama, namasat, gapok);
			//showData_gajib(data, "nip", "nama", "namasat", "gapok");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void showData_gajib(JSONArray arrayData,String nip, String nama, String namasat, String gapok) {
		System.out.println(arrayData);
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|          nip                 |                NAMA                    |                    NAMA SAT                 |     GAPOK      |");
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------+");
		String space;
		int tamp;
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			space=(String) obj.get(nip);
			space = space.trim();
			System.out.print("|    "+space);
			for (int j = 0; j  <26-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(nama);
			space = space.trim();
			System.out.print("|    "+space);
			for (int j = 0; j  <36-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(namasat);
			space = space.trim();
			System.out.print("|    "+space);
			for (int j = 0; j  <41-(space.length()); j++) {
				System.out.print(" ");
			}
			
			
			System.out.print("|       "+obj.get(gapok)+"      ");
			

	
			System.out.println("|");
			System.out.println("+--------------------------------------------------------------------------------------------------------------+");
		}
		
	}
}
