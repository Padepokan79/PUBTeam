package com.padepokan79.test;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdJabatanFungsiController;
import com.padepokan79.controller.MdJadualHutangController;
import com.padepokan79.model.MdJadualHutang;
import com.padepokan79.util.DatabaseConnection;

public class MdJadualHutangTest extends DatabaseConnection implements MdJadualHutang {
	Scanner in=new Scanner(System.in);
	 MainActivity ma=new MainActivity();
	 public MdJadualHutangTest() {
		 mainMenu();
	 }
	 
	 public void mainMenu() {
		 	System.out.println("+------------------------------------+");
			System.out.println("|       ~ Menu Jadual_Hutang ~       |");
			System.out.println("+------------------------------------+");
			System.out.println("| 1. Menampilkan  |   2. Menambahkan |");
			System.out.println("+------------------------------------+");
			System.out.println("| 3. Merubah      |   4. Menghapus   |");
			System.out.println("+------------------------------------+");
			System.out.println("|           5. Mencari               |");
			System.out.println("+------------------------------------+");
			
			try {
				System.out.print("Masukan PIlihan : ");
				String input=in.next();
				switch (input) {
				case "1":
					testMenampilkanData();
					break;
				case "2":
					testMenambahkanData();
					break;
				case "3":
					testMerubahData();
					testMenampilkanData();
					break;
				case "4":
					testMenghapusData();
					testMenampilkanData();
					break;
				case "5":
					testMencariData();
					break;
				case "0":
					mainMenu();
					break;
				default:
					System.out.println("Masukan anda tidak valid !");
				}
			} catch (Exception e) {
				System.out.println("Exception Print !");
				System.out.println(e.getMessage());
			}		
	 }
	 public  void testMenampilkanData(){
			MdJadualHutangController mac=new MdJadualHutangController();
			try {
				JSONArray data = mac.getMenampilkanTabelJadualHutang();
				showData(data,"nip","urut","jumlah");
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}
	}
	 public  void testMenambahkanData(){
		 MdJadualHutangController mac=new MdJadualHutangController();
		 String nip,tgl_potong,kode_lbg,tgl_lunas; int urut,jumlah,kd_lunas;
			try {
				System.out.print("Masukkan nip (196811052007011027) : ");
				nip=in.next();
				System.out.print("Masukkan urut(mulai 1) : ");
				urut=in.nextInt();
				System.out.print("Masukkan tgl potong : ");
				tgl_potong=in.next();
				System.out.print("Masukkan kode_lbg(Mulai 001) : ");
				kode_lbg=in.next();
				System.out.print("Masukkan jumlah : ");
				jumlah=in.nextInt();
				System.out.print("Masukkan Kode lunas(mulai 101) : ");
				kd_lunas=in.nextInt();
				System.out.print("Masukkan tgl lunas : ");
				tgl_lunas=in.next();

				System.out.println("");
				mac.getMenambahkanTabelJadualHutang(nip, urut, tgl_potong, kode_lbg, jumlah, kd_lunas, tgl_lunas);

				JSONArray data = mac.getMencariTabelJadualHutang(urut);
				showData(data,"nip","urut","jumlah");
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}
	}
	 public  void testMenghapusData(){
		 MdJadualHutangController mac=new MdJadualHutangController();
			int urut;
			try {
				System.out.print("Masukkan No Urut : ");
				urut=in.nextInt();
				mac.getMenghapusTabelJadualHutang(urut);
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}
	}
	 public  void testMerubahData(){
		 MdJadualHutangController mac=new MdJadualHutangController();
			int jumlah,urut;
			try {
				System.out.print("Masukkan Jumlah : ");
				jumlah=in.nextInt();
				System.out.print("Masukkan No Urut : ");
				urut=in.nextInt();
				mac.getMerubahTabelJadualHutang(jumlah, urut);
				JSONArray data = mac.getMencariTabelJadualHutang(urut);
				showData(data,"nip","urut","jumlah");
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}
	}
	 public  void testMencariData(){
		 MdJadualHutangController mac=new MdJadualHutangController();
			int urut;
			try {
				System.out.print("Masukkan No urut : ");
				urut=in.nextInt();
				
				JSONArray data = mac.getMencariTabelJadualHutang(urut);
				showData(data,"nip","urut","jumlah");
			}catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
			}
	}
	 
	 public  void showData(JSONArray arrayData,String nip, String urut, String jumlah) {
			//System.out.println(arrayData);
			System.out.println("+-------------------------------------------+");
			System.out.println("|         nip         |   urut   |  Jumlah  |");
			System.out.println("+-------------------------------------------+");
			String space;
			for (int i = 0; i < arrayData.length(); i++) {
				JSONObject obj =  arrayData.getJSONObject(i);	
				space=obj.getString(nip);
				space=space.trim();
				
				System.out.print("| "+space);
				for (int x=0;x<20-space.length();x++) {
					System.out.print(" ");
				}
				System.out.print("|    "+obj.get(urut));
				for (int y=0;y<6-obj.get(urut).toString().length();y++) {
					System.out.print(" ");
				}
				System.out.print("|    "+obj.get(jumlah));
				for (int y=0;y<6-obj.get(jumlah).toString().length();y++) {
					System.out.print(" ");
				}
				
				System.out.print("|\n");
				System.out.println("+-------------------------------------------+");
			}
		}
	 
	 public static void main (String[] args) {
		 MdJadualHutangTest mat=new MdJadualHutangTest();
	 }
}
