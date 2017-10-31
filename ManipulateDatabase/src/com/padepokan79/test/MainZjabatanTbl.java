package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdZjabatanTblController;

public class MainZjabatanTbl {
	
	
	BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
	MdZjabatanTblController hs = new MdZjabatanTblController();
	
	public MainZjabatanTbl(){
		mainMenu();
	}
	
	public void mainMenu(){
		System.out.println("1. Menampilkan data ZjabatanTbl");
		System.out.println("2. Mencari data ZjabatanTbl");
		System.out.println("3. Insert data ZjabatanTbl");
		System.out.println("4. Update data ZjabatanTbl");
		System.out.println("5. Delete data ZjabatanTbl");

		try{
			System.out.print("Masukan PIlihan : ");
			String input = keyboard.readLine();
			switch(input){
			case "1":
				MenampilkanDataZjabatanTbl();
				mainMenu();
				break;
			case "2":
				MencariDataZjabatanTbl();
				mainMenu();
				break;
			case "3":
				InsertDataZjabatanTbl();
				mainMenu();
				break;
			case "4":
				UpdateDataZjabatanTbl();
				mainMenu();
				break;
			case "5":
				DeleteDataZjabatanTbl();
				mainMenu();
				break;
			default:
				System.out.println("Masukan anda tidak valid !");
			}
			
		}catch (Exception e) {
			System.out.println("Exception Print !");
			System.out.println(e.getMessage());
		}
	}
	
	
	public void MenampilkanDataZjabatanTbl(){
		try{
			JSONArray data = hs.getQuerySelectZjabatanTbl();
			showData(data, "jml_r", "nmjabatan", "jml", "pensiun");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
		
	}
	
	public void MencariDataZjabatanTbl(){
		try{
			System.out.print("Masukan KdJabatan : "); 
			String kdjabatan= keyboard.readLine();
			JSONArray data = hs.getQueryCariZjabatanTbl(kdjabatan);
			showData(data, "jml_r", "nmjabatan", "jml", "pensiun");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	
	public void InsertDataZjabatanTbl(){
		try{
			System.out.print("Masukan Jml_r : "); 
			int jml_r= Integer.parseInt(keyboard.readLine());
			System.out.print("Masukan TmtJabatan : "); 
			String tmtjabatan= keyboard.readLine();
			System.out.print("Masukan KdJabatan : "); 
			String kdjabatan= keyboard.readLine();
			System.out.print("Masukan NmJabatan : "); 
			String nmjabatan= keyboard.readLine();
			System.out.print("Masukan Jml : "); 
			int jml= Integer.parseInt(keyboard.readLine());
			System.out.print("Masukan Pensiun : "); 
			int pensiun= Integer.parseInt(keyboard.readLine());
			System.out.print("Masukan KdFungsi : "); 
			int kdfungsi= Integer.parseInt(keyboard.readLine());
		
			JSONArray data = hs.getQueryInsertZjabatanTbl(jml_r,tmtjabatan,kdjabatan,nmjabatan,jml,pensiun,kdfungsi);
			
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		
		mainMenu();
	}
	
	public void UpdateDataZjabatanTbl(){
		try{
			System.out.print("Masukan NmJabatan : "); 
			String nmjabatan= keyboard.readLine();
			System.out.print("Masukan KdJabatan: "); 
			String kdjabatan= keyboard.readLine();
		
			JSONArray data = hs.getQueryUpdateZjabatanTbl(nmjabatan, kdjabatan);
			//backto();
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		
		mainMenu();
	}

	public void DeleteDataZjabatanTbl(){
		try{
			System.out.print("Masukan Kdjabatan : "); 
			String kdjabatan= keyboard.readLine();
			JSONArray data = hs.getQueryDeleteZjabatanTbl(kdjabatan);
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		
		mainMenu();
	}

	
	public  void showData(JSONArray arrayData,String jml_r, String nmjabatan, String jml, String pensiun) {
	
		System.out.println("+--------------------------------------------------------------------------------------------------+");
		System.out.println("|    jml_r            |         nmjabatan           |        jml         |       pensiun           |");
		System.out.println("+--------------------------------------------------------------------------------------------------+");

		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			System.out.print("|         "+obj.get(jml_r));
			
			space=(String) obj.get(nmjabatan);
			System.out.print("|     "+ space);
			for (int j = 0; j  < 16 - (space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.print("|         "+obj.get(jml));
			
			System.out.print("|         "+obj.get(pensiun));
			System.out.println("|");
			System.out.println("+----------------------------------+");
		}
		
		mainMenu();
	}
	
	public static  void main(String args[]) {
		MainZjabatanTbl hs=new MainZjabatanTbl();
		hs.mainMenu();
	}
}
