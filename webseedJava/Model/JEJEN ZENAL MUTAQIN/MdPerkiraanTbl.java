package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;
@Table("perkiraan_tbl")
@CompositePK({"MA_INDUK","MA_TERPENCIL"})
public class MdPerkiraanTbl extends Model {

}
