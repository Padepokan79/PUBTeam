package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdHistorisEselonController;


public class MainMdHistorisEselon {
	//Scanner dataIn=new Scanner(System.in);
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
				MenampilkanHistorisSkep();
				break;
			case "2":
				MenambahkanHistorisSkep();
				break;
			case "3":
				mengubahDataHistorisSkep();
				break;
			case "4":
				mencariDataHistorisSkep();
				break;
			case "5":
				hapusDataHistorisSkep();
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
	public  void MenampilkanHistorisSkep(){
		MdHistorisEselonController mhe =new MdHistorisEselonController();
		JSONArray data = mhe.getQueryMenampilkanDataHistoriEselon(); 
		showData2(data,"tmtgaji","nip","kdeselon","tjeselon");
	}

	public  void MenambahkanHistorisSkep(){
		MdHistorisEselonController mhe =new MdHistorisEselonController();
		String tmtgaji, nip, kdeselon,  keterangan, tglupdate;
		int tjeselon;
		try{
			System.out.print("Masukan tanggal mulai tugas (yyyy-mm-dd) : ");
			tmtgaji=dataIn.readLine();
			System.out.print("Masukan Nip : ");
			nip=dataIn.readLine();
			System.out.print("Masukan Kode eselon : ");
			kdeselon=dataIn.readLine();
			System.out.print("Masukan Keterengan : ");
			keterangan=dataIn.readLine();
			System.out.print("Masukan Tunjangan Eselon : ");
			tjeselon=Integer.parseInt(dataIn.readLine());
			mhe.getQueryInsertDataHistorisEselon(tmtgaji, nip, kdeselon, tjeselon, keterangan);
			mainMenu();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public  void mengubahDataHistorisSkep(){
		MdHistorisEselonController mhe =new MdHistorisEselonController();
		String tmtgaji, nip, kdeselon,  keterangan, tglupdate;
		int tjeselon;
		try {
			System.out.print("Masukan tanggal mulai tugas (yyyy-mm-dd) : ");
			tmtgaji=dataIn.readLine();
			System.out.print("Masukan Nip data yang ingin di ubah : ");
			nip=dataIn.readLine();
			System.out.print(" Masukan Kode eselon : ");
			kdeselon=dataIn.readLine();
			System.out.print("Masukan Keterengan : ");
			keterangan=dataIn.readLine();
			System.out.print("Masukan Tunjangan Eselon : ");
			tjeselon=Integer.parseInt(dataIn.readLine());
			mhe.getQueryUpdateDataHistorisEselon(tmtgaji, nip, kdeselon, tjeselon, keterangan);
			mainMenu();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public  void hapusDataHistorisSkep() throws IOException{
		MdHistorisEselonController mhe =new MdHistorisEselonController();
		String nip;

		System.out.print("Masukan Nip data yang ingin di ubah : ");
		nip=dataIn.readLine();

		mhe.getQueryDeleteDataHistorisEselon(nip);
		mainMenu();
	}

	public  void mencariDataHistorisSkep() throws IOException{
		MdHistorisEselonController mhe =new MdHistorisEselonController();
		String nip;
		System.out.print("Masukan Nip data yang ingin di ubah : ");
		nip=dataIn.readLine();
		JSONArray data = mhe.getQuerySearchDataHistorisEselon(nip); 
		showData2(data,"tmtgaji","nip","kdeselon","tjeselon");
	}

	public  void showData2(JSONArray arrayData,String fieldtmt ,String fieldnip, String fieldkode, String fieldtj) {
		//System.out.println(arrayData);
		System.out.println("+---------------------------------------------------------------------+");
		System.out.println("|      TMT GAji     |            NIP           |  Kode  |  Tunjangan  |");
		System.out.println("+---------------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			System.out.print("|   "+obj.get(fieldtmt));
			space=(String) obj.get(fieldnip);
			space = space.trim();

			System.out.print("      | "+space);
			for (int j = 0; j  <25-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldkode);
			space = space.trim();

			System.out.print("| "+space);
			for (int j = 0; j  <5-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("  | ");
			space=String.valueOf(obj.get(fieldtj));
			space = space.trim();
			for (int j = 0; j  <10-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println(space +"  |");
			System.out.println("+---------------------------------------------------------------------+");
		}

		mainMenu();
	}


	public static void main(String args[]){
		MainMdHistorisEselon mm=new MainMdHistorisEselon();
		mm.mainMenu();
	}
}
