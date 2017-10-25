package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("fgaji_lama_1")
@CompositePK({"tglgaji", "kdjnstrans", "nip"})
public class MdFgajiLama1 extends Model{

}
