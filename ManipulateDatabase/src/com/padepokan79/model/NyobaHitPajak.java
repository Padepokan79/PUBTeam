package com.padepokan79.model;

import java.sql.DriverManager;

import org.json.JSONArray;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.ListQuery;

public class NyobaHitPajak implements ListQuery{

	String myDriver = "org.gjt.mm.mysql.Driver";
	String myUrl = "jdbc:mysql://127.0.0.1:3306/nyoba";
	Connection conn = null;
	int menuOn = 0;
	int menuOn2 =0;
	public NyobaHitPajak() {
		try
		{
			Class.forName(myDriver);
			// create our mysql database connection
			conn = (Connection) 
					DriverManager.getConnection(
							myUrl, "root", "");

		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

	public JSONArray simpleQuery(String query, int inputKode, int inputkode2){
		try
		{
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				st.setInt(1, inputKode);
				st.setInt(2, inputkode2);
			
			// execute the query, and get a java resultset
			ResultSet rs = (ResultSet) st.executeQuery();

			//System.out.println("------ ------ ------ ----- -----");
			return Convertor.convertToJSON(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public JSONArray getHitPajak(int KodeInput, int nextPage){
		try
		{
//			menuOn = input;
//			menuOn2 = input2;
			String query = "select nip, thp, kotorinduk, subkotor, istri, anak from hit_pajak where istri =? and anak =?;";
			return simpleQuery(query, KodeInput, nextPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}