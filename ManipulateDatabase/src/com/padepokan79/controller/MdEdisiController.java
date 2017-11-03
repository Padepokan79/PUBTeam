package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdEdisi;
import com.padepokan79.util.DatabaseConnection;

public class MdEdisiController extends DatabaseConnection implements MdEdisi {
	
	public MdEdisiController() {
		// TODO Auto-generated constructor stub
	}
	
	public JSONArray queryMenampilkanTabelEdisi(String query){
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
//			st.setInt(1, inputKode);
			
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result = Convertor.convertToJSON(rs);
			rs=null;
			if(st != null) {
				st.close();
			}
			return result;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getMenampilkanTabelEdisi(){
		try
		{
			String query = tampilDataMdEdisi;
			return queryMenampilkanTabelEdisi(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMenambahkanEdisi(String query, String tglDb, String tglE, String ket){
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, tglDb);
			st.setString(2, tglE);
			st.setString(3, ket);
			
			st.executeUpdate();
			
		
			if(st!=null){
				st.close();
			}
			
			if(conn!=null){
				st.close();
			}

			
//			ResultSet rs = (ResultSet) st.executeQuery();
//			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getMenambahEdisi(String tglDb, String tglE, String ket){
		try
		{
			String query = tambahDataMdEdisi;
			return queryMenambahkanEdisi(query, tglDb, tglE, ket);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMencariKeteranganEdisi(String query, String inputKode){
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, inputKode);
			
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result = Convertor.convertToJSON(rs);
			rs=null;
			if(st != null) {
				st.close();
			}
			return result;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getMencariFungsional(String inputKode){
		try
		{
			String query = cariDataMdEdisi;
			return queryMencariKeteranganEdisi(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	public JSONArray queryMengeditEdisi(String query, String ket, String tglE){
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, ket);
			st.setString(2, tglE);
			
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
	
	public JSONArray getMengeditEdisi(String ket, String tglE){
		try
		{
			String query = ubahDataMdEdisi;
			return queryMengeditEdisi(query, ket, tglE);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMenghapusEdisi(String query, String tglE){
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, tglE);
			
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
	
	public JSONArray getMenghapusEdisi(String tglE){
		try
		{
			String query = hapusDataMdEdisi;
			return queryMenghapusEdisi(query, tglE);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	
}