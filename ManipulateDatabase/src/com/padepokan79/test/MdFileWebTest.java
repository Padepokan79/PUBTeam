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
import com.padepokan79.controller.MdFileWebController;
import com.padepokan79.controller.MdJiwaPtkpController;

public class MdFileWebTest {
	//public  Scanner keyboard = new Scanner( System.in );
	BufferedReader keyboard= new BufferedReader(new InputStreamReader(System.in));

	MdFileWebController bit = new MdFileWebController();
	public  void testqueryReadAll() {
		
		
		try {
			JSONArray data = bit.LihatData();
			showData(data,"namafile");
		} catch (Exception e) {
			
			 
		}
	}
	
	public  void testqueryMencariDataBup() {
		
		try {
			System.out.print("Enter file name : ");
			String nip= keyboard.readLine();
			JSONArray data = bit.LihatData(nip);
			showData(data,"namafile");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan karekter");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryDeleteDataBup() {
		
		try {
			System.out.print("Enter file name : ");
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
			System.out.print("Enter namafile lama : ");
			String lama= keyboard.readLine();
			System.out.print("Enter namafile baru : ");
			String baru=keyboard.readLine();
			JSONArray data = bit.UpdateData(lama,baru);
			//showData(data,"nip", "bup", "tgl_srt", "no_srt");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan karekter");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryInsertDataBup() {
		
		try {
			System.out.print("Enter Nama file : ");
			String nmfile=keyboard.readLine();
		
			
			JSONArray data = bit.InsertData(nmfile);
			//showData(data,"nip", "bup", "tgl_srt", "no_srt");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public void menu() throws IOException {
		System.out.println("+===============================MENU FileWeb===================================+");
		System.out.println("+------------------------------------------------------------------------------+");
		System.out.println("|1. ReadAll |  2. Search (nameFile)   | 3. Insert	| 4. Update | 5. Delete|");
		System.out.println("+------------------------------------------------------------------------------+");
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
	public MdFileWebTest() throws IOException {
		menu();
		//testqueryReadAllBupIndTbl();
		//testqueryMencariDataBup();
		//testqueryInsertDataBup();
	}
	public  void showData(JSONArray arrayData, String nmfile) {
		System.out.println("+---------------------------------------------------------------------------+");
		System.out.println("| 	                               nama file                                           |");
		System.out.println("+---------------------------------------------------------------------------+");
		int space;
		String tamp;
		//Date tamp1;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			tamp=(String) obj.get(nmfile);
			System.out.println("  "+tamp);
			
			
			System.out.println("+---------------------------------------------------------------------------+");
		}
	}
	
	public static void main(String args[]) throws IOException {
		MdFileWebTest MdBup = new MdFileWebTest();
		//MdBup.testqueryReadAllBupIndTbl();
	}
	
}
