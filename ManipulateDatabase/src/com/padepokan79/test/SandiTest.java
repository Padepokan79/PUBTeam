package com.padepokan79.test;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.Satker;
import com.padepokan79.controller.Twafat;

public class SandiTest {
	
	public void kepalaDinasHaji(){
		Satker satkerja = new Satker();
		JSONArray data = satkerja.getQueryKepalaDinasHaji();
		//System.out.println(data);
		showData(data,"satkerja", "descsatker", "nama_atasa", "jab_atasan");
	} 
	
	public void showData(JSONArray arrayData, String fSatu, String fDua, String fTiga, String fEmpat) {
		//System.out.println(arrayData);
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("| Satuan Kerja |            Deskripsi Satuan Kerja            |                 Nama Atasan                 |               Jabatan Atasan               |");
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------+");
		String space;
		
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			space=(String) obj.get(fSatu);
			System.out.print("|      "+space);
			
			space=(String) obj.get(fDua);
			space = space.trim();
			System.out.print("     | "+space);
			for (int j = 0; j  <40-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(fTiga);
			space = space.trim();
			System.out.print("     | "+space);
			for (int j = 0; j  <40-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(fEmpat);
			space = space.trim();
			System.out.print("    | "+space);
			for (int j = 0; j  <43-(space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.println("|");
					
			System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------+");
		}
	}
	
	public void JumlahPegawaiYangKerjaDiDinasKesehatan(){
		Satker satkerja = new Satker();
		JSONArray data = satkerja.getQueryJumlahPegawaiYangKerjaDiDinasKesehatan();
		//System.out.println(data);
		showData(data,"satuan_kerja", "count(*)");
	} 
	
	public void showData(JSONArray arrayData, String fSatu, String fDua) {
		//System.out.println(arrayData);
		System.out.println("+---------------------------------------------+");
		System.out.println("|            Satuan Kerja            | Jumlah |");
		System.out.println("+---------------------------------------------+");
		String space;
		
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			space=(String) obj.get(fSatu);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <35-(space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.print("|    "+obj.get(fDua));
			
			
			
					
			System.out.println("   |");
					
			System.out.println("+---------------------------------------------+");
		}
	}
	
	public void NIPNamaTanggalWafat(){
		Twafat twafat = new Twafat();
		JSONArray data = twafat.getQueryNIPNamaTanggalWafat();
		//System.out.println(data);
		showData(data,"nip", "nama","tglwafat");
	} 
	
	public void showData(JSONArray arrayData, String fSatu, String fDua,String fTiga) {
		//System.out.println(arrayData);
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.println("|        Nip         |                 Nama               | Tanggal Wafat |");
		System.out.println("+-------------------------------------------------------------------------+");
		String space;
		
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			space=(String) obj.get(fSatu);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <19-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(fDua);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <35-(space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.print("|  "+obj.get(fTiga));
			
			System.out.println("   |");
					
			System.out.println("+-------------------------------------------------------------------------+");
		}
	}
	
	public void KdKubKelPenerimaKosong(){
		Twafat twafat = new Twafat();
		JSONArray data = twafat.getQueryKdKubKelPenerimaKosong();
		//System.out.println(data);
		showData(data,"nip", "nama","tglwafat","penerbit","kdhubkelpenerima");
	} 
	
	public void showData(JSONArray arrayData, String fSatu, String fDua,String fTiga,String fEmpat,String fLima) {
		//System.out.println(arrayData);
		System.out.println("+------------------------------------------------------------------------------------------+");
		System.out.println("|        Nip         |           Nama           | Tanggal Wafat | Penerbit | Kode Penerima |");
		System.out.println("+------------------------------------------------------------------------------------------+");
		String space;
		
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			space=(String) obj.get(fSatu);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <19-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(fDua);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <25-(space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.print("|  "+obj.get(fTiga));
			
			space=(String) obj.get(fEmpat);
			space = space.trim();
			System.out.print("   |   "+space);
			for (int j = 0; j  <7-(space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.print("|      "+obj.get(fLima));
			
			System.out.println("       |");
					
			System.out.println("+------------------------------------------------------------------------------------------+");
		}
	}

	
	public static void main(String args[]) {
		SandiTest st = new SandiTest();
		st.KdKubKelPenerimaKosong();
	}

}
