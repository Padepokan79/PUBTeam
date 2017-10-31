package com.padepokan79.model;

public interface MdGapokTbl {
	public final String menampilkanDataGapok =
		"select kdpangkat, nilai_bawah from gapok_tbl limit 0,10;";
	public final String mencariData = 
		"select kdpangkat, nilai_bawah from gapok_tbl where kdpangkat = ? ;";
	public final String menambahkanDataGapok =
		"insert into gapok_tbl values (?, ?, ?, ?, ?, ?);";
	public final String mengubahNilaiBawah = 
		"update gapok_tbl set nilai_bawah = ? where kdpangkat = ?;";
	public final String menghapusData =
		"delete from gapok_tbl where kdpangkat = ?;";
}
