package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;


import com.padepokan79.controller.FgajiUangDuka;


public class MainDuka {
	public  Scanner bf=new Scanner( System.in );
	public  String input,quiz;
	
	MainActivity ma=new MainActivity();

	public MainDuka(){
		mainMenu();
	}	
	public  void mainMenu () {//Modify by Ipin

		System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                           Submenu Uang Duka                                                                    |");
		System.out.println("|------------------------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("| 1. Data uang Duka yang di bayar setelah 1 minggu | 2. PNS yang tidak memiliki tunjangan keluarga | 3. PNS yang tidak memiliki tunjangan Eselon |");
		System.out.println("|------------------------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("| 4. Tunjangan lebih dari 1 Juta                   | 5. PNS tidak Punya anak                       | 0. Menu Utama                               |");
		System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------+");

		try {
			System.out.print("Masukan PIlihan : ");
			String input=bf.next();
			switch (input) {
			case "1":
				tesNamaPNSyangMeninggaldanUangDukaDibayarSetelah1MingguSesudahWafat();
				break;
			case "2":
				tesNamaPNSYangMeningglTanpaTunjanganAnakIstri();
				break;
			case "3":
				tesJumlahPNSYangTidakMempunyaiTunjanganEselonDanTunjanganFungsi();
				break;
			case "4":
				testTGLWafatDanUangBersihLebihDari1Jt();
				break;
			case "5":
				testPnsWafatLebihdar4thnYangmempunyaiIstriTidakMempunyaiAnak();
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
		System.out.print("1. Menu Utama 2. Submenu Uang Duka : ");
		try {
			inp=bf.next();
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



	//NIP, NAMA, TGLWAFAT, TGLBAYAR
	public  void tesNamaPNSyangMeninggaldanUangDukaDibayarSetelah1MingguSesudahWafat(){
		int nextPage=0;
		FgajiUangDuka fju=new FgajiUangDuka();
		try {
			System.out.print("Masukan lama uang duka yang diterima keluarga : ");
			int inputHari=bf.nextInt();
			JSONArray data = fju.getNamaPNSyangMeninggaldanUangDukaDibayarSetelah1MingguSesudahWafat(inputHari, nextPage);
			showData(data,"nip","nama","tglwafat","tglbayar",inputHari,nextPage);
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}

	}

	/*NIP,Nama,tglwafat,tjistri,tjanak*/
	public  void tesNamaPNSYangMeningglTanpaTunjanganAnakIstri(){
		int nextPage=0;
		FgajiUangDuka fju=new FgajiUangDuka();
		try {
			System.out.print("Masukan Tunjangan Istri : ");
			int jmlIstri=bf.nextInt();
			
			JSONArray data = fju.getNamaPNSYangMeningglTanpaTunjanganAnakIstri(jmlIstri, nextPage);
			showData(data,"nip","nama","tglwafat","tjistri","tjanak",jmlIstri,nextPage);
		}catch (Exception e) {
			//System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}

	public  void tesJumlahPNSYangTidakMempunyaiTunjanganEselonDanTunjanganFungsi(){
		int nextPage=0;
		FgajiUangDuka fju=new FgajiUangDuka();
		try {
			JSONArray data = fju.getJumlahPNSYangTidakMempunyaiTunjanganEselonDanTunjanganFungsi(nextPage);
			showData(data,"jumlah_pns_nontjseslon_nontjfungsi",nextPage);
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}

	}

	public  void testTGLWafatDanUangBersihLebihDari1Jt(){
		FgajiUangDuka fju=new FgajiUangDuka();
		int nextPage=0;
		try {
			System.out.print("Masukan Tanggal wafat : ");
			String inputTanggal=bf.next();
			System.out.print("Masukan Penghasilan Bersih : ");
			int inputBersih=bf.nextInt();
			JSONArray data = fju.getTGLWafatDanUangBersihLebihDari1Jt(inputTanggal, inputBersih, nextPage);
			showData_tgl(data,"nip","tglwafat","bersih",inputTanggal,inputBersih,nextPage);
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	} // Yusup  added test for TGLWafatDanUangBersihLebihDari1Jt

	//NIP, NAMA, TGLWAFAT, TGLBAYAR
	public  void showData(JSONArray arrayData, String pa, String pb,String pc,String pd,int inputHari,int nextPage) {
		//System.out.println(arrayData);
		System.out.println("+----------------------------------------------------------------------------------+");
		System.out.println("|         NIP        |             Nama            |  Tgl Wafat  |  Tgl Pembayaran |");
		System.out.println("+----------------------------------------------------------------------------------+");
		String space;
		int tamp=0;
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);
			space = (String) obj.get(pb);
			space=space.trim();
			if(tamp<space.length())
				tamp=space.length();
		}
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			System.out.print("| "+obj.get(pa)+" |");

			space = (String) obj.get(pb);
			space=space.trim();
			System.out.print(" "+space);
			for (int j = 0; j  <tamp-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print(" | "+obj.get(pc)+"  |");
			System.out.println("   "+obj.get(pd)+"    |");
			System.out.println("+----------------------------------------------------------------------------------+");
		}
		System.out.println("N lanjut M Menu : ");
		quiz=bf.next();
		if(quiz.equalsIgnoreCase("N")) {
			nextPage+=10;
			FgajiUangDuka fju=new FgajiUangDuka();
			JSONArray data = fju.getNamaPNSyangMeninggaldanUangDukaDibayarSetelah1MingguSesudahWafat(inputHari, nextPage);
			showData(data,"nip","nama","tglwafat","tglbayar",inputHari,nextPage);
		}else {
			backto();
		}
	}

	public  void showData(JSONArray arrayData, String pa, String pb,String pc,String pd,String pe,int jmlIstri,int nextPage) {
		//System.out.println(arrayData);
		System.out.println("+----------------------------------------------------------------------------------------------------+");
		System.out.println("|         NIP        |             Nama            |  Tgl Wafat  |  Tunjangan Istri | Tunjangan Anak |");
		System.out.println("+----------------------------------------------------------------------------------------------------+");
		String space;
		int tamp=0;
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);
			space = (String) obj.get(pb);
			space=space.trim();
			if(tamp<space.length())
				tamp=space.length();
		}
		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			System.out.print("| "+obj.get(pa)+" |");

			space = (String) obj.get(pb);
			space=space.trim();
			System.out.print(" "+space);
			for (int j = 0; j  <tamp-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print(" | "+obj.get(pc)+"  |");
			System.out.print("        "+obj.get(pd)+"         |");
			System.out.println("       "+obj.get(pe)+"        |");
			System.out.println("+----------------------------------------------------------------------------------------------------+");
		}
		System.out.println("N lanjut M Menu : ");
		quiz=bf.next();
		if(quiz.equalsIgnoreCase("N")) {
			nextPage+=10;
			FgajiUangDuka fju=new FgajiUangDuka();
			JSONArray data = fju.getNamaPNSYangMeningglTanpaTunjanganAnakIstri(jmlIstri, nextPage);
			showData(data,"nip","nama","tglwafat","tjistri","tjanak",jmlIstri,nextPage);
		}else {
			backto();
		}
	}

	public  void showData(JSONArray arrayData, String pa,int nextPage) {
		//System.out.println(arrayData);
		System.out.println("+------------------------------------------+");
		System.out.println("| Jumlah PNS yang tidak memiliki tunjangan |");
		System.out.println("+------------------------------------------+");

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			System.out.println("|                    "+obj.get(pa)+"                    |");


			System.out.println("+------------------------------------------+");
		}
		System.out.println("N lanjut M Menu : ");
		quiz=bf.next();
		if(quiz.equalsIgnoreCase("N")) {
			nextPage+=10;
			FgajiUangDuka fju=new FgajiUangDuka();
			JSONArray data = fju.getJumlahPNSYangTidakMempunyaiTunjanganEselonDanTunjanganFungsi(nextPage);
			showData(data,"jumlah_pns_nontjseslon_nontjfungsi",nextPage);
		}else {
			backto();
		}
	}



	public  void showData_tgl(JSONArray arrayData, String fNip, String ftglwaf, String Fbersih,String inputTanggal,int inputBersih,int nextPage) {
		//System.out.println(arrayData);
		System.out.println("+----------------------------------------------------------+");
		System.out.println("|         NIP         |Tanggal Wafat|  Pengghasilan Bersih |");
		System.out.println("+----------------------------------------------------------+");
		String space;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(fNip);
			System.out.print("| "+space);
			System.out.print("  | "+ obj.get(ftglwaf));
			for (int j = 0; j  <26-(space.length()); j++) {
				System.out.print(" ");
			}
			System.out.print("  |         "+ obj.get(Fbersih));
			System.out.println("        |");
			System.out.println("+-------------------------------------------------------------------------------+");
		}
		System.out.println("N lanjut M Menu : ");
		quiz=bf.next();
		if(quiz.equalsIgnoreCase("N")) {
			nextPage+=10;
			FgajiUangDuka fju=new FgajiUangDuka();
			JSONArray data = fju.getTGLWafatDanUangBersihLebihDari1Jt(inputTanggal, inputBersih, nextPage);
			showData_tgl(data,"nip","tglwafat","bersih",inputTanggal,inputBersih, nextPage);
		}else {
			backto();
		}
	}//Yusup Add ShowData Hehe...

	public  void testPnsWafatLebihdar4thnYangmempunyaiIstriTidakMempunyaiAnak(){
		FgajiUangDuka fju=new FgajiUangDuka();

		try {
			System.out.print("Masukan Tanggal wafat : ");
			String tanggal=bf.next();
			System.out.print("Masukan Tunjangan Istri : ");
			int jmlIstri=bf.nextInt();
			System.out.print("Masukan Tunjangan Anak : ");
			int jmlAnak=bf.nextInt();

			JSONArray data = fju.getPNSLamanyaWafatdariIstridaniAnak(tanggal, jmlIstri, jmlAnak);
			showData_tj(data,"nip","tglwafat","tjistri","tjanak");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	} // Yusup  added test for TGLWafatDanUangBersihLebihDari1Jt

	public  void showData_tj(JSONArray arrayData, String fNip, String ftglwaf, String Ftjis, String Ftjanak) {
		//System.out.println(arrayData);
		System.out.println("+--------------------------------------------------------------------------+");
		System.out.println("|         NIP         |Tanggal Wafat|  Tunjangan Istri  |  Tunjangan Anak  |");
		System.out.println("+--------------------------------------------------------------------------+");
		String space;
		int tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			space=(String) obj.get(fNip);
			System.out.print("| "+space);


			System.out.print("  | "+ obj.get(ftglwaf));
			for (int j = 0; j  <6-(space.length()); j++) {
				System.out.print(" ");
			}

			tamp =(int) obj.get(Ftjis);
			space = space.valueOf(tamp);
			System.out.print("  |      "+ space);
			for (int j = 0; j  <11-(space.length()); j++) {
				System.out.print(" ");
			}

			System.out.print("  |         "+ obj.get(Ftjanak));
			System.out.println("        |");
			System.out.println("+--------------------------------------------------------------------------+");
		}
	}//Yusup Add ShowData Hehe...

	public static void main(String args[]) {
		MainDuka md=new MainDuka();
		md.mainMenu();
	}
}
