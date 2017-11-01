package com.padepokan79.model;

public interface MdHutangTbl {
	public final String insertDataHutang_tbl = 
			"insert into hutang_tbl values (?,?);";
	public final String updateDataHutang_tbl = 
			"update hutang_tbl set nmhutang=? where kdhutang=?;";
	public final String searchDataHutang_tbl = 
			"select * from hutang_tbl where kdhutang=?;";
	public final String deleteDataHutang_tbl = 
			"delete from hutang_tbl where kdhutang=?;";
	public final String SelectDataHutang_tbl =
			"select * from hutang_tbl ;";
}
