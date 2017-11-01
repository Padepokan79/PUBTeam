package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdZakatTblController;

public class MainZakatTbl {
	BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
	MdZakatTblController hs = new MdZakatTblController();
	
	public MainZakatTbl(){
		mainMenu();
	}
	
	public void mainMenu(){
		System.out.println("1. Menampilkan data Zakat Tbl");
		System.out.println("2. Mencari data Zakat Tbl");
		System.out.println("3. Insert data Zakat Tbl");
		System.out.println("4. Update data Zakat Tbl");
		System.out.println("5. Delete data Zakat Tbl");
		
		try{
			System.out.print("Masukan PIlihan : ");
			String input = keyboard.readLine();
			switch(input){
			case "1":
				MenampilkanDataZakatTbl();
				break;
			case "2":
				MencariDataZakatTbl();
				break;
			case "3":
				InsertDataZakatTbl();
				break;
			case "4":
				UpdateDataZakatTbl();
				break;
			case "5":
				DeleteDataZakatTbl();
				break;
			default:
				System.out.println("Masukan anda tidak valid !");
			}
			
		}catch (Exception e) {
			System.out.println("Exception Print !");
			System.out.println(e.getMessage());
		}
	}
	
	
	public void MenampilkanDataZakatTbl(){
		try{
			JSONArray data = hs.getQuerySelectZakatTbl();
			showData(data,"nip", "blthgaji", "kdjnstrans", "nilai");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
		
	}
	
	public void MencariDataZakatTbl(){
		try{
			System.out.print("Masukan Nip : "); 
			String nip= keyboard.readLine();
			JSONArray data = hs.getQueryCariZakatTbl(nip);
			showData(data,"nip", "blthgaji", "kdjnstrans", "nilai");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	
	public void InsertDataZakatTbl(){
		try{
			System.out.print("Masukan Nip : "); 
			String nip= keyboard.readLine();
			System.out.print("Masukan BlThGaji : "); 
			String blthgaji= keyboard.readLine();
			System.out.print("Masukan KdjnsTrans : "); 
			int kdjnstrans= Integer.parseInt(keyboard.readLine());
			System.out.print("Masukan Kode : "); 
			int kode= Integer.parseInt(keyboard.readLine());
			System.out.print("Masukan Nilai : "); 
			int nilai= Integer.parseInt(keyboard.readLine());
		
			JSONArray data = hs.getQueryInsertZakatTbl(nip, blthgaji, kdjnstrans, kode, nilai);
			//backto();
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		mainMenu();
	}
	
	public void UpdateDataZakatTbl(){
		try{
			System.out.print("Masukan Nilai : "); 
			int nilai=Integer.parseInt(keyboard.readLine());
			System.out.print("Masukan Nip : "); 
			String nip= keyboard.readLine();
		
			JSONArray data = hs.getQueryUpdateZakatTbl(nilai,nip);
			//backto();
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		mainMenu();
	}
	
	public void DeleteDataZakatTbl(){
		try{
			System.out.print("Masukan Nip : "); 
			String nip= keyboard.readLine();
			JSONArray data = hs.getQueryDeleteZakatTbl(nip);
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		mainMenu();
	}
	
	
	public  void showData(JSONArray arrayData,String nip, String blthgaji, String kdjnstrans, String nilai) {
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		System.out.println("|     nip            |         blthgaji            |        kdjnstrans         |       nilai    |");
		System.out.println("+-----------------------------------------------------------------------------------------------+");

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			System.out.print("|         "+obj.get(nip));

			System.out.print("              | "+obj.get(blthgaji));
			System.out.print("              | "+obj.get(kdjnstrans));
			System.out.print("              | "+obj.get(nilai));
		
			System.out.println("|");
			System.out.println("+----------------------------------+");
		}

		mainMenu();
	}
	
	public static  void main(String args[]) {
		MainZakatTbl hs=new MainZakatTbl();
		hs.mainMenu();
	}
	
}
