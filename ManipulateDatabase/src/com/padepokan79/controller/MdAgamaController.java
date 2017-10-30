package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdAgamaQuery;
import com.padepokan79.util.DatabaseConnection;

public class MdAgamaController extends DatabaseConnection implements MdAgamaQuery {
	public MdAgamaController() {
		
	}
	public JSONArray queryMenghapusAgama(String query, int inputKode){
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
	public JSONArray queryMenambahkanAgama(String query, int inputKode, String namaAgama){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, inputKode);
			st.setString(2, namaAgama);
			
			st.executeUpdate();
			
//			ResultSet rs = (ResultSet) st.executeQuery();
//			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMengeditAgama(String query, String namaAgama, int inputKode){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, namaAgama);
			st.setInt(2, inputKode);
			
			st.executeUpdate();
			

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMencariNamaAgama(String query, int inputKode){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, inputKode);
			
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMenampilkanTabelAgama(String query){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
//			st.setInt(1, inputKode);
			
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenambahAgama(int inputKode, String namaAgama){
		try
		{
			String query = menambahkanAgama;
			return queryMenambahkanAgama(query, inputKode, namaAgama);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMencariAgama(int inputKode){
		try
		{
			String query = mencariAgama;
			return queryMencariNamaAgama(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenampilkanTabelAgama(){
		try
		{
			String query = menampilkanAgama;
			return queryMenampilkanTabelAgama(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMengeditAgama(String namaAgama, int inputKode){
		try
		{
			String query = MengeditAgama;
			return queryMengeditAgama(query, namaAgama, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenghapusAgama(int inputKode){
		try
		{
			String query = menghapusAgama;
			return queryMenghapusAgama(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}
