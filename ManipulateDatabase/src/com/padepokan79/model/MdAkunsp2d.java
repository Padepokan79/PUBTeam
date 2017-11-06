package com.padepokan79.model;

public interface MdAkunsp2d {
	public final String menampilkanDataAkunsp2d =
			"select * from akunsp2d limit 10;";
	public final String menambahkanDataAkunsp2d =
			"insert into akunsp2d values (?,?,?,?,?);";
	public final String mengubahNmakunAkunsp2d =
			"update  akunsp2d set nmakun=?  where kdssbp=? and kdskpd=? and kdtrans=?;";
	public final String mencariDataAkun =
			"select * from akunsp2d where kdssbp=? and kdskpd=? and kdtrans=?;";
	public final String menghapusDataAkunsp2d =
			"delete from akunsp2d where kdssbp=? and kdskpd=? and kdtrans=?;";

}

