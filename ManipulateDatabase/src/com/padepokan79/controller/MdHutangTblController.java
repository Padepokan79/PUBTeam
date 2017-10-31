package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdHutangTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdHutangTblController extends DatabaseConnection implements MdHutangTbl {

	public JSONArray readAllQuery(String query) throws SQLException{
		PreparedStatement st = null;
		
		try
		{
			st=(PreparedStatement) conn.prepareStatement(query);
			// execute the query, and get a java resultset
			//for insert, update, delete
			//st.executeUpdate();
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result=Convertor.convertToJSON(rs);
			//rs=null;
		
			if(st!=null) {
				st.close();
			}
			
		return result;
		}catch(Exception e){
			
		}
		return null;
	
	}
	
	public JSONArray ReadAllDataHutang_tbl(){
		try
		{
			String query = SelectDataHutang_tbl;
			return readAllQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray searchQuery(String query, String kode  ) throws SQLException{
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setString(1, kode);
					// execute the query, and get a java resultset
					//for insert, update, delete
					//st.executeUpdate();
					ResultSet rs = (ResultSet) st.executeQuery();
					JSONArray result=Convertor.convertToJSON(rs);
					//rs=null;
				
					if(st!=null) {
						st.close();
					}
					
				return result;
				}catch(Exception e){
					
				}
				return null;
			
			}
	public JSONArray searchDataHutang_tbl(String kode){
		try
		{
			String query = searchDataHutang_tbl;
			return searchQuery(query,kode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray insertQuery(String query, int kdhutang,String nmhutang ) throws SQLException{
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setInt(1, kdhutang);
					st.setString(2, nmhutang);
					// execute the query, and get a java resultset
					//for insert, update, delete
					//st.executeUpdate();
					//ResultSet rs = (ResultSet) st.executeQuery();
					st.executeUpdate();
					//JSONArray result=Convertor.convertToJSON(rs);
					//rs=null;
				
					if(st!=null) {
						st.close();
					}
					
				return null;
				}catch(Exception e){
					
				}
				return null;
			
			}
	public JSONArray insertDataHutang_tbl(int  k, String nmhutang){
		try
		{
			String query = insertDataHutang_tbl;
			return insertQuery(query,k,nmhutang);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray updateQuery(String query,  int kdhutang,String nmhutang  ) throws SQLException{
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setString(1, nmhutang);
					st.setInt(2, kdhutang);
					
					// execute the query, and get a java resultset
					//for insert, update, delete
					//st.executeUpdate();
					//ResultSet rs = (ResultSet) st.executeQuery();
					st.executeUpdate();
					//JSONArray result=Convertor.convertToJSON(rs);
					//rs=null;
				
					if(st!=null) {
						st.close();
					}
					
				return null;
				}catch(Exception e){
					
				}
				return null;
			
			}
	public JSONArray updateDataHutang_tbl(  String nmhutang,int kdhutang){
		try
		{
			String query = updateDataHutang_tbl;
			return updateQuery(query,kdhutang,nmhutang);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray deleteQuery(String query,String kdhutang  ) throws SQLException{
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setString(1, kdhutang);
					// execute the query, and get a java resultset
					//for insert, update, delete
					//st.executeUpdate();
					//ResultSet rs = (ResultSet) st.executeQuery();
					st.executeUpdate();
					//JSONArray result=Convertor.convertToJSON(rs);
					//rs=null;
				
					if(st!=null) {
						st.close();
					}
					
				return null;
				}catch(Exception e){
					
				}
				return null;
			
			}
	public JSONArray deleteDataHutang_tbl( String kdeselon){
		try
		{
			String query = deleteDataHutang_tbl;
			return deleteQuery(query,kdeselon);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
