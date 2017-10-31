package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdTkdTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdTkdTblController extends DatabaseConnection implements MdTkdTbl{
	public MdTkdTblController() {
		
	}
	
	public JSONArray queryInsertTkdTbl(String query, String tgl, int kode, String nama, int tkd) throws SQLException{
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, tgl);
			st.setInt(2, kode);
			st.setString(3, nama);
			st.setInt(4, tkd);
			st.executeUpdate();
			if(st!=null) {
				st.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray querySelectAllTkdTbl(String query) throws SQLException{
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
	
	
	public JSONArray queryMencariTkdTbl(String query, String nama) throws SQLException{
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
	
	public JSONArray queryUpdateTkdTbl(String query, String nama, int tkd, String tgl, int kode) throws SQLException{
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nama);
			st.setInt(2, tkd);
			st.setString(3, tgl);
			st.setInt(4, kode);
			st.executeUpdate();
			if(st!=null) {
				st.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryDeleteTkdTbl(String query, String tgl, int kode) throws SQLException{
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, tgl);
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
	//=========================================================================================
		
	public JSONArray getQueryInsertTkdTbl(String tgl, int kode, String nama, int tkd) {
		try {
			String query=queryInsertTkdTbl;
			return queryInsertTkdTbl(query, tgl, kode, nama, tkd);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQuerySelectAllTkdTbl() {
		try {
			String query =querySelectAllTkdTbl;
			return querySelectAllTkdTbl(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMencariTkdTbl(String nama) {
		try {
			String query = queryMencariTkdTbl;
			return queryMencariTkdTbl(query, nama);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryUpdateTkdTbl(String nama, int tkd, String tgl, int kode) {
		try {
			String query=queryUpdateTkdTbl;
			return queryUpdateTkdTbl(query, nama, tkd, tgl, kode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryDeleteTkdTbl(String tgl, int kode) {
		try {
			String query = queryDeleteTkdTbl;
			return queryDeleteTkdTbl(query, tgl, kode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
