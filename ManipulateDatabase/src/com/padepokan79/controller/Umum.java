package com.padepokan79.controller;

import java.sql.DriverManager;

import org.json.JSONArray;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.ListQuery;
import com.padepokan79.util.DatabaseConnection;

public class Umum extends DatabaseConnection implements ListQuery{

	public Umum() {
		
	}

	public JSONArray queryMencariTJUmumBerdasarkanKodeGolongan(String query, int kodeGolongan, int nextPage){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			
				st.setInt(1, kodeGolongan);
				st.setInt(2, nextPage);	
			
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();

			//System.out.println("------ ------ ------ ----- -----");
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryMencariTJUmumBerdasarkanKodeGolongan(int kodeGolongan, int nextPage){
		try
		{
			String query = queryMencariTJUmumBerdasarkanKodeGolongan;
			return queryMencariTJUmumBerdasarkanKodeGolongan(query, kodeGolongan, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}