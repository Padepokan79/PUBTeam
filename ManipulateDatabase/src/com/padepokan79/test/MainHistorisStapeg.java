package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;


import org.json.JSONArray;
import org.json.JSONObject;


import com.padepokan79.controller.MdHistorisStapegController;


public class MainHistorisStapeg {
	BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
	MdHistorisStapegController hs = new MdHistorisStapegController();
	
	public MainHistorisStapeg(){
		mainMenu();
	}
	
	public void mainMenu(){
		System.out.println("1. Menampilkan data Historis Stapeg");
		System.out.println("2. Mencari data Historis Stapeg");
		System.out.println("3. Insert data Historis Stapeg");
		System.out.println("4. Update data Historis Stapeg");
		System.out.println("5. Delete data Historis Stapeg");
		
		try{
			System.out.print("Masukan PIlihan : ");
			String input = keyboard.readLine();
			switch(input){
			case "1":
				MenampilkanDataHistorisStapeg();
				break;
			case "2":
				MencariDataHistorisStapeg();
				break;
			case "3":
				InsertDataHistorisStapeg();
				break;
			case "4":
				UpdateDataHistorisStapeg();
				break;
			case "5":
				DeleteDataHistorisStapeg();
				break;
			default:
				System.out.println("Masukan anda tidak valid !");
			}
			
		}catch (Exception e) {
			System.out.println("Exception Print !");
			System.out.println(e.getMessage());
		}
	}

	
	public void MenampilkanDataHistorisStapeg(){
		try{
			JSONArray data = hs.getQuerySelectHistorisStapeg();
			showData(data,"tmtgaji", "nip", "kdstapeg", "keterangan");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
		
	}
	
	public void MencariDataHistorisStapeg(){
		try{
			System.out.print("Masukan Nip : "); 
			String nip= keyboard.readLine();
			JSONArray data = hs.getQueryCariHistorisStapeg(nip);
			showData(data,"tmtgaji", "nip", "kdstapeg", "keterangan");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	
	public void InsertDataHistorisStapeg(){
		try{
			System.out.print("Masukan Tmtgaji : "); 
			String tmtgaji= keyboard.readLine();
			System.out.print("Masukan Nip : "); 
			String nip= keyboard.readLine();
			System.out.print("Masukan Kdstapeg : "); 
			int kdstapeg= Integer.parseInt(keyboard.readLine());
			System.out.print("Masukan Keterangan : "); 
			String keterangan= keyboard.readLine();
		
			JSONArray data = hs.getQueryInsertHistorisStapeg(tmtgaji,nip,kdstapeg,keterangan);
			
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		
		mainMenu();
	}
	
	public void UpdateDataHistorisStapeg(){
		try{
			System.out.print("Masukan Kdstapeg : "); 
			int kdstapeg=Integer.parseInt(keyboard.readLine());
			System.out.print("Masukan Nip : "); 
			String nip= keyboard.readLine();
		
			JSONArray data = hs.getQueryUpdateHistorisStapeg(kdstapeg,nip);
			//backto();
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		
		mainMenu();
	}
	
	public void DeleteDataHistorisStapeg(){
		try{
			System.out.print("Masukan Nip : "); 
			String nip= keyboard.readLine();
			JSONArray data = hs.getQueryDeleteHistorisStapeg(nip);
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
		
		mainMenu();
	}
	
	
	public  void showData(JSONArray arrayData,String tmtgaji, String nip, String kdstapeg, String keterangan) {
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		System.out.println("|   tmtgaji            |         nip            |        kdstapeg         |       Keterangan    |");
		System.out.println("+-----------------------------------------------------------------------------------------------+");

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			System.out.print("|  "+obj.get(tmtgaji));

			System.out.print("          | "+obj.get(nip));
			System.out.print("          | "+obj.get(kdstapeg));
			System.out.print("              | "+obj.get(keterangan));
		
			System.out.println("|");
			System.out.println("+-----------------------------------------------------------------------------------------------+");
		}

		mainMenu();
	}
	
	public static  void main(String args[]) {
		MainHistorisStapeg hs=new MainHistorisStapeg();
		hs.mainMenu();
	}
	
}
