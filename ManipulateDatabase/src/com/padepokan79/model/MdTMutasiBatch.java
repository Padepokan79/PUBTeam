package com.padepokan79.model;

public interface MdTMutasiBatch {
	public final String queryNipKdsatkerlInputer = 
			"SELECT NIP,KDsatker_l,inputer from t_mutasi_batch WHERE NIP = ?;";
	public final String queryCreateTMutasiBatch =
			"INSERT INTO t_mutasi_batch(Nip,KdSkpd_l,KdSatker_l,Inputer) VALUES (?,?,?,'?);";
	public final String queryReadTMutasiBatch =
			"SELECT NIP,KDsatker_l,inputer FROM t_mutasi_batch limit 0,10;";
	public final String queryUpdateTMutasiBatch =
			"UPDATE t_mutasi_batch SET inputer = 'Jejen Zenal Mutaqin' WHERE NIP = ?; ";
	public final String queryDeleteTMutasiBatch =
			"DELETE FROM t_mutasi_batch WHERE NIP = ?;";
}
