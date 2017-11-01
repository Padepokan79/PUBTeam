package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdTwafat;
import com.padepokan79.util.DatabaseConnection;

public class MdTwafatController extends DatabaseConnection implements MdTwafat {
	
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
	
	public JSONArray mencariData(String query,String nosurat){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nosurat);
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
	
	public JSONArray menambahData(String query, String nip, String hubkel, String wafat, String nosurat, String surat, String penerbit, int terusan, String stop, String penerima){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			st.setString(2, hubkel);
			st.setString(3, wafat);
			st.setString(4, nosurat);
			st.setString(5, surat);
			st.setString(6, penerbit);
			st.setInt(7, terusan);
			st.setString(8, stop);
			st.setString(9, penerima);
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray mengubahData(String query,String penerbit, String nosurat){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, penerbit);
			st.setString(2, nosurat);
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray menghapusData(String query,String nosurat){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nosurat);
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
	
	public JSONArray getQueryMencariData(String nosurat){
		try
		{
			String query = queryMencariData;
			return mencariData(query, nosurat);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenambahData(String nip, String hubkel, String wafat, String nosurat, String surat, String penerbit, int terusan, String stop, String penerima){
		try
		{
			String query = queryMenambahData;
			return menambahData(query,nip, hubkel, wafat, nosurat, surat,penerbit, terusan,stop,penerima);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMengubahData(String penerbit,String nosurat ){
		try
		{
			String query = queryMengubahData;
			return mengubahData(query, penerbit, nosurat);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenghapusData(String nosurat){
		try
		{
			String query = queryMenghapusData;
			return menghapusData(query, nosurat);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
