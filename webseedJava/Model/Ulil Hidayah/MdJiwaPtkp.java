package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("jiwaptkp")
@CompositePK({"NIP","TAHUN"})
public class MdJiwaPtkp extends Model {

}
