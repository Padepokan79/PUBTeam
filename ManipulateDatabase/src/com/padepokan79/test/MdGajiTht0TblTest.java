package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.Agama;
import com.padepokan79.controller.MdBupIndTblController;
import com.padepokan79.controller.MdGajiTht0TblController;
import com.padepokan79.controller.MdJiwaPtkpController;

public class MdGajiTht0TblTest {
	//public  Scanner keyboard = new Scanner( System.in );
	BufferedReader keyboard= new BufferedReader(new InputStreamReader(System.in));

	MdGajiTht0TblController bit = new MdGajiTht0TblController();
	public  void testqueryReadAll() {
		
		
		try {
			JSONArray data = bit.LihatData();
			showData(data,"nip", "tglgaji", "kdjnstrans", "gapok");
		} catch (Exception e) {
			
			 
		}
	}
	
	public  void testqueryMencariDataBup() {
		
		try {
			System.out.print("Enter nip : ");
			String nip= keyboard.readLine();
			JSONArray data = bit.LihatData(nip);
			showData(data,"nip", "tglgaji", "kdjnstrans", "gapok");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan karekter");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryDeleteDataBup() {
		
		try {
			System.out.print("Enter nip : ");
			String nip= keyboard.readLine();
			JSONArray data = bit.DeleteData(nip);
			//showData(data,"nip", "bup", "tgl_srt", "no_srt");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan karekter");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryUpdateDataBup() {
		
		try {
			System.out.print("Enter nip : ");
			String nip= keyboard.readLine();
			System.out.print("Enter gapok : ");
			String b=keyboard.readLine();
			int janak=Integer.parseInt(b);
			JSONArray data = bit.UpdateData(nip,janak);
			//showData(data,"nip", "bup", "tgl_srt", "no_srt");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan karekter");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryInsertDataBup() {
		
		try {
			System.out.print("Enter NIP : ");
			String nip=keyboard.readLine();
			System.out.print("Enter tgl gaji : ");
			String tglgaji=keyboard.readLine();
			System.out.print("Enter kdjnstrans : ");
			String b=keyboard.readLine();
			int kdtrans=Integer.parseInt(b);
			System.out.print("Enter gapok : ");
			String c=keyboard.readLine();
			int gapok=Integer.parseInt(c);
		
			
			JSONArray data = bit.InsertData(nip,tglgaji, kdtrans, gapok, "", 0, "", "", "0000-00-00 00:00:00", "", "2017-10-31");
			//showData(data,"nip", "bup", "tgl_srt", "no_srt");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public void menu() throws IOException {
		System.out.println("+==========================MENU GajiTht0Tbl=============================+");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|1. ReadAll |  2. Search (NIP)   | 3. Insert	| 4. Update | 5. Delete |");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.print("Enter your choice : ");
		String p= keyboard.readLine();
		int pil=Integer.parseInt(p);
		if (pil==1) {
			testqueryReadAll();
		}else if(pil==2) {
			testqueryMencariDataBup();
		}else if(pil==3) {
			testqueryInsertDataBup();
		}else if(pil==4) {
			testqueryUpdateDataBup();
		}else if(pil==5) {
			testqueryDeleteDataBup();
		}else {
			System.out.println("Inputan tidak tersedia!");
		}
		menu();
	}
	public MdGajiTht0TblTest() throws IOException {
		menu();
		//testqueryReadAllBupIndTbl();
		//testqueryMencariDataBup();
		//testqueryInsertDataBup();
	}
	public  void showData(JSONArray arrayData, String nip, String tglgaji, String kdtrans, String gapok) {
		System.out.println(arrayData);
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("| NIP 			|     Tglgaji   | kdjnstrans |     gapok     |");
		System.out.println("+--------------------------------------------------------------------+");
		int space;
		String space1;
		Date tamp1;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			space1=(String) obj.get(nip);
			System.out.print("  "+space1);
			
			tamp1=(Date) obj.get(tglgaji);
			System.out.print("	|  "+tamp1);
			
			space=(int) obj.get(kdtrans);
			System.out.print("	|  "+space);
			
			space=(int) obj.get(gapok);
			System.out.println("         |   "+space);
			
			System.out.println("+--------------------------------------------------------------------+");
		}
	}
	
	public static void main(String args[]) throws IOException {
		MdGajiTht0TblTest MdBup = new MdGajiTht0TblTest();
		//MdBup.testqueryReadAllBupIndTbl();
	}
	
}
