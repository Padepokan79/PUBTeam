package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdHistorisSatker;
import com.padepokan79.util.DatabaseConnection;

public class MdHistorisSatkerController extends DatabaseConnection implements MdHistorisSatker {
	public MdHistorisSatkerController() {
		
	}
	
	public JSONArray ReadData(String query) throws SQLException{
		PreparedStatement st =null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result=Convertor.convertToJSON(rs);
			rs=null;
			if (st!=null) {
				st.close();
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getReadData() {
		try {
			String query = ReadData;
			return ReadData(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray SearchData(String query,String nip) throws SQLException{
		PreparedStatement st =null;
		try {
			st=(PreparedStatement)  conn.prepareStatement(query);
			st.setString(1,nip);
			
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result=Convertor.convertToJSON(rs);
			rs=null;
			if (st!=null) {
				st.close();
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getSearchData(String nip){
		try
		{
			String query = SearchData;
			return SearchData(query, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray UpdateData(String query,String keterangan,String tmtgaji,String nip) throws SQLException {
		PreparedStatement st =null;
		try {
			st=(PreparedStatement)conn.prepareStatement(query);
			st.setString(1, keterangan);
			st.setString(2, tmtgaji);
			st.setString(3, nip);
			
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getUpdateData(String keterangan,String tmtgaji,String nip){
		try
		{
			String query = UpdateData;
			return UpdateData(query,keterangan,tmtgaji,nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray CreateData(String query, String tmtgaji, String nip,String kdssbp,String kdskpd,String kdsatker,String tglskep,String nomorskep,String penerbitskep,String keterangan,String tglupdate,String updater) throws SQLException{
		PreparedStatement st =null;
		try
		{
			st=(PreparedStatement)conn.prepareStatement(query);
			st.setString(1, tmtgaji);
			st.setString(2, nip);
			st.setString(3, kdssbp);
			st.setString(4, kdskpd);
			st.setString(5, kdsatker);
			st.setString(6, tglskep);
			st.setString(7, nomorskep);
			st.setString(8, penerbitskep);
			st.setString(9, keterangan);
			st.setString(10, tglupdate);
			st.setString(11, updater);
			
			
			
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public JSONArray getCreateData(String tmtgaji, String nip,String kdssbp,String kdskpd,String kdsatker,String tglskep,String nomorskep,String penerbitskep,String keterangan,String tglupdate,String updater){
		try
		{
			String query = CreateData;
			return CreateData(query,tmtgaji,nip,kdssbp,kdskpd,kdsatker,tglskep,nomorskep,penerbitskep,keterangan,tglupdate,updater);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray DeleteData(String query, String tmtgaji,String nip)throws SQLException{
		PreparedStatement st =null;
		try
		{
			st=(PreparedStatement)conn.prepareStatement(query);
			st.setString(1,tmtgaji );
			st.setString(2,nip );
			
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getDeleteData(String tmtgaji,String nip){
		try
		{
			String query = DeleteData;
			return DeleteData(query,tmtgaji,nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
