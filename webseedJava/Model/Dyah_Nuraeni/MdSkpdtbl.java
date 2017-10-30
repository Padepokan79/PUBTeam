package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("skpd_tbl")
@CompositePK({"kddati1","kddati2","kdssbp","kdskpd"})
public class MdSkpdtbl extends Model{

}
