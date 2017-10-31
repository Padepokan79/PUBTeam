package com.padepokan79.model;

public interface MdStatus {
	public final String queryMenampilkanData = 
			"select * from tb_status limit 10;";
	public final String queryMencariData = 
			"select * from tb_status where kd_status = ?;";
	public final String queryMenambahData =
			"insert into tb_status values(?,?);";
	public final String queryMengubahData =
			"update tb_status set nm_status=? where kd_status=?;";
	public final String queryMenghapusData =
			"delete from tb_status where kd_status=?;";
	
}
