package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("user_akses")
@CompositePK({"kdskpd","pemakai"})
public class MdUserAkses extends Model{
	
}
