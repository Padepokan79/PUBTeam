package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdIrdhata;
import com.padepokan79.util.DatabaseConnection;

public class MdIrdhataController extends DatabaseConnection implements MdIrdhata{
	
	public JSONArray queryMenampilkanIrdhata(String query) throws SQLException{
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
	
	public JSONArray queryInsertDataIrdhata(String query,String tmt,String kdirdhata,int nilai ,String keter) throws SQLException{
		PreparedStatement st=null;
		try
		{//tmt= ? , kdirdhata= ? , nilai=? , keter = ?
			st = (PreparedStatement) conn.prepareStatement(query);
			
			st.setString(1, tmt);
			st.setString(2, kdirdhata);
			st.setInt(3,nilai);
			st.setString(4, keter);
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
	
	public JSONArray queryUpdateIrdhata(String query,String tmt,String kdirdhata,int nilai ,String keter) throws SQLException{
		PreparedStatement st=null;
		try
		{//nilai=? , keter = ? where tmt= ? and kdirdhata= ?
			st = (PreparedStatement) conn.prepareStatement(query);

			st.setInt(1, nilai);
			st.setString(2, keter);
			st.setString(3, tmt);
			st.setString(4, kdirdhata);
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
	
	public JSONArray queryDeleteDataIrdhata(String query,String kdirdhata) throws SQLException{
		PreparedStatement st=null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, kdirdhata);
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
	
	public JSONArray querySearchDataIrdhata(String query,String kdirdhata) throws SQLException{
		PreparedStatement st=null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, kdirdhata);
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
	
	public JSONArray getQuerySearchIrdhata(String kdirdhata){
		try
		{
			String query = querySearchIrdhataTbl;
			return  querySearchDataIrdhata(query, kdirdhata);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryDeleteDataIrdhata(String kdirdhata){
		try
		{
			String query = queryDeleteIrdhataTbl;
			return  queryDeleteDataIrdhata(query, kdirdhata);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryUpdateDataIrdhata(String tmt,String kdirdhata,int nilai ,String keter){
		try
		{
			String query = queryUpdateIrdhataTbl;
			return  queryUpdateIrdhata(query, tmt, kdirdhata, nilai, keter);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryInsertDataTerusan(String tmt,String kdirdhata,int nilai ,String keter){
		try
		{
			String query = queryInsertIrdhataTbl;
			return  queryInsertDataIrdhata(query, tmt, kdirdhata, nilai, keter);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenampilkanDataIrdhata(){
		try
		{
			String query = queryReadIrdhataTbl;
			return  queryMenampilkanIrdhata(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
