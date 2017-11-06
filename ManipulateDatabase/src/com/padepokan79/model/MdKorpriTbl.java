package com.padepokan79.model;

public interface MdKorpriTbl {
public final String cariKorpriBerdaskrkankode="select kdkorpri,nilai,keter\r\n" + 
		"from korpri_tbl where kdkorpri= ?;";
public final String tampilKorpri="select kdkorpri,nilai,keter\r\n" + 
		"from korpri_tbl";
public final String tambahKorpri = "insert into korpri_tbl\r\n" + 
		"values(?,?,?,?);";
public final String updateKorpri = "update korpri_tbl set nilai = ? , keter = ? where kdkorpri = ?";

public final String deleteKorpri = "delete from korpri_tbl  where kdkorpri = ?";
}


