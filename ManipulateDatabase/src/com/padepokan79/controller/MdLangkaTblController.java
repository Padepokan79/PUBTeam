package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdLangkaTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdLangkaTblController extends DatabaseConnection implements MdLangkaTbl{
	public MdLangkaTblController() {
		
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
	public JSONArray SearchData(String query,int kdlangka) throws SQLException{
		PreparedStatement st =null;
		try {
			st=(PreparedStatement)  conn.prepareStatement(query);
			st.setInt(1,kdlangka);
			
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
	
	public JSONArray getSearchData(int kdlangka){
		try
		{
			String query = SearchData;
			return SearchData(query, kdlangka);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray UpdateData(String query,String uraian_langka,int kdlangka) throws SQLException {
		PreparedStatement st =null;
		try {
			st=(PreparedStatement)conn.prepareStatement(query);
			st.setString(1, uraian_langka);
			st.setInt(2, kdlangka);
			
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getUpdateData(String uraian_langka,int kdlangka){
		try
		{
			String query = UpdateData;
			return UpdateData(query,uraian_langka,kdlangka);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray CreateData(String query, int kdlangka, String uraian_langka,int jumlah) throws SQLException{
		PreparedStatement st =null;
		try
		{
			st=(PreparedStatement)conn.prepareStatement(query);
			st.setInt(1, kdlangka);
			st.setString(2, uraian_langka);
			st.setInt(3, jumlah);
			
			
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public JSONArray getCreateData(int kdlangka, String uraian_langka,int jumlah){
		try
		{
			String query = CreateData;
			return CreateData(query,kdlangka,uraian_langka,jumlah);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray DeleteData(String query, int kdlangka)throws SQLException{
		PreparedStatement st =null;
		try
		{
			st=(PreparedStatement)conn.prepareStatement(query);
			st.setInt(1,kdlangka );
			
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getDeleteData(int langka){
		try
		{
			String query = DeleteData;
			return DeleteData(query,langka);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
