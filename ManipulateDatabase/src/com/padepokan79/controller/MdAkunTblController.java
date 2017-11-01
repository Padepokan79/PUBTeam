package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdAkunTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdAkunTblController extends DatabaseConnection implements MdAkunTbl {
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
	public JSONArray queryMenampilkanTabelAKun(String query) throws SQLException{
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
	public JSONArray queryMenambahkanTabelAkun(String query, int KDTRANS, String KDAKUN, String NMAKUN, String idakun){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, KDTRANS);
				st.setString(2, KDAKUN);
				st.setString(3, NMAKUN);
				st.setString(4, idakun);
			st.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMenghapusTabelAkun(String query, int kdtrans){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, kdtrans);
			st.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMerubahTabelAkun(String query,String NMAKUN, int KDTRANS){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, NMAKUN);	
			st.setInt(2, KDTRANS);
			st.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMencariKodeTransTabelAkun(String query, int kdtrans){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, kdtrans);
			
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
//-----------------------------------------------------------------------------------------------------------------	
	
	public JSONArray getMenampilkanTabelAkun(){
		try
		{
			String query = querySelectKdakunDanNmakun;
			return queryMenampilkanTabelAKun(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenambahkanTabelAkun(int KDTRANS, String KDAKUN, String NMAKUN, String idakun){
		try
		{
			String query = queryInsertDataAkun_tbl;
			return queryMenambahkanTabelAkun(query,KDTRANS,KDAKUN,NMAKUN,idakun);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenghapusTabelAkun(int kdtrans){
		try
		{
			String query = queryDeleteDataBerdasarkanKdTrans;
			return queryMenghapusTabelAkun(query, kdtrans);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMerubahTabelAkun(String NMAKUN,int KDTRANS){
		try
		{
			String query = queryUpdateNamaBerdasarkanKodeTrans;
			return queryMerubahTabelAkun(query, NMAKUN, KDTRANS);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMencariTabelAkun(int kdtrans){
		try
		{
			String query = querySearchBerdasarkanKodeTrans;
			return queryMencariKodeTransTabelAkun(query, kdtrans);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
