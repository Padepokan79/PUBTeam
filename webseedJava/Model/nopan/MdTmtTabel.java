package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;
@Table("tmt_tabel")
@CompositePK({"nmtabel","tmtberlaku"})
public class MdTmtTabel extends Model{

}
