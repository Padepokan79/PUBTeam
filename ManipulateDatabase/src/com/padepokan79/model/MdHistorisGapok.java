package com.padepokan79.model;

public interface MdHistorisGapok {
	public final String nampilinHistorisGapok=
			"select * from historis_gapok limit 5;";
	
	public final String nambahHistorisGapok=
			"insert into historis_gapok (TMTGAJI,NIP,kdstapeg,KDPANGKAT,GAPOK,MASKER,PRSNGAPOK,\r\n" + 
			"TMTTABEL,TGLSKEP,NOMORSKEP,\r\n" + 
			"PENERBITSKEP,tmt,KETERANGAN,TGLUPDATE) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public final String ubahHistorisgapok=
			"update historis_gapok set GAPOK=? where TMTGAJI=? and NIP=?;";
	
	public final String hapusHistorisGapok=
			"delete from pajak_acc where TMTGAJI=? and NIP=?;";
	
	public final String mencariHistorisGapok=
			"select GAPOK from historis_gapok where NIP=?;";
}
