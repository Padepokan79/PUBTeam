package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("tb_mata")
@CompositePK({"MA_INDUK", "MA_SATKER", "MA_GAPOK"})
public class MdTbMata extends Model{

}
