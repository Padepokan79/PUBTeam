package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdPendidikanTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdPendidikanTblController extends DatabaseConnection implements MdPendidikanTbl{
	public MdPendidikanTblController(){
		 
	 }
	
	public JSONArray queryTampilDataPendidikan(String query) throws SQLException{
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
	 
	 public JSONArray getQueryTampilDataPendidikan(){
			try
			{
				String query = queryReadPendidikanTbl;
				return queryTampilDataPendidikan(query);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
	}
	 
	 public JSONArray queryMencariPendidikan(String query, int inputKodejns, int inputkd) throws SQLException{
		 PreparedStatement st = null;	
		 try
			{

			 	st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, inputKodejns);
				st.setInt(2, inputkd);
				
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
		public JSONArray getQuerySearchPendidikan(int inputkodejns, int inputkd){
			try
			{
				String query = querySearchPendidikanTbl;
				return queryMencariPendidikan(query, inputkodejns, inputkd);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray queryInsertPendidikan(String query, int inputKodejns,int inputkd, String inputNama) throws SQLException{
			PreparedStatement st = null;
			try
			{

				st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, inputKodejns);
				st.setInt(2, inputkd);
				st.setString(3, inputNama);
				
				st.executeUpdate();
				if(st != null){
					st.close();
				}

			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray getQueryInsertPendidikan(int inputKodejns, int inputkd, String inputNama){
			try
			{
				String query = queryInsertPendidikanTbl;
				return queryInsertPendidikan(query, inputKodejns, inputkd, inputNama);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray queryUpdatePendidikan(String query,  String inputNama, int inputKodejns, int inputkd) throws SQLException{
			PreparedStatement st = null;
			try
			{
				st = (PreparedStatement) conn.prepareStatement(query);
				st.setString(1, inputNama);
				st.setInt(2, inputKodejns);
				st.setInt(3, inputkd);
				
				st.executeUpdate();
				if(st != null){
					st.close();
				}

			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray getQueryUpdatePendidikan(int inputKodejns, int inputkd, String inputNama){
			try
			{
				String query = queryUpdatePendidikanTbl;
				return queryUpdatePendidikan(query, inputNama, inputKodejns, inputkd);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray queryDeletePendidikan(String query,  int inputKodejns, String inputNama) throws SQLException{
			PreparedStatement st = null;
			
			try
			{
				st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, inputKodejns);
				st.setString(2, inputNama);
				st.executeUpdate();
				if(st != null){
					st.close();
				}

			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray getQueryDeletePendidikan(int inputKodejns, String inputNama){
			try
			{
				String query = queryDeletePendidikanTbl;
				return queryDeletePendidikan(query, inputKodejns, inputNama);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}


}
