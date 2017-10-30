package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;


@Table("sertifikasi00")
@CompositePK({"Tglgaji","Nip"})
public class MdSertifikasi00 extends Model {

}
