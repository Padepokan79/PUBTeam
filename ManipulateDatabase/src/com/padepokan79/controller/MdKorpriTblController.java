package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdKorpriTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdKorpriTblController extends DatabaseConnection implements MdKorpriTbl{
	public JSONArray simpleQuery(String query){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray res = Convertor.convertToJSON(rs);
			rs=null;
			if(st!=null) {
				st.close();
			}
			
			//System.out.println("------ ------ ------ ----- -----");
			return res;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMencariKorpriByKode(String query,int inputKode){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, inputKode);
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray res = Convertor.convertToJSON(rs);
			rs=null;
			if(st!=null) {
				st.close();
			}
			return res;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryMencariKorpriByKode(int inputKode){
		try
		{
			String query = cariKorpriBerdaskrkankode;
			return queryMencariKorpriByKode(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryTampilKorpri(){
		try
		{
			String query = tampilKorpri;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryTambahKorpri(String query,String tmt,String kdkorpri,int nilai,String keter) throws SQLException{
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
		try
		{
			st.setString(1, tmt);
			st.setString(2, kdkorpri);
			st.setInt(3, nilai);
			st.setString(4, keter);
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
	
	public JSONArray queryHapusKorpri(String query,String kdkorpri) throws SQLException{
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
		try
		{
			st.setString(1, kdkorpri);
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
	
	public JSONArray queryUbahKorpri(String query,String kdkorpri,int nilai,String keter) throws SQLException{
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
		try
		{
			st.setString(3, kdkorpri);
			st.setInt(1, nilai);
			st.setString(2, keter);
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
	
	public JSONArray getQueryTambahKorpri(String tmt,String kdkorpri,int nilai,String keter){
		try
		{
			String query = tambahKorpri;
			return  queryTambahKorpri(query, tmt,kdkorpri,nilai,keter);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryUbahKorpri(String kdkorpri,int nilai,String keter){
		try
		{
			String query = updateKorpri;
			return  queryUbahKorpri(query, kdkorpri,nilai,keter);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryHapusKorpri(String kdkorpri){
		try
		{
			String query = deleteKorpri;
			return  queryHapusKorpri(query, kdkorpri);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


}
