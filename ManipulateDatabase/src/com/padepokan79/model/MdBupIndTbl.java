package com.padepokan79.model;

public interface MdBupIndTbl {
	public final String ReadAllBupIndTbl=
			"SELECT nip,bup,tgl_srt,no_srt FROM bup_ind_tbl";
	public final String TambahDataBupIndTbl = 
			"INSERT INTO bup_ind_tbl VALUES (?, ?, ?, ?);";
	public final String LihatBupBupIndTbl = 
			"SELECT nip,bup,tgl_srt,no_srt FROM bup_ind_tbl WHERE NIP=?;";
	public final String UpdateDataBaruBupIndTbl = 
			"UPDATE bup_ind_tbl SET bup=? WHERE nip=?;";
	public final String DeleteDataBaruBupIndTbl =
			"DELETE FROM bup_ind_tbl WHERE nip=?;";
}
