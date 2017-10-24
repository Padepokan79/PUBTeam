package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("koperasi_tbl")
@CompositePK({"TMT","KDKOPERASI"})
public class MdKoperasiTbl extends Model{

}
