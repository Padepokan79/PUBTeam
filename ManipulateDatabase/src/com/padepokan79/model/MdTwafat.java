package com.padepokan79.model;

public interface MdTwafat {
	public final String queryMenampilkanData = 
			"select nip,tglwafat,nosurat,penerbit from twafat;";
	public final String queryMencariData = 
			"select nip,tglwafat,nosurat,penerbit from twafat where nosurat = ?;";
	public final String queryMenambahData = 
			"insert into twafat values(?,?,?,?,?,?,?,?,?);";
	public final String queryMengubahData = 
			"update twafat set penerbit=? where nosurat=?;";
	public final String queryMenghapusData = 
			"delete from twafat where nosurat=?;";
}
