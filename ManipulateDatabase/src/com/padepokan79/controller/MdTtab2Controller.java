package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdTtab2;
import com.padepokan79.util.DatabaseConnection;

public class MdTtab2Controller extends DatabaseConnection implements MdTtab2{
//////////////////////////////////MENAMPILKAN//////////////////////////////////////////////////////////	
	public JSONArray queryMenampilkanTtab2(String query)throws SQLException{
		PreparedStatement st = null;
		try
		{

			 st=(PreparedStatement) conn.prepareStatement(query);
//			st.setInt(1, inputKode);
			
			ResultSet rs = (ResultSet) st.executeQuery();
			//return Convertor.convertToJSON(rs);
			JSONArray result=Convertor.convertToJSON(rs);
			rs=null;
			
			if(st!=null){
				st.close();
			}
			return result;
			

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	////////////////////////////////////////////MENAMBAH////////////////////////////////////////
	public JSONArray queryMenambahkanTtab2(String query,int kode,String jenjab,String agama){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, kode);
			st.setString(2, jenjab);	
			st.setString(3, agama);
			
			
			st.executeUpdate();
			
		
			
			//ResultSet rs = (ResultSet) st.executeQuery();
			//return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	//////////////////////////////////MENCARI//////////////////////////////////////////////////
	public JSONArray queryMencariDataBerdasarkanKODE(String query,int kode){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, kode);
			
		
			
		ResultSet rs = (ResultSet) st.executeQuery();
		return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	//////////////////////////////////MENGUBAH//////////////////////////////////////////////////
	public JSONArray queryMengubahAgamaBerdasarkanKODE(String query,String agama,int kode){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, agama);
			st.setInt(2, kode);
			
			st.executeUpdate();
			

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	///////////////////////////////////MENGHAPUS/////////////////////////////////////////////////
	public JSONArray queryHapusTtab2BerdasarkanKODE(String query, int inputKode){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, inputKode);

			
			st.executeUpdate();
			
//			ResultSet rs = (ResultSet) st.executeQuery();
//			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	//===========================MENAMPILKAN======================================================
	public JSONArray getMenampilkanTtab2(){
		try
		{
			String query = menampilkanTtab2;
			return queryMenampilkanTtab2(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	//================================MENAMBAH==================================================
	public JSONArray getMenambahkanTtab2(int kode,String jenjab,String agama){
		try
		{
			String query = menambahkanTtab2;
			return queryMenambahkanTtab2(query,kode,jenjab,agama);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	//====================================MENGUBAH==============================================
	public JSONArray getMengubahAgamaBerdasarkanKODE(String agama,int kode){
		try
		{
			String query = mengubahAgamaBerdasarkanKODE;
			return queryMengubahAgamaBerdasarkanKODE(query,agama,kode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	//======================================MENGHAPUS============================================
	public JSONArray getHapusTtab2BerdasarkanKODE(int kode){
		try
		{
			String query = hapusTtab2BerdasarkanKODE;
			return queryHapusTtab2BerdasarkanKODE(query,kode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	//======================================MENCARI============================================
		public JSONArray getMencariDataBerdasarkanKODE(int kode){
			try
			{
				String query = mencariDataBerdasarkanKODE;
				return queryMencariDataBerdasarkanKODE(query,kode);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
}
