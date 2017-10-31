package com.padepokan79.model;

public interface MdStapegTbl {
	public final String ReadStapegTbl=
			"select kdstapeg,nmstapeg,kd_jns_peg from stapeg_tbl limit 5;";
	public final String TambahDataStapegTbl=
			"insert into stapeg_tbl values(?,?,?);";
	public final String SearchDataStapegTbl=
			"select kdstapeg,nmstapeg,kd_jns_peg from stapeg_tbl where kdstapeg=?;";
	public final String UpdateDataStapegTbl=
			"UPDATE stapeg_tbl SET nmstapeg=? WHERE kdstapeg=?;";
	public final String DeleteDataStapegTbl=
			"DELETE FROM stapeg_tbl WHERE kdstapeg=?;";
}
