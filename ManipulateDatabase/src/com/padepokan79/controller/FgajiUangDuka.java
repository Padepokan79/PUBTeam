package com.padepokan79.controller;

import java.sql.DriverManager;

import org.json.JSONArray;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.ListQuery;
import com.padepokan79.util.DatabaseConnection;

public class FgajiUangDuka extends DatabaseConnection implements ListQuery {
	
	public FgajiUangDuka() {
		
	}

	public JSONArray queryLamanyaUangDukaDibayar(String query, int inputLamaHari, int nextPage){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, inputLamaHari);
				st.setInt(2, nextPage);
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		}
	
	public JSONArray queryTglWafatDanBersih(String query, String inputTanggal, int inputBersih, int nextPage){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setString(1, inputTanggal);
				st.setInt(2, inputBersih);
				st.setInt(3, nextPage);	
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		}
	public JSONArray queryNamaPNSYangMeninggldariTunjanganAnakIstri(String query, int jmlIstri, int nextPage){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, jmlIstri);
				st.setInt(2, nextPage);	
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		}
	public JSONArray queryPnsLamanyaWafatdariIstridaniAnak(String query, String tanggal, int jmlIstri, int jmlAnak){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setString(1, tanggal);
				st.setInt(2, jmlIstri);
				st.setInt(3, jmlAnak);	
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		}
	public JSONArray queryJumlahPNSYangTidakMempunyaiTunjanganEselonDanTunjanganFungsi(String query, int nextPage){
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
	
	public JSONArray getNamaPNSyangMeninggaldanUangDukaDibayarSetelah1MingguSesudahWafat(int inputLamaHari, int nextPage){
		try
		{
			String query = queryNamaPNSyangMeninggaldanUangDukaDibayarSetelah1MingguSesudahWafat;
			return queryLamanyaUangDukaDibayar(query, inputLamaHari, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null; 
	}
	
	public JSONArray getTGLWafatDanUangBersihLebihDari1Jt(String inputTanggal, int inputBersih, int nextPage){
		try
		{
			String query = queryTGLWafatDanUangBersihLebihDari1Jt;
			return queryTglWafatDanBersih(query, inputTanggal, inputBersih, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getNamaPNSYangMeningglTanpaTunjanganAnakIstri(int jmlIstri, int nextPage){
		try
		{
			String query = queryNamaPNSYangMeningglTanpaTunjanganAnakIstri;
			return queryNamaPNSYangMeninggldariTunjanganAnakIstri(query, jmlIstri, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getPNSLamanyaWafatdariIstridaniAnak(String tanggal, int jmlIstri, int jmlAnak){
		try
		{
			String query = queryPnsWafatLebihdar4thnYangmempunyaiIstriTidakMempunyaiAnak;
			return queryPnsLamanyaWafatdariIstridaniAnak(query, tanggal, jmlIstri, jmlAnak);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getJumlahPNSYangTidakMempunyaiTunjanganEselonDanTunjanganFungsi(int nextPage){
		try
		{
			String query = queryJumlahPNSYangTidakMempunyaiTunjanganEselonDanTunjanganFungsi;
			return queryJumlahPNSYangTidakMempunyaiTunjanganEselonDanTunjanganFungsi(query, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
