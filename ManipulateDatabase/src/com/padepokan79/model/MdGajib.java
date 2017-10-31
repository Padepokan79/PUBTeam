package com.padepokan79.model;
//by ILFA SRI DESY
public interface MdGajib {
	public final String queryInsertGajib = 
			"insert into gajib (nip, nama, namasat, gapok) values (?,?,?,?);";
	
	public final String querySelectAllGajib=
			"select nip, nama, namasat, gapok from gajib limit 0,10;";
	
	public final String queryMencariGajib=
			"select nip, nama, namasat, gapok from gajib where nip=?;";
	
	public final String queryUpdateGajib =
			"update gajib set gapok=? where nip=?;";
	
	public final String queryDeleteGajib =
			"delete from gajib where nip=?;";
}
