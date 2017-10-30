package com.padepokan79.controller;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.ListQuery;
import com.padepokan79.util.DatabaseConnection;

public class HistorisEselon extends DatabaseConnection implements ListQuery{

	public HistorisEselon() {

	}

	public JSONArray queryMenampilkanRatarataTunjanganEselon(String query){
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

	public JSONArray queryMenampilkanDaftarPNSYangMempunyaiKodeEselonBersuratKeputusan(String query, int nextPage){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, nextPage);
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray queryTJEselonYangNolBukanNull(String query, int nextPage){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);			
			st.setInt(1, nextPage);
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray queryMenampilkanJumlahPNSyangMempunyaiTunjanganEselonberdasrakanInputanBatasKecildanBatasBesar(String query,
			int inputTunjanganEselonAwal, int inputTunjanganEselonAkhir, int nextPage){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, inputTunjanganEselonAwal);
			st.setInt(2, inputTunjanganEselonAkhir);
			st.setInt(3, nextPage);
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray queryMenampilkanHistorisSkep(String query, int nextPage){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, nextPage);
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray getQueryMenampilkanRatarataTunjanganEselon(){
		try
		{
			String query = queryMenampilkanRatarataTunjanganEselon;
			return queryMenampilkanRatarataTunjanganEselon(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray getQueryMenampilkanDaftarPNSYangMempunyaiKodeEselonBersuratKeputusan(int nextPage){
		try
		{
			String query = queryMenampilkanDaftarPNSYangMempunyaiKodeEselonBersuratKeputusan;
			return queryMenampilkanDaftarPNSYangMempunyaiKodeEselonBersuratKeputusan(query, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray getQueryTJEselonYangNolBukanNull(int nextPage){
		try
		{
			String query = queryTJEselonYangNolBukanNull;
			return queryTJEselonYangNolBukanNull(query, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getQueryMenampilkanJumlahPNSyangMempunyaiTunjanganEselonberdasrakanInputanBatasKecildanBatasBesar(
			int inputTunjanganEselonAwal, int inputTunjanganEselonAkhir, int nextPage){
		try
		{
			String query = queryMenampilkanJumlahPNSyangMempunyaiTunjanganEselonberdasrakanInputanBatasKecildanBatasBesar;
			return queryMenampilkanJumlahPNSyangMempunyaiTunjanganEselonberdasrakanInputanBatasKecildanBatasBesar(query,
					inputTunjanganEselonAwal, inputTunjanganEselonAkhir, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray getQueryMenampilkanHistorisSkep(int nextPage){
		try
		{
			String query = queryMenampilkanHistorisSkep;
			return queryMenampilkanHistorisSkep(query, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}