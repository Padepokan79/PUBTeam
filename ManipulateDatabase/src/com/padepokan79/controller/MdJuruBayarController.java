package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdJuruBayar;
import com.padepokan79.util.DatabaseConnection;

public class MdJuruBayarController extends DatabaseConnection implements MdJuruBayar{
	 public MdJuruBayarController(){
		 
	 }
	 
	 public JSONArray queryTampilDataJuruBayar(String query) throws SQLException{
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
	 
	 public JSONArray getQueryTampilDataJuruBayar(){
			try
			{
				String query = queryReadJuruBayar;
				return queryTampilDataJuruBayar(query);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
	}
	 
	 public JSONArray queryMencariNamaBayar(String query, String inputKode) throws SQLException{
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
		public JSONArray getQueryMencariNamaBayar(String inputKode){
			try
			{
				String query = querySearchJuruBayar;
				return queryMencariNamaBayar(query, inputKode);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray queryInsertJuruBayar(String query, String inputKode, String namaJuruBayar) throws SQLException{
			PreparedStatement st = null;
			try
			{

				st = (PreparedStatement) conn.prepareStatement(query);
				st.setString(1, inputKode);
				st.setString(2, namaJuruBayar);
				
				st.executeUpdate();
				if(st != null){
					st.close();
				}
//				ResultSet rs = (ResultSet) st.executeQuery();
//				return Convertor.convertToJSON(rs);

			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray getQueryInsertJuruBaya(String inputKode, String inputNama){
			try
			{
				String query = queryInsertJuruBayar;
				return queryInsertJuruBayar(query, inputKode, inputNama);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray queryUpdateJuruBayar(String query,  String namaJuruBayar, String inputKode) throws SQLException{
			PreparedStatement st = null;
			try
			{
				st = (PreparedStatement) conn.prepareStatement(query);
				st.setString(1, namaJuruBayar);
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
		
		public JSONArray getQueryUpdateJuruBaya(String inputKode, String inputNama){
			try
			{
				String query = queryUpdateJuruBayar;
				return queryUpdateJuruBayar(query, inputNama, inputKode);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray queryDeleteJuruBayar(String query,  String inputKode) throws SQLException{
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
		
		public JSONArray getQueryDeleteJuruBayar(String inputKode){
			try
			{
				String query = queryDeleteJuruBayar;
				return queryDeleteJuruBayar(query, inputKode);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
}
