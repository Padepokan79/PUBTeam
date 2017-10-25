package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("fgaji_02")
@CompositePK({"TGLGAJI", "KDJNSTRANS","NIP"})
public class MdFGaji02 extends Model{

}
