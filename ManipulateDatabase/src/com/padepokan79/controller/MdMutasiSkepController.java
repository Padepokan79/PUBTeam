package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdMutasiSkep;
import com.padepokan79.util.DatabaseConnection;

public class MdMutasiSkepController extends DatabaseConnection implements MdMutasiSkep{

	public JSONArray queryMenampilkanMutasi(String query) throws SQLException{
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
	
	public JSONArray queryInsertDataMutasi(String query,String nip,String noagenda,String kdpangkat,int gapok ,int masker) throws SQLException{
		PreparedStatement st=null;
		try
		{//nip=?,noagenda=?,kdpangkat=?,gapok=?,masker
			st = (PreparedStatement) conn.prepareStatement(query);
			
			st.setString(1, nip);
			st.setString(2, noagenda);
			st.setString(3,kdpangkat);
			st.setInt(4, gapok);
			st.setInt(5, masker);
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
	
	public JSONArray queryUpdateMutasi(String query,String nip,String noagenda,String kdpangkat,int gapok ,int masker) throws SQLException{
		PreparedStatement st=null;
		try
		{//nmjabatan=? , jml = ? , pensiun= ? where kdkel= ? and kdjab= ?
			st = (PreparedStatement) conn.prepareStatement(query);

			st.setString(1,kdpangkat);
			st.setInt(2, gapok);
			st.setInt(3, masker);
			st.setString(4, nip);
			st.setString(5, noagenda);
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
	
	public JSONArray queryDeleteDataMutasi(String query,String nip,String noagenda) throws SQLException{
		PreparedStatement st=null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			st.setString(2, noagenda);
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
	
	public JSONArray querySearchDataMutasi(String query,String noagenda) throws SQLException{
		PreparedStatement st=null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, noagenda);
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
	
	public JSONArray getQuerySearchMutasi(String noagenda){
		try
		{
			String query = querySearchMutasi;
			return  querySearchDataMutasi(query, noagenda);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryDeleteDataMutasi(String nip,String noagenda){
		try
		{
			String query = queryDeleteMutasi;
			return  queryDeleteDataMutasi(query, nip, noagenda);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryUpdateDataMutasi(String nip,String noagenda,String kdpangkat,int gapok ,int masker){
		try
		{
			String query = queryUpdateMutasi;
			return  queryUpdateMutasi(query, nip, noagenda, kdpangkat, gapok, masker);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryInsertDataMutasi(String nip,String noagenda,String kdpangkat,int gapok ,int masker){
		try
		{
			String query = queryInsertMutasi;
			return  queryInsertDataMutasi(query, nip, noagenda, kdpangkat, gapok, masker);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenampilkanTunjangan(){
		try
		{
			String query = queryReadMutasi;
			return  queryMenampilkanMutasi(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
