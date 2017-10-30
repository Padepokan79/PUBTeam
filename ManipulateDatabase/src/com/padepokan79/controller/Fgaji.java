package com.padepokan79.controller;

import java.sql.DriverManager;

import org.json.JSONArray;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.ListQuery;
import com.padepokan79.util.DatabaseConnection;

public class Fgaji extends DatabaseConnection implements ListQuery{

	public Fgaji() {
		
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
	public JSONArray getNamaDanGajiBersih(){
		try
		{
			String query = "SELECT nama,bersih FROM fgaji limit 0 , 10;";
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray getNamaDanStatusKawin(){
		try
		{
			String query = queryNamaDanStatusKawin;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getNamaDanLakiJomblo(){
		try
		{
			//String query = queryNamaDanLakiJomblo;
			return simpleQuery(queryNamaDanLakiJomblo);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getNipNamaGajiBersihDiAtas10Jt() {
		try {
			String query = queryNipNamaGajiBersihDiAtas10Jt;
			return simpleQuery(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getNipNamaJombloMasaKerjaDiAtas10thn() {
		try {
			String query = queryJombloMasaKerjaDiatas10thn;
			return simpleQuery(query);
		} catch (Exception e) {
			// Add by Manto
		}
		return null;
	}
	public JSONArray getNamaJandaKembang() {
		try {
			//"SELECT nip,nama,kdstawin,janak FROM fgaji where kdstawin=3 and janak=0 limit 0,10;"
			String query = queryNamaJandaKembang;
			return simpleQuery(query);
		} catch (Exception e) {
			// Add by Hendra YN
		}
		return null;
	}
	public JSONArray getNamaSuperDad() {
		try {
			//"SELECT nip,nama,kdjenkel,tgllhr,kdpangkat,masker,janak FROM fgaji where kdjenkel = 1 and kdpangkat=1  and masker > 20 and janak > 1 limit 0,10;"
			String query = queryNamaSuperDad;
			return simpleQuery(query);
		} catch (Exception e) {
			// Add by Hendra YN
		}
		return null;
	}
	public JSONArray queryUsiaAntara25Sampai35() {
		try {
			//"SELECT nip, nama, bersih, kdpangkat, TGLLHR as usia from fgaji where kdstawin = '1' and TGLLHR <= '1992/09/14' and TGLLHR >= '1982/09/14' limit 0,10"
			String query = queryNamaUsiaAntara25Sampai35;
			return simpleQuery(query);
		} catch (Exception e) {
			// Add by Hendra YN
		}
		return null;
	}
	
	public JSONArray getNamaDanJomblo(int gender){
		try
		{
			String query = "SELECT getNamaDanJomblo FROM fgaji where kdjenkel=?  limit 0,10;";
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


}
