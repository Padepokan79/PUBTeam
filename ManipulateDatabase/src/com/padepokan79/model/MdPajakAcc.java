package com.padepokan79.model;

public interface MdPajakAcc {
	public final String nampilinPajakAcc=
			"select * from pajak_acc;";
	
	public final String nambahPajakAcc=
			"insert into pajak_acc(kdcabang,kdssbp,tgl_srt,no_srt) values(?,?,?,?);";
	
	public final String ubahPajakAcc=
			"update pajak_acc set tgl_srt=? where no_srt=?;";
	
	public final String hapusPajakAcc=
			"delete from pajak_acc where kdcabang=? AND kdssbp=?;";
	
	public final String mencariPajakAcc=
			"select kdcabang,kdssbp from pajak_acc where tgl_srt=?;";
}
