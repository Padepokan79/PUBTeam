package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdFileWeb;
import com.padepokan79.model.MdHubkelTbl;
import com.padepokan79.model.MdJiwaPtkp;
import com.padepokan79.util.DatabaseConnection;

public class MdFileWebController extends DatabaseConnection implements MdFileWeb {

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
	
	public JSONArray ReadQuery(String query, String nmfile){
		PreparedStatement st = null;
		
		try
		{
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nmfile);
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
	
	public JSONArray InsertQuery(String query, String nmfile){
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setString(1, nmfile);
					
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
	
	public JSONArray UpdateQuery(String query, String nmlama, String nmfile) {
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
				
					st.setString(1, nmfile);
					st.setString(2, nmlama);
					
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
	
	public JSONArray DeleteQuery(String query, String nmfile) {
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setString(1, nmfile);
					
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
			return ReadAllQuery(ReadAllFileWeb);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray LihatData(String nmfile) {
		try {
			String query = LihatDataBaruFileWeb;
			return ReadQuery(query, nmfile);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray InsertData(String nmfile) {
		try {
			String query = TambahDataFileWeb;
			return InsertQuery(query, nmfile);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray UpdateData(String nmlama, String nmfile) {
		try {
			String query = UpdateDataBaruFileWeb;
			return UpdateQuery(query, nmlama, nmfile);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray DeleteData(String nmfile) {
		try {
			String query =DeleteDataBaruFileWeb;
			return DeleteQuery(query, nmfile);
		}catch(Exception e) {
			
		}
		return null;
		
	}
}
