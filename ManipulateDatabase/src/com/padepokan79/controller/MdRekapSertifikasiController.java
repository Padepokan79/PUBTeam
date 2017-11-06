package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdRekapSertifikasi;
import com.padepokan79.util.DatabaseConnection;

public class MdRekapSertifikasiController extends DatabaseConnection implements MdRekapSertifikasi{
	public MdRekapSertifikasiController() {

	}

	public JSONArray queryMencariTglgajiTglBayarKdsatkerdanPeg(String query, String inputKode) throws SQLException{
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
	public JSONArray getQueryMencariqueryMencariTglgajiTglBayarKdsatkerdanPeg(String inputKode){
		try
		{
			String query = mencariTglgajiTglBayarKdsatkerdanPeg;
			return queryMencariTglgajiTglBayarKdsatkerdanPeg(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMenampilkanSemuaData(String query) throws SQLException{
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
	
	public JSONArray getQueryMenampilkanSemuaData() {
		try
		{
			String query = menampilkanSemuaData;
			return queryMenampilkanSemuaData(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMenambahkanDataDiTabelRekapSertifikasi(String query, String inputKode) throws SQLException{
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, inputKode);
			st.executeUpdate();
			if(st != null) {
				st.close();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryMenambahkanDataDiTabelRekapSertifikasi(String inputKode){
		try
		{
			String query = menambahkanDataDiTabelRekapSertifikasi;
			return queryMenambahkanDataDiTabelRekapSertifikasi(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
