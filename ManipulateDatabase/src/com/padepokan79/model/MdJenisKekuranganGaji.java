package com.padepokan79.model;

public interface MdJenisKekuranganGaji {
	public final String queryInsertJenisKekuranganGaji =
			"insert into jenis_kekurangan_gaji values (?, ?);";
	
	public final String querySelectAllJenisKekuranganGaji =
			"select * from jenis_kekurangan_gaji;";
	
	public final String queryMencariJenisKekuranganGaji =
			"select * from jenis_kekurangan_gaji where NMKEKURANGAN=?;";
	
	public final String queryUpdateJenisKekuranganGaji =
			"update jenis_kekurangan_gaji set NMKEKURANGAN=? where JENISKEKURANGAN=?;";
	
	public final String queryDeleteJenisKekuranganGaji =
			"delete from jenis_kekurangan_gaji where JENISKEKURANGAN=?;";
}
