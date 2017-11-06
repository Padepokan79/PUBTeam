package com.padepokan79.model;

public interface MdJenisSkppTbl {
	public final String queryMencariNamaSkpp = 
			"SELECT jenis,nama_skpp FROM jenisskpp_tbl where jenis = ?;";
	public final String queryCreateJenisSkpp =
			"INSERT INTO jenisskpp_tbl VALUES (?,?);";
	public final String queryReadJenisSkpp =
			"SELECT * FROM jenisskpp_tbl";
	public final String queryUpdateJenisSkpp =
			"UPDATE jenisskpp_tbl SET nama_skpp = ? WHERE jenis = ?";
	public final String queryDeleteJenisSkpp =
			"DELETE FROM jenisskpp_tbl WHERE jenis = ?;";
}
