package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdHistorisSatkerController;


public class MainMdHistorisSatker {
	BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
	MdHistorisSatkerController mhs= new MdHistorisSatkerController();
	
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
			JSONArray data = mhs.getReadData();
			showData_HistorisSatker(data,"tmtgaji","nip","kdsatker","keterangan");
			
			menu();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	public void testSearchData() {	
		try {
			String input;
			System.out.println("Masukkan nip:");
			input=keyboard.readLine();
			JSONArray data = mhs.getSearchData(input);
			showData_HistorisSatker(data,"tmtgaji","nip","kdsatker","keterangan");
			menu();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	public void testUpdateData() {
		try {
			String tmtgaji;
			String nip;
			String keterangan;
			System.out.print("Masukan tmtgaji yang akan di edit : ");
			tmtgaji=keyboard.readLine();
			System.out.print("Masukan nip yang akan di edit : ");
			nip=keyboard.readLine();
			System.out.print("Masukan keterangan baru: ");
			keterangan=keyboard.readLine();
			mhs.getUpdateData(keterangan,tmtgaji,nip);
			menu();
		} catch (Exception e){
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		
		
		
	}
	public void testCreateData() {	
		try {
			System.out.print("Masukan tmtgaji : ");
			String tmtgaji=keyboard.readLine();
			System.out.print("Masukan nip : ");
			String nip=keyboard.readLine();
			System.out.print("Masukan kdssbp : ");
			String kdssbp=keyboard.readLine();
			System.out.print("Masukan kdskpd : ");
			String kdskpd=keyboard.readLine();
			System.out.print("Masukan kdsatker : ");
			String kdsatker=keyboard.readLine();
			System.out.print("Masukan tglskep : ");
			String tglskep=keyboard.readLine();
			System.out.print("Masukan nomorskep : ");
			String nomorskep=keyboard.readLine();
			System.out.print("Masukan penerbitskep : ");
			String penerbitskep=keyboard.readLine();
			System.out.print("Masukan keterangan : ");
			String keterangan=keyboard.readLine();
			System.out.print("Masukan tglupdate : ");
			String tglupdate=keyboard.readLine();
			System.out.print("Masukan updater : ");
			String updater=keyboard.readLine();
			
			JSONArray data = mhs.getCreateData(tmtgaji,nip,kdssbp,kdskpd,kdsatker,tglskep,nomorskep,penerbitskep,keterangan,tglupdate,updater);
			menu();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void testDeleteData() {	
		try {
			System.out.print("Masukan tmtgaji yang akan di hapus : ");
			String tmtgaji=keyboard.readLine();
			System.out.print("Masukan nip yang akan di hapus : ");
			String nip=keyboard.readLine();
			JSONArray data = mhs.getDeleteData(tmtgaji,nip);
			menu();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
		
	}
	
	
	public void showData_HistorisSatker(JSONArray arrayData, String tmtgaji, String nip,String kdsatker,String keterangan) {
		System.out.println("+---------------------------------------------------------------------+");
		System.out.println("|    tmtgaji   |         nip       |       kdsatker      |  keterangan  |");
		System.out.println("+---------------------------------------------------------------------+");
	
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);
			System.out.print("| "+ obj.get(tmtgaji));
			System.out.print("   | "+  obj.get(nip));
			System.out.print("| "+  obj.get(kdsatker));
			System.out.print("| "+  obj.get(keterangan));
			System.out.println("  |");
			System.out.println("+---------------------------------------------------------------------+");
			}
		
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		MainMdHistorisSatker mainhistorissatker=new MainMdHistorisSatker();
		mainhistorissatker.menu();
	}

}
