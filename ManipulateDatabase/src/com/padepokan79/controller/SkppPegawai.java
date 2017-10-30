package com.padepokan79.controller;

import java.sql.DriverManager;

import org.json.JSONArray;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.ListQuery;
import com.padepokan79.util.DatabaseConnection;

public class SkppPegawai extends DatabaseConnection implements ListQuery{
	
	public SkppPegawai() {
		
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
	
	public JSONArray getNamaPnsYangmempunyaiAnakTapiTidakMempunyaiIstri(){
		try
		{
			String query = queryNamaPnsYangmempunyaiAnakTapiTidakMempunyaiIstri;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getNamaPnsYangPensiunTahunIni(){
		try
		{
			String query = queryNamaPnsYangPensiunTahunIni;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getNamaPNSYangSkepnyaDiterbitkanOlehPresiden(){
		try
		{
			String query = queryNamaPNSYangSkepnyaDiterbitkanOlehPresiden;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getTampilkanJumlahSKPP_PNSberdasarkanKodePangkat(){
		try
		{
			String query = queryTampilkanJumlahSKPP_PNSberdasarkanKodePangkat;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getTampilkanJumlahSuratSKPPberdasarkanPenerbitnya(){
		try
		{
			String query = queryTampilkanJumlahSuratSKPPberdasarkanPenerbitnya;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}