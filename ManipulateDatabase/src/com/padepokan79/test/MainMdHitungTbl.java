package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdHitungTblController;




public class MainMdHitungTbl {
	MdHitungTblController mht= new MdHitungTblController();
	BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
	
	
	public void menu() throws NumberFormatException, IOException  {
		int inp;
		System.out.println("1. Read Data");
		System.out.println("2. Search Data");
		System.out.println("3. Update Data");
		System.out.println("4. Create Data");
		System.out.println("5. Delete Data");
		System.out.println("=======================================");
		System.out.print("Masukan Pilihan : ");
			inp=Integer.parseInt(keyboard.readLine());
			if(inp==1) {
				testReadData();
			}else if(inp==2) {
				testSearchData();
			}else if(inp==3) {
				testUpdateData();
			}else if(inp==4) {
				testCreateData();
			}else if(inp==5) {
				testDeleteData();
			}else {
				System.out.println("Masukan Salah !");
			}
		
	}
	
	public void testReadData() {
		try {
			JSONArray data = mht.getReadData();
			showData_HitungTbl(data,"kdhitung","nmhitung");
			
			menu();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	public void testSearchData() {	
		try {
			int input;
			System.out.println("Masukkan kode hitung:");
			input=Integer.parseInt(keyboard.readLine());
			JSONArray data = mht.getSearchData(input);
			showData_HitungTbl(data,"kdhitung","nmhitung");
			
			menu();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	public void testUpdateData() {
		try {
			int kdhitung;
			String nama;
			System.out.print("Masukan kode hitung yang akan di edit : ");
			kdhitung=Integer.parseInt(keyboard.readLine());
			System.out.print("Masukan nama hitung baru: ");
			nama=keyboard.readLine();
			mht.getUpdateData(nama,kdhitung);
			menu();
		} catch (Exception e){
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		
		
		
	}
	public void testCreateData() {	
		try {
			System.out.print("Masukan kdhitung : ");
			int kdhitung=Integer.parseInt(keyboard.readLine());
			System.out.print("Masukan Nama Hitung Baru : ");
			String nmhitung=keyboard.readLine();
			
			JSONArray data = mht.getCreateData(kdhitung,nmhitung);
			menu();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void testDeleteData() {	
		try {
			System.out.print("Masukan kdhitung yang akan di hapus : ");
			int kdhitung=Integer.parseInt(keyboard.readLine());
			
			JSONArray data = mht.getDeleteData(kdhitung);
			menu();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
		
	}
	
	
	public void showData_HitungTbl(JSONArray arrayData, String kdhitung, String nama_hitung) {
		System.out.println("+---------------------------------+");
		System.out.println("| kdlangka |      namahitung      |");
		System.out.println("+---------------------------------+");
	
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);
			System.out.print("|    "+ obj.get(kdhitung));
			System.out.print("     |   "+  obj.get(nama_hitung));
			System.out.println("    |");
			System.out.println("+--------------------------------------+");
			}
		
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		MainMdHitungTbl mainmdhitungtbl = new MainMdHitungTbl();
		mainmdhitungtbl.menu();
	}
}
