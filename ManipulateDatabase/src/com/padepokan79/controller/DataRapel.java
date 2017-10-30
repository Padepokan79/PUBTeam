package com.padepokan79.controller;

import java.sql.DriverManager;

import org.json.JSONArray;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.ListQuery;
import com.padepokan79.util.DatabaseConnection;

public class DataRapel extends DatabaseConnection implements ListQuery{
	

	public DataRapel() {
		
	}

	public JSONArray queryGroupByGapokPNS(String query, int gapok){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, gapok);	
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryGroupByGapokPNS(int gapok){
		try
		{
			String query = queryGroupByGapokPNS;
			return queryGroupByGapokPNS(query, gapok);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray simpleQuery(String query){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);	
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryGroupKodeSatuanKerjaNamaSatuanKerjaDanJumlahPNSNya(){
		try
		{
			String query = queryGroupKodeSatuanKerjaNamaSatuanKerjaDanJumlahPNSNya;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMenampilkanDataYangDibayarkanSatuBulanSetelahDataAwal(String query, String tglAwal, String tglAkhir, int nextPage){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, tglAwal);
			st.setString(2, tglAkhir);
			st.setInt(3, nextPage);
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryMenampilkanDataYangDibayarkanSatuBulanSetelahDataAwal(String tglAwal, String tglAkhir, int nextPage){
		try
		{
			String query = queryMenampilkanDataYangDibayarkanSatuBulanSetelahDataAwal;
			return queryMenampilkanDataYangDibayarkanSatuBulanSetelahDataAwal(query, tglAwal, tglAkhir, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMenampilkanDataNamaYangHurufAwalADanPangkat3D(String query, String hurufAwal, String kodePangkat, int nextPage){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, hurufAwal);
			st.setString(2, kodePangkat);
			st.setInt(3, nextPage);
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryMenampilkanDataNamaYangHurufAwalADanPangkat3D(String hurufAwal, String kodePangkat, int nextPage){
		try
		{
			String query = queryMenampilkanDataNamaYangHurufAwalADanPangkat3D;
			return queryMenampilkanDataNamaYangHurufAwalADanPangkat3D(query, hurufAwal, kodePangkat, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getQueryMenampilkanPNSyangJenisKElaminNULLdanBukanPriadaWanita(){
		try
		{
			String query = queryGroupKodeSatuanKerjaNamaSatuanKerjaDanJumlahPNSNya;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}