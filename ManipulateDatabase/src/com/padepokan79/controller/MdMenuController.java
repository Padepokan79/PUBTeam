package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdMenuTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdMenuController extends DatabaseConnection implements MdMenuTbl{
	public JSONArray simpleQuery(String query){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray res= Convertor.convertToJSON(rs);
			rs=null;
			if(st!=null) {
				st.close();
			}
			//System.out.println("------ ------ ------ ----- -----");
			return res;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMencariMenuByKode(String query,String inputKode){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, inputKode);
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray res= Convertor.convertToJSON(rs);
			rs = null;
			if(st!=null) {
				st.close();
			}
			return res;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryTambahMenu(String query,String kode,String nama,String fm) throws SQLException{
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
		try
		{
			st.setString(1, kode);
			st.setString(2, nama);
			st.setString(3, fm);
			st.executeUpdate();
			if(st!=null) {
				st.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryUbahMenu(String query,String kode,String nama,String fm) throws SQLException{
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
		try
		{
			st.setString(3, kode);
			st.setString(1, nama);
			st.setString(2, fm);
			st.executeUpdate();
			if(st!=null) {
				st.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryHapusMenu(String query,String kode) throws SQLException{
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
		try
		{
			st.setString(1, kode);
			st.executeUpdate();
			if(st!=null) {
				st.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	
	public JSONArray getQueryMencariMenuByKode(String inputKode){
		try
		{
			String query = tampilMenu;
			return queryMencariMenuByKode(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryTambahMenu(String kode,String nama,String fm){
		try
		{
			String query = tambahMenu;
			return queryTambahMenu(query, kode, nama, fm);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryUbahMenu(String kode,String nama,String fm){
		try
		{
			String query = updateMenu;
			return queryUbahMenu(query, kode, nama, fm);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryHapusMenu(String kode){
		try
		{
			String query = deleteMenu;
			return queryHapusMenu(query, kode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryTampilMenu(){
		try
		{
			String query = tampilMenuAll;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
