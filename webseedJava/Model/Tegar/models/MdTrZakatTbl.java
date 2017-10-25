package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("trzakat_tbl")
@CompositePK({"kd_zakat","kdpangkat","tmt_berlaku"})
public class MdTrZakatTbl extends Model {

}
