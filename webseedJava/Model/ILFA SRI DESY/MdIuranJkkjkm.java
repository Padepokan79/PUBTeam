package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.IdName;
import org.javalite.activejdbc.annotations.Table;

@Table("iuran_jkkjkm")
@CompositePK({"nip","tglgaji","KdJnsTrans"})
public class MdIuranJkkjkm extends Model{

}
