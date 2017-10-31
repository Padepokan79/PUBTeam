package com.padepokan79.model;

public interface MdIrdhata {

	public final String queryReadIrdhataTbl=
			"select * from irdhata_tbl ";
	
	public final String queryInsertIrdhataTbl=
			"insert into irdhata_tbl set tmt= ? , kdirdhata= ? , nilai=? , keter = ? ";
	
	public final String queryUpdateIrdhataTbl=
			"update irdhata_tbl set  nilai=? , keter = ? where tmt= ? and kdirdhata= ? ";
	
	public final String querySearchIrdhataTbl=
			"select * from irdhata_tbl  where kdirdhata= ? ";
	
	public final String queryDeleteIrdhataTbl=
			"delete from irdhata_tbl  where  kdirdhata= ?  ";
}
