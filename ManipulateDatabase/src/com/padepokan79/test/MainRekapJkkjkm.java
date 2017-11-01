package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdRekapJkkjkmController;


public class MainRekapJkkjkm {
	BufferedReader keyboard= new BufferedReader(new InputStreamReader(System.in));

	public  void testqueryReadAllRekapjkkjkm() {
		MdRekapJkkjkmController bit = new MdRekapJkkjkmController();
		
		try {
			JSONArray data = bit.ReadAllDataRekapJkkjkm();
			showData(data,"kdskpd", "tglgaji","kdjnstrans");
		} catch (Exception e) {	 
		
	}
	}
		public  void testQueryMencariDataRekapJkkjkm() {
			MdRekapJkkjkmController bit = new MdRekapJkkjkmController();
			
			try {
				System.out.print("Masukan Kode Jenis Transaksi : ");
				String tamp=keyboard.readLine();
				JSONArray data = bit.searchDataRekapJkkjkm(tamp);
				showData(data,"kdskpd", "tglgaji","kdjnstrans");
			} catch (Exception e) {
				System.out.println("Inputan Salah !");
				System.out.println(e.getMessage());
				 
			}
	
		
	}
	
			public  void testQueryInsertDataRekapJkkjkm() {
			MdRekapJkkjkmController bit = new MdRekapJkkjkmController();
			
			try {
				System.out.print("Masukan tglgaji : ");
				String tgl=keyboard.readLine();
				System.out.print("Masukan kode Jenis Transaksi : ");
				String k=keyboard.readLine();
				int kdJns=Integer.parseInt(k);
				System.out.print("Masukan kdskpd : ");
				String kds=keyboard.readLine();
				System.out.print("Masukan kdsatker : ");
				String kdsat=keyboard.readLine();
				System.out.print("Masukan Gapok : ");
				String g=keyboard.readLine();
				int gap=Integer.parseInt(g);
				System.out.print("Masukan iuran_jkk : ");
				String i1=keyboard.readLine();
				int jkk=Integer.parseInt(i1);
				System.out.print("Masukan iuran_jkm : ");
				String i2=keyboard.readLine();
				int jkm=Integer.parseInt(i2);
				System.out.print("Masukan updstamp : ");
				String up=keyboard.readLine();
				JSONArray data = bit.insertDataRekapJkkjkm(tgl,kdJns,kds,kdsat,gap,jkk,jkm,up);
			} catch (Exception e) {
				System.out.println("Inputan Salah !");
				System.out.println(e.getMessage());
				 
			}
	
		
	}
		public void testQueryUpdateDataRekapJkkjkm(){
			MdRekapJkkjkmController bit = new MdRekapJkkjkmController();
			
			try {
				
				System.out.print("Masukan Kode Jenis TRansaksi yang akan di Update : ");
				String k=keyboard.readLine();
				int kd=Integer.parseInt(k);
				System.out.print("Masukan update kdskpd : ");
				String kds=keyboard.readLine();
				JSONArray data = bit.updateDataRekapJkkjkm(kds,kd);
			} catch (Exception e) {
				System.out.println("Inputan Salah !");
				System.out.println(e.getMessage());
				 
			}
			
		}
		
		public void testQueryDeleteDataRekapJkkjkm(){
			MdRekapJkkjkmController bit = new MdRekapJkkjkmController();
			
			try {
				
				System.out.print("Masukan Kode Jenis Trans yang akan di delete : ");
				String kd=keyboard.readLine();
				
				JSONArray data = bit.deleteDataRekapjkkjkm(kd);
			} catch (Exception e) {
				System.out.println("Inputan Salah !");
				System.out.println(e.getMessage());
				 
			}
		}
		public  void backto()  {
			String inp;
			System.out.println("1. Data RekapJkkjkm \n2. Mencari Data Berdasarkan Kode Jenis Transaksi  \n3.Insert Data  \n4.Update data \n5.Delete Data" );
			System.out.print("Masukan Pilihan : ");
			try {
				inp=keyboard.readLine();
				switch (inp) {
				case "1":
					testqueryReadAllRekapjkkjkm();
					break;
				case "2":
					testQueryMencariDataRekapJkkjkm();
					break;
				case "3" :
					testQueryInsertDataRekapJkkjkm();
					break;
				case "4" :
					testQueryUpdateDataRekapJkkjkm();
					break; 
				case "5" :
					testQueryDeleteDataRekapJkkjkm();
					break; 
				default:
					System.out.println("Masukan Salah !");
					
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			backto();
		}
		
		
	public void showData(JSONArray arrayData, String kdskpd,String  tglgaji, String kdjns){
		//System.out.println(arrayData);
		System.out.println("+-------------------------------------------------+");
		System.out.println("| kdskpd        | tglgaji       | kdjnstrans      |");
		System.out.println("+-------------------------------------------------+");
		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(kdskpd);
			System.out.print("|  "+ space);
			
			Date space1=(Date) obj.get(tglgaji);
			System.out.print("          |     "+ space1);
			
			tamp=(int) obj.get(kdjns);
			System.out.print("|    "+tamp);

			
			for (int j = 0; j  < 16 - (space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("  ");
			System.out.println("+-------------------------------------------------+");
		}
		backto();
		
		
	}
	public static void main(String args[]) {
		MainRekapJkkjkm mainRekapJkkjkm = new MainRekapJkkjkm();
		mainRekapJkkjkm.testqueryReadAllRekapjkkjkm();
	}
}
