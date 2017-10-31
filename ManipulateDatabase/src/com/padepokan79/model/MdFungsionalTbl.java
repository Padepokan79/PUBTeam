package com.padepokan79.model;

public interface MdFungsionalTbl {
	public final String tampilDataFungsional = 
			"SELECT kdfungsi, nm_fungsi from fungsional_tbl LIMIT 0,10;";
	public final String cariNamaFungsional =
			"SELECT kdfungsi, nm_fungsi from fungsional_tbl where kdfungsi=? LIMIT 0,10;";
	public final String tambahDataFungsional = 
			"INSERT INTO fungsional_tbl VALUES(?,?,?,?);";
	public final String ubahDataFungsional =
			"UPDATE fungsional_tbl set nm_fungsi=? where kdfungsi=?;";
	public final String hapusDataFungsional = 
			"DELETE FROM fungsional_tbl WHERE kdfungsi=?;";
}
