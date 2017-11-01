package com.padepokan79.controller;

import java.sql.Date;
import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdBupIndTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdBupIndTblController extends DatabaseConnection implements MdBupIndTbl {
	
	public JSONArray ReadAllQuery(String query) throws SQLException{
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
	
	public JSONArray ReadQuery(String query, String inputKode){
		PreparedStatement st = null;
		
		try
		{
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, inputKode);
			// execute the query, and get a java resultset
			//for insert, update, delete
			//st.executeUpdate();
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result=Convertor.convertToJSON(rs);
			rs=null;
		
			if(st!=null) {
				st.close();
			}
			
		return result;
		}catch(Exception e){
			
		}
		return null;
	
	}
	
	public JSONArray InsertQuery(String query, String nip,  int bup, String tgl, String no){
PreparedStatement st = null;
		
		try
		{
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			st.setInt(2, bup);
			st.setString(3, tgl);
			st.setString(4, no);
			// execute the query, and get a java resultset
			//for insert, update, delete
			st.executeUpdate();
//			ResultSet rs = (ResultSet) st.executeQuery();
//			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray DeleteQuery(String query, String nip) {
PreparedStatement st = null;
		
		try
		{
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			
			// execute the query, and get a java resultset
			//for insert, update, delete
			st.executeUpdate();
//			ResultSet rs = (ResultSet) st.executeQuery();
//			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	
	}
	
	public JSONArray UpdateQuery(String query, String nip, int bup) {
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setInt(1, bup);
					st.setString(2, nip);
					
					
					// execute the query, and get a java resultset
					//for insert, update, delete
					st.executeUpdate();
//					ResultSet rs = (ResultSet) st.executeQuery();
//					return Convertor.convertToJSON(rs);
				}catch (Exception e) {
					// TODO: handle exception
				}
				return null;
			
			}

	public JSONArray LihatData() {
		try {
			return ReadAllQuery(ReadAllBupIndTbl);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray LihatData(String nip) {
		try {
			String query = LihatBupBupIndTbl;
			return ReadQuery(query, nip);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray InsertBup(String nip, int bup, String tgl, String no) {
		try {
			String query = TambahDataBupIndTbl;
			return InsertQuery(query, nip, bup, tgl, no);
		}catch(Exception e) {
			
		}
		return null;
		
	}

	public JSONArray DeleteBup(String nip) {
		try {
			String query = DeleteDataBaruBupIndTbl;
			return DeleteQuery(query, nip);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray UpdateBup(String nip, int bup) {
		try {
			String query = UpdateDataBaruBupIndTbl;
			return UpdateQuery(query, nip, bup);
		}catch(Exception e) {
			
		}
		return null;
		
	}

}
