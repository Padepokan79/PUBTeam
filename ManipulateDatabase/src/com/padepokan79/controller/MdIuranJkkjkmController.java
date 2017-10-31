package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdIuranJkkjkm;
import com.padepokan79.util.DatabaseConnection;
//by ILFA SRI DESY
public class MdIuranJkkjkmController extends DatabaseConnection implements MdIuranJkkjkm{
	public MdIuranJkkjkmController() {
		
	}
	public JSONArray queryInsertIuranJkkjkm(String query, String nip, String tgl, int kode, int jk, int jm) {
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			st.setString(2, tgl);
			st.setInt(3, kode);
			st.setInt(4, jk);
			st.setInt(5, jm);
			st.executeUpdate();
			if(st!=null) {
				st.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray querySelectAllIuranJkkjkm(String query) throws SQLException{
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
	
	
	public JSONArray queryMencariIuranJkkjkm(String query, String nip) {
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
	
	public JSONArray queryUpdateIuranJkkjkm(String query, int jk, int jm, String nip, String tgl, int kode) {
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, jk);
			st.setInt(2, jm);
			st.setString(3, nip);
			st.setString(4, tgl);
			st.setInt(5, kode);
			st.executeUpdate();
			if(st!=null) {
				st.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryDeleteIuranJkkjkm(String query, String nip, String tgl, int kode) {
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			st.setString(2, tgl);
			st.setInt(3, kode);
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
		
	public JSONArray getQueryInsertIuranJkkjkm(String nip, String tgl, int kode, int jk, int jm) {
		try {
			String query=queryInsertIuranJkkjkm;
			return queryInsertIuranJkkjkm(query, nip, tgl, kode, jk, jm);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQuerySelectAllIuranJkkjkm() {
		try {
			String query = querySelectAllIuranJkkjkm;
			return querySelectAllIuranJkkjkm(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMencariIuranJkkjkm(String nip) {
		try {
			String query =queryMencariIuranJkkjkm;
			return queryMencariIuranJkkjkm(query, nip);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryUpdateIuranJkkjkm(int jk, int jm, String nip, String tgl, int kode) {
		try {
			String query=queryUpdateIuranJkkjkm;
			return queryUpdateIuranJkkjkm(query, jk, jm, nip, tgl, kode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryDeleteIuranJkkjkm(String nip, String tgl, int kode) {
		try {
			String query = queryDeleteIuranJkkjkm;
			return queryDeleteIuranJkkjkm(query, nip, tgl, kode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
