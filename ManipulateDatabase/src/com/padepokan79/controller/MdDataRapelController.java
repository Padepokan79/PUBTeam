package com.padepokan79.controller;

import java.sql.PreparedStatement;

import org.json.JSONArray;

import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdDataRapel;
import com.padepokan79.util.DatabaseConnection;

public class MdDataRapelController extends DatabaseConnection implements MdDataRapel{
	public MdDataRapelController() {
		
	}
	public JSONArray queryMenghapusDataRapel(String query, String NIP){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, NIP);

			
			st.executeUpdate();
			
//			ResultSet rs = (ResultSet) st.executeQuery();
//			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMenambahkanDataRapel(String query,  String KDSATKER,String NAMASATKER, String NIP,String NAMA,int KDJENKEL){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			
			st.setString(1, KDSATKER);
			st.setString(2, NAMASATKER);
			st.setString(3, NIP);
			st.setString(4, NAMA);
			st.setInt(5, KDJENKEL);
			
			st.executeUpdate();
			
//			ResultSet rs = (ResultSet) st.executeQuery();
//			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMengeditDataRapel(String query, String NAMA,int JANAK){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, JANAK);
			st.setString(2, NAMA);
			
			st.executeUpdate();
			

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMencariDataRapel(String query, String inputKode){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, inputKode);
			
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMenampilkanDataRapel(String query){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
//			st.setInt(1, inputKode);
			
			ResultSet rs = (ResultSet) st.executeQuery();
			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenambahDataRapel(String KDSATKER,String NAMASATKER, String NIP,String NAMA,int KDJENKEL){
		try
		{
			String query = nambahinDataRapel;
			return queryMenambahkanDataRapel(query,KDSATKER,NAMASATKER,NIP,NAMA,KDJENKEL);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMencariDataRapel(String inputKode){
		try
		{
			String query = mencariDataRapel;
			return queryMencariDataRapel(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenampilkanTabelDataRapel(){
		try
		{
			String query = nampilinDataRapel;
			return queryMenampilkanDataRapel(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMengeditDataRapel( String NAMA,int JANAK){
		try
		{
			String query = mengeditDataRapel;
			return queryMengeditDataRapel(query,NAMA, JANAK);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenghapusDataRapel(String NIP){
		try
		{
			String query = hapusDataRapel;
			return queryMenghapusDataRapel(query, NIP);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}


