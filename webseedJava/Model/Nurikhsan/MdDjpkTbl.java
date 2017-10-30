package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;
@Table("djpk_tbl")
@CompositePK({"prov","Kab"})
public class MdDjpkTbl extends  Model{

}
