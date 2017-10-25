package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("tkd_tbl")
@CompositePK({"TMT","KDTKD"})
public class MdTkdTbl extends Model{

}
