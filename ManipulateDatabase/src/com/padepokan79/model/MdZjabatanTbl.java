package com.padepokan79.model;

public interface MdZjabatanTbl {
	public final String InsertDataZjabatanTbl = "insert into zjabatan_tbl (jml_r,tmtjabatan,kdjabatan,nmjabatan,jml,pensiun,kdfungsi) values (?,?,?,?,?,?,?);";
	public final String CariDataZjabatanTbl = "select jml_r, nmjabatan, jml, pensiun from zjabatan_tbl where kdjabatan = ? limit 0,5;";
	public final String UpdateDataZjabatanTbl = "update zjabatan_tbl set nmjabatan = ? where kdjabatan = ?;";
	public final String DeleteDataZjabatanTbl = "delete from zjabatan_tbl where kdjabatan = ?;";
	public final String SelectDataZjabatanTbl = "select jml_r, nmjabatan, jml, pensiun from zjabatan_tbl limit 0,5;";
}
