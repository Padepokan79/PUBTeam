package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdJenisSkppTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdJenisSkppTblController  extends DatabaseConnection implements MdJenisSkppTbl{

//	Searching jenisskpp_tbl by Jejen
	public JSONArray queryMencariJenisSkpp(String query, int inputKode) throws SQLException{
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, inputKode);
			
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
	
	public JSONArray getQueryMencariJenisSkpp(int inputKode){
		try
		{
			String query = queryMencariNamaSkpp;
			return queryMencariJenisSkpp(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
//	Menampilkan data jenisskpp_tbl by Jejen
	public JSONArray queryMenampilkanJenisSkpp(String query) throws SQLException{
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

	public JSONArray getQueryMenampilkanJenisSkpp(){
		try
		{
			String query = queryReadJenisSkpp;
			return queryMenampilkanJenisSkpp(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}	
//	Mengubah data jenisskpp_tbl by jejen
	public JSONArray queryMengubahNamaJenisSkpp(String query, int jenis, String namaJenis) throws SQLException{
		PreparedStatement st = null;
		try
		{
			 st = (PreparedStatement) conn.prepareStatement(query);
			 st.setString(1, namaJenis);	
			 st.setInt(2,jenis);
				
			st.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public JSONArray getQueryMengubahNamaJenisSkpp(int jenis, String namaJenis){
		try
		{
			String query = queryUpdateJenisSkpp;
			return queryMengubahNamaJenisSkpp(query, jenis, namaJenis);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
//	Menghapus data jenisskpp_tbl by jejen
	public JSONArray queryMenghapusJenisSkpp(String query, int inputKode) throws SQLException{
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, inputKode);
			st.executeUpdate();
			if(st !=null){
				st.close();
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public JSONArray getQueryMenghapusJenisSkpp(int inputKode){
		try
		{
			String query = queryDeleteJenisSkpp;
			return queryMenghapusJenisSkpp(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
//	Menambah data jenisskpp_tbl  by jejen
	public JSONArray queryMenambahJenisSkpp(String query, int jenis,String namaJenis) throws SQLException{
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, jenis);
			st.setString(2, namaJenis);
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
	
	public JSONArray getQueryMenambahJenisSkpp(int jenis, String namaJenis){
		try
		{
			String query = queryCreateJenisSkpp;
			return queryMenambahJenisSkpp(query, jenis, namaJenis);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
