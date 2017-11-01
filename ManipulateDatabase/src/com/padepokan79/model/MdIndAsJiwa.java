package com.padepokan79.model;

public interface MdIndAsJiwa {
	public final String InsertDataIndAsJiwa = "insert into ind_as_jiwa (nip, nama, kdpangkat, kdjiwa) values "
			+ "(?,?,?,?);";
	public final String CariDataIndAsJiwa = "select nip, nama ,kdpangkat ,kdjiwa from ind_as_jiwa where nip = ? limit 0,10;";
	public final String UpdateDataIndAsJiwa = "update ind_as_jiwa set nama = ? where nip = ?;";
	public final String DeleteDataIndAsJiwa = "delete from ind_as_jiwa where nip = ?;";
	public final String SelectDataIndAsJiwa = "select nip, nama , kdpangkat, kdjiwa from ind_as_jiwa limit 0,10;";
}
