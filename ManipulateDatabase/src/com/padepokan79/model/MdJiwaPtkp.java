package com.padepokan79.model;

public interface MdJiwaPtkp {
		public final String ReadJiwaPtkp=
				"SELECT nip, tahun, jistri, janak FROM jiwaptkp;";
		public final String TambahDataJiwaPtkp=
				"INSERT INTO jiwaptkp VALUES(?, ?, ?, ?);";
		public final String searchJiwaPtkp=
				"SELECT nip, tahun, jistri, janak FROM jiwaptkp WHERE nip=?;";
		public final String UpdateTahunDataBaruJiwaPtkp=
				"UPDATE jiwaptkp SET janak=? WHERE nip=?;";
		public final String DeleteDataBaruJiwaPtkp=
				"DELETE FROM jiwaptkp WHERE nip=?;";

}
