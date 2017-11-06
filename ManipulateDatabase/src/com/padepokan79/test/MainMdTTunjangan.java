package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdIrdhataController;
import com.padepokan79.controller.MdTTunjanganController;
import com.padepokan79.model.MdTTunjangan;

public class MainMdTTunjangan {

	//Scanner dataIn=new Scanner(System.in);
			BufferedReader dataIn= new BufferedReader(new InputStreamReader(System.in));
			public void mainMenu () {

				System.out.println("+-------------------------------------------------------------------+");
				System.out.println("|                           Tunjangan                               |");
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
						MenampilkanTunjangan();
						break;
					case "2":
						MenambahkanTunjangan();
						break;
					case "3":
						mengubahDataTunjangan();
						break;
					case "4":
						mencariDataTunjangan();
						break;
					case "5":
						hapusDataTunjangan();
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
			public  void MenampilkanTunjangan(){
				MdTTunjanganController mtc =new MdTTunjanganController();
				JSONArray data = mtc.getQueryMenampilkanTunjangan(); 
				showData2(data,"kdkel","kdjab","nmjabatan","jml","pensiun");
			}

			public  void MenambahkanTunjangan(){
				MdTTunjanganController mic =new MdTTunjanganController();
				String kdkel, kdjab,  nmjabatan;
				int jml,pensiun;
				try{
					System.out.print("Masukan Kode Kel : ");
					kdkel=dataIn.readLine();
					System.out.print("Masukan kode Jabatan : ");
					kdjab=dataIn.readLine();
					System.out.print("Masukan Jabatan : ");
					nmjabatan=dataIn.readLine();
					System.out.print("Masukan nilai Tunjangan : ");
					jml=Integer.parseInt(dataIn.readLine());
					System.out.print("Masukan Waktu Pensiun : ");
					pensiun=Integer.parseInt(dataIn.readLine());
					mic.getQueryInsertDataTunjangan(kdkel, kdjab, nmjabatan, jml, pensiun);
					mainMenu();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}

			public  void mengubahDataTunjangan(){
				MdTTunjanganController mic =new MdTTunjanganController();
				String kdkel, kdjab,  nmjabatan;
				int jml,pensiun;
				try{
					System.out.print("Masukan Kode Kel yang ingin dirubah : ");
					kdkel=dataIn.readLine();
					System.out.print("Masukan kode Jabatan  yang ingin dirubah : ");
					kdjab=dataIn.readLine();
					System.out.print("Masukan Jabatan : ");
					nmjabatan=dataIn.readLine();
					System.out.print("Masukan nilai Tunjangan : ");
					jml=Integer.parseInt(dataIn.readLine());
					System.out.print("Masukan Waktu Pensiun : ");
					pensiun=Integer.parseInt(dataIn.readLine());
					mic.getQueryUpdateDataTunjangan(kdkel, kdjab, nmjabatan, jml, pensiun);
					mainMenu();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}

			public  void hapusDataTunjangan() throws IOException{
				MdTTunjanganController mci =new MdTTunjanganController();
				String kdkel, kdjab;
				System.out.print("Masukan Kode Kel yang ingin dihapus : ");
				kdkel=dataIn.readLine();
				System.out.print("Masukan kode Jabatan  yang ingin dihapus : ");
				kdjab=dataIn.readLine();
				mci.getQueryDeleteDataTunjangan(kdkel, kdjab);
				mainMenu();
			}

			public  void mencariDataTunjangan() throws IOException{
				MdTTunjanganController mhe =new MdTTunjanganController();
				String kdjab;
				System.out.print("Masukan Kode Jab : ");
				kdjab=dataIn.readLine();
				JSONArray data = mhe.getQuerySearchTunjangan(kdjab);
				showData2(data,"kdkel","kdjab","nmjabatan","jml","pensiun");
			}

			public  void showData2(JSONArray arrayData,String fieldkel ,String fieldjab, String fieldnm, String fieldjml,String pensi) {
				//System.out.println(arrayData);
				System.out.println("+------------------------------------------------------------------------------------+");
				System.out.println("| Kode Kel | Kode Jab |             Nama Jabatan           | Jml Tunjangan | Pensiun |");
				System.out.println("+------------------------------------------------------------------------------------+");
				String space;

				for (int i = 0; i < arrayData.length(); i++) {
					JSONObject obj =  arrayData.getJSONObject(i);	
					System.out.print("|    "+obj.get(fieldkel));
					space=(String) obj.get(fieldjab);
					space = space.trim();
					System.out.print("   |    "+space);
					
					space=(String) ( obj.get(fieldnm));
					space = space.trim();

					System.out.print("    | "+space);
					for (int j = 0; j  <34-(space.length()); j++) {
						System.out.print(" ");
					}
					System.out.print(" | ");
					space=String.valueOf((obj.get(fieldjml)));
					space = space.trim();
					for (int j = 0; j  <11-(space.length()); j++) {
						System.out.print(" ");
					}
					System.out.print(space +"   |    ");
					System.out.println(obj.get(pensi)+"   |");
					System.out.println("+------------------------------------------------------------------------------------+");
				}

				mainMenu();
			}


			public static void main(String args[]){
				MainMdTTunjangan mm=new MainMdTTunjangan();
				mm.mainMenu();
			}
		
}
