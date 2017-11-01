package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdTbulan;
import com.padepokan79.util.DatabaseConnection;

public class MdTbulanController extends DatabaseConnection implements MdTbulan {

	public MdTbulanController() {
		
	}
	
	public JSONArray queryMenambahkanBulan(String query, int inputKode, String namaBulan){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, inputKode);
			st.setString(2, namaBulan);
			
			st.executeUpdate();
			
//			ResultSet rs = (ResultSet) st.executeQuery();
//			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	
	public JSONArray queryMenampilkanTabelBulan(String query){
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
//			st.setInt(1, inputKode);
			
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
	
	public JSONArray queryMencariNamaBulan(String query, int inputKode){
		PreparedStatement st = null;
		try
		{

			st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, inputKode);
			
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
	
	
	public JSONArray queryMengeditBulan(String query, String namaBulan, int inputKode ){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, namaBulan);
			st.setInt(2, inputKode);
		
			st.executeUpdate();
			

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	
	
	public JSONArray queryMenghapusBulan(String query, int inputKode){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, inputKode);

			
			st.executeUpdate();
			
//			ResultSet rs = (ResultSet) st.executeQuery();
//			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	////////////////////////////////////////////////GET///////////////////////////////////////////////
	
	public JSONArray getMenambahBulan(int inputKode, String namaBulan){
		try
		{
			String query = menambahkanDatadiTbulan;
			return queryMenambahkanBulan(query, inputKode, namaBulan);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getMenampilkanTabelBulan(){
		try
		{
			String query = menampilkanSemuaData;
			return queryMenampilkanTabelBulan(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getMencariBulan(int inputKode){
		try
		{
			String query = mencariKdbulandanNmBulan;
			return queryMencariNamaBulan(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	public JSONArray getMengeditBulan(int inputKode, String namaBulan){
		try
		{
			String query = mengubahBulan;
			return queryMengeditBulan(query, namaBulan, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	public JSONArray getMenghapusBulan(int inputKode){
		try
		{
			String query = menghapusBulan;
			return queryMenghapusBulan(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}
