package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("historis_stapeg")
@CompositePK({"TMTGAJI","NIP"})
public class MdhistorisStapeg extends Model{

}
