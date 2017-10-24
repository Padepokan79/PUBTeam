package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;
@Table("nomor_tbl")
@CompositePK({"tglgaji","kdjnstrans","kdskpd","kdtrans"})
public class MdNomorTbl extends Model{

}
