package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;


import com.padepokan79.controller.MdHutangTblController;
public class MainHutangTbl {

	//MainActivity ma=new MainActivity();
		//public  Scanner keyboard = new Scanner( System.in );
		BufferedReader keyboard= new BufferedReader(new InputStreamReader(System.in));

		
		public  void testqueryReadAllHutangTbl() {
			MdHutangTblController bit = new MdHutangTblController();
			
			try {
				JSONArray data = bit.ReadAllDataHutang_tbl();
				showData(data,"kdhutang", "nmhutang");
			} catch (Exception e) {	 
			
		}
		}
			public  void testQueryMencariDataHutangTbl() {
				MdHutangTblController bit = new MdHutangTblController();
				
				try {
					System.out.print("Masukan Kode Hutang : ");
					String tamp=keyboard.readLine();
					JSONArray data = bit.searchDataHutang_tbl(tamp);
					showData(data,"kdhutang", "nmhutang");
				} catch (Exception e) {
					System.out.println("Inputan Salah !");
					System.out.println(e.getMessage());
					 
				}
		
			
		}
			
			public  void testQueryInsertDataHutangTbl() {
				MdHutangTblController bit = new MdHutangTblController();
				
				try {
					System.out.print("Masukan kode hutang : ");
					String k=keyboard.readLine();
					int kdhutang=Integer.parseInt(k);
					System.out.print("Masukan nama hutang : ");
					String nm=keyboard.readLine();
					JSONArray data = bit.insertDataHutang_tbl(kdhutang,nm);
				} catch (Exception e) {
					System.out.println("Inputan Salah !");
					System.out.println(e.getMessage());
					 
				}
		
			
		}
			public void testQueryUpdateDataHutangTbl(){
				MdHutangTblController bit = new MdHutangTblController();
				
				try {
					
					System.out.print("Masukan Kode Hutang yang akan di Update : ");
					String k=keyboard.readLine();
					int kdhutang=Integer.parseInt(k);
					System.out.print("Masukan update Nama Hutang : ");
					String nm=keyboard.readLine();
					JSONArray data = bit.updateDataHutang_tbl(nm,kdhutang);
				} catch (Exception e) {
					System.out.println("Inputan Salah !");
					System.out.println(e.getMessage());
					 
				}
				
			}
			
			public void testQueryDeleteDataHutangTbl(){
				MdHutangTblController bit = new MdHutangTblController();
				
				try {
					
					System.out.print("Masukan Kode Hutang yang akan di delete : ");
					String kd=keyboard.readLine();
					
					JSONArray data = bit.deleteDataHutang_tbl(kd);
					//showData(data,"kdeselon", "tmteselon","rp_eselon");
				} catch (Exception e) {
					System.out.println("Inputan Salah !");
					System.out.println(e.getMessage());
					 
				}
			}
			public  void backto()  {
				String inp;
				System.out.println("1. Data Hutang \n2. Mencari Data Berdasarkan Kode Hutang  \n3.Insert Data  \n4.Update data \n5.Delete Data" );
				System.out.print("Masukan Pilihan : ");
				try {
					inp=keyboard.readLine();
					switch (inp) {
					case "1":
						testqueryReadAllHutangTbl();
						break;
					case "2":
						testQueryMencariDataHutangTbl();
						break;
					case "3" :
						testQueryInsertDataHutangTbl();
						break;
					case "4" :
						testQueryUpdateDataHutangTbl();
						break; 
					case "5" :
						testQueryDeleteDataHutangTbl();
						break; 
					default:
						System.out.println("Masukan Salah !");
						
					}
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
				backto();
			}
			
		public void showData(JSONArray arrayData, String kdhutang, String nmhutang){
			System.out.println("+------------------------------------------------+");
			System.out.println("| Kode Hutang     | Nama Hutang                  |");
			System.out.println("+------------------------------------------------+");
			String space;
			int tamp;

			for (int i = 0; i < arrayData.length(); i++) {
				JSONObject obj =  arrayData.getJSONObject(i);	

				tamp=(int) obj.get(kdhutang);
				System.out.print("|       "+tamp);

				space=(String) obj.get(nmhutang);
				System.out.print("         | "+ space);
				for (int j = 0; j  < 16 - (space.length()); j++) {
					System.out.print(" ");
				}
				System.out.println("     ");
				System.out.println("+------------------------------------------------+");
			}
			backto();
			
			
		}
		public static void main(String args[]) {
			MainHutangTbl mainHutang = new MainHutangTbl();
			mainHutang.testqueryReadAllHutangTbl();
		}
}
