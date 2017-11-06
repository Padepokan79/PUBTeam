package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdJabatanFungsi;
import com.padepokan79.util.DatabaseConnection;

public class MdJabatanFungsiController extends DatabaseConnection implements MdJabatanFungsi {
	public JSONArray simpleQuery(String query){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();

			//System.out.println("------ ------ ------ ----- -----");
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMenampilkanTabelJabatanFungsi(String query) throws SQLException{
		PreparedStatement st = null;
		try
		{
			st=(PreparedStatement) conn.prepareStatement(query);
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result= Convertor.convertToJSON(rs);
			rs=null;
			if (st!=null) {
				st.close();
			}
			return result;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMenambahkanTabelJabatanFungsi(String query, int KDFUNGSI, String NMFUNGSI){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, KDFUNGSI);
				st.setString(2, NMFUNGSI);
			st.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMenghapusTabelJabatanFungsi(String query, int NMFUNGSI){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, NMFUNGSI);
			st.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMerubahTabelJabatanFungsi(String query,String NMFUNGSI, int KDFUNGSI){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, NMFUNGSI);	
			st.setInt(2, KDFUNGSI);
			st.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMencariKodeTransTabelJabatanFungsi(String query, int KDFUNGSI){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, KDFUNGSI);
			
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
//-----------------------------------------------------------------------------------------------------------------	
	
	public JSONArray getMenampilkanTabelJabatanFungsi(){
		try
		{
			String query = querySelectData;
			return queryMenampilkanTabelJabatanFungsi(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenambahkanTabelJabatanFungsi(int KDFUNGSI, String NMFUNGSI){
		try
		{
			String query = queryInsertData;
			return queryMenambahkanTabelJabatanFungsi(query, KDFUNGSI, NMFUNGSI);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenghapusTabelJabatanFungsi(int KDFUNGSI){
		try
		{
			String query = queryDeleteDataBerdasarkanKodeFungsi;
			return queryMenghapusTabelJabatanFungsi(query, KDFUNGSI);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMerubahTabelJabatanFungsi(String NMFUNGSI, int KDFUNGSI){
		try
		{
			String query = queryUpdateNamaBerdasarkanKodeFungsi;
			return queryMerubahTabelJabatanFungsi(query, NMFUNGSI, KDFUNGSI);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMencariKodeTransTabelJabatanFungsi(int KDFUNGSI){
		try
		{
			String query = querySearchNamaBerdasarkanKdFungsi;
			return queryMencariKodeTransTabelJabatanFungsi(query, KDFUNGSI);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
