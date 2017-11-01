package com.padepokan79.model;

public interface MdHubkelTbl {
	public final String ReadHubkelTbl=
			"SELECT KDHUBKEL,NMHUBKEL FROM hubkel_tbl LIMIT 10;";
	public final String TambahDataHubkelTbl=
			"INSERT INTO hubkel_tbl VALUES (?,?);";
	public final String LihatDataBaruHubkelTbl=
			"SELECT kdhubkel,nmhubkel from hubkel_tbl where kdhubkel=?;";
	public final String UpdateNamaHubDataBaruHubkelTbl=
			"UPDATE hubkel_tbl SET nmhubkel=? where kdhubkel=?;";
	public final String DeleteDataBaruHubkelTbl=
			"DELETE FROM hubkel_tbl where kdhubkel=?;";
}

