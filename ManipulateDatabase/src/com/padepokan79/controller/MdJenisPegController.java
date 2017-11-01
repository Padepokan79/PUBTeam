package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdJenisPeg;
import com.padepokan79.util.DatabaseConnection;

public class MdJenisPegController extends DatabaseConnection implements MdJenisPeg{
	public MdJenisPegController(){
		
	}
	
//	Searching jenis pegawai by Jejen
	public JSONArray queryMencariKodeJenisPegawaidiJenisPeg(String query, int inputKode) throws SQLException{
		
		try
		{
			
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, inputKode);
			
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();

			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public JSONArray getQueryMencariKodeJenisPegawaidiJenisPeg(int inputKode){
		try
		{
			String query = queryKodedanNamaJenis;
			return queryMencariKodeJenisPegawaidiJenisPeg(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
//	Menampilkan data jenis pegawai by Jejen
	public JSONArray queryMenampilkanKodeJenisPegawaidiJenisPeg(String query) throws SQLException{
		
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public JSONArray getQueryMenampilkanKodeJenisPegawaidiJenisPeg(){
		try
		{
			String query = queryReadJenisPegawai;
			return queryMenampilkanKodeJenisPegawaidiJenisPeg(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}	
	
//	Mengubah data jenis pegawai by jejen
	public JSONArray queryMengubahNamaJenisPegawaidiJenisPeg(String query, int inputKode, String nmjenis) throws SQLException{
	
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setString(1,nmjenis);
				st.setInt(2, inputKode);
			
			st.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public JSONArray getQueryMengubahNamaJenisPegawaidiJenisPeg(int inputKode,String nmjenis){
		try
		{
			String query = queryUpdateJenisPegawai;
			return queryMengubahNamaJenisPegawaidiJenisPeg(query, inputKode,nmjenis);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
//	Menghapus data jenis pegawai by jejen
	public JSONArray queryMenghapusJenisPegawaidiJenisPeg(String query, int inputKode) throws SQLException{
		
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, inputKode);
			st.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public JSONArray getQueryMenghapusJenisPegawaidiJenisPeg(int inputKode){
		try
		{
			String query = queryDeleteJenisPegawai;
			return queryMenghapusJenisPegawaidiJenisPeg(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
//	Menambah data jenis pegawai by jejen
	public JSONArray queryMenambahJenisPegawaidiJenisPeg(String query, int inputKode,String nmJenis) throws SQLException{
		
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, inputKode);
			st.setString(2, nmJenis);
			st.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} 
		return null;
	}
	
	public JSONArray getQueryMenambahJenisPegawaidiJenisPeg(int inputKode,String nmJenis){
		try
		{
			String query = queryCreateJenisPegawai;
			return queryMenambahJenisPegawaidiJenisPeg(query, inputKode, nmJenis);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}

