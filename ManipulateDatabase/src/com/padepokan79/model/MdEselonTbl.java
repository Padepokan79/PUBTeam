package com.padepokan79.model;

public interface MdEselonTbl {
	public final String insertDataEselon_tbl = 
			"insert into eselon_tbl values (?,?,?,?, ?);";
	public final String updateDataEselon_tbl = 
			"update eselon_tbl set rp_eselon=? where kdeselon=?;";
	public final String searchDataEselon_tbl = 
			"select * from eselon_tbl where kdeselon=?;";
	public final String deleteDataEselon_tbl = 
			"delete from eselon_tbl where kdeselon=?;";
	public final String SelectDataEselon_tbl =
			"select TMTESELON,KDESELON,RP_ESELON from eselon_tbl ;";
}
