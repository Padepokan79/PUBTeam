package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("pendidikan_tbl")
@CompositePK({"JNSDIDIK", "KDDIDIK"})
public class MdPendidikanTbl extends Model{

}
