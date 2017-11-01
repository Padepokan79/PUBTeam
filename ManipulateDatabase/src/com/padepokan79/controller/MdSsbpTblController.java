package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdSspbTbl;
import com.padepokan79.util.DatabaseConnection;

public class MdSsbpTblController extends DatabaseConnection implements MdSspbTbl{
//////////////////////////////////MENAMPILKAN//////////////////////////////////////////////////////////	
public JSONArray queryMenampilkanSsbpTbl(String query)throws SQLException{
PreparedStatement st = null;
try
{

st=(PreparedStatement) conn.prepareStatement(query);
//st.setInt(1, inputKode);

ResultSet rs = (ResultSet) st.executeQuery();
//return Convertor.convertToJSON(rs);
JSONArray result=Convertor.convertToJSON(rs);
rs=null;

if(st!=null){
st.close();
}
return result;


}catch (Exception e) {
//TODO: handle exception
}
return null;
}
////////////////////////////////////////////MENAMBAH////////////////////////////////////////
public JSONArray queryMenambahkanSsbpTbl(String query,String kdssbp,String nmssbp,String kdcabang){
try
{

PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
st.setString(1, kdssbp);
st.setString(2, nmssbp);	
st.setString(3, kdcabang);

st.executeUpdate();


//ResultSet rs = (ResultSet) st.executeQuery();
//return Convertor.convertToJSON(rs);

}catch (Exception e) {
//TODO: handle exception
}
return null;
}
//////////////////////////////////MENCARI//////////////////////////////////////////////////
public JSONArray queryMencariData(String query,String kdssbp){
try
{

PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);

st.setString(1, kdssbp);



ResultSet rs = (ResultSet) st.executeQuery();
return Convertor.convertToJSON(rs);

}catch (Exception e) {
//TODO: handle exception
}
return null;
}
//////////////////////////////////MENGUBAH//////////////////////////////////////////////////
public JSONArray queryMengubahKodeKab(String query,String kdssbp,String kdcabang){
try
{


PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);

st.setString(1, kdssbp);
st.setString(2, kdcabang);




st.executeUpdate();


}catch (Exception e) {
//TODO: handle exception
}
return null;
}
///////////////////////////////////MENGHAPUS/////////////////////////////////////////////////
public JSONArray queryHapusBerdasarkanKdssbp(String query,String kdssbp){
try
{

PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
st.setString(1, kdssbp);




st.executeUpdate();

//ResultSet rs = (ResultSet) st.executeQuery();
//return Convertor.convertToJSON(rs);

}catch (Exception e) {
//TODO: handle exception
}
return null;
}
//===========================MENAMPILKAN======================================================
public JSONArray getMenampilkanSsbpTbl(){
try
{
String query = menampilkanDataSsbpTbl;
return queryMenampilkanSsbpTbl(query);
}catch (Exception e) {
//TODO: handle exception
}
return null;
}
//================================MENAMBAH==================================================
public JSONArray getMenambahkanSsbpTbl(String kdssbp,String nmssbp,String kdcabang){
try
{
String query = menambahDataSsbpTbl;
return queryMenambahkanSsbpTbl(query,kdssbp,nmssbp,kdcabang);
}catch (Exception e) {
//TODO: handle exception
}
return null;
}
//====================================MENGUBAH==============================================
public JSONArray getMengubahKodeKab(String kdcabang,String kdssbp){
try
{
String query = mengubahKdcabangBerdasarkanKdssbp;
return queryMengubahKodeKab(query, kdcabang, kdssbp);
}catch (Exception e) {
//TODO: handle exception
}
return null;
}
//======================================MENGHAPUS============================================
public JSONArray getHapusBerdasarkanKdssbp(String kdssbp){
try
{
String query = hapusSsbpBerdasarkanKdssbp;
return queryHapusBerdasarkanKdssbp(query, kdssbp);
}catch (Exception e) {
//TODO: handle exception
}
return null;
}
//======================================MENCARI============================================
public JSONArray getMencariData(String kdssbp){
try
{
String query =mencariDataBerdasarkanKDSSBP;
return queryMencariData(query, kdssbp);
}catch (Exception e) {
//TODO: handle exception
}
return null;
}




}
