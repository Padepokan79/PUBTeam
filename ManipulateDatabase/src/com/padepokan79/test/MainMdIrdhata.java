package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdIrdhataController;
import com.padepokan79.model.MdIrdhata;

public class MainMdIrdhata {

	
		//Scanner dataIn=new Scanner(System.in);
		BufferedReader dataIn= new BufferedReader(new InputStreamReader(System.in));
		public void mainMenu () {

			System.out.println("+-------------------------------------------------------------------+");
			System.out.println("|                             Irdhata                               |");
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
					MenampilkanIrdhata();
					break;
				case "2":
					MenambahkanIrdhata();
					break;
				case "3":
					mengubahDataIrdhata();
					break;
				case "4":
					mencariDataIrdata();
					break;
				case "5":
					hapusDataIrdhata();
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

		//tmt= ? , kdirdhata= ? , nilai=? , keter = ? "
		public  void MenampilkanIrdhata(){
			MdIrdhataController mic =new MdIrdhataController();
			JSONArray data = mic.getQueryMenampilkanDataIrdhata(); 
			showData2(data,"tmt","kdirdhata","nilai","keter");
		}

		public  void MenambahkanIrdhata(){
			MdIrdhataController mic =new MdIrdhataController();
			String tmt, kdirdhata,  keter;
			int nilai;
			try{
				System.out.print("Masukan tanggal mulai tugas (yyyy-mm-dd) : ");
				tmt=dataIn.readLine();
				System.out.print("Masukan kode irdhata : ");
				kdirdhata=dataIn.readLine();
				System.out.print("Masukan nilai iuran : ");
				nilai=Integer.parseInt(dataIn.readLine());
				System.out.print("Masukan Keterengan : ");
				keter=dataIn.readLine();
				mic.getQueryInsertDataTerusan(tmt, kdirdhata, nilai, keter);
				mainMenu();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

		public  void mengubahDataIrdhata(){
			MdIrdhataController mci =new MdIrdhataController();
			String tmt, kdirdhata,  keter;
			int nilai;
			try{
				System.out.print("Masukan kode irdhata yang ingin dirubah : ");
				kdirdhata=dataIn.readLine();
				System.out.print("Masukan tanggal mulai tugas (yyyy-mm-dd) : ");
				tmt=dataIn.readLine();
				System.out.print("Masukan nilai iuran : ");
				nilai=Integer.parseInt(dataIn.readLine());
				System.out.print("Masukan Keterengan : ");
				keter=dataIn.readLine();
				mci.getQueryUpdateDataIrdhata(tmt, kdirdhata, nilai, keter);
				mainMenu();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		public  void hapusDataIrdhata() throws IOException{
			MdIrdhataController mci =new MdIrdhataController();
			String kdirdhata;

			System.out.print("Masukan Nip data yang ingin dihapus : ");
			kdirdhata=dataIn.readLine();

			mci.getQueryDeleteDataIrdhata(kdirdhata);
			mainMenu();
		}

		public  void mencariDataIrdata() throws IOException{
			MdIrdhataController mhe =new MdIrdhataController();
			String kdirdhata;

			System.out.print("Masukan Nip data yang ingin dicari : ");
			kdirdhata=dataIn.readLine();
			JSONArray data = mhe.getQuerySearchIrdhata(kdirdhata); 
			showData2(data,"tmt","kdirdhata","nilai","keter");
		}

		public  void showData2(JSONArray arrayData,String fieldtmt ,String fieldnip, String fieldkode, String fieldtj) {
			//System.out.println(arrayData);
			System.out.println("+--------------------------------------------------------------+");
			System.out.println("| TMT iuran  | Irdhata |  Iuran  |        Keterangan           |");
			System.out.println("+--------------------------------------------------------------+");
			String space;

			for (int i = 0; i < arrayData.length(); i++) {
				JSONObject obj =  arrayData.getJSONObject(i);	
				System.out.print("| "+obj.get(fieldtmt));
				space=(String) obj.get(fieldnip);
				space = space.trim();

				System.out.print(" | "+space);
				for (int j = 0; j  <8-(space.length()); j++) {
					System.out.print(" ");
				}
				space=String.valueOf( obj.get(fieldkode));
				space = space.trim();

				System.out.print("| "+space);
				for (int j = 0; j  <6-(space.length()); j++) {
					System.out.print(" ");
				}
				System.out.print("  | ");
				space=(String) (obj.get(fieldtj));
				space = space.trim();
				for (int j = 0; j  <26-(space.length()); j++) {
					System.out.print(" ");
				}
				System.out.println(space +"  |");
				System.out.println("+--------------------------------------------------------------+");
			}

			mainMenu();
		}


		public static void main(String args[]){
			MainMdIrdhata mm=new MainMdIrdhata();
			mm.mainMenu();
		}
	

}
