package com.padepokan79.model;

public interface MdDataRapel {
	public final String nampilinDataRapel=
			"select * from data_rapel limit 5;";
	
	public final String nambahinDataRapel=
			"insert into data_rapel (KDSATKER,NAMASATKER,NIP,NAMA,KDJENKEL) VALUES(?,?,?,?,?);";
			
	
	public final String mencariDataRapel=
			"SELECT KDSATKER,NIP FROM data_rapel where NAMA=?;";
	
	public final String mengeditDataRapel=
			"update data_rapel set JANAK=? where NAMA=?;";
	
	public final String hapusDataRapel=
			"delete from data_rapel where NAMA='TEGUH PRABOWO LEKSONO';";
}
