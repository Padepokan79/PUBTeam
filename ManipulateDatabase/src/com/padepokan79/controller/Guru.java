package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.ListQuery;
import com.padepokan79.util.DatabaseConnection;

public class Guru extends DatabaseConnection implements ListQuery{
	public Guru() {
		
	}

	public JSONArray queryMencariKodeGurudiTabelGuruTBL(String query, int inputKode){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, inputKode);
			
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();

			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryMencariKodeGurudiTabelGuruTBL(int inputKode){
		try
		{
			String query = queryMencariKodeGurudiTabelGuruTBL;
			return queryMencariKodeGurudiTabelGuruTBL(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}