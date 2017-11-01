package com.padepokan79.model;

public interface MdGajiTht0Tbl {
	public final String ReadGajiTht0Tbl=
			"SELECT nip,tglgaji,kdjnstrans,gapok FROM Gaji_Tht0_Tbl;";
	public final String TambahDataGajiTht0Tbl=
			"INSERT INTO gaji_tht0_tbl VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	public final String LihatGapokDataBaruGajiTht0Tbl=
			"SELECT nip,tglgaji,kdjnstrans,gapok FROM gaji_tht0_tbl WHERE nip=?;";
	public final String UpdateGappokDataBaruGajiTht0Tbl=
			"UPDATE gaji_tht0_tbl SET gapok=? WHERE nip=?;";
	public final String DeleteDataBaru=
			"DELETE FROM gaji_tht0_tbl WHERE nip=?;";
}
