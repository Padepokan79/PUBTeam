package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("nomorsp2d")
@CompositePK({"tglgaji","kdjnstrans","kdskpd"})
public class MdNomorsp2d extends Model {

}
