package com.padepokan79.model;

public interface MdAkunKonv {
	public final String CreateData= 
			"insert into akun_konv values (?,?)";
	public final String ReadData=
			"select * from akun_konv";
	public final String UpdateData=
			"update akun_konv set urt=? where kdtrans=?";
	public final String DeleteData=
			"delete from akun_konv where kdtrans=?";
	public final String SearchData=
			"select * from akun_konv where kdtrans=?";
}
