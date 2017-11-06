package com.padepokan79.model;

public interface MdSsbp {
	public final String  tampilSsbp = "Select Npwp,namawp from ssbp ;";
	public final String cariSsbpBykdTrans = "Select Npwp,namawp from ssbp where kdtrans = ?;";
}
