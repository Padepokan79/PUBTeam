package com.padepokan79.model;

public interface MdCabangTbl {
	public final String menambahkanDataCabangTbl =
			"INSERT INTO cabang_tbl VALUE(?,?,?);";
	public final String menampilkanSemuaDataCabangTbl =
			"SELECT * FROM cabang_tbl;";
	public final String menampilkanDataCabangTbl =
			"SELECT KDCABANG, NMCABANG, NICKCABANG FROM cabang_tbl WHERE kdcabang=?;";
	public final String mengubahNickcabangTbl =
			"UPDATE cabang_tbl SET nmcabang=?, nickcabang=? WHERE kdcabang=?;";
	public final String menghapusDataCabangTbl =
			"DELETE FROM cabang_tbl WHERE kdcabang=?;";
}
