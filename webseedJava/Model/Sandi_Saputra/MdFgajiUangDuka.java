package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("FGaji_UangDuka")
@CompositePK({"TGLGAJI","KDJNSTRANS","NIP"})
public class MdFgajiUangDuka extends Model {

}
