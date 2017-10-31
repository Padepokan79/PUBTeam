package com.padepokan79.model;

public interface MdHistorisJiwaQuery {
	public final String selectTable =
	"select tmtgaji,nip,kdstawin,tglupdate from historis_jiwa where kdstawin = 1;";
	public final String insertTable =
	"insert into historis_jiwa values ('2011-02-01','195111211983031002',1,1,'data awal','2013-07-30 13:20:54',2,'2004-04-01');";
	public final String updateTable =
	"update historis_jiwa set keterangan ='Data update' where tmtgaji='2004-04-01' and nip ='195107311978121001';";
	public final String deleteTable ="delete from historis_jiwa where tmtgaji='2004-04-01' and nip ='195107311978121001';";
	
}
