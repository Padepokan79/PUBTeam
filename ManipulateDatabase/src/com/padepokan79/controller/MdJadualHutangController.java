package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdJadualHutang;
import com.padepokan79.util.DatabaseConnection;

public class MdJadualHutangController extends DatabaseConnection implements MdJadualHutang {
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
	public JSONArray queryMenampilkanTabelJadualHutang(String query) throws SQLException{
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
	public JSONArray queryMenambahkanTabelJadualHutang(String query,String nip, int urut, String tgl_potong,String kode_lbg, int jumlah, int kd_lunas, String tgl_lunas){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);	
			st.setInt(2, urut);
			st.setString(3, tgl_potong);
			st.setString(4, kode_lbg);	
			st.setInt(5, jumlah);
			st.setInt(6, kd_lunas);
			st.setString(7, tgl_lunas);
			st.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMenghapusTabelJadualHutang(String query, int urut){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, urut);
			st.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMerubahTabelJadualHutang(String query,int jumlah, int urut){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, jumlah);	
			st.setInt(2, urut);
			st.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMencariKodeTransTabelJadualHutang(String query, int urut){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, urut);
			
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
//-----------------------------------------------------------------------------------------------------------------	
	
	public JSONArray getMenampilkanTabelJadualHutang(){
		try
		{
			String query = querySelectData;
			return queryMenampilkanTabelJadualHutang(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenambahkanTabelJadualHutang(String nip, int urut, String tgl_potong,String kode_lbg, int jumlah, int kd_lunas, String tgl_lunas){
		try
		{
			String query = queryInsertData;
			return queryMenambahkanTabelJadualHutang(query, nip, urut, tgl_potong, kode_lbg, jumlah, kd_lunas, tgl_lunas);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenghapusTabelJadualHutang(int urut){
		try
		{
			String query = queryDeleteDataBerdasarkanUrut;
			return queryMenghapusTabelJadualHutang(query, urut);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMerubahTabelJadualHutang(int jumlah, int urut){
		try
		{
			String query = queryUpdateJumlahBerdasarkanNoUrut;
			return queryMerubahTabelJadualHutang(query, jumlah, urut);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMencariTabelJadualHutang(int urut){
		try
		{
			String query = querySearchberdasarkanNoUrut;
			return queryMencariKodeTransTabelJadualHutang(query, urut);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
