package com.padepokan79.model;

public interface MdFileWeb {
	public final String ReadAllFileWeb=
			"SELECT namafile FROM fileweb";
	public final String TambahDataFileWeb=
			"INSERT INTO fileweb VALUES (?);";
	public final String LihatDataBaruFileWeb=
			"SELECT namafile FROM fileweb where namafile=?;";
	public final String UpdateDataBaruFileWeb=
			"UPDATE fileweb set namafile =? where namafile=?;";
	public final String DeleteDataBaruFileWeb=
			"DELETE FROM fileweb WHERE namafile =?;";
}
