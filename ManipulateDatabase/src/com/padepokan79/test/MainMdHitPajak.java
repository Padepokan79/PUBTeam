package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdHitPajakController;



public class MainMdHitPajak {
	public  Scanner keyboard = new Scanner( System.in );
	
	public MainMdHitPajak(){
		//testqueryTampilDataJuruBayar();
	}
	
	public void menu(){
		System.out.println(" ---------------------------");
		System.out.println("|            MENU           |");
		System.out.println(" ---------------------------");
		System.out.println("| 1. Tampil Data Hit Pajak  |");
		System.out.println("| 2. Cari Data Hit Pajak    |");
		System.out.println("| 3. Tambah Data Hit Pajak  |");
		System.out.println("| 4. Ubah Data Hit Pajak    |");
		System.out.println("| 5. Hapus Data Hit Pajak   |");
		System.out.println(" ---------------------------");
		System.out.print("Pilih Menu : ");
		int pilih=keyboard.nextInt();
		switch (pilih) {
		case 1:
			testqueryTampilDataHitPajak();
			menu();
			break;
		case 2:
			testquerySearchDataHitPajak();
			menu();
			break;
		case 3:
			testqueryInsertDataHitPajak();
			menu();
			break;
		case 4:
			testqueryUpdateDataHitPajak();
			menu();
			break;
		case 5:
			testqueryDeleteDataHitPajak();
			menu();
			break;
		default:
			System.out.println("Masukan Salah !");
			menu();
		}
	}
	
	public  void testqueryTampilDataHitPajak() {
		MdHitPajakController md= new MdHitPajakController();
		
		try {
			JSONArray data = md.getQueryTampilDataHitPajak();
			showData(data,"nip","subkotor","istri","anak");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testquerySearchDataHitPajak() {
		MdHitPajakController md= new MdHitPajakController();
		
		try {
			System.out.print("Masukan NIP yang di cari : ");
			String inputNip=keyboard.next();
			System.out.print("Masukan Jumlah Istri yang di cari : ");
			int inputIstri=keyboard.nextInt();
			System.out.print("Masukan Jumlah Anak yang di cari : ");
			int inputAnak=keyboard.nextInt();
			JSONArray data = md.getQuerySearchHitPajak(inputNip, inputIstri, inputAnak);
			showData(data,"nip","subkotor","istri","anak");
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryInsertDataHitPajak() {
		MdHitPajakController md= new MdHitPajakController();
		
		try {
			System.out.print("Masukan NIP : ");
			String inputNip=keyboard.next();
			System.out.print("Masukan THP : ");
			int inputThp=keyboard.nextInt();
			System.out.print("Masukan Kotor Induk : ");
			int inputKotorInduk=keyboard.nextInt();
			System.out.print("Masukan SubKotor : ");
			int inputSubKotor=keyboard.nextInt();
			System.out.print("Masukan Jumlah Istri : ");
			int inputIstri=keyboard.nextInt();
			System.out.print("Masukan Jumlah Anak : ");
			int inputAnak=keyboard.nextInt();
			JSONArray data = md.getQueryInsertHitPajak(inputNip, inputThp, inputKotorInduk, inputSubKotor, inputIstri, inputAnak);
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryUpdateDataHitPajak() {
		MdHitPajakController md= new MdHitPajakController();
		
		try {
			System.out.print("Masukan NIP yang akan di ubah: ");
			String inputNip=keyboard.next();
			System.out.print("Masukan THP yang akan di ubah: ");
			int inputThp=keyboard.nextInt();
			System.out.print("Masukan Kotor Induk baru: ");
			int inputKotorInduk=keyboard.nextInt();
			System.out.print("Masukan SubKotor baru: ");
			int inputSubKotor=keyboard.nextInt();
			JSONArray data = md.getQueryUpdateHitPajak(inputNip, inputThp, inputKotorInduk, inputSubKotor);
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void testqueryDeleteDataHitPajak() {
		MdHitPajakController md= new MdHitPajakController();
		
		try {
			System.out.print("Masukan NIP yang akan di hapus: ");
			String inputNip=keyboard.next();
			System.out.print("Masukan THP yang akan di hapus: ");
			int inputThp=keyboard.nextInt();
			JSONArray data = md.getQueryDeleteHitPajak(inputNip, inputThp);
		} catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
			 
		}
	}
	
	public  void showData(JSONArray arrayData, String nip, String subkotor, String istri, String anak) {
		//System.out.println(arrayData);
		System.out.println("+-----------------------------------------------+");
		System.out.println("| NIP             | SubKotor  | Istri | anak    |");
		System.out.println("+-----------------------------------------------+");
		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(nip);
			System.out.print("| "+ space);
			
			tamp=(int) obj.get(subkotor);
			System.out.print("       |"+tamp);

			tamp=(int) obj.get(istri);
			System.out.print("    | "+ tamp);
			
			tamp=(int) obj.get(anak);
			System.out.print("     | "+ tamp);
			for (int k = 0; k  < 16 - (space.length()); k++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+-----------------------------------------------+");
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainMdHitPajak mp= new MainMdHitPajak();
		mp.menu();
	}

}
