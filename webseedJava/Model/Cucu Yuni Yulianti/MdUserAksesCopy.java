package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;
@Table("user_akses_copy")
@CompositePK({"pemakai", "kdskpd"})
public class MdUserAksesCopy extends Model{

}
