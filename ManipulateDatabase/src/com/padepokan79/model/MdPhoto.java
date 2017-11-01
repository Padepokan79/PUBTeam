package com.padepokan79.model;
//by ILFA SRI DESY
public interface MdPhoto {
	public final String queryInsertPhoto = 
			"insert into photo (nip, gambar) values (?, ?);";
	
	public final String querySelectAllPhoto =
			"select * from photo limit 0,10;";
	
	public final String queryMencariPhoto =
			"select * from photo where nip=?;";
	
	public final String queryUpdatePhoto =
			"update photo set gambar=? where nip=?;";
	
	public final String queryDeletePhoto =
			"delete from photo where nip=?;";
}
