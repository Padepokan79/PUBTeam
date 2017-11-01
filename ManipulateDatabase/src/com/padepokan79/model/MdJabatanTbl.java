package com.padepokan79.model;

public interface MdJabatanTbl {
	public final String menampilkanJabatan =
		"select kdjabatan, nmjabatan from jabatan_tbl ;";
	public final String mencariData =
		"select kdjabatan, nmjabatan from jabatan_tbl where kdjabatan = ? ;";
	public final String menambahData = 
		"insert into jabatan_tbl values (?, ?, ?, ?, ?, ?, ?);";
	public final String mengubahJabatan =
		"update jabatan_tbl set nmjabatan = ? where kdjabatan = ?;";
	public final String menghapusData =
		"delete from jabatan_tbl where kdjabatan = ?;";
		
}
