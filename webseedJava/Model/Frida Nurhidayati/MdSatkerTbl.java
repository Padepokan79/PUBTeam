package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;
@Table("satker_tbl")
@CompositePK({"kdsatker","kdssbp","kdskpd"})
public class MdSatkerTbl extends Model{

}
