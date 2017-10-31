package com.padepokan79.model;

public interface MdRekapJkkjkm {
	public final String insertDataRekapJkkjkm = 
			"insert into rekap_jkkjkm values (?,?,?,?,?,?,?,?);";
	public final String updateDataRekapJkkjkm = 
			"update rekap_jkkjkm set kdskpd=? where KdJnsTrans=?;";
	public final String searchDataRekapJkkjkm = 
			"select tglgaji,KdJnsTrans,kdskpd from rekap_jkkjkm where KdJnsTrans=?;";
	public final String deleteDataRekapJkkjkm = 
			"delete from rekap_jkkjkm where KdJnsTrans=?;";
	public final String SelectDataRekapJkkjkm =
			"select kdskpd,tglgaji,KdJnsTrans from rekap_jkkjkm ;";
}
