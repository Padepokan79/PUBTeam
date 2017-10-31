package com.padepokan79.controller;

import org.json.JSONArray;

import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdHistorisJiwaQuery;
import com.padepokan79.util.DatabaseConnection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class MdHistorisJiwaController extends DatabaseConnection implements MdHistorisJiwaQuery{
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
	public JSONArray getSelectTable(){
		try
		{
			
			return simpleQuery(selectTable);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
