package com.padepokan79.test;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdFsptController;

public class MainFspt {
public static void main(String [] args) {
	MainFspt m= new MainFspt();
	m.testFspt();
}

public  void showData(JSONArray arrayData,String fielda, String fieldb) {
	for (int i = 0; i < 10; i++) {
		JSONObject obj =  arrayData.getJSONObject(i);	
		
		System.out.println("|    "+obj.get(fielda)+"  |");
		System.out.println("|    "+obj.get(fieldb)+"  |");
		System.out.println("+----------------------------------------------------+");
	}
	
}

public  void testFspt(){
	MdFsptController m= new MdFsptController();
	JSONArray data = m.getQueryFspt(); 
	showData(data,"nip","nama");
} 

}
