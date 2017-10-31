package com.padepokan79.model;

public interface MdSequenceTbl {
	public final String CreateData=
			"insert into sequence_tbl values(?,?,?,?,?,?)";
	public final String ReadData =
			"select * from sequence_tbl";
	public final String UpdateData =
			"update sequence_tbl set ket=? where idnum=?";
	public final String DeleteData =
			"delete from sequence_tbl where idnum=?";
	public final String SearchData =
			"select * from sequence_tbl where idnum =?";
}
