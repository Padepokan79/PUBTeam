package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdHistJiwa;
import com.padepokan79.util.DatabaseConnection;

public class MdHistJiwaController extends DatabaseConnection implements MdHistJiwa{
	
//	Searching hist_jiwa by Jejen
	public JSONArray queryMencariDataHistJiwa(String query, String inputKode) throws SQLException{
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, inputKode);
			
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
	
	public JSONArray getQueryMencariDataHistJiwa(String inputKode){
		try
		{
			String query = queryMenampilkanPenerbit;
			return queryMencariDataHistJiwa(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
//	Menampilkan data jenisskpp_tbl by Jejen
	public JSONArray queryMenampilkanDataHistJiwa(String query) throws SQLException{
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

	public JSONArray getQueryMenampilkanHistJiwa(){
		try
		{
			String query = queryReadHistJiwa;
			return queryMenampilkanDataHistJiwa(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
//	Mengubah data hist_jiwa by jejen
	public JSONArray queryMengubahPenerbitdiHistJiwa(String query, String nip,String tmt, String penerbit) throws SQLException{
		PreparedStatement st = null;
		try
		{
			 st = (PreparedStatement) conn.prepareStatement(query);
			 st.setString(1, penerbit);	
			 st.setString(2,nip);	
			 st.setString(3,tmt);
				
			st.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public JSONArray getQueryMengubahPenerbitdiHistJiwa(String nip, String tmt, String penerbit){
		try
		{
			String query = queryUpdateHistJiwa;
			return queryMengubahPenerbitdiHistJiwa(query, nip,tmt,penerbit);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
//	Menghapus data hist_jiwa by jejen
	public JSONArray queryMenghapusDataHistJiwa(String query, String nip, String tmt) throws SQLException{
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			st.setString(2, tmt);
			st.executeUpdate();
			if(st !=null){
				st.close();
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public JSONArray getQueryMenghapusDataHistJiwa(String nip, String tmt){
		try
		{
			String query = queryDeleteHistJiwa;
			return queryMenghapusDataHistJiwa(query, nip,tmt);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
//	Menambah data jenisskpp_tbl  by jejen
	public JSONArray queryMenambahDataHistJiwa(String query, String nip,String tmtberlaku,int jistri,int janak,String nomorskep,String tglskep,String penerbitskep,String tglupdate) throws SQLException{
		PreparedStatement st = null;
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);
			st.setString(2, tmtberlaku);
			st.setInt(3, jistri);
			st.setInt(4, janak);
			st.setString(5,nomorskep);
			st.setString(6,tglskep);
			st.setString(7,penerbitskep);
			st.setString(8,tglupdate);
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
	
	public JSONArray getQueryMenambahJenisSkpp( String nip,String tmtberlaku,int jistri,int janak,String nomorskep,String tglskep,String penerbitskep,String tglupdate){
		try
		{
			String query = queryCreateHistJiwa;
			return queryMenambahDataHistJiwa(query, nip,tmtberlaku,jistri,janak,nomorskep,tglskep,penerbitskep,tglupdate);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
