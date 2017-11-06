package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;

import com.padepokan79.model.MdHubkelTbl;
import com.padepokan79.model.MdJiwaPtkp;
import com.padepokan79.model.MdStapegTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdStapegTblController extends DatabaseConnection implements MdStapegTbl {

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
	
	public JSONArray ReadQuery(String query, int inputKode){
		PreparedStatement st = null;
		
		try
		{
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, inputKode);
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
	
	public JSONArray InsertQuery(String query, int kd,String nm, int kdjns){
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setInt(1, kd);
					st.setString(2, nm);
					st.setInt(3, kdjns);
					
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
	
	public JSONArray UpdateQuery(String query,  int kd, String nm) {
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					
					st.setString(1, nm);
					st.setInt(2, kd);
					
					
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
	
	public JSONArray DeleteQuery(String query, int kd) {
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setInt(1, kd);
					
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
			return ReadAllQuery(ReadStapegTbl);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray LihatData(int kd) {
		try {
			String query = SearchDataStapegTbl;
			return ReadQuery(query, kd);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray InsertData( int kd,String nm, int kdjns) {
		try {
			String query = TambahDataStapegTbl;
			return InsertQuery(query, kd, nm, kdjns);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray UpdateData(int kd,String nm) {
		try {
			String query = UpdateDataStapegTbl;
			return UpdateQuery(query, kd, nm);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray DeleteData(int kd) {
		try {
			String query =DeleteDataStapegTbl;
			return DeleteQuery(query, kd);
		}catch(Exception e) {
			
		}
		return null;
		
	}
}
