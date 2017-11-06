package com.padepokan79.model;

public interface MdHistPendidikan {
	public final String menampilkanHistPendidikan =
			"select * from hist_pendidikan";
	
	public final String menambahDataHistPendidikan =
			"insert into hist_pendidikan (nip,tmtawal,tmtakhir,noijazah,catatan) values (?,?,?,?,?);";
	
	public final String mencariDataBerdasarkanNIP =
			"select nip,tmtawal,tmtakhir,noijazah,catatan from hist_pendidikan where nip=?;";
	
	public final String mengbahCatatanHistPendidikanBerdasarkanNIP =
			"update hist_pendidikan set catatan=? where nip=?;";
	
	public final String menghapusDataHistPendidikanBerdasarkanNIP =
			"delete from hist_pendidikan where nip=?;";
			
}
