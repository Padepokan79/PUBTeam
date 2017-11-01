package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdSkpdKota;
import com.padepokan79.util.DatabaseConnection;

public class MdSkpdController extends DatabaseConnection implements MdSkpdKota {
	
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
	
	public JSONArray mencariData(String query, String nama){
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nama);
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
	
	public JSONArray menambahData(String query, String cabang, String ssbp, String skpd, String nama, String upd, String input, String kel){
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, cabang);
			st.setString(2, ssbp);
			st.setString(3, skpd);
			st.setString(4, nama);
			st.setString(5, upd);
			st.setString(6, input);
			st.setString(7, kel);
			st.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray mengubahData(String query, String nama, String skpd){
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nama);
			st.setString(2, skpd);
			st.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray menghapusData(String query,String skpd){
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, skpd);
			st.executeUpdate();
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
	
	public JSONArray getQueryMencariData(String nama){
		try
		{
			String query = queryMencariData;
			return mencariData(query, nama);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenambahData(String cabang, String ssbp, String skpd, String nama, String upd, String input, String kel) {
		try
		{
			String query = queryMenambahData;
			return menambahData(query, cabang, ssbp, skpd, nama, upd, input, kel);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMengubahData(String nama, String skpd){
		try
		{
			String query = queryMengubahData;
			return mengubahData(query, nama, skpd);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenghapusData(String skpd){
		try
		{
			String query = queryMenghapusData;
			return menghapusData(query,skpd);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
