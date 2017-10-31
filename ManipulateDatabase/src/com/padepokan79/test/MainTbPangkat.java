package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdTbPangkatController;

//by ILFA SRI DESY
public class MainTbPangkat {
	BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		MainTbPangkat tp=new MainTbPangkat();
		tp.menu();
	}
	
	public void menu() throws NumberFormatException, IOException {
		System.out.println("");
		System.out.println("+------------------------------------+");
		System.out.println("|        MENU TB PANGKAT             |");
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
			testSelectTbPangkat();
			menu();
		}else if(tamp==2) {
			testInsertTbPangkat();
			menu();
		}else if(tamp==3) {
			testUpdateTbPangkat();
			menu();
		}else if(tamp==4) {
			testDeleteTbPangkat();
			menu();
		}else if(tamp==5) {
			testMencariTbPangkat();
			menu();
		}else {
			System.out.println("Pilihan tidak terdaftar");
			menu();
		}
	}
	
	public void testSelectTbPangkat() {
		MdTbPangkatController mpc=new MdTbPangkatController();
		try {
			JSONArray data=mpc.getQuerySelectAllTbPangkat();
			showData_tbPangkat(data, "pkt010", "pkt020", "pkt030", "pkt040", "pkt050");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testMencariTbPangkat(){
		MdTbPangkatController mpc=new MdTbPangkatController();
		try {
			System.out.println("Masukan pkt010: ");
			String in=input.readLine();
			JSONArray data=mpc.getQueryMencariTbPangkat(in);
			showData_tbPangkat(data, "pkt010", "pkt020", "pkt030", "pkt040", "pkt050");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testUpdateTbPangkat() {
		MdTbPangkatController mpc=new MdTbPangkatController();
		try {
			
			System.out.println("Masukan pkt030 baru: ");
			String pkt030=input.readLine();
			
			System.out.println("Masukan pkt010 yang pkt030 nya akan diubah: ");
			String pkt010=input.readLine();
			
			JSONArray data=mpc.getQueryUpdateTbPangkat(pkt030, pkt010);
			//showData_TbPangkat(data, "nip", "nama", "tgllhr", "agama");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testDeleteTbPangkat() {
		MdTbPangkatController mpc=new MdTbPangkatController();
		try {
			System.out.println("Masukan pkt010 yang data nya akan dihapus: ");
			String pkt010=input.readLine();
			JSONArray data=mpc.getQueryDeleteTbPangkat(pkt010);
			//showData_TbPangkat(data, "nip", "nama", "tgllhr", "agama");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testInsertTbPangkat() {
		MdTbPangkatController mpc=new MdTbPangkatController();
		try {
			System.out.println("Masukan pkt010 data baru: ");
			String pkt010=input.readLine();
			System.out.println("Masukan pkt020 data baru: ");
			String pkt020=input.readLine();
			System.out.println("Masukan pkt030 data baru: ");
			String pkt030=input.readLine();
			System.out.println("Masukan pkt040 data baru: ");
			String pkt040=input.readLine();
			System.out.println("Masukan pkt050 data baru: ");
			String pkt050=input.readLine();
			
			mpc.getQueryInsertTbPangkat(pkt010, pkt020, pkt030, pkt040, pkt050);
			//showData_TbPangkat(data, "nip", "nama", "tgllhr", "agama");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void showData_tbPangkat(JSONArray arrayData,String pkt010, String pkt020, String pkt030, String pkt040, String pkt050) {
		System.out.println(arrayData);
		System.out.println("+-------------------------------------------------------------------+");
		System.out.println("|PKT010|  PKT020   |           PKT030             |  PKT040  |PKT050|");
		System.out.println("+-------------------------------------------------------------------+");
		String space;
		int tamp;
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			space=(String) obj.get(pkt010);
			space = space.trim();
			System.out.print("|  "+space);
			for (int j = 0; j  <4-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(pkt020);
			space = space.trim();
			System.out.print("|   "+space);
			for (int j = 0; j  <8-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(pkt030);
			space = space.trim();
			System.out.print("|  "+space);
			for (int j = 0; j  <28-(space.length()); j++) {
				System.out.print(" ");
			}
			
			
			space=(String) obj.get(pkt040);
			space = space.trim();
			System.out.print("|  "+space);
			for (int j = 0; j  <8-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(pkt050);
			space = space.trim();
			System.out.print("|  "+space);
			for (int j = 0; j  <4-(space.length()); j++) {
				System.out.print(" ");
			}
			
			
			System.out.println("|");
			System.out.println("+-------------------------------------------------------------------+");
		}
		
	}

}
