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
import com.padepokan79.controller.MdStapegTblController;

public class MdStapegTblTest {
	//public  Scanner keyboard = new Scanner( System.in );
	BufferedReader keyboard= new BufferedReader(new InputStreamReader(System.in));

	MdStapegTblController bit = new MdStapegTblController();
	public  void testqueryReadAll() {
		
		
		try {
			JSONArray data = bit.LihatData();
			showData(data,"kdstapeg", "nmstapeg", "kd_jns_peg");
		} catch (Exception e) {
			
			 
		}
	}
	
	public  void testqueryMencariDataBup() {
		
		try {
			System.out.print("Enter kd : ");
			String nip= keyboard.readLine();
			int kd=Integer.parseInt(nip);
			JSONArray data = bit.LihatData(kd);
			showData(data,"kdstapeg", "nmstapeg", "kd_jns_peg");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan karekter");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryDeleteDataBup() {
		
		try {
			System.out.print("Enter nip : ");
			String nip= keyboard.readLine();
			int kd=Integer.parseInt(nip);
			JSONArray data = bit.DeleteData(kd);
			//showData(data,"nip", "bup", "tgl_srt", "no_srt");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan karekter");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryUpdateDataBup() {
		
		try {
			System.out.print("Enter kdstapeg : ");
			String nip= keyboard.readLine();
			int kd=Integer.parseInt(nip);
			System.out.print("Enter nmstapeg : ");
			String b=keyboard.readLine();
			JSONArray data = bit.UpdateData(kd,b);
			//showData(data,"nip", "bup", "tgl_srt", "no_srt");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan karekter");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryInsertDataBup() {
		
		try {
			
			System.out.print("Enter kdstapeg : ");
			String a=keyboard.readLine();
			int kd=Integer.parseInt(a);
			System.out.print("Enter nmstapeg : ");
			String nm=keyboard.readLine();
			System.out.print("Enter kdjnstrans : ");
			String kdj=keyboard.readLine();
			int kdjns=Integer.parseInt(kdj);
		
			
			JSONArray data = bit.InsertData(kd, nm, kdjns);
			//showData(data,"nip", "bup", "tgl_srt", "no_srt");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public void menu() throws IOException {
		System.out.println("+============================MENU Stapeg_tbl============================+");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|1. ReadAll |  2. Search (KDs)   | 3. Insert	| 4. Update | 5. Delete |");
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
	public MdStapegTblTest() throws IOException {
		menu();
		//testqueryReadAllBupIndTbl();
		//testqueryMencariDataBup();
		//testqueryInsertDataBup();
	}
	public  void showData(JSONArray arrayData, String kd, String nm, String kdj) {
		System.out.println("+--------------------------------------------------------+");
		System.out.println("| KDStapeg |  nmStapeg                  |   kdjnsTrans   |");
		System.out.println("+--------------------------------------------------------+");
		int space;
		String tamp;
		//Date tamp1;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			space=(int) obj.get(kd);
			System.out.print("  "+space);
			
			tamp=(String) obj.get(nm);
			System.out.print("	   |  "+tamp);
			
			space=(int) obj.get(kdj);
			System.out.println("	  |  "+space);
			
			System.out.println("+--------------------------------------------------------+");
		}
	}
	
	public static void main(String args[]) throws IOException {
		MdStapegTblTest MdBup = new MdStapegTblTest();
		//MdBup.testqueryReadAllBupIndTbl();
	}
	
}
