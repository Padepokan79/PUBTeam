package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdDokumenQuery;
import com.padepokan79.util.DatabaseConnection;

public class MdDokumenController extends DatabaseConnection implements MdDokumenQuery{
	
public JSONArray deleteQuery(String query, String kddokumen) throws SQLException{
	PreparedStatement st = null;
	conn.prepareStatement(query);
	try
	{
		st.setString(1, kddokumen);
		st.executeUpdate();

	}catch (Exception e) {
		// TODO: handle exception
	}finally {
		if (st!=null){
			st.close();
		}
		if (conn!=null){
			conn.close();
		}
	}
	return null;
}
public JSONArray queryAdd(String query, String kddokumen, String nmdokumen) throws SQLException{
	PreparedStatement st = (PreparedStatement)
	conn.prepareStatement(query);
	try
	{
		st.setString(1, kddokumen);
		st.setString(2, nmdokumen);
		st.executeUpdate();
		
		if (st!=null){
			st.close();
		}
	}catch (Exception e) {
		// TODO: handle exception
	}
	return null;
}

public JSONArray EditQuery(String query, String kddokumen,String nmdokumen)  throws SQLException{
	PreparedStatement st = null;
	conn.prepareStatement(query);
	try
	{
		st.setString(2, nmdokumen);
		st.setString(1, kddokumen);
		
		st.executeUpdate();
		
		if (st!=null){
			st.close();
		}
	}catch (Exception e) {
		// TODO: handle exception
	} 
	return null;
}
public JSONArray SearchQuery(String query, String kddokumen) throws SQLException{
	PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);

	try
	{
		//System.out.println(st + kddokumen);
		st.setString(1, kddokumen);
		ResultSet rs = (ResultSet) st.executeQuery();
		//System.out.print(rs);
		if (st!=null){
			st.close();
		}
		
		return Convertor.convertToJSON(rs);
		
	}catch (Exception e) {
		// TODO: handle exception
	}
	return null;
}

public JSONArray viewQuery(String query) throws SQLException{
	
	try
	{
		PreparedStatement st = (PreparedStatement)conn.prepareStatement(query);
		ResultSet rs = (ResultSet) st.executeQuery();
		JSONArray result = Convertor.convertToJSON(rs);
		if (st!=null){
			st.close();
		}
		return result;

	}catch (Exception e) {
		// TODO: handle exception
	} 
	return null;
}
public JSONArray geInsertTable(String kddokumen, String nmdokumen) throws SQLException{
	try
	{
		String query = insertTable;
		return queryAdd(query, kddokumen, nmdokumen);
	}catch (Exception e) {
		// TODO: handle exception
	} 
	return null;
}
public JSONArray getSelectTable(String kddokumen){
	//System.out.print(Kode);
	try
	{
		String query = selectTable;
		System.out.print(query);
		return SearchQuery(query, kddokumen);
	}catch (Exception e) {
		// TODO: handle exception
	}
	return null;
}
public JSONArray getViewTable() throws SQLException{
	try
	{
		String query = viewTable;
		return viewQuery(query);
	}catch (Exception e) {
		// TODO: handle exception
	}
	return null;
}
public JSONArray getEditTable(String nmdokumen, String kddokumen) throws SQLException{
	try
	{
		String query = updateTable;
		return EditQuery(query, nmdokumen, kddokumen);
	}catch (Exception e) {
		// TODO: handle exception
	}
	return null;
}
public JSONArray getDeleteTable(String kddokumen) throws SQLException{
	try
	{
		String query = deleteTable;
		return deleteQuery(query, kddokumen);
	}catch (Exception e) {
		// TODO: handle exception
	}
	return null;
}

}
