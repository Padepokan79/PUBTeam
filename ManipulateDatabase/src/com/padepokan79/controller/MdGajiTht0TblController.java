package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdGajiTht0Tbl;
import com.padepokan79.model.MdHubkelTbl;
import com.padepokan79.model.MdJiwaPtkp;
import com.padepokan79.util.DatabaseConnection;

public class MdGajiTht0TblController extends DatabaseConnection implements MdGajiTht0Tbl {

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
			//rs=null;
		
			if(st!=null) {
				st.close();
			}
			
		return result;
		}catch(Exception e){
			
		}
		return null;
	
	}
	
	public JSONArray InsertQuery(String query, String nip, String tglgaji, int kdtrans, int gapok, String kdjiwa, int iuran, String kdskpd, String kdsatker, String tgl_update, String inputer, String tglsetor){
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setString(1, nip);
					st.setString(2, tglgaji);
					st.setInt(3, kdtrans);
					st.setInt(4, gapok);
					st.setString(5, kdjiwa);
					st.setInt(6, iuran);
					st.setString (7,kdskpd); 
					st.setString(8,kdsatker); 
					st.setString (9,tgl_update); 
					st.setString (10,inputer); 
					st.setString (11,tglsetor);
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
	
	public JSONArray UpdateQuery(String query, String nip, int gapok) {
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					
					st.setInt(1, gapok);
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
	
	public JSONArray DeleteQuery(String query, String nip) {
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setString(1, nip);
					
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
			return ReadAllQuery(ReadGajiTht0Tbl);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray LihatData(String nip) {
		try {
			String query = LihatGapokDataBaruGajiTht0Tbl;
			return ReadQuery(query, nip);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray InsertData(String nip, String tglgaji, int kdtrans, int gapok, String kdjiwa, int iuran, String kdskpd, String kdsatker, String tgl_update, String inputer, String tglsetor){
		try {
			String query = TambahDataGajiTht0Tbl;
			return InsertQuery(query, nip,tglgaji, kdtrans, gapok, kdjiwa, iuran, kdskpd, kdsatker, tgl_update, inputer, tglsetor);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray UpdateData(String nip, int gapok) {
		try {
			String query = UpdateGappokDataBaruGajiTht0Tbl;
			return UpdateQuery(query, nip, gapok);
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	public JSONArray DeleteData(String nip) {
		try {
			String query =DeleteDataBaru;
			return DeleteQuery(query, nip);
		}catch(Exception e) {
			
		}
		return null;
		
	}
}
