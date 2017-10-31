package com.padepokan79.model;

public interface MdJenisPeg {
	public final String queryKodedanNamaJenis = 
			"SELECT kd_jns,nm_jns FROM jenis_peg WHERE kd_jns = ?;";
	public final String queryCreateJenisPegawai =
			"INSERT INTO jenis_peg VALUES (?,?);";
	public final String queryReadJenisPegawai =
			"SELECT * FROM jenis_peg;";
	public final String queryUpdateJenisPegawai = 
			"UPDATE jenis_peg SET nm_jns = ? WHERE kd_jns = ?;";
	public final String queryDeleteJenisPegawai = 
			"DELETE FROM jenis_peg WHERE kd_jns = ?;";
}
