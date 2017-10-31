package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdRekapJkkjkm;
import com.padepokan79.util.DatabaseConnection;

public class MdRekapJkkjkmController extends DatabaseConnection implements MdRekapJkkjkm{

	public JSONArray readAllQuery(String query) throws SQLException{
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
	
	public JSONArray ReadAllDataRekapJkkjkm(){
		try
		{
			String query = SelectDataRekapJkkjkm;
			return readAllQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray searchQuery(String query, String KdJnsTrans  ) throws SQLException{
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setString(1, KdJnsTrans);
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
	public JSONArray searchDataRekapJkkjkm(String KdJnsTrans){
		try
		{
			String query = searchDataRekapJkkjkm;
			return searchQuery(query,KdJnsTrans);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray insertQuery(String query,String tglgaji, int KdJnsTrans,String kdskpd,String kdsatker,int gapok,
		int iuran_jkk,int iuran_jkm, String updstamp	) throws SQLException{
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setString(1, tglgaji);
					st.setInt(2, KdJnsTrans);
					st.setString(3, kdskpd);
					st.setString(4, kdsatker);
					st.setInt(5, gapok);
					st.setInt(6, iuran_jkk);
					st.setInt(7, iuran_jkm);
					st.setString(8, updstamp);
					st.executeUpdate();
				
					if(st!=null) {
						st.close();
					}
					
				return null;
				}catch(Exception e){
					
				}
				return null;
			
			}
	public JSONArray insertDataRekapJkkjkm(String tglgaji, int KdJnsTrans,String kdskpd,String kdsatker,int gapok,
			int iuran_jkk,int iuran_jkm, String updstamp){
		try
		{
			String query = insertDataRekapJkkjkm;
			return insertQuery(query, tglgaji, KdJnsTrans, kdskpd, kdsatker,gapok,
					 iuran_jkk,iuran_jkm, updstamp);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray updateQuery(String query,  int KdJnsTrans,String kdskpd  ) throws SQLException{
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setString(1, kdskpd);
					st.setInt(2, KdJnsTrans);
					st.executeUpdate();
					
				
					if(st!=null) {
						st.close();
					}
					
				return null;
				}catch(Exception e){
					
				}
				return null;
			
			}
	public JSONArray updateDataRekapJkkjkm(  String kdskpd,int KdJnsTrans){
		try
		{
			String query = updateDataRekapJkkjkm;
			return updateQuery(query,KdJnsTrans,kdskpd);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public JSONArray deleteQuery(String query,String KdJnsTrans  ) throws SQLException{
		PreparedStatement st = null;
				
				try
				{
					st=(PreparedStatement) conn.prepareStatement(query);
					st.setString(1, KdJnsTrans);
					// execute the query, and get a java resultset
					//for insert, update, delete
					//st.executeUpdate();
					//ResultSet rs = (ResultSet) st.executeQuery();
					st.executeUpdate();
					//JSONArray result=Convertor.convertToJSON(rs);
					//rs=null;
				
					if(st!=null) {
						st.close();
					}
					
				return null;
				}catch(Exception e){
					
				}
				return null;
			
			}
	public JSONArray deleteDataRekapjkkjkm( String KdJnsTrans){
		try
		{
			String query = deleteDataRekapJkkjkm;
			return deleteQuery(query,KdJnsTrans);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
