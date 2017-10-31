package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdJadwalQuery;
import com.padepokan79.util.DatabaseConnection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

	public class MdJadwalController extends DatabaseConnection implements MdJadwalQuery{
		
		public JSONArray InsertQuery(String query,String tgl,String nip,int telah,int harus) throws SQLException{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			try
			{
				
				st.setString(1, tgl);
				st.setString(2, nip);
				st.setInt(3, telah);
				st.setInt(4, harus);
				st.executeUpdate();
			}catch (Exception e) {
				// TODO: handle exception
			}finally{
				if(st!=null){
					st.close();
				}
				
				if(conn!=null){
					st.close();
				}
			}
			return null;
		}
		
		public JSONArray UpdateQuery(String query,String tgl,String nip) throws SQLException{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			try
			{
				st.setString(1, tgl);
				st.setString(2, nip);
				st.executeUpdate();
			}catch (Exception e) {
				// TODO: handle exception
			}finally{
				if(st!=null){
					st.close();
				}
				
				if(conn!=null){
					st.close();
				}
			}
			return null;
		}

		
		public JSONArray DeleteQuery(String query,String nip) throws SQLException{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			try
			{
				
				st.setString(1, nip);
				st.executeUpdate();
			}catch (Exception e) {
				// TODO: handle exception
			}finally{
				if(st!=null){
					st.close();
				}
				
				if(conn!=null){
					st.close();
				}
			}
			
			return null;
		}


		public JSONArray viewQuery(String query) throws SQLException{
			PreparedStatement st =(PreparedStatement) conn.prepareStatement(query);
			try
			{
				
				ResultSet rs = (ResultSet) st.executeQuery();

				return Convertor.convertToJSON(rs);
			}catch (Exception e) {
				// TODO: handle exception
			}finally{
				if(st!=null){
					st.close();
				}
				
				if(conn!=null){
					st.close();
				}
			}
			return null;
		}
		
		public JSONArray getQueryInsert(String tgl,String nip,int telah,int harus){
			try
			{
				String query = insertTable;
				return  InsertQuery(query,tgl,nip,telah,harus);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}

		
		public JSONArray SearchQuery(String query,String nip) throws SQLException{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			try
			{
				st.setString(1, nip);
				ResultSet rs = (ResultSet) st.executeQuery();

				return Convertor.convertToJSON(rs);
			}catch (Exception e) {
				// TODO: handle exception
			}finally{
				if(st!=null){
					st.close();
				}
				
				if(conn!=null){
					st.close();
				}
			}
			
			return null;
		}

		public JSONArray getSearchQuery(String nip){
			try
			{
				String query = selectTable;
				return  SearchQuery(query,nip);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray getUpdateQuery(String tmtgaji,String nip){
			try
			{
				String query = updateTable;
				return  UpdateQuery(query, tmtgaji, nip);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}


		public JSONArray getDeleteQuery(String nip){
			try
			{
				String query = deleteTable;
				return  DeleteQuery(query, nip);
			}catch (Exception e) {
				// TODO: handle exception
			}ft;lkkjhgf
			return null;
		}

		
		
		public JSONArray getViewQuery(){
			try
			{
				String query = viewTable;
				return  viewQuery(query);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}

		
	}

