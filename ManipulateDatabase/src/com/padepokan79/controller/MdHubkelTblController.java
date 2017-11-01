package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;

import com.padepokan79.model.MdHubkelTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdHubkelTblController extends DatabaseConnection implements MdHubkelTbl {

	public JSONArray ReadAllQuery(String query) throws SQLException{
		PreparedStatement st = null;
		
		try
		{
			st=(PreparedStatement) conn.prepareStatement(query);
			// execute the query, and get a java resultset
			//for insert, update, delete
			//st.executeUpdate();
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result=Convertor.convertToJSON(rs);
			//rs=null;
		
			if(st!=null) {
				st.close();
			}
			
		return result;
		}catch(Exception e){
			
		}
		return null;
	}
	
	public JSONArray ReadQuery(String query, String inputKode){
		PreparedStatement st = null;
		
		try
		{
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, inputKode);
			// execute the query, and get a java resultset
			//for insert, update, delete
			//st.executeUpdate();
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result=Convertor.convertToJSON(rs);
			rs=null;
		
			if(st!=null) {
				st.close();
			}
			
		return result;
		}catch(Exception e){
			
		}
		return null;
	
	}
	
	public JSONArray InsertQuery(String query, String kd, String nm){
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setString(1, kd);
					st.setString(2, nm);
					
					// execute the query, and get a java resultset
					//for insert, update, delete
					st.executeUpdate();
//					ResultSet rs = (ResultSet) st.executeQuery();
//					return Convertor.convertToJSON(rs);
				}catch (Exception e) {
					// TODO: handle exception
				}
				return null;
			}
	
	public JSONArray UpdateQuery(String query, String kd, String nm) {
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					
					st.setString(1, nm);
					st.setString(2, kd);
					
					
					// execute the query, and get a java resultset
					//for insert, update, delete
					st.executeUpdate();
//					ResultSet rs = (ResultSet) st.executeQuery();
//					return Convertor.convertToJSON(rs);
				}catch (Exception e) {
					// TODO: handle exception
				}
				return null;
			
			}
	
	public JSONArray DeleteQuery(String query, String kd) {
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setString(1, kd);
					
					// execute the query, and get a java resultset
					//for insert, update, delete
					st.executeUpdate();
//					ResultSet rs = (ResultSet) st.executeQuery();
//					return Convertor.convertToJSON(rs);
				}catch (Exception e) {
					// TODO: handle exception
				}
				return null;
			
			}
	public JSONArray LihatData() {
		try {
			return ReadAllQuery(ReadHubkelTbl);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray LihatData(String kdhubkel) {
		try {
			String query = LihatDataBaruHubkelTbl;
			return ReadQuery(query, kdhubkel);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray InsertData(String kd,String nm) {
		try {
			String query = TambahDataHubkelTbl;
			return InsertQuery(query, kd, nm);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray UpdateData(String kd, String nm) {
		try {
			String query = UpdateNamaHubDataBaruHubkelTbl;
			return UpdateQuery(query, kd, nm);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray DeleteData(String kd) {
		try {
			String query = DeleteDataBaruHubkelTbl;
			return DeleteQuery(query, kd);
		}catch(Exception e) {
			
		}
		return null;
		
	}
}
