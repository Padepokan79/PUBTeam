package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdZjabatanTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdZjabatanTblController extends DatabaseConnection implements  MdZjabatanTbl{

///////////////////////////////////////////////////////Menampilkan Zjabatan Tbl//////////////////////////////////////////////////////////////////////////////////////////	
	
	public JSONArray querySelectZjabatanTbl(String query) throws SQLException{
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result = Convertor.convertToJSON(rs);
			
			rs= null;
			if(st != null){
				st.close();
			}
			
			return result;

		}catch (Exception e) {
			// TODO: handle exception
		} 
		
		return null;
	}
	
	
	public JSONArray getQuerySelectZjabatanTbl(){
		try
		{
			String query = SelectDataZjabatanTbl;
			return querySelectZjabatanTbl(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
///////////////////////////////////////////////////////////////////////////Cari Zjabatan Tbl/////////////////////////////////////////////////////////////////////////////////
	
	public JSONArray queryCariZjabatanTbl(String query, String kdjabatan) throws SQLException{
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, kdjabatan);
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result = Convertor.convertToJSON(rs);
			
			rs= null;
			if(st != null){
				st.close();
			}
			
			return result;

		}catch (Exception e) {
			// TODO: handle exception
		} 
		
		return null;
	}
	
	public JSONArray getQueryCariZjabatanTbl(String kdjabatan){
		try
		{
			String query = CariDataZjabatanTbl;
			return queryCariZjabatanTbl(query, kdjabatan);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

////////////////////////////////////////////////////////////////////////Insert Zjabatan Tbl//////////////////////////////////////////////////////////////////////////////////	
	public JSONArray queryInsertZjabatanTbl(String query, int jml_r, String tmtjabatan, String kdjabatan, String nmjabatan,int jml, int pensiun, int kdfungsi) throws SQLException{
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, jml_r);
			st.setString(2, tmtjabatan);
			st.setString(3, kdjabatan);
			st.setString(4, nmjabatan);
			st.setInt(5, jml);
			st.setInt(6, pensiun);
			st.setInt(7, kdfungsi);
			
			
			
			st.executeUpdate();
			
			if(st != null){
				st.close();
			}

		}catch (Exception e) {
			// TODO: handle exception
		} 
		
		return null;
	}
	
	
	
	public JSONArray getQueryInsertZjabatanTbl(int jml_r, String tmtjabatan, String kdjabatan, String nmjabatan,int jml, int pensiun, int kdfungsi){
		try
		{
			String query = InsertDataZjabatanTbl;
			return queryInsertZjabatanTbl(query, jml_r, tmtjabatan, kdjabatan, nmjabatan, jml, pensiun, kdfungsi);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
///////////////////////////////////////////////////////////Update Zjabatan Tbl//////////////////////////////////////////////////////////////////////////////////	
	
	public JSONArray queryUpdateZjabatanTbl(String query, String nmjabatan, String kdjabatan) throws SQLException{
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nmjabatan);
			st.setString(2, kdjabatan);
			
			st.executeUpdate();
			if(st != null){
				st.close();
			}
			

		}catch (Exception e) {
			// TODO: handle exception
		} 
		
		return null;
	}
	
	
	
	public JSONArray getQueryUpdateZjabatanTbl(String nmjabatan, String kdjabatan){
		try
		{
			String query = UpdateDataZjabatanTbl;
			return queryUpdateZjabatanTbl(query, nmjabatan, kdjabatan);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}	
	
//////////////////////////////////////////////////////////////////////////Delete Zjabatan Tbl//////////////////////////////////////////////////////////////////////////////
	
	public JSONArray queryDeleteZjabatanTbl(String query, String kdjabatan) throws SQLException{
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, kdjabatan);
			st.executeUpdate();
			
			if(st != null){
				st.close();
			}
			

		}catch (Exception e) {
			// TODO: handle exception
		} 
		
		return null;
	}
	
	public JSONArray getQueryDeleteZjabatanTbl(String kdjabatan){
		try
		{
			String query = DeleteDataZjabatanTbl;
			return queryDeleteZjabatanTbl(query, kdjabatan);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


}
