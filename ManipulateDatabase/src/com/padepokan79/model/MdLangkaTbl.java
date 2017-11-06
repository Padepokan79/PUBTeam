package com.padepokan79.model;

public interface MdLangkaTbl {
	public final String CreateData=
			"insert into langka_tbl values (?,?,?)";
	
	public final String ReadData=
			"select * from langka_tbl";
	
	public final String UpdateData=
			"update langka_tbl set uraian_langka=? where kdlangka=?";
	
	public final String DeleteData=
			"delete from langka_tbl where kdlangka=?";
	
	public final String SearchData=
			"select * from langka_tbl where kdlangka=?";
}
