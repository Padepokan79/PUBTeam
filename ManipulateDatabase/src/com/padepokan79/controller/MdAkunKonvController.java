package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdAkunKonv;
import com.padepokan79.util.DatabaseConnection;

public class MdAkunKonvController extends DatabaseConnection implements MdAkunKonv{
	public MdAkunKonvController () {
		
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
	
	public JSONArray SearchData(String query,String inputKode) throws SQLException{
		PreparedStatement st =null;
		try {
			st=(PreparedStatement)  conn.prepareStatement(query);
			st.setString(1,inputKode);
			
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
	
	public JSONArray getSearchData(String inputKode){
		try
		{
			String query = SearchData;
			return SearchData(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray UpdateData(String query,int urt,String inputKode) throws SQLException {
		PreparedStatement st =null;
		try {
			st=(PreparedStatement)conn.prepareStatement(query);
			st.setInt(1, urt);
			st.setString(2, inputKode);
			
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getUpdateData(int urt,String inputKode){
		try
		{
			String query = UpdateData;
			return UpdateData(query,urt,inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray CreateData(String query, String kdtrans, int urt) throws SQLException{
		PreparedStatement st =null;
		try
		{
			st=(PreparedStatement)conn.prepareStatement(query);
			st.setString(1, kdtrans);
			st.setInt(2, urt);
			
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public JSONArray getCreateData(String kdtrans, int urt){
		try
		{
			String query = CreateData;
			return CreateData(query, kdtrans, urt);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray DeleteData(String query, String kdtrans)throws SQLException{
		PreparedStatement st =null;
		try
		{
			st=(PreparedStatement)conn.prepareStatement(query);
			st.setString(1,kdtrans );
			
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getDeleteData(String kdtrans){
		try
		{
			String query = DeleteData;
			return DeleteData(query, kdtrans);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	
}
