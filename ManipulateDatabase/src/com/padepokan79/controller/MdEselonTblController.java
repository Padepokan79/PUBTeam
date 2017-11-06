package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdEselonTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdEselonTblController extends DatabaseConnection implements MdEselonTbl {

	public JSONArray simpleQuery(String query) throws SQLException{
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
	
	public JSONArray ReadAllDataEselon_tbl(){
		try
		{
			String query = SelectDataEselon_tbl;
			return simpleQuery(query);
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
	public JSONArray searchDataEselon_tbl(String kode){
		try
		{
			String query = searchDataEselon_tbl;
			return searchQuery(query,kode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray insertQuery(String query, String tmtEselon, String kdeselon, int rp_eselon,String uraian, int bup  ) throws SQLException{
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setString(1, tmtEselon);
					st.setString(2, kdeselon);
					st.setInt(3, rp_eselon);
					st.setString(4, uraian);
					st.setInt(5, bup);
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
	public JSONArray insertDataEselon_tbl(String tmteselon, String kdeselon, int rp, String uraian, int bup){
		try
		{
			String query = insertDataEselon_tbl;
			return insertQuery(query,tmteselon,kdeselon,rp,uraian,bup);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray updateQuery(String query,  int rp_eselon,String kdeselon  ) throws SQLException{
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setInt(1, rp_eselon);
					st.setString(2, kdeselon);
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
	public JSONArray updateDataEselon_tbl( int rp, String kdeselon){
		try
		{
			String query = updateDataEselon_tbl;
			return updateQuery(query,rp,kdeselon);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray deleteQuery(String query,String kdeselon  ) throws SQLException{
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setString(1, kdeselon);
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
	public JSONArray deleteDataEselon_tbl( String kdeselon){
		try
		{
			String query = deleteDataEselon_tbl;
			return deleteQuery(query,kdeselon);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
