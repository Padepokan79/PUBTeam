package com.padepokan79.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;

import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdJabatanTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdJabatanTblController extends DatabaseConnection implements MdJabatanTbl{
public MdJabatanTblController(){
		
	}
	public JSONArray queryMenghapusJabatan(String query, String inputKode){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, inputKode);

			st.executeUpdate();
			
//			ResultSet rs = (ResultSet) st.executeQuery();
//			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMenambahkanJabatan(String query, String inputKode, String inputGapok, String j, int a, int b, int c, String i){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, inputKode);
			st.setString(2, inputGapok);
			st.setString(3, j);
			st.setInt(4, a);
			st.setInt(5, b);
			st.setInt(6, c);
			st.setString(7, i);
			
			st.executeUpdate();
			
//			ResultSet rs = (ResultSet) st.executeQuery();
//			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMengeditJabatan(String query, String a, String i){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			
			st.setString(1, i);
			st.setString(2, a);
			
			st.executeUpdate();
			

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray mencariJabatan (String query, String kode) throws SQLException {
		PreparedStatement st = null; 
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			
			st.setString(1, kode);
			
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result=Convertor.convertToJSON(rs);
			//rs=null;
		
			if(st!=null) {
				st.close();
			}
			
		return result;
		}catch(Exception e){
			
		}
		return null;
	}

	
	public JSONArray queryMenampilkanTabelJabatan(String query) throws SQLException{
PreparedStatement st = null;
		
		try
		{
			st=(PreparedStatement) conn.prepareStatement(query);
			// execute the query, and get a java resultset
			//for insert, update, delete
			//st.executeUpdate();
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result=Convertor.convertToJSON(rs);
			//rs=null;
		
			if(st!=null) {
				st.close();
			}
			
		return result;
		}catch(Exception e){
			
		}
		return null;
	}
	public JSONArray getMenambahJabatan(String inputKode, String input, String i, int a, int b, int c, String j){
		try
		{
			String query = menambahData;
			return queryMenambahkanJabatan(query, inputKode, input, i, a, b, c, j);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
//	public JSONArray getMencariBUlan(int inputKode){
//		try
//		{
//			String query = mencariBulan;
//			return mencariBulan(query, inputKode);
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//		return null;
//	}
	public JSONArray getMenampilkanTabelJabatan(){
		try
		{
			String query = menampilkanJabatan;
			return queryMenampilkanTabelJabatan(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMengeditJabatan(String kode, String param){
		try
		{
			String query = mengubahJabatan;
			return queryMengeditJabatan(query, kode, param);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenghapusJabatan(String inputKode){
		try
		{
			String query = menghapusData;
			return queryMenghapusJabatan(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


	
	public JSONArray getmencariJabatan(String kode){
		try
		{
			String query = mencariData;
			return mencariJabatan(query, kode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
