package com.padepokan79.model;

public interface MdJabatanFungsi {
	public final String querySearchNamaBerdasarkanKdFungsi = 
			"select KDFUNGSI,NMFUNGSI from jabatan_fungsi where KDFUNGSI=?";
	public final String querySelectData = 
			"select KDFUNGSI,NMFUNGSI from jabatan_fungsi;";
	public final String queryInsertData=
			"insert into jabatan_fungsi values (?,?);";
	public final String queryUpdateNamaBerdasarkanKodeFungsi=
			"update jabatan_fungsi set nmfungsi=? where kdfungsi=?;";
	public final String queryDeleteDataBerdasarkanKodeFungsi=
			"delete from jabatan_fungsi where kdfungsi=?;";
}
