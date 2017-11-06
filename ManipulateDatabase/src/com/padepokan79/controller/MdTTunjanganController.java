package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdTTunjangan;
import com.padepokan79.util.DatabaseConnection;

public class MdTTunjanganController extends DatabaseConnection implements MdTTunjangan{

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
	
	public JSONArray queryInsertDataTunjangan(String query,String kdkel,String kdjab,String nmjabatan,int jml ,int pensiun) throws SQLException{
		PreparedStatement st=null;
		try
		{// kdkel= ? , kdjab= ? , nmjabatan=? , jml = ? , pensiun
			st = (PreparedStatement) conn.prepareStatement(query);
			
			st.setString(1, kdkel);
			st.setString(2, kdjab);
			st.setString(3,nmjabatan);
			st.setInt(4, jml);
			st.setInt(5, pensiun);
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
	
	public JSONArray queryUpdateTunjangan(String query,String kdkel,String kdjab,String nmjabatan,int jml ,int pensiun) throws SQLException{
		PreparedStatement st=null;
		try
		{//nmjabatan=? , jml = ? , pensiun= ? where kdkel= ? and kdjab= ?
			st = (PreparedStatement) conn.prepareStatement(query);

			st.setString(1,nmjabatan);
			st.setInt(2, jml);
			st.setInt(3, pensiun);
			st.setString(4, kdkel);
			st.setString(5, kdjab);
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
	
	public JSONArray queryDeleteDataTunjangan(String query,String kdkel,String kdjab) throws SQLException{
		PreparedStatement st=null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, kdkel);
			st.setString(2, kdjab);
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
	
	public JSONArray querySearchDataTunjangan(String query,String kdjab) throws SQLException{
		PreparedStatement st=null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, kdjab);
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
	
	public JSONArray getQuerySearchTunjangan(String kdjab){
		try
		{
			String query = querySearchTTunjangan;
			return  querySearchDataTunjangan(query, kdjab);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryDeleteDataTunjangan(String kdkel,String kdjab){
		try
		{
			String query = queryDeleteTTunjangan;
			return  queryDeleteDataTunjangan(query, kdkel, kdjab);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryUpdateDataTunjangan(String kdkel,String kdjab,String nmjabatan,int jml ,int pensiun){
		try
		{
			String query = queryUpdateTTunjangan;
			return  queryUpdateTunjangan(query, kdkel, kdjab, nmjabatan, jml, pensiun);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryInsertDataTunjangan(String kdkel,String kdjab,String nmjabatan,int jml ,int pensiun){
		try
		{
			String query = queryInsertTTunjangan;
			return  queryInsertDataTunjangan(query, kdkel, kdjab, nmjabatan, jml, pensiun);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenampilkanTunjangan(){
		try
		{
			String query = queryReadTTunjangan;
			return  queryMenampilkanIrdhata(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
