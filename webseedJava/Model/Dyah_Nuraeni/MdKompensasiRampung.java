package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("kompensasi_rampung")
@CompositePK({"TGLGAJI","NIP"})
public class MdKompensasiRampung extends Model{

}
