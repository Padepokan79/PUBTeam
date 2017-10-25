package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("gaji_tht0_tbl")
@CompositePK({"nip","tglgaji","kdjnstrans"})
public class MdGajiTht0Tbl extends Model {

}
