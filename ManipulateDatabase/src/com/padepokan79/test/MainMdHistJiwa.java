package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdHistJiwaController;

public class MainMdHistJiwa {
	int inputInt;
	String inputStr1;
	String inputStr2;
	String inputStr3;
	String nip,tmtberlaku,nomorskep,tglskep,penerbitskep,tglupdate;
	int jistri,janak;
	BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
	
//	Searching data penerbitskep by Jejen
	public  void MencariDataHistJiwa(){
		MdHistJiwaController hj = new MdHistJiwaController();
		try {
			System.out.print("Masukan NIP : ");
			 inputStr1= dataIn.readLine();
			JSONArray data = hj.getQueryMencariDataHistJiwa(inputStr1);
			showData_histJiwaPenerbit(data, "nip", "penerbitskep");
		}catch (Exception e) {
			System.out.println("Inputan Salah");
			System.out.println(e.getMessage());
		}
	}
	
//	Menampilkan data Hist Jiwa by Jejen	
	public  void MenampilkanHistJiwa(){
		MdHistJiwaController hj = new MdHistJiwaController();
			JSONArray data = hj.getQueryMenampilkanHistJiwa();
			showData_histJiwa(data, "nip", "tmtberlaku", "penerbitskep");
	}	
	
//	Mengubah data Hist Jiwa by Jejen
	public  void MengubahPenerbitdiHistJiwa(){
		MdHistJiwaController hj = new MdHistJiwaController();
			System.out.print("Masukan NIP yang akan di ubah : ");
			try {
				inputStr1 = dataIn.readLine();
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			System.out.print("Masukan TMTberlaku yang akan di ubah : ");
			try {
				inputStr2 = dataIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.print("Masukan Penerbitnya  : ");
			try {
				inputStr3 = dataIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			hj.getQueryMengubahPenerbitdiHistJiwa(inputStr1, inputStr2, inputStr3);
			System.out.println("UPDATE SUCCESS !!");
	}	

//	Menghapus data Hist Jiwa by Jejen
	public  void MenghapusDataHistJiwa(){
		MdHistJiwaController hj = new MdHistJiwaController();
			System.out.print("Masukan NIP yang akan di hapus : ");
			try {
				inputStr1 = dataIn.readLine();
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			System.out.print("Masukan TMT berlaku yang akan di hapus : ");
			try {
				inputStr2 = dataIn.readLine();
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			hj.getQueryMenghapusDataHistJiwa(inputStr1, inputStr2);
			System.out.println("DELETE SUCCESS !!");
	}
//	Menambah data Jenis Skpp by Jejen
	public  void MenambahDataHistJiwa(){
		MdHistJiwaController hj = new MdHistJiwaController();
			System.out.print("Masukan Nip : ");
			try {
				nip = dataIn.readLine();
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			System.out.print("Masukan TmtBerlaku : ");
			try {
				tmtberlaku = dataIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.print("Masukan jistri : ");
			try {
				jistri = Integer.parseInt(dataIn.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.print("Masukan janak : ");
			try {
				janak = Integer.parseInt(dataIn.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.print("Masukan nomorskep : ");
			try {
				nomorskep = dataIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.print("Masukan tglskep : ");
			try {
				tglskep = dataIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.print("Masukan penerbitskep : ");
			try {
				penerbitskep = dataIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.print("Masukan tglupdate : ");
			try {
				tglupdate = dataIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			hj.getQueryMenambahJenisSkpp(nip, tmtberlaku, jistri, janak, nomorskep, tglskep, penerbitskep, tglupdate);
			System.out.println("DATA BARU SUCCESS DI TAMBAHKAN !!");
	}	
	public  void backto()  {
		String inp;
		System.out.println("\n====================================================");
		System.out.println("==                CRUD TABEL hist_jiwa            ==");
		System.out.println("====================================================");
		System.out.println("1. Menampilkan data hist_jiwa  ");
		System.out.println("2. Mencari data hist_jiwa ");
		System.out.println("3. Menambahkan data hist_jiwa ");
		System.out.println("4. Mengubah data hist_jiwa ");
		System.out.println("5. Menghapus data hist_jiwa ");
		try {
			System.out.print("Input Pilihan : ");
			inp=dataIn.readLine();
			System.out.println("====================================================\n");
			switch (inp) {
			case "1":
				MenampilkanHistJiwa();
				break;
			case "2":
				MencariDataHistJiwa();
				break;
			case "3":
				MenambahDataHistJiwa();
				break;
			case "4":
				MengubahPenerbitdiHistJiwa();
				break;
			case "5":
				MenghapusDataHistJiwa();
				break;
			default:
				System.out.println("Masukan Salah !");
			}
			backto();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public  void showData_histJiwaPenerbit(JSONArray arrayData, String nip, String penerbitSkep) {
		//System.out.println(arrayData);
		System.out.println("+-------------------------------------------+");
		System.out.println("|      NIP       |       Penerbit Skep      |");
		System.out.println("+-------------------------------------------+");
		String space;
		String tamp;

		for (int i = 0; i < arrayData.length(); i++) {
			JSONObject obj =  arrayData.getJSONObject(i);	

			tamp=(String) obj.get(nip);
			System.out.print("| "+tamp);

			space=(String) obj.get(penerbitSkep);
			System.out.print("            | "+ space);
			for (int j = 0; j  < 25 - (space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			System.out.println("+-------------------------------------------+");
		}
		backto();
	}
	
	public  void showData_histJiwa(JSONArray Data,String p1, String p2, String p3 )
	{
		System.out.println();
		System.out.println("+--------------------------------------------------------------------------+");
		System.out.println("| 	NIP	   |          TMT BERLAKU       |    PENERBIT SKEP        |");
		System.out.println("+--------------------------------------------------------------------------+");
		String space;
				//System.out.println(Data);
		for (int i = 0; i < Data.length(); i++) {
			JSONObject obj =  Data.getJSONObject(i);	
			
			//System.out.println("halo");
			System.out.print("|       "+obj.get(p1));
			
			space=String.valueOf(obj.get(p2)) ;
			System.out.print("        |      "+space);
			
			
			space=(String) obj.get(p3);
			System.out.print("            | "+ space);
			for (int j = 0; j  < 25 - (space.length()); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			

			System.out.println("+--------------------------------------------------------------------------+");
		} backto();
	}	
	
	public static void main(String[] args) {
		MainMdHistJiwa newMenu = new MainMdHistJiwa();
		newMenu.backto();
	}
}
