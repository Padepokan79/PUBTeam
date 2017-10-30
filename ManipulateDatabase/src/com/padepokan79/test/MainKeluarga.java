package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.Keluarga;

public class MainKeluarga {
	 BufferedReader dataIn = new BufferedReader(new InputStreamReader( System.in) );
	 MainActivity ma=new MainActivity();
	 public MainKeluarga() {
		 mainMenu();
	 }
	 
	public  void mainMenu () {//Modify by Ipin

		System.out.println("+-----------------------------------------------------------------------------+");
		System.out.println("|                                Submenu Keluarga                             |");
		System.out.println("|-----------------------------------------------------------------------------|");
		System.out.println("| 1. PNS Usia Nikah lebih dari 25 | 2. Jomblo Mati         | 3. Jomblo Sejati |");
		System.out.println("|-----------------------------------------------------------------------------|");
		System.out.println("| 4. PNS yang Sudah Menikah       | 5. PNS Duda Atau Janda | 0. Menu Utama    |");
		System.out.println("+-----------------------------------------------------------------------------+");

		try {
			System.out.print("Masukan PIlihan : ");
			String input=dataIn.readLine();
			switch (input) {
			case "1":
				PNSUsiaPernikahanPerak25tahun();
				break;
			case "2":
				jombloWafat();
				break;
			case "3":
				jombloSejati();
				break;
			case "4":
				testKeluargaPNSyangSudahMenikahDanMempunyaiKartuSuamiIstri();
				break;
			case "5":
				testNamaKeluargaPNSyangPernahMenikahLaluCerai();
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

	/*NIP,NAMAKELUARGA,TGLNIKAH*/

	public  void PNSUsiaPernikahanPerak25tahun(){
		Keluarga objKeluarga=new Keluarga();
		JSONArray data = objKeluarga.getQueryPNSUsiaPernikahanPerak25tahun(); 
		showData(data,"nip","namakeluarga","tglnikah");
	}

	/*nip,Nama,tglnikah,tglwafat*/
	public  void jombloWafat(){
		Keluarga objKeluarga=new Keluarga();
		JSONArray data = objKeluarga.getQueryPNSJombloWafat(); 
		showData(data,"nip","nama","tglwafat","");
	}

	/*NMKEL,TGLLHR,TGLNIKAH*/
	public  void jombloSejati(){
		Keluarga objKeluarga=new Keluarga();
		JSONArray data = objKeluarga.getQueryPNSjomblosejati(); 
		showData(data,"nmkel","tgllhr");
	}

	public  void testKeluargaPNSyangSudahMenikahDanMempunyaiKartuSuamiIstri(){
		Keluarga objkeluarga =new Keluarga();

		JSONArray data = objkeluarga.getQueryKeluargaPNSyangSudahMenikahDanMempunyaiKartuSuamiIstri(); 

		showData2(data,"nip","nama","tglnikah","nipsuamiistri");
	} // Yusup  added test for KeluargaPNSyangSudahMenikahDanMempunyaiKartuSuamiIstri

	public  void testNamaKeluargaPNSyangPernahMenikahLaluCerai(){
		Keluarga objkeluarga =new Keluarga();

		JSONArray data = objkeluarga.getQueryNamaKeluargaPNSyangPernahMenikahLaluCerai(); 

		showData_(data,"nip","nama","tglnikah","tglcerai");
	} // Yusup  added test for NamaKeluargaPNSyangPernahMenikahLaluCerai


	public  void showData(JSONArray arrayData,String fielda, String fieldb, String fieldc) {
		//System.out.println(arrayData);
		System.out.println("+--------------------------------------------------------------+");
		System.out.println("|        NIP           |      Nama Keluarga    | Tanggal Nikah |");
		System.out.println("+--------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			System.out.print("|    "+obj.get(fielda));
			space=(String) obj.get(fieldb);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <22-(space.length()); j++) {
				System.out.print(" ");
			}

			System.out.print("|   "+obj.get(fieldc));
			System.out.println("  |");
			System.out.println("+--------------------------------------------------------------+");
		}
		backto();
	}		


	public  void showData(JSONArray arrayData,String fielda, String fieldb, String fieldc,String fieldd) {
		//System.out.println(arrayData);
		System.out.println("+---------------------------------------------------------------+");
		System.out.println("|        NIP           |     Nama Keluarga      | Tanggal Wafat |");
		System.out.println("+---------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			System.out.print("|    "+obj.get(fielda));
			space=(String) obj.get(fieldb);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <23-(space.length()); j++) {
				System.out.print(" ");
			}

			System.out.print("|    "+obj.get(fieldc));
			System.out.println(" |");
			System.out.println("+------------------------------------------------------------------+");
		}
		backto();
	}


	public  void showData(JSONArray arrayData,String fielda, String fieldb) {
		System.out.println("+----------------------------------------------------+");
		System.out.println("|               Nama                |  Tanggal Lahir |");
		System.out.println("+----------------------------------------------------+");
		String space;

		for (int i = 0; i < 10; i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			space=(String) obj.get(fielda);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <34-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|    "+obj.get(fieldb)+"  |");
			System.out.println("+----------------------------------------------------+");
		}
		backto();
	}


	public  void showData2(JSONArray arrayData, String fNip, String fNama, String Ftglnikah, String fnipSI) {
		//System.out.println(arrayData);
		System.out.println("+-------------------------------------------------------------------------------------------+");
		System.out.println("|         NIP         |               Nama                 |Tanggal Nikah|  Nip Suami Istri |");
		System.out.println("+-------------------------------------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(fNip);
			System.out.print("| "+space);

			space=(String) obj.get(fNama);
			space = space.trim();
			System.out.print("  | "+space);
			for (int j = 0; j  <33-(space.length()); j++) {
				System.out.print(" ");
			}


			System.out.print("  | "+ obj.get(Ftglnikah));
			for (int j = 0; j  <5-(space.length()); j++) {
				System.out.print(" ");
			}


			space=(String) obj.get(fnipSI);
			space = space.trim();
			System.out.print("  |"+space);
			for (int j = 0; j  <18-(space.length()); j++) {
				System.out.print(" ");
			}

			System.out.println("|");
			System.out.println("+-------------------------------------------------------------------------------------------+");
		}
	}//Yusup Add ShowData Hehe...




	public  void showData_(JSONArray arrayData, String fNip, String fNama, String Ftglnikah, String ftglcerai) {
		//System.out.println(arrayData);
		System.out.println("+---------------------------------------------------------------------------+");
		System.out.println("|         NIP         |          Nama           |Tanggal Nikah|Tanggal Cerai|");
		System.out.println("+---------------------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(fNip);
			System.out.print("| "+space);

			space=(String) obj.get(fNama);
			space = space.trim();
			System.out.print("  | "+space);
			for (int j = 0; j  <22-(space.length()); j++) {
				System.out.print(" ");
			}


			System.out.print("  | "+ obj.get(Ftglnikah));
			for (int j = 0; j  <5-(space.length()); j++) {
				System.out.print(" ");
			}

			System.out.print("  |"+obj.get(ftglcerai));
			for (int j = 0; j  <9-(space.length()); j++) {
				System.out.print(" ");
			}

			System.out.println("   |");
			System.out.println("+---------------------------------------------------------------------------+");
		}
	}

	public  void main(String args[]) {
		MainKeluarga mk=new MainKeluarga();
		mk.mainMenu();
	}
}
