package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.Fgaji;
import com.padepokan79.controller.Satker;

public class MainSatker {
	 BufferedReader dataIn = new BufferedReader(new InputStreamReader( System.in) );
	 MainActivity ma=new MainActivity();
	 public MainSatker() {
		 mainMenu();
	 }
	 
	public  void mainMenu () {//Modify by Ipin

		System.out.println("+----------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                      Submenu Satuan Kerja                                                |");
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
				namaOperatorDenganAkhiranH();
				break;
			case "2":
				getqueryNamaAtasanDRSDanJabatanCamat();
				break;
			case "3":
				kepalaDinasHaji();
				break;
			case "4":
				JumlahPegawaiYangKerjaDiDinasKesehatan();
				break;
			case "5":
				testBendaharaPembantuDaftarGaji();
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
	
	public  void namaOperatorDenganAkhiranH(){
		Satker satKerja=new Satker();
		JSONArray data = satKerja.getQueryNamaOperatorDenganAkhiranH();
		showData1(data,"nama_operator","satuan_kerja","kota","deskripsi");
	}

	public  void getqueryNamaAtasanDRSDanJabatanCamat(){
		Satker satkerja = new Satker();
		JSONArray data = satkerja.getQueryNamaAtasanDRSDanJabatanCamat();
		//System.out.println(data);
		showData5Parameter(data,"satkerja", "jab_atasan", "descsatker", "kota", "nama_atasan");
	} 
	
	public  void kepalaDinasHaji(){
		Satker satkerja = new Satker();
		JSONArray data = satkerja.getQueryKepalaDinasHaji();
		//System.out.println(data);
		showData(data,"satkerja", "descsatker", "nama_atasa", "jab_atasan");
	} 
	
	public  void JumlahPegawaiYangKerjaDiDinasKesehatan(){
		Satker satkerja = new Satker();
		JSONArray data = satkerja.getQueryJumlahPegawaiYangKerjaDiDinasKesehatan();
		//System.out.println(data);
		showData(data,"satuan_kerja", "count(*)");
	} 
	
	public  void testBendaharaPembantuDaftarGaji(){
		Satker objSatker =new Satker();
		JSONArray data = objSatker.getQueryBendaharaPembantuDaftarGaji(); 
		showData(data,"satkerja","descsatker","nip_bend","nama_bend","jab_bend","jab_operat");
	} // Yusup  added test for BendaharaPembantuDaftarGaji
	
	public  void showData5Parameter(JSONArray arrayData,String fielda, String fieldb, String fieldc, String fieldd, String fielde) {
		//System.out.println(arrayData);
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("| Satuan Kerja |      Jabatan Atasan      |                Des Satuan Kerja                  |     Kota      |    Nama Atasan                |");
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------+");
		String space;
		
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			space=(String) obj.get(fielda);
			space = space.trim();
			System.out.print("|"+space);
			for (int j = 0; j  <8-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(fieldb);
			space = space.trim();
			System.out.print("      | "+space);
			for (int j = 0; j  <20-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(fieldc);
			space = space.trim();
			System.out.print("     | "+space);
			for (int j = 0; j  <45-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(fieldd);
			space = space.trim();
			System.out.print("    | "+space);
			for (int j = 0; j  <10-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fielde);
			space = space.trim();
			System.out.print("    | "+space);
			for (int j = 0; j  <30-(space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.println("|");
			System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------+");
		}
		backto();
	}		
	
	//SATKERJA , DESCSATKER , Kota, nama_opera
	private  void showData1(JSONArray arrayData, String fieldsa, String fieldsb, String fieldsc,String fieldsd) {
		System.out.println("+----------------------------------------------------------------------------------------------------+");
		System.out.println("|   Nama Operator           | Satuan Kerja |  Kota     |                 Deskripsi                   |");
		System.out.println("+----------------------------------------------------------------------------------------------------+");
		//System.out.println(arrayData);

		for (int i = 0; i < arrayData.length(); i++) {//modify by Ipin
			JSONObject obj =  arrayData.getJSONObject(i);
			String space=(String) obj.get(fieldsa);
			space=space.trim();
			System.out.print("| "+space);
			for (int j = 0; j <26-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("|      "+ obj.get(fieldsb)+"     ");
			String tmp=(String)obj.get(fieldsb);
			if(tmp.length()<3)
				System.out.print(" ");
			System.out.print("| "+obj.get(fieldsc));
			tmp=(String)obj.get(fieldsc);
			if(tmp.length()<9)
				System.out.print(" ");
			System.out.print(" | "+obj.get(fieldsd));
			if(tmp.length()<3)
				System.out.print(" ");
			tmp=(String)obj.get(fieldsd);
			for (int j = 0; j <43-(tmp.length()); j++) {
				System.out.print(" ");
			}
			System.out.println(" |");
			System.out.println("+----------------------------------------------------------------------------------------------------+");

		}
		backto();
	} 
	
	
	
	public  void showData(JSONArray arrayData, String fSatu, String fDua, String fTiga, String fEmpat) {
		//System.out.println(arrayData);
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("| Satuan Kerja |            Deskripsi Satuan Kerja            |                 Nama Atasan                 |               Jabatan Atasan               |");
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------+");
		String space;
		
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			space=(String) obj.get(fSatu);
			System.out.print("|      "+space);
			
			space=(String) obj.get(fDua);
			space = space.trim();
			System.out.print("     | "+space);
			for (int j = 0; j  <40-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(fTiga);
			space = space.trim();
			System.out.print("     | "+space);
			for (int j = 0; j  <40-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(fEmpat);
			space = space.trim();
			System.out.print("    | "+space);
			for (int j = 0; j  <43-(space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.println("|");
					
			System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------+");
		}
	}
	
	
	
	public  void showData(JSONArray arrayData, String fSatu, String fDua) {
		//System.out.println(arrayData);
		System.out.println("+---------------------------------------------+");
		System.out.println("|            Satuan Kerja            | Jumlah |");
		System.out.println("+---------------------------------------------+");
		String space;
		
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			space=(String) obj.get(fSatu);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <35-(space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.print("|    "+obj.get(fDua));
			
			
			
					
			System.out.println("   |");
					
			System.out.println("+---------------------------------------------+");
		}
	}
	
	
	public  void showData(JSONArray arrayData, String fSatker, String fdescsatker, String fnip_bend, String fnama_bend, String fjab_bend, String fjab_operat) {
		//System.out.println(arrayData);
		System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|Satuan kerja|     Deskripsi Satuan kerja    |    Nip Bendahara    |         Nama Bendahara        |                   Jabatan Bendahara                 |             Jabatan Operator          |");
		System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(fSatker);
			System.out.print("| "+space);

			space=(String) obj.get(fdescsatker);
			space = space.trim();
			System.out.print("        | "+space);
			for (int j = 0; j  <28-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(fnip_bend);
			space = space.trim();
			System.out.print("  | "+space);
			for (int j = 0; j  <18-(space.length()); j++) {
				System.out.print(" ");
			}
		
			space=(String) obj.get(fnama_bend);
			space = space.trim();
			System.out.print("  | "+space);
			for (int j = 0; j  <30-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fjab_bend);
			space = space.trim();
			System.out.print("|"+space);
			for (int j = 0; j  <53-(space.length()); j++) {
				System.out.print(" ");
			}
			
			space=(String) obj.get(fjab_operat);
			space = space.trim();
			System.out.print("| "+space);
			for (int j = 0; j  <38-(space.length()); j++) {
				System.out.print(" ");
			}

			System.out.println("|");
			System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		}
	}//Yusup Add ShowData Hehe...
	
	public  void main(String args[]) {
		
		MainSatker ms=new MainSatker();
		ms.mainMenu();
	}
}
