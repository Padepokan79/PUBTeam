package com.padepokan79.model;

public interface MdTaperumTbl {
	public final String insertDataTaperum_tbl = 
			"insert into taperum_tbl values (?,?);";
	public final String updateDataTaperum_tbl = 
			"update taperum_tbl set nilai=? where kdgol=?;";
	public final String searchDataTaperum_tbl = 
			"select kdgol,nilai from taperum_tbl where kdgol=?;";
	public final String deleteDataTaperum_tbl = 
			"delete from taperum_tbl where kdgol=?;";
	public final String SelectDataTaperum_tbl =
			"select kdgol,nilai from taperum_tbl  ;";
}
