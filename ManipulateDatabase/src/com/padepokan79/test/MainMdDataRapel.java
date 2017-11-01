package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdDataRapelController;

public class MainMdDataRapel {
public  Scanner keyboard = new Scanner( System.in );
BufferedReader dataIn= new BufferedReader(new InputStreamReader(System.in));

public void mainMenu () {

	System.out.println("+-------------------------------------------------------------------+");
	System.out.println("|                       Historis Eselon                             |");
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
			testMenampilkanDataRapel();
			break;
		case "2":
			testqueryMenambahDataRapel();
			break;
		case "3":
			MengubahNamaDataRapel();
			break;
		case "4":
			testqueryMencariDataRapel();
			break;
		case "5":
			hapusDataRapel();
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
	
	public  void testqueryMencariDataRapel() {
		MdDataRapelController dr = new MdDataRapelController();
		
		try {
			System.out.print("Masukan Nama : ");
			String inputKode=keyboard.nextLine();
			JSONArray data = dr.getMencariDataRapel(inputKode);
			showData_DataRapel(data,"kdsatker","nip");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	public MainMdDataRapel(){
		testqueryMencariDataRapel();
	}
	
	public  void testqueryMenambahDataRapel(){
		MdDataRapelController dr =new MdDataRapelController();
		String kdsatker,namasatker,nip,nama;
		int kdjenkel;
		try{
			System.out.print("Masukan KDSTAKER : ");
			kdsatker=dataIn.readLine();
			System.out.print("Masukan NAMASATKER : ");
			namasatker=dataIn.readLine();
			System.out.print("Masukan NIP : ");
			nip=dataIn.readLine();
			System.out.print("Masukan NAMA : ");
			nama=dataIn.readLine();
			System.out.print("Masukan KDJENKEL : ");
			kdjenkel=Integer.parseInt(dataIn.readLine());
			dr.getMenambahDataRapel(kdsatker, namasatker, nip, nama, kdjenkel);
			mainMenu();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void MengubahNamaDataRapel(){
		MdDataRapelController dr =new MdDataRapelController();
		String nama;
		int janak;
		try{
			
			System.out.print("Masukan NAMA : ");
			nama=dataIn.readLine();
			System.out.print("Masukan JANAK : ");
			janak=Integer.parseInt(dataIn.readLine());
			dr.getMengeditDataRapel(nama, janak);
			mainMenu();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void testMenampilkanDataRapel(){
		MdDataRapelController dr =new MdDataRapelController();
		JSONArray data = dr.getMenampilkanTabelDataRapel(); 
		showData_DataRapel(data, "kdsatker", "nip");
	}
	
	public  void hapusDataRapel() throws IOException{
		MdDataRapelController dr =new MdDataRapelController();
		String nip;

		System.out.print("Masukan NIP data yang ingin di hapus : ");
		nip=dataIn.readLine();

		dr.getMenghapusDataRapel(nip);
		mainMenu();
	}
	
//	public  void backto()  {
//		String inp;
//		MainActivity ma = new MainActivity();
//		System.out.print("1. Menu Utama 2. Submenu Mencari Agama Berdasarkan Kode  : ");
//		try {
//			inp=keyboard.next();
//			switch (inp) {
//			case "1":
//				ma.menuUtama();;
//				break;
//			case "2":
//				testqueryMencariNamaAgama();
//				break;
//			default:
//				System.out.println("Masukan Salah !");
//			}
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
	public  void showData_DataRapel(JSONArray arrayData, String kdsatker, String nip) {
		//System.out.println(arrayData);
		System.out.println("+----------------------------------+");
		System.out.println("| KDSATKER    | NIP      |");
		System.out.println("+----------------------------------+");
		String space;
		String tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			tamp=(String) obj.get(kdsatker);
			System.out.print("| "+tamp);

			space=(String) obj.get(nip);
			System.out.print("              | "+ space);
			for (int j = 0; j  < 20 - (space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+----------------------------------+");
		}
		//backto();
		//add by Hendra YN
	}
	public static void main(String args[]) {
		MainMdDataRapel mainMdDataRapel = new MainMdDataRapel();
		mainMdDataRapel.mainMenu();
	}

}
