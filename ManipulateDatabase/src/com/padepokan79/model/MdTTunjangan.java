package com.padepokan79.model;

public interface MdTTunjangan {

	public final String queryReadTTunjangan=
			"select * from t_tunjangan limit 10";
	
	public final String queryInsertTTunjangan=
			"insert into t_tunjangan set kdkel= ? , kdjab= ? , nmjabatan=? , jml = ? , pensiun= ?";
	
	public final String queryUpdateTTunjangan=
			"update t_tunjangan set  nmjabatan=? , jml = ? , pensiun= ? where kdkel= ? and kdjab= ?  ";
	
	public final String querySearchTTunjangan=
			"select * from t_tunjangan  where kdjab= ? ";
	
	public final String queryDeleteTTunjangan=
			"delete from t_tunjangan  where kdkel= ? and kdjab= ?  ";
}
