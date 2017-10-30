package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.DetilKekurangan;

public class MainDetilKekurangan{
	public  Scanner keyboard = new Scanner( System.in );
	MainActivity ma=new MainActivity();
	
	public MainDetilKekurangan(){
		mainMenu();
	}	
	public  void mainMenu () {//Modify by Ipin

		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                                 Submenu Detail Kekurangan                                                                                      |");
		System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("| 1. Menampikan Masker Dibawah 5 Tahun Dan Gaji Diatas 25jt | 2. Menampilkan Jenis Kekurangan Yang Lebih Dari Satu | 3. Jumlah PNS Berdasarkan Golongan Jumlah Anak Jumlah Istri |");
		System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("| 4. Menampilkan Daftar Tanggal Bayar berdasarkan Input     | 5. Mencari Kode Pangkat dan Mengurutkan UPDSTAMP     | 0. Menu Utama                                               |");
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

		try {
			System.out.print("Masukan PIlihan : ");
			String input=keyboard.next();
			switch (input) {
			case "1":
				testqueryMenampikanMaskerDibawah5TahunDanGajiDiatas25jt();
				break;
			case "2":
				queryMenampilkanJenisKekuranganYangLebihDariSatu();
				break;
			case "3":
				queryJumlahPNSBerdasarkanGolonganJumlahAnakJumlahIstri();
				break;
			case "4":
				queryMenampilkanDaftarTanggalBayarberdasarkanInput();
				break;
			case "5":
				queryMencariKodePangkatdanMengurutkanUPDSTAMP();
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
		System.out.print("1. Menu Utama 2. Submenu DEtail Kekurangan : ");
		try {
			inp=keyboard.next();
			switch (inp) {
			case "1":

				break;
			case "2":
				ma.menuUtama();;
				break;
			case "3":
				mainMenu();
				break;
			default:
				System.out.println("Masukan Salah !");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	public  void testqueryMenampikanMaskerDibawah5TahunDanGajiDiatas25jt() {
		DetilKekurangan dk = new DetilKekurangan();
		
		//try {
			System.out.print("Masukan Masa Kerja : ");
			int inputMasaKerja=keyboard.nextInt();
			System.out.print("Masukan Gaji Pokok : ");
			int inputGapok=keyboard.nextInt();
			
			JSONArray data = dk.getQueryMenampikanMaskerDibawah5TahunDanGajiDiatas25jt(inputMasaKerja, inputGapok);
			showData_dk(data,"nip","nama","masker","gapok");
		//} catch (Exception e) {
			//System.out.println("Inputan Salah");
			//System.out.println(e.getMessage());
			// TODO: handle exception
		//}
	}
	public  void showData_dk(JSONArray arrayData, String nip, String nama, String masakerja, String gapok) {
		//System.out.println(arrayData);
		System.out.println("+-------------------------------------------------------------------------------------------+");
		System.out.println("|       NIP           |            Nama Pegawai           | Masa Kerja    |    Gaji Pokok   |");
		System.out.println("+-------------------------------------------------------------------------------------------+");
		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(nip);
			System.out.print("| "+space);

			space=(String) obj.get(nama);
			System.out.print("  | "+ space);
			for (int j = 0; j  < 16 - (space.length()); j++) {
				System.out.print(" ");
			}
			tamp=(int) obj.get(masakerja);
			//space = space.valueOf(tamp);
			System.out.print("              | "+ tamp);
			for (int j = 0; j  < 10 - (space.length()); j++) {
				System.out.print(" ");
			}
			tamp=(int) obj.get(gapok);
			//space = space.valueOf(tamp);
			System.out.print("| "+ tamp);
			for (int j = 0; j  < (space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+---------------------------------------------------------------------------------------+");
		}
		backto();
	}
	public  void queryJumlahPNSBerdasarkanGolonganJumlahAnakJumlahIstri() {
		DetilKekurangan dk = new DetilKekurangan();
		
	
			
			JSONArray input = dk.getQueryJumlahPNSBerdasarkanGolonganJumlahAnakJumlahIstri();
			showData_dk(input,"kode_pangkat","jumlah_istri","jumlah_anak","jumlah");
		//} catch (Exception e) {
			//System.out.println("Inputan Salah");
			//System.out.println(e.getMessage());
			// TODO: handle exception
		//}
	}
	public  void showData_dkk(JSONArray arrayData, String kd_pangkat, String jml_istri,String jml_anak,String jml) {
		//System.out.println(arrayData);
		System.out.println("+-------------------------------------------------------------------------------------------------+");
		System.out.println("|  Kode Pangkat          |    Jumlah Istri          |      Jumlah Anak       |      Jumlah        |");
		System.out.println("+-------------------------------------------------------------------------------------------------+");
		String space;
	//	int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);

			space=String.valueOf(obj.get(kd_pangkat)) ;
			System.out.print("|  "+ space);
			for (int j = 1; j  < 23 - (space.length()); j++) {
				System.out.print(" ");
			}
			space=String.valueOf(obj.get(jml_istri));
			System.out.print("|  "+ space);
			for (int j = 1; j  < 25 - (space.length()); j++) {
				System.out.print(" ");
			}
			space=String.valueOf(obj.get(jml_anak));
			System.out.print("|  "+ space);
			for (int j = 1; j  < 23 - (space.length()); j++) {
				System.out.print(" ");
			}
			space=String.valueOf(obj.get(jml));
			System.out.print("|  "+ space);
			for (int j = 1; j  < 19 - (space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.println("|");
			System.out.println("+-------------------------------------------------------------------------------------------------+");
		}
		backto();
	}
//public  Scanner keyboard = new Scanner( System.in );
	//query 5
	public  void queryMencariKodePangkatdanMengurutkanUPDSTAMP() {
		DetilKekurangan dk = new DetilKekurangan();
		
		//Try
		System.out.print("Masukan Tanggal Dari : : ");
		String inputKodePangkat=keyboard.nextLine();
		
			JSONArray input = dk.getQueryMencariKodePangkatdanMengurutkanUPDSTAMP(inputKodePangkat, 0);
			showData_a(input,"tglbayar","nip","nama","jeniskekurangan","dari","sampai","kdpangkat","updstamp");
		//} catch (Exception e) {
			//System.out.println("Inputan Salah");
			//System.out.println(e.getMessage());
			// TODO: handle exception
		//}
	}
	public  void showData_a(JSONArray arrayData, String tgl_bayar, String nip, String nama, String jns_kekurangan, String dari, String sampai, String kd_pangkat, String updstamp) {
		//System.out.println(arrayData);
		System.out.println("+----------------------------------------------------------------------------------------------------+");
		System.out.println("|  		Tanggal Bayar        |          Nip         |      Nama          |  Jenis kekurangan |");
		System.out.println("+----------------------------------------------------------------------------------------------------+");
		System.out.println("|  		    Dari             |         Sampai       |      Kd Pangkat    |        UPDSTAMP   |");
		System.out.println("+----------------------------------------------------------------------------------------------------+");
		String space;
	//	int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);

			space=(String) obj.get(tgl_bayar) ;
			System.out.print("|"+ space);
			for (int j = 0; j  < 20- (space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(nip);
			System.out.print("|"+ space);
			for (int j = 0; j  < 20 - (space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(nama);
			System.out.print("|"+ space);
			for (int j = 0; j  < 25 - (space.length()); j++) {
				System.out.print(" ");
			}
			space=String.valueOf( obj.get(jns_kekurangan));
			System.out.print("|"+space);
			for (int j = 0; j  < 25 - (space.length()); j++) {
				System.out.print(" ");
			}space=(String) obj.get(dari);
			System.out.print("|"+ space);
			for (int j = 0; j  < 25 - (space.length()); j++) {
				System.out.print(" ");
			}space=(String) obj.get(sampai);
			System.out.print("|"+ space);
			for (int j = 0; j  < 25 - (space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("|"+ obj.get(kd_pangkat));
			for (int j = 0; j  < 25 - (space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.print("|"+ obj.get(updstamp));
			for (int j = 0; j  < 25 - (space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+--------------------------------------------------------------------------------------+");
		}
		backto();
	}
	//query 2
	public  void queryMenampilkanJenisKekuranganYangLebihDariSatu() {
		DetilKekurangan dk = new DetilKekurangan();
		
			JSONArray input = dk.getQueryMenampilkanJenisKekuranganYangLebihDariSatu();
			showData_a(input,"nip","jeniskekurangan");
		//} catch (Exception e) {
			//System.out.println("Inputan Salah");
			//System.out.println(e.getMessage());
			// TODO: handle exception
		//}
	}
	public  void showData_a(JSONArray arrayData, String nip, String jns_kekurangan) {
		//System.out.println(arrayData);
		System.out.println("+------------------------------------------+");
		System.out.println("|  	      Nip     |    Jenis kekurangan    |");
		System.out.println("+------------------------------------------+");
		String space;
		//int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);

			space=(String) obj.get(nip) ;
			System.out.print("|"+ space);
			for (int j = 0; j  < 20- (space.length()); j++) {
				System.out.print(" ");
			}
			space=String.valueOf( obj.get(jns_kekurangan));
			System.out.print("|"+ space);
			for (int j = 0; j  < 20 - (space.length()); j++) {
				System.out.print(" ");
			}
			
			System.out.println("|");
			System.out.println("+--------------------------------------------------------------------------------------+");
		}
		backto();
	}
	//query 4
	public  void queryMenampilkanDaftarTanggalBayarberdasarkanInput() {
		DetilKekurangan dk = new DetilKekurangan();
		//Try
		System.out.print("Masukan Tanggal Dari : : ");
		String inputTanggalDari=keyboard.nextLine();
		System.out.print("Masukan Tanggal Sampai : ");
		String inputTanggalSampai=keyboard.nextLine();
		
		
			JSONArray input = dk.getQueryMenampilkanDaftarTanggalBayarberdasarkanInput(inputTanggalDari, inputTanggalSampai, 0);
			showData_a(input,"nip","nama","tglbayar");
		//} catch (Exception e) {
			//System.out.println("Inputan Salah");
			//System.out.println(e.getMessage());
			// TODO: handle exception
		//}
	}
	public  void showData_a(JSONArray arrayData, String nip, String nama, String tgl_bayar) {
		//System.out.println(arrayData);
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.println("|          Nip         |      Nama          |        Tanggal Bayar        | ");
		System.out.println("+-------------------------------------------------------------------------+");
		String space;
		//int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);

			space=(String) obj.get(nip) ;
			System.out.print("|"+ space);
			for (int j = 0; j  < 20- (space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(nama);
			System.out.print("|"+ space);
			for (int j = 0; j  < 20 - (space.length()); j++) {
				System.out.print(" ");
			}
			space=(String) obj.get(tgl_bayar);
			System.out.print("|"+ space);
			for (int j = 0; j  < 20 - (space.length()); j++) {
				System.out.print(" ");
			}

			System.out.println("|");
			System.out.println("+--------------------------------------------------------------------------------------+");
		}
		backto();
	}

}
