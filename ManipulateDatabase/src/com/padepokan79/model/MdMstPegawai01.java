package com.padepokan79.model;
//by ILFA SRI DESY
public interface MdMstPegawai01 {
	public final String queryInsertMstPegawai01 = 
			"insert into mstpegawai_01 (nip, nama, tgllhr, pendidikan) values (?,?,?,?); ";
	
	public final String querySelectAllMstPegawai01 =
			"select nip, nama, tgllhr, pendidikan from mstpegawai_01 limit 0,10";
	
	public final String queryMencariMstPegawai01 =
			"select nip, nama, tgllhr, pendidikan from mstpegawai_01 where nip=?;";
	
	public final String queryUpdateMstPegawai01 =
			"update mstpegawai_01 set nama=? where nip=?;";
	
	public final String queryDeleteMstPegawai01 =
			"delete from mstpegawai_01 where nip=?;";
}
