package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;

import com.padepokan79.model.MdHubkelTbl;
import com.padepokan79.model.MdJiwaPtkp;
import com.padepokan79.util.DatabaseConnection;

public class MdJiwaPtkpController extends DatabaseConnection implements MdJiwaPtkp {

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
			//rs=null;
		
			if(st!=null) {
				st.close();
			}
			
		return result;
		}catch(Exception e){
			
		}
		return null;
	
	}
	
	public JSONArray InsertQuery(String query, String nip, int thn, int jistri, int janak){
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setString(1, nip);
					st.setInt(2, thn);
					st.setInt(3, jistri);
					st.setInt(4, janak);
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
	
	public JSONArray UpdateQuery(String query, String nip, int janak) {
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					
					st.setInt(1, janak);
					st.setString(2, nip);
					
					
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
			return ReadAllQuery(ReadJiwaPtkp);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray LihatData(String nip) {
		try {
			String query = searchJiwaPtkp;
			return ReadQuery(query, nip);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray InsertData(String nip, int thn, int jistri, int janak) {
		try {
			String query = TambahDataJiwaPtkp;
			return InsertQuery(query, nip, thn, jistri, janak);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray UpdateData(String nip, int janak) {
		try {
			String query = UpdateTahunDataBaruJiwaPtkp;
			return UpdateQuery(query, nip, janak);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray DeleteData(String nip) {
		try {
			String query =DeleteDataBaruJiwaPtkp;
			return DeleteQuery(query, nip);
		}catch(Exception e) {
			
		}
		return null;
		
	}
}
