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

public class MdBupIndTblTest {
	//public  Scanner keyboard = new Scanner( System.in );
	BufferedReader keyboard= new BufferedReader(new InputStreamReader(System.in));

	MdBupIndTblController bit = new MdBupIndTblController();
	
	public  void testqueryReadAllBupIndTbl() {
		
		try {
			JSONArray data = bit.LihatData();
			showData(data,"nip", "bup", "tgl_srt", "no_srt");
		} catch (Exception e) {
			
			 
		}
	}
	
	public  void testqueryMencariDataBup() {
		
		try {
			System.out.print("Enter nip : ");
			String nip= keyboard.readLine();
			JSONArray data = bit.LihatData(nip);
			showData(data,"nip", "bup", "tgl_srt", "no_srt");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan karekter");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryDeleteDataBup() {
		
		try {
			System.out.print("Enter nip : ");
			String nip= keyboard.readLine();
			JSONArray data = bit.DeleteBup(nip);
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
			System.out.print("Enter bup : ");
			String b=keyboard.readLine();
			int bup=Integer.parseInt(b);
			JSONArray data = bit.UpdateBup(nip,bup);
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
			System.out.print("Enter bup : ");
			String b=keyboard.readLine();
			int bup=Integer.parseInt(b);
			System.out.print("Masukan Tgl : ");
			String tgl=keyboard.readLine();
			//Date tgl=Date.valueOf(t);
			System.out.print("Enter letter's number : ");
			String num=keyboard.readLine();
			JSONArray data = bit.InsertBup(nip, bup,tgl, num);
			//showData(data,"nip", "bup", "tgl_srt", "no_srt");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public void menu() throws IOException {
		System.out.println("+==========================MENU bup_ind_tbl=============================+");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|1. ReadAll |  2. Search (NIP)   | 3. Insert	| 4. Update | 5. Delete |");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.print("Enter your choice : ");
		String p= keyboard.readLine();
		int pil=Integer.parseInt(p);
		if (pil==1) {
			testqueryReadAllBupIndTbl();
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
	public MdBupIndTblTest() throws IOException {
		menu();
		//testqueryReadAllBupIndTbl();
		//testqueryMencariDataBup();
		//testqueryInsertDataBup();
	}
	public  void showData(JSONArray arrayData, String nip, String bup, String tgl_srt, String no_srt) {
		System.out.println("+--------------------------------------------------------+");
		System.out.println("| NIP 			|  bup   |    tgl_srt	| no_srt |");
		System.out.println("+--------------------------------------------------------+");
		int space;
		String tamp;
		Date tamp1;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			tamp=(String) obj.get(nip);
			System.out.print("| "+tamp);
			
			space=(int) obj.get(bup);
			System.out.print("	|  "+space);
			
			tamp1=(Date) obj.get(tgl_srt);
			System.out.print("	 |  "+tamp1);
			
			tamp=(String) obj.get(no_srt);
			System.out.println("  |   "+tamp+"	 |");
			
			System.out.println("+--------------------------------------------------------+");
		}
	}
	
	public static void main(String args[]) throws IOException {
		MdBupIndTblTest MdBup = new MdBupIndTblTest();
		//MdBup.testqueryReadAllBupIndTbl();
	}
	
}
