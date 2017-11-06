package com.padepokan79.model;

public interface MdHitPajak {
	public final String queryInsertHitPajak = 
			"insert into hit_pajak values (?, ?, ?, ?, ?, ?);";
	public final String queryUpdateHitPajak = 
			"update hit_pajak set subkotor=?, kotorinduk=? where nip=? and thp=?;";
	
	public final String queryDeleteHitPajak = 
			"delete from hit_pajak where nip=? and thp=?;";
	
	public final String queryReadHitPajak = 
			"select nip, subkotor, istri, anak from hit_pajak limit 0,10;";
	
	public final String querySearchHitPajak = 
			"select nip, subkotor, istri, anak from hit_pajak where nip=? and istri=? and anak=?;";
}
