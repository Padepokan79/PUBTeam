package com.padepokan79.model;
//by ILFA SRI DESY
public interface MdTbPangkat {
	public final String queryInsertTbPangkat =
			"insert into tb_pangkat (pkt010, pkt020, pkt030, pkt040, pkt050) values (?, ?, ?, ?, ?);";
	
	public final String querySelectAllTbPangkat =
			"select * from tb_pangkat;";
	
	public final String queryMencariTbPangkat =
			"select * from tb_pangkat where pkt010=?;";
	
	public final String queryUpdateTbPangkat =
			"update tb_pangkat set pkt030=? where pkt010=?;";
	
	public final String queryDeleteTbPangkat =
			"delete from tb_pangkat where pkt010=?;";
}
