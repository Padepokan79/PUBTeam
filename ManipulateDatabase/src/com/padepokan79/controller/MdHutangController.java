package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdHutang;
import com.padepokan79.util.DatabaseConnection;

public class MdHutangController extends DatabaseConnection implements MdHutang {

	public JSONArray simpleQuery(String query){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
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
	
	public JSONArray mencariData(String query, int hutang){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, hutang);
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
	
	public JSONArray menambahData(String query, String nip, int kode, int norut, int jmlhutang, int jmlcicilan, int akhir, int waktu, String tmt, String tat, String ket, String lunas, int jmlunas, String gaji){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			st.setInt(2, kode);
			st.setInt(3, norut);
			st.setInt(4, jmlhutang);
			st.setInt(5, jmlcicilan);
			st.setInt(6, akhir);
			st.setInt(7, waktu);
			st.setString(8, tmt);
			st.setString(9, tat);
			st.setString(10, ket);
			st.setString(11, lunas);
			st.setInt(12, jmlunas);
			st.setString(13, gaji);
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray mengubahData(String query, String ket, String nip){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, ket);
			st.setString(2, nip);
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray menghapusData(String query,String nip){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
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
	
	public JSONArray getQueryMencariData(int hutang){
		try
		{
			String query = queryMencariData;
			return mencariData(query, hutang);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenambahData(String nip, int kode, int norut, int jmlhutang, int jmlcicilan, int akhir, int waktu, String tmt, String tat, String ket, String lunas, int jmlunas, String gaji){
		try
		{
			String query = queryMenambahData;
			return menambahData(query,nip,kode,norut,jmlhutang,jmlcicilan,akhir,waktu,tmt,tat,ket,lunas,jmlunas,gaji);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMengubahData(String ket, String nip){
		try
		{
			String query = queryMengubahData;
			return mengubahData(query, ket, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray getQueryMenghapusData(String nip){
		try
		{
			String query = queryMenghapusData;
			return menghapusData(query,nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
