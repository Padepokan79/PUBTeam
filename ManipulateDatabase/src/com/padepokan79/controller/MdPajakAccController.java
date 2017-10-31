package com.padepokan79.controller;

import java.sql.PreparedStatement;

import org.json.JSONArray;

import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdPajakAcc;
import com.padepokan79.util.DatabaseConnection;

public class MdPajakAccController extends DatabaseConnection implements MdPajakAcc{
	public MdPajakAccController() {
		
	}
	public JSONArray queryMenghapusPajakAcc(String query, String kdcabang,String kdssbp){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, kdcabang);
			st.setString(2, kdssbp);
			
			st.executeUpdate();
			
//			ResultSet rs = (ResultSet) st.executeQuery();
//			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMenambahkanPajakAcc(String query,  String kdcabang,String kdssbp, String tgl_srt,String no_srt){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			
			st.setString(1, kdcabang);
			st.setString(2, kdssbp);
			st.setString(3, tgl_srt);
			st.setString(4, no_srt);
			
			
			st.executeUpdate();
			
//			ResultSet rs = (ResultSet) st.executeQuery();
//			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMengeditPajakAcc(String query, String tgl_srt,String no_srt){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, tgl_srt);
			st.setString(2, no_srt);
			
			st.executeUpdate();
			

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMencariPajakAcc(String query, String inputKode){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, inputKode);
			
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMenampilkanPajakAcc(String query){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
//			st.setInt(1, inputKode);
			
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenambahPajakAcc(String kdcabang,String kdssbp, String tgl_srt,String no_srt){
		try
		{
			String query = nambahPajakAcc;
			return queryMenambahkanPajakAcc(query,kdcabang,kdssbp, tgl_srt, no_srt);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMencariPajakAcc(String inputKode){
		try
		{
			String query = mencariPajakAcc;
			return queryMencariPajakAcc(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenampilkanTabelPajakAcc(){
		try
		{
			String query = nampilinPajakAcc;
			return queryMenampilkanPajakAcc(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMengeditPajakAcc( String tgl_srt,String no_srt){
		try
		{
			String query = ubahPajakAcc;
			return queryMengeditPajakAcc(query,tgl_srt, no_srt);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenghapusPajakAcc(String kdcabang,String kdssbp){
		try
		{
			String query = hapusPajakAcc;
			return queryMenghapusPajakAcc(query, kdcabang,kdssbp);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
