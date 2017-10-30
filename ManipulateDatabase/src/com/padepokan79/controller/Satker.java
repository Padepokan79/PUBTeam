package com.padepokan79.controller;

import java.sql.DriverManager;

import org.json.JSONArray;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.ListQuery;
import com.padepokan79.util.DatabaseConnection;

public class Satker extends DatabaseConnection implements ListQuery{

	

	public Satker() {
		
	}

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
	public JSONArray getQueryNamaAtasanDRSDanJabatanCamat(){
		try
		{
			String query = queryNamaAtasanDRSDanJabatanCamat;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryKepalaDinasHaji(){
		try
		{
			String query = queryKepalaDinasHaji;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryBendaharaPembantuDaftarGaji(){
		try
		{
			String query = queryBendaharaPembantuDaftarGaji;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryNamaOperatorDenganAkhiranH(){
		try
		{
			String query = queryNamaOperatorDenganAkhiranH;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryJumlahPegawaiYangKerjaDiDinasKesehatan(){
		try
		{
			String query = queryJumlahPegawaiYangKerjaDiDinasKesehatan;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}