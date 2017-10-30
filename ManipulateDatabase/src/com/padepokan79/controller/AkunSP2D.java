package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.ListQuery;
import com.padepokan79.util.DatabaseConnection;

public class AkunSP2D extends DatabaseConnection implements ListQuery{

	public AkunSP2D() {
		
	}

	public JSONArray queryMencariKDSKPDdiAkunsp2d(String query, int inputKode, int nextPage){
		try
		{	
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			
				st.setInt(1, inputKode);
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
	public JSONArray queryMencariKDTRANSdiAkunsp2d(String query, int inputKode, int nextPage){
		try
		{	
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			
				st.setInt(1, inputKode);
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
	public JSONArray queryListKDTransdiAkunsp2d(String query, int inputKode, int nextPage){
		try
		{	
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			
				st.setInt(1, inputKode);
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
	public JSONArray getqueryMencariBerdasakanKDSKPDdiAkunsp2d(int kodeSKPD, int nextPage){
		try
		{
			String query = queryMencariBerdasakanKDSKPDdiAkunsp2d;
			return queryMencariKDSKPDdiAkunsp2d(query, kodeSKPD, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getqueryMencariBerdasakanKDTRANSdiAkunsp2d(int kodeTRANS, int nextPage){
		try
		{
			String query = queryMencariBerdasakanKDTRANSdiAkunsp2d;
			return queryMencariKDTRANSdiAkunsp2d(query, kodeTRANS, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getqueryListKDTransdiAkunsp2d(int kodeTRANS, int nextPage){
		try
		{
			String query = queryListKDTransdiAkunsp2d;
			return queryListKDTransdiAkunsp2d(query, kodeTRANS, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}