package com.padepokan79.model;

public interface MdHistJiwa {
	public final String queryMenampilkanPenerbit = 
			"SELECT nip,penerbitskep FROM hist_jiwa WHERE NIP = ?;";
	public final String queryCreateHistJiwa =
			"INSERT INTO hist_jiwa VALUES (?,?,?,?,?,?,?,?);";
	public final String queryReadHistJiwa =
			"SELECT nip,tmtberlaku,penerbitskep FROM hist_jiwa";
	public final String queryUpdateHistJiwa =
			"UPDATE hist_jiwa SET PENERBITSKEP = ? WHERE nip = ? AND tmtberlaku = ? ;";
	public final String queryDeleteHistJiwa =
			"DELETE FROM hist_jiwa WHERE nip = ? AND tmtberlaku = ?;";
}
