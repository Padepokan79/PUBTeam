package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdHitungTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdHitungTblController extends DatabaseConnection implements MdHitungTbl {
	public MdHitungTblController() {
		// TODO Auto-generated constructor stub
	}
	
	public JSONArray CreateData(String query, int kdhitung, String nmhitung) throws SQLException{
		PreparedStatement st =null;
		try
		{
			st=(PreparedStatement)conn.prepareStatement(query);
			st.setInt(1, kdhitung);
			st.setString(2, nmhitung);
			
			
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public JSONArray getCreateData(int kdhitung, String nmhitung){
		try
		{
			String query = CreateData;
			return CreateData(query,kdhitung,nmhitung);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
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
	
	public JSONArray UpdateData(String query,String nmhitung,int kdhitung) throws SQLException {
		PreparedStatement st =null;
		try {
			st=(PreparedStatement)conn.prepareStatement(query);
			st.setString(1, nmhitung);
			st.setInt(2, kdhitung);
			
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getUpdateData(String nmhitung,int kdhitung){
		try
		{
			String query = UpdateData;
			return UpdateData(query,nmhitung,kdhitung);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray DeleteData(String query, int kdhitung)throws SQLException{
		PreparedStatement st =null;
		try
		{
			st=(PreparedStatement)conn.prepareStatement(query);
			st.setInt(1,kdhitung );
			
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getDeleteData(int kdhitung){
		try
		{
			String query = DeleteData;
			return DeleteData(query,kdhitung);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray SearchData(String query,int kdhitung) throws SQLException{
		PreparedStatement st =null;
		try {
			st=(PreparedStatement)  conn.prepareStatement(query);
			st.setInt(1,kdhitung);
			
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
	
	public JSONArray getSearchData(int kdhitung){
		try
		{
			String query = SearchData;
			return SearchData(query, kdhitung);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	

}
