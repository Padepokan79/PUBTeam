package com.padepokan79.model;

public interface MdHistorisEselon {

	public final String queryReadTjHistoriEselon=
			"select tmtgaji,nip,kdeselon,tjeselon from historis_eselon where tjeselon <>0 limit 10";
	public final String  queryInsertDataHistorisEselon=
			"insert into historis_eselon set tmtgaji=?,nip=?,kdeselon=?,tjeselon=?,keterangan=?";
	public final String  queryUpdateDataHistorisEselon=
			"update historis_eselon set tmtgaji=?,kdeselon=?,tjeselon=?,keterangan=? where nip=?";
	public final String querySearchTjHistorisEselon=
			"select tmtgaji,nip,kdeselon,tjeselon from historis_eselon where nip=?";
	public final String queryDeleteTjHistorisEselon=
			"delete from historis_eselon where nip=?";
	
}
