package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("r_bpkp")
@CompositePK({"Bulan","kdskpd","kd_sumber"})
public class MdRBpkp extends Model{

}
