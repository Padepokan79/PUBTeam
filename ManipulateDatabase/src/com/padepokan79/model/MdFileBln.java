package com.padepokan79.model;

public interface MdFileBln {
	public final String mencariBulan =
		"select curr_mm, name_mm from filebln where curr_mm = ?;";
	public final String menampilkanBulan = 
		"select curr_mm, name_mm from filebln;";
	public final String menambahkanDataBulan =
		"insert into filebln values (?, ?, ?, ?, ?);";
	public final String mengubahDataBln =
		"update filebln set name_mm= ? where curr_mm = ?;";
	public final String menghapusDataBln =
		"delete from filebln where curr_mm = ?;";
}
