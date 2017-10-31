package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdAkunsp2dController;

public class MainAkunsp2d {
	/*public  Scanner keyboard = new Scanner( System.in );*/
	BufferedReader dataIn= new BufferedReader(new InputStreamReader(System.in));

	

////////////////////////MENAMPILKAN//////////////////////////////////////////////////////////////


public  void testqueryMenampilkanAkunsp2d() {
MdAkunsp2dController ag = new MdAkunsp2dController();

try {
//System.out.print("Masukan Kode Agama : ");
//int inputKode=keyboard.nextInt();
JSONArray data = ag.getMenampilkanAkunsp2d();
showData_akun(data,"kdssbp","kdskpd","kdtrans","kdakun","nmakun");

} catch (Exception e) {
System.out.println("Inputan Salah, masukan angka 1 sampai 6");
System.out.println(e.getMessage());

}
mainMenu();
}
///////////////////////////////////////MENCARI///////////////////////////////////////////////
public  void testqueryMencariData() {
MdAkunsp2dController ag = new MdAkunsp2dController();

try {
	System.out.print("Masukan KDSSBP : ");
	String kdssbp=dataIn.readLine();
System.out.print("Masukan KDSKPD : ");
String kdskpd=dataIn.readLine();
System.out.print("Masukan KDTRANS : ");
int kdtrans=Integer.parseInt(dataIn.readLine());
JSONArray data = ag.getMencariData(kdssbp,kdskpd,kdtrans);
showData_akun(data,"kdssbp","kdskpd","kdtrans","kdakun","nmakun");
} catch (Exception e) {
System.out.println("Inputan Salah, masukan angka 1 sampai 6");
System.out.println(e.getMessage());

}
mainMenu();
}

///////////////////////////////////////MENAMBAH/////////////////////////////////////////////////////////
public  void testqueryMenambahkanAkunsp2d() {
	MdAkunsp2dController ag = new MdAkunsp2dController();

try {
System.out.print("Masukan KDSSBP : ");
String kdssbp=dataIn.readLine();
System.out.print("Masukan KDSKPD : ");
String kdskpd=dataIn.readLine();
System.out.print("Masukan KDTRANS : ");
int kdtrans=Integer.parseInt(dataIn.readLine());
System.out.print("Masukan KDAKUN : ");
String kdakun=dataIn.readLine();
System.out.print("Masukan NMAKUN : ");
String nmakun=dataIn.readLine();
JSONArray data = ag.getMenambahkanAkunsp2d(kdssbp,kdskpd,kdtrans,kdakun,nmakun);
//showData_ttab2(data,"inputKode", "jenjab","agama");
} catch (Exception e) {
System.out.println("Inputan Salah");
System.out.println(e.getMessage());
}
mainMenu();
}
///////////////////////////////////////MENGUBAH///////////////////////////////////////////////////
public  void testqueryMengubahNmakunAkunsp2d() {
	MdAkunsp2dController ag = new MdAkunsp2dController();

try {
	
	System.out.print("Masukan NNMAKUN yang baru : ");
	String nmakun=dataIn.readLine();
	System.out.print("Masukan KDSSBP yang akan dirubah : ");
	String kdssbp=dataIn.readLine();
System.out.print("Masukan KDSKPD yang akan dirubah : ");
String kdskpd=dataIn.readLine();
System.out.print("Masukan KDTRANS yang akan dirubah : ");
int kdtrans=Integer.parseInt(dataIn.readLine());

JSONArray data = ag.getMengubahNmakunAkunsp2d(nmakun,kdssbp,kdskpd,kdtrans);
//showData_ttab2(data,"kode","agama");
} catch (Exception e) {
System.out.println("Inputan Salah");
System.out.println(e.getMessage());
}
mainMenu();
}
/////////////////////////////////////MENGHAPUS///////////////////////////////////////////////////
public  void testqueryHapusBerdasarkanKdskpdKdtrans() {
	MdAkunsp2dController ag = new MdAkunsp2dController();

try {
	System.out.print("Masukan KDSSBP yang akan di hapus : ");
	String kdssbp=dataIn.readLine();
System.out.print("Masukan KDSKPD yang akan di hapus : ");
String kdskpd=dataIn.readLine();
System.out.print("Masukan KDTRANS yang akan di hapus : ");
int kdtrans=Integer.parseInt(dataIn.readLine());
JSONArray data = ag.getHapusBerdasarkanKdskpdKdtrans(kdssbp,kdskpd,kdtrans);
//showData_agama(data,"kdagama","nmagama");
} catch (Exception e) {
System.out.println("Inputan Salah");
System.out.println(e.getMessage());

}
mainMenu();
}
//////////////////////////////////////////MENU///////////////////////////////////////////////
public  void mainMenu()  {
String inp;

System.out.println("====================================");
System.out.println("1. | Menampilkan Tabel Akunsp2d     |");
System.out.println("2. | Mencari data Akunskp2d         |");
System.out.println("3. | Menambahkan Akunskp2d          |");
System.out.println("4. | Mengubah Nama Akun             |");
System.out.println("5. | Menghapus Data                 |");
System.out.println("====================================");
System.out.print("Masukan Menu : ");
try {
inp=dataIn.readLine();
switch (inp) {
case "1":
testqueryMenampilkanAkunsp2d();
break;
case "2":
testqueryMencariData();
break;
case "3":
testqueryMenambahkanAkunsp2d();
break;
case "4":
testqueryMengubahNmakunAkunsp2d();
case "5":
testqueryHapusBerdasarkanKdskpdKdtrans();
default:
System.out.println("Masukan Salah !");
}
}catch (Exception e) {
System.out.println(e.getMessage());
}
}

//==================================================================
public  void showData_akun(JSONArray arrayData, String kdssbp, String kdskpd,String kdtrans,String kdakun,String nmakun) {
//System.out.println(arrayData);
System.out.println("+------------------------------------------------------------------------------------------+");
System.out.println("| KDSSBP | KDSKPD | KDTRANS|            KDAKUN              |             NMAKUN           |");
System.out.println("+------------------------------------------------------------------------------------------+");
String space;
int tamp;

for (int i = 0; i < arrayData.length(); i++) {
JSONObject obj =  arrayData.getJSONObject(i);	

/*tamp=(int) obj.get(kode);
System.out.print("| "+tamp);*/

space=(String) obj.get(kdssbp);
System.out.print("| "+space);

space=(String) obj.get(kdskpd);
System.out.print("    | "+ space);
for (int j = 0; j  < 6 - (space.length()); j++) {
System.out.print(" ");
}
space=String.valueOf(obj.get(kdtrans)) ;
System.out.print(" | "+ space);
for (int j = 0; j  < 6 - (space.length()); j++) {
System.out.print(" ");
}
space=(String) obj.get(kdakun);
System.out.print(" | "+ space);
for (int j = 0; j  < 6 - (space.length()); j++) {
System.out.print(" ");
}

space=(String) obj.get(nmakun);
System.out.print(" |"+ space);
for (int j = 0; j  < 16 - (space.length()); j++) {
System.out.print(" ");
}
System.out.println("|");
System.out.println("+------------------------------------------------------------------------------------------+");
}
mainMenu();
}
public static void main(String args[]) {
MainAkunsp2d mMakun = new MainAkunsp2d();
mMakun.mainMenu();
}


}
