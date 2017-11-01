package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdLangkaTblController;


public class MainMdLangkaTbl {
	MdLangkaTblController mlt= new MdLangkaTblController();
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
			JSONArray data = mlt.getReadData();
			showData_LangkaTbl(data,"kdlangka","uraian_langka","jumlah");
			
			menu();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	public void testSearchData() {	
		try {
			int input;
			System.out.println("Masukkan kode langka:");
			input=Integer.parseInt(keyboard.readLine());
			JSONArray data = mlt.getSearchData(input);
			showData_LangkaTbl(data,"kdlangka","uraian_langka","jumlah");
			
			menu();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	public void testUpdateData() {
		try {
			int kdlangka;
			String uraian;
			System.out.print("Masukan kode langka yang akan di edit : ");
			kdlangka=Integer.parseInt(keyboard.readLine());
			System.out.print("Masukan uraian baru: ");
			uraian=keyboard.readLine();
			mlt.getUpdateData(uraian,kdlangka);
			menu();
		} catch (Exception e){
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		
		
		
	}
	public void testCreateData() {	
		try {
			System.out.print("Masukan kdlangka : ");
			int kdlangka=Integer.parseInt(keyboard.readLine());
			System.out.print("Masukan Uraian : ");
			String uraian=keyboard.readLine();
			System.out.print("Masukan jumlah : ");
			int jumlah=Integer.parseInt(keyboard.readLine());
			
			JSONArray data = mlt.getCreateData(kdlangka,uraian,jumlah);
			menu();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void testDeleteData() {	
		try {
			System.out.print("Masukan kdlangka yang akan di hapus : ");
			int kdlangka=Integer.parseInt(keyboard.readLine());
			
			JSONArray data = mlt.getDeleteData(kdlangka);
			menu();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
		
	}
	
	
	public void showData_LangkaTbl(JSONArray arrayData, String kdlangka, String uraian_langka,String jumlah) {
		System.out.println("+--------------------------------------+");
		System.out.println("| kdlangka |      uraian     | jumlah  |");
		System.out.println("+--------------------------------------+");
	
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);
			System.out.print("|    "+ obj.get(kdlangka));
			System.out.print("     |   "+  obj.get(uraian_langka));
			System.out.print("   | "+  obj.get(jumlah));
			System.out.println("    |");
			System.out.println("+--------------------------------------+");
			}
		
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		MainMdLangkaTbl mainmdlangkatbl = new MainMdLangkaTbl();
		mainmdlangkatbl.menu();
	}

}
