package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdHistorisGapokController;


public class MainMdHistorisGapok {
	public  Scanner keyboard = new Scanner( System.in );
	BufferedReader dataIn= new BufferedReader(new InputStreamReader(System.in));
	public void mainMenu () {

		System.out.println("+-------------------------------------------------------------------+");
		System.out.println("|                       Historis Eselon                             |");
		System.out.println("|-------------------------------------------------------------------|");
		System.out.println("| 1. Read Data          | 2. Insert Data     | 3. Update Data       |");
		System.out.println("|-------------------------------------------------------------------|");
		System.out.println("| 4. Search Data        | 5. Delete Data     | 0. Menu Utama        |");
		System.out.println("+-------------------------------------------------------------------+");

		try {
			System.out.print("Masukan PIlihan : ");
			String input=dataIn.readLine();
			switch (input) {
			case "1":
				testMenampilkanHistorisGapok();
				break;
			case "2":
				testqueryMenambahHistorisGapok();
				break;
			case "3":
				MengubahHistorisGapok();
				break;
			case "4":
				testqueryMencariHistorisGapok();
				break;
			case "5":
				hapusHistorisGapok();
				break;
			case "0":
			default:
				System.out.println("Masukan anda tidak valid !");
			}

		} catch (Exception e) {
			System.out.println("Exception Print !");
			System.out.println(e.getMessage());
		}

	}
		
		public  void testqueryMencariHistorisGapok() {
			MdHistorisGapokController hg = new MdHistorisGapokController();
			
			try {
				System.out.print("Masukan NIP : ");
				String inputKode=keyboard.nextLine();
				JSONArray data = hg.getMencariHistorisGapok(inputKode);
				showData_HistorisGapok(data,"tmtgaji","gapok");
			} catch (Exception e) {
				System.out.println("Inputan Salah");
				System.out.println(e.getMessage());
				 
			}
		}
		public MainMdHistorisGapok(){
			testqueryMencariHistorisGapok();
		}
		
		public  void testqueryMenambahHistorisGapok(){
			MdHistorisGapokController hg =new MdHistorisGapokController();
			String tmtgaji, nip, kdpangkat,tmttabel, tglskep, nomorskep, penerbitskep, tmt, keterangan, tglupdate;
			int gapok, masker, prsngapok,  kdstapeg;
			
			try{
				System.out.print("Masukan tmtgaji : ");
				tmtgaji=dataIn.readLine();
				
				System.out.print("Masukan nip : ");
				nip=dataIn.readLine();
				
				System.out.print("Masukan kdstapeg : ");
				kdstapeg=Integer.parseInt(dataIn.readLine());
				
				System.out.print("Masukan kdpangkat : ");
				kdpangkat=dataIn.readLine();
				
				System.out.print("Masukan gapok : ");
				gapok=Integer.parseInt(dataIn.readLine());
				
				System.out.print("Masukan masker : ");
				masker=Integer.parseInt(dataIn.readLine());
				
				System.out.print("Masukan prsngapok : ");
				prsngapok=Integer.parseInt(dataIn.readLine());
				
				System.out.print("Masukan tmttabel : ");
				tmttabel=dataIn.readLine();
				
				System.out.print("Masukan tglskep : ");
				tglskep=dataIn.readLine();
				
				System.out.print("Masukan nomorskep : ");
				nomorskep=dataIn.readLine();
				
				System.out.print("Masukan penerbitskep : ");
				penerbitskep=dataIn.readLine();
				
				System.out.print("Masukan tmt : ");
				tmt=dataIn.readLine();
				
				System.out.print("Masukan keterangan : ");
				keterangan=dataIn.readLine();
				
				System.out.print("Masukan tglupdate : ");
				tglupdate=dataIn.readLine();
				
				hg.getMenambahHistorisGapok(tmtgaji, nip, kdstapeg, kdpangkat, gapok, masker, prsngapok, tmttabel, tglskep, nomorskep, penerbitskep, tmt, keterangan, tglupdate);
				mainMenu();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		public  void MengubahHistorisGapok(){
			MdHistorisGapokController hg =new MdHistorisGapokController();
			String tmtgaji,nip;
			int gapok;
			
			try{
				
				System.out.print("Masukan gapok yang akan di ubah: ");
				gapok=Integer.parseInt(dataIn.readLine());
				System.out.print("Masukan tmtgaji : ");
				tmtgaji=dataIn.readLine();
				System.out.print("Masukan nip : ");
				nip=dataIn.readLine();
				hg.getMengeditHistorisGapok(tmtgaji, nip, gapok);
				mainMenu();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		public  void testMenampilkanHistorisGapok(){
			MdHistorisGapokController hg =new MdHistorisGapokController();
			JSONArray data = hg.getMenampilkanTabelHistorisGapok(); 
			showData_HistorisGapok(data, "tmtgaji", "nip");
		}
		
		public  void hapusHistorisGapok() throws IOException{
			MdHistorisGapokController hg =new MdHistorisGapokController();
			String tmtgaji,nip;

			System.out.print("Masukan tmtgaji : ");
			tmtgaji=dataIn.readLine();
			System.out.print("Masukan nip : ");
			nip=dataIn.readLine();
			hg.getMenghapusHistorisGapok(tmtgaji, nip);			
			mainMenu();
		}
		
//		public  void backto()  {
//			String inp;
//			MainActivity ma = new MainActivity();
//			System.out.print("1. Menu Utama 2. Submenu Mencari Agama Berdasarkan Kode  : ");
//			try {
//				inp=keyboard.next();
//				switch (inp) {
//				case "1":
//					ma.menuUtama();;
//					break;
//				case "2":
//					testqueryMencariNamaAgama();
//					break;
//				default:
//					System.out.println("Masukan Salah !");
//				}
//			}catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}
		public  void showData_HistorisGapok(JSONArray arrayData, String tmtgaji, String nip) {
			//System.out.println(arrayData);
			System.out.println("+----------------------------------+");
			System.out.println("| TMTGAJI    | NIP      |");
			System.out.println("+----------------------------------+");
			String space;
			String tamp;

			for (int i = 0; i < arrayData.length(); i++) {
				JSONObject obj =  arrayData.getJSONObject(i);	

				tamp=(String) obj.get(tmtgaji);
				System.out.print("| "+tamp);

				space=(String) obj.get(nip);
				System.out.print("              | "+ space);
				for (int j = 0; j  < 20 - (space.length()); j++) {
					System.out.print(" ");
				}
				System.out.println("|");
				System.out.println("+----------------------------------+");
			}
			//backto();
			//add by Hendra YN
		}
		public static void main(String args[]) {
			MainMdHistorisGapok mainMdHistorisGapok = new MainMdHistorisGapok();
			mainMdHistorisGapok.mainMenu();
		}

}
