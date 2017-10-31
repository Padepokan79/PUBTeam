package com.padepokan79.model;

public interface MdDokumenQuery {
	public final String viewTable = 
	"select kddokumen,nmdokumen from dokumen_tbl  limit 10";
	public final String selectTable = 
	"select kddokumen, nmdokumen from dokumen_tbl where kddokumen = ? ";
	public final String insertTable =
	"insert into dokumen_tbl values (?,?);";
	public final String updateTable =
	"update dokumen_tbl set nmdokumen = ? where kddokumen = ?";
	public final String deleteTable =
	"delete from dokumen_tbl where kddokumen =?";
}
