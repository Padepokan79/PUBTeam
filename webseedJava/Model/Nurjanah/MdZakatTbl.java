package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("zakat_tbl")
@CompositePK({"NIP","blthgaji","kdjnstrans"})
public class MdZakatTbl extends Model{

}
