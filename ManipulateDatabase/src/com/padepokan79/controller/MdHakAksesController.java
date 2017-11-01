package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdHakAkses;
import com.padepokan79.util.DatabaseConnection;

public class MdHakAksesController extends DatabaseConnection implements MdHakAkses{
	public MdHakAksesController(){
		
	}
	
	/////////////select
		public JSONArray queryMencariHakAkses(String query)throws SQLException{
			PreparedStatement st = null; 
			try
			{
				st = (PreparedStatement) conn.prepareStatement(query);
				ResultSet rs = (ResultSet) st.executeQuery();
				JSONArray result = Convertor.convertToJSON(rs);
				rs = null;
			
				if (st !=null) {
					st.close();
				}
				return result;
			}catch (Exception e) {
				//yyy	
			}
			return null;
		}
		
		public JSONArray getQueryMencariHakAkses(){
			try
			{
				String query = queryTampilHakAkses;
				return queryMencariHakAkses(query);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		////////////////insert
		public JSONArray queryTambahHakAkses(String query, String p, String k){
			PreparedStatement st = null;
			                              
				try
			    {
			        st=(PreparedStatement) conn.prepareStatement(query);
			        st.setString(1, p);
			        st.setString(2, k);
			
			                                        
			        st.executeUpdate();
			    }catch (Exception e) {
			     // TODO: handle exception
			    }
			     return null;                
		}
			                
		public JSONArray getQueryTambahHakAkses(String p, String k){
			 try
			 {
			    String query = queryInputHakAkses;
			    return queryTambahHakAkses(query, p, k);
			    }catch (Exception e) {
			    // TODO: handle exception
			    }
			     return null;
		}

////////////////edit
		public JSONArray queryEditHakAkses(String query, String nama, String kode){
			PreparedStatement st = null;
            
			try
		    {
		        st=(PreparedStatement) conn.prepareStatement(query);
		        st.setString(1, nama);
		        st.setString(2, kode);
		
		                                        
		        st.executeUpdate();
		    }catch (Exception e) {
		     // TODO: handle exception
		    }
		     return null;                
	}
		                
	public JSONArray getQueryEditHakAkses(String p, String k){
		 try
		 {
		    String query = queryUpdateHakAkses;
		    return queryTambahHakAkses(query, p, k);
		    }catch (Exception e) {
		    // TODO: handle exception
		    }
		     return null;
		}
		
////////////////delete
		public JSONArray queryDeleteHakAkses(String query, String p, String k){
			PreparedStatement st = null;
            
			try
		    {
		        st=(PreparedStatement) conn.prepareStatement(query);
		        st.setString(1, p);
		        st.setString(2, k);
		
		                                        
		        st.executeUpdate();
		    }catch (Exception e) {
		     // TODO: handle exception
		    }
		     return null;                
	}
		                
	public JSONArray getQueryHapusHakAkses(String p, String k){
		 try
		 {
		    String query = queryDeleteHakAkses;
		    return queryTambahHakAkses(query, p, k);
		    }catch (Exception e) {
		    // TODO: handle exception
		    }
		     return null;
		}


}
