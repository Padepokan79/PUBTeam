package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdIuranJkkjkmController;
import com.padepokan79.controller.MdJabatanKhususTblController;
//by ILFA SRI DESY
public class MainIuranJkkjkm {
	BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		MainIuranJkkjkm i=new MainIuranJkkjkm();
		i.menu();
	}
	
	public void menu() throws NumberFormatException, IOException {
		System.out.println("");
		System.out.println("+------------------------------------+");
		System.out.println("|        MENU IURAN_JKKJKM           |");
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
			testSelectIuranJkkjkm();
			menu();
		}else if(tamp==2) {
			testInsertIuranJkkjkm();
			menu();
		}else if(tamp==3) {
			testUpdateIuranJkkjkm();
			menu();
		}else if(tamp==4) {
			testDeleteIuranJkkjkm();
			menu();
		}else if(tamp==5) {
			testMencariIuranJkkjkm();
			menu();
		}else {
			System.out.println("Pilihan tidak terdaftar");
			menu();
		}
	}
	
	public void testSelectIuranJkkjkm() {
		MdIuranJkkjkmController ii=new MdIuranJkkjkmController();
		try {
			JSONArray data=ii.getQuerySelectAllIuranJkkjkm();
			showData_iuranJkkjkm(data, "nip", "tglgaji", "kdjnstrans", "iuran_jkk", "iuran_jkm");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testMencariIuranJkkjkm(){
		MdIuranJkkjkmController ii=new MdIuranJkkjkmController();
		try {
			System.out.println("Masukan nip: ");
			String in=input.readLine();
			JSONArray data=ii.getQueryMencariIuranJkkjkm(in);
			showData_iuranJkkjkm(data, "nip", "tglgaji", "kdjnstrans", "iuran_jkk", "iuran_jkm");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testUpdateIuranJkkjkm() {
		MdIuranJkkjkmController ii=new MdIuranJkkjkmController();
		try {
			
			System.out.println("Masukan iuran jkk baru: ");
			int jk=Integer.parseInt(input.readLine());
			System.out.println("Masukan iuran jkm baru: ");
			int jm=Integer.parseInt(input.readLine());
			System.out.println("Masukan nip yang iuran nya akan diubah: ");
			String nip=input.readLine();
			System.out.println("Masukan tgl yang iuran nya akan diubah: ");
			String tgl=input.readLine();
			System.out.println("Masukan kode jenis trans yang iuran nya akan diubah: ");
			int kode=Integer.parseInt(input.readLine());
			JSONArray data=ii.getQueryUpdateIuranJkkjkm(jk, jm, nip, tgl, kode);
			//showData_iuranJkkjkm(data, "nip", "tglgaji", "kdjnstrans", "iuranjkk", "iuranjkm");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testDeleteIuranJkkjkm() {
		MdIuranJkkjkmController ii=new MdIuranJkkjkmController();
		try {
			System.out.println("Masukan nip yang iuran nya akan dihapus: ");
			String nip=input.readLine();
			System.out.println("Masukan tgl yang iuran nya akan dihapus: ");
			String tgl=input.readLine();
			System.out.println("Masukan kode jenis trans yang iuran nya akan dihapus: ");
			int kode=Integer.parseInt(input.readLine());
			JSONArray data=ii.getQueryDeleteIuranJkkjkm(nip, tgl, kode);
			//showData_iuranJkkjkm(data, "nip", "tglgaji", "kdjnstrans", "iuranjkk", "iuranjkm");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testInsertIuranJkkjkm() {
		MdIuranJkkjkmController ii=new MdIuranJkkjkmController();
		try {
			System.out.println("Masukan nip iuran baru: ");
			String nip=input.readLine();
			System.out.println("Masukan tgl iuran baru: ");
			String tgl=input.readLine();
			System.out.println("Masukan kode jenis trans iuran baru: ");
			int kode=Integer.parseInt(input.readLine());
			System.out.println("Masukan iuran jkk baru: ");
			int jk=Integer.parseInt(input.readLine());
			System.out.println("Masukan iuran jkm baru: ");
			int jm=Integer.parseInt(input.readLine());
			
			JSONArray data=ii.getQueryInsertIuranJkkjkm(nip, tgl, kode, jk, jm);
			//showData_iuranJkkjkm(data, "nip", "tglgaji", "kdjnstrans", "iuranjkk", "iuranjkm");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void showData_iuranJkkjkm(JSONArray arrayData,String nip, String tglgaji, String kdjnstrans, String iuran_jkk, String iuran_jkm) {
		System.out.println(arrayData);
		System.out.println("+--------------------------------------------------------------------------------------------------------------+");
		System.out.println("|          nip                 |   tanggal gaji     |kode jenis trans|     iuran jkk      |      iuran jkm     |");
		System.out.println("+--------------------------------------------------------------------------------------------------------------+");
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
			
			System.out.print("|     "+obj.get(tglgaji)+"     ");
			System.out.print("|        "+obj.get(kdjnstrans)+"       ");
			System.out.print("|      "+obj.get(iuran_jkk)+"       ");
			System.out.print("|       "+obj.get(iuran_jkm)+"      ");
			

	
			System.out.println("|");
			System.out.println("+--------------------------------------------------------------------------------------------------------------+");
		}
		
	}
}
