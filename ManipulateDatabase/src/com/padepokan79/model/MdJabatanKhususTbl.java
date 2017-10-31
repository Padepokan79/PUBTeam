package com.padepokan79.model;

public interface MdJabatanKhususTbl {
	public final String queryInsertJabatanKhususTbl = 
			"insert into jabatankhusus_tbl (TMTJABATAN, KDJABATAN, NMJABATAN, JML, PENSIUN) values (?, ?, ?, ?, ?);";
	
	public final String querySelectAllJabatanKhususTbl =
			"select * from jabatankhusus_tbl;";
	
	public final String queryMencariJabatanKhususTbl =
			"select * from jabatankhusus_tbl where NMJABATAN=?";
	
	public final String queryUpdateJabatanKhususTbl =
			"update jabatankhusus_tbl set PENSIUN=? where TMTJABATAN=? and KDJABATAN=?;";
	
	public final String queryDeleteJabatanKhususTbl =
			"delete from jabatankhusus_tbl where TMTJABATAN=? and KDJABATAN=?;";
}
