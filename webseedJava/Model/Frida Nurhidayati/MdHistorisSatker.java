package app.models;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("historis_satker")
@CompositePK({"tmtgaji","nip"})
public class MdHistorisSatker extends Model {

}
