package com.padepokan79.model;

public interface MdHutang {
	public final String queryMenampilkanData = 
			"select nip,jmlhutang, jmlcicilan, jmlbulan from hutang;";
	public final String queryMencariData = 
			"select nip,jmlhutang, jmlcicilan, jmlbulan from hutang where jmlhutang > ?;";
	public final String queryMenambahData = 
			"insert into hutang values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
	public final String queryMengubahData = 
			"update hutang set keterangan=? where nip=?;";
	public final String queryMenghapusData =
			"delete from hutang where nip=?;";
}
