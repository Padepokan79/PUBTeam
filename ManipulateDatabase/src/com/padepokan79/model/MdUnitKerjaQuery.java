package com.padepokan79.model;

public interface MdUnitKerjaQuery {
	public final String selectTable =
	"select satkerja,unit,kota,jab_atasan from unitkerja where unit=5 limit 10;";
	public final String insertTable =
	"insert into unitkerja values ('97',1,'Badan Pemerintahan','Bandung','Kepala Badan','Buah Batu','Bulan','','','','','','','');";
	public final String updateTable =
	"update unitkerja set unit =3 where satkerja = '97'";
	public final String deleteTable =
	"delete from unit kerja where satkerja='97'";
}
