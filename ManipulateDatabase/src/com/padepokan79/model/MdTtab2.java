package com.padepokan79.model;

public interface MdTtab2 {
	public final String menampilkanTtab2 =
			"select kode,jenjab,agama from t_tab2";
	
	public final String menambahkanTtab2 =	
			"insert into t_tab2 (kode,jenjab,agama) values (?,?,?);";
	public final String mencariDataBerdasarkanKODE =
			"select kode,jenjab,agama from t_tab2 where kode=?;";
	public final String mengubahAgamaBerdasarkanKODE =
			"update t_tab2 set agama=? where kode=?;";
	public final String hapusTtab2BerdasarkanKODE =
			"delete from t_tab2 where kode=?;";
}
