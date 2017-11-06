package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdGajib;
import com.padepokan79.util.DatabaseConnection;
//by ILFA SRI DESY
public class MdGajibController extends DatabaseConnection implements MdGajib{
	public MdGajibController() {
		
	}
	public JSONArray queryInsertGajib(String query, String nip, String nama, String namasat, int gapok) {
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			st.setString(2, nama);
			st.setString(3, namasat);
			st.setInt(4, gapok);
			
			st.executeUpdate();
			if(st!=null) {
				st.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray querySelectAllGajib(String query) throws SQLException{
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
	
	
	public JSONArray queryMencariGajib(String query, String nip) {
		PreparedStatement st = null;
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
	
	public JSONArray queryUpdateGajib(String query, int gapok, String nip) {
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, gapok);
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
	public JSONArray queryDeleteGajib(String query, String nip) {
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
		
	public JSONArray getQueryInsertGajib(String nip, String nama, String namasat, int gapok) {
		try {
			String query=queryInsertGajib;
			return queryInsertGajib(query, nip, nama, namasat, gapok);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQuerySelectAllGajib() {
		try {
			String query =querySelectAllGajib;
			return querySelectAllGajib(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMencariGajib(String nip) {
		try {
			String query =queryMencariGajib;
			return queryMencariGajib(query, nip);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryUpdateGajib(int gapok, String nip) {
		try {
			String query=queryUpdateGajib;
			return queryUpdateGajib(query, gapok, nip);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryDeleteGajib(String nip) {
		try {
			String query = queryDeleteGajib;
			return queryDeleteGajib(query, nip);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
