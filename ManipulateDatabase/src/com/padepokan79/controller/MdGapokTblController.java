package com.padepokan79.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;

import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdGapokTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdGapokTblController extends DatabaseConnection implements MdGapokTbl {
	public MdGapokTblController(){
		
	}
	public JSONArray queryMenghapusGapok(String query, String inputKode){
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
	public JSONArray queryMenambahkanGapok(String query, int inputKode, String inputGapok, String j, int a, int b, int c){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, inputKode);
			st.setString(2, inputGapok);
			st.setString(3, j);
			st.setInt(4, a);
			st.setInt(5, b);
			st.setInt(6, c);
			
			st.executeUpdate();
			
//			ResultSet rs = (ResultSet) st.executeQuery();
//			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMengeditGapok(String query, String kode, int nilai){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			
			st.setInt(1, nilai);
			st.setString(2, kode);
			
			st.executeUpdate();
			

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray mencariGapok (String query, String kode) throws SQLException {
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

	
	public JSONArray queryMenampilkanTabelGapok(String query) throws SQLException{
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
	public JSONArray getMenambahGapok(int inputKode, String input, String i, int a, int b, int c){
		try
		{
			String query = menambahkanDataGapok;
			return queryMenambahkanGapok(query, inputKode, input, i, a, b, c);
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
	public JSONArray getMenampilkanTabelGapok(){
		try
		{
			String query = menampilkanDataGapok;
			return queryMenampilkanTabelGapok(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMengeditGapok(String kode, int nilai){
		try
		{
			String query = mengubahNilaiBawah;
			return queryMengeditGapok(query, kode, nilai);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenghapusGapok(String inputKode){
		try
		{
			String query = menghapusData;
			return queryMenghapusGapok(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


	
	public JSONArray getmencariGapok (String kode){
		try
		{
			String query = mencariData;
			return mencariGapok(query, kode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
