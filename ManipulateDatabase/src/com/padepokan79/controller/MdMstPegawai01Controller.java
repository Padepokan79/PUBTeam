package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdMstPegawai01;
import com.padepokan79.util.DatabaseConnection;
//by ILFA SRI DESY
public class MdMstPegawai01Controller extends DatabaseConnection implements MdMstPegawai01{
	public MdMstPegawai01Controller() {
		
	}
	public JSONArray queryInsertMstPegawai01(String query, String nip, String nama, String tgl, String pendidikan) {
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			st.setString(2, nama);
			st.setString(3, tgl);
			st.setString(4, pendidikan);
			
			st.executeUpdate();
			if(st!=null) {
				st.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray querySelectAllMstPegawai01(String query) throws SQLException{
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
	
	
	public JSONArray queryMencariMstPegawai01(String query, String nip) {
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
	
	public JSONArray queryUpdateMstPegawai01(String query, String nama, String nip) {
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nama);
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
	public JSONArray queryDeleteMstPegawai01(String query, String nip) {
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
		
	public JSONArray getQueryInsertMstPegawai01(String nip, String nama, String tgl, String pendidikan) {
		try {
			String query=queryInsertMstPegawai01;
			return queryInsertMstPegawai01(query, nip, nama, tgl, pendidikan);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQuerySelectAllMstPegawai01() {
		try {
			String query =querySelectAllMstPegawai01;
			return querySelectAllMstPegawai01(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMencariMstPegawai01(String nip) {
		try {
			String query =queryMencariMstPegawai01;
			return queryMencariMstPegawai01(query, nip);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryUpdateMstPegawai01(String nama, String nip) {
		try {
			String query=queryUpdateMstPegawai01;
			return queryUpdateMstPegawai01(query, nama, nip);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryDeleteMstPegawai01(String nip) {
		try {
			String query = queryDeleteMstPegawai01;
			return queryDeleteMstPegawai01(query, nip);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
