package com.padepokan79.controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.UpdatableResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdFileBln;
import com.padepokan79.util.DatabaseConnection;

public class MdFileBlnController extends DatabaseConnection implements MdFileBln {
	public MdFileBlnController() {}
	public JSONArray queryMenghapusBulan(String query, int inputKode){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, inputKode);

			
			st.executeUpdate();
			
//			ResultSet rs = (ResultSet) st.executeQuery();
//			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMenambahkanBulan(String query, int inputKode, int a, int b, int c, String namaBulan){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, inputKode);
			st.setInt(2,a );
			st.setInt(3, b);
			st.setInt(4, c);
			st.setString(5, namaBulan);
			
			st.executeUpdate();
			
//			ResultSet rs = (ResultSet) st.executeQuery();
//			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMengeditBulan(String query, String namaBulan, int inputKode){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, namaBulan);
			st.setInt(2, inputKode);
			
			st.executeUpdate();
			

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray mencariBulan (String query, int bln) throws SQLException {
		PreparedStatement st = null; 
		try
		{
			st = (PreparedStatement) conn.prepareStatement(query);
			
			st.setInt(1, bln);
			
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result=Convertor.convertToJSON(rs);
			//rs=null;
		
			if(st!=null) {
				st.close();
			}
			
		return result;
		}catch(Exception e){
			
		}
		return null;
	}

	
	public JSONArray queryMenampilkanTabelBulan(String query) throws SQLException{
PreparedStatement st = null;
		
		try
		{
			st=(PreparedStatement) conn.prepareStatement(query);
			// execute the query, and get a java resultset
			//for insert, update, delete
			//st.executeUpdate();
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result=Convertor.convertToJSON(rs);
			//rs=null;
		
			if(st!=null) {
				st.close();
			}
			
		return result;
		}catch(Exception e){
			
		}
		return null;
	}
	public JSONArray getMenambahBulan(int inputKode, int a, int b, int c, String namaBulan){
		try
		{
			String query = menambahkanDataBulan;
			return queryMenambahkanBulan(query, inputKode, a, b, c,  namaBulan);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
//	public JSONArray getMencariBUlan(int inputKode){
//		try
//		{
//			String query = mencariBulan;
//			return mencariBulan(query, inputKode);
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//		return null;
//	}
	public JSONArray getMenampilkanTabelBulan(){
		try
		{
			String query = menampilkanBulan;
			return queryMenampilkanTabelBulan(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMengeditBulan(String namaBulan, int inputKode){
		try
		{
			String query = mengubahDataBln;
			return queryMengeditBulan(query, namaBulan, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenghapusBulan(int inputKode){
		try
		{
			String query = menghapusDataBln;
			return queryMenghapusBulan(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


	
	public JSONArray getmencariBulan (int bln){
		try
		{
			String query = mencariBulan;
			return mencariBulan(query, bln);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
