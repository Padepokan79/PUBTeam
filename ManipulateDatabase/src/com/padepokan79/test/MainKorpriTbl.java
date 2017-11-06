package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdKorpriTblController;;

public class MainKorpriTbl {
	public  Scanner bf=new Scanner( System.in );
	public BufferedReader dataIn= new BufferedReader(new InputStreamReader(System.in));

	static MainKorpriTbl m= new MainKorpriTbl();
	public static void main(String [] args) {
		
		m.MenuUtamaMenuTbl();
	}
	public void testQueryMencariKorpri(){
		MdKorpriTblController obj=new MdKorpriTblController();
		try {
			System.out.print("Masukan Kode : ");
			int inputKode=bf.nextInt();
			JSONArray data = obj.getQueryMencariKorpriByKode(inputKode); 
			showData(data, "kdkorpri", "nilai","keter");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	
	public void testQueryTampilKorpri(){
		MdKorpriTblController obj=new MdKorpriTblController();
		try {
			JSONArray data = obj.getQueryTampilKorpri(); 
			showData(data, "kdkorpri", "nilai","keter");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	public  void showData(JSONArray arrayData,String fielda, String fieldb,String fieldc) {
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			System.out.print("|   "+obj.get(fielda)+"    |");
			System.out.print("|   "+obj.get(fieldb)+"    |");
			System.out.print("|   "+obj.get(fieldc)+"    |");


			
			System.out.println(" |");
			System.out.println("+--------------------------------------+");
		}

	}
	public void MenuUtamaMenuTbl() {
		System.out.println("Show Korpri Tbl");
		System.out.println("1. Mencari Data  By Kode");
		System.out.println("2. Menampilkan Semua Data");
		System.out.println("3. Tambah Korpri");
		System.out.println("4. Ubah Korpri");
		System.out.println("5. Hapus Korpri");
		System.out.print("Masukkan nomor : ");
		String inp = bf.nextLine();
		switch(inp) {
			case "1":   m.testQueryMencariKorpri();;
						m.MenuUtamaMenuTbl();
						break;
			case "2": 	m.testQueryTampilKorpri();
						m.MenuUtamaMenuTbl();
						break;
			case "3": 	m.TambahKorpri();
						m.MenuUtamaMenuTbl();
						break;
			case "4": 	m.UbahKorpri();
						m.MenuUtamaMenuTbl();
						break;
			case "5": 	m.HapusKorpri();
						m.MenuUtamaMenuTbl();
						break;
			
		}
		
		
	}
	public  void TambahKorpri(){
		MdKorpriTblController m = new MdKorpriTblController();
		String tmt, kdkorpri,  keterangan;
		int nilai;
		try{
			System.out.print("Masukan tanggal mulai tugas (yyyy-mm-dd) : ");
			tmt=dataIn.readLine();
			System.out.print("Masukan Kode Korpri : ");
			kdkorpri= dataIn.readLine();
			System.out.print("Masukan Nilai : ");
			nilai = Integer.parseInt(dataIn.readLine());
			System.out.print("Masukan Keterengan : ");
			keterangan=dataIn.readLine();
			m.getQueryTambahKorpri(tmt, kdkorpri, nilai, keterangan);
			System.out.println("Data Di tambah kan");
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public  void HapusKorpri(){
		MdKorpriTblController m = new MdKorpriTblController();
		String kdkorpri;
		try{
			System.out.print("Masukan Kode Korpri : ");
			kdkorpri= dataIn.readLine();
			m.getQueryHapusKorpri(kdkorpri);
			System.out.println("Data Di Hapus kan");
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public  void UbahKorpri(){
		MdKorpriTblController m = new MdKorpriTblController();
		String kdkorpri,  keterangan;
		int nilai;
		try{
			System.out.print("Masukan Kode Korpri : ");
			kdkorpri= dataIn.readLine();
			System.out.print("Masukan Nilai : ");
			nilai = Integer.parseInt(dataIn.readLine());
			System.out.print("Masukan Keterengan : ");
			keterangan=dataIn.readLine();
			m.getQueryUbahKorpri( kdkorpri, nilai, keterangan);
			System.out.println("Data Di ubah kan");
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	

}
