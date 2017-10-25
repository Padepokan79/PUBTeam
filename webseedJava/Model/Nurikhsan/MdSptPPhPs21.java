package app.models;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("sptpphps21")
@CompositePK({"TAHUN","NIP"})
public class MdSptPPhPs21 extends Model{
	

}
