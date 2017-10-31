package com.padepokan79.model;
//by ILFA SRI DESY
public interface MdIuranJkkjkm {
	public final String queryInsertIuranJkkjkm = 
			"insert into iuran_jkkjkm (nip, tglgaji, KdJnsTrans, iuran_jkk, iuran_jkm) values (?,?,?,?,?);";
	
	public final String querySelectAllIuranJkkjkm =
			"select nip, tglgaji, KdJnsTrans, iuran_jkk, iuran_jkm from iuran_jkkjkm limit 0,10";
	
	public final String queryMencariIuranJkkjkm=
			"select nip, tglgaji, KdJnsTrans, iuran_jkk, iuran_jkm from iuran_jkkjkm where nip=?;";
	
	public final String queryUpdateIuranJkkjkm =
			"update iuran_jkkjkm set iuran_jkk=?, iuran_jkm=? where nip=? and tglgaji=? and KdJnsTrans=?;";
	
	public final String queryDeleteIuranJkkjkm =
			"delete from iuran_jkkjkm where nip=? and tglgaji=? and KdJnsTrans=?;";
}
