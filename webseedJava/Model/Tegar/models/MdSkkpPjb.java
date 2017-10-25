package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("skkp_pjb")
@CompositePK({"kddati1","kddati2"})
public class MdSkkpPjb extends Model {

}
