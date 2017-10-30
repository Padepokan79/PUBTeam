package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.ListQuery;
import com.padepokan79.util.DatabaseConnection;

public class DetilKekurangan extends DatabaseConnection implements ListQuery {

	public DetilKekurangan() {

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
	
	public JSONArray queryMenampikanMaskerDibawah5TahunDanGajiDiatas25jt(String query,
			int inputMasaKerja, int inputGapok){	
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, inputMasaKerja);
			st.setInt(2, inputGapok);

			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();

			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray queryMenampilkanDaftarTanggalBayarberdasarkanInput(String query, 
			String inputTanggalDari, String inputTanggalSampai, int nextPage){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, inputTanggalDari);
			st.setString(2, inputTanggalSampai);
			st.setInt(3, nextPage);

			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();

			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray queryMencariKodePangkatdanMengurutkanUPDSTAMP(String query, String inputKodePangkat, int nextPage){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, inputKodePangkat);
			st.setInt(2, nextPage);

			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();

			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray getQueryMenampikanMaskerDibawah5TahunDanGajiDiatas25jt(int inputMasaKerja, int inputGapok){
		try
		{
			String query = queryMenampikanMaskerDibawah5TahunDanGajiDiatas25jt;
			return queryMenampikanMaskerDibawah5TahunDanGajiDiatas25jt(query, inputMasaKerja, inputGapok);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray getQueryMenampilkanJenisKekuranganYangLebihDariSatu(){
		try
		{
			String query = queryMenampilkanJenisKekuranganYangLebihDariSatu;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray getQueryJumlahPNSBerdasarkanGolonganJumlahAnakJumlahIstri(){
		try
		{
			String query = queryJumlahPNSBerdasarkanGolonganJumlahAnakJumlahIstri;
			return simpleQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray getQueryMenampilkanDaftarTanggalBayarberdasarkanInput(String inputTanggalDari,
			String inputTanggalSampai, int nextPage){
		try
		{
			String query = queryMenampilkanDaftarTanggalBayarberdasarkanInput;
			return queryMenampilkanDaftarTanggalBayarberdasarkanInput(query, inputTanggalDari, inputTanggalSampai, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray getQueryMencariKodePangkatdanMengurutkanUPDSTAMP(String inputKodePangkat, int nextPage){
		try
		{
			String query = queryMencariKodePangkatdanMengurutkanUPDSTAMP;
			return queryMencariKodePangkatdanMengurutkanUPDSTAMP(query, inputKodePangkat, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
