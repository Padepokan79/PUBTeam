package com.padepokan79.test;

import java.util.Scanner;

public class MainUnitKerja {
	public  Scanner bf=new Scanner( System.in );
	public  String input,quiz;
	
	
	 MainActivity ma=new MainActivity();
	
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
				//tesNamaPNSyangMeninggaldanUangDukaDibayarSetelah1MingguSesudahWafat();
				break;
			case "2":
				//tesNamaPNSYangMeningglTanpaTunjanganAnakIstri();
				break;
			case "3":
				//tesJumlahPNSYangTidakMempunyaiTunjanganEselonDanTunjanganFungsi();
				break;
			case "4":
				//testTGLWafatDanUangBersihLebihDari1Jt();
				break;
			case "5":
				//testPnsWafatLebihdar4thnYangmempunyaiIstriTidakMempunyaiAnak();
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

	
	
}
