package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.UrtNIP;

public class MainUrtNIP {
	public  Scanner sc = new Scanner(System.in);
	BufferedReader dataIn = new BufferedReader(new InputStreamReader( System.in) );
	MainActivity ma=new MainActivity();

	public  void mainMenu () {//Modify by Ipin

		System.out.println("+-----------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                Submenu Main Urutan NIP                                                      |");   
		System.out.println("|-----------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("| 1. PNS berdasarkan tempat lahir dan jens kelamin | 2. PNS tidak punya agama berdasar golongan   | 3.  PNS berdasarkan Agama |");
		System.out.println("|-----------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("| 4. PNS punya NPWP,golongan,tempat lahir          | 5. PNS punya NPWP yang berdasarkan Lama Kerja| 0. Menu Utama             |");
		System.out.println("+-----------------------------------------------------------------------------------------------------------------------------+");

		try {
			System.out.print("Masukan PIlihan : ");
			String input=dataIn.readLine();
			switch (input) {
			case "1":
				getMenampilkanTempatLahirDiLimaPuluhDanJenisKelaminPerempuan();
				break;
			case "2":
				getMenampilkanJumlahPNSberdasrkanAgamadanGolongan();
				break;
			case "3":
				getMenampilkanGroupByAgama();
				break;
			case "4":
				getMenampilkanPNSYangPunyaNPWPTempatLahirdanAgama();
				break;
			case "5":
				getMenampilkanPNSpunyaNPWPdanMasaKerjaLama();;
				break;
			case "0":
				ma.menuUtama();
				break;
			default:
				System.out.println("Masukan anda tidak valid !");
			}
			
			backto();
		} catch (Exception e) {
			System.out.println("Exception Print !");
			System.out.println(e.getMessage());
		}

	}

	public  void backto()  {
		String inp;
		System.out.print("1. Menu Utama 2. Submenu Urutan NIP  : ");
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


	
	public  static void main(String[]args) {
		MainUrtNIP obj =  new MainUrtNIP();
		obj.mainMenu();
		
	}
	//"SELECT nip,nama,kdstawin,janak FROM fgaji where kdstawin=3 and janak=0 limit 0,10;"
	// query 1
	public  void getMenampilkanPNSYangPunyaNPWPTempatLahirdanAgama(){
		UrtNIP urtNIP = new UrtNIP();
		JSONArray data = urtNIP.getMenampilkanPNSYangPunyaNPWPTempatLahirdanAgama(0);
		//System.out.println(data);
		showData7Parameter(data,"nip","nama","npwp","tempat_lahir","jenkel","agama","golongan");
	} // ikan added test for NamaDanGajiBersih
	public  void showData7Parameter(JSONArray arrayData,String fieldNIP,String fieldNama,String fieldNPWP,String fieldTempatLahir,String fieldJenisKelamin,String fieldAgama,String fieldGolongan) {
		//System.out.println(arrayData);
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|        NIP       |              nama            |          NPWP        |  Tempat Lahir | Jenis Kelamin |    Agama        | Golongan  |");
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------+");
		String space;
		int tmp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	


			space=(String) obj.get(fieldNIP);
			System.out.print("|"+space);
			for (int j = 0; j  <18-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldNama);
			System.out.print("|"+space);
			for (int j = 0; j  <30-(space.length()); j++) {
				System.out.print(" ");
			}

			space=(String) obj.get(fieldNPWP);
			space = space.trim();
			System.out.print("|"+space);
			for (int j = 0; j  <22-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldTempatLahir);
			System.out.print("|"+space);
			for (int j = 0; j  <15-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldJenisKelamin);
			System.out.print("|"+space);
			for (int j = 0; j  <15-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldAgama);
			System.out.print("|"+space);
			for (int j = 0; j  <17-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldGolongan);
			System.out.print("|"+space);
			for (int j = 0; j  <11-(space.length()); j++) {
				System.out.print(" ");
			}


			System.out.println("|");
			System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------+");

		}
	}
	// query 3
	public  void getMenampilkanPNSpunyaNPWPdanMasaKerjaLama(){
		UrtNIP urtNIP = new UrtNIP();
		System.out.println("Masukan masa kerja : ");
		int masker = sc.nextInt();
		JSONArray data = urtNIP.getMenampilkanPNSpunyaNPWPdanMasaKerjaLama(masker,0);
		//System.out.println(data);
		showData7Parameter(data,"nip","nama","npwp","masa_kerja","golongan","jab_struktur");
	} // ikan added test for NamaDanGajiBersih
	public  void showData7Parameter(JSONArray arrayData,String fieldNIP,String fieldNama,String fieldNPWP,String fieldMasaKerja,String fieldGolongan,String fieldStrukturJabatan) {
		//System.out.println(arrayData);
		
		System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|        NIP       |              nama            |          NPWP        |   Masa Kerja  | Golongan  |    Struktur Jabatan     |");
		System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
		String space;
		int tmp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	


			space=(String) obj.get(fieldNIP);
			System.out.print("|"+space);
			for (int j = 0; j  <18-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldNama);
			System.out.print("|"+space);
			for (int j = 0; j  <30-(space.length()); j++) {
				System.out.print(" ");
			}

			space=(String) obj.get(fieldNPWP);
			space = space.trim();
			System.out.print("|"+space);
			for (int j = 0; j  <22-(space.length()); j++) {
				System.out.print(" ");
			}
			tmp=(int) obj.get(fieldMasaKerja);
			space =space.valueOf(tmp);
			System.out.print("|"+obj.get(fieldMasaKerja));
			for (int j = 0; j  <15-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldGolongan);
			System.out.print("|"+space);
			for (int j = 0; j  <11-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldStrukturJabatan);
			System.out.print("|"+space);
			for (int j = 0; j  <25-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");

		}
	}	
	// query 2
	public  void getMenampilkanTempatLahirDiLimaPuluhDanJenisKelaminPerempuan(){
		UrtNIP urtNIP = new UrtNIP();
		System.out.println("Masukan Tempat lahir : ");
		String tempatLahir = sc.nextLine();
		System.out.println("Masukan Jenis Kelamin : ");
		String JenisKelamin = sc.next();
		JSONArray data = urtNIP.getMenampilkanTempatLahirDiLimaPuluhDanJenisKelaminPerempuan(tempatLahir, JenisKelamin, 0);
		//System.out.println(data);
		showData7Parameter(data,"nip_v", "v_nama", "v_tmp_lahir", "c_jns_kelamin");
	} // ikan added test for NamaDanGajiBersih
	public  void showData7Parameter(JSONArray arrayData,String fieldNIP,String fieldNama,String fieldTempat_Lahir,String fieldJenis_Kelamin) {
		//System.out.println(arrayData);
		System.out.println("+---------------------------------------------------------------------------------------------+");
		System.out.println("|        NIP       |              nama            |    Tempat_Lahir      |   Jenis_Kelamin    | ");
		System.out.println("+---------------------------------------------------------------------------------------------+");
		String space;
		int tmp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	


			space=(String) obj.get(fieldNIP);
			System.out.print("|"+space);
			for (int j = 0; j  <18-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldNama);
			System.out.print("|"+space);
			for (int j = 0; j  <30-(space.length()); j++) {
				System.out.print(" ");
			}

			space=(String) obj.get(fieldTempat_Lahir);
			space = space.trim();
			System.out.print("|"+space);
			for (int j = 0; j  <22-(space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(fieldJenis_Kelamin);
			System.out.print("|    "+space);
			for (int j = 0; j  <15-(space.length()); j++) {
				System.out.print(" ");
			}

			System.out.println(" |");
			System.out.println("+---------------------------------------------------------------------------------------------+");

		}
	}


	//query 4
	public  void getMenampilkanJumlahPNSberdasrkanAgamadanGolongan(){ //modify by siska
		UrtNIP urtNIP = new UrtNIP();
		JSONArray data = urtNIP.getMenampilkanJumlahPNSberdasrkanAgamadanGolongan(1);
		showData_Parameter(data,"golongan","jumlah");
	}

	public  void showData_Parameter(JSONArray arrayData, String fieldGolongan, String fieldJumlah_PNSTakPunyaAgama) {
		//System.out.println(arrayData);
		System.out.println("+-------------------------------------------------+");
		System.out.println("|        Golongan      |Jumlah_PNS Tak punya Agama|");
		System.out.println("+-------------------------------------------------+");
		String space;
		long tmp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	
			
			space=(String) obj.get(fieldGolongan);
			System.out.print("|"+space);
			for (int j = 0; j  <21-(space.length()); j++) {
				System.out.print(" ");
			}

			tmp=(long) obj.get(fieldJumlah_PNSTakPunyaAgama);
			space=space.valueOf(tmp);
			System.out.print(" |          "+ tmp);
			for (int j = 0; j  <16-(space.length()); j++) {
				System.out.print(" ");
			}


			System.out.println("|");
			System.out.println("+-------------------------------------------------+");

		}
	}

	// query 5
	public  void getMenampilkanGroupByAgama(){ //modify by siska
		UrtNIP urtNIP = new UrtNIP();
		JSONArray data = urtNIP.queryMenampilkanGroupByAgama(1);
		showData2Parameter(data,"agama","jumlah_pns");
	}

	public  void showData2Parameter(JSONArray arrayData,String fieldAgama, String fieldJumlahPNS) {
		//System.out.println(arrayData);
		System.out.println("+-----------------------------------------------+");
		System.out.println("|        Agama       |        Jumlah_PNS        |");
		System.out.println("+-----------------------------------------------+");
		String space;
		long tmp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	


			space=(String) obj.get(fieldAgama);
			System.out.print("|"+space);
			for (int j = 0; j  <18-(space.length()); j++) {
				System.out.print(" ");
			}
			tmp=(long) obj.get(fieldJumlahPNS);
			space=space.valueOf(tmp);
			System.out.print("  |          "+ tmp);
			for (int j = 0; j  <16-(space.length()); j++) {
				System.out.print(" ");
			}


			System.out.println("|");
			System.out.println("+-----------------------------------------------+");

		}
	}
}
