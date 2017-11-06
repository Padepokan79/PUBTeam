package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdFungsionalTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdFungsionaltblController extends DatabaseConnection implements MdFungsionalTbl {

	public MdFungsionaltblController() {
		// TODO Auto-generated constructor stub
	}
	
	public JSONArray queryMenampilkanTabelFungsional(String query){
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
	
	public JSONArray getMenampilkanTabelFungsional(){
		try
		{
			String query = tampilDataFungsional;
			return queryMenampilkanTabelFungsional(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	public JSONArray queryMencariNamaFungsi(String query, String inputKode){
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
			String query = cariNamaFungsional;
			return queryMencariNamaFungsi(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	public JSONArray queryMenambahkanFungsional(String query, String tmt, String kdF, String nmF, int rp){
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, tmt);
			st.setString(2, kdF);
			st.setString(3, nmF);
			st.setInt(4, rp);
			
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
	
	public JSONArray getMenambahFungsional(String tmt, String kdF, String nmF, int rp){
		try
		{
			String query = tambahDataFungsional;
			return queryMenambahkanFungsional(query, tmt, kdF, nmF, rp);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	public JSONArray queryMengeditFungsional(String query, String nmF, String kdF){
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nmF);
			st.setString(2, kdF);
			
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
	
	public JSONArray getMengeditFungsional(String nmF, String kdF){
		try
		{
			String query = ubahDataFungsional;
			return queryMengeditFungsional(query, nmF, kdF);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	public JSONArray queryMenghapusFungsional(String query, String kdF){
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, kdF);
			
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
	
	public JSONArray getMenghapusFungsional(String kdF){
		try
		{
			String query = hapusDataFungsional;
			return queryMenghapusFungsional(query, kdF);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}