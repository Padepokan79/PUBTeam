package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdJenisDidik;
import com.padepokan79.util.DatabaseConnection;

public class MdJenisDidikController extends DatabaseConnection implements MdJenisDidik{

	public JSONArray queryMenampilkanDataJnsDidik(String query) throws SQLException{
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
	
	public JSONArray queryInsertDataJenisDidik(String query,int jnsdidik,String nmjenisdidik) throws SQLException{
		PreparedStatement st=null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			
			st.setInt(1, jnsdidik);
			st.setString(2, nmjenisdidik);
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
	
	public JSONArray queryUpdateDataJenisDidik(String query,int jnsdidik,String nmjenisdidik) throws SQLException{
		PreparedStatement st=null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);

			st.setString(1, nmjenisdidik);
			st.setInt(2, jnsdidik);
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
	
	public JSONArray queryDeleteDataJenisDidik(String query,int jnsdidik) throws SQLException{
		PreparedStatement st=null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, jnsdidik);
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
	
	public JSONArray querySearchDataJenisDidik(String query,int jnsdidik) throws SQLException{
		PreparedStatement st=null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, jnsdidik);
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
	
	public JSONArray getQuerySearchDataJenisDidik(int jnsdidik){
		try
		{
			String query = querySearchDataJnsDidik;
			return  querySearchDataJenisDidik(query, jnsdidik);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryDeleteDataJenisDidik(int jnsdidik){
		try
		{
			String query = queryDeleteDataJnsDidik;
			return  queryDeleteDataJenisDidik(query, jnsdidik);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryUpdateDataJenisDidik(int jnsdidik,String nmjenisdidik){
		try
		{
			String query = queryUpdateDataJnsDidik;
			return  queryUpdateDataJenisDidik(query, jnsdidik, nmjenisdidik);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryInsertDataJenisDidik(int jnsdidik,String nmjenisdidik){
		try
		{
			String query = queryInsertDataJnsDidik;
			return  queryInsertDataJenisDidik(query, jnsdidik, nmjenisdidik);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenampilkanDataJenisDidik(){
		try
		{
			String query = queryReadDataJnsDidik;
			return  queryMenampilkanDataJnsDidik(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}
