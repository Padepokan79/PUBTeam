package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdHitPajak;
import com.padepokan79.util.DatabaseConnection;

public class MdHitPajakController extends DatabaseConnection implements MdHitPajak{
	public MdHitPajakController(){
		 
	 }
	
	public JSONArray queryTampilDataHitPajak(String query) throws SQLException{
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
	 
	 public JSONArray getQueryTampilDataHitPajak(){
			try
			{
				String query = queryReadHitPajak;
				return queryTampilDataHitPajak(query);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
	}
	 
	 public JSONArray queryMencariHitPajak(String query, String nip, int istri, int anak) throws SQLException{
		 PreparedStatement st = null;	
		 try
			{

			 	st = (PreparedStatement) conn.prepareStatement(query);
				st.setString(1, nip);
				st.setInt(2, istri);
				st.setInt(3, anak);
				
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
		public JSONArray getQuerySearchHitPajak(String nip, int istri, int anak){
			try
			{
				String query = querySearchHitPajak;
				return queryMencariHitPajak(query, nip, istri, anak);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray queryInsertHitPajak(String query, String nip, int thp, int kotorInduk, int subKotor, int istri, int anak) throws SQLException{
			PreparedStatement st = null;
			try
			{

				st = (PreparedStatement) conn.prepareStatement(query);
				st.setString(1, nip);
				st.setInt(2, thp);
				st.setInt(3, kotorInduk);
				st.setInt(4, subKotor);
				st.setInt(5, istri);
				st.setInt(6, anak);
				
				st.executeUpdate();
				if(st != null){
					st.close();
				}

			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray getQueryInsertHitPajak(String nip, int thp, int kotorinduk, int subkotor, int istri, int anak){
			try
			{
				String query = queryInsertHitPajak;
				return queryInsertHitPajak(query, nip, thp, kotorinduk, subkotor, istri, anak);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray queryUpdateHitPajak(String query,  String nip, int thp, int kotorinduk, int subkotor) throws SQLException{
			PreparedStatement st = null;
			try
			{
				st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, subkotor);
				st.setInt(2, kotorinduk);
				st.setString(3, nip);
				st.setInt(4, thp);
				
				st.executeUpdate();
				if(st != null){
					st.close();
				}

			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray getQueryUpdateHitPajak(String nip, int thp, int kotorinduk, int subkotor){
			try
			{
				String query = queryUpdateHitPajak;
				return queryUpdateHitPajak(query, nip, thp, kotorinduk, subkotor);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray queryDeleteHitPajak(String query,  String nip, int thp) throws SQLException{
			PreparedStatement st = null;
			
			try
			{
				st = (PreparedStatement) conn.prepareStatement(query);
				st.setString(1, nip);
				st.setInt(2, thp);
				st.executeUpdate();
				if(st != null){
					st.close();
				}

			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public JSONArray getQueryDeleteHitPajak(String nip, int thp){
			try
			{
				String query = queryDeleteHitPajak;
				return queryDeleteHitPajak(query, nip, thp);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
}
