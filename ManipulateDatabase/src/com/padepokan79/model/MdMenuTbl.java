package com.padepokan79.model;

public interface MdMenuTbl {
	public final String tampilMenu="Select kd_menu,nama_menu from menu_tbl Where kd_menu =?";
	public final String tampilMenuAll="Select kd_menu,nama_menu from menu_tbl";
	public final String tambahMenu="Insert into menu_tbl values(?,?,?)";
	public final String deleteMenu = "delete from menu_tbl where kd_menu = ?;";
	public final String updateMenu = "update menu_tbl set nama_menu =? , form_menu = ? where kd_menu = ?;";
}
