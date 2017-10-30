package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;
@Table("tparam_tbl")
@CompositePK({"TMTBERLAKU","kddati1","kddati2"})
public class MdTParamTbl extends Model {

}
