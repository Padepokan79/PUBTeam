package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table ("memfile")
@CompositePK({"TAHUN", "KODE"})
public class MdMemfile extends Model {

}
