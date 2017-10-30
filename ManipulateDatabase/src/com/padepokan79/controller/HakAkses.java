package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.ListQuery;
import com.padepokan79.util.DatabaseConnection;

public class HakAkses extends DatabaseConnection implements ListQuery{

	public HakAkses() {
		
	}
	
	public JSONArray queryMenghitungJumlahHakAksesBerdasarkanPemakai(String query){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			
			ResultSet rs = (ResultSet) st.executeQuery();

			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMencariYangMenggunakanKodeHakAkses(String query, int inputKode, int nextPage){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, inputKode);
				st.setInt(2, nextPage);
			ResultSet rs = (ResultSet) st.executeQuery();

			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenghitungJumlahHakAksesBerdasarkanPemakai(){
		try
		{
			String query = queryMenghitungJumlahHakAksesBerdasarkanPemakai;
			return queryMenghitungJumlahHakAksesBerdasarkanPemakai(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryMencariYangMenggunakanKodeHakAkses(int inputKode, int nextPage){
		try
		{
			String query = queryMencariYangMenggunakanKodeHakAkses;
			return queryMencariYangMenggunakanKodeHakAkses(query, inputKode, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
