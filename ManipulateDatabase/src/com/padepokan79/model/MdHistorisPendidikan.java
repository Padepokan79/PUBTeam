package com.padepokan79.model;

public interface MdHistorisPendidikan {
	public final String queryMencariPenerbit = 
			"SELECT NIP,PENERBIT,CATATAN FROM historis_pendidikan WHERE NIP = ?;";
	public final String queryCreateHistorisPendidikan =
			"INSERT INTO historis_pendidikan (nip,penerbit,catatan) VALUES (?,?,?);";
	public final String queryReadHistorisPendidikan =
			"SELECT nip,penerbit,catatan from historis_pendidikan;";
	public final String queryUpdateHistorisPendidikan =
			"UPDATE historis_pendidikan SET penerbit = ?,catatan=? WHERE nip = ?;";
	public final String queryDeleteHistorisPendidikan =
			"DELETE FROM historis_pendidikan WHERE nip = ?;";
}
