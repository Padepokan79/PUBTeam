package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdJabatanKhususTblController;
import com.padepokan79.controller.MdStawinTblController;
import com.padepokan79.controller.MdTkdTblController;
//by ILFA SRI DESY
public class MainJabatanKhususTbl {
	BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		MainJabatanKhususTbl j=new MainJabatanKhususTbl();
		j.menu();
	}
	
	public void menu() throws NumberFormatException, IOException {
		System.out.println("");
		System.out.println("+------------------------------------+");
		System.out.println("|        MENU JABATANKHUSUS_TBL      |");
		System.out.println("+------------------------------------+");
		System.out.println("|   1. Menampilkan Data              |");
		System.out.println("|   2. Insert Data                   |");
		System.out.println("|   3. Update Data                   |");
		System.out.println("|   4. Delete Data                   |");
		System.out.println("|   5. Search Data                   |");
		System.out.println("+------------------------------------+");
		System.out.println("Pilihan: ");
		int tamp=Integer.parseInt(input.readLine());
		if(tamp==1) {
			testSelectJabatanKhususTbl();
			menu();
		}else if(tamp==2) {
			testInsertJabatanKhususTbl();
			menu();
		}else if(tamp==3) {
			testUpdateJabatanKhususTbl();
			menu();
		}else if(tamp==4) {
			testDeleteJabatanKhususTbl();
			menu();
		}else if(tamp==5) {
			testMencariJabatanKhususTbl();
			menu();
		}else {
			System.out.println("Pilihan tidak terdaftar");
			menu();
		}
	}
	
	public void testSelectJabatanKhususTbl() {
		MdJabatanKhususTblController jabkhus=new MdJabatanKhususTblController();
		try {
			JSONArray data=jabkhus.getQuerySelectAllJabatanKhususTbl();
			showData_jabatanKhususTbl(data, "tmtjabatan", "kdjabatan", "nmjabatan", "jml", "pensiun");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testMencariJabatanKhususTbl(){
		MdJabatanKhususTblController jabkhus=new MdJabatanKhususTblController();
		try {
			System.out.println("Masukan nama jabatan: ");
			String in=input.readLine();
			JSONArray data=jabkhus.getQueryMencariJabatanKhususTbl(in);
			showData_jabatanKhususTbl(data, "tmtjabatan", "kdjabatan", "nmjabatan", "jml", "pensiun");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testUpdateJabatanKhususTbl() {
		MdJabatanKhususTblController jabkhus=new MdJabatanKhususTblController();
		try {
			
			System.out.println("Masukan umur pensiun baru: ");
			int pensiun=Integer.parseInt(input.readLine());
			System.out.println("Masukan tgl yang jabkhus nya akan diubah: ");
			String tgl=input.readLine();
			System.out.println("Masukan kode jabkhus yang nama TKD nya akan diubah: ");
			String kode=input.readLine();
			JSONArray data=jabkhus.getQueryUpdateJabatanKhususTbl(pensiun, tgl, kode);
			//showData_jabatanKhususTbl(data, "tmtjabatan", "kdjabatan", "nmjabatan", "jml", "pensiun");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testDeleteJabatanKhususTbl() {
		MdJabatanKhususTblController jabkhus=new MdJabatanKhususTblController();
		try {
			System.out.println("Masukan tanggal yang jabkhus nya akan dihapus: ");
			String tgl=input.readLine();
			System.out.println("Masukan kode yang jabkhus nya akan dihapus: ");
			String kode=input.readLine();
			JSONArray data=jabkhus.getQueryDeleteJabatanKhususTbl(tgl, kode);
			//showData_jabatanKhususTbl(data, "tmtjabatan", "kdjabatan", "nmjabatan", "jml", "pensiun");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testInsertJabatanKhususTbl() {
		MdJabatanKhususTblController jabkhus=new MdJabatanKhususTblController();
		try {
			System.out.println("Masukan tanggal jabkhus baru: ");
			String tgl=input.readLine();
			System.out.println("Masukan kode jabkhus baru: ");
			String kode=input.readLine();
			System.out.println("Masukan nama jabkhus baru: ");
			String nama=input.readLine();
			System.out.println("Masukan jumlah uang pensiun baru: ");
			int jml=Integer.parseInt(input.readLine());
			System.out.println("Masukan umur pensiun baru: ");
			int pensiun=Integer.parseInt(input.readLine());
			JSONArray data=jabkhus.getQueryInsertJabatanKhususTbl(tgl, kode, nama, jml, pensiun);
			//showData_jabatanKhususTbl(data, "tmtjabatan", "kdjabatan", "nmjabatan", "jml", "pensiun");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void showData_jabatanKhususTbl(JSONArray arrayData,String tmtjabatan, String kdjabatan, String nmjabatan, String jml, String pensiun) {
		System.out.println(arrayData);
		System.out.println("+------------------------------------------------------------------------------------------------------------------+");
		System.out.println("| TMT Jabatan  |        KD Jabatan   |                  Nama Jabatan                    |    Jumlah     |  Pensiun |");
		System.out.println("+------------------------------------------------------------------------------------------------------------------+");
		String space;
		int tamp;
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			
			System.out.print("|    "+obj.get(tmtjabatan));
			
			
			space=(String) obj.get(kdjabatan);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <20-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(nmjabatan);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <50-(space.length()); j++) {
				System.out.print(" ");
			}
			
			tamp=(int) obj.get(jml);			
			System.out.print("|    "+tamp);

			tamp=(int) obj.get(pensiun);
			
			System.out.print("    |    "+tamp);

//			
			System.out.println("    |");
			System.out.println("+------------------------------------------------------------------------------------------------------------------+");
		}
		
	}
}
