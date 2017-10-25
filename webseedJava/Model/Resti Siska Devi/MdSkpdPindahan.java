package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("skpd_pindahan")
@CompositePK({"Kddati1", "KdDati2", "KDSKPD_L", "KDSSBP"})
public class MdSkpdPindahan extends Model{

}
