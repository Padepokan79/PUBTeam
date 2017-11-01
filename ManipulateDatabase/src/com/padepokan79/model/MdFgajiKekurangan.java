package com.padepokan79.model;

public interface MdFgajiKekurangan {
	public final String tampilFgajiKekurangan = //added By Nurikhsan
			"SELECT TGLGAJI,NIP, GAPOKBARU,kdsatker \r\n" + 
			"FROM fgaji_kekurangan\r\n" + 
			"WHERE TGLGAJI= '2012-06-01'\r\n" + 
			"LIMIT 0,10;";
	public String tambahfGajiKekurangan = 
			"INSERT INTO fgaji_kekurangan (TGLGAJI,NIP,GAPOKBARU,kdsatker) \r\n" + 
			"values ('1997-10-29','196902102007011999',29000000,'D10200101000029     ');";
	public String updateFgajiKekurangan =
			"Update fgaji_kekurangan\r\n" + 
			"SET NIP = '196902102007011989'\r\n" + 
			"WHERE TGLGAJI = '1997-10-29';";
	public String deleteFgajikekurangan = 
			"DELETE FROM fgaji_kekurangan\r\n" + 
			"WHERE tglgaji = '97-10-29';";
	
}
