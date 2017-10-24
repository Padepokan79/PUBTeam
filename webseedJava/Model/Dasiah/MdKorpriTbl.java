package app.models;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("korpri_tbl")
@CompositePK({"TMT", "KDKORPRI"})
public class MdKorpriTbl extends Model {

}
