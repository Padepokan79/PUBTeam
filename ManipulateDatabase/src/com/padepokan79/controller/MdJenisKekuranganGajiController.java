package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdJenisKekuranganGaji;
import com.padepokan79.util.DatabaseConnection;
//by ILFA SRI DESY
public class MdJenisKekuranganGajiController extends DatabaseConnection implements MdJenisKekuranganGaji{
	public MdJenisKekuranganGajiController() {
		
	}
	public JSONArray queryInsertJenisKekuranganGaji(String query, int kode, String nama) throws SQLException{
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
	
	public JSONArray querySelectAllJenisKekuranganGaji(String query) throws SQLException{
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
	
	
	public JSONArray queryMencariJenisKekuranganGaji(String query, String nama) throws SQLException{
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
	
	public JSONArray queryUpdateJenisKekuranganGaji(String query, String nama, int kode) throws SQLException{
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
	
	public JSONArray queryDeleteJenisKekuranganGaji(String query, int kode) throws SQLException{
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
		
	public JSONArray getQueryInsertJenisKekuranganGaji(int kode, String nama) {
		try {
			String query=queryInsertJenisKekuranganGaji;
			return queryInsertJenisKekuranganGaji(query, kode, nama);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQuerySelectAllJenisKekuranganGaji() {
		try {
			String query = querySelectAllJenisKekuranganGaji;
			return querySelectAllJenisKekuranganGaji(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMencariJenisKekuranganGaji(String nama) {
		try {
			String query = queryMencariJenisKekuranganGaji;
			return queryMencariJenisKekuranganGaji(query, nama);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryUpdateJenisKekuranganGaji(String nama, int kode) {
		try {
			String query=queryUpdateJenisKekuranganGaji;
			return queryUpdateJenisKekuranganGaji(query, nama, kode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryDeleteJenisKekuranganGaji(int kode) {
		try {
			String query = queryDeleteJenisKekuranganGaji;
			return queryDeleteJenisKekuranganGaji(query, kode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
