package com.padepokan79.model;

public interface MdTkdTbl {
	public final String queryInsertTkdTbl =
			"insert into tkd_tbl (TMT, KDTKD, NMTKD, TKD) values (?, ?, ?, ?);";
	
	public final String querySelectAllTkdTbl =
			"select * from tkd_tbl;";
	
	public final String queryMencariTkdTbl =
			"select * from tkd_tbl where NMTKD=?;";
	
	public final String queryUpdateTkdTbl =
			"update tkd_tbl set NMTKD=?, TKD=? where TMT=? and KDTKD=?;";
	
	public final String queryDeleteTkdTbl =
			"delete from tkd_tbl where TMT=? and KDTKD=?;";
}
