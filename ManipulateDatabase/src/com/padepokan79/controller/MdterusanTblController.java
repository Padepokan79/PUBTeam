package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdTerusanTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdterusanTblController extends DatabaseConnection implements MdTerusanTbl{
 
	public JSONArray queryMenampilkanTerusan(String query) throws SQLException{
		PreparedStatement st =null;
		try
		{
			st=(PreparedStatement) conn.prepareStatement(query);
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result=Convertor.convertToJSON(rs);
			rs=null;
			if(st!=null){
				st.close();
			}
			
			if(conn!=null){
				st.close();
			}
			return result;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryInsertDataTerusan(String query,int KDJNSTRANS,String nip) throws SQLException{
		PreparedStatement st=null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			
			st.setString(1, nip);
			st.setInt(2, KDJNSTRANS);
			st.executeUpdate();
			if(st!=null){
				st.close();
			}
			
			if(conn!=null){
				st.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryUpdateTerusan(String query,int KDJNSTRANS,String nip) throws SQLException{
		PreparedStatement st=null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);

			st.setInt(1, KDJNSTRANS);
			st.setString(2, nip);
			st.executeUpdate();
			if(st!=null){
				st.close();
			}
			
			if(conn!=null){
				st.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryDeleteDataTerusan(String query,String nip) throws SQLException{
		PreparedStatement st=null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			st.executeUpdate();
			if(st!=null){
				st.close();
			}
			
			if(conn!=null){
				st.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}finally{
			
		}
		
		return null;
	}
	
	public JSONArray querySearchDataTerusan(String query,String nip) throws SQLException{
		PreparedStatement st=null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result=Convertor.convertToJSON(rs);
			rs=null;
			if(st!=null){
				st.close();
			}
			
			if(conn!=null){
				st.close();
			}
			return result;
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	//////////////////////////////////////////////////////////////getQuery///////////////////////////////////////////
	
	public JSONArray getQuerySearchTerusan(String nip){
		try
		{
			String query = querySearchTerusanTbl;
			return  querySearchDataTerusan(query, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryDeleteDataTerusan(String nip){
		try
		{
			String query = queryDeleteTerusanTbl;
			return  queryDeleteDataTerusan(query, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryUpdateDataTerusan(int KDJNSTRANS,String nip){
		try
		{
			String query = queryUpdateTerusanTbl;
			return  queryUpdateTerusan(query, KDJNSTRANS, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryInsertDataTerusan(int KDJNSTRANS,String nip){
		try
		{
			String query = queryInsertTerusanTbl;
			return  queryInsertDataTerusan(query, KDJNSTRANS, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenampilkanDataTerusan(){
		try
		{
			String query = queryReadTerusanTbl;
			return  queryMenampilkanTerusan(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
