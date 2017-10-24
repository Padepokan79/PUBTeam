package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("close_gaji")
@CompositePK({"TGLGAJI", "KDJNSTRANS"})
public class MdCloseGaji extends Model {

}
