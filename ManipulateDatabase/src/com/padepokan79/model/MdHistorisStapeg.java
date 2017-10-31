package com.padepokan79.model;

public interface MdHistorisStapeg {
	public final String InsertDataHistorisStapeg = "insert into historis_stapeg(tmtgaji, nip, kdstapeg, keterangan) values (?,?,?,?);";
	public final String CariDataHistorisStapeg = "select tmtgaji, nip, kdstapeg, keterangan from historis_stapeg where nip=? limit 0,10;";
	public final String UpdateDataHistorisStapeg = "update historis_stapeg set kdstapeg = ? where nip = ?;";
	public final String DeleteDataHistorisStapeg = "delete from historis_stapeg where nip = ?;";
	public final String SelectDataHistorisStapeg = "select tmtgaji, nip, kdstapeg, keterangan from historis_stapeg limit 0,10;";

}
