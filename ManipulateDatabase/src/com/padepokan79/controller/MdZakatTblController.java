package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdZakatTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdZakatTblController extends DatabaseConnection implements MdZakatTbl{
	
///////////////////////////////////Menampilkan Zakat Tbl//////////////////////////////////////	
	public JSONArray querySelectZakatTbl(String query) throws SQLException{
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
	
	
	public JSONArray getQuerySelectZakatTbl(){
		try
		{
			String query = SelectDataZakatTbl;
			return querySelectZakatTbl(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
////////////////////////////////Cari Zakat Tbl//////////////////////////////////////////////
	
	public JSONArray queryCariZakatTbl(String query, String nip) throws SQLException{
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
	
	public JSONArray getQueryCariZakatTbl(String nip){
		try
		{
			String query = CariDataZakatTbl;
			return queryCariZakatTbl(query, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

//////////////////////////////////////////Insert Zakat Tbl///////////////////////////////////////////	
	public JSONArray queryInsertZakatTbl(String query, String nip, String blthgaji, int kdjnstrans, int kode, int nilai) throws SQLException{
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			st.setString(2, blthgaji);
			st.setInt(3, kdjnstrans);
			st.setInt(4, kode);
			st.setInt(5, nilai);
			
			
			
			st.executeUpdate();
			
			if(st != null){
				st.close();
			}

		}catch (Exception e) {
			// TODO: handle exception
		} 
		
		return null;
	}
	
	
	
	public JSONArray getQueryInsertZakatTbl(String nip, String blthgaji, int kdjnstrans, int kode, int nilai){
		try
		{
			String query = InsertDataZakatTbl;
			return queryInsertZakatTbl(query, nip, blthgaji, kdjnstrans, kode, nilai);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
/////////////////////////////////////////////////////////////////////Update Zakat Tbl///////////////////////////////////////////////////////////////////////////	
	
	public JSONArray queryUpdateZakatTbl(String query, int nilai, String nip) throws SQLException{
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, nilai);
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
	
	
	
	public JSONArray getQueryUpdateZakatTbl(int nilai, String nip){
		try
		{
			String query = UpdateDataZakatTbl;
			return queryUpdateZakatTbl(query, nilai, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}	
	
/////////////////////////////////////////////////////////////////Delete Zakat Tbl///////////////////////////////////////////////////////////////////////////////////////
	
	public JSONArray queryDeleteZakatTbl(String query, String nip) throws SQLException{
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
	
	public JSONArray getQueryDeleteZakatTbl(String nip){
		try
		{
			String query = DeleteDataZakatTbl;
			return queryDeleteZakatTbl(query, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


}

