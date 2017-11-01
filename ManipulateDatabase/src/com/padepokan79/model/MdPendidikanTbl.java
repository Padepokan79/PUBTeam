package com.padepokan79.model;

public interface MdPendidikanTbl {
	public final String queryInsertPendidikanTbl = 
			"insert into pendidikan_tbl values (?, ?, ?);";
	
	public final String queryUpdatePendidikanTbl = 
			"update pendidikan_tbl set pendidikan=? where jnsdidik=? and kddidik=?;";
	
	public final String queryDeletePendidikanTbl = 
			"delete from pendidikan_tbl where jnsdidik=? and pendidikan=?;";
	
	public final String queryReadPendidikanTbl = 
			"select *from pendidikan_tbl limit 0,10;";
	
	public final String querySearchPendidikanTbl = 
			"select *from pendidikan_tbl where jnsdidik=? and kddidik=?;";
}
