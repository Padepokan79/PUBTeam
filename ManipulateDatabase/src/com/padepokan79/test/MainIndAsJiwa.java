package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdIndAsJiwaController;
import com.padepokan79.controller.MdKlaimTblController;

public class MainIndAsJiwa {
	
	//public Scanner keyboard = new Scanner(System.in);
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		MdIndAsJiwaController hs = new MdIndAsJiwaController();
		
		public MainIndAsJiwa(){
			mainMenu();
		}
		
		public void mainMenu(){
			System.out.println("1. Menampilkan data IndAsJiwa");
			System.out.println("2. Mencari data IndAsJiwa");
			System.out.println("3. Insert data IndAsJiwa");
			System.out.println("4. Update data IndAsJiwa");
			System.out.println("5. Delete data IndAsJiwa");
			
			try{
				System.out.print("Masukan PIlihan : ");
				String input = keyboard.readLine();
				switch(input){
				case "1":
					MenampilkanDataIndAsJiwa();
					break;
				case "2":
					MencariDataIndAsJiwa();
					break;
				case "3":
					InsertDataIndAsJiwa();
					break;
				case "4":
					UpdateDataIndAsJiwa();
					break;
				case "5":
					DeleteDataIndAsJiwa();
					break;
				default:
					System.out.println("Masukan anda tidak valid !");
				}
				
			}catch (Exception e) {
				System.out.println("Exception Print !");
				System.out.println(e.getMessage());
			}
		}
		
		
		public void MenampilkanDataIndAsJiwa(){
			try{
				JSONArray data = hs.getQuerySelectIndAsJiwa();
				showData(data, "nip", "nama", "kdpangkat", "kdjiwa");
			} catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
				 
			}
			
		}
		
		public void MencariDataIndAsJiwa(){
			try{
				System.out.print("Masukan Nip : "); 
				String nip= keyboard.readLine();
				JSONArray data = hs.getQueryCariIndAsJiwa(nip);
				showData(data, "nip", "nama", "kdpangkat", "kdjiwa");
			} catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}
		}
		
		public void InsertDataIndAsJiwa(){
			try{
				System.out.print("Masukan Nip : "); 
				String nip= keyboard.readLine();
				System.out.print("Masukan Nama : "); 
				String nama= keyboard.readLine();
				System.out.print("Masukan KdPangkat : "); 
				String kdpangkat= keyboard.readLine();
				System.out.print("Masukan KdJiwa : "); 
				String kdjiwa= keyboard.readLine();
				
			
				JSONArray data = hs.getQueryInsertIndAsJiwa(nip, nama, kdpangkat, kdjiwa);
				
			} catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}
			mainMenu();
		}
		
		public void UpdateDataIndAsJiwa(){
			try{
				System.out.print("Masukan Nama : "); 
				String nama= keyboard.readLine();
				System.out.print("Masukan Nip : "); 
				String nip= keyboard.readLine();
			
				JSONArray data = hs.getQueryUpdateIndAsJiwa(nama, nip);
				
			} catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}
			mainMenu();
		}

		public void DeleteDataIndAsJiwa(){
			try{
				System.out.print("Masukan Nip : "); 
				String nip= keyboard.readLine();
				JSONArray data = hs.getQueryDeleteIndAsJiwa(nip);
			} catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}
			mainMenu();
		}

		
		public  void showData(JSONArray arrayData,String nip, String nama, String kdpangkat, String kdjiwa) {
		
			System.out.println("+---------------------------------------------------------------------------------------+");
			System.out.println("|           nip             |         nama           |     kdpangka    |      kdjiwa    |");
			System.out.println("+---------------------------------------------------------------------------------------+");

			String space;

			for (int i = 0; i < arrayData.length(); i++) {
				JSONObject obj =  arrayData.getJSONObject(i);	

				space=(String) obj.get(nip);
				space=space.trim();
				System.out.print("|     "+ space);
				for (int j = 0; j  < 16 - (space.length()); j++) {
					System.out.print(" ");
				}
				
				space=(String) obj.get(nama);
				space=space.trim();
				System.out.print("      | "+ space);
				for (int j = 0; j  < 16 - (space.length()); j++) {
					System.out.print(" ");
				}
				
				space=(String) obj.get(kdpangkat);
				space=space.trim();
				System.out.print("       | "+ space);
				for (int j = 0; j  < 16 - (space.length()); j++) {
					System.out.print(" ");
				}
				
				space=(String) obj.get(kdjiwa);
				space=space.trim();
				System.out.print("|"+ space);
				for (int j = 0; j  < 16 - (space.length()); j++) {
					System.out.print(" ");
				}
				
				System.out.println("|");
				System.out.println("+---------------------------------------------------------------------------------------+");
			}
			
			mainMenu();
		}
		
		public static  void main(String args[]) {
			MainIndAsJiwa hs=new MainIndAsJiwa();
			hs.mainMenu();
		}

}
