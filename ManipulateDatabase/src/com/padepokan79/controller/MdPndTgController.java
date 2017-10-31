package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdPndTg;
import com.padepokan79.util.DatabaseConnection;

public class MdPndTgController extends DatabaseConnection implements MdPndTg{
	public MdPndTgController() {
		// TODO Auto-generated constructor stub
	}
	
/////////////select
public JSONArray queryMencariPndTg(String query, String nama)throws SQLException{
	PreparedStatement st = null; 
	try
	{
		st = (PreparedStatement) conn.prepareStatement(query);
		st.setString(1, nama);
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

public JSONArray getQueryMencariPndTg(String nama){
	try
	{
		String query = queryTampilPndTg;
		return queryMencariPndTg(query, nama);
	}catch (Exception e) {
		// TODO: handle exception
	}
	return null;
}

////////////////insert
public JSONArray queryTambahPndTg(String query, String nip, String nama, String jab, String npwp, String kota, String nms){
	PreparedStatement st = null;
	                              
		try
	    {
	        st=(PreparedStatement) conn.prepareStatement(query);
	        st.setString(1, nip);
	        st.setString(2, nama);
	        st.setString(3, jab);
	        st.setString(4, npwp);
	        st.setString(5, kota);
	        st.setString(6, nms);
	                                        
	        st.executeUpdate();
	    }catch (Exception e) {
	     // TODO: handle exception
	    }
	     return null;                
}
	                
public JSONArray getQueryTambahPndTg(String nip, String nama, String jab, String npwp, String kota, String nms){
	 try
	 {
	    String query = queryInputPndTg;
	    return queryTambahPndTg(query, nip, nama, jab, npwp, kota, nms);
	    }catch (Exception e) {
	    // TODO: handle exception
	    }
	     return null;
}

////////////////edit
public JSONArray queryEditPndTg(String query, String kota, String nip){
	PreparedStatement st = null;
    
	try
    {
        st=(PreparedStatement) conn.prepareStatement(query);
        st.setString(1, kota);
        st.setString(2, nip);

                                        
        st.executeUpdate();
    }catch (Exception e) {
     // TODO: handle exception
    }
     return null;                
}
                
public JSONArray getQueryEditPndTg(String kota, String nip){
 try
 {
    String query = queryUpdatePndTg;
    return queryEditPndTg(query, kota, nip);
    }catch (Exception e) {
    // TODO: handle exception
    }
     return null;
}

////////////////delete
public JSONArray queryDeletepndTg(String query, String nip){
	PreparedStatement st = null;
    
	try
    {
        st=(PreparedStatement) conn.prepareStatement(query);
        st.setString(1, nip);
                                        
        st.executeUpdate();
    }catch (Exception e) {
     // TODO: handle exception
    }
     return null;                
}
                
public JSONArray getQueryHapusPndTg(String nip){
 try
 {
    String query = queryDeletePndTg;
    return queryDeletepndTg(query, nip);
    }catch (Exception e) {
    // TODO: handle exception
    }
     return null;
}

}
