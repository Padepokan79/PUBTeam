package com.padepokan79.model;

public interface MdGuruTbl {
	public final String queryInsertGuruTbl = 
			"insert into guru_tbl values (?, ?, ?, ?);";
	
	public final String queryUpdateGuruTbl = 
			"update guru_tbl set tjguru=? where kdguru=?;";
	
	public final String queryDeleteGuruTbl = 
			"delete from guru_tbl where kdguru=?;";
	
	public final String queryReadGuruTbl = 
			"select *from guru_tbl limit 0,10;";
	
	public final String querySearchGuruTbl = 
			"select *from guru_tbl where kdguru=?;";
}
