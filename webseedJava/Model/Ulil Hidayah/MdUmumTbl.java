package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("umum_tbl")
@CompositePK({"TMTBERLAKU","KDGOL"})
public class MdUmumTbl extends Model{

}
