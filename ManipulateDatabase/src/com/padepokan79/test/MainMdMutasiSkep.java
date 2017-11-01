package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdIrdhataController;
import com.padepokan79.controller.MdMutasiSkepController;

public class MainMdMutasiSkep {

	//Scanner dataIn=new Scanner(System.in);
	BufferedReader dataIn= new BufferedReader(new InputStreamReader(System.in));
	public void mainMenu () {

		System.out.println("+-------------------------------------------------------------------+");
		System.out.println("|                        Mutasi Skep                                |");
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
				MenampilkanMutasi();
				break;
			case "2":
				MenambahkanMutasi();
				break;
			case "3":
				mengubahDataMutasi();
				break;
			case "4":
				mencariDataMutasi();
				break;
			case "5":
				hapusDataMutasi();
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

	//nip=?,noagenda=?,kdpangkat=?,gapok=?,masker
	public  void MenampilkanMutasi(){
		MdMutasiSkepController mic =new MdMutasiSkepController();
		JSONArray data = mic.getQueryMenampilkanTunjangan(); 
		showData2(data,"nip","kdpangkat","gapok","masker");
	}

	public  void MenambahkanMutasi(){
		MdMutasiSkepController mic =new MdMutasiSkepController();
		String nip, noagenda,  kdpangkat;
		int gapok,masker;
		try{
			System.out.print("Masukan nip : ");
			nip=dataIn.readLine();
			System.out.print("Masukan noagenda : ");
			noagenda=dataIn.readLine();
			System.out.print("Masukan kode pangkat : ");
			kdpangkat=dataIn.readLine();
			System.out.println("Masukan Gaji Pokok : ");
			gapok=Integer.parseInt(dataIn.readLine());
			System.out.print("Masukan masa Kerja : ");
			masker=Integer.parseInt( dataIn.readLine());
			mic.getQueryInsertDataMutasi(nip, noagenda, kdpangkat, gapok, masker);
			mainMenu();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public  void mengubahDataMutasi(){
		MdMutasiSkepController mic =new MdMutasiSkepController();
		String nip, noagenda,  kdpangkat;
		int gapok,masker;
		try{
			System.out.print("Masukan nip yang akan diubah: ");
			nip=dataIn.readLine();
			System.out.print("Masukan noagenda : ");
			noagenda=dataIn.readLine();
			System.out.print("Masukan kode pangkat : ");
			kdpangkat=dataIn.readLine();
			System.out.println("Masukan Gaji Pokok : ");
			gapok=Integer.parseInt(dataIn.readLine());
			System.out.print("Masukan masa Kerja : ");
			masker=Integer.parseInt( dataIn.readLine());
			mic.getQueryUpdateDataMutasi(nip, noagenda, kdpangkat, gapok, masker);
			mainMenu();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public  void hapusDataMutasi() throws IOException{
		MdMutasiSkepController mic =new MdMutasiSkepController();
		String nip, noagenda,  kdpangkat;
		int gapok,masker;
		try{
			System.out.print("Masukan nip yang akan dihapus: ");
			nip=dataIn.readLine();
			System.out.print("Masukan noagenda : ");
			noagenda=dataIn.readLine();

			mic.getQueryDeleteDataMutasi(nip, noagenda);
			mainMenu();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public  void mencariDataMutasi() throws IOException{
		MdMutasiSkepController mic =new MdMutasiSkepController();
		String  noagenda;
			System.out.print("Masukan noagenda : ");
			noagenda=dataIn.readLine();
		JSONArray data = mic.getQuerySearchMutasi(noagenda); 
		showData2(data,"nip","kdpangkat","gapok","masker");
	}

	public  void showData2(JSONArray arrayData,String fieldtmt ,String fieldnip, String fieldkode, String fieldtj) {
		//System.out.println(arrayData);
		System.out.println("+--------------------------------------------------+");
		System.out.println("|    Nip     | Kd Pangkat |    Gapok    |  masker  |");
		System.out.println("+--------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			System.out.print("| "+obj.get(fieldtmt));
			space=(String) obj.get(fieldnip);
			space = space.trim();

			System.out.print(" |     "+space);
			for (int j = 0; j  <7-(space.length()); j++) {
				System.out.print(" ");
			}
			space=String.valueOf( obj.get(fieldkode));
			space = space.trim();

			System.out.print("|  "+space);
			for (int j = 0; j  <6-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("   |  ");
			space=String.valueOf( (obj.get(fieldtj)));
			space = space.trim();
			for (int j = 0; j  <4-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println(space +"    |");
			System.out.println("+--------------------------------------------------+");
		}

		mainMenu();
	}


	public static void main(String args[]){
		MainMdMutasiSkep mm=new MainMdMutasiSkep();
		mm.mainMenu();
	}

}
