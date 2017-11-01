package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdStatus;
import com.padepokan79.util.DatabaseConnection;

public class MdStatusController extends DatabaseConnection implements MdStatus {
	
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
	
	public JSONArray getQueryMencariData(String query, String input) {
		PreparedStatement st = null;
		try {
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, input);
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result = Convertor.convertToJSON(rs);
			rs = null;
			if (st!=null) {
				st.close();
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryCUDData(String query, String kode, String nama) {
		PreparedStatement st = null;
		try {
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, kode);
			st.setString(2, nama);
			st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenghapusData(String query, String kode) {
		PreparedStatement st = null;
		try {
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, kode);
			st.executeUpdate();
		} catch (Exception e) {
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
	
	public JSONArray getQueryMencariDdata(String input){
		try
		{
			String query = queryMencariData;
			return getQueryMencariData(query, input);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenambahData(String kode, String nama) {
		try {
			String query = queryMenambahData;
			return getQueryCUDData(query, kode, nama);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMengubahData(String kode, String nama) {
		try {
			String query = queryMengubahData;
			return getQueryCUDData(query, kode, nama);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenghapusData(String kode) {
		try {
			String query = queryMenghapusData;
			return getQueryMenghapusData(query, kode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
