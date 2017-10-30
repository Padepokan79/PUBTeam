package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;
@Table("historis_fungsional")
@CompositePK({"TMTGAJI","NIP"})
public class MdHistorisFungsional extends Model{

}
