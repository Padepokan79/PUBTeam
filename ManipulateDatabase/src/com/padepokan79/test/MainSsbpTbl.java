package com.padepokan79.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.padepokan79.controller.MdSsbpTblController;



public class MainSsbpTbl {
	BufferedReader dataIn= new BufferedReader(new InputStreamReader(System.in));

	

////////////////////////MENAMPILKAN//////////////////////////////////////////////////////////////


public  void testqueryMenampilkanSsbpTbl() {
	MdSsbpTblController ag = new MdSsbpTblController();

try {
//System.out.print("Masukan Kode Agama : ");
//int inputKode=keyboard.nextInt();
JSONArray data = ag.getMenampilkanSsbpTbl();
showData_ssbp(data,"kdssbp","nmssbp","kdcabang");

} catch (Exception e) {
System.out.println("Inputan Salah, masukan angka 1 sampai 6");
System.out.println(e.getMessage());

}
mainMenu();
}
///////////////////////////////////////MENCARI///////////////////////////////////////////////
public  void testqueryMencariData() {
	MdSsbpTblController ag = new MdSsbpTblController();

try {
System.out.print("Masukan KDSSBP : ");
String kdssbp=dataIn.readLine();
JSONArray data = ag.getMencariData(kdssbp);
showData_ssbp(data,"kdssbp","nmssbp","kdcabang");
} catch (Exception e) {
System.out.println("Inputan Salah, masukan angka 1 sampai 6");
System.out.println(e.getMessage());

}
mainMenu();
}

///////////////////////////////////////MENAMBAH/////////////////////////////////////////////////////////
public  void testqueryMenambahkanSsbpTbl() {
	MdSsbpTblController ag = new MdSsbpTblController();

try {
System.out.print("Masukan KDSSBP : ");
String kdssbp=dataIn.readLine();
System.out.print("Masukan NMSSBP : ");
String nmssbp=dataIn.readLine();
System.out.print("Masukan KDCABANG : ");
String kdcabang=dataIn.readLine();
;
JSONArray data = ag.getMenambahkanSsbpTbl(kdssbp, nmssbp, kdcabang);
//showData_ttab2(data,"inputKode", "jenjab","agama");
} catch (Exception e) {
System.out.println("Inputan Salah");
System.out.println(e.getMessage());
}
mainMenu();
}
///////////////////////////////////////MENGUBAH///////////////////////////////////////////////////
public  void testqueryMengubahKodeKab() {
	MdSsbpTblController ag = new MdSsbpTblController();

try {

System.out.print("Masukan KDCABANG yang baru : ");
String kdcabang=dataIn.readLine();
System.out.print("Masukan KDSSBP yang akan dirubah : ");
String kdssbp=dataIn.readLine();


JSONArray data = ag.getMengubahKodeKab(kdcabang,kdssbp);
//showData_ttab2(data,"kode","agama");
} catch (Exception e) {
System.out.println("Inputan Salah");
System.out.println(e.getMessage());
}
mainMenu();
}
/////////////////////////////////////MENGHAPUS///////////////////////////////////////////////////
public  void testqueryHapusBerdasarkanKdssbp() {
	MdSsbpTblController ag = new MdSsbpTblController();

try {
System.out.print("Masukan KDSSBP yang akan di hapus : ");
String kdssbp=dataIn.readLine();


JSONArray data = ag.getHapusBerdasarkanKdssbp(kdssbp);
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
System.out.println("1. | Menampilkan Tabel Ssbp_Tbl     |");
System.out.println("2. | Mencari data Ssbp_Tbl          |");
System.out.println("3. | Menambahkan Ssbp_Tbl           |");
System.out.println("4. | Mengubah KDCABANG              |");
System.out.println("5. | Menghapus Data                 |");
System.out.println("====================================");
System.out.print("Masukan Menu : ");
try {
inp=dataIn.readLine();
switch (inp) {
case "1":
testqueryMenampilkanSsbpTbl();
break;
case "2":
testqueryMencariData();
break;
case "3":
testqueryMenambahkanSsbpTbl();
break;
case "4":
testqueryMengubahKodeKab();
case "5":
testqueryHapusBerdasarkanKdssbp();
default:
System.out.println("Masukan Salah !");
}
}catch (Exception e) {
System.out.println(e.getMessage());
}
}

//==================================================================
public  void showData_ssbp(JSONArray arrayData, String kdssbp, String nmssbp,String kdcabang) {
//System.out.println(arrayData);
System.out.println("+------------------------------------------------+");
System.out.println("| KDSSBP |          NMSSBP            | KDCABANG |");
System.out.println("+------------------------------------------------+");
String space;
//int tamp;

for (int i = 0; i < arrayData.length(); i++) {
JSONObject obj =  arrayData.getJSONObject(i);	

/*tamp=(int) obj.get(kode);
System.out.print("| "+tamp);*/

space=(String) obj.get(kdssbp);
System.out.print("|  "+space);

space=(String) obj.get(nmssbp);
System.out.print("   |"+ space);
for (int j = 0; j  < 16 - (space.length()); j++) {
System.out.print(" ");
}
space=String.valueOf(obj.get(kdcabang)) ;
System.out.print("            |"+ space);
for (int j = 0; j  < 10 - (space.length()); j++) {
System.out.print(" ");
}



System.out.println("|");
System.out.println("+------------------------------------------------+");
}
mainMenu();
}
public static void main(String args[]) {
MainSsbpTbl mMssbp = new MainSsbpTbl();
mMssbp.mainMenu();
}


}
