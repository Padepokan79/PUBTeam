package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.ListQuery;
import com.padepokan79.util.DatabaseConnection;

public class Automut extends DatabaseConnection implements ListQuery{
	public Automut() {

	}

	public JSONArray queryMencariTanggalPensiundanKodeStapeg(String query, String tglPensiun,String kdStaPeg_l){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, tglPensiun);
			st.setString(2, kdStaPeg_l);


			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryMencariTanggalPensiundanKodeStapeg(String tglPensiun,String kdStaPeg_l){
		try
		{
			String query = queryMencariTanggalPensiundanKodeStapeg;
			return queryMencariTanggalPensiundanKodeStapeg(query, tglPensiun,kdStaPeg_l);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryKodeStapegdanNamaStapeg(String query, String tglPensiun){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, tglPensiun);
		


			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryKodeStapegdanNamaStapeg(String tglPensiun){
		try
		{
			String query = queryKodeStapegdanNamaStapeg;
			return queryKodeStapegdanNamaStapeg(query, tglPensiun);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
