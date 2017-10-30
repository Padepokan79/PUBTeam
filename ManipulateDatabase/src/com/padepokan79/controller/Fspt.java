package com.padepokan79.controller;

import java.sql.DriverManager;

import org.json.JSONArray;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.ListQuery;
import com.padepokan79.util.DatabaseConnection;

public class Fspt extends DatabaseConnection implements ListQuery{

	public Fspt() {

	}

	public JSONArray queryMencariPNSberdasarkanNoUrut(String query, int noUrut){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);

			st.setInt(1, noUrut);

			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();

			//System.out.println("------ ------ ------ ----- -----");
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryMencariPNSberdasarkanNoUrut(int noUrut){
		try
		{

			String query = queryMencariPNSberdasarkanNoUrut;
			return queryMencariPNSberdasarkanNoUrut(query, noUrut);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray queryMencariPNSberdasrkanNamaDanKDSKPDsecaraBersanaan(String query, String namaPNS, int kodeKDSKPD, int nextPage){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);

			st.setString(1, namaPNS);
			st.setInt(2, kodeKDSKPD);
			st.setInt(3, nextPage);

			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();

			//System.out.println("------ ------ ------ ----- -----");
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryMencariPNSberdasrkanNamaDanKDSKPDsecaraBersanaan(String namaPNS, int kodeKDSKPD, int nextPage){
		try
		{

			String query = queryMencariPNSberdasrkanNamaDanKDSKPDsecaraBersanaan;
			return queryMencariPNSberdasrkanNamaDanKDSKPDsecaraBersanaan(query, namaPNS, kodeKDSKPD, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}