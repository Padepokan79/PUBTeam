package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.ListQuery;
import com.padepokan79.util.DatabaseConnection;

public class UnitKerja extends DatabaseConnection implements ListQuery{
	public UnitKerja() {

	}

	public JSONArray simpleQuery(String query, int nextPage){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, nextPage);
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray simpleQuery(String query, String inputName, int nextPage){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, inputName);
			st.setInt(2, nextPage);
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray getQueryNIPAtasanDanJabatanAtasanDanNamaAtasanTidakKosong(int nextPage){
		try
		{
			String query = queryNIPAtasanDanJabatanAtasanDanNamaAtasanTidakKosong;
			return simpleQuery(query, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenampilkanBerdasarkanNamaJabatanAtasan(String inputName, int nextPage){
		try
		{
			String query = queryMenampilkanBerdasarkanNamaJabatanAtasan;
			return simpleQuery(query, inputName, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenampilkanBerdasarkanNamaBendahara(String inputName, int nextPage){
		try
		{
			String query = queryMenampilkanBerdasarkanNamaBendahara;
			return simpleQuery(query, inputName, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray getQueryMenampilkanBerdasarkanNamaOperator(String inputName, int nextPage){
		try
		{
			String query = queryMenampilkanBerdasarkanNamaOperator;
			return simpleQuery(query, inputName, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}