package com.padepokan79.model;

public interface MdHistorisSatker {
	public final String CreateData = 
			"insert into historis_satker values (?,?,?,?,?,?,?,?,?,?,?)";
	public final String ReadData = 
			"select tmtgaji,nip,kdsatker,keterangan from historis_satker limit 0,5";
	public final String UpdateData = 
			"update historis_satker set keterangan=? where tmtgaji=? and nip=?";
	public final String DeleteData = 
			"delete from historis_satker where tmtgaji=? and nip=?";
	public final String SearchData= 
			"select tmtgaji,nip,kdsatker,keterangan from historis_satker where nip=?";
}
