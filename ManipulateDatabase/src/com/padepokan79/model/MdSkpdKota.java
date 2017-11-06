package com.padepokan79.model;

public interface MdSkpdKota {
	public final String queryMenampilkanData = 
			"select * from skpd_kota ;";
	public final String queryMencariData = 
			"select * from skpd_kota where nmskpd = ?;";
	public final String queryMenambahData =
			"insert into skpd_kota values(?,?,?,?,?,?,?);";
	public final String queryMengubahData =
			"update skpd_kota set nmskpd=? where kdskpd=?;";
	public final String queryMenghapusData =
			"delete from skpd_kota where kdskpd=?;";
}
