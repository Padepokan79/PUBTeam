package com.padepokan79.model;

public interface MdRekapSertifikasi {
	public final String menambahkanDataDiTabelRekapSertifikasi =
			"INSERT INTO rekap_sertifikasi (tglgaji, tgl_byr, kdsatker, peg, Gapok, Pajak, tgl_cutoff) VALUE('2017-09-09', '2017-09-10', '001', 700000, 5000000, 1000000, '2017-09-11'), ('2017-10-09', '2017-09-10', '002', 700000, 8000000, 2000000, '2017-09-12');";
	public final String menampilkanSemuaData =
			"SELECT * FROM rekap_sertifikasi;";
	public final String mencariTglgajiTglBayarKdsatkerdanPeg =
			"SELECT tglgaji, tgl_byr, kdsatker, peg FROM rekap_sertifikasi WHERE kdsatker=?;";
	public final String mengubahGapok =
			"UPDATE rekap_sertifikasi SET gapok=10000000 FROM rekap_sertifikasi WHERE kdsatker='001';";
	public final String menghapusData =
			"DELETE FROM rekap_sertifikasi WHERE kdsatker='002';";
}
