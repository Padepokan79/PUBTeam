package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdJenisDidikController;


public class MainjenisDidik {

	BufferedReader dataIn= new BufferedReader(new InputStreamReader(System.in));
	public void mainMenu () {

		System.out.println("+-------------------------------------------------------------------+");
		System.out.println("|                          Jenis Didik                              |");
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
				MenampilkanJenisDidik();
				break;
			case "2":
				MenambahkanJenisDidik();
				break;
			case "3":
				mengubahDataJenisDidik();
				break;
			case "4":
				mencariDataJenisDidik();
				break;
			case "5":
				hapusDataJenisDidik();
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
	public  void MenampilkanJenisDidik(){
		MdJenisDidikController mjd =new MdJenisDidikController();
		JSONArray data = mjd.getQueryMenampilkanDataJenisDidik(); 
		showData2(data,"jnsdidik","nmjenisdidik");
	}

	public  void MenambahkanJenisDidik(){
		MdJenisDidikController mjd =new MdJenisDidikController();
		String  nmjenisdidik;
		int jnsdidik ;
		try{
			System.out.print("Masukan Jenis Didik : ");
			jnsdidik=Integer.parseInt(dataIn.readLine());
			System.out.print("Masukan Pendidikan : ");
			nmjenisdidik=dataIn.readLine();
			
			mjd.getQueryInsertDataJenisDidik(jnsdidik, nmjenisdidik);
			mainMenu();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public  void mengubahDataJenisDidik(){
		MdJenisDidikController mjd =new MdJenisDidikController();
		String nmjenisdidik;
		int jnsdidik;
		try {
			System.out.print("Masukan KOde pendidikan yang akan di ubah : ");
			jnsdidik=Integer.parseInt(dataIn.readLine());
			System.out.print("Masukan Pendidikan : ");
			nmjenisdidik=dataIn.readLine();
			mjd.getQueryUpdateDataJenisDidik(jnsdidik, nmjenisdidik);
			mainMenu();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public  void hapusDataJenisDidik() throws IOException{
		MdJenisDidikController mjd =new MdJenisDidikController();
		int jnsdidik;

		System.out.print("Masukan Nip data yang ingin di ubah : ");
		jnsdidik=Integer.parseInt(dataIn.readLine());

		mjd.getQueryDeleteDataJenisDidik(jnsdidik);
		mainMenu();
	}

	public  void mencariDataJenisDidik() throws IOException{
		MdJenisDidikController mjd =new MdJenisDidikController();
		int kode;
		System.out.print("Masukan Nip data yang ingin di cari : ");
		kode=Integer.parseInt(dataIn.readLine());
		JSONArray data = mjd.getQuerySearchDataJenisDidik(kode); 
		showData2(data,"jnsdidik","nmjenisdidik");
	}

	public  void showData2(JSONArray arrayData,String jnsdidik ,String nmjenisdidik) {
		//System.out.println(arrayData);
		System.out.println("+------------------------+");
		System.out.println("| Kode |   Pendidikan    |");
		System.out.println("+------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);
			space=String.valueOf( obj.get(jnsdidik));
			space = space.trim();
			System.out.print("|  "+space);
			for (int j = 0; j  <3-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(nmjenisdidik);
			space = space.trim();

			System.out.print(" | "+space );
			for (int j = 0; j  <15-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println(" |");
			System.out.println("+------------------------+");
		}

		mainMenu();
	}


	public static void main(String args[]){
		MainjenisDidik nm=new MainjenisDidik();
		nm.mainMenu();
	}
}
