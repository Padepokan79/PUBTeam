package app.models;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("otostruk")
@CompositePK({"KDSSBP", "KDSKPD", "KDSATKER"})
public class MdOtoStruk extends Model {

}
