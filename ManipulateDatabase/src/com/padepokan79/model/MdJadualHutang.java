package com.padepokan79.model;

public interface MdJadualHutang {
	public final String querySearchberdasarkanNoUrut = 
			"select nip,urut,jumlah from jadual_hutang where urut=?;";
	public final String querySelectData = 
			"select nip,urut,jumlah from jadual_hutang;";
	public final String queryInsertData=
			"insert into jadual_hutang values (?,?,?,?,?,?,?);";
	public final String queryUpdateJumlahBerdasarkanNoUrut=
			"update jadual_hutang set jumlah=? where urut=?;";
	public final String queryDeleteDataBerdasarkanUrut=
			"delete from jadual_hutang where urut=?;";
}
