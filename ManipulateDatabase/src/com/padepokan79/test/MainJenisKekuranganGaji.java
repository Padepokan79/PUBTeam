package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdJenisKekuranganGajiController;
import com.padepokan79.controller.MdStawinTblController;

public class MainJenisKekuranganGaji {
	BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		MainJenisKekuranganGaji jkg=new MainJenisKekuranganGaji();
		jkg.menu();
	}
	
	public void menu() throws NumberFormatException, IOException {
		System.out.println("");
		System.out.println("+------------------------------------+");
		System.out.println("|        MENU Jenis Kekurangan       |");
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
			testSelectJenisKekuranganGaji();
			menu();
		}else if(tamp==2) {
			testInsertJenisKekuranganGaji();
			menu();
		}else if(tamp==3) {
			testUpdateJenisKekuranganGaji();
			menu();
		}else if(tamp==4) {
			testDeleteJenisKekuranganGaji();
			menu();
		}else if(tamp==5) {
			testMencariJenisKekuranganGaji();
			menu();
		}else {
			System.out.println("Pilihan tidak terdaftar");
			menu();
		}
	}
	
	public void testSelectJenisKekuranganGaji() {
		MdJenisKekuranganGajiController mjkg=new MdJenisKekuranganGajiController();
		try {
			JSONArray data=mjkg.getQuerySelectAllJenisKekuranganGaji();
			showData_jenisKekuranganGaji(data,"jeniskekurangan","nmkekurangan");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testMencariJenisKekuranganGaji(){
		MdJenisKekuranganGajiController mjkg=new MdJenisKekuranganGajiController();
		try {
			System.out.println("Masukan nama kekurangan: ");
			String in=input.readLine();
			JSONArray data=mjkg.getQueryMencariJenisKekuranganGaji(in);
			showData_jenisKekuranganGaji(data,"jeniskekurangan","nmkekurangan");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testUpdateJenisKekuranganGaji() {
		MdJenisKekuranganGajiController mjkg=new MdJenisKekuranganGajiController();
		try {
			System.out.println("Masukan nama kekurangan baru: ");
			String n=input.readLine();
			System.out.println("Masukan kode yang jenis kekurangannya akan diubah: ");
			int k=Integer.parseInt(input.readLine());
			JSONArray data=mjkg.getQueryUpdateJenisKekuranganGaji(n, k);
			//showData_jenisKekuranganGaji(data,"JENISKEKURANGAN","NMKEKURANGAN");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testDeleteJenisKekuranganGaji() {
		MdJenisKekuranganGajiController mjkg=new MdJenisKekuranganGajiController();
		try {
			System.out.println("Masukan kode yang jenis kekurangannya akan dihapus: ");
			int k=Integer.parseInt(input.readLine());
			JSONArray data=mjkg.getQueryDeleteJenisKekuranganGaji(k);
			//showData_jenisKekuranganGaji(data,"JENISKEKURANGAN","NMKEKURANGAN");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testInsertJenisKekuranganGaji() {
		MdJenisKekuranganGajiController mjkg=new MdJenisKekuranganGajiController();
		try {
			System.out.println("Masukan kode jenis kekurangan baru: ");
			int k=Integer.parseInt(input.readLine());
			System.out.println("Masukan jenis kekurangan baru: ");
			String n=input.readLine();
			JSONArray data=mjkg.getQueryInsertJenisKekuranganGaji(k, n);
			//showData_jenisKekuranganGaji(data,"JENISKEKURANGAN","NMKEKURANGAN");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public  void showData_jenisKekuranganGaji(JSONArray arrayData, String jeniskekurangan, String nmkekurangan) {
		//System.out.println(arrayData);
		System.out.println("+----------------------------------------------------------+");
		System.out.println("|Jenis Kekurangan|             Nama Kekurangan             |");
		System.out.println("+----------------------------------------------------------+");
		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			tamp=(int) obj.get(jeniskekurangan);
			System.out.print("| "+tamp);

			space=(String) obj.get(nmkekurangan);
			System.out.print("              | "+ space);
			for (int j = 0; j  < 40 - (space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+----------------------------------------------------------+");
		}
		
	}
}
