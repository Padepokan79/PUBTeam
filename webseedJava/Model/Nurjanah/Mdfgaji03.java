package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("fgaji_03")
@CompositePK({"TGLGAJI","KDJNSTRANS","NIP"})
public class Mdfgaji03 extends Model {

}
