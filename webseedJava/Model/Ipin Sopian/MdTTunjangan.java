package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("t_tunjangan")
@CompositePK({"KDKEL","KDJAB"})
public class MdTTunjangan extends Model{

}
