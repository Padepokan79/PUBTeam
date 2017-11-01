package com.padepokan79.model;

public interface MdTp {
	public final String queryMenampilkanData = 
			"select * from tp_tbl";
	public final String queryMencariData = 
			"select * from tp_tbl where kode_tp = ?";
	public final String queryMenambahData = 
			"insert into tp_tbl values(?,?,?,?);";
	public final String queryMengubahData = 
			"update tp_tbl set ket = ? where kode_tp = ?;";
	public final String queryMenghapusData = 
			"delete from tp_tbl where kode_tp = ?;";
}
