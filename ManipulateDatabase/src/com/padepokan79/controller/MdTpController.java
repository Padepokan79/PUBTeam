package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdTp;
import com.padepokan79.util.DatabaseConnection;

public class MdTpController extends DatabaseConnection implements MdTp {

	public JSONArray simpleQuery(String query){
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result = Convertor.convertToJSON(rs);
			rs = null;
			if (st!=null) {
				st.close();
			}
			return result;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray mencariData(String query, String kode){
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, kode);
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result = Convertor.convertToJSON(rs);
			rs = null;
			if (st!=null) {
				st.close();
			}
			return result;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray menambahData(String query, String kode, String ket, int satu, int dua){
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, kode);
			st.setString(2, ket);
			st.setInt(3, satu);
			st.setInt(4, dua);
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray mengubahData(String query, String ket, String kode){
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, ket);
			st.setString(2, kode);
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray menghapusData(String query,String kode){
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, kode);
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenampilkanData(){
		try
		{
			String query = queryMenampilkanData;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public JSONArray getQueryMencariData(String kode){
		try
		{
			String query = queryMencariData;
			return mencariData(query, kode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenambahData(String kode, String ket, int satu, int dua){
		try
		{
			String query = queryMenambahData;
			return menambahData(query,kode, ket, satu, dua);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMengubahData(String ket, String kode){
		try
		{
			String query = queryMengubahData;
			return mengubahData(query, ket, kode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenghapusData(String kode){
		try
		{
			String query = queryMenghapusData;
			return menghapusData(query, kode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}
