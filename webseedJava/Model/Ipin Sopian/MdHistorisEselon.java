package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("historis_eselon")
@CompositePK({"tmtgaji","nip"})
public class MdHistorisEselon extends Model{

}
