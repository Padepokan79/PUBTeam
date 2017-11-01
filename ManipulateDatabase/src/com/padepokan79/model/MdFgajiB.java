package com.padepokan79.model;

public interface MdFgajiB {
	public final String manampilkanDataFgajiB =
			"select * from fgaji_b";
	public final String menambahDataFgajiB =
			"insert into  fgaji_b values ('2017-10-25',2,'020415103210001','SUGIARTINI','Drs','MM',2,'1976-06-11',1,0,0,4,'2000-11-09','3a',8,100,'2012-01-01','00','08405','90',0,2,0,'0',0,'999',1921000,0,0,0,0,265000,0,0,0,0,0,0,49500,35620,0,0,0,2271120,192100,0,35620,0,7000,0,234720,2036400,'300114','001','019','D10200101900001','00.000.00.0-000.000','140331208',1,'999','888',null,1,1)";
	public final String mengubahNamaFgajiB =
			"update fgaji_b set nama='Sugiartini Fajriati' where nip='020415103210001';";
	public final String mencariTgllhrBerdasarkanNama =
			"select tgllhr from fgaji_b where nama='sri sugiartini';";
	public final String menghapusDataFgajiBberdasarkanNIP =
			"delete from fgaji_b where nip='020415103210001';";
}
