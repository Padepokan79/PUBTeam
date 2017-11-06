package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdSsbp;
import com.padepokan79.util.DatabaseConnection;

public class MdSsbpController extends DatabaseConnection implements MdSsbp {
	public JSONArray simpleQuery(String query){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();

			//System.out.println("------ ------ ------ ----- -----");
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMencariSSbpByKode(String query,Integer inputKode){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, inputKode);
			ResultSet rs = (ResultSet) st.executeQuery();

			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryMencariSsbpByKode(Integer inputKode){
		try
		{
			String query = cariSsbpBykdTrans;
			return queryMencariSSbpByKode(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryTampilSsbp(){
		try
		{
			String query = tampilSsbp;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}
