package com.padepokan79.test;

import java.util.Scanner;
public class MainActivity {
	public static void main(String[] args) {
		MainActivity newMenu = new MainActivity();
		newMenu.menuUtama();
	}
		public  void  menuUtama() {
		int input;	
		Scanner in = new Scanner(System.in);
		System.out.println("+---------------------------------------------------------------------------------+");
		System.out.println("|                            Menu Utama                                           |");
		System.out.println("+---------------------------------------------------------------------------------+");
		System.out.println("| 1. Gaji       |  2. Satuan Kerja      | 3. Tabel Wafat        |  4. Hutang      |");
		System.out.println("+---------------------------------------------------------------------------------+");
		System.out.println("| 5. Keluarga   |  6. SKPP Pegawai      | 7. Uang duka          |  8. Data Rapel  |");
		System.out.println("+---------------------------------------------------------------------------------+");
		System.out.println("| 9. URT NIP    |  10. Historis Eselon  | 11. Detil Kekurangan  |  12. Pajak      |");
		System.out.println("+---------------------------------------------------------------------------------+");
		System.out.println("| 13.Tabel Agama|  14. Tabel Guru       | 15. Tabel Umum        |  16.T Tunjangan |");
		System.out.println("+---------------------------------------------------------------------------------+");
		System.out.println("| 17.Hak Akses  |  18. Tabel 1721A      | 19. Tabel F_spt       |  20.T akunsp2d  |");
		System.out.println("+---------------------------------------------------------------------------------+");
		System.out.print("Pilihan : ");
		input = in.nextInt();
		if (input==1) {
			FGajiMenu newGaji = new FGajiMenu();
			newGaji.mainMenu();
		}else if(input == 2) {
			MainSatker newSatker = new MainSatker();
			newSatker.mainMenu();
		}else if( input == 3){
			Maintwafat newWafat = new Maintwafat();
			newWafat.mainMenu();
		}else if(input == 4){
			MainHutang newHutang = new MainHutang();
			newHutang.mainMenu();
		}else if (input == 5){
			MainKeluarga newKeluarga = new MainKeluarga();
			newKeluarga.mainMenu();
		}else if  (input == 6){
			MainSKPP newSKPP = new MainSKPP();
			newSKPP.mainMenu();
		}else if (input == 7){
			MainDuka newDuka = new MainDuka();
			newDuka.mainMenu();
		}else if (input == 8){
			MainDataRapel newRapel = new MainDataRapel();
			newRapel.mainMenu();
		}else if(input == 9) {
			MainUrtNIP newUrt = new MainUrtNIP();
			newUrt.mainMenu();
		}else if(input == 11) {
			MainDetilKekurangan newDetilKekurangan = new MainDetilKekurangan();
			newDetilKekurangan.mainMenu();
		}else if(input == 13) {
			MainAgama newAgama = new MainAgama();
			newAgama.testqueryMencariNamaAgama();
		}else if (input == 14){
			MainGuru newGuru = new MainGuru();
			newGuru.tesMencariKodeGuruDitabelGuru();
		}else if (input == 15){
			MainUmum newUmum = new MainUmum();
			newUmum.getMencariTJUmumBerdasarkanKodeGolongan();	
		}else if (input == 16) {
			MainTunjangan newTunjangan = new MainTunjangan();
			newTunjangan.mainMenu();
		}else if (input == 17) {
			MainHakAkses newHakAkses = new  MainHakAkses();
			newHakAkses.mainMenu();
		}
		System.out.println("Maaf, inputan anda salah");
		menuUtama();
	}
}
