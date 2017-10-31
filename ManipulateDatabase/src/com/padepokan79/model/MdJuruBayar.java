package com.padepokan79.model;

public interface MdJuruBayar {
	public final String queryInsertJuruBayar = 
			"insert into jurubayar values (?, ?);";
	
	public final String queryUpdateJuruBayar = 
			"update jurubayar set nmbayar=? where kodebyr=?;";
	
	public final String queryDeleteJuruBayar = 
			"delete from jurubayar where kodebyr=?;";
	
	public final String queryReadJuruBayar = 
			"select *from jurubayar;";
	
	public final String querySearchJuruBayar = 
			"select *from jurubayar where kodebyr=?;";
}
