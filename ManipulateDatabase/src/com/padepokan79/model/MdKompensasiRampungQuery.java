package com.padepokan79.model;

public interface MdKompensasiRampungQuery {
	public final String viewTable =
	"select tglgaji,nip,telah,harus from kompensasi_rampung";
	public final String selectTable =
	"select tglgaji,nip,telah,harus from kompensasi_rampung where nip=?";
	public final String insertTable =
	"insert into kompensasi_rampung values (?,?,?,?);";
	public final String updateTable =
	"update kompensasi_rampung set tglgaji= where nip = ?";
	public final String deleteTable =
	" delete from kompensasi_rampung where nip = ?;";
}
