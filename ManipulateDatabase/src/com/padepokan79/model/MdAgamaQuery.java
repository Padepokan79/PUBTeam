package com.padepokan79.model;

public interface MdAgamaQuery {
	public final String MengeditAgama =
			"update agama_tbl set nmagama=? where kdagama = ?;";
	public final String menghapusAgama =
			"delete from agama_tbl where kdagama=? ;";
	public final String menambahkanAgama =
			"insert into agama_tbl (kdagama,nmagama) values (?,?);";
	public final String mencariAgama =
			"SELECT kdagama,nmagama FROM agama_tbl where kdagama=? limit 0,10;";
	public final String menampilkanAgama =
			"select kdagama, nmagama from agama_tbl limit 0,10;";
}
