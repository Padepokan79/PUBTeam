package com.padepokan79.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.padepokan79.model.Convertor;
import com.padepokan79.model.MdAkunsp2d;
import com.padepokan79.util.DatabaseConnection;

public class MdAkunsp2dController extends DatabaseConnection implements MdAkunsp2d{
//////////////////////////////////MENAMPILKAN//////////////////////////////////////////////////////////	
public JSONArray queryMenampilkanAkunsp2d(String query)throws SQLException{
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
// TODO: handle exception
}
return null;
}
////////////////////////////////////////////MENAMBAH////////////////////////////////////////
public JSONArray queryMenambahkanAkunsp2d(String query,String kdssbp,String kdskpd,int kdtrans,String kdakun,String nmakun){
try
{

PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
st.setString(1, kdssbp);
st.setString(2, kdskpd);	
st.setInt(3, kdtrans);
st.setString(4, kdakun);
st.setString(5, nmakun);

st.executeUpdate();


//ResultSet rs = (ResultSet) st.executeQuery();
//return Convertor.convertToJSON(rs);

}catch (Exception e) {
// TODO: handle exception
}
return null;
}
//////////////////////////////////MENCARI//////////////////////////////////////////////////
public JSONArray queryMencariData(String query,String kdssbp,String kdskpd,int kdtrans){
try
{

PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
st.setString(1, kdssbp);
st.setString(2, kdskpd);
st.setInt(3, kdtrans);



ResultSet rs = (ResultSet) st.executeQuery();
return Convertor.convertToJSON(rs);

}catch (Exception e) {
// TODO: handle exception
}
return null;
}
//////////////////////////////////MENGUBAH//////////////////////////////////////////////////
public JSONArray queryMengubahNmakunAkunsp2d(String query,String nmakun,String kdssbp,String kdskpd,int kdtrans){
try
{

	
PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);

st.setString(1, nmakun);
st.setString(2, kdssbp);
st.setString(3, kdskpd);
st.setInt(4, kdtrans);



st.executeUpdate();


}catch (Exception e) {
// TODO: handle exception
}
return null;
}
///////////////////////////////////MENGHAPUS/////////////////////////////////////////////////
public JSONArray queryHapusBerdasarkanKdskpdKdtrans(String query,String kdssbp, String kdskpd,int kdtrans){
try
{

PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
st.setString(1, kdssbp);
st.setString(2, kdskpd);
st.setInt(3, kdtrans);



st.executeUpdate();

//ResultSet rs = (ResultSet) st.executeQuery();
//return Convertor.convertToJSON(rs);

}catch (Exception e) {
// TODO: handle exception
}
return null;
}
//===========================MENAMPILKAN======================================================
public JSONArray getMenampilkanAkunsp2d(){
try
{
String query = menampilkanDataAkunsp2d;
return queryMenampilkanAkunsp2d(query);
}catch (Exception e) {
// TODO: handle exception
}
return null;
}
//================================MENAMBAH==================================================
public JSONArray getMenambahkanAkunsp2d(String kdssbp,String kdskpd,int kdtrans,String kdakun,String nmakun){
try
{
String query = menambahkanDataAkunsp2d;
return queryMenambahkanAkunsp2d(query,kdssbp,kdskpd,kdtrans,kdakun,nmakun);
}catch (Exception e) {
// TODO: handle exception
}
return null;
}
//====================================MENGUBAH==============================================
public JSONArray getMengubahNmakunAkunsp2d(String nmakun,String kdssbp,String kdskpd,int kdtrans){
try
{
String query = mengubahNmakunAkunsp2d;
return queryMengubahNmakunAkunsp2d(query,nmakun,kdssbp,kdskpd,kdtrans);
}catch (Exception e) {
// TODO: handle exception
}
return null;
}
//======================================MENGHAPUS============================================
public JSONArray getHapusBerdasarkanKdskpdKdtrans(String kdssbp,String kdskpd,int kdtrans){
try
{
String query = menghapusDataAkunsp2d;
return queryHapusBerdasarkanKdskpdKdtrans(query,kdssbp,kdskpd,kdtrans);
}catch (Exception e) {
// TODO: handle exception
}
return null;
}
//======================================MENCARI============================================
public JSONArray getMencariData(String kdssbp,String kdskpd,int kdtrans){
try
{
String query = mencariDataAkun;
return queryMencariData(query,kdssbp,kdskpd,kdtrans);
}catch (Exception e) {
// TODO: handle exception
}
return null;
}


}
