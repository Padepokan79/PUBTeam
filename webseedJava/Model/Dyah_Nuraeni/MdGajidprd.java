package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("fgaji_dprd")
@CompositePK({"nip","tglgaji","kdjnstrans"})
public class MdGajidprd extends Model{

}
