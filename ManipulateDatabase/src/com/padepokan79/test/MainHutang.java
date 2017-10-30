 package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.Hutang;

public class MainHutang {
	 BufferedReader dataIn = new BufferedReader(new InputStreamReader( System.in) );
	 MainActivity ma=new MainActivity();
	 
	 public MainHutang() {
		 mainMenu();
	 }
	 
	public  void mainMenu () {//Modify by Ipin

		System.out.println("+-----------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                      Submenu Hutang                                                       |");
		System.out.println("|-----------------------------------------------------------------------------------------------------------|");
		System.out.println("| 1. PNS yang Memiliki Hutang Lebih Dari 10 Jt | 2. PNS dengan Hutang Paling Banyak | 3. Cicilan Hutang PNS |");
		System.out.println("|-----------------------------------------------------------------------------------------------------------|");
		System.out.println("| 4. Hutang Untuk Anak                         | 5. Hutang berdasarkan Cicilan      | 0. Menu Utama         |");
		System.out.println("+-----------------------------------------------------------------------------------------------------------+");

		try {
			System.out.print("Masukan PIlihan : ");
			String input=dataIn.readLine();
			switch (input) {
			case "1":
				getqueryNamaPegawaiYangMempunyaiHutangLebihDari10JtJumlahCicilanlebihdari1Tahun();
				break;
			case "2":
				queryHutangPalingBanyak();
				break;
			case "3":
				queryHutangPalingbanyak();
				break;
			case "4":
				queryHutangUntukAnak();
				break;
			case "5":
				getTampilanJumlahPNSyangBerhutangBerdasarkanCicilan();
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

	public  void getqueryNamaPegawaiYangMempunyaiHutangLebihDari10JtJumlahCicilanlebihdari1Tahun(){
		Hutang hutang = new Hutang();
		JSONArray data = hutang.getQueryNamaPegawaiYangMempunyaiHutangLebihDari10JtJumlahCicilanlebihdari1Tahun();
		//System.out.println(data);
		showData4Parameter(data,"nip", "nama", "jumlah_hutang","jmlbulan");
	} // By Indra

	/*JMLCICILAN, COUNT(*) as JUMLAH*/
	public  void getTampilanJumlahPNSyangBerhutangBerdasarkanCicilan(){
		Hutang hutang = new Hutang();
		JSONArray data = hutang.getQueryTampilkanJumlahPNSyangBerhutangBerdasarkanCicilan();
		showData2Parameter(data,"jmlcicilan", "jumlah");
	}

	public  void queryHutangPalingBanyak(){
		Hutang hutang = new Hutang();
		JSONArray data = hutang.getQueryHutangPalingBanyak();
		showData2Parameter(data,"nip","nama","jumlah_hutang");
	} // ikan added test for NamaDanGajiBersih

	public  void queryHutangPalingbanyak(){
		Hutang hutang = new Hutang();
		JSONArray data = hutang.getQueryHutangPalingbanyak();
		showData3Parameter(data,"nip","jmlbulan","jmlhutang");
	} // ikan added test for NamaDanGajiBersih


	//"SELECT nip,nama,kdstawin,janak FROM fgaji where kdstawin=3 and janak=0 limit 0,10;"
	public  void queryHutangUntukAnak(){
		Hutang hutang = new Hutang();
		JSONArray data = hutang.getQueryHutangUntukAnak();
		//System.out.println(data);
		showData9Parameter(data,"nip","kdhutang","jmlhutang","jmlcicilan","cicilanakhir","jmlbulan","tmthutang","tathutang","keterangan");
	}

	public  void showData4Parameter(JSONArray arrayData,String fielda, String fieldb, String fieldc, String fieldd) {
		//System.out.println(arrayData);
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|            NIP           |            Nama          |  Jumlah Hutang   | Jumlah Bulan | ");
		System.out.println("+---------------------------------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(fielda);
			space = space.trim();
			System.out.print("|"+space);
			for (int j = 0; j  <26-(space.length()); j++) {
				System.out.print(" ");
			}

			space=(String) obj.get(fieldb);
			space = space.trim();
			System.out.print("|"+space);
			for (int j = 0; j  <26-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("|");
			System.out.print(obj.get(fieldc));
			for (int j = 0; j  <25-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("|");
			space = space.trim();
			System.out.print(obj.get(fieldd));
			for (int j = 0; j  <27-(space.length()); j++) {
				System.out.print(" ");
			}

			System.out.println("|");
			space = space.trim();
			for (int j = 0; j  <10-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("+----------------------------------------------------------------------------------------+");
		}
	}	
	
	public  void showData2Parameter(JSONArray arrayData,String fielda,String fieldb,String fieldc) {
		//System.out.println(arrayData);
		System.out.println("+----------------------------------------------------------------------------+");
		System.out.println("|          NIP         |                NAMA             |   Jumlah Hutang   |");
		System.out.println("+----------------------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	


			space=(String) obj.get(fielda);
			space = space.trim();
			System.out.print("|"+space);
			for (int j = 0; j  <22-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldb);
			space = space.trim();
			System.out.print("|"+space);
			for (int j = 0; j  <33-(space.length()); j++) {
				System.out.print(" ");
			}


			System.out.print("|");
			System.out.print(obj.get(fieldc));
			System.out.println("           |");

			System.out.println("+----------------------------------------------------------------------------+");

		}
	}	

	public  void showData3Parameter(JSONArray arrayData,String fielda,String fieldb,String fieldc) {
		//System.out.println(arrayData);
		System.out.println("+-----------------------------------------------------------+");
		System.out.println("|          NIP         |  Jumlah Bulan |   Jumlah Hutang    |");
		System.out.println("+-----------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	


			space=(String) obj.get(fielda);
			space = space.trim();
			System.out.print("|"+space);
			for (int j = 0; j  <22-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("|        ");
			System.out.print(obj.get(fieldb));

			System.out.print("      |");


			System.out.print(obj.get(fieldc));

			System.out.println("            |");

			System.out.println("+----------------------------------------------------------+");

		}
	}	

	//belum di benerin
	/*JMLCICILAN, COUNT(*) as JUMLAH*/
	public  void showData2Parameter(JSONArray arrayData,String fielda,String fieldb) {
		//System.out.println(arrayData);
		System.out.println("+-------------------------------------+");
		System.out.println("|  Besaran Cicilan  |  Jumlah Cicilan |");
		System.out.println("+-------------------------------------+");
		String space,tmp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);

			space=String.valueOf(obj.get(fielda));
			tmp=String.valueOf(obj.get(fieldb));
			space=space.trim();
			tmp=tmp.trim();
			System.out.print("|      "+space);
			for (int j = 0; j  <8-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("     |       "+tmp);
			for (int j = 0; j  <3-(tmp.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("       |");
			System.out.println("+-------------------------------------+");

		}
	}	


	public  void showData9Parameter(JSONArray arrayData,String fielda,String fieldb,String fieldc,String fieldd,String fielde,String fieldf,String fieldg,String fieldh,String fieldi) {
		//System.out.println(arrayData);
		System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|          NIP         |Kode Hutang| Jumlah Hutang |Jumlah Cicilan | Cicilan Akhir | jmlbulan | tmthutang | tathutang |                         keterangan                          |");
		System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		String space;
		int tmp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	


			space=(String) obj.get(fielda);
			System.out.print("|"+space);
			for (int j = 0; j  <22-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("|     ");
			System.out.print(obj.get(fieldb));
			System.out.print("     |");
			for (int j = 0; j  <15-(space.length()); j++) {
				System.out.print(" ");
			}

			tmp=(int)(obj.get(fieldc));
			space=space.valueOf(tmp);
			System.out.print(tmp);
			for (int j = 0; j  <15-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("|");
			tmp=(int)(obj.get(fieldd));
			space=space.valueOf(tmp);
			System.out.print(tmp);
			for (int j = 0; j  <15-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("|");
			tmp=(int)(obj.get(fielde));
			space=space.valueOf(tmp);
			System.out.print(tmp);
			for (int j = 0; j  <15-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("|");
			tmp=(int)(obj.get(fieldf));
			space=space.valueOf(tmp);
			System.out.print(tmp);
			for (int j = 0; j  <10-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("| ");
			System.out.print(obj.get(fieldg));
			System.out.print("| ");
			System.out.print(obj.get(fieldh));


			space=(String) obj.get(fieldi);
			space = space.trim();
			System.out.print("|"+space);
			for (int j = 0; j  <61-(space.length()); j++) {
				System.out.print(" ");
			}


			System.out.println("|");
			System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

		}
	}

//	public  void main(String args[]) {
//		MainHutang mh =new MainHutang();
//		mh.getTampilanJumlahPNSyangBerhutangBerdasarkanCicilan();
//	}
}
