package com.padepokan79.model;

public interface MdHakAkses {
	public final String queryTampilHakAkses = 
			"select pemakai, kodeakses from hak_akses ;";
	public final String queryInputHakAkses =
			"insert into hak_akses values (?, ?);";
	public final String queryUpdateHakAkses =
			"update hak_akses set pemakai = ? where kodeakses = ? ;";
	public final String queryDeleteHakAkses =
			"delete from hak_akses where pemakai = ? and kodeakses = ?;";
}
