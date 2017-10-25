package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("ref_rek_5_x")
@CompositePK({"Kd_Rek_1","Kd_Rek_2","Kd_Rek_3","Kd_Rek_4","Kd_Rek_5"})
public class MdRefRek5X extends Model{

}
