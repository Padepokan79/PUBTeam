package com.padepokan79.test;
import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.Hutang;


public  class MainTest {

	public static void main(String[]args) {

		MainTest newTest = new MainTest();
		newTest.getqueryNamaPegawaiYangMempunyaiHutangLebihDari10JtJumlahCicilanlebihdari1Tahun();
	}
	//"SELECT nip,nama,kdstawin,janak FROM fgaji where kdstawin=3 and janak=0 limit 0,10;"
	public  void getqueryNamaPegawaiYangMempunyaiHutangLebihDari10JtJumlahCicilanlebihdari1Tahun(){

		Hutang hutang = new Hutang();
		JSONArray data = hutang.getQueryNamaPegawaiYangMempunyaiHutangLebihDari10JtJumlahCicilanlebihdari1Tahun();
		//System.out.println(data);
		showData4Parameter(data,"nip", "nama", "jumlah_hutang","jmlbulan");
	}

	public  void showData4Parameter(JSONArray arrayData,String fielda, String fieldb, String fieldc, String fieldd) {
		//System.out.println(arrayData);
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|            NIP           |            Nama          |  Jumlah Hutang   | Jumlah Bulan | ");
		System.out.println("+---------------------------------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(fielda);
			space = space.trim();
			System.out.print("|"+space);
			for (int j = 0; j  <26-(space.length()); j++) {
				System.out.print(" ");
			}

			space=(String) obj.get(fieldb);
			space = space.trim();
			System.out.print("|"+space);
			for (int j = 0; j  <26-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("|");
			System.out.print(obj.get(fieldc));
			for (int j = 0; j  <25-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("|");
			space = space.trim();
			System.out.print(obj.get(fieldd));
			for (int j = 0; j  <27-(space.length()); j++) {
				System.out.print(" ");
			}

			System.out.println("|");
			space = space.trim();
			for (int j = 0; j  <10-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("+---------------------------------------------------------------------------------------+");
		}
	}	
	
}

