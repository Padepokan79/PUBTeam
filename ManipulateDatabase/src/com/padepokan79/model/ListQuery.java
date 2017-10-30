package com.padepokan79.model;

public interface ListQuery {
	public final String queryNamaDanLakiJomblo = 
			"SELECT nama,bersih FROM fgaji where kdjenkel=1 limit 0,10;";
	public final String queryNamaDanStatusKawin = 
			"SELECT nama,bersih FROM fgaji where kdjenkel=1 limit 0,10;";
	public final String queryNipNamaGajiBersihDiAtas10Jt = // add by rzkypprtm
			"select nip, nama, bersih, kdpangkat from fgaji where bersih > 10000000 limit 0,10;";
	public final String queryJombloMasaKerjaDiatas10thn = // add by selfi
			"select NIP, NAMA, MASKER, KDSTAWIN FROM fgaji where MASKER > 10 and KDSTAWIN=0 limit 0,10;";
	public final String queryNamaJandaKembang = 
			"SELECT distinct nip,nama,kdstawin,janak FROM fgaji where kdstawin=3 and janak=0 limit 0,10;"; //add by siska
	public final String queryNamaUsiaAntara25Sampai35 = //add by rzkypprtm
			"SELECT nip, nama, bersih, kdpangkat, TGLLHR as usia from fgaji where kdstawin = '1' and TGLLHR <= '1992/09/14' and TGLLHR >= '1982/09/14' limit 0,10;";
	public final String queryNamaSuperDad = 
			"SELECT nip,nama,kdjenkel,tgllhr,kdpangkat,masker,janak FROM fgaji where kdjenkel = 1 and kdpangkat=1  and masker > 20 and janak > 1 limit 0,10;"; //add by siska



	//========================================================================================================================================
	// tabel 2 SATKERJA

	public final String queryNamaAtasanDRSDanJabatanCamat =  // tambahan selfi
			"SELECT SATKERJA,JAB_ATASAN,DESCSATKER,KOTA, NAMA_ATASA AS NAMA_ATASAN FROM satkerja WHERE NAMA_ATASA LIKE 'DRS%' AND JAB_ATASAN LIKE 'CAMAT%' ;";
	public final String queryKepalaDinasHaji = 
			"select SATKERJA,descsatker,nama_atasa,jab_atasan from satkerja where descsatker like '%dinas%' and nama_atasa like 'h%' ;"; //add by siska	
	public final String queryBendaharaPembantuDaftarGaji = 
			"select SATKERJA,descsatker,nip_bend,nama_bend,jab_bend,jab_operat from satkerja where jab_bend like '%pembantu%' and jab_operat like '%gaji%';"; //add by siska	
	public final String queryNamaOperatorDenganAkhiranH = // add by rzkypprtm
			"SELECT SATKERJA as Satuan_Kerja, DESCSATKER as Deskripsi, Kota, nama_opera as Nama_Operator from satkerja where nama_opera like '%h';";
	public final String queryJumlahPegawaiYangKerjaDiDinasKesehatan = // add by rzkypprtm
			"SELECT DESCSATKER as Satuan_Kerja, COUNT(*) from satkerja where DESCSATKER like '%PUSKESMAS%' or DESCSATKER like '%KESEHATAN%' GROUP BY DESCSATKER LIMIT 0,10;";



	//===========================================================================================================================================
	//tabel 3 twafat

	public final String queryNIPNamaTanggalWafat = // add by rzkypprtm
			"SELECT twafat.NIP,mstpegawai.nama,twafat.TGLWAFAT FROM twafat,mstpegawai WHERE twafat.NIP = mstpegawai.NIP AND twafat.TGLWAFAT > '2014/04/31';";
	public final String queryKdHubKelPenerimaKosong =
			"select twafat.NIP,mstpegawai.nama,twafat.TGLWAFAT,penerbit,kdhubkelpenerima from  twafat,mstpegawai where twafat.NIP = mstpegawai.NIP AND twafat.TGLWAFAT and kdhubkelpenerima=''  limit 10;"; //add by siska
	public final String queryPenerbitBukanDariLurah = // add by selfi
			"select twafat.NIP,mstpegawai.nama, twafat.PENERBIT from twafat,mstpegawai where twafat.NIP=mstpegawai.NIP AND NOT PENERBIT LIKE '%lurah%' limit 10;";
	public final String queryDaftarPegawaiYangMatiSebelumTahun2013 = // add by rzkypprtm
			"SELECT twafat.NIP,mstpegawai.nama,twafat.TGLWAFAT FROM twafat,mstpegawai WHERE twafat.TGLWAFAT < '2013/00/10' AND twafat.TGLSTOP < '2013/00/10' limit 0,10;";
	public final String queryPNSYangMatinyaPalingLama = // add by rzkypprtm
			"SELECT twafat.NIP,mstpegawai.nama,twafat.TGLWAFAT FROM twafat,mstpegawai ORDER BY twafat.TGLWAFAT asc limit 1;";

	//===========================================================================================================================================
	//tabel 4 hutang

	public final String queryNamaPegawaiYangMempunyaiHutangLebihDari10JtJumlahCicilanlebihdari1Tahun = // add by rzkypprtm
			"SELECT hutang.NIP, mstpegawai.nama as Nama, hutang.JMLHUTANG as Jumlah_Hutang, hutang.JMLBULAN FROM hutang, mstpegawai WHERE hutang.JMLHUTANG > 10000000 AND hutang.JMLBULAN > 12 limit 0,10;";
	public final String queryTampilkanJumlahPNSyangBerhutangBerdasarkanCicilan = // add by rzkypprtm
			"SELECT JMLCICILAN, COUNT(*) as JUMLAH FROM hutang GROUP BY JMLCICILAN;";
	public final String queryHutangUntukAnak =
			"select nip,kdhutang,jmlhutang,jmlcicilan,cicilanakhir,jmlbulan,tmthutang,tathutang,keterangan from hutang where keterangan like '%anak%' order by jmlhutang desc limit 10;"; //add by siska
	public final String queryHutangPalingBanyak = // add by selfi
			"SELECT hutang.NIP, mstpegawai.nama, hutang.JMLHUTANG AS JUMLAH_HUTANG from hutang,mstpegawai WHERE hutang.NIP=mstpegawai.NIP order by JUMLAH_HUTANG DESC LIMIT 10;";
	public final String queryHutangPalingbanyak = // add by selfi
			"select NIP, JMLHUTANG,JMLBULAN from hutang ORDER BY JMLBULAN AND JMLHUTANG ASC limit 10;"; 


	//===========================================================================================================================================
	//tabel 5 keluarga

	public final String queryPNSJombloWafat =
			"select nip,nmkel as Nama,tglnikah,tglwafat from keluarga where tglnikah IS NULL and tglwafat IS NOT NULL limit 10;"; //add by siska
	public final String queryPNSUsiaPernikahanPerak25tahun = // add by selfi
			"select NIP, NMKEL as NAMAKELUARGA,TGLNIKAH from keluarga where TGLNIKAH > '1992-01-01' AND TGLNIKAH < '1992-12-30';";
	public final String queryPNSjomblosejati = // add by nopan
			"select NMKEL,TGLLHR,TGLNIKAH from keluarga where TGLLHR <= '1987/09/15' AND TGLNIKAH IS NULL;";
	public final String queryKeluargaPNSyangSudahMenikahDanMempunyaiKartuSuamiIstri = // add by rzkypprtm
			"SELECT NIP, NMKEL as Nama, TGLNIKAH, NIPSUAMIISTRI FROM keluarga WHERE TGLNIKAH IS NOT NULL AND NIPSUAMIISTRI IS NOT NULL AND NOT NIPSUAMIISTRI = '';";
	public final String queryNamaKeluargaPNSyangPernahMenikahLaluCerai = // add by rzkypprtm
			"SELECT NIP, NMKEL as Nama, TGLNIKAH, TGLCERAI FROM keluarga WHERE TGLNIKAH IS NOT NULL AND TGLCERAI IS NOT NULL;";


	//===========================================================================================================================================
	//tabel 6 skpp_pegawai

	public final String queryNamaPnsYangmempunyaiAnakTapiTidakMempunyaiIstri = // add by novan
			"select NIP,NAMA,TJISTRI,TJANAK from skpp_pegawai where TJISTRI = 0 AND TJANAK > 0;";
	public final String queryNamaPnsYangPensiunTahunIni = // add by selfi
			"select NIP,NAMA,TMTPENSIUN from skpp_pegawai WHERE TMTPENSIUN >= '2017-01-01'  AND TMTPENSIUN <= '2017-12-31' LIMIT 50;";
	public final String queryNamaPNSYangSkepnyaDiterbitkanOlehPresiden = //add by siska
			"select distinct nip,nama,tgllhr as Tanggal_Lahir, tmtstop as Tanggal_Berhenti,kdpangkat as Pangkat,masker as Masa_Kerja,penerbitskep as Penerbit from skpp_pegawai where masker > '20' and tmtstop < '2012-06-31' and penerbitskep like '%Presiden%' limit 10;";
	public final String queryTampilkanJumlahSKPP_PNSberdasarkanKodePangkat = // add by rzkypprtm
			"SELECT KDPANGKAT as Kode_Pangkat, COUNT(*) as Jumlah_PNS FROM skpp_pegawai GROUP BY KDPANGKAT ORDER BY KDPANGKAT, COUNT(*);";
	public final String queryTampilkanJumlahSuratSKPPberdasarkanPenerbitnya = // add by rzkypprtm
			"SELECT PENERBITSKEP as PENERBIT , COUNT(*) as Jumlah_Surat FROM skpp_pegawai GROUP BY PENERBITSKEP ORDER BY PENERBITSKEP, COUNT(*) desc;";

	//==========================================================================================================================================================================
	//Tabel 7 fgaji_uangduka


	public final String queryNamaPNSyangMeninggaldanUangDukaDibayarSetelah1MingguSesudahWafat = // add by rzkypprtm ? = 7(1minggu)
			"SELECT  b.NIP, a.NAMA, b.TGLWAFAT, b.TGLBAYAR FROM mstpegawai a, fgaji_uangduka b WHERE a.NIP = b.NIP AND (TGLBAYAR-TGLWAFAT) <= ? LIMIT ?, 10;";
	public final String queryTGLWafatDanUangBersihLebihDari1Jt = // add by selfi, ? 2016-01-01 (sesuai tahun dan bulan)  , ?= sesuai Nominal gaji
			"select NIP,TGLWAFAT,BERSIH from fgaji_uangduka where TGLWAFAT > ? AND BERSIH > ? limit 0,10;";
	public final String queryNamaPNSYangMeningglTanpaTunjanganAnakIstri = // add by siska
			"select distinct fgaji_uangduka.NIP,mstpegawai.NAMA as Nama,tglwafat,tjistri,tjanak  from fgaji_uangduka,mstpegawai where fgaji_uangduka.NIP = mstpegawai.NIP and tjistri=? and tjanak=? limit 0,10;";
	public final String queryPnsWafatLebihdar4thnYangmempunyaiIstriTidakMempunyaiAnak = // add by novan
			"select NIP,TGLWAFAT,TJISTRI,TJANAK from fgaji_uangduka where TGLWAFAT <= ? AND (TJISTRI > ? AND TJANAK = ?) ;";
	public final String queryJumlahPNSYangTidakMempunyaiTunjanganEselonDanTunjanganFungsi = // add by rzkypprtm 
			"SELECT COUNT(TJESELON) as JUMLAH_PNS_NonTJSESLON_NonTJFUNGSI FROM fgaji_uangduka WHERE TJESELON = '0' AND TJFUNGSI = '0' LIMIT ?, 10;";


	//==========================================================================================================================================================================
	//Tabel 8 data_rapel

	public final String queryGroupByGapokPNS = // add by siska
			"select gapok, count(*) as Jumlah_PNS from data_rapel where gapok > ? group by gapok limit 100;"; // di database ? = 300.000
	public final String queryGroupKodeSatuanKerjaNamaSatuanKerjaDanJumlahPNSNya = // add by rzkypprtm
			"SELECT KDSATKER as Kode_Satuan_Kerja , NAMASATKER as Nama_Satuan_Kerja , COUNT(*) as Jumlah_PNS FROM data_rapel GROUP BY KDSATKER;"; // 
	public final String queryMenampilkanDataYangDibayarkanSatuBulanSetelahDataAwal =// add by selfi 
			"SELECT NIP, NAMA, AWAL, AKHIR FROM data_rapel where AWAL LIKE ? AND AKHIR LIKE ? LIMIT ?,10;"; // ? '2009-01-01' . ? '2009-02-01' . ? LIMIT
	public final String queryMenampilkanDataNamaYangHurufAwalADanPangkat3D = // Add by selfi
			"SELECT NIP, NAMA, KDPANGKAT FROM data_rapel WHERE NAMA LIKE ? AND KDPANGKAT LIKE ? limit ?,10;"; // ?1.= A, ?2=3D ,?3=Untuk limit
	public final String queryMenampilkanPNSyangJenisKElaminNULLdanBukanPriadaWanita = // add by rzkypprtm
			"SELECT KDSATKER as Kode_Satuan_Kerja, NIP, NAMA, TGLLHR as Tanggal_Lahir FROM data_rapel WHERE KDJENKEL is NULL AND TGLLHR is NOT NULL OR KDJENKEL = '3' ORDER BY KDJENKEL;";


	//==========================================================================================================================================================================
	//Tabel 9 urtnip

	public final String queryMenampilkanPNSYangPunyaNPWPTempatLahirdanAgama = //add by siska
			"select nip_v as NIP,v_nama as Nama, v_npwp as NPWP, v_tmp_lahir as Tempat_Lahir,c_jns_kelamin as JenKel,c_agama as Agama, c_golongan as Golongan from urtnip where v_npwp IS NOT NULL and v_tmp_lahir IS NOT NULL and c_agama IS NOT NULL limit ?, 10;";
	public final String queryMenampilkanTempatLahirDiLimaPuluhDanJenisKelaminPerempuan = // add by selfi
			"SELECT nIP_V, V_NAMA, V_TMP_LAHIR, C_JNS_KELAMIN  FROM urtnip where V_TMP_LAHIR LIKE '?' AND C_JNS_KELAMIN LIKE '?' limit ?,10;"; // ?1 nama tempat lahir, ?2. jeniskelamin ?3. lIMIT
	public final String queryMenampilkanPNSpunyaNPWPdanMasaKerjaLama = //add by siska
			"select nip_v as NIP,v_nama as Nama, v_npwp as NPWP, n_masakerja as Masa_Kerja, c_golongan as Golongan,c_jbt_struktur as Jab_Struktur from urtnip where v_npwp IS NOT NULL  and n_masakerja > ? limit ?, 10;"; // nb : di database ? = 20 
	public final String queryMenampilkanJumlahPNSberdasrkanAgamadanGolongan = //add by rzkypprtm
			"SELECT C_AGAMA as AGAMA, C_GOLONGAN as GOLONGAN, COUNT(*) as Jumlah FROM urtnip GROUP BY C_AGAMA, C_GOLONGAN ORDER BY C_AGAMA, C_GOLONGAN, COUNT(*) LIMIT ?, 10;";
	public final String queryMenampilkanGroupByAgama = //add by siska
			"select c_agama as Agama, count(*) as Jumlah_PNS from urtnip group by c_agama limit ?, 10;";


	//==========================================================================================================================================================================
	//Tabel 10 historis_eselon

	public final String queryMenampilkanRatarataTunjanganEselon = //add by siska
			"select avg(tjeselon) as Tunjangan_Eselon from historis_eselon;";
	public final String queryMenampilkanDaftarPNSYangMempunyaiKodeEselonBersuratKeputusan = //add by rzkypprtm
			"SELECT a.NIP, b.NAMA, a.KDESELON, a.TJESELON, a.NOMORSKEP, a.PENERBITSKEP FROM historis_eselon a,mstpegawai b WHERE NOT a.KDESELON = '00' AND NOT a.NOMORSKEP = ' ' LIMIT ?, 10;";
	public final String queryTJEselonYangNolBukanNull = // add by selfi
			"select NIP,TJESELON from historis_eselon where TJESELON = 0 order by TJESELON limit ?,10;"; 
	public final String queryMenampilkanJumlahPNSyangMempunyaiTunjanganEselonberdasrakanInputanBatasKecildanBatasBesar = //add by rzkypprtm ?1=batas bawah, ?2=batas atas, ?3=Limit
			"SELECT TJESELON, COUNT(*) as JUMLAH FROM historis_eselon WHERE TJESELON >= ? AND TJESELON <= ? GROUP BY TJESELON limit ?,10;";
	public final String queryMenampilkanHistorisSkep = //add by siska
			"select distinct a.NIP,b.NAMA,a.nomorskep,a.penerbitskep,a.keterangan,a.tglupdate from historis_eselon a,fgaji b where tglskep IS NOT NULL and NOT penerbitskep='' and nomorskep IS NOT NULL and NOT keterangan='' and a.NIP = b.NIP  limit ?,10;";




	//==========================================================================================================================================================================
	//Tabel 11 detil_kekurangan

	public final String queryMenampikanMaskerDibawah5TahunDanGajiDiatas25jt = // Add by selfi
			"select DISTINCT detil_kekurangan.NIP, mstpegawai.NAMA , detil_kekurangan.MASKER , detil_kekurangan.GAPOK from detil_kekurangan left join mstpegawai ON detil_kekurangan.NIP = mstpegawai.NIP where detil_kekurangan.masker < ? and detil_kekurangan.GAPOK  > ? limit 20;"; // ?1 maske ?2 GAPOK
	public final String queryMenampilkanJenisKekuranganYangLebihDariSatu = // add by selfi
			"select NIP, JENISKEKURANGAN from detil_kekurangan where JENISKEKURANGAN > ? ORDER BY JENISKEKURANGAN ASC limit 0,10;"; // ? jeniskekurangan = angka 1 atau lebih
	public final String queryJumlahPNSBerdasarkanGolonganJumlahAnakJumlahIstri = // add by rzkypprtm
			"SELECT KDPANGKAT as Kode_Pangkat, JISTRI as Jumlah_Istri, JANAK as Jumlah_Anak, COUNT(*) as JUMLAH FROM detil_kekurangan WHERE NOT KDPANGKAT = '' GROUP BY KDPANGKAT, JISTRI, JANAK LIMIT 0 , 10;";
	public final String queryMenampilkanDaftarTanggalBayarberdasarkanInput = // add by rzkypprtm ?1 = batas awal ?2=batas akhir
			"SELECT detil_kekurangan.NIP, mstpegawai.NAMA, detil_kekurangan.TGLBAYAR FROM detil_kekurangan, mstpegawai WHERE TGLBAYAR >= ? and TGLBAYAR <= ? GROUP BY TGLBAYAR LIMIT ? , 10;";
	public final String queryMencariKodePangkatdanMengurutkanUPDSTAMP = // add by siska ? untuk kdpangkat bisa diisi 1/2/3/4 
			"select distinct a.tglbayar, a.NIP, b.NAMA, a.jeniskekurangan,a.dari,a.sampai,a.kdpangkat,a.UPDSTAMP from detil_kekurangan a, mstpegawai b where a.kdpangkat like '%?%' and a.NIP = b.NIP  order by a.UPDSTAMP desc limit ?,10;";


	//==========================================================================================================================================================================
	//Tabel 12 form_1721_a2


	public final String queryMencariTahunPajakdanJabatanGolongan = // add by siska contoh : ? tahun pajak = 2015 , ? jabatan_gol = utama
			"select tahun_pajak,nourt,nama_peg,jabatan_gol,awal_pajak,akhir_pajak from form_1721_a2 where tahun_pajak='?' and jabatan_gol like '%?%' order by nourt desc limit ?,10;";
	public final String queryMenunjukanJumlahJabatanPNSyangsudahbayardanBelum = // add by rzkypprtm
			"SELECT JABATAN_GOL, Status, COUNT(*) as JUMLAH_PNS_YG_BELUM_BAYAR FROM form_1721_a2 GROUP BY JABATAN_GOL, Status  ORDER BY JABATAN_GOL;";
	public final String queryMenampilkanStatusYangBelumBayarPajakDanLakiLaki = // add by selfi
			"select * from form_1721_a2 where status like ? and sex like ? order by Tahun_Pajak ASC  limit ?,10;"; // ?1 0/1 ?2 1/2
	public final String queryMenampilkanYangSudahAdaNPWP = // Add by selfi
			"select * from form_1721_a2 where not Npwp_Peg like '0%' and not Npwp_Peg like '' limit ?,10;"; // 
	public final String queryMenampilkanStatusBerdasarkanGenderdanJumlahKeluarga = // Add by siska contoh : ? sex = 1/2 ? jml_kel = 1/2/3
			"select nip,nama_peg,jabatan_gol,sex,jml_kel as Jumlah_Keluarga,status from form_1721_a2 where sex='?' and jml_kel='?' order by nourt desc limit ?,10;";

	//==========================================================================================================================================================================
	//Tabel 13 From Agama_tbl add by Hendra YN
	public final String queryMencariNamaAgama = 
			"select kdagama as KodeAgama, nmagama as NamaAgama from agama_tbl where kdagama = ?;"; // 1. KodeAgama = 1/2/3/4/5/6 2. limit next page

	//==========================================================================================================================================================================
	//Tabel 14 From akunsp2d add by Hendra YN
	public final String queryMencariBerdasakanKDSKPDdiAkunsp2d =
			"select kdssbp as KodeSSBP, kdskpd as KodeSKPD, kdtrans as KodeTRANS, kdakun  as KodeAkun, nmakun as NamaAkun from akunsp2d where not kdskpd = ' ' and kdskpd = ? limit ?,10;";
	// ? 1. KodeSKPD 1 sampai 49 ? 2. limit page
	public final String queryMencariBerdasakanKDTRANSdiAkunsp2d =
			"select kdssbp as KodeSSBP, kdskpd as KodeSKPD, kdtrans as KodeTRANS, kdakun  as KodeAkun, nmakun as NamaAkun from akunsp2d where not kdskpd = ' ' and kdtrans = ? limit ?,10;";
	// ? 1. KodeTRANS 101 s/d 112 201 s/d 206
	public final String queryListKDTransdiAkunsp2d =
			"select distinct kdtrans as KodeTRANS, nmakun as NamaAkun, kdakun as KodeAkun from akunsp2d where kdtrans = ? limit ?,10;";
	// ? 1. Kode Trans 101 s/d 112 201 s/d 206


	//=================================================================================================================================================================================
	//Tabel 15 t_tunjangan add by rzkypprtm

	public final String queryMenampilkanJumlahPNSYangPensiunBerdasarkanKodeJabatandanUsiaJabatan =
			"SELECT KDJAB as Kode_Jabatan, PENSIUN as Usia_Pensiun, COUNT(*) as jumlah FROM t_tunjangan WHERE NOT PENSIUN is Null AND NOT PENSIUN = '0' GROUP BY KDJAB, PENSIUN ORDER BY KDJAB LIMIT ?, 10;";
	public final String queryMenampilkanJumlahPNSYangPensiunBerdasarkanJumlahUangPensiun =
			"SELECT JML as Jumlah , COUNT(*) as Jumlah_PNS FROM t_tunjangan WHERE JML >= ? AND JML <= ? GROUP BY JML ORDER BY JML LIMIT ?, 10;";
	public final String queryMenampilkanPNSyangPensiunKurangdariUsia60 =
			"SELECT * FROM t_tunjangan WHERE PENSIUN < '60' LIMIT 10;";


//==========================================================================================================================================================================
//Tabel 16 From unitkerja add by selfi
		public final String queryNIPAtasanDanJabatanAtasanDanNamaAtasanTidakKosong =
				"select satkerja AS SATUANKERJA, unit, NIP_ATASAN, JAB_ATASAN, NAMA_ATASA as NAMA_ATASAN from UNITKERJA WHERE NOT NIP_ATASAN LIKE '' AND NOT JAB_ATASAN LIKE '' AND NOT NAMA_ATASA LIKE '' LIMIT ?,10;";
		public final String queryMenampilkanBerdasarkanNamaJabatanAtasan = 
				"select SATKERJA, UNIT, KOTA,  JAB_ATASAN, NAMA_ATASA AS NAMA_ATASAN from unitkerja where JAB_ATASAN like '?%' limit ?,10;"; // ?1 namaAtasan ?2 limit ?
		public final String queryMenampilkanBerdasarkanNamaBendahara = 
				"select SATKERJA, UNIT, KOTA, if (JAB_ATASAN = '', 'SAYA ATASAN', JAB_ATASAN),  NAMA_ATASA AS NAMA_ATASAN, NAMA_BEND AS NAMA_BENDAHARA from unitkerja where NAMA_BEND like '?%'  limit ?,10;"; // ?1. NamaBendahara ?2. limit 
		public final String queryMenampilkanBerdasarkanNamaOperator =
				"select SATKERJA, UNIT, KOTA,  JAB_ATASAN, NAMA_ATASA AS NAMA_ATASAN, NAMA_OPERA AS NAMA_OPERATOR from unitkerja where NAMA_OPERA like '?%' limit ?,10;"; // ?1. NamaOperator ?2. limit
		
//=======================================================================================================================================================================================
//Tabel 17 F_spt add by rzkypprtm
			
		public final String queryMencariPNSberdasarkanNoUrut =
				"SELECT * FROM f_spt WHERE nourt = ?;"; // ?=no urut, tanpa limit karena hanya akan memunculkan 1 record 
		public final String queryMencariPNSberdasrkanNamaDanKDSKPDsecaraBersanaan =	
				"SELECT * FROM f_spt WHERE nama LIKE '%?%' OR kdskpd LIKE '%?%' LIMIT ?, 10;"; // ?1 = nama PNS yang di cari, ?2 = kdskdp yang di cari

//==========================================================================================================================================================================

//Tabel 18 From umum_tbl add by selfi
		public final String queryMencariTJUmumBerdasarkanKodeGolongan = 
					"select * from umum_tbl where KDGOL = ?  limit ?,10;"; // ?1. KDGOL 1/2/3/4 ?2. AwalLimit
//==========================================================================================================================================================================
//Tabel 19 From hak_akses add by selfi

		public final String queryMenghitungJumlahHakAksesBerdasarkanPemakai =
				"select pemakai, count(*) as jumlah_hak_akses from hak_akses where not pemakai =' ' group by pemakai;"; 
		public final String queryMencariYangMenggunakanKodeHakAkses =
				"select * from hak_akses where kodeakses > ? LIMIT ?,10;"; // ?1 kodehakakses contoh 12 . ?2 limit 

//Tabel 20 From guru_tbl add by Hendra YN
		public final String queryMencariKodeGurudiTabelGuruTBL =
				"select kdGuru as KodeGuru, nmguru as NamaGuru From guru_tbl where kdguru = ? and nmguru is not null;";
				//?1. Kode guru 1 s.d 17 ?2. limit
		
//Tabel 21 From automut add by siska
		public final String queryMencariTanggalPensiundanKodeStapeg = // ? tglpensiun = 2010-01-01, ? kdstapeg = 4
				"select automut.nip, mstpegawai.nama, automut.kdstapeg_l , automut.TGLPENSIUN from automut inner join mstpegawai on automut.nip = mstpegawai.nip where TGLPENSIUN < ? and kdstapeg_l=? limit ?,10;";
		public final String queryKodeStapegdanNamaStapeg = // ? = 2015-01-01 (contoh format)
				"select automut.nip, mstpegawai.nama, automut.kdstapeg_l as Kode_Status_Pegawai , stapeg_tbl.NMSTAPEG, automut.TGLPENSIUN from automut,mstpegawai,stapeg_tbl where TGLPENSIUN < ? and NOT TGLPENSIUN like '%0000%' and automut.kdstapeg_l  = stapeg_tbl.KDSTAPEG  and automut.nip=mstpegawai.nip limit 10;";

}			
