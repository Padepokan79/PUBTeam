package com.padepokan79.model;

public interface MdHitungTbl {
	public final String CreateData=
			"insert into hitung_tbl values(?,?)";
	public final String ReadData=
			"select * from hitung_tbl";
	public final String UpdateData=
			"update hitung_tbl set nmhitung=? where kdhitung=? ";
	public final String DeleteData=
			"delete from hitung_tbl where kdhitung=?";
	public final String SearchData=
			"select * from hitung_tbl where kdhitung=?";

}
