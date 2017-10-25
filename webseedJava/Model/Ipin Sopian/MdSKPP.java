package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("skpp")
@CompositePK({"TGLGAJI","KDJNSTRANS","JNSSKPP","NIP"})
public class MdSKPP extends Model{

}
