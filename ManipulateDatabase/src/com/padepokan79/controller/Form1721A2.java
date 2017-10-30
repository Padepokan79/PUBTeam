package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.ListQuery;
import com.padepokan79.util.DatabaseConnection;

public class Form1721A2 extends DatabaseConnection implements ListQuery{

	public Form1721A2() {
		
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
	
	public JSONArray getqueryMencariTahunPajakdanJabatanGolongan(String query,
			int inputTahunPajak, int inputJabatanGolongan, int nextPage){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, inputTahunPajak);
				st.setInt(2, inputJabatanGolongan);
				st.setInt(3, nextPage);			
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMenampilkanStatusYangBelumBayarPajakDanLakiLaki(String query,
			int inputStatusPajak, int inputGender, int nextPage){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, inputStatusPajak);
				st.setInt(2, inputGender);
				st.setInt(3, nextPage);
		
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();

			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMenampilkanYangSudahAdaNPWP(String query, int nextPage){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, nextPage);
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();

			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMenampilkanStatusBerdasarkanGenderdanJumlahKeluarga(String query,
			int inputGender, int inputJumlahKeluarga, int nextPage){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, inputGender);
				st.setInt(2, inputJumlahKeluarga);
				st.setInt(3, nextPage);
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();

			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMencariTahunPajakdanJabatanGolongan(int inputTahunPajak, int inputJabatanGolongan, int nextPage){
		try
		{
			String query = queryMencariTahunPajakdanJabatanGolongan;
			return getqueryMencariTahunPajakdanJabatanGolongan(query, inputTahunPajak, inputJabatanGolongan, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenunjukanJumlahJabatanPNSyangsudahbayardanBelum(){
		try
		{
			String query = queryMenunjukanJumlahJabatanPNSyangsudahbayardanBelum;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenampilkanStatusYangBelumBayarPajakDanLakiLaki(int inputStatusPajak, int inputGender, int nextPage){
		try
		{
			String query = queryMenampilkanStatusYangBelumBayarPajakDanLakiLaki;
			return queryMenampilkanStatusYangBelumBayarPajakDanLakiLaki(query, inputStatusPajak, inputGender, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenampilkanYangSudahAdaNPWP(int nextPage){
		try
		{
			String query = queryMenampilkanYangSudahAdaNPWP;
			return queryMenampilkanYangSudahAdaNPWP(query, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenampilkanStatusBerdasarkanGenderdanJumlahKeluarga(int inputGender,
			int inputJumlahKeluarga, int nextPage){
		try
		{
			String query = queryMenampilkanStatusBerdasarkanGenderdanJumlahKeluarga;
			return queryMenampilkanStatusBerdasarkanGenderdanJumlahKeluarga(query, inputGender, inputJumlahKeluarga, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}