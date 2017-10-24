package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;


@Table("gaji_13_tmp")
@CompositePK({"tglgaji","kdjnstrans","nip"})
public class MdGaji13Tmp extends Model{

}
