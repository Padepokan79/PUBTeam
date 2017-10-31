package com.padepokan79.model;

public interface MdAkunTbl {
	public final String querySearchBerdasarkanKodeTrans = 
			"select kdtrans,kdakun, nmakun from akun_tbl where kdtrans=?";
	public final String querySelectKdakunDanNmakun = 
			"select kdtrans, kdakun, nmakun from akun_tbl";
	public final String queryInsertDataAkun_tbl = 
			"insert into akun_tbl values (?,?,?,?);";
	public final String queryUpdateNamaBerdasarkanKodeTrans=
			"update akun_tbl set nmakun=? where kdtrans=?;";
	public final String queryDeleteDataBerdasarkanKdTrans=
			"delete from akun_tbl where kdtrans=?;";
}
