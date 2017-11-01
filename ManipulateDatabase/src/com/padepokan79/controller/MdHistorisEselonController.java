package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdHistorisEselon;
import com.padepokan79.util.DatabaseConnection;

public class MdHistorisEselonController extends DatabaseConnection implements MdHistorisEselon{

	public JSONArray queryMenampilkanDataHistoriEselon(String query) throws SQLException{
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
	
	public JSONArray queryInsertDataHistorisEselon(String query,String tmtgaji,String nip,String kdeselon,int tjeselon,String keterangan) throws SQLException{
		PreparedStatement st =null;
		try
		{
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, tmtgaji);
			st.setString(2, nip);
			st.setString(3, kdeselon);
			st.setInt(4, tjeselon);
			st.setString(5, keterangan);
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
	
	public JSONArray queryUpdateDataHistorisEselon(String query,String tmtgaji,String nip,String kdeselon,int tjeselon,String keterangan) throws SQLException{
		PreparedStatement st =null;
		try
		{//tmtgaji=?,kdeselon=?,tjeselon=?,keterangan=?, where nip=?
			st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1, tmtgaji);
			st.setString(2, kdeselon);
			st.setInt(3, tjeselon);
			st.setString(4, keterangan);
			st.setString(5, nip);
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
	
	public JSONArray queryDeleteDataHistorisEselon(String query,String nip) throws SQLException{
		PreparedStatement st =null;
		try
		{
			st=(PreparedStatement) conn.prepareStatement(query);
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
		}
		
		return null;
	}
	
	public JSONArray querySearchDataHistorisEselon(String query,String nip) throws SQLException{
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
	
	//////////////////////////////////////////////////////////////getQuery///////////////////////////////////////////
	
	public JSONArray getQuerySearchDataHistorisEselon(String nip){
		try
		{
			String query = querySearchTjHistorisEselon;
			return  querySearchDataHistorisEselon(query,nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryDeleteDataHistorisEselon(String nip){
		try
		{
			String query = queryDeleteTjHistorisEselon;
			return  queryDeleteDataHistorisEselon(query, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryUpdateDataHistorisEselon(String tmtgaji,String nip,String kdeselon,int tjeselon,String keterangan){
		try
		{
			String query = queryUpdateDataHistorisEselon;
			return  queryUpdateDataHistorisEselon(query, tmtgaji, nip, kdeselon, tjeselon, keterangan);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryInsertDataHistorisEselon(String tmtgaji,String nip,String kdeselon,int tjeselon,String keterangan){
		try
		{
			String query = queryInsertDataHistorisEselon;
			return  queryInsertDataHistorisEselon(query,tmtgaji,nip,kdeselon,tjeselon, keterangan);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenampilkanDataHistoriEselon(){
		try
		{
			String query = queryReadTjHistoriEselon;
			return  queryMenampilkanDataHistoriEselon(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
