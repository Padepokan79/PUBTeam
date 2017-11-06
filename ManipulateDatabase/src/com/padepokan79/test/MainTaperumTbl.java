package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;


import com.padepokan79.controller.MdTaperumTblController;
public class MainTaperumTbl {
		BufferedReader keyboard= new BufferedReader(new InputStreamReader(System.in));

			public  void testqueryReadAllTaperumTbl() {
				MdTaperumTblController bit = new MdTaperumTblController();
				
				try {
					JSONArray data = bit.ReadAllDataTaperum_tbl();
					showData(data,"nilai", "kdgol");
				} catch (Exception e) {	 
				
			}
			}
				public  void testQueryMencariDataTaperumTbl() {
					MdTaperumTblController bit = new MdTaperumTblController();
					
					try {
						System.out.print("Masukan Kode Gol : ");
						String tamp=keyboard.readLine();
						JSONArray data = bit.searchDataTaperum_tbl(tamp);
						showData(data,"nilai", "kdgol");
					} catch (Exception e) {
						System.out.println("Inputan Salah !");
						System.out.println(e.getMessage());
						 
					}
			
				
			}
				
				public  void testQueryInsertDataTaperumTbl() {
					MdTaperumTblController bit = new MdTaperumTblController();
					
					try {
						System.out.print("Masukan kode gol : ");
						String k=keyboard.readLine();
						int kdgol=Integer.parseInt(k);
						System.out.print("Masukan nilai : ");
						String n=keyboard.readLine();
						JSONArray data = bit.insertDataTaperum_tbl(kdgol,n);
					} catch (Exception e) {
						System.out.println("Inputan Salah !");
						System.out.println(e.getMessage());
						 
					}
			
				
			}
				public void testQueryUpdateDataTaperumTbl(){
					MdTaperumTblController bit = new MdTaperumTblController();
					
					try {
						
						System.out.print("Masukan Kode Gol yang akan di Update : ");
						String k=keyboard.readLine();
						int kdgol=Integer.parseInt(k);
						System.out.print("Masukan update Nilai : ");
						String n=keyboard.readLine();
						JSONArray data = bit.updateDataTaperum_tbl(n,kdgol);
					} catch (Exception e) {
						System.out.println("Inputan Salah !");
						System.out.println(e.getMessage());
						 
					}
					
				}
				
				public void testQueryDeleteDataTaperumTbl(){
					MdTaperumTblController bit = new MdTaperumTblController();
					
					try {
						
						System.out.print("Masukan Kode Gol yang akan di delete : ");
						String kd=keyboard.readLine();
						
						JSONArray data = bit.deleteDataTaperum_tbl(kd);
					} catch (Exception e) {
						System.out.println("Inputan Salah !");
						System.out.println(e.getMessage());
						 
					}
				}
				public  void backto()  {
					String inp;
					System.out.println("1. Data Taperum \n2. Mencari Data Berdasarkan Kode Gol  \n3.Insert Data  \n4.Update data \n5.Delete Data" );
					System.out.print("Masukan Pilihan : ");
					try {
						inp=keyboard.readLine();
						switch (inp) {
						case "1":
							testqueryReadAllTaperumTbl();
							break;
						case "2":
							testQueryMencariDataTaperumTbl();
							break;
						case "3" :
							testQueryInsertDataTaperumTbl();
							break;
						case "4" :
							testQueryUpdateDataTaperumTbl();
							break; 
						case "5" :
							testQueryDeleteDataTaperumTbl();
							break; 
						default:
							System.out.println("Masukan Salah !");
							
						}
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
					backto();
				}
				
			public void showData(JSONArray arrayData, String kdgol, String nilai){
				//System.out.println(arrayData);
				System.out.println("+---------------------------------------+");
				System.out.println("| Nilai        |   KD GOL               |");
				System.out.println("+---------------------------------------+");
				String space;
				int tamp;

				for (int i = 0; i < arrayData.length(); i++) {
					JSONObject obj =  arrayData.getJSONObject(i);	

					tamp=(int) obj.get(kdgol);
					System.out.print("|    "+tamp);

					space=(String) obj.get(nilai);
					System.out.print("      | "+ space);
					for (int j = 0; j  < 16 - (space.length()); j++) {
						System.out.print(" ");
					}
					System.out.println("  ");
					System.out.println("+---------------------------------------+");
				}
				backto();
				
				
			}
			public static void main(String args[]) {
				MainTaperumTbl mainTaperum = new MainTaperumTbl();
				mainTaperum.testqueryReadAllTaperumTbl();
			}
}
