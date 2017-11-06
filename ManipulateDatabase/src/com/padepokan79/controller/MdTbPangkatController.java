package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdTbPangkat;
import com.padepokan79.util.DatabaseConnection;
//by ILFA SRI DESY
public class MdTbPangkatController extends DatabaseConnection implements MdTbPangkat{
	public MdTbPangkatController() {
		
	}
	public JSONArray queryInsertTbPangkat(String query, String pkt010, String pkt020, String pkt030, String pkt040, String pkt050) {
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, pkt010);
			st.setString(2, pkt020);
			st.setString(3, pkt030);
			st.setString(4, pkt040);
			st.setString(5, pkt050);
			st.executeUpdate();
			if(st!=null) {
				st.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public JSONArray querySelectAllTbPangkat(String query) throws SQLException{
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
	
	
	public JSONArray queryMencariTbPangkat(String query, String pkt010) {
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, pkt010);
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
	
	public JSONArray queryUpdateTbPangkat(String query, String pkt030, String pkt010) {
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, pkt030);
			st.setString(2, pkt010);
			
			st.executeUpdate();
			if(st!=null) {
				st.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryDeleteTbPangkat(String query, String pkt010) {
		PreparedStatement st = null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, pkt010);
		
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
		
	public JSONArray getQueryInsertTbPangkat(String pkt010, String pkt020, String pkt030, String pkt040, String pkt050) {
		try {
			String query=queryInsertTbPangkat;
			return queryInsertTbPangkat(query, pkt010, pkt020, pkt030, pkt040, pkt050);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public JSONArray getQuerySelectAllTbPangkat() {
		try {
			String query =querySelectAllTbPangkat;
			return querySelectAllTbPangkat(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMencariTbPangkat(String pkt010) {
		try {
			String query =queryMencariTbPangkat;
			return queryMencariTbPangkat(query, pkt010);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryUpdateTbPangkat(String nama, String pkt010) {
		try {
			String query=queryUpdateTbPangkat;
			return queryUpdateTbPangkat(query, nama, pkt010);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryDeleteTbPangkat(String pkt010) {
		try {
			String query = queryDeleteTbPangkat;
			return queryDeleteTbPangkat(query, pkt010);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
