package com.padepokan79.model;

public interface MdJadwalQuery {
	public final String selectTable = 
	"select nip,kdhutang,tglcicilan,jmlcicilan from jadwal where jmlcicilan < 100000 limit 10;";
	public final String insertTable =
	"insert into jadwal values ('12345678',1,1,'2011-06-01',100000,0,'2011-06-05');";
	public final String updateTable = 
	"update jadwal set jmlcicilan =50000 where nip='12345678';";
	public final String deleteTable =
	"delete from jadwal where nip='12345678';";
	
	public final String viewTable =
	"select nip,kdhutang,tglcicilan,jmlcicilan from jadwal";
}
