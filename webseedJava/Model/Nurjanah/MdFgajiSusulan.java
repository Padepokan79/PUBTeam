package app.models;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("fgaji_susulan")
@CompositePK({"TGLGAJI","KDJNSTRANS","NIP","TGLRENCANA"})
public class MdFgajiSusulan extends Model {

}
