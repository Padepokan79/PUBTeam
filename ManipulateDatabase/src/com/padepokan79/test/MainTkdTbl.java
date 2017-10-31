package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdStawinTblController;
import com.padepokan79.controller.MdTkdTblController;

public class MainTkdTbl {
	BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		MainTkdTbl tt=new MainTkdTbl();
		tt.menu();
	}
	
	public void menu() throws NumberFormatException, IOException {
		System.out.println("");
		System.out.println("+------------------------------------+");
		System.out.println("|        MENU TKD_TBL                |");
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
			testSelectTkdTbl();
			menu();
		}else if(tamp==2) {
			testInsertTkdTbl();
			menu();
		}else if(tamp==3) {
			testUpdateTkdTbl();
			menu();
		}else if(tamp==4) {
			testDeleteTkdTbl();
			menu();
		}else if(tamp==5) {
			testMencariTkdTbl();
			menu();
		}else {
			System.out.println("Pilihan tidak terdaftar");
			menu();
		}
	}
	
	public void testSelectTkdTbl() {
		MdTkdTblController tkdtbl=new MdTkdTblController();
		try {
			JSONArray data=tkdtbl.getQuerySelectAllTkdTbl();
			showData_tkdTbl(data,"tmt","kdtkd","nmtkd","tkd");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testMencariTkdTbl(){
		MdTkdTblController tkdtbl=new MdTkdTblController();
		try {
			System.out.println("Masukan nama TKD: ");
			String in=input.readLine();
			JSONArray data=tkdtbl.getQueryMencariTkdTbl(in);
			showData_tkdTbl(data,"tmt","kdtkd","nmtkd","tkd");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testUpdateTkdTbl() {
		MdTkdTblController tkdtbl=new MdTkdTblController();
		try {
			System.out.println("Masukan nama TKD baru: ");
			String nama=input.readLine();
			System.out.println("Masukan total TKD baru: ");
			int t=Integer.parseInt(input.readLine());
			System.out.println("Masukan tgl yang TKD nya akan diubah: ");
			String tgl=input.readLine();
			System.out.println("Masukan kode TKD yang nama TKD nya akan dibuah: ");
			int kode=Integer.parseInt(input.readLine());
			JSONArray data=tkdtbl.getQueryUpdateTkdTbl(nama, t, tgl, kode);
			//showData_tkdTbl(data,"tmt","kdtkd","nmtkd","tkd");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testDeleteTkdTbl() {
		MdTkdTblController tkdtbl=new MdTkdTblController();
		try {
			System.out.println("Masukan tanggal yang TKD nya akan dihapus: ");
			String tgl=input.readLine();
			System.out.println("Masukan kode yang TKD nya akan dihapus: ");
			int kode=Integer.parseInt(input.readLine());
			JSONArray data=tkdtbl.getQueryDeleteTkdTbl(tgl, kode);
			//showData_tkdTbl(data,"tmt","kdtkd","nmtkd","tkd");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testInsertTkdTbl() {
		MdTkdTblController tkdtbl=new MdTkdTblController();
		try {
			System.out.println("Masukan tanggal TKD baru: ");
			String tgl=input.readLine();
			System.out.println("Masukan kode TKD baru: ");
			int kode=Integer.parseInt(input.readLine());
			System.out.println("Masukan nama TKD baru: ");
			String nama=input.readLine();
			System.out.println("Masukan jumlah TKD baru: ");
			int t=Integer.parseInt(input.readLine());
			JSONArray data=tkdtbl.getQueryInsertTkdTbl(tgl, kode, nama, t);
			//showData_tkdTbl(data,"tmt","kdtkd","nmtkd","tkd");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public  void showData_tkdTbl(JSONArray arrayData, String tmt, String kdtkd, String nmtkd, String tkd) {
		System.out.println(arrayData);
		System.out.println("+------------------------------------------------------------------------+");
		System.out.println("|      TMT       |     KDTKD       |       NMTKD        |       TKD      |");
		System.out.println("+------------------------------------------------------------------------+");
		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			//System.out.println(obj.get(kdtkd));
			
			System.out.print("|      "+ obj.get(tmt));
			
			
			tamp=(int) obj.get(kdtkd);
			System.out.print("| "+ tamp);
			

			space=(String) obj.get(nmtkd);
			System.out.print("              | "+ space);
			for (int j = 0; j  < 20 - (space.length()); j++) {
				System.out.print(" ");
			}
			
			tamp=(int) obj.get(tkd);
			System.out.print("| "+ tamp);
			
			
			
			System.out.println("        |");
			System.out.println("+------------------------------------------------------------------------+");
		}
		
	}
}
