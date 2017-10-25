package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("fgaji_01")
@CompositePK({"TGLGAJI","KDJNSTRANS","NIP"})
public class MdFgaji01 extends Model{

}
