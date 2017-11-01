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
import com.padepokan79.controller.MdJiwaPtkpController;

public class MdJiwaPtkpTest {
	//public  Scanner keyboard = new Scanner( System.in );
	BufferedReader keyboard= new BufferedReader(new InputStreamReader(System.in));

	MdJiwaPtkpController bit = new MdJiwaPtkpController();
	public  void testqueryReadAll() {
		
		
		try {
			JSONArray data = bit.LihatData();
			showData(data,"nip", "tahun", "jistri", "janak");
		} catch (Exception e) {
			
			 
		}
	}
	
	public  void testqueryMencariDataBup() {
		
		try {
			System.out.print("Enter nip : ");
			String nip= keyboard.readLine();
			JSONArray data = bit.LihatData(nip);
			showData(data,"nip", "tahun", "jistri", "janak");
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
			System.out.print("Enter janak : ");
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
			System.out.print("Enter tahun : ");
			String a=keyboard.readLine();
			int tahun=Integer.parseInt(a);
			System.out.print("Enter janak : ");
			String b=keyboard.readLine();
			int janak=Integer.parseInt(b);
			System.out.print("Enter jistri : ");
			String c=keyboard.readLine();
			int jistri=Integer.parseInt(c);
		
			
			JSONArray data = bit.InsertData(nip, tahun, jistri, janak);
			//showData(data,"nip", "bup", "tgl_srt", "no_srt");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public void menu() throws IOException {
		System.out.println("+=============================MENU jiwaptkp=============================+");
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
	public MdJiwaPtkpTest() throws IOException {
		menu();
		//testqueryReadAllBupIndTbl();
		//testqueryMencariDataBup();
		//testqueryInsertDataBup();
	}
	public  void showData(JSONArray arrayData, String nip, String tahun, String jistri, String janak) {
		System.out.println("+--------------------------------------------------------+");
		System.out.println("| NIP 			|  TAHUN  |   JISTRI |   JANAK   |");
		System.out.println("+--------------------------------------------------------+");
		int space;
		String tamp;
		//Date tamp1;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			tamp=(String) obj.get(nip);
			System.out.print("  "+tamp);
			
			space=(int) obj.get(tahun);
			System.out.print("	|  "+space);
			
			space=(int) obj.get(jistri);
			System.out.print("	  |  "+space);
			
			space=(int) obj.get(janak);
			System.out.println("       |   "+space);
			
			System.out.println("+--------------------------------------------------------+");
		}
	}
	
	public static void main(String args[]) throws IOException {
		MdJiwaPtkpTest MdBup = new MdJiwaPtkpTest();
		//MdBup.testqueryReadAllBupIndTbl();
	}
	
}
