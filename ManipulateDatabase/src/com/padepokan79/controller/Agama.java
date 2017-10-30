package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.ListQuery;
import com.padepokan79.util.DatabaseConnection;

public class Agama extends DatabaseConnection implements ListQuery{
	public Agama() {

	}

	public JSONArray queryMencariNamaAgama(String query, int inputKode){
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
	public JSONArray getQueryMencariNamaAgama(int inputKode){
		try
		{
			String query = queryMencariNamaAgama;
			return queryMencariNamaAgama(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}