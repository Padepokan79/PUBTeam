package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;
@Table("seluma04")
@CompositePK({"FD_SATKER1","FD_SATKER2","FD_KDGIAT"})
public class MdSeluma04 extends Model{

}
