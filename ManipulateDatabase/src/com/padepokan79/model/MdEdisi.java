package com.padepokan79.model;

public interface MdEdisi {
	public final String tampilDataMdEdisi = 
			"SELECT TGLEDISI, KETERANGAN FROM edisi LIMIT 0,10;";
	public final String tambahDataMdEdisi =
			"INSERT INTO edisi VALUES(?,?,?);";
	public final String cariDataMdEdisi =
			"SELECT TGLEDISI, KETERANGAN FROM edisi where TGLEDISI=? LIMIT 0,10;";
	public final String ubahDataMdEdisi =
			"UPDATE edisi set keterangan=? where tgledisi=?;";
	public final String hapusDataMdEdisi =
			"DELETE FROM edisi where TGLEDISI=?;";
}
