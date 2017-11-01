package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdKlaimTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdKlaimTblController extends DatabaseConnection implements MdKlaimTbl {

	
/////////////////////////////////Menampilkan Klaim Tbl/////////////////////////////////////	
	public JSONArray querySelectKlaimTbl(String query) throws SQLException{
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
	
	
	public JSONArray getQuerySelectKlaimTbl(){
		try
		{
			String query = SelectDataKlaimTbl;
			return querySelectKlaimTbl(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
//////////////////////////////////////////Cari Klaim Tbl////////////////////////////////////////
	
	public JSONArray queryCariKlaimTbl(String query, String kdklaim) throws SQLException{
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, kdklaim);
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
	
	
	public JSONArray getQueryCariKlaimTbl(String kdklaim){
		try
		{
			String query = CariDataKlaimTbl;
			return queryCariKlaimTbl(query,kdklaim);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

///////////////////////////////////////////////Insert Klaim Tbl////////////////////////////////////
	
	public JSONArray queryInsertKlaimTbl(String query, String kdklaim, int kdproduk, int kdkelompok, String nmklaim) throws SQLException{
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, kdklaim);
			st.setInt(2, kdproduk);
			st.setInt(3, kdkelompok);
			st.setString(4,nmklaim);
			
			st.executeUpdate();
			
			if(st != null){
				st.close();
			}
			
			

		}catch (Exception e) {
			// TODO: handle exception
		} 
		
		return null;
	}
	
	
	public JSONArray getQueryInsertKlaimTbl(String kdklaim, int kdproduk, int kdkelompok, String nmklaim){
		try
		{
			String query = InsertDataKlaimTbl;
			return queryInsertKlaimTbl(query,kdklaim, kdproduk, kdkelompok, nmklaim);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

///////////////////////////////////////////Update Klaim Tbl//////////////////////////////////////////
	
	public JSONArray queryUpdateKlaimTbl(String query, String nmklaim, String kdklaim) throws SQLException{
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nmklaim);
			st.setString(2,kdklaim);
			
			st.executeUpdate();
			
			if(st != null){
				st.close();
			}
			
			

		}catch (Exception e) {
			// TODO: handle exception
		} 
		
		return null;
	}
	
	
	public JSONArray getQueryUpdateKlaimTbl(String nmklaim, String kdklaim){
		try
		{
			String query = UpdateDataKlaimTbl;
			return queryUpdateKlaimTbl(query,nmklaim, kdklaim);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
//////////////////////////////////////////////Delete Klaim Tbl////////////////////////////////////
	
	public JSONArray queryDeleteKlaimTbl(String query, String kdklaim) throws SQLException{
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1,kdklaim);
			
			st.executeUpdate();
			
			if(st != null){
				st.close();
			}
			
			

		}catch (Exception e) {
			// TODO: handle exception
		} 
		
		return null;
	}
	
	
	public JSONArray getQueryDeleteKlaimTbl(String kdklaim){
		try
		{
			String query = DeleteDataKlaimTbl;
			return queryDeleteKlaimTbl(query, kdklaim);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}
