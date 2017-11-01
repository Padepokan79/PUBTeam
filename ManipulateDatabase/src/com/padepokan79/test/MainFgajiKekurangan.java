package com.padepokan79.test;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdFgajiKekuranganController;;

public class MainFgajiKekurangan {
	public  void tampilFgajiTanggal29101997(){
		MdFgajiKekuranganController obj = new MdFgajiKekuranganController();
		JSONArray data = obj.getQueryDataFgajikekuranganPadatanggalGaji29101997(); 
		showData(data,"TGLGAJI","NIP","GAPOKBARU","kdsatker");
	}
	public  void showData(JSONArray arrayData,String fielda, String fieldb, String fieldc,String fieldd) {
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			System.out.print("|    "+obj.get(fielda));
		}
	}
	
	public static void main(String [] args) {
		MainFgajiKekurangan obj= new MainFgajiKekurangan();
		obj.tampilFgajiTanggal29101997();
	}
}
