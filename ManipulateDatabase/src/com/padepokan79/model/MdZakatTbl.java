package com.padepokan79.model;

public interface MdZakatTbl {
	public final String InsertDataZakatTbl = "insert into zakat_tbl (nip, blthgaji,kdjnstrans,kode,nilai) values (?,?,?,?,?);";
	public final String CariDataZakatTbl = "select nip, blthgaji, kdjnstrans, nilai from zakat_tbl where nip = ? limit 0,10;";
	public final String UpdateDataZakatTbl = "update zakat_tbl set nilai = ? where nip = ?;";
	public final String DeleteDataZakatTbl = "delete from zakat_tbl where nip = ?;";
	public final String SelectDataZakatTbl = "select nip, blthgaji, kdjnstrans, nilai from zakat_tbl limit 0,10;";

}
