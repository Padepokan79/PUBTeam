package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.SkppPegawai;

public class MainSKPP {
	 BufferedReader dataIn = new BufferedReader(new InputStreamReader( System.in) );
	 MainActivity ma=new MainActivity();
	 public MainSKPP() {
		 mainMenu();
	 }
	public  void mainMenu () {//Modify by Ipin

		System.out.println("+----------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                      Submenu SKPP                                                |");
		System.out.println("|----------------------------------------------------------------------------------------------------------|");
		System.out.println("| 1. Nama Operator dengan Akhiran H | 2. Nama Atasan bergelar Drs.dan Menjadi camat | 3. Kepala Dinas Haji |");
		System.out.println("|----------------------------------------------------------------------------------------------------------|");
		System.out.println("| 4. Pegawai Dinas Kesehatan        | 5. Bendahara Pendaftran Haji                  | 0. Menu Utama        |");
		System.out.println("+----------------------------------------------------------------------------------------------------------+");

		try {
			System.out.print("Masukan PIlihan : ");
			String input=dataIn.readLine();
			switch (input) {
			case "1":
				//namaOperatorDenganAkhiranH();
				break;
			case "2":
				//getqueryNamaAtasanDRSDanJabatanCamat();
				break;
			case "3":
				//kepalaDinasHaji();
				break;
			case "4":
				//JumlahPegawaiYangKerjaDiDinasKesehatan();
				break;
			case "5":
				//testBendaharaPembantuDaftarGaji();
				break;
			case "0":
				ma.menuUtama();
				break;
			default:
				System.out.println("Masukan anda tidak valid !");
			}

		} catch (Exception e) {
			System.out.println("Exception Print !");
			System.out.println(e.getMessage());
		}

	}

	public  void backto()  {
		String inp;
		System.out.print("1. Menu Utama 2. Submenu Satuan Kerja  : ");
		try {
			inp=dataIn.readLine();
			switch (inp) {
			case "1":
				ma.menuUtama();;
				break;
			case "2":
				mainMenu();
				break;
			default:
				System.out.println("Masukan Salah !");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public  void testNamaPnsYangmempunyaiAnakTapiTidakMempunyaiIstri(){
		SkppPegawai objskp =new SkppPegawai();

		JSONArray data = objskp.getNamaPnsYangmempunyaiAnakTapiTidakMempunyaiIstri(); 

		showData_Duda(data,"nip","nama","tjistri","tjanak");
	} // Yusup  added test for NamaKeluargaPNSyangPernahMenikahLaluCerai

	public  void showData_Duda(JSONArray arrayData, String fNip, String fNama, String Ftjis, String ftjanak) {
		//System.out.println(arrayData);
		System.out.println("+--------------------------------------------------------------------------------------+");
		System.out.println("|         NIP         |            Nama              |Tunjangan Istri|  Tunjangan Anak |");
		System.out.println("+--------------------------------------------------------------------------------------+");
		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(fNip);
			System.out.print("| "+space);

			space=(String) obj.get(fNama);
			space = space.trim();
			System.out.print("  | "+space);
			for (int j = 0; j  <27-(space.length()); j++) {
				System.out.print(" ");
			}

			tamp =(int) obj.get(Ftjis);
			space =space.valueOf(tamp);
			System.out.print("  |       "+ space);
			for (int j = 0; j  <8-(space.length()); j++) {
				System.out.print(" ");
			}
			tamp =(int) obj.get(ftjanak);
			space =space.valueOf(tamp);
			System.out.print("|       "+space);
			for (int j = 0; j  <8-(space.length()); j++) {
				System.out.print(" ");
			}

			System.out.println("  |");
			System.out.println("+--------------------------------------------------------------------------------------+");
		}
	}//Yusup Add ShowData Hehe...


	public  void testNamaPnsYangPensiunTahunIni(){
		SkppPegawai objskp =new SkppPegawai();

		JSONArray data = objskp.getNamaPnsYangPensiunTahunIni(); 

		showData_YangpensiunTahunini(data,"nip","nama","tmtpensiun");
	} // Yusup  added test for NamaPnsYangPensiunTahunIni

	public  void showData_YangpensiunTahunini(JSONArray arrayData, String fNip, String fNama, String Ftmtpensiun) {
		//System.out.println(arrayData);
		System.out.println("+-------------------------------------------------------------------------------+");
		System.out.println("|         NIP         |             Nama            |Tanggal Mulai Tugas Pensiun|");
		System.out.println("+-------------------------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(fNip);
			System.out.print("| "+space);

			space=(String) obj.get(fNama);
			space = space.trim();
			System.out.print("  | "+space);
			for (int j = 0; j  <26-(space.length()); j++) {
				System.out.print(" ");
			}


			System.out.print("  |         "+ obj.get(Ftmtpensiun));
			System.out.println("        |");
			System.out.println("+-------------------------------------------------------------------------------+");
		}
	}//Yusup Add ShowData Hehe...

	public  void testNamaPNSYangSkepnyaDiterbitkanOlehPresiden(){
		SkppPegawai objskp =new SkppPegawai();

		JSONArray data = objskp.getNamaPNSYangSkepnyaDiterbitkanOlehPresiden(); 

		showData(data,"nip","nama","tanggal_lahir","tanggal_berhenti","pangkat","masa_kerja","penerbit");
	} // Yusup  added test for NamaPNSYangSkepnyaDiterbitkanOlehPresiden

	public  void showData(JSONArray arrayData, String fNip, String fNama, String Ftgllahir, String ftglhenti, String Fpkt, String Fmasa_k, String Fpnerbit) {
		//System.out.println(arrayData);
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|         NIP         |              Nama             |Tanggal Lahir|Tanggal Berhenti|  Pangkat  |Masa Kerja|              Penerbit          |");
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(fNip);
			System.out.print("| "+space);

			space=(String) obj.get(fNama);
			space = space.trim();
			System.out.print("  | "+space);
			for (int j = 0; j  <28-(space.length()); j++) {
				System.out.print(" ");
			}


			System.out.print("  | "+ obj.get(Ftgllahir));
			for (int j = 0; j  <5-(space.length()); j++) {
				System.out.print(" ");
			}

			System.out.print("  |   "+obj.get(ftglhenti));
			for (int j = 0; j  <10-(space.length()); j++) {
				System.out.print(" ");
			}

			space=(String) obj.get(Fpkt);
			space = space.trim();
			System.out.print("   |    "+space);
			for (int j = 0; j  <5-(space.length()); j++) {
				System.out.print(" ");
			}



			System.out.print("  |    "+obj.get(Fmasa_k));
			for (int j = 0; j  <3-(space.length()); j++) {
				System.out.print(" ");
			}

			space=(String) obj.get(Fpnerbit);
			space = space.trim();
			System.out.print("   |  "+space);
			for (int j = 0; j  <10-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("   |");
			System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------+");
		}
	}//Yusup Add ShowData Hehe...

	public  void testTampilkanJumlahSKPP_PNSberdasarkanKodePangkat(){
		SkppPegawai objskp =new SkppPegawai();

		JSONArray data = objskp.getTampilkanJumlahSKPP_PNSberdasarkanKodePangkat(); 

		showData(data,"kode_pangkat","jumlah_pns");
	} // Yusup  added test for NamaPnsYangPensiunTahunIni

	public  void showData(JSONArray arrayData, String fkdPns, String fjmlPns) {
		//System.out.println(arrayData);
		System.out.println("+-----------------------+");
		System.out.println("|Kode Pangkat|Jumlah PNS|");
		System.out.println("+-----------------------+");
		String space;
		long tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(fkdPns);
			System.out.print("|     "+space);

			tamp =(long) obj.get(fjmlPns);
			space = space.valueOf(tamp);
			System.out.print("     |   "+space);
			for (int j = 0; j  <4-(space.length()); j++) {
				System.out.print(" ");
			}


			System.out.println("   |");
			System.out.println("+-----------------------+");
		}
	}//Yusup Add ShowData Hehe...


	public  void testTampilkanJumlahSuratSKPPberdasarkanPenerbitnya(){
		SkppPegawai objskp =new SkppPegawai();

		JSONArray data = objskp.getTampilkanJumlahSuratSKPPberdasarkanPenerbitnya(); 

		showData_skpp(data,"penerbit","jumlah_surat");
	} // Yusup  added test for testTampilkanJumlahSuratSKPPberdasarkanPenerbitnya()

	public  void showData_skpp(JSONArray arrayData, String fpenerbit, String fjmls) {
		//System.out.println(arrayData);
		System.out.println("+--------------------------------------------------+");
		System.out.println("|                Penerbit             |Jumlah Surat|");
		System.out.println("+--------------------------------------------------+");
		String space;
		long tamp;
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(fpenerbit);
			System.out.print("| "+space);
			for (int j = 0; j  <36-(space.length()); j++) {
				System.out.print(" ");
			}
			tamp =(long) obj.get(fjmls);
			space = space.valueOf(tamp);
			System.out.print("|     "+space);
			for (int j = 0; j  <6-(space.length()); j++) {
				System.out.print(" ");
			}

			System.out.println(" |");
			System.out.println("+--------------------------------------------------+");
		}
	}//Yusup Add ShowData Hehe...

}
