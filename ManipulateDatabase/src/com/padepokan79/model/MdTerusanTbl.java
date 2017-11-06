package com.padepokan79.model;

public interface MdTerusanTbl {

	public final String queryReadTerusanTbl=
			"select * from terusan_tbl limit 10";
	
	public final String queryInsertTerusanTbl=
			"insert into terusan_tbl set nip= ? , KDJNSTRANS= ? ";
	
	public final String queryUpdateTerusanTbl=
			"update terusan_tbl set  KDJNSTRANS= ? where nip= ? ";
	
	public final String querySearchTerusanTbl=
			"select * from terusan_tbl  where nip= ? ";
	
	public final String queryDeleteTerusanTbl=
			"delete from terusan_tbl  where nip= ? ";
}
