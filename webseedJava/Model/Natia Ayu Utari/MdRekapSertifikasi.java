package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("rekap_sertifikasi")
@CompositePK({"tglgaji","kdsatker"})
public class MdRekapSertifikasi extends Model {

}
