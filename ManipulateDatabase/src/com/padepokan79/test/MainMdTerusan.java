package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdterusanTblController;

public class MainMdTerusan {

	

		BufferedReader dataIn= new BufferedReader(new InputStreamReader(System.in));
		public void mainMenu () {

			System.out.println("+-------------------------------------------------------------------+");
			System.out.println("|                          Terusan Tbl                              |");
			System.out.println("|-------------------------------------------------------------------|");
			System.out.println("| 1. Read Data          | 2. Insert Data     | 3. Update Data       |");
			System.out.println("|-------------------------------------------------------------------|");
			System.out.println("| 4. Search Data        | 5. Delete Data     | 0. Menu Utama        |");
			System.out.println("+-------------------------------------------------------------------+");

			try {
				System.out.print("Masukan PIlihan : ");
				String input=dataIn.readLine();
				switch (input) {
				case "1":
					MenampilkanTerusan();
					break;
				case "2":
					MenambahkanTerusan();
					break;
				case "3":
					mengubahDataTerusan();
					break;
				case "4":
					mencariDataTerusan();
					break;
				case "5":
					hapusDataTerusan();
					break;
				case "0":
				default:
					System.out.println("Masukan anda tidak valid !");
				}

			} catch (Exception e) {
				System.out.println("Exception Print !");
				System.out.println(e.getMessage());
			}

		}

		//tmtgaji,nip,kdeselon,tjeselon
		public  void MenampilkanTerusan(){
			MdterusanTblController mc =new MdterusanTblController();
			JSONArray data = mc.getQueryMenampilkanDataTerusan(); 
			showData2(data,"nip","kdjnstrans");
		}

		public  void MenambahkanTerusan(){
			MdterusanTblController mc =new MdterusanTblController();
			String  nip;
			int KDJNSTRANS ;
			try{
				System.out.print("Masukan KOde transaksi : ");
				KDJNSTRANS=Integer.parseInt(dataIn.readLine());
				System.out.print("Masukan nip : ");
				nip=dataIn.readLine();
				
				mc.getQueryInsertDataTerusan(KDJNSTRANS, nip);
				mainMenu();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

		public  void mengubahDataTerusan(){
			MdterusanTblController mc =new MdterusanTblController();
			String nip;
			int KDJNSTRANS;
			try {
				System.out.print("Masukan KOde transaksi : ");
				KDJNSTRANS=Integer.parseInt(dataIn.readLine());
				System.out.print("Masukan nip : ");
				nip=dataIn.readLine();
				mc.getQueryUpdateDataTerusan(KDJNSTRANS, nip);
				mainMenu();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		public  void hapusDataTerusan() throws IOException{
			MdterusanTblController mc =new MdterusanTblController();
			String nip;

			System.out.print("Masukan Nip data yang ingin di hapus : ");
			nip=(dataIn.readLine());

			mc.getQueryDeleteDataTerusan(nip);
			mainMenu();
		}

		public  void mencariDataTerusan() throws IOException{
			MdterusanTblController mc =new MdterusanTblController();
			String nip;
			System.out.print("Masukan Nip data yang ingin di cari : ");
			nip=(dataIn.readLine());
			JSONArray data = mc.getQuerySearchTerusan(nip); 
			showData2(data,"nip","kdjnstrans");
		}

		public  void showData2(JSONArray arrayData,String nip ,String kdjnstrans) {
			//System.out.println(arrayData);
			System.out.println("+--------------------------------+");
			System.out.println("|         Nip       | Kode Trans |");
			System.out.println("+--------------------------------+");
			String space;

			for (int i = 0; i < arrayData.length(); i++) {
				JSONObject obj =  arrayData.getJSONObject(i);
				space= (String) obj.get(nip);
				space = space.trim();
				System.out.print("| "+space);
				for (int j = 0; j  <17-(space.length()); j++) {
					System.out.print(" ");
				}
				space=String.valueOf( obj.get(kdjnstrans));
				space = space.trim();

				System.out.print(" |    "+space );
				for (int j = 0; j  <3-(space.length()); j++) {
					System.out.print(" ");
				}
				System.out.println("    |");
				System.out.println("+--------------------------------+");
			}

			mainMenu();
		}


		public static void main(String args[]){
			MainMdTerusan nm=new MainMdTerusan();
			nm.mainMenu();
		}
	

}
