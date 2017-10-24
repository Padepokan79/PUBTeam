package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;


@Table("fgaji_baru")
@CompositePK({"TGLGAJI","KDJNSTRANS","NIP","TGLBAYAR","norut"})
public class MdFGajiBaru extends Model{

}
