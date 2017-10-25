package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("terpencil_tbl")
@CompositePK({"TMTBERLAKU","KDDAERAH"})
public class MdTerpencilTbl extends Model {

}
