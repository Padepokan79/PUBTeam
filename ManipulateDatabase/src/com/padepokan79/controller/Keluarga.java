package com.padepokan79.controller;

import java.sql.DriverManager;

import org.json.JSONArray;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.ListQuery;
import com.padepokan79.util.DatabaseConnection;

public class Keluarga extends DatabaseConnection implements ListQuery{

	public Keluarga() {
		
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
	public JSONArray getQueryPNSJombloWafat(){
		try
		{
			String query = queryPNSJombloWafat;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryPNSUsiaPernikahanPerak25tahun(){
		try
		{
			String query = queryPNSUsiaPernikahanPerak25tahun;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryPNSjomblosejati(){
		try
		{
			String query = queryPNSjomblosejati;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryKeluargaPNSyangSudahMenikahDanMempunyaiKartuSuamiIstri(){
		try
		{
			String query = queryKeluargaPNSyangSudahMenikahDanMempunyaiKartuSuamiIstri;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryNamaKeluargaPNSyangPernahMenikahLaluCerai(){
		try
		{
			String query = queryNamaKeluargaPNSyangPernahMenikahLaluCerai;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}