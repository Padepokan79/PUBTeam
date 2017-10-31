package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdStawinTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdStawinTblController extends DatabaseConnection implements MdStawinTbl{
	public MdStawinTblController() {
		
	}
	public JSONArray queryInsertStawinTbl(String query, int kode, String nama) throws SQLException{
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, kode);
			st.setString(2, nama);
			st.executeUpdate();
			if(st!=null) {
				st.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray querySelectAllStawinTbl(String query) throws SQLException{
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
	
	
	public JSONArray queryMencariStawinTbl(String query, String nama) throws SQLException{
		PreparedStatement st=null;
		
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nama);
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
	
	public JSONArray queryUpdateStawinTbl(String query, String nama, int kode) throws SQLException{
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nama);
			st.setInt(2, kode);
			st.executeUpdate();
			if(st!=null) {
				st.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryDeleteStawinTbl(String query, int kode) throws SQLException{
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, kode);
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
		
	public JSONArray getQueryInsertStawinTbl(int kode, String nama) {
		try {
			String query=queryInsertStawinTbl;
			return queryInsertStawinTbl(query, kode, nama);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQuerySelectAllStawinTbl() {
		try {
			String query = querySelectAllStawinTbl;
			return querySelectAllStawinTbl(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMencariStawinTbl(String nama) {
		try {
			String query = queryMencariStawinTbl;
			return queryMencariStawinTbl(query, nama);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryUpdateStawinTbl(String nama, int kode) {
		try {
			String query=queryUpdateStawinTbl;
			return queryUpdateStawinTbl(query, nama, kode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryDeleteStawinTbl(int kode) {
		try {
			String query = queryDeleteStawinTbl;
			return queryDeleteStawinTbl(query, kode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}
