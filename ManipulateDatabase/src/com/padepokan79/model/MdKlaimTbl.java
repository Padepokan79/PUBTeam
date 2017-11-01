package com.padepokan79.model;

public interface MdKlaimTbl {
	public final String InsertDataKlaimTbl = "insert into klaim_tbl (kdklaim,kdproduk,kdkelompok,nmklaim) values (?,?,?,?);";
	public final String CariDataKlaimTbl = "select kdklaim,kdproduk,kdkelompok,nmklaim from klaim_tbl where kdklaim = ?;";
	public final String UpdateDataKlaimTbl = "update klaim_tbl set nmklaim = ? where kdklaim = ?;";
	public final String DeleteDataKlaimTbl = "delete from klaim_tbl where kdklaim = ?;";
	public final String SelectDataKlaimTbl = "select kdklaim,kdproduk,kdkelompok,nmklaim from klaim_tbl;";
}
