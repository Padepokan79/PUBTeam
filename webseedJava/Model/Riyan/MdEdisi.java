package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("edisi")
@CompositePK({"TGLDB","TGLEDISI"})
public class MdEdisi extends Model {

}
