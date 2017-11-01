package com.padepokan79.model;

public interface MdStrukTbl {
	public final String menambahkanDatadiStrukTbl =
			"INSERT INTO struk_tbl VALUE('NIP001', 1, 'L001', 900000, '2017-06-05', '2017-06-21', 200000, 700000),\r\n" + 
			"('NIP002', 2, 'L002', 3000000, '2017-03-23', '2017-04-21', 1000000, 2000000);";
	public final String menampilkanSemuaData =
			"SELECT * FROM struk_tbl;";
	public final String menampilkanNipNourtPotblndanPotakhir =
			"SELECT NIP, No_urt, Pot_bln, Pot_akhir FROM struk_tbl WHERE Jml_Hutang < 1000000;";
	public final String mengubahAkhirhutang =
			"UPDATE struk_tbl SET akhir_Hutang='2017-05-05' WHERE NIP='NIP001'";
	public final String menghapusData =
			"DELETE FROM struk_tbl WHERE NIP='NIP001';";
}
