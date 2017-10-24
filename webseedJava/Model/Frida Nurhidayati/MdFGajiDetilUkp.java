package app.models;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("fgaji_detil_ukp")
@CompositePK({"TGLGAJI","KDJNSTRANS","NIP"})
public class MdFGajiDetilUkp extends Model {

}
