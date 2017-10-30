package com.padepokan79.controller;

import java.sql.DriverManager;

import org.json.JSONArray;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.ListQuery;
import com.padepokan79.util.DatabaseConnection;

public class Ttunjangan  extends DatabaseConnection implements ListQuery{
	public Ttunjangan() {
		
	}

	public JSONArray MenampilkanJumlahPNSYangPensiunBerdasarkanKodeJabatandanUsiaJabatan(String query, int nextPage){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, nextPage);
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();

			//System.out.println("------ ------ ------ ----- -----");
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray MenampilkanJumlahPNSYangPensiunBerdasarkanJumlahUangPensiun(String query, int jumlahAwal, int jumlahAkhir, int nextPage){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, jumlahAwal);
				st.setInt(2, jumlahAkhir);
				st.setInt(3, nextPage);
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray simpleQuery(String query){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();

			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenampilkanJumlahPNSYangPensiunBerdasarkanKodeJabatandanUsiaJabatan(int nextPage){
		try
		{
			String query = queryMenampilkanJumlahPNSYangPensiunBerdasarkanKodeJabatandanUsiaJabatan;
			return MenampilkanJumlahPNSYangPensiunBerdasarkanKodeJabatandanUsiaJabatan(query, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getqueryMenampilkanJumlahPNSYangPensiunBerdasarkanJumlahUangPensiun(int jumlahAwal, int jumlahAkhir, int nextPage){
		try
		{
			String query = queryMenampilkanJumlahPNSYangPensiunBerdasarkanJumlahUangPensiun;
			return MenampilkanJumlahPNSYangPensiunBerdasarkanJumlahUangPensiun(query, jumlahAwal, jumlahAkhir, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getqueryMenampilkanPNSyangPensiunKurangdariUsia60(){
		try
		{
			String query = queryMenampilkanPNSyangPensiunKurangdariUsia60;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}