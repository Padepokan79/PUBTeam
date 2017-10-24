package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;


@Table("fgaji_Copy")
@CompositePK({"TGLGAJI","KDJNSTRANS","NIP"})
public class MdFgajiCopy extends Model{

}
