package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;


import com.padepokan79.controller.MdEselonTblController;

public class MainEselonTbl {

	//MainActivity ma=new MainActivity();
	//public  Scanner keyboard = new Scanner( System.in );
	BufferedReader keyboard= new BufferedReader(new InputStreamReader(System.in));

	
	public  void testqueryReadAllEselonTbl() {
		MdEselonTblController bit = new MdEselonTblController();
		
		try {
			JSONArray data = bit.ReadAllDataEselon_tbl();
			showData(data,"kdeselon", "tmteselon","rp_eselon");
		} catch (Exception e) {	 
		
	}
	}
		public  void testQueryMencariDataEselonTbl() {
			MdEselonTblController bit = new MdEselonTblController();
			
			try {
				System.out.print("Masukan Kode Eselon : ");
				String tamp=keyboard.readLine();
				JSONArray data = bit.searchDataEselon_tbl(tamp);
				showData(data,"kdeselon", "tmteselon","rp_eselon");
			} catch (Exception e) {
				System.out.println("Inputan Salah !");
				System.out.println(e.getMessage());
				 
			}
	
		
	}
		
		public  void testQueryInsertDataEselonTbl() {
			MdEselonTblController bit = new MdEselonTblController();
			
			try {
				System.out.print("Masukan TMT Eselon : ");
				String tmt=keyboard.readLine();
				System.out.print("Masukan Kode Eselon : ");
				String kd=keyboard.readLine();
				System.out.print("Masukan RP Eselon : ");
				String r=keyboard.readLine();
				int rp=Integer.parseInt(r);
				System.out.print("Masukan Uraian : ");
				String uraian=keyboard.readLine();
				System.out.print("Masukan BUP : ");
				String b=keyboard.readLine();
				int bup=Integer.parseInt(b);
				JSONArray data = bit.insertDataEselon_tbl(tmt,kd,rp,uraian,bup);
				//showData(data,"kdeselon", "tmteselon","rp_eselon");
			} catch (Exception e) {
				System.out.println("Inputan Salah !");
				System.out.println(e.getMessage());
				 
			}
	
		
	}
		public void testQueryUpdateDataEselonTbl(){
			MdEselonTblController bit = new MdEselonTblController();
			
			try {
				
				System.out.print("Masukan Kode Eselon yang akan di Update : ");
				String kd=keyboard.readLine();
				System.out.print("Masukan update RP Eselon : ");
				String r=keyboard.readLine();
				int rp=Integer.parseInt(r);
				JSONArray data = bit.updateDataEselon_tbl(rp,kd);
				//showData(data,"kdeselon", "tmteselon","rp_eselon");
			} catch (Exception e) {
				System.out.println("Inputan Salah !");
				System.out.println(e.getMessage());
				 
			}
			
		}
		
		public void testQueryDeleteDataEselonTbl(){
			MdEselonTblController bit = new MdEselonTblController();
			
			try {
				
				System.out.print("Masukan Kode Eselon yang akan di delete : ");
				String kd=keyboard.readLine();
				
				JSONArray data = bit.deleteDataEselon_tbl(kd);
				//showData(data,"kdeselon", "tmteselon","rp_eselon");
			} catch (Exception e) {
				System.out.println("Inputan Salah !");
				System.out.println(e.getMessage());
				 
			}
		}
		public  void backto()  {
			String inp;
			System.out.println("1. Data Eselon 2.  Mencari Data Berdasarkan Kode Eselon  3.Insert Data  4.Update data 5.Delete Data" );
			System.out.print("Masukan Pilihan : ");
			try {
				inp=keyboard.readLine();
				switch (inp) {
				case "1":
					testqueryReadAllEselonTbl();
					break;
				case "2":
					testQueryMencariDataEselonTbl();
					break;
				case "3" :
					testQueryInsertDataEselonTbl();
					break;
				case "4" :
					testQueryUpdateDataEselonTbl();
					break; 
				case "5" :
					testQueryDeleteDataEselonTbl();
					break; 
				default:
					System.out.println("Masukan Salah !");
					
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			backto();
		}
		
	public void showData(JSONArray arrayData, String kdeselon, String tmteselon, String rp_eselon){
	//	System.out.println(arrayData);
		System.out.println("+-------------------------------------------------+");
		System.out.println("|  KDESELON     | TMTESELON     | RP_ESELON       |");
		System.out.println("+-------------------------------------------------+");
		String space;
		int tamp;
		Date tamp1;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			

			space=(String) obj.get(kdeselon);
			System.out.print("  "+ space);
			
			tamp1=(Date) obj.get(tmteselon);
			System.out.print("            | "+tamp1);
			
			tamp=(int) obj.get(rp_eselon);
			System.out.print("    | "+tamp);
	
			System.out.println("          ");
			System.out.println("+-------------------------------------------------+");
		}
	backto();	
	}
	public static void main(String args[]) {
		MainEselonTbl mainEselon = new MainEselonTbl();
		mainEselon.testqueryReadAllEselonTbl();
	}
}

