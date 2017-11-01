package com.padepokan79.model;

public interface MdTbulan {
	public final String menambahkanDatadiTbulan =
			"INSERT INTO tbulan VALUE(?,?);";
	public final String menampilkanSemuaData =
			"SELECT * FROM tbulan;";
	public final String mencariKdbulandanNmBulan =
			"SELECT kdbulan, nmbulan FROM tbulan WHERE kdbulan=?;";
	public final String mengubahBulan =
			"UPDATE tbulan SET nmbulan=? WHERE kdbulan=?;";
	public final String menghapusBulan =
			"DELETE FROM tbulan WHERE kdbulan=?;";
}
