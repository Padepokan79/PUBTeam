package com.padepokan79.model;

public interface MdSspbTbl {
public final String menampilkanDataSsbpTbl =
	"select kdssbp,nmssbp,kdcabang from ssbp_tbl;";

public final String menambahDataSsbpTbl =
	"insert into ssbp_tbl (kdssbp,nmssbp,kdcabang) values(?,?,?)";

public final String mencariDataBerdasarkanKDSSBP =
"select kdssbp,nmssbp,kdcabang from ssbp_tbl where kdssbp=?;";

public final String mengubahKdcabangBerdasarkanKdssbp =
"update ssbp_tbl set kdcabang=? where kdssbp=?;";

public final String hapusSsbpBerdasarkanKdssbp =
"delete from ssbp_tbl where kdssbp=?;";

}
