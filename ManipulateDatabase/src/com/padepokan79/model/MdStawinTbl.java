package com.padepokan79.model;

public interface MdStawinTbl {
	public final String queryInsertStawinTbl = 
			"insert into stawin_tbl (kdstawin, nmstawin) values (?, ?);";
	
	public final String querySelectAllStawinTbl =
			"select * from stawin_tbl;";
	
	public final String queryMencariStawinTbl =
			"select * from stawin_tbl where nmstawin=?;";
	
	public final String queryUpdateStawinTbl =
			"update stawin_tbl set nmstawin=? where kdstawin=?;";
	
	public final String queryDeleteStawinTbl =
			"delete from stawin_tbl where kdstawin=?;";
}
