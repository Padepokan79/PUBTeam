package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;


@Table("tzakat_tbl")
@CompositePK({"nip","blthgaji","kdjnstrans"})
public class MdTzakatTbl extends Model {

}
