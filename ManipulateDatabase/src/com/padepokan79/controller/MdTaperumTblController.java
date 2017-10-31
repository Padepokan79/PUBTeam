package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdTaperumTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdTaperumTblController extends DatabaseConnection implements MdTaperumTbl{

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
	
	public JSONArray ReadAllDataTaperum_tbl(){
		try
		{
			String query = SelectDataTaperum_tbl;
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
	public JSONArray searchDataTaperum_tbl(String kode){
		try
		{
			String query = searchDataTaperum_tbl;
			return searchQuery(query,kode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray insertQuery(String query, int kdgol,String nilai ) throws SQLException{
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setInt(1, kdgol);
					st.setString(2, nilai);
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
	public JSONArray insertDataTaperum_tbl(int  kdgol, String nilai){
		try
		{
			String query = insertDataTaperum_tbl;
			return insertQuery(query,kdgol,nilai);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray updateQuery(String query,  int kdgol,String nilai  ) throws SQLException{
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setString(1, nilai);
					st.setInt(2, kdgol);
					
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
	public JSONArray updateDataTaperum_tbl(  String nilai,int kdgol){
		try
		{
			String query = updateDataTaperum_tbl;
			return updateQuery(query,kdgol,nilai);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray deleteQuery(String query,String kdgol  ) throws SQLException{
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setString(1, kdgol);
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
	public JSONArray deleteDataTaperum_tbl( String kdgol){
		try
		{
			String query = deleteDataTaperum_tbl;
			return deleteQuery(query,kdgol);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
