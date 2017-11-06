package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdHistorisStapeg;
import com.padepokan79.util.DatabaseConnection;

public class MdHistorisStapegController extends DatabaseConnection implements MdHistorisStapeg {
	
//////////////////////////////////////////Menampilkan Historis Stapeg///////////////////////////////////	
	public JSONArray querySelectHistorisStapeg(String query) throws SQLException{
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
	
	
	public JSONArray getQuerySelectHistorisStapeg(){
		try
		{
			String query = SelectDataHistorisStapeg;
			return querySelectHistorisStapeg(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
////////////////////////////////Cari Historis Stapeg//////////////////////////////////////////////
	
	public JSONArray queryCariHistorisStapeg(String query, String nip) throws SQLException{
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
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
	
	public JSONArray getQueryCariHistorisStapeg(String nip){
		try
		{
			String query = CariDataHistorisStapeg;
			return queryCariHistorisStapeg(query, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

//////////////////////////////////////////Insert Historis Stapeg///////////////////////////////////////////	
	public JSONArray queryInsertHistorisStapeg(String query, String tmtgaji, String nip, int kdstapeg, String keterangan) throws SQLException{
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, tmtgaji);
			st.setString(2, nip);
			st.setInt(3, kdstapeg);
			st.setString(4, keterangan);
			
			
			st.executeUpdate();
			
			if(st != null){
				st.close();
			}

		}catch (Exception e) {
			// TODO: handle exception
		} 
		
		return null;
	}
	
	
	
	public JSONArray getQueryInsertHistorisStapeg(String tmtgaji, String nip, int kdstapeg, String keterangan){
		try
		{
			String query = InsertDataHistorisStapeg;
			return queryInsertHistorisStapeg(query, tmtgaji, nip, kdstapeg,keterangan);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
//////////////////////////////////////Update Historis Stapeg/////////////////////////////////////	
	
	public JSONArray queryUpdateHistorisStapeg(String query, int kdstapeg, String nip) throws SQLException{
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, kdstapeg);
			st.setString(2, nip);
			
			st.executeUpdate();
			if(st != null){
				st.close();
			}
			

		}catch (Exception e) {
			// TODO: handle exception
		} 
		
		return null;
	}
	
	
	
	public JSONArray getQueryUpdateHistorisStapeg(int kdstapeg, String nip){
		try
		{
			String query = UpdateDataHistorisStapeg;
			return queryUpdateHistorisStapeg(query, kdstapeg, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}	
	
//////////////////////////////////////Delete Historis Stapeg/////////////////////////////////////
	
	public JSONArray queryDeleteHistorisStapeg(String query, String nip) throws SQLException{
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			st.executeUpdate();
			
			if(st != null){
				st.close();
			}
			

		}catch (Exception e) {
			// TODO: handle exception
		} 
		
		return null;
	}
	
	public JSONArray getQueryDeleteHistorisStapeg(String nip){
		try
		{
			String query = DeleteDataHistorisStapeg;
			return queryDeleteHistorisStapeg(query, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


}
