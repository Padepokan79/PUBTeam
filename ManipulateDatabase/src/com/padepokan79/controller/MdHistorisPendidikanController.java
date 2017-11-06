package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdHistorisPendidikan;
import com.padepokan79.util.DatabaseConnection;

public class MdHistorisPendidikanController extends DatabaseConnection implements MdHistorisPendidikan{
//	Searching historisPendidikan by Jejen
	public JSONArray queryMencariDataHistorisPendidikan(String query, String nip) throws SQLException{
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result = Convertor.convertToJSON(rs);
			rs=null;
			if(st !=null){
				st.close();
			}
			return result;
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public JSONArray getQueryMencariDataHistorisPendidikan(String nip){
		try
		{
			String query = queryMencariPenerbit;
			return queryMencariDataHistorisPendidikan(query, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
//	Menampilkan data historisPendidikan by Jejen
	public JSONArray queryMenampilkanDataHistorisPendidikan(String query) throws SQLException{
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result = Convertor.convertToJSON(rs);
			rs=null;
			if(st !=null){
				st.close();
			}
			return result;
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public JSONArray getQueryMenampilkanDataHistorisPendidikan(){
		try
		{
			String query = queryReadHistorisPendidikan;
			return queryMenampilkanDataHistorisPendidikan(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
//	Mengubah data historisPendidikan by jejen
	public JSONArray queryMengubahPenerbitdiHistorisPendidikan(String query, String nip, String penerbit , String catatan) throws SQLException{
		PreparedStatement st = null;
		try
		{
			 st = (PreparedStatement) conn.prepareStatement(query);
			 st.setString(1, penerbit);	
			 st.setString(2,catatan);	
			 st.setString(3,nip);
				
			st.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public JSONArray getQueryMengubahPenerbitdiHistorisPendidikan(String nip, String penerbit, String catatan){
		try
		{
			String query = queryUpdateHistorisPendidikan;
			return queryMengubahPenerbitdiHistorisPendidikan(query, nip, penerbit, catatan);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
//	Menghapus data historisPendidikan by jejen
	public JSONArray queryMenghapusDataHistorisPendidikan(String query, String nip) throws SQLException{
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			st.executeUpdate();
			if(st !=null){
				st.close();
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public JSONArray getQueryMenghapusDataHistorisPendidikan(String nip){
		try
		{
			String query = queryDeleteHistorisPendidikan;
			return queryMenghapusDataHistorisPendidikan(query, nip);
		}catch (Exception e) {
			// TODOhandle exception
		}
		return null;
	}
	
//	Menambah data historispendidikan  by jejen
	public JSONArray queryMenambahDataHistorisPendidikan(String query, String nip,String penerbit,String catatan) throws SQLException{
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			st.setString(2, penerbit);
			st.setString(3, catatan);
			
			st.executeUpdate();
			if(st !=null){
				st.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} 
		return null;
	}
	
	public JSONArray getQueryMenambahDataHistorisPendidikan( String nip,String penerbit,String catatan){
		try
		{
			String query = queryCreateHistorisPendidikan;
			return queryMenambahDataHistorisPendidikan(query, nip, penerbit, catatan);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
