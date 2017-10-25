package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("setnomor")
@CompositePK({"tahun","kode"})
public class MdSetNomor extends Model {

}
