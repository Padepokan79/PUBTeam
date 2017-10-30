package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("tb_lain")
@CompositePK({"askes","biaya"})
public class MdTbLain extends Model{

}
