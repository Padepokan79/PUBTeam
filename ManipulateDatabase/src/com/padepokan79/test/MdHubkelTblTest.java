package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdBupIndTblController;
import com.padepokan79.controller.MdHubkelTblController;

public class MdHubkelTblTest {

BufferedReader keyboard= new BufferedReader(new InputStreamReader(System.in));

	
	public  void testqueryReadAllHubkelTbl() {
		MdHubkelTblController bit = new MdHubkelTblController();
		
		try {
			JSONArray data = bit.LihatData();
			showData(data,"nmhubkel", "kdhubkel");
		} catch (Exception e) {
			
			 
		}
	}
	
	public  void testqueryMencariData() {
		MdHubkelTblController bit = new MdHubkelTblController();
		
		try {
			System.out.print("Enter KDHUBKEL : ");
			String nip= keyboard.readLine();
			JSONArray data = bit.LihatData(nip);
			showData(data,"nmhubkel", "kdhubkel");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan karekter");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryInsertData() {
		MdHubkelTblController bit = new MdHubkelTblController();
		
		try {
			System.out.print("Enter KDHUBKEL : ");
			String KD= keyboard.readLine();
			System.out.print("Enter NMHUBKEL : ");
			String b=keyboard.readLine();
			JSONArray data = bit.InsertData(KD,b);
			//showData(data,"nip", "bup", "tgl_srt", "no_srt");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan karekter");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryUpdateData() {
		MdHubkelTblController bit = new MdHubkelTblController();
		
		try {
			System.out.print("Enter kdhubkel : ");
			String kd= keyboard.readLine();
			System.out.print("Enter nmhubkel : ");
			String nm=keyboard.readLine();
			
			JSONArray data = bit.UpdateData(kd,nm);
			//showData(data,"nip", "bup", "tgl_srt", "no_srt");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan karekter");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryDeleteData() {
		MdHubkelTblController bit = new MdHubkelTblController();
		
		try {
			System.out.print("Enter KDHUBKEL : ");
			String nip= keyboard.readLine();
			JSONArray data = bit.DeleteData(nip);
			//showData(data,"nip", "bup", "tgl_srt", "no_srt");
		} catch (Exception e) {
			System.out.println("Inputan Salah, masukan karekter");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void showData(JSONArray arrayData, String NMHUBKEL, String KDHUBKEL) {
		//System.out.println(arrayData);
		System.out.println("+-------------------------------------+");
		System.out.println("| KDHUBKEL 	|        NMHUBKEL     |");
		System.out.println("+-------------------------------------+");
	
		String tamp;
		

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			tamp=(String) obj.get(KDHUBKEL);
			System.out.print("      "+tamp);
			
			tamp=(String) obj.get(NMHUBKEL);
			System.out.println("        |  "+tamp);
			System.out.println("+-------------------------------------+");
		}
		
	}
	
	public void menu() throws IOException {
		System.out.println("+============================MENU Hubkel_Tbl============================+");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|1. ReadAll |  2. Search (KD)   | 3. Insert	 | 4. Update | 5. Delete|");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.print("Enter your choice : ");
		String p= keyboard.readLine();
		int pil=Integer.parseInt(p);
		if (pil==1) {
			testqueryReadAllHubkelTbl();
		}else if(pil==2) {
			testqueryMencariData();
		}else if(pil==3) {
			testqueryInsertData();
		}else if(pil==4) {
			testqueryUpdateData();
		}else if(pil==5) {
			testqueryDeleteData();
		}else {
			System.out.println("Inputan tidak tersedia!");
		}
		menu();
	}
	
	public static void main(String args[]) throws IOException {
		MdHubkelTblTest Mdhub = new MdHubkelTblTest();
		Mdhub.menu();
	
	}
}
