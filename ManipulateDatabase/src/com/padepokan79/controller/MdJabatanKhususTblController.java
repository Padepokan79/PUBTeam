package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdJabatanKhususTbl;
import com.padepokan79.util.DatabaseConnection;
//by ILFA SRI DESY
public class MdJabatanKhususTblController extends DatabaseConnection implements MdJabatanKhususTbl{
	public MdJabatanKhususTblController() {
		
	}
	public JSONArray queryInsertJabatanKhususTbl(String query, String tgl, String kode, String nama, int jml, int pensiun) {
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, tgl);
			st.setString(2, kode);
			st.setString(3, nama);
			st.setInt(4, jml);
			st.setInt(5, pensiun);
			st.executeUpdate();
			if(st!=null) {
				st.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray querySelectAllJabatanKhususTbl(String query) throws SQLException{
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
	
	
	public JSONArray queryMencariJabatanKhususTbl(String query, String nama) {
		PreparedStatement st = null;
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
	
	public JSONArray queryUpdateJabatanKhususTbl(String query, int pensiun, String tgl, String kode) {
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, pensiun);
			st.setString(2, tgl);
			st.setString(3, kode);
			st.executeUpdate();
			if(st!=null) {
				st.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryDeleteJabatanKhususTbl(String query, String tgl, String kode) {
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, tgl);
			st.setString(2, kode);
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
		
	public JSONArray getQueryInsertJabatanKhususTbl(String tgl, String kode, String nama, int jml, int pensiun) {
		try {
			String query=queryInsertJabatanKhususTbl;
			return queryInsertJabatanKhususTbl(query, tgl, kode, nama, jml, pensiun);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQuerySelectAllJabatanKhususTbl() {
		try {
			String query = querySelectAllJabatanKhususTbl;
			return querySelectAllJabatanKhususTbl(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMencariJabatanKhususTbl(String nama) {
		try {
			String query = queryMencariJabatanKhususTbl;
			return queryMencariJabatanKhususTbl(query, nama);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryUpdateJabatanKhususTbl(int pensiun, String tgl, String kode) {
		try {
			String query=queryUpdateJabatanKhususTbl;
			return queryUpdateJabatanKhususTbl(query, pensiun, tgl, kode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryDeleteJabatanKhususTbl(String tgl, String kode) {
		try {
			String query = queryDeleteJabatanKhususTbl;
			return queryDeleteJabatanKhususTbl(query, tgl, kode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
