package com.padepokan79.controller;

import java.sql.PreparedStatement;

import org.json.JSONArray;

import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdHistorisGapok;
import com.padepokan79.util.DatabaseConnection;

public class MdHistorisGapokController extends DatabaseConnection implements MdHistorisGapok{
	public MdHistorisGapokController() {
		
	}
	public JSONArray queryMenghapusHistorisGapok(String query, String TMTGAJI,String NIP){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setString(1, TMTGAJI);
			st.setString(2, NIP);
			
			st.executeUpdate();
			
//			ResultSet rs = (ResultSet) st.executeQuery();
//			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMenambahkanHistorisGapok(String query,  String TMTGAJI,String NIP, int kdstapeg,String KDPANGKAT,int GAPOK,int MASKER,int PRSNGAPOK,
			String TMTTABEL,String TGLSKEP,String NOMORSKEP,String PENERBITSKEP,String tmt,String KETERNAGAN,String TGLUPDATE){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			
			st.setString(1, TMTGAJI);
			st.setString(2, NIP);
			st.setInt(3, kdstapeg);
			st.setString(4, KDPANGKAT);
			st.setInt(5, GAPOK);
			st.setInt(6, MASKER);
			st.setInt(7, PRSNGAPOK);
			st.setString(8, TMTTABEL);
			st.setString(9, TGLSKEP);
			st.setString(10, NOMORSKEP);
			st.setString(11, PENERBITSKEP);
			st.setString(12, tmt);
			st.setString(13, KETERNAGAN);
			st.setString(14, TGLUPDATE);
			
			
			st.executeUpdate();
			
//			ResultSet rs = (ResultSet) st.executeQuery();
//			return Convertor.convertToJSON(rs);

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public JSONArray queryMengeditHistorisGapok(String query, String TMTGAJI,String NIP,int GAPOK){
		try
		{

			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			st.setInt(1, GAPOK);
			st.setString(2, TMTGAJI);
			st.setString(3, NIP);
			
			st.executeUpdate();
			

		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray queryMencariHistorisGapok(String query, String inputKode){
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
	
	public JSONArray queryMenampilkanHistorisGapok(String query){
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
	public JSONArray getMenambahHistorisGapok(String TMTGAJI,String NIP, int kdstapeg,String KDPANGKAT,int GAPOK,int MASKER,int PRSNGAPOK,
			String TMTTABEL,String TGLSKEP,String NOMORSKEP,String PENERBITSKEP,String tmt,String KETERNAGAN,String TGLUPDATE){
		try
		{
			String query = nambahHistorisGapok;
			return queryMenambahkanHistorisGapok(query,TMTGAJI, NIP,  kdstapeg, KDPANGKAT, GAPOK, MASKER, PRSNGAPOK,
					 TMTTABEL, TGLSKEP, NOMORSKEP, PENERBITSKEP, tmt, KETERNAGAN, TGLUPDATE);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMencariHistorisGapok(String inputKode){
		try
		{
			String query = mencariHistorisGapok;
			return queryMencariHistorisGapok(query, inputKode);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenampilkanTabelHistorisGapok(){
		try
		{
			String query = nampilinHistorisGapok;
			return queryMenampilkanHistorisGapok(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMengeditHistorisGapok( String TMTGAJI,String NIP,int GAPOK){
		try
		{
			String query = ubahHistorisgapok;
			return queryMengeditHistorisGapok(query,TMTGAJI, NIP, GAPOK);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getMenghapusHistorisGapok(String TMTGAJI,String NIP){
		try
		{
			String query = hapusHistorisGapok;
			return queryMenghapusHistorisGapok(query,  TMTGAJI, NIP);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


}
