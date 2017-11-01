package com.padepokan79.model;

public interface MdFSpt {
public final String tampilFspt ="select nip,nama from f_spt ;";
public final String cariFspt = "select nip,nama from f_spt where nip = ?;";
	public final String querySearchBerdasarkanNip = 
			"select nip,nama,nourt from f_spt where nip=?;";
	public final String querySelectData = 
			"select nip,nama,nourt from f_spt limit 0,10;";
	public final String queryInsertData=
			"insert into f_spt values (?,?,?,?,?,?);";
	public final String queryUpdateBerdasarkanNip=
			"update f_spt set nourt=? where nip=?;";
	public final String queryDeleteDataBerdasarkanNip=
			"delete from f_spt where nip=?;";
}
