package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("fgaji_lama")
@CompositePK({"TGLGAJI","KDJNSTRANS","NIP","TGLBAYAR","norut"})
public class MdFgajiLama extends Model {

}
