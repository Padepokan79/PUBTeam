package com.padepokan79.model;

public interface MdZakatTdk {
	public final String menambahkanDataZakat =
			"INSERT INTO zakat_tdk VALUE(?,?);";
	public final String menampilkanSemuaDataZakat =
			"SELECT * FROM zakat_tdk;";
	public final String mencariDataZakat =
			"SELECT nip, mulai FROM zakat_tdk WHERE nip=?;";
	public final String mengubahMulaiZakat =
			"UPDATE zakat_tdk SET mulai=? WHERE nip=?;";
	public final String menghapusDataZakat =
			"DELETE FROM zakat_tdk WHERE nip=?;";
}
