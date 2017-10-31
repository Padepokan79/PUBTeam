package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdSequenceTblController;


public class MainMdSequenceTbl {
	public static Scanner keyboard = new Scanner(System.in);
	public static MdSequenceTblController mst= new MdSequenceTblController();
	
	public static void testReadData() {
		try {
			JSONArray data = mst.getReadData();
			showData_SequenceTbl(data,"idnum","seqnum","cseqnum","ket","bulan","tahun");
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	public static void testSearchData() {	
		try {
			int input;
			System.out.println("Masukkan idnum:");
			input=keyboard.nextInt();
			JSONArray data = mst.getSearchData(input);
			showData_SequenceTbl(data,"idnum","seqnum","cseqnum","ket","bulan","tahun");
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		backto();
		
	}
	public static void testUpdateData() {
		try {
			System.out.print("Masukan id num yang akan di edit : ");
			int idnum=keyboard.nextInt();
			System.out.print("Masukan ket baru: ");
			String ket=keyboard.next();
			JSONArray data = mst.getUpdateData(ket,idnum);
		} catch (Exception e){
			System.out.println("Inputan Salah, masukan integer untuk Id num");
			System.out.println(e.getMessage());
		}
		backto();
		
	}
	public static void testCreateData() {	
		try {
			System.out.print("Masukan Id Num : ");
			int idnum=keyboard.nextInt();
			System.out.print("Masukan Seq Num : ");
			int seqnum=keyboard.nextInt();
			System.out.print("Masukan CSeq Num : ");
			String cseqnum=keyboard.next();
			System.out.print("Masukan Ket : ");
			String ket=keyboard.next();
			System.out.print("Masukan bulan : ");
			int bulan=keyboard.nextInt();
			System.out.print("Masukan tahun : ");
			int tahun=keyboard.nextInt();
			JSONArray data = mst.getCreateData(idnum, seqnum,cseqnum,ket,bulan,tahun);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		backto();
	}
	public static void testDeleteData() {	
		try {
			System.out.print("Masukan Id Num yang akan di hapus : ");
			int idnum=keyboard.nextInt();
			JSONArray data = mst.getDeleteData(idnum);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
		backto();
	}
	public static  void backto()  {
		int inp;
		System.out.println("1. Menampilkan Tabel Sequence");
		System.out.println("2. Mencari Data Berdasarkan Id num");
		System.out.println("3. Mengedit Data Sequence");
		System.out.println("4. Menambahkan Data Sequence");
		System.out.println("5. Menghapus Data Sequence");
		System.out.println("=======================================");
		System.out.print("Masukan Pilihan : ");
			inp=keyboard.nextInt();
			if(inp==1) {
				testReadData();
			}else if(inp==2) {
				testSearchData();
			}else if(inp==3) {
				testUpdateData();
			}else if(inp==4) {
				testCreateData();
			}else if(inp==5) {
				testDeleteData();
			}else {
				System.out.println("Masukan Salah !");
			}
		
	}
	
	public static  void showData_SequenceTbl(JSONArray arrayData, String idnum,String seqnum,String cseqnum,String ket,String bulan,String tahun) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("| Idnum | Seqnum | Cseqnum |  Keterangan  | bulan | tahun |");
		System.out.println("+---------------------------------------------------------+");
	
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);
			System.out.print("| "+ obj.get(idnum));
			System.out.print("     | "+  obj.get(seqnum));
			System.out.print("     | "+  obj.get(cseqnum));
			System.out.print("   | "+  obj.get(ket));
			System.out.print(" | "+  obj.get(bulan));
			System.out.print("    | "+  obj.get(tahun));
			
			System.out.println("  |");
			System.out.println("+---------------------------------------------------------+");
			}
		backto();
		
	}
	
	public static void main(String args[]) {
		MainMdSequenceTbl mainmdsequencetbl=new MainMdSequenceTbl();
		mainmdsequencetbl.backto();
	}
}
