package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdPangkatTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdPangkatTblController extends DatabaseConnection implements MdPangkatTbl{
	public MdPangkatTblController(){
		 
	 }
	
	public JSONArray queryTampilDataPangkat(String query) throws SQLException{
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
	 
	 public JSONArray getQueryTampilDataPangkat(){
			try
			{
				String query = queryReadPangkatTbl;
				return queryTampilDataPangkat(query);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
	}
	 
	 public JSONArray queryMencariPangkat(String query, String inputKode, String inputNama) throws SQLException{
		 PreparedStatement st = null;	
		 try
			{

			 	st = (PreparedStatement) conn.prepareStatement(query);
				st.setString(1, inputKode);
				st.setString(2, inputNama);
				
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
		public JSONArray getQuerySearchPangkat(String inputkode, String inputNama){
			try
			{
				String query = querySearchPangkatTbl;
				return queryMencariPangkat(query, inputkode, inputNama);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray queryInsertPangkat(String query, String inputKode,String inputGol, String inputNmGol, String inputNmPangkat) throws SQLException{
			PreparedStatement st = null;
			try
			{

				st = (PreparedStatement) conn.prepareStatement(query);
				st.setString(1, inputKode);
				st.setString(2, inputGol);
				st.setString(3, inputNmGol);
				st.setString(4, inputNmPangkat);
				
				st.executeUpdate();
				if(st != null){
					st.close();
				}

			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray getQueryInsertPangkat(String inputKode,String inputGol, String inputNmGol, String inputNmPangkat){
			try
			{
				String query = queryInsertPangkatTbl;
				return queryInsertPangkat(query, inputKode, inputGol, inputNmGol, inputNmPangkat);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray queryUpdatePangkat(String query,  String inputNmGol, String inputKode) throws SQLException{
			PreparedStatement st = null;
			try
			{
				st = (PreparedStatement) conn.prepareStatement(query);
				st.setString(1, inputNmGol);
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
		
		public JSONArray getQueryUpdatePangkat(String inputKode, String inputNmGol){
			try
			{
				String query = queryUpdatePangkatTbl;
				return queryUpdatePangkat(query, inputNmGol, inputKode);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray queryDeletePangkat(String query,  String inputKode, String inputNmPangkat) throws SQLException{
			PreparedStatement st = null;
			
			try
			{
				st = (PreparedStatement) conn.prepareStatement(query);
				st.setString(1, inputKode);
				st.setString(2, inputNmPangkat);
				st.executeUpdate();
				if(st != null){
					st.close();
				}

			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray getQueryDeletePangkat(String inputKode, String inputNmPangkat){
			try
			{
				String query = queryDeletePangkatTbl;
				return queryDeletePangkat(query, inputKode, inputNmPangkat);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}


}
