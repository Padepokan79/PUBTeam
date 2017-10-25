package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("struk_tbl")
@CompositePK({"Nip", "No_urt", "Kode_Lbg"})
public class MdStrukTbl extends Model {

}
