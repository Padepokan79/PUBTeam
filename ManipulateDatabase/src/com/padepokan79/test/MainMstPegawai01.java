package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdGajibController;
import com.padepokan79.controller.MdMstPegawai01Controller;
//by ILFA SRI DESY
public class MainMstPegawai01 {
	BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		MainMstPegawai01 mp=new MainMstPegawai01();
		mp.menu();
	}
	
	public void menu() throws NumberFormatException, IOException {
		System.out.println("");
		System.out.println("+------------------------------------+");
		System.out.println("|        MENU MST PEGAWAI 01         |");
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
			testSelectMstPegawai01();
			menu();
		}else if(tamp==2) {
			testInsertMstPegawai01();
			menu();
		}else if(tamp==3) {
			testUpdateMstPegawai01();
			menu();
		}else if(tamp==4) {
			testDeleteMstPegawai01();
			menu();
		}else if(tamp==5) {
			testMencariMstPegawai01();
			menu();
		}else {
			System.out.println("Pilihan tidak terdaftar");
			menu();
		}
	}
	
	public void testSelectMstPegawai01() {
		MdMstPegawai01Controller mpc=new MdMstPegawai01Controller();
		try {
			JSONArray data=mpc.getQuerySelectAllMstPegawai01();
			showData_mstPegawai01(data, "nip", "nama", "tgllhr", "pendidikan");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testMencariMstPegawai01(){
		MdMstPegawai01Controller mpc=new MdMstPegawai01Controller();
		try {
			System.out.println("Masukan nip: ");
			String in=input.readLine();
			JSONArray data=mpc.getQueryMencariMstPegawai01(in);
			showData_mstPegawai01(data, "nip", "nama", "tgllhr", "pendidikan");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testUpdateMstPegawai01() {
		MdMstPegawai01Controller mpc=new MdMstPegawai01Controller();
		try {
			
			System.out.println("Masukan nama baru: ");
			String nama=input.readLine();
			
			System.out.println("Masukan nip yang nama nya akan diubah: ");
			String nip=input.readLine();
			
			JSONArray data=mpc.getQueryUpdateMstPegawai01(nama, nip);
			//showData_mstPegawai01(data, "nip", "nama", "tgllhr", "agama");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testDeleteMstPegawai01() {
		MdMstPegawai01Controller mpc=new MdMstPegawai01Controller();
		try {
			System.out.println("Masukan nip yang data nya akan dihapus: ");
			String nip=input.readLine();
			JSONArray data=mpc.getQueryDeleteMstPegawai01(nip);
			//showData_mstPegawai01(data, "nip", "nama", "tgllhr", "agama");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void testInsertMstPegawai01() {
		MdMstPegawai01Controller mpc=new MdMstPegawai01Controller();
		try {
			System.out.println("Masukan nip data baru: ");
			String nip=input.readLine();
			System.out.println("Masukan nama data baru: ");
			String nama=input.readLine();
			System.out.println("Masukan tgl lahir data baru: ");
			String tgl=input.readLine();
			System.out.println("Masukan pendidikan data baru: ");
			String pendidikan=input.readLine();
			
			JSONArray data=mpc.getQueryInsertMstPegawai01(nip, nama, tgl, pendidikan);
			//showData_mstPegawai01(data, "nip", "nama", "tgllhr", "agama");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void showData_mstPegawai01(JSONArray arrayData,String nip, String nama, String tgllhr, String pendidikan) {
		System.out.println(arrayData);
		System.out.println("+--------------------------------------------------------------------------------------------------------------+");
		System.out.println("|          nip                 |                NAMA                    |    TGL LAHIR  |     PENDIDIKAN       |");
		System.out.println("+--------------------------------------------------------------------------------------------------------------+");
		String space;
		int tamp;
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			space=(String) obj.get(nip);
			space = space.trim();
			System.out.print("|    "+space);
			for (int j = 0; j  <26-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(nama);
			space = space.trim();
			System.out.print("|    "+space);
			for (int j = 0; j  <36-(space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.print("|  "+obj.get(tgllhr)+"   ");
			
			
			space=(String) obj.get(pendidikan);
			space = space.trim();
			System.out.print("|  "+space);
			for (int j = 0; j  <20-(space.length()); j++) {
				System.out.print(" ");
			}
			
			
			System.out.println("|");
			System.out.println("+--------------------------------------------------------------------------------------------------------------+");
		}
		
	}
}
