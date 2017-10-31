package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdPhoto;
import com.padepokan79.util.DatabaseConnection;

public class MdPhotoController extends DatabaseConnection implements MdPhoto{
	public MdPhotoController() {
		
	}
	public JSONArray queryInsertPhoto(String query, String nip, String gambar) throws SQLException{
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			st.setString(2, gambar);
			st.executeUpdate();
			if(st!=null) {
				st.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray querySelectAllPhoto(String query) throws SQLException{
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result = Convertor.convertToJSON(rs);
			rs=null;
			if(st!=null) {
				st.close();
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	public JSONArray queryMencariPhoto(String query, String nip) throws SQLException{
		PreparedStatement st=null;
		
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result = Convertor.convertToJSON(rs);
			rs=null;
			if(st!=null) {
				st.close();
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryUpdatePhoto(String query, String gambar, String nip) throws SQLException{
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, gambar);
			st.setString(2, nip);
			st.executeUpdate();
			if(st!=null) {
				st.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryDeletePhoto(String query, String nip) throws SQLException{
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			st.executeUpdate();
			if(st!=null) {
				st.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	//=========================================================================================
		
	public JSONArray getQueryInsertPhoto(String nip, String gambar) {
		try {
			String query=queryInsertPhoto;
			return queryInsertPhoto(query, nip, gambar);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQuerySelectAllPhoto() {
		try {
			String query = querySelectAllPhoto;
			return querySelectAllPhoto(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMencariPhoto(String nip) {
		try {
			String query = queryMencariPhoto;
			return queryMencariPhoto(query, nip);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryUpdatePhoto(String gambar, String nip) {
		try {
			String query=queryUpdatePhoto;
			return queryUpdatePhoto(query, gambar, nip);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryDeletePhoto(String nip) {
		try {
			String query = queryDeletePhoto;
			return queryDeletePhoto(query, nip);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
