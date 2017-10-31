package com.padepokan79.model;

public interface MdPndTg {

	public final String queryTampilPndTg = 
			"select nama, jab from pnd_tg where nama = ?;";
	public final String queryInputPndTg =
			"insert into pnd_tg values(?, ?, ?, ?, ?, ?);";
	public final String queryUpdatePndTg =
			"update pnd_tg set kota = ? where nip = ?;";
	public final String queryDeletePndTg =
			"delete from pnd_tg where nip = ?;";

}
