package com.padepokan79.model;

public interface MdJenisDidik {

	public final String queryReadDataJnsDidik=
			"select * from jenis_didik";
	
	public final String queryInsertDataJnsDidik=
			"insert into jenis_didik set jnsdidik= ? , nmjenisdidik= ? ";
	
	public final String queryUpdateDataJnsDidik=
			"update jenis_didik set  nmjenisdidik= ? where jnsdidik= ? ";
	
	public final String querySearchDataJnsDidik=
			"select * from jenis_didik where jnsdidik= ? ";
	
	public final String queryDeleteDataJnsDidik=
			"delete from jenis_didik  where jnsdidik= ? ";

}

