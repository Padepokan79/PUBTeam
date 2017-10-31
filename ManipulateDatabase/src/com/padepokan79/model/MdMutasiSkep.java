package com.padepokan79.model;

public interface MdMutasiSkep {

	public final String queryReadMutasi=
			"select nip,kdpangkat,gapok,masker from mutasi_skep";
	public final String queryInsertMutasi=
			"insert into mutasi_skep set nip=?,noagenda=?,kdpangkat=?,gapok=?,masker=?";
	public final String queryUpdateMutasi=
			"update mutasi_skep set kdpangkat=?,gapok=?,masker=? where nip=? and noagenda=?";
	public final String queryDeleteMutasi=
			"delete from mutasi_skep  where nip=? and noagenda=?";
	public final String querySearchMutasi=
			"select nip,kdpangkat,gapok,masker from mutasi_skep where noagenda=?";
}
