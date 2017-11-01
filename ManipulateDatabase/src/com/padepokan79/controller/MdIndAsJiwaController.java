package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdIndAsJiwa;
import com.padepokan79.util.DatabaseConnection;

public class MdIndAsJiwaController extends DatabaseConnection implements MdIndAsJiwa {

	
///////////////////////////////////////////////////////////Menampilkan Ind_As_Jiwa///////////////////////////////////////////////////////////////////////////////
	public JSONArray querySelectIndAsJiwa(String query) throws SQLException{
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
	
	
	public JSONArray getQuerySelectIndAsJiwa(){
		try
		{
			String query = SelectDataIndAsJiwa;
			return querySelectIndAsJiwa(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
///////////////////////////////////////////////////////////////////////////Cari Ind_As_Jiwa/////////////////////////////////////////////////////////////////////////////////
	
	public JSONArray queryCariIndAsJiwa(String query, String nip) throws SQLException{
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
	
	public JSONArray getQueryCariIndAsJiwa(String nip){
		try
		{
			String query = CariDataIndAsJiwa;
			return queryCariIndAsJiwa(query, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

////////////////////////////////////////////////////////////////////////Insert Ind_As_Jiwa//////////////////////////////////////////////////////////////////////////////////	
	public JSONArray queryInsertIndAsJiwa(String query, String nip, String nama, String kdpangkat, String kdjiwa) throws SQLException{
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			st.setString(2, nama);
			st.setString(3, kdpangkat);
			st.setString(4, kdjiwa);
			
			
			
			st.executeUpdate();
			
			if(st != null){
				st.close();
			}

		}catch (Exception e) {
			// TODO: handle exception
		} 
		
		return null;
	}
	
	
	
	public JSONArray getQueryInsertIndAsJiwa(String nip, String nama, String kdpangkat, String kdjiwa){
		try
		{
			String query = InsertDataIndAsJiwa;
			return queryInsertIndAsJiwa(query, nip, nama, kdpangkat, kdjiwa);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
///////////////////////////////////////////////////////////Update Menampilkan Ind_As_Jiwa//////////////////////////////////////////////////////////////////////////////////	
	
	public JSONArray queryUpdateIndAsJiwa(String query, String nama, String nip) throws SQLException{
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nama);
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
	
	
	
	public JSONArray getQueryUpdateIndAsJiwa(String nama, String nip){
		try
		{
			String query = UpdateDataIndAsJiwa;
			return queryUpdateIndAsJiwa(query, nama, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}	
	
//////////////////////////////////////////////////////////////////////////Menampilkan Ind_As_Jiwa//////////////////////////////////////////////////////////////////////////////
	
	public JSONArray queryDeleteIndAsJiwa(String query, String kdjabatan) throws SQLException{
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
	
	public JSONArray getQueryDeleteIndAsJiwa(String nip){
		try
		{
			String query = DeleteDataIndAsJiwa;
			return queryDeleteIndAsJiwa(query, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


}
