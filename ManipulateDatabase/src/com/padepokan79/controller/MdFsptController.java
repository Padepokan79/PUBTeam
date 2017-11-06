package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdFSpt;
import com.padepokan79.util.DatabaseConnection;

public class MdFSptController extends DatabaseConnection implements MdFSpt {
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
	public JSONArray queryMenampilkanTabelFSpt(String query) throws SQLException{
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
	public JSONArray queryMenambahkanTabelFSpt(String query,String nip,String nama, String kdskpd, String KdSatker, int nourt, double th_pajak){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, nip);	
			st.setString(2, nama);
			st.setString(3, kdskpd);
			st.setString(4, KdSatker);
			st.setInt(5, nourt);
			st.setDouble(6, th_pajak);
			st.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMenghapusTabelFSpt(String query, String nip){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setString(1, nip);
			st.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMerubahTabelFSpt(String query,int nourt, String nip){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1,nourt);
			st.setString(2,nip);
			st.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMencariKodeTransTabelFSpt(String query, String nip){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1,nip);			
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
//-----------------------------------------------------------------------------------------------------------------	
	
	public JSONArray getMenampilkanTabelFSpt(){
		try
		{
			String query = querySelectData;
			return queryMenampilkanTabelFSpt(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenambahkanTabelFSpt(String nip,String nama, String kdskpd, String KdSatker, int nourt, double th_pajak){
		try
		{
			String query = queryInsertData;
			return queryMenambahkanTabelFSpt(query, nip, nama, kdskpd, KdSatker, nourt, th_pajak);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenghapusTabelFSpt(String nip){
		try
		{
			String query = queryDeleteDataBerdasarkanNip;
			return queryMenghapusTabelFSpt(query, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMerubahTabelFSpt(int nourt, String nip){
		try
		{
			String query = queryUpdateBerdasarkanNip;
			return queryMerubahTabelFSpt(query, nourt, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMencariTabelFSpt(String nip){
		try
		{
			String query = querySearchBerdasarkanNip;
			return queryMencariKodeTransTabelFSpt(query, nip);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
