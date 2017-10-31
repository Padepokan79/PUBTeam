package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdKompensasiRampungController;

public class MainKompensasiRampung {
	BufferedReader in= new BufferedReader(new InputStreamReader(System.in));

	
	public  void View(){
		MdKompensasiRampungController m =new MdKompensasiRampungController();
		JSONArray data = m.getViewQuery(); 
		showData(data,"tglgaji","nip","telah","harus");
	}
	
	public  void Edit(){
		MdKompensasiRampungController m =new MdKompensasiRampungController();
		String tmtgaji, nip, telah,  harus;
		
		try{
			System.out.print("Masukan tanggal mulai tugas (yyyy-mm-dd) : ");
			tmtgaji=in.readLine();
			System.out.print("Masukan Nip : ");
			nip=in.readLine();
		/*	System.out.print("Apakah Telah melakukan kompensasi (1= Ya / 0=Tidak): ");
			telah=in.readLine();
			int tlh = Integer.parseInt(telah);
			System.out.print("Apakah harus melakukan kompensasi (1= Ya / 0=Tidak): ");
		harus=in.readLine();
			int hrs = Integer.parseInt(harus);*/	
			m.getUpdateQuery(tmtgaji, nip);
			//mainMenu();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public  void Search() throws IOException {
		MdKompensasiRampungController m =new MdKompensasiRampungController();
		String nip;
		System.out.print("Masukan nip : ");
		nip=in.readLine();
		JSONArray data = m.getSearchQuery(nip); 
		showData(data,"tglgaji","nip","telah","harus");
	}
	
	public  void Add(){
		MdKompensasiRampungController m =new MdKompensasiRampungController();
		String tmtgaji, nip, telah,  harus;
		
		try{
			System.out.print("Masukan tanggal mulai tugas (yyyy-mm-dd) : ");
			tmtgaji=in.readLine();
			System.out.print("Masukan Nip : ");
			nip=in.readLine();
			System.out.print("Apakah Telah melakukan kompensasi (1= Ya / 0=Tidak): ");
			telah=in.readLine();
			int tlh = Integer.parseInt(telah);
			System.out.print("Apakah harus melakukan kompensasi (1= Ya / 0=Tidak): ");
			harus=in.readLine();
			int hrs = Integer.parseInt(harus);
			m.getQueryInsert(tmtgaji,nip,tlh,hrs);
			//mainMenu();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void Delete() throws IOException{
		MdKompensasiRampungController m =new MdKompensasiRampungController();
		String nip;

		System.out.print("Masukan Nip data yang ingin dihapus : ");
		nip=in.readLine();

		m.getDeleteQuery(nip);
		
	}



	public  void showData(JSONArray arrayData,String tgl ,String fieldnip, String telah, String harus) {
		//System.out.println(arrayData);
		System.out.println("+---------------------------------------------------------------------+");
		System.out.println("|      Tgl Gaji     |            NIP           |  Telah  |     Harus  |");
		System.out.println("+---------------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			System.out.print("|   "+obj.get(tgl));
			space=(String) obj.get(fieldnip);
			space = space.trim();

			System.out.print("      | "+space);
			for (int j = 0; j  <25-(space.length()); j++) {
				System.out.print(" ");
			}
			space=String.valueOf( obj.get(telah));
			space = space.trim();

			System.out.print("| "+space);
			for (int j = 0; j  <5-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("  | ");
			space=String.valueOf(obj.get(harus));
			space = space.trim();
			for (int j = 0; j  <10-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println(space +"  |");
			System.out.println("+---------------------------------------------------------------------+");
		}

	
	}
	public static void main(String[] args) throws IOException{
		MainKompensasiRampung mk = new MainKompensasiRampung();
		mk.Edit();
		mk.View();
	}

}
