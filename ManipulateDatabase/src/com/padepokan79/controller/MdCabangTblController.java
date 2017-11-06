package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdCabangTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdCabangTblController extends DatabaseConnection implements MdCabangTbl {
	public MdCabangTblController() {
		
	}
	
	public JSONArray queryMenambahkanCabang(String query, String inputKode, String inputNama, String inputNick){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, inputKode);
			st.setString(2, inputNama);
			st.setString(3, inputNick);
			
			st.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	
	public JSONArray queryMenampilkanTabelCabang(String query){
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
	
	public JSONArray queryMencariNamaCabang(String query, String inputKode){
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
	
	
	public JSONArray queryMengeditCabang(String query, String inputNama, String inputNick, String inputKode ){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, inputNama);
			st.setString(2, inputNick);
			st.setString(3, inputKode);
		
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
