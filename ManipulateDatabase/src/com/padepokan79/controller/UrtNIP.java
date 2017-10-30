package com.padepokan79.controller;

import java.sql.DriverManager;

import org.json.JSONArray;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.ListQuery;
import com.padepokan79.util.DatabaseConnection;

public class UrtNIP extends DatabaseConnection implements ListQuery {

	public UrtNIP() {

	}

	public JSONArray queryMenampilkanPNSYangPunyaNPWPTempatLahirdanAgama(String query, int nextPage){
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
	public JSONArray getMenampilkanPNSYangPunyaNPWPTempatLahirdanAgama(int nextPage){
		try
		{		
			String query = queryMenampilkanPNSYangPunyaNPWPTempatLahirdanAgama;
			return queryMenampilkanPNSYangPunyaNPWPTempatLahirdanAgama(query, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray queryMenampilkanTempatLahirDiLimaPuluhDanJenisKelaminPerempuan(String query, String tempatLahir, String JenisKelamin, int nextPage){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);

			st.setString(1, tempatLahir);
			st.setString(2, JenisKelamin);	
			st.setInt(3, nextPage);	

			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();

			//System.out.println("------ ------ ------ ----- -----");
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenampilkanTempatLahirDiLimaPuluhDanJenisKelaminPerempuan(String tempatLahir, String JenisKelamin, int nextPage){
		try
		{
			String query = queryMenampilkanTempatLahirDiLimaPuluhDanJenisKelaminPerempuan;
			return queryMenampilkanTempatLahirDiLimaPuluhDanJenisKelaminPerempuan(query,tempatLahir,JenisKelamin,nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray queryMenampilkanPNSpunyaNPWPdanMasaKerjaLama(String query, int masaKerja, int nextPage){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, masaKerja);
			st.setInt(2, nextPage);		

			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();

			//System.out.println("------ ------ ------ ----- -----");
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenampilkanPNSpunyaNPWPdanMasaKerjaLama(int masaKerja, int nextPage){
		try
		{
			String query = queryMenampilkanPNSpunyaNPWPdanMasaKerjaLama;
			return queryMenampilkanPNSpunyaNPWPdanMasaKerjaLama(query, masaKerja, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray queryMenampilkanJumlahPNSberdasrkanAgamadanGolongan(String query, int nextPage){
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
	public JSONArray getMenampilkanJumlahPNSberdasrkanAgamadanGolongan(int nextPage){
		try
		{
			String query = queryMenampilkanJumlahPNSberdasrkanAgamadanGolongan;
			return queryMenampilkanJumlahPNSberdasrkanAgamadanGolongan(query,nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray queryMenampilkanGroupByAgama(String query, int nextPage){
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
	public JSONArray queryMenampilkanGroupByAgama(int nextPage){
		try
		{
			String query = queryMenampilkanGroupByAgama;
			return queryMenampilkanGroupByAgama(query, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
