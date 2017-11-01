package com.padepokan79.model;

public interface MdPangkatTbl {
	public final String queryInsertPangkatTbl = 
			"insert into pangkat_tbl values (?, ?, ?, ?);";
	
	public final String queryUpdatePangkatTbl = 
			"update pangkat_tbl set nmgol=? where kdpangkat=?;";
	
	public final String queryDeletePangkatTbl = 
			"delete from pangkat_tbl where kdPangkat=? and nmpangkat=?;";
	
	public final String queryReadPangkatTbl = 
			"select *from pangkat_tbl limit 0,10;";
	
	public final String querySearchPangkatTbl = 
			"select *from pangkat_tbl where kdpangkat=? and nmgol=?;";
}
