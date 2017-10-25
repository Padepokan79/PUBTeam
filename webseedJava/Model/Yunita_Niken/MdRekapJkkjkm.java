package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;
@Table("rekap_jkkjkm")
@CompositePK({"tglgaji","KdJnsTrans"})
public class MdRekapJkkjkm extends Model{

}
