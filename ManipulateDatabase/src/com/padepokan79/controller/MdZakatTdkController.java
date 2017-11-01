package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdZakatTdk;
import com.padepokan79.util.DatabaseConnection;

public class MdZakatTdkController extends DatabaseConnection implements MdZakatTdk {

	public MdZakatTdkController() {
	
	}
	public JSONArray queryMenambahkanZakat(String query, String inputKode, String mulai){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, inputKode);
			st.setString(2, mulai);
			
			st.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	
	public JSONArray queryMenampilkanTabelZakat(String query){
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result = Convertor.convertToJSON(rs);
			rs = null;
			if(st != null) {
				st.close();
			}
			return result;

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMencariMulai(String query, String inputKode){
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, inputKode);
			
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result = Convertor.convertToJSON(rs);
			rs = null;
			if(st != null) {
				st.close();
			}
			return result;

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	public JSONArray queryMengeditZakat(String query, String mulai, String inputKode ){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, mulai);
			st.setString(2, inputKode);
		
			st.executeUpdate();
			

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	public JSONArray queryMenghapusZakat(String query, String inputKode){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, inputKode);
			
			st.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	////////////////////////////////////////////////GET///////////////////////////////////////////////
	
	public JSONArray getMenambahZakat(String inputKode, String mulai){
		try
		{
			String query = menambahkanDataZakat;
			return queryMenambahkanZakat(query, inputKode, mulai);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getMenampilkanTabelZakat(){
		try
		{
			String query = menampilkanSemuaDataZakat;
			return queryMenampilkanTabelZakat(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getMencariZakat(String inputKode){
		try
		{
			String query = mencariDataZakat;
			return queryMencariMulai(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	public JSONArray getMengeditZakat(String inputKode, String mulai){
		try
		{
			String query = mengubahMulaiZakat;
			return queryMengeditZakat(query, mulai, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	public JSONArray getMenghapusZakat(String inputKode){
		try
		{
			String query = menghapusDataZakat;
			return queryMenghapusZakat(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
