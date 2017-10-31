package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdStawinTblController;
//by ILFA SRI DESY
public class MainStawinTbl {
	BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		MainStawinTbl s=new MainStawinTbl();
		s.menu();
	}
	
	public void menu() throws NumberFormatException, IOException {
		System.out.println("");
		System.out.println("+------------------------------------+");
		System.out.println("|        MENU STAWIN_TBL             |");
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
			testSelectStawinTbl();
			menu();
		}else if(tamp==2) {
			testInsertStawinTbl();
			menu();
		}else if(tamp==3) {
			testUpdateStawinTbl();
			menu();
		}else if(tamp==4) {
			testDeleteStawinTbl();
			menu();
		}else if(tamp==5) {
			testMencariStawinTbl();
			menu();
		}else {
			System.out.println("Pilihan tidak terdaftar");
			menu();
		}
	}
	
	public void testSelectStawinTbl() {
		MdStawinTblController stawin=new MdStawinTblController();
		try {
			JSONArray data=stawin.getQuerySelectAllStawinTbl();
			showData_stawinTbl(data,"kdstawin","nmstawin");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testMencariStawinTbl(){
		MdStawinTblController stawin=new MdStawinTblController();
		try {
			System.out.println("Masukan nama status: ");
			String in=input.readLine();
			JSONArray data=stawin.getQueryMencariStawinTbl(in);
			showData_stawinTbl(data,"kdstawin","nmstawin");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testUpdateStawinTbl() {
		MdStawinTblController stawin=new MdStawinTblController();
		try {
			System.out.println("Masukan status baru: ");
			String n=input.readLine();
			System.out.println("Masukan kode yang statusnya akan diubah: ");
			int k=Integer.parseInt(input.readLine());
			JSONArray data=stawin.getQueryUpdateStawinTbl(n, k);
			//showData_stawinTbl(data,"kdstawin","nmstawin");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testDeleteStawinTbl() {
		MdStawinTblController stawin=new MdStawinTblController();
		try {
			System.out.println("Masukan kode yang statusnya akan dihapus: ");
			int k=Integer.parseInt(input.readLine());
			JSONArray data=stawin.getQueryDeleteStawinTbl(k);
			//showData_stawinTbl(data,"kdstawin","nmstawin");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testInsertStawinTbl() {
		MdStawinTblController stawin=new MdStawinTblController();
		try {
			System.out.println("Masukan kode status baru: ");
			int k=Integer.parseInt(input.readLine());
			System.out.println("Masukan status baru: ");
			String n=input.readLine();
			JSONArray data=stawin.getQueryInsertStawinTbl(k, n);
			//showData_stawinTbl(data,"kdstawin","nmstawin");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public  void showData_stawinTbl(JSONArray arrayData, String kdstawin, String nmstawin) {
		System.out.println(arrayData);
		System.out.println("+----------------------------------+");
		System.out.println("| Kode Stawin    | Nama Stawin     |");
		System.out.println("+----------------------------------+");
		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			tamp=(int) obj.get(kdstawin);
			System.out.print("| "+tamp);

			space=(String) obj.get(nmstawin);
			System.out.print("              | "+ space);
			for (int j = 0; j  < 16 - (space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+----------------------------------+");
		}
		
	}
}
