package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdSequenceTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdSequenceTblController extends DatabaseConnection implements MdSequenceTbl{
	public MdSequenceTblController(){
		
	}
	
	public JSONArray ReadData(String query) throws SQLException{
		PreparedStatement st =null;
		try {
			st=(PreparedStatement) conn.prepareStatement(query);
			
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result=Convertor.convertToJSON(rs);
			rs=null;
			if (st!=null) {
				st.close();
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getReadData() {
		try {
			String query = ReadData;
			return ReadData(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray SearchData(String query,int idnum) throws SQLException{
		PreparedStatement st =null;
		try {
			st=(PreparedStatement)  conn.prepareStatement(query);
			st.setInt(1,idnum);
			
			ResultSet rs = (ResultSet) st.executeQuery();
			JSONArray result=Convertor.convertToJSON(rs);
			rs=null;
			if (st!=null) {
				st.close();
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getSearchData(int idnum){
		try
		{
			String query = SearchData;
			return SearchData(query, idnum);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray UpdateData(String query,String ket,int idnum) throws SQLException {
		PreparedStatement st =null;
		try {
			st=(PreparedStatement)conn.prepareStatement(query);
			st.setString(1, ket);
			st.setInt(2, idnum);
			
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getUpdateData(String ket,int idnum){
		try
		{
			String query = UpdateData;
			return UpdateData(query,ket,idnum);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray CreateData(String query, int idnum, int seqnum,String cseqnum,String ket,int bulan,int tahun) throws SQLException{
		PreparedStatement st =null;
		try
		{
			st=(PreparedStatement)conn.prepareStatement(query);
			st.setInt(1, idnum);
			st.setInt(2, seqnum);
			st.setString(3, cseqnum);
			st.setString(4, ket);
			st.setInt(5, bulan);
			st.setInt(6, tahun);
			
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public JSONArray getCreateData(int idnum, int seqnum,String cseqnum,String ket,int bulan,int tahun){
		try
		{
			String query = CreateData;
			return CreateData(query, idnum, seqnum,cseqnum,ket,bulan,tahun);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray DeleteData(String query, int idnum)throws SQLException{
		PreparedStatement st =null;
		try
		{
			st=(PreparedStatement)conn.prepareStatement(query);
			st.setInt(1,idnum );
			
			st.executeUpdate();
			if (st!=null) {
				st.close();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray getDeleteData(int idnum){
		try
		{
			String query = DeleteData;
			return DeleteData(query, idnum);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
}
