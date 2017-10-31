package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdKlaimTblController;

public class MainKlaimTbl {

	//public Scanner keyboard = new Scanner(System.in);
	BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
	MdKlaimTblController hs = new MdKlaimTblController();
	
	public MainKlaimTbl(){
		mainMenu();
	}
	
	public void mainMenu(){
		System.out.println("1. Menampilkan data KlaimTbl");
		System.out.println("2. Mencari data KlaimTbl");
		System.out.println("3. Insert data KlaimTbl");
		System.out.println("4. Update data KlaimTbl");
		System.out.println("5. Delete data KlaimTbl");
		
		try{
			System.out.print("Masukan PIlihan : ");
			String input = keyboard.readLine();
			switch(input){
			case "1":
				MenampilkanDataKlaimTbl();
				break;
			case "2":
				MencariDataKlaimTbl();
				break;
			case "3":
				InsertDataKlaimTbl();
				break;
			case "4":
				UpdateDataKlaimTbl();
				break;
			case "5":
				DeleteDataKlaimTbl();
				break;
			default:
				System.out.println("Masukan anda tidak valid !");
			}
			
		}catch (Exception e) {
			System.out.println("Exception Print !");
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public void MenampilkanDataKlaimTbl(){
		try{
			JSONArray data = hs.getQuerySelectKlaimTbl();
			showData(data, "kdklaim", "kdproduk", "kdkelompok", "nmklaim");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
		
	}
	
	public void MencariDataKlaimTbl(){
		try{
			System.out.print("Masukan KdKlaim : "); 
			String kdklaim= keyboard.readLine();
			JSONArray data = hs.getQueryCariKlaimTbl(kdklaim);
			showData(data, "kdklaim", "kdproduk", "kdkelompok", "nmklaim");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	
	public void InsertDataKlaimTbl(){
		try{
			System.out.print("Masukan KdKlaim : "); 
			String kdklaim= keyboard.readLine();
			System.out.print("Masukan KdProduk : "); 
			int kdproduk= Integer.parseInt(keyboard.readLine());
			System.out.print("Masukan KdKelompok : "); 
			int kdkelompok= Integer.parseInt(keyboard.readLine());
			System.out.print("Masukan NmKlaim : "); 
			String nmklaim= keyboard.readLine();
		
			JSONArray data = hs.getQueryInsertKlaimTbl(kdklaim, kdproduk, kdkelompok, nmklaim);
			//backto();
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		mainMenu();
	}
	
	public void UpdateDataKlaimTbl(){
		try{
			System.out.print("Masukan NmKlaim : "); 
			String nmklaim= keyboard.readLine();
			System.out.print("Masukan KdKlaim : "); 
			String kdklaim= keyboard.readLine();
		
			JSONArray data = hs.getQueryUpdateKlaimTbl(nmklaim, kdklaim);
			//backto();
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		
		mainMenu();
	}

	public void DeleteDataKlaimTbl(){
		try{
			System.out.print("Masukan KdKlaim : "); 
			String kdklaim= keyboard.readLine();
			JSONArray data = hs.getQueryDeleteKlaimTbl(kdklaim);
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		
		mainMenu();
	}

	
	public  void showData(JSONArray arrayData,String kdklaim, String kdproduk, String kdkelompok, String nmklaim) {
	
		System.out.println("+--------------------------------------------------------------------------------------------------+");
		System.out.println("|    kdklaim            |         kdproduk            |        kdkelompok       |       nmklaim    |");
		System.out.println("+--------------------------------------------------------------------------------------------------+");

		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(kdklaim);
			System.out.print("|     "+ space);
			for (int j = 0; j  < 16 - (space.length()); j++) {
				System.out.print(" ");
			}
			
			
			tamp=(int) obj.get(kdproduk);
			System.out.print(" | "+tamp);
			
			tamp=(int) obj.get(kdkelompok);
			System.out.print("| "+tamp);
			
			space=(String) obj.get(nmklaim);
			System.out.print("              | "+ space);
			for (int j = 0; j  < 16 - (space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+----------------------------------+");
		}
		
		mainMenu();
	}
	
	public static  void main(String args[]) {
		MainKlaimTbl hs=new MainKlaimTbl();
		hs.mainMenu();
	}
}
