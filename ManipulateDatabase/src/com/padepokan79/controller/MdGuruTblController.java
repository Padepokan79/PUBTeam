package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdGuruTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdGuruTblController extends DatabaseConnection implements MdGuruTbl{
	public MdGuruTblController(){
		
	}
	
	public JSONArray queryTampilDataGuru(String query) throws SQLException{
		 PreparedStatement st = null;	
		 try
			{

			 st = (PreparedStatement) conn.prepareStatement(query);
				//st.setInt(1);
				
				ResultSet rs = (ResultSet) st.executeQuery();
				JSONArray result = Convertor.convertToJSON(rs);
				rs=null;
				if(st != null){
					st.close();
				}
				return result;

			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
	}
	 
	 public JSONArray getQueryTampilDataGuru(){
			try
			{
				String query = queryReadGuruTbl;
				return queryTampilDataGuru(query);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
	}
	 
	 public JSONArray queryMencariGuru(String query, String inputKode) throws SQLException{
		 PreparedStatement st = null;	
		 try
			{

			 	st = (PreparedStatement) conn.prepareStatement(query);
				st.setString(1, inputKode);
				
				ResultSet rs = (ResultSet) st.executeQuery();
				JSONArray result = Convertor.convertToJSON(rs);
				rs=null;
				if(st != null){
					st.close();
				}
				return result;

			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		public JSONArray getQuerySearchGuru(String inputKode){
			try
			{
				String query = querySearchGuruTbl;
				return queryMencariGuru(query, inputKode);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray queryInsertGuru(String query, String tmt, String kdGuru, String NmGuru, int tjGuru) throws SQLException{
			PreparedStatement st = null;
			try
			{

				st = (PreparedStatement) conn.prepareStatement(query);
				st.setString(1, tmt);
				st.setString(2, kdGuru);
				st.setString(3, NmGuru);
				st.setInt(4, tjGuru);
				
				st.executeUpdate();
				if(st != null){
					st.close();
				}

			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray getQueryInsertGuru(String tmt, String kdGuru, String nmGuru, int tjGuru){
			try
			{
				String query = queryInsertGuruTbl;
				return queryInsertGuru(query, tmt, kdGuru, nmGuru, tjGuru);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray queryUpdateGuru(String query,  String inputKode, int tjGuru) throws SQLException{
			PreparedStatement st = null;
			try
			{
				st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, tjGuru);
				st.setString(2, inputKode);
				
				
				st.executeUpdate();
				if(st != null){
					st.close();
				}

			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray getQueryUpdateGuru(String inputKode, int tjGuru){
			try
			{
				String query = queryUpdateGuruTbl;
				return queryUpdateGuru(query, inputKode, tjGuru);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray queryDeleteGuru(String query,  String inputKode) throws SQLException{
			PreparedStatement st = null;
			
			try
			{
				st = (PreparedStatement) conn.prepareStatement(query);
				st.setString(1, inputKode);
				st.executeUpdate();
				if(st != null){
					st.close();
				}

			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray getQueryDeleteGuru(String inputKode){
			try
			{
				String query = queryDeleteGuruTbl;
				return queryDeleteGuru(query, inputKode);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}

}
